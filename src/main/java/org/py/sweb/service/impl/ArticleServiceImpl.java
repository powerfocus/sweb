package org.py.sweb.service.impl;

import org.py.sweb.mapper.ArticleMapper;
import org.py.sweb.model.Article;
import org.py.sweb.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int insert(Article entity) {
        return articleMapper.insert(entity);
    }

    @Override
    public int delete(Article entity) {
        return articleMapper.delete(entity);
    }

    @Override
    public int update(Article entity) {
        return articleMapper.update(entity);
    }

    @Override
    public List<Article> selectAll() {
        return articleMapper.selectAll();
    }

    @Override
    public Article selectById(long id) {
        return articleMapper.selectById(id);
    }
}
