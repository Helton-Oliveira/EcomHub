package com.example.demo.DigitalProduct.domain;

import com.example.demo.component.Category;
import com.example.demo.domain.Product;
import com.example.demo.factory.products.IProduct;

import java.util.UUID;

public class DigitalProduct extends Product implements IProduct {

    @Override
    public void create(String name, String description, String price, String fileSize, String fileFormat) {
        this.setId(UUID.randomUUID());
        this.setName(name);
        this.setDescription(description);
        this.setFileSize(fileSize);
        this.setFileFormat(fileFormat);
        this.setPrice(price);
        this.setCategory(Category.DIGITAL);
    }

    @Override
    public Product get() {
        return this;
    }

}
