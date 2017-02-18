package com.openpolicy.controller;

import com.openpolicy.repository.ArticleRepository;
import com.openpolicy.repository.CategoryRepository;
import com.openpolicy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CatalogController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value ={"/","/catalog"}, method = RequestMethod.GET)
    public String catalog(Model model) {
        return "catalog";
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public String article(@PathVariable("id") long id, Model model) {
        return "catalog";
    }

}
