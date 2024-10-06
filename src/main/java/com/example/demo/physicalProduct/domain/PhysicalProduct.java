package com.example.demo.physicalProduct.domain;

import com.example.demo.component.Category;
import com.example.demo.domain.Product;
import com.example.demo.factory.products.IProduct;

import java.util.UUID;

public class PhysicalProduct extends Product implements IProduct {

    private Integer stock; 

    @Override
    public void create(String name, String description, String price, String fileSize, String fileFormat) {
        this.setId(UUID.randomUUID());
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setCategory(Category.PHYSICAL);
    }

    public void create(String name, String description, String price, Integer stock) {
        this.setId(UUID.randomUUID());
        this.setName(name);
        this.setDescription(description);
        this.setStock(stock);
        this.setPrice(price);
        this.setCategory(Category.PHYSICAL);
    }

    @Override
    public Product get() {
        return this;
    }

    private void setStock(Integer stock) {
        this.stock = stock;
    }
}
