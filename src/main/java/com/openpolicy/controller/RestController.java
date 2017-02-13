package com.openpolicy.controller;

import com.openpolicy.entity.Article;
import com.openpolicy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    public static final String TAG = "api";

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = TAG+"/articles/", method = RequestMethod.GET)
    @ResponseBody
    public List<Article> getAll() {
        return articleService.getAll();
    }

    @RequestMapping(value = TAG+"/article/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Article get(@PathVariable("id") long id) {
        return articleService.getByID(id);
    }

    @RequestMapping(value = TAG+"/article/add", method = RequestMethod.POST)
    @ResponseBody
    public Article save(@RequestBody Article article) {
        return articleService.save(article);
    }

    @RequestMapping(value = TAG+"/article/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        articleService.remove(id);
    }
}
