package com.favor.factory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "client/index";
    }

    @GetMapping("/contacts")
    public String contacts(){
        return "client/contacts";
    }

    @GetMapping("/collaboration")
    public String collaboration(){
        return "client/collaboration";
    }
}
