package org.py.sweb.service.impl;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.py.sweb.mapper.ArticleMapper;
import org.py.sweb.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void insert() {
        Article article = Article.builder()
                .album("")
                .artLock(false)
                .author("admin")
                .clicks(1)
                .content("这是一篇测试文章")
                .keyword("测试文章")
                .publishDatetime(LocalDateTime.now())
                .resourceId(1L)
                .smallTitle("测试文章")
                .source("网络")
                .thumbnail("")
                .title("测试文章")
                .userGroup("user, admin")
                .build();
        int insert = articleMapper.insert(article);
        Assertions.assertEquals(1, insert);
    }

    @Test
    public void delete() {
        Article article = articleMapper.selectById(1);
        int delete = articleMapper.delete(article);
        Assertions.assertEquals(1, delete);
    }

    @Test
    public void update() {
        Article article = articleMapper.selectById(1);
        article.setTitle("修改后的文章标题");
        int update = articleMapper.update(article);
        Assertions.assertEquals(1, update);
    }

    @Test
    public void selectAll() {
        articleMapper.selectAll().forEach(System.out::println);
    }

    @Test
    public void selectById() {
        Article article = articleMapper.selectById(1L);
        Assertions.assertNotNull(article);
        Assertions.assertEquals(1, article.getId());
    }
}