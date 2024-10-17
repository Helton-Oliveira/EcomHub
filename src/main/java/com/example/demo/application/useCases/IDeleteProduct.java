package com.example.demo.application.useCases;

import com.example.demo.application.useCases.statePattern.IProductState;

public interface IDeleteProduct {
    String execute();
    String getProductId();
    void setState(IProductState state);
}
