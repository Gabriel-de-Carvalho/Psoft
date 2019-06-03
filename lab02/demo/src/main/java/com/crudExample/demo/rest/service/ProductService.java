package com.crudExample.demo.rest.service;

import com.crudExample.demo.exception.ProductNotFoundException;
import com.crudExample.demo.rest.dao.ProductDao;
import com.crudExample.demo.rest.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductDao productDao;

    ProductService(ProductDao productDao){
        this.productDao = productDao;
    }

    public Product create(Product product){
        return productDao.save(product);
    }

    public Product update(Product productToUpdate) throws ProductNotFoundException{

        Product product = productDao.findById(productToUpdate.getId());
        if(product == null){
            throw new ProductNotFoundException("could no update, product doesn't exist");
        }

        return productDao.save(productToUpdate);
    }

    public void delete(long id){
        productDao.deleteById(id);
    }

    public Product findById(long id){
        return productDao.findById(id);
    }
}
