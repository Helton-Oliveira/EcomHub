package com.example.demo.application.productFactory.factories;

import com.example.demo.adapter.dto.ICreateDTO;
import com.example.demo.application.productFactory.products.IProduct;
import com.example.demo.application.productFactory.products.PhysicalProduct;

import java.util.Map;

public class PhysicalProductFactory implements ProductFactory{

    private final ICreateDTO createDTO;

    public PhysicalProductFactory(ICreateDTO createDTO) {
        this.createDTO = createDTO;
    }

    @Override
    public IProduct createProduct(Map<String, String> attribute) {
         if(attribute.containsKey("quantity")) {
            return new PhysicalProduct(createDTO);
        }
         return null;
    }
}
