package com.openpolicy.service;

import com.openpolicy.entity.Article;
import com.openpolicy.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository repository;

    @Override
    public List<Article> getAll() {
        return repository.findAll();
    }

    @Override
    public Article getByID(long id) {
        return repository.findOne(id);
    }

    @Override
    public Article save(Article article) {
        return repository.saveAndFlush(article);
    }

    @Override
    public void remove(long id) {
        repository.delete(id);
    }
}
