package org.py.sweb.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTest {
    @Autowired
    private Validator validator;
    @Test
    public void validTest() {
        Article article = Article.builder()
                .userGroup("user, admin")
                .thumbnail("")
                .source("网络")
                .smallTitle("")
                .resourceId(1L)
                .publishDatetime(LocalDateTime.now())
                .keyword("")
                .content("hello world.")
                .clicks(1)
                .author("admin")
                .artLock(false)
                .album("")
                .build();
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(article, "article");
        validator.supports(Article.class);
        validator.validate(article, result);
        result.getAllErrors().forEach(System.out::println);
    }
}