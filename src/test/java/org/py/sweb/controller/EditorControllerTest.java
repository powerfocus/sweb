package org.py.sweb.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EditorControllerTest {

    @Value("${uploadDir}")
    private String uploadDir;
    @Test
    public void test() throws IOException {
        ClassPathResource root = new ClassPathResource("/");
        Path rootPath = Paths.get(root.getFile().getAbsolutePath()).getParent().resolve("classes").resolve("public").resolve(uploadDir);
        List<Path> list = new ArrayList<>();
        Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getParent().getFileName() + "/" + file.getFileName());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}