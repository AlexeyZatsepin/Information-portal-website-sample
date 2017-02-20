package com.openpolicy.controller;

import com.openpolicy.service.ArticleService;
import com.openpolicy.service.CategoryService;
import com.openpolicy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Locale;

@Controller
public class CatalogController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value ={"/","/catalog"})
    public String catalog(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("articles", articleService.getAll());
        return "catalog";
    }

    @GetMapping(value = "/article/{id}")
    public String article(@PathVariable long id, Model model) {
        model.addAttribute("article",articleService.getByLang(id, new Locale("en")));
        return "article";
    }

    @GetMapping(value = "/category/{id}")
    public String category(@PathVariable long id, Model model) {
        model.addAttribute("category", categoryService.getByID(id));
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("articles", articleService.getByCategory(categoryService.getByID(id)));
        return "catalog";
    }

}
