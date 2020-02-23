package org.py.sweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class SwebApplicationTests {
    @Value("${uploadDir}")
    private String uploadDir;

    @Test
    void contextLoads() throws IOException {
        ClassPathResource resource = new ClassPathResource("/");
        System.out.println(resource.getFile().getAbsolutePath());
    }

    @Test
    void pathTest() throws IOException {
        ClassPathResource root = new ClassPathResource("");
        Path savePath = Paths.get(Paths.get(root.getFile().getAbsolutePath()).getParent().toAbsolutePath().toString(),
                uploadDir,
                LocalDate.now().toString());
        if(!Files.exists(savePath))
            Files.createDirectories(savePath);
        String fn = UUID.randomUUID().toString().replace("-", "").substring(0, 10).concat(".txt");
        Path write = Files.write(Paths.get(savePath.toString(), fn), "hello world.".getBytes());
        System.out.println(write.toAbsolutePath() + " 文件写入完成！");
    }

    @Test
    void rootTest() throws IOException {
        ClassPathResource res = new ClassPathResource("public");
        System.out.println(res.getFile().getAbsolutePath());
    }

}
