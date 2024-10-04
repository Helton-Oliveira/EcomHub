package com.example.demo.domain.factory;

import com.example.demo.domain.factory.products.IProduct;
import com.example.demo.domain.factory.products.PhysicalProduct;

import java.util.Optional;

public class PhysicalProductFactory implements ProductFactory{
    @Override
    public IProduct createProduct() {
        return new PhysicalProduct();
    }
}
