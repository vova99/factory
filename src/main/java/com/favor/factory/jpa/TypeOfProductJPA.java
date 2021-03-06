package com.favor.factory.jpa;

import com.favor.factory.entity.TypeOfProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TypeOfProductJPA extends JpaRepository<TypeOfProduct,Integer> {

}
