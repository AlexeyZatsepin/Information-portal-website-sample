package com.openpolicy.service.impl;

import com.openpolicy.entity.Article;
import com.openpolicy.entity.Translation;
import com.openpolicy.repository.ArticleRepository;
import com.openpolicy.repository.TranslationRepository;
import com.openpolicy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private TranslationRepository translationRepository;

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article getByID(long id) {
        return articleRepository.findOne(id);
    }

    @Override
    public Article save(Article article) {
        return articleRepository.saveAndFlush(article);
    }

    @Override
    public void remove(long id) {
        articleRepository.delete(id);
    }
}
