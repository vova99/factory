package com.favor.factory.controller;

import com.favor.factory.viber.ViberListenerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MainController {

    private ViberListenerService viberListenerService;

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

    @PostMapping("/contacts")
    public String getContact(String name, String phone, String description){
        viberListenerService.sendForAll(name,phone,description);
        return "redirect:/";
    }

    @GetMapping("/collaboration")
    public String collaboration(Model model){
        model.addAttribute("activeLink","collaboration");
        return "client/collaboration";
    }
}
