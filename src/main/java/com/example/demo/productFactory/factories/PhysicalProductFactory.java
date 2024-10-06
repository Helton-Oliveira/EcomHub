package com.example.demo.productFactory.factories;

import com.example.demo.productFactory.products.IProduct;
import com.example.demo.productFactory.products.PhysicalProduct;

public class PhysicalProductFactory extends ProductFactory{
    @Override
    public IProduct createProduct() {
        return new PhysicalProduct();
    }
}
