package com.himanshu.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("name","Test");
        return "index";
    }

    @RequestMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("name","From hello");
        return "index";
    }
}