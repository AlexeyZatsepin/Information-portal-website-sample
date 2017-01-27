package com.openpolicy.service.impl;

import com.openpolicy.entity.Category;
import com.openpolicy.repository.CategoryRepository;
import com.openpolicy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Category getByID(long id) {
        return repository.findOne(id);
    }

    @Override
    public Category save(Category category) {
        return repository.saveAndFlush(category);
    }

    @Override
    public void remove(long id) {
        repository.delete(id);
    }
}
