package com.favor.factory.controller;

import com.favor.factory.entity.Product;
import com.favor.factory.entity.dto.ProductDTO;
import com.favor.factory.service.ProductService;
import com.favor.factory.service.TypeOfProductService;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

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


    @ResponseBody
    @PostMapping
    public JSONObject getFilteredProducts(Integer type, Integer page, Integer size){
        List<Product> products = productService.getFilteredProducts(type,size,page);
        double countOfAllProducts =  productService.getCountOfElements(type,size,page);
        JSONObject object = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for(Product product:products){
            jsonArray.add(ProductDTO.convertToDTO(product));
        }

        object.put("products",jsonArray);
        object.put("countOfAllProducts",countOfAllProducts);
        object.put("pageCount",Math.ceil(countOfAllProducts/ size));
        return object;
    }
}
