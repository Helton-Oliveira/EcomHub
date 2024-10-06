package com.example.demo.application.useCases;

import com.example.demo.productFactory.factories.ProductFactory;

import java.util.Map;

public class CreateProduct implements ICreateProduct{

    @Override
    public void execute(Map<String, String> attributes) {
        var factory = ProductFactory.getFactory(attributes);
        var product = factory.createProduct();
        product.create(attributes);
    }

}
