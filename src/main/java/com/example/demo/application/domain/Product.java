package com.example.demo.application.domain;

import com.example.demo.component.Category;

import java.util.UUID;

public abstract class Product {
    private UUID id;
    private String name;
    private Integer priceInCents;
    private String description;
    private String fileSize;
    private String fileFormat;
    private Category category;

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

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
        this.priceInCents = Integer.parseInt(priceInCents.replace(",", "")) * 100;
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
