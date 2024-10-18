package com.example.demo.application.productFactory.factories;

import com.example.demo.adapter.dto.ICreateOutputDTO;
import com.example.demo.application.productFactory.products.IProduct;
import com.example.demo.application.productFactory.products.PhysicalProduct;

import java.util.Map;

public class PhysicalProductFactory implements ProductFactory{

    private final ICreateOutputDTO createDTO;

    public PhysicalProductFactory(ICreateOutputDTO createDTO) {
        this.createDTO = createDTO;
    }

    @Override
    public IProduct createFactoryProduct() {
        return new PhysicalProduct(createDTO);
    }
}
