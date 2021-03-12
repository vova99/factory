package com.favor.factory.service;

import com.favor.factory.entity.Product;
import com.favor.factory.entity.StatusOfEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product save(Product product, MultipartFile multipartFile);
    Product update(Product product, MultipartFile multipartFile);
    Product findById(long id);
    Product changeStatus(long id, boolean status);
    List<Product> findByTypeOfProductId(int id);
    List<Product> findAll();
    List<Product> findByStatus(StatusOfEntity status);
    List<Product> findSameProducts(Product product);
    void deleteByID(long id);
}
