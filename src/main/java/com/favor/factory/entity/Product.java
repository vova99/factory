package com.favor.factory.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String article;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] img;
    private String imgType;
    private String imgName;

    @ManyToOne
    private TypeOfProduct typeOfProduct;

    @Enumerated(EnumType.STRING)
    private StatusOfEntity statusOfEntity=StatusOfEntity.ACTIVE;
}
