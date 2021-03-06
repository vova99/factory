package com.favor.factory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class OrderInfo {
    @Id
    private UUID id;

    private String name;
    private String phone;
}
