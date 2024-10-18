package com.example.demo.application.productFactory.factories;

import com.example.demo.adapter.dto.ICreateOutputDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductFactoryProvider implements IProductFactoryProvider {

    private final Map<String, ProductFactory> factoryMap = new HashMap<>();

    public ProductFactoryProvider(List<ProductFactory> factories, ICreateOutputDTO createOutputDTO) {
        factoryMap.put("digital", new DigitalProductFactory(createOutputDTO));
        factoryMap.put("physical", new PhysicalProductFactory(createOutputDTO));
    }

    @Override
    public ProductFactory getFactory(String category) {
        ProductFactory factory = factoryMap.get(category.toLowerCase());
        if (factory == null) {
            throw new IllegalArgumentException("No factory found for category: " + category);
        }
        return factory;
    }
}
