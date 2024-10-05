package com.example.demo.domain.factory;

import com.example.demo.domain.factory.products.DigitalProduct;
import com.example.demo.domain.factory.products.IProduct;

public class DigitalProductFactory extends ProductFactory{
    @Override
    public IProduct createProduct() {
        return new DigitalProduct();
    }
}
