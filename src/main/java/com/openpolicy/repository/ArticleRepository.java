package com.openpolicy.repository;

import com.openpolicy.entity.Article;
import com.openpolicy.entity.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

//    @Query("select a from Article a where a.")
//    Article findByLocale(@Param("locale") Translation.Locale locale);
}
