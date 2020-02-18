package org.py.sweb.service.impl;

import org.py.sweb.mapper.UserMapper;
import org.py.sweb.model.User;
import org.py.sweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public int insert(User entity) {
        return userMapper.insert(entity);
    }

    public int delete(User entity) {
        return userMapper.delete(entity);
    }

    public int update(User entity) {
        return userMapper.updateByPrimaryKey(entity);
    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User selectById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
