package com.openpolicy.controller;

import com.openpolicy.entity.Article;
import com.openpolicy.entity.Category;
import com.openpolicy.entity.Translation;
import com.openpolicy.entity.User;
import com.openpolicy.service.ArticleService;
import com.openpolicy.service.CategoryService;
import com.openpolicy.service.UserService;
import com.openpolicy.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("userForm",new User());

        model.addAttribute("languages",new ArrayList<>(Arrays.asList(new String[]{"RU","EN","UA"})));

        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("categoryForm",new Category());

        model.addAttribute("articles", articleService.getAll());

        model.addAttribute("articleForm",new Article());

        model.addAttribute("translationForm",new Translation());

        return "admin";
    }

    @PostMapping(value = "/add/article")
    public String addArticle(@ModelAttribute("articleForm") Article articleForm, Model model) {
//        articleForm.setCategory(category);
        articleService.save(articleForm);
        return "redirect:/admin";
    }

    @PostMapping("/add/user")
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", userService.getAll());

            model.addAttribute("categories", categoryService.getAll());
            model.addAttribute("categoryForm",new Category());

            model.addAttribute("articles", articleService.getAll());
            Article articleForm = new Article();
            Set<Translation> set = new HashSet<>();
            set.add(new Translation());
            set.add(new Translation());
            articleForm.setTranslations(set);
            model.addAttribute("articleForm",articleForm);
            return "admin";
        }
        userService.save(userForm);
        return "redirect:/admin";
    }

    @PostMapping("/add/category")
    public String addCategory(@ModelAttribute("categoryForm") Category categoryForm, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) categoryService.save(categoryForm);
        return "redirect:/admin";
    }

    @PostMapping("/add/translation")
    public String addTranslation(@ModelAttribute("translationForm") Translation translationForm, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            articleService.save(translationForm);
        }
        return "redirect:/admin";
    }

}
