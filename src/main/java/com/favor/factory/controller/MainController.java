package com.favor.factory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("activeLink","index");
        return "client/index";
    }

    @GetMapping("/contacts")
    public String contacts(Model model){
        model.addAttribute("activeLink","contacts");
        return "client/contacts";
    }

    @GetMapping("/collaboration")
    public String collaboration(Model model){
        model.addAttribute("activeLink","collaboration");
        return "client/collaboration";
    }
}
