package com.example.demo.DigitalProduct.digitalFactory;

import com.example.demo.DigitalProduct.domain.DigitalProduct;
import com.example.demo.factory.ProductFactory;
import com.example.demo.factory.products.IProduct;

public class DigitalProductFactory extends ProductFactory{
    @Override
    public IProduct createProduct() {
        return new DigitalProduct();
    }
}
