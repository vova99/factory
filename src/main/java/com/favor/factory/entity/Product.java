package com.favor.factory.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Product {
    @Id
    private long id;

    private String name;
    private String season;
    private BigDecimal price;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] img;
    private String imgType;
    private String imgName;

    @ManyToOne
    private TypeOfProduct typeOfProduct;

    @Enumerated(EnumType.STRING)
    private StatusOfEntity statusOfEntity;
}
