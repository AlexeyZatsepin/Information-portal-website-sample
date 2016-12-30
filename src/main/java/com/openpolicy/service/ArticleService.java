package com.openpolicy.service;

import com.openpolicy.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAll();
    Article getByID(long id);
    Article save(Article article);
    void remove(long id);
}