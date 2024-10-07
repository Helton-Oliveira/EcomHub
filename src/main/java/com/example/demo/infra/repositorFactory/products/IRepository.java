package com.example.demo.infra.repositorFactory.products;

import com.example.demo.application.domain.Product;

public interface IRepository {
    Boolean save(Product product);
    Product getProduct();
}