package com.example.demo.application.domain;

import com.example.demo.application.domain.component.Category;

import java.util.UUID;

public abstract class Product {
    private UUID id;
    private String name;
    private Integer priceInCents;
    private String description;
    private Category category;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(String priceInCents) {
        var doubleValue = Double.parseDouble(priceInCents.trim().replace(",", ".")) * 100;
        this.priceInCents = (int) Math.round(doubleValue);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
