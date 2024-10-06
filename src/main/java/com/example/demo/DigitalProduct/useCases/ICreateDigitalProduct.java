package com.example.demo.DigitalProduct.useCases;

public interface ICreateDigitalProduct {
    void execute(String name, String description, String price, String fileFormat, String fileSize);
}
