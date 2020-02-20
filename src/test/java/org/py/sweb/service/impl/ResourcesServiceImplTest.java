package org.py.sweb.service.impl;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.py.sweb.model.Resources;
import org.py.sweb.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourcesServiceImplTest {
    @Autowired
    private ResourcesService resService;
    @Test
    public void test() {
        Assertions.assertNotNull(resService);
    }
    @Test
    public void insert() {
        Resources res = Resources.builder()
                .resName("测试资源")
                .source("网络")
                .belongId(1L)
                .content("hello world.".getBytes())
                .build();
        int insert = resService.insert(res);
        Assertions.assertEquals(1, insert);
    }

    @Test
    public void delete() {
        Resources res = resService.selectById(1);
        int delete = resService.delete(res);
        Assertions.assertEquals(1, delete);
    }

    @Test
    public void update() {
        Resources res = resService.selectById(1);
        res.setResName("修改后的资源名");
        int update = resService.update(res);
        Assertions.assertEquals(1, update);
    }

    @Test
    public void selectByIdTest() {
        Resources res = resService.selectById(1);
        Assertions.assertNotNull(res);
        Assertions.assertEquals(1, res.getId());
    }

    @Test
    public void selectAll() {
        List<Resources> list = resService.selectAll();
        Assertions.assertTrue(list.size() > 0);
    }
}