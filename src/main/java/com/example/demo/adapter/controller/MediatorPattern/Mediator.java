package com.example.demo.adapter.controller.MediatorPattern;

import com.example.demo.application.useCases.abstractions.ICreateProduct;
import com.example.demo.application.useCases.abstractions.IDeactivateProduct;
import com.example.demo.application.useCases.abstractions.IGetAllProducts;
import com.example.demo.application.useCases.abstractions.IGetProduct;

import java.util.Map;

public class Mediator implements IMediator {

    private final IGetProduct getProduct;
    private final IGetAllProducts getAllProduct;
    private final ICreateProduct createProduct;
    private final IDeactivateProduct deactivateProduct;

    public Mediator(IGetProduct getProduct, IGetAllProducts getAllProduct, ICreateProduct createProduct, IDeactivateProduct deactivateProduct) {
        this.getProduct = getProduct;
        this.getAllProduct = getAllProduct;
        this.createProduct = createProduct;
        this.deactivateProduct = deactivateProduct;
    }

    @Override
    public <T> T execute(Map<String, String> stringMap, String reqName) {

        if (reqName.equalsIgnoreCase("get") && stringMap.containsKey("id") && stringMap.containsKey("category")) {
            return (T) getProduct.execute(stringMap.get("id"), stringMap.get("category"));
        }

        if (reqName.equalsIgnoreCase("get") && stringMap.containsKey("category")) {
            return (T) getAllProduct.execute(stringMap.get("category"));
        }

        if (reqName.equalsIgnoreCase("post") && !stringMap.isEmpty()) {
            createProduct.execute(stringMap);
            return (T) "Sucess";
        }

        if (reqName.equalsIgnoreCase("put") && stringMap.containsKey("id")) {
            return (T) deactivateProduct.execute(stringMap.get("id"));
        }

        throw new RuntimeException("ERRO NA REQUISIÇÃO");
    }
}
