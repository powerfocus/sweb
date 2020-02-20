package org.py.sweb.service.impl;

import org.py.sweb.mapper.ResourcesMapper;
import org.py.sweb.model.Resources;
import org.py.sweb.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourcesServiceImpl implements ResourcesService {
    @Autowired
    private ResourcesMapper resMapper;
    @Override
    public int insert(Resources entity) {
        return resMapper.insert(entity);
    }

    @Override
    public int delete(Resources entity) {
        return resMapper.delete(entity);
    }

    @Override
    public int update(Resources entity) {
        return resMapper.update(entity);
    }

    @Override
    public List<Resources> selectAll() {
        return resMapper.selectAll();
    }

    @Override
    public Resources selectById(long id) {
        return resMapper.selectById(id);
    }
}
