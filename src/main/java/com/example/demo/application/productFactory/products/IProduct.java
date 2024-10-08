package com.example.demo.application.productFactory.products;

import com.example.demo.adapter.dto.OutputProductDTO;

import java.util.Map;

public interface IProduct {
    void create(Map<String, String> attributes);
    OutputProductDTO get();
}
