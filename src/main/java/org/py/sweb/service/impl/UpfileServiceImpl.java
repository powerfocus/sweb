package org.py.sweb.service.impl;

import org.py.sweb.mapper.Sort;
import org.py.sweb.mapper.UpfileMapper;
import org.py.sweb.model.Upfiles;
import org.py.sweb.service.UpfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("upfileServiceImpl")
public class UpfileServiceImpl implements UpfileService {
    @Autowired
    private UpfileMapper upfileMapper;

    @Override
    public int insert(Upfiles entity) {
        return upfileMapper.insert(entity);
    }

    @Override
    public int delete(Upfiles entity) {
        return upfileMapper.delete(entity);
    }

    @Override
    public int update(Upfiles entity) {
        return upfileMapper.update(entity);
    }

    @Override
    public List<Upfiles> selectAll() {
        return upfileMapper.selectAll();
    }

    @Override
    public Upfiles selectById(long id) {
        return upfileMapper.selectById(id);
    }

    @Override
    public List<Upfiles> selectEvery(Sort order) {
        return upfileMapper.selectEvery(order);
    }

    @Override
    public int delete(long id) {
        return upfileMapper.deleteById(id);
    }
}
