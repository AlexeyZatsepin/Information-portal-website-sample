package com.openpolicy.service;

import com.openpolicy.entity.Article;
import com.openpolicy.entity.Category;
import com.openpolicy.entity.Translation;

import java.util.List;
import java.util.Locale;

public interface ArticleService {
    List<Article> getAll();
    Article getByID(long id);
    Article save(Article article);
    void remove(long id);
    Translation save(Translation translation);
    Translation getByLang(long articleId, Locale locale);
    List<Article> getByCategory(Category category);
}
