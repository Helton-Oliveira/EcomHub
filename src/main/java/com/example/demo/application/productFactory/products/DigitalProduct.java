package com.example.demo.application.productFactory.products;

import com.example.demo.application.domain.component.Category;
import com.example.demo.application.domain.Product;

import java.util.Map;
import java.util.UUID;

public class DigitalProduct extends Product implements IProduct {

    @Override
    public void create(Map<String, String> attributes) {
        this.setId(UUID.randomUUID());
        this.setName(attributes.get("name"));
        this.setDescription(attributes.get("description"));
        this.setFileSize(attributes.get("fileSize"));
        this.setFileFormat(attributes.get("fileFormat"));
        this.setPriceInCents(attributes.get("price"));
        this.setCategory(Category.DIGITAL);
    }

    @Override
    public Product get() {
        return this;
    }

}
