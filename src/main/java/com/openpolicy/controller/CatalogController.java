package com.openpolicy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CatalogController {

    @RequestMapping(value ={"/","/catalog"}, method = RequestMethod.GET)
    public String catalog(Model model) {
        return "catalog";
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public String article(@PathVariable("id") long id, Model model) {
        return "catalog";
    }
}
