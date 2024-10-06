package com.example.demo.productFactory.products;

import com.example.demo.application.domain.Product;

import java.util.Map;

public interface IProduct {
    void create(Map<String, String> attributes);
    Product get();
}
