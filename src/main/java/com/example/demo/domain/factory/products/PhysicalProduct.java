package com.example.demo.domain.factory.products;

import com.example.demo.domain.Product;
import com.example.demo.domain.component.Category;

import java.util.Optional;
import java.util.UUID;

public class PhysicalProduct extends Product implements IProduct {

    private static final PhysicalProduct physicalProduct = new PhysicalProduct();

    @Override
    public void create(String name, String description, String price, String fileSize, String fileFormat) {
        physicalProduct.setId(UUID.randomUUID());
        physicalProduct.setName(name);
        physicalProduct.setDescription(description);
        physicalProduct.setPrice(price);
        physicalProduct.setCategory(Category.PHYSICAL);


    }
}
