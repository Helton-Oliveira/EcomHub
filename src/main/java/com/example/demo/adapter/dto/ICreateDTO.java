package com.example.demo.adapter.dto;

import com.example.demo.application.domain.component.Category;

import java.util.UUID;

public interface ICreateDTO {
    OutputProductDTO createOutputDigitalProductDto(UUID id, String name, String description, String fileSize, String fileFormat, Integer price, Category category);
    OutputProductDTO createOutputPhysicalProductDto(UUID id, String name, String description, Integer quantity, Integer price, Category category);
}
