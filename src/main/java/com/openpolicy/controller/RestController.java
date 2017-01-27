package com.openpolicy.controller;

import com.openpolicy.entity.Article;
import com.openpolicy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private ArticleService service;

    @RequestMapping(value = "/articles/", method = RequestMethod.GET)
    @ResponseBody
    public List<Article> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Article get(@PathVariable("id") long remindID) {
        return service.getByID(remindID);
    }

    @RequestMapping(value = "/article/add", method = RequestMethod.POST)
    @ResponseBody
    public Article save(@RequestBody Article remind) {
        return service.save(remind);
    }

    @RequestMapping(value = "/article/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        service.remove(id);
    }
}
