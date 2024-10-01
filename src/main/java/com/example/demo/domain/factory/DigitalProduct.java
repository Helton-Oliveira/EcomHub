package com.example.demo.domain.factory;

import com.example.demo.domain.Product;

public class DigitalProduct implements IProduct {

    private String fileSize;
    private String fileFormat;

    private DigitalProduct(String fileSize, String fileFormat) {
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
    }

    @Override
    public Product crateProduct() {
        return null;
    }
}
