package org.py.sweb.controller.index;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.py.sweb.mapper.Sort;
import org.py.sweb.model.Upfiles;
import org.py.sweb.service.UpfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author pythagoras
 * 上传文件控制器
 * 2020.02.15
 * */
@Controller
@RequestMapping("/upload")
@Slf4j
public class UploadController {
    @Autowired
    private UpfileService upfileService;
    /**
     * 分页显示文件列表时使用的每页记录条数，读取配置文件中的自定义设置
     * */
    @Value("${page_limit}")
    private int limit;

    /**
     * 读取图片文件，并以字节码的形式输出给客户端
     * */
    @GetMapping(value = {"img/{id}"}, produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] img(@PathVariable Long id) {
        Assert.notNull(id, "必须指定资源ID！");
        Assert.isTrue(0 <= id, "不支持的资源ID！");
        Upfiles entity = upfileService.selectById(id);
        Assert.notNull(entity, "未找到指定资源！");
        return entity.getContent();
    }

    /**
     * 上传文件下载接口
     * */
    @GetMapping({"download/{id}"})
    public ResponseEntity fileDownload(HttpServletResponse response, @PathVariable Long id, Model model) {
        Upfiles file = upfileService.selectById(id);
        String filetype = file.getFiletype();
        String extName = "." + filetype.substring(filetype.lastIndexOf("/") + 1);
        ByteArrayResource resource = new ByteArrayResource(file.getContent());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName=" + file.getTitle() + extName);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .headers(headers)
                .body(resource);
    }

    @GetMapping({""})
    public String form() {
        return "index/upload/form";
    }

    /**
     * 处理上传文件操作
     * */
    @PostMapping({""})
    public String action(@RequestParam("upfs") MultipartFile[] files, String author,
                         Model model) throws IOException {
        List<MultipartFile> tlist = Arrays.stream(files).filter(f -> !f.isEmpty()).collect(Collectors.toList());
        if(tlist.size() == 0) {
            model.addAttribute("icon", ":(");
            model.addAttribute("msg", "未选择任何文件，没有文件被保存！");
            model.addAttribute("href", "/upload");
            model.addAttribute("icon", ":(");
            return "msg";
        }
        try {
            for(MultipartFile f : files) {
                if (!f.isEmpty()) {
                    byte[] bytes = f.getBytes();
                    String contentType = f.getContentType();
                    String originalName = f.getOriginalFilename();
                    String extName = originalName.substring(originalName.lastIndexOf("."));
                    String fileName = DigestUtils.md5DigestAsHex(LocalDateTime.now().toString().getBytes()) + UUID.randomUUID().toString().substring(0, 20).replace("-", "");
                    Upfiles entity = Upfiles.builder()
                            .title(fileName)
                            .author(author)
                            .filetype(contentType)
                            .extName(extName)
                            .uploadDatetime(LocalDateTime.now())
                            .content(bytes)
                            .build();
                    int re = upfileService.insert(entity);
                    if (re != 1) {
                        model.addAttribute("icon", ":(");
                        model.addAttribute("msg", fileName + " 文件保存时发生错误！文件未被保存！");
                        model.addAttribute("href", "/");
                        return "msg";
                    }
                }
            }
        } catch(IOException e) {
            model.addAttribute("icon", ":(");
            model.addAttribute("msg", "保存文件时发生错误！文件未被保存！" + e);
            model.addAttribute("href", "/");
            return "msg";
        }
        model.addAttribute("icon", ":)");
        model.addAttribute("msg", "文件上传成功！");
        model.addAttribute("href", "upload/list");
        return "msg";
    }
    /**
     * 上传文件列表展示功能
     * */
    @GetMapping({"list", "list/{offset}"})
    public String list(Model model, @PathVariable(required = false) Integer offset) {
        offset = null == offset ? 1 : offset;
        offset = offset < 1 ? 1 : offset;
        PageHelper.offsetPage((offset - 1) * limit, limit);
        List<Upfiles> list = upfileService.selectEvery(Sort.desc);
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("upfiles", list);
        model.addAttribute("title", "上传文件资源");
        model.addAttribute("format", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        model.addAttribute("pageInfo", pageInfo);
        return "index/upload/list";
    }
    @GetMapping({"del/{id}"})
    public String delete(@PathVariable Long id, Model model) {
        int delete = upfileService.delete(id);
        model.addAttribute("href", "/upload/list");
        if(delete == 1) {
            model.addAttribute("msg", "资源删除成功！");
            model.addAttribute("icon", ":)");
        } else {
            model.addAttribute("msg", "资源删除失败！");
            model.addAttribute("icon", ":(");
        }
        return "msg";
    }
}
