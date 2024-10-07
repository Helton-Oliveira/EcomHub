package com.example.demo.application.productFactory.factories;

import com.example.demo.application.productFactory.products.IProduct;
import com.example.demo.application.productFactory.products.PhysicalProduct;

public class PhysicalProductFactory extends ProductFactory{
    @Override
    public IProduct createProduct() {
        return new PhysicalProduct();
    }
}
