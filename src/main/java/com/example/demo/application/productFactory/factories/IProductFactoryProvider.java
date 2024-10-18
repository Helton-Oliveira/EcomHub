package com.example.demo.application.productFactory.factories;

public interface IProductFactoryProvider {
    ProductFactory getFactory(String category);
}
