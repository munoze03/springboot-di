package com.enrique.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enrique.springboot.di.app.springboot_di.models.Product;
import com.enrique.springboot.di.app.springboot_di.repositories.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll(){

        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.21d;
            // Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){

        return repository.findById(id);
    }
}