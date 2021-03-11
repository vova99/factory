package com.favor.factory.controller;

import com.favor.factory.entity.TypeOfProduct;
import com.favor.factory.service.TypeOfProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class TypeOfProductController {
    @Autowired
    private TypeOfProductService typeOfProductService;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/categories")
    public String getAll(Model model){
        model.addAttribute("types",typeOfProductService.findAll());
        return "/admin/categories";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addType")
    public String addType(String nameOfType){
        typeOfProductService.create(nameOfType);
        return "redirect:/admin/categories";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/editType")
    public String editType(TypeOfProduct type){
        typeOfProductService.update(type);
        return "redirect:/admin/categories";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/deleteType")
    public String deleteType(int typeId){
        typeOfProductService.deleteByID(typeId);
        return "redirect:/admin/categories";
    }
}
