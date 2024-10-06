package com.example.demo.productFactory.products;

import com.example.demo.component.Category;
import com.example.demo.application.domain.Product;

import java.util.Map;
import java.util.UUID;

public class PhysicalProduct extends Product implements IProduct {

    private Integer quantity;

    @Override
    public void create(Map<String, String> attributes) {
        this.setId(UUID.randomUUID());
        this.setName(attributes.get("name"));
        this.setDescription(attributes.get("description"));
        this.setPrice(attributes.get("price"));
        this.setQuantity(Integer.parseInt(attributes.get("quantity")));
        this.setCategory(Category.PHYSICAL);
    }

    @Override
    public Product get() {
        return this;
    }

    private void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
