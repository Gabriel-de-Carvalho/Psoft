package com.crudExample.demo.rest.model;

import lombok.Data;
import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;


@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationTYPE.IDENTIFY)
    private long id;

    private String nome;
    private String description;
    private float price;

    public Product(){

    }

    public Product(String name, String description, float price){
        this.nome = nome;
        this.description = description;
        this.price = price;
    }

    public long getId() {
        return id;
    }
}
