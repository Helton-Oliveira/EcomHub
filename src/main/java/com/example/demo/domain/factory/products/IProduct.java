package com.example.demo.domain.factory.products;

import com.example.demo.domain.Product;

public interface IProduct {
    void create(String name, String description, String price, String fileSize, String fileFormat);
    Product get();
}
