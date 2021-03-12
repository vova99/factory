package com.favor.factory.controller;

import com.favor.factory.service.ProductService;
import com.favor.factory.service.TypeOfProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
@AllArgsConstructor
public class ShopController {

    private TypeOfProductService typeOfProductService;
    private ProductService productService;

    @GetMapping
    public String shop(Model model,Integer typeId){
        model.addAttribute("activeLink","shop");
        model.addAttribute("types",typeOfProductService.findAll());
        if(typeId!=null) {
            model.addAttribute("products", productService.findByTypeOfProductId(typeId));
        }
        return "client/shop";
    }

}
