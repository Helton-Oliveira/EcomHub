package com.example.demo.application.productFactory.factories;

import com.example.demo.adapter.dto.ICreateOutputDTO;
import com.example.demo.application.productFactory.products.DigitalProduct;
import com.example.demo.application.productFactory.products.IProduct;

import java.util.Map;

public class DigitalProductFactory implements ProductFactory{

    private final ICreateOutputDTO createDTO;

    public DigitalProductFactory(ICreateOutputDTO createDTO) {
        this.createDTO = createDTO;
    }

    @Override
    public IProduct createFactoryProduct() {
        return new DigitalProduct(createDTO);
    }
}
