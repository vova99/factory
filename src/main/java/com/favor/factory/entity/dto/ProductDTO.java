package com.favor.factory.entity.dto;


import com.favor.factory.entity.Product;
import lombok.Data;

@Data
public class ProductDTO {
    private long id;
    private String article;
    private String typeOfProduct;

    public static ProductDTO convertToDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setArticle(product.getArticle());
        productDTO.setTypeOfProduct(product.getTypeOfProduct().getName());
        return productDTO;
    }
}
