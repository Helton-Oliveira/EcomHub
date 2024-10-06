package com.example.demo.productFactory.factories;

import com.example.demo.productFactory.products.DigitalProduct;
import com.example.demo.productFactory.products.IProduct;

public class DigitalProductFactory extends ProductFactory{
    @Override
    public IProduct createProduct() {
        return new DigitalProduct();
    }
}
