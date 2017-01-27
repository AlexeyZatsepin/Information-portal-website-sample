package com.openpolicy.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "Translations")
public class Translation {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "locale", nullable = false)
    private Locale locale;

    @ManyToOne
    @JoinColumn(name="article_id", nullable = false)
    private Article article;

    @Column(name = "article_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationStamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Date getCreationStamp() {
        return creationStamp;
    }

    public void setCreationStamp(Date creationStamp) {
        this.creationStamp = creationStamp;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Translation{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", locale=" + locale +
                ", creationStamp=" + creationStamp +
                '}';
    }
}
