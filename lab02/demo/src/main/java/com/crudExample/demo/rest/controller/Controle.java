package com.crudExample.demo.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudExample.demo.exception.ProductNotFoundException;
import com.crudExample.demo.rest.model.Product;
import com.crudExample.demo.rest.service.ProductService;

@RestController
@RequestMapping({"/v1/products"})
public class Controle {
    private ProductService productService;

    Controle(ProductService productService){
        this.productService = productService;
    }
    
    @GetMapping(value = "/{id}")
    	@ResponseBody
    	public ResponseEntity<Product> findById(@PathVariable long id){
    	Product product = productService.findById(id);
    	
    	if(product == null) {
    		throw new ProductNotFoundException("product not found");
    	}
    	
    	return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
    
    @PostMapping(value = "/")
    	@ResponseBody
    	public ResponseEntity<Product> create(@RequestBody Product product){
    	Product newProduct = productService.create(product);
    	
    	if (newProduct == null) {
    		throw new InternalError("Somenthing went wrong");
    	}
    	
    	return new ResponseEntity<Product>(newProduct, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable long id) {
    	try {
    		productService.delete(id);
    		return new ResponseEntity(HttpStatus.OK);
    	} catch (Exception e) {
    		throw new InternalError("Something went wrong");
    	}
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<Product> update(@RequestBody Product product){
    	try {
    		Product update = productService.update(product);
    		return new ResponseEntity<Product>(product, HttpStatus.OK);
    	} catch (Exception e) {
    		throw new InternalError("something went wrong");
    	}
    }
    	
}
