package org.py.sweb.service;

import org.py.sweb.model.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    User selectById(long id);
}
