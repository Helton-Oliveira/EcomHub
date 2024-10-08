package com.example.demo.application.productFactory.products;

import com.example.demo.adapter.dto.ICreateDTO;
import com.example.demo.adapter.dto.OutputProductDTO;
import com.example.demo.application.domain.component.Category;
import com.example.demo.application.domain.Product;

import java.util.Map;
import java.util.UUID;

public class DigitalProduct extends Product implements IProduct {

    private String fileSize;
    private String fileFormat;

    private final ICreateDTO createDTO;

    public DigitalProduct(ICreateDTO createDTO) {
        this.createDTO = createDTO;
    }

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
    public OutputProductDTO get() {
        return this.createDTO.createOutputDigitalProductDto(
                this.getId(),
                this.getName(),
                this.getDescription(),
                this.getFileSize(),
                this.getFileFormat(),
                this.getPriceInCents(),
                this.getCategory());
    }

    public String getFileSize() {
        return fileSize;
    }

    private void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    private void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }
}
