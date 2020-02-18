package org.py.sweb.service;

import java.util.List;

public interface BaseService<T> {
    int insert(T entity);
    int delete(T entity);
    int update(T entity);
    List<T> selectAll();
}
