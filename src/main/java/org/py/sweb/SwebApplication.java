package org.py.sweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"org.py.sweb.mapper"})
public class SwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwebApplication.class, args);
    }

}
