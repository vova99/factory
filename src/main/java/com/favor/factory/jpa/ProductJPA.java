package com.favor.factory.jpa;


import com.favor.factory.entity.Product;
import com.favor.factory.entity.StatusOfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJPA extends JpaRepository<Product,Long> {
    @Query("select obj from Product obj where obj.statusOfEntity=?1")
    List<Product> findByStatus(StatusOfEntity status);

    List<Product> findFirst10ByTypeOfProductId(int typeId);

}
