package com.example.demo.application.productFactory.factories;

import com.example.demo.adapter.dto.CreateDTO;
import com.example.demo.application.productFactory.products.DigitalProduct;
import com.example.demo.application.productFactory.products.IProduct;

public class DigitalProductFactory extends ProductFactory{
    @Override
    public IProduct createProduct() {
        return new DigitalProduct(new CreateDTO());
    }
}
