package com.favor.factory.serviceImpl;

import com.favor.factory.entity.TypeOfProduct;
import com.favor.factory.jpa.TypeOfProductJPA;
import com.favor.factory.service.TypeOfProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfProductServiceImpl implements TypeOfProductService {

    private TypeOfProductJPA typeOfProductJPA;

    public TypeOfProductServiceImpl(TypeOfProductJPA typeOfProductJPA) {
        this.typeOfProductJPA = typeOfProductJPA;
    }

    @Override
    public TypeOfProduct save(TypeOfProduct type) {
        return typeOfProductJPA.save(type);
    }

    @Override
    public TypeOfProduct update(TypeOfProduct type) {
        TypeOfProduct typeDB = typeOfProductJPA.getOne(type.getId());
        typeDB.setName(type.getName());
        return save(typeDB);
    }

    @Override
    public TypeOfProduct create(String nameType) {
        if(!nameType.isEmpty()){
            TypeOfProduct typeOfProduct = new TypeOfProduct();
            typeOfProduct.setName(nameType);
            return typeOfProductJPA.save(typeOfProduct);
        }
        return null;
    }

    @Override
    public TypeOfProduct findById(int id) {
        return typeOfProductJPA.getOne(id);
    }

    @Override
    public List<TypeOfProduct> findAll() {
        return typeOfProductJPA.findAll();
    }

    @Override
    public void deleteByID(int id) {
        typeOfProductJPA.deleteById(id);
    }
}
