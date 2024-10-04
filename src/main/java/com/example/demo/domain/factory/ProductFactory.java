package com.example.demo.domain.factory;

import com.example.demo.domain.factory.products.IProduct;

import java.util.Optional;

public interface ProductFactory {
        IProduct createProduct();
}
