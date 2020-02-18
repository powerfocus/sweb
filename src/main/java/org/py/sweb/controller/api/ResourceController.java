package org.py.sweb.controller.api;

import org.py.sweb.model.Upfiles;
import org.py.sweb.service.UpfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class ResourceController {
    @Autowired
    private UpfileService upfileService;

    @GetMapping({"load/{id}"})
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
}
