package com.example.demo.useCases;

import com.example.demo.domain.factory.ProductFactory;

public class Creator implements ICreator{

    @Override
    public void execute(String name, String description, String price, String fileFormat, String fileSize) {
        var factory = ProductFactory.getFactory(fileFormat, fileSize);
        var product = factory.createProduct();
        product.create(name, description, price, fileSize, fileFormat);
    }
}
