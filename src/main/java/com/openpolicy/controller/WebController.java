package com.openpolicy.controller;

import com.openpolicy.entity.Article;
import com.openpolicy.entity.Translation;
import com.openpolicy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class WebController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(@RequestParam(value="name", required=false, defaultValue="World") String name, @RequestParam(value="lang", required=false, defaultValue="EN") String lang, Model model) {
        model.addAttribute("name", name);
        String text = articleService.getByID(0).getTranslations().parallelStream().filter(a->a.getLocale()== Locale.forLanguageTag(lang)).toString();
        model.addAttribute("text",text);
        return "index";
    }

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String article(@RequestParam(value="lang", required=false, defaultValue="en") String lang,Model model){
        model.addAttribute("name", articleService.getByID(0));
        return "index";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(@RequestParam(value="lang", required=false, defaultValue="en") String lang,Model model){
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value="lang", required=false, defaultValue="en") String lang,Model model){
        return "login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String error403(@RequestParam(value="lang", required=false, defaultValue="en") String lang,Model model){
        return "403";
    }

}
