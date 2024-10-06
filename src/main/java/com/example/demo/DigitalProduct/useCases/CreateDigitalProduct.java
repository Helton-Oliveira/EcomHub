package com.example.demo.DigitalProduct.useCases;

import com.example.demo.factory.ProductFactory;

public class CreateDigitalProduct implements ICreateDigitalProduct{

    @Override
    public void execute(String name, String description, String price, String fileFormat, String fileSize) {
        var factory = ProductFactory.getFactory("digital");
        var product = factory.createProduct();
        product.create(name, description, price, fileSize, fileFormat);
    }
}
