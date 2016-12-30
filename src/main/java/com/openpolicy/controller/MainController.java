package com.openpolicy.controller;

import com.openpolicy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ArticleService service;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String repo(Model model){
        model.addAttribute("name",service.getByID(0).getTitle());
        return "index";
    }
}
