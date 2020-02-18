package org.py.sweb;

import org.py.sweb.controller.GlobalErrorHandlerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@MapperScan(basePackages = {"org.py.sweb.mapper"})
public class SwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwebApplication.class, args);
    }

    /*@Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        simpleMappingExceptionResolver.setDefaultErrorView("errorView");
        simpleMappingExceptionResolver.setExceptionAttribute("ex");
        return simpleMappingExceptionResolver;
    }*/

}
