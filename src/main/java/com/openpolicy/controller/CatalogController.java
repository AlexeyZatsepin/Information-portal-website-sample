package com.openpolicy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CatalogController {

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String registration(Model model) {
        return "catalog";
    }
}
