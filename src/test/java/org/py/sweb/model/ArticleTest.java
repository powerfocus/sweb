package org.py.sweb.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.CustomValidatorBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTest {
    @Test
    public void validTest() {
        Article article = Article.builder()
                .userGroup("user, admin")
                .title(null)
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
        Validator validatorBean = new LocalValidatorFactoryBean();
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(article, "article");
        validatorBean.validate(article, result);
        if(result.hasErrors()) {
            System.out.println("验证时发生错误！");
            result.getAllErrors().forEach(System.out::println);
        } else {
            System.out.println("验证成功！没有发现验证错误。");
        }
    }
}