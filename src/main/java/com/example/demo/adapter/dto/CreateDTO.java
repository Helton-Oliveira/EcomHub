package com.example.demo.adapter.dto;

import com.example.demo.application.domain.component.Category;

import java.util.UUID;

public class CreateDTO implements ICreateDTO{

    @Override
    public OutputProductDTO createOutputDigitalProductDto(UUID id, String name, String description, String fileSize, String fileFormat, Integer price, Category category) {
        return new OutputProductDTO(id, name, description, fileSize, fileFormat, price, category);
    }

    @Override
    public OutputProductDTO createOutputPhysicalProductDto(UUID id, String name, String description, Integer quantity, Integer price, Category category) {
        return new OutputProductDTO(id, name, description, quantity, price, category);
    }
}
