package com.openpolicy.service.impl;

import com.openpolicy.entity.Article;
import com.openpolicy.entity.Category;
import com.openpolicy.entity.Translation;
import com.openpolicy.repository.ArticleRepository;
import com.openpolicy.repository.TranslationRepository;
import com.openpolicy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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

    @Override
    public Translation save(Translation translation) {
        translation.setCreationStamp(new Date());
        save(translation.getArticle());
        return translationRepository.saveAndFlush(translation);
    }

    @Override
    public Translation getByLang(long articleId, Locale locale) {
        Article article = articleRepository.getOne(articleId);
        return article.getTranslations().parallelStream().filter(a -> a.getLocale().equals(locale)).findAny().get();
    }

    @Override
    public List<Article> getByCategory(Category category) {
        return articleRepository.findAll().parallelStream().filter(article -> article.getCategory().equals(category)).collect(Collectors.toList());
    }
}
