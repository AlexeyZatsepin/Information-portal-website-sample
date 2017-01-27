package com.openpolicy.service;


import com.openpolicy.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getByID(long id);
    Category save(Category article);
    void remove(long id);
}
