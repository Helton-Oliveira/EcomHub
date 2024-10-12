package com.example.demo.application.productFactory.factories;

import com.example.demo.application.productFactory.products.IProduct;

import java.util.Map;

public interface ProductFactory {
       IProduct createProduct(Map<String, String> attribute);
}