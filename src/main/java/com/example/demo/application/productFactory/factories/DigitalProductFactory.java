package com.example.demo.application.productFactory.factories;

import com.example.demo.adapter.dto.ICreateDTO;
import com.example.demo.application.productFactory.products.DigitalProduct;
import com.example.demo.application.productFactory.products.IProduct;

import java.util.Map;

public class DigitalProductFactory implements ProductFactory{

    private final ICreateDTO createDTO;

    public DigitalProductFactory(ICreateDTO createDTO) {
        this.createDTO = createDTO;
    }

    @Override
    public IProduct createProduct(Map<String, String> attribute) {
        if (attribute.containsKey("fileFormat") && attribute.containsKey("fileSize")) {
            return new DigitalProduct(createDTO);
        }
        return null;
    }
}
