package org.py.sweb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.py.sweb.mapper.Sort;
import org.py.sweb.model.Upfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UpfileServiceImplTest {
    @Autowired
    private UpfileService upfileService;
    @Test
    public void insert() {

    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void selectAll() {
        PageHelper.offsetPage(1, 20);
        List<Upfiles> list = upfileService.selectAll();
        list.forEach(f -> {
            System.out.println(f.getId() + " " + f.getTitle() + " " + f.getFiletype());
        });
    }

    @Test
    public void selectEvery() {
        int index = 1;
        int pageSize = 5;
        PageHelper.offsetPage((index - 1) * pageSize, pageSize);
        List<Upfiles> list = upfileService.selectEvery(Sort.desc);
        PageInfo<Upfiles> pageInfo = new PageInfo<>(list);
        System.out.println("上一页：" + pageInfo.getPrePage());
        System.out.println("下一页：" + pageInfo.getNextPage());
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("每页记录数：" + pageInfo.getPageSize());
        System.out.println("总页数：" + pageInfo.getPages());
        pageInfo.getList().forEach(p -> System.out.println(p.getId() + " " + p.getTitle() + " " + p.getFiletype()));
    }

    @Test
    public void selectById() {
        Upfiles file = upfileService.selectById(11);
        String fileType = file.getFiletype();
        String fileName = file.getTitle();
        String extName = "." + fileType.substring(fileType.lastIndexOf("/") + 1);
        String fullName = fileName + extName;
        System.out.println(fullName);
    }
}