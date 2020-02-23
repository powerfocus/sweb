package org.py.sweb.controller;

import com.baidu.ueditor.ActionEnter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/")
@Log
public class EditorController {

    @Value("${uploadDir}")
    private String uploadDir;

    @GetMapping({"ueditor"})
    public String ueditor(HttpServletRequest request) throws IOException {
        ClassPathResource resource = new ClassPathResource("public");
        String dir = resource.getFile().getAbsolutePath();
        return new ActionEnter(request, dir).exec();
    }

    @PostMapping({"uploadimage"})
    public Map<String, Object> uploadimage(MultipartFile upfile) throws IOException {
        Map<String, Object> result = new HashMap<>();
        ClassPathResource root = new ClassPathResource("public");
        String saveDirName = LocalDate.now().toString();
        Path savePath = Paths.get(
                Paths.get(root.getFile().getAbsolutePath())
                        .toAbsolutePath()
                        .toString(),
                uploadDir,
                saveDirName);
        if (!Files.exists(savePath))
            Files.createDirectories(savePath);
        String originalFilename = upfile.getOriginalFilename();
        Assert.notNull(originalFilename, "无法获得上传文件名！");
        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString().replace("-", "").substring(0, 10).concat(extName);
        Path saveDir = Paths.get(savePath.toAbsolutePath().toString(), fileName);
        Files.write(saveDir, upfile.getBytes());
        result.put("state", "SUCCESS");
        result.put("error", "0");
        result.put("url", "/" + uploadDir + "/" + saveDirName + "/" + fileName);
        return result;
    }

    @GetMapping({"listimage"})
    public Map<String, Object> fileManager() throws IOException {
        Map<String, Object> result = new HashMap<>();
        ClassPathResource root = new ClassPathResource("public/" + uploadDir);
        result.put("state", "SUCCESS");
        List<Map<String, String>> mlist = new ArrayList<>();
        if(root.exists()) {
            Files.walkFileTree(Paths.get(root.getFile().getAbsolutePath()), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if(!Files.isDirectory(file)) {
                        Map<String, String> m = new HashMap<>();
                        String parentDir = file.getParent().toString().replace(File.separator, "/");
                        parentDir = parentDir.substring(parentDir.lastIndexOf(uploadDir));
                        m.put("url", "/" + parentDir + "/" + file.getFileName());
                        mlist.add(m);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        }
        result.put("list", mlist);
        return result;
    }
}
