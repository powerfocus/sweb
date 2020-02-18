package org.py.sweb.service;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.py.sweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@SpringBootTest
@Transactional
@Rollback(true)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void test() {
        TestCase.assertNotNull(userService);
    }
    @Test
    void insert() {
        User user = User.builder()
                .username("张三")
                .pwd(DigestUtils.md5DigestAsHex("123".getBytes()))
                .build();
        int insert = userService.insert(user);
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
        User user = userService.selectById(1);
        user.setUsername("李四");
        int re = userService.update(user);
        TestCase.assertEquals(1, re);
        user.setUsername("王五");
        int re2 = userService.update(user);
        TestCase.assertEquals(1, re);
    }

    @Test
    void selectAll() {
    }

    @Test
    void selectById() {
        User user = userService.selectById(1);
        System.out.println(user);
    }
}