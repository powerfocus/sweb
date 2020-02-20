package org.py.sweb.service;

import org.py.sweb.model.Article;

public interface ArticleService extends BaseService<Article> {
    Article selectById(long id);
}
