package com.favor.factory.serviceImpl;

import com.favor.factory.entity.Product;
import com.favor.factory.entity.StatusOfEntity;
import com.favor.factory.entity.TypeOfProduct;
import com.favor.factory.jpa.ProductJPA;
import com.favor.factory.service.ProductService;
import com.favor.factory.service.TypeOfProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductJPA productJPA;
    private final TypeOfProductService typeOfProductService;


    @Override
    public Product save(Product product) {
        return productJPA.save(product);
    }

    @Override
    public Product save(Product product, MultipartFile multipartFile) {
        if(multipartFile!=null && product!=null){
            try {
                product.setSeason(product.getSeason().replace(",",""));
                product.setImg(multipartFile.getBytes());
                product.setImgName(multipartFile.getOriginalFilename());
                product.setImgType(multipartFile.getContentType());
                return productJPA.save(product);
            }
            catch(Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public Product update(Product product, MultipartFile multipartFile) {
        System.out.println(product);
        if(product!=null){
            Product productDB = productJPA.findById(product.getId()).orElse(new Product());

            productDB.setName(product.getName());
            productDB.setSeason(product.getSeason().replace(",",""));
            productDB.setPrice(product.getPrice());
            productDB.setTypeOfProduct(product.getTypeOfProduct());
            System.out.println("Mulipart "+multipartFile.getSize());
            if(multipartFile.getSize()>0){
                try {
                    productDB.setImg(multipartFile.getBytes());
                    productDB.setImgName(multipartFile.getOriginalFilename());
                    productDB.setImgType(multipartFile.getContentType());
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
            return productJPA.save(productDB);
        }
        return null;
    }

    @Override
    public Product findById(long id) {
        return productJPA.findById(id).orElse(null);
    }

    @Override
    public Product changeStatus(long id, boolean status) {
        if(id>0){
            Product product = productJPA.getOne(id);
            if(status){
                product.setStatusOfEntity(StatusOfEntity.ACTIVE);
            }else {
                product.setStatusOfEntity(StatusOfEntity.ARCHIVED);
            }
            return productJPA.save(product);
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return productJPA.findAll();
    }

    @Override
    public List<Product> findByStatus(StatusOfEntity status) {
        return productJPA.findByStatus(status);
    }

    @Override
    public List<Product> findSameProducts(Product product) {
        List<Product> products = productJPA.findFirst10ByTypeOfProductId(product.getTypeOfProduct().getId());
        products.remove(product);
        if(products.size()<5){
        }
        return products;
    }

    @Override
    public void deleteByID(long id) {
        productJPA.deleteById(id);
    }
}
