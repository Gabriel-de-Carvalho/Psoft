package com.crudExample.demo.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/v1/products"})
public class Controle {
    private ProductService productService;

    Controle(ProductService productService){
        this.productService = productService;
    }
}
