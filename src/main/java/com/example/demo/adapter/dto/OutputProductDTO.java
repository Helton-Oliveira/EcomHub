package com.example.demo.adapter.dto;

import com.example.demo.application.domain.component.Category;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OutputProductDTO {

    private Map<String, String> attributes = new HashMap<>();

    public OutputProductDTO(UUID id, String name, String description, String fileSize, String fileFormat, Integer price, Category category, Boolean active) {
        this.attributes.put("id", String.valueOf(id));
        this.attributes.put("name", name);
        this.attributes.put("description", description);
        this.attributes.put("fileSize", fileSize);
        this.attributes.put("fileFormat", fileFormat);
        this.attributes.put("priceInCents", String.valueOf(price));
        this.attributes.put("category", String.valueOf(category));
        this.attributes.put("active", String.valueOf(active));
    }

    public OutputProductDTO(UUID id, String name, String description, Integer quantity, Integer price, Category category, Boolean active) {
        this.attributes.put("id", String.valueOf(id));
        this.attributes.put("name", name);
        this.attributes.put("description", description);
        this.attributes.put("quantity", String.valueOf(quantity));
        this.attributes.put("priceInCents", String.valueOf(price));
        this.attributes.put("category", String.valueOf(category));
        this.attributes.put("active", String.valueOf(active));
    }

    public String getAttribute(String attributeName) {
        return this.attributes.get(attributeName);
    }

}
