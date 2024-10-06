package com.example.demo.physicalProduct.physicalFactory;

import com.example.demo.factory.ProductFactory;
import com.example.demo.factory.products.IProduct;
import com.example.demo.physicalProduct.domain.PhysicalProduct;

public class PhysicalProductFactory extends ProductFactory{
    @Override
    public IProduct createProduct() {
        return new PhysicalProduct();
    }
}
