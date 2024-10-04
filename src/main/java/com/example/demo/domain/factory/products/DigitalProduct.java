package com.example.demo.domain.factory.products;

import com.example.demo.domain.Product;
import com.example.demo.domain.component.Category;

import java.util.Optional;
import java.util.UUID;

public class DigitalProduct extends Product implements IProduct {

    private static final DigitalProduct digital = new DigitalProduct();
    private String fileSize;
    private String fileFormat;

    @Override
    public void create(String name, String description, String price, String fileSize, String fileFormat) {
        digital.setId(UUID.randomUUID());
        digital.setName(name);
        digital.setDescription(description);
        digital.setFileSize(fileSize);
        digital.setFileFormat(fileFormat);
        digital.setPrice(price);
        digital.setCategory(Category.DIGITAL);

        System.out.println(digital.getCategory());
    }

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
}
