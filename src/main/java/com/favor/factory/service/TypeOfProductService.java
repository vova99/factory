package com.favor.factory.service;


import com.favor.factory.entity.TypeOfProduct;

import java.util.List;

public interface TypeOfProductService {
    TypeOfProduct save(TypeOfProduct type);
    TypeOfProduct update(TypeOfProduct type);
    TypeOfProduct create(String nameType);
    TypeOfProduct findById(int id);
    List<TypeOfProduct> findAll();
    void deleteByID(int id);
}
