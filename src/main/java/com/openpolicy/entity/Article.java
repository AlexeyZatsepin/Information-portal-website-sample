package com.openpolicy.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Article")
public class Article {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "article")
    private Set<Translation> translations;

    public Article() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<Translation> translations) {
        this.translations = translations;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", category=" + category +
                ", translations=" + translations +
                '}';
    }
}
