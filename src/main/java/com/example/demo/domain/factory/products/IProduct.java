package com.example.demo.domain.factory.products;

import java.util.Optional;

public interface IProduct {
    void create(String name, String description, String price, String fileSize, String fileFormat);
}
