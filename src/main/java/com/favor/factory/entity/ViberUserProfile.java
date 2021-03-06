package com.favor.factory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViberUserProfile {
    @Id
    private String id;
    private  String country;
    private  String language;
    private  Integer apiVersion;

    private  String name;
    private  String avatar;

    private String chatId;

}
