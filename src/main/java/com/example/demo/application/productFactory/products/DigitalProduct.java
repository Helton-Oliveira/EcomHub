package com.example.demo.application.productFactory.products;

import com.example.demo.adapter.dto.ICreateOutputDTO;
import com.example.demo.adapter.dto.OutputProductDTO;
import com.example.demo.application.domain.component.Category;
import com.example.demo.application.domain.Product;

import java.util.Map;
import java.util.UUID;

public class DigitalProduct extends Product implements IProduct {

    private String fileSize;
    private String fileFormat;

    private final ICreateOutputDTO createDTO;

    public DigitalProduct(ICreateOutputDTO createDTO) {
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
        this.setActive(true);
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
                this.getCategory(),
                this.getActive());
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
