package com.example.demo.application.useCases.statePattern;

import com.example.demo.application.useCases.IDeleteProduct;
import com.example.demo.infra.repositorFactory.products.IRepository;

import java.util.UUID;

public class DeactivateDigitalProductState implements IProductState {

    private final IDeleteProduct context;
    private final IRepository repository;

    public DeactivateDigitalProductState(IDeleteProduct context, IRepository repository) {
        this.context = context;
        this.repository = repository;
    }

    @Override
    public String transitState() {
        var result = repository.delete(UUID.fromString(context.getProductId()));
        if (!result) throw new RuntimeException("ERRO AO DESATIVAR PRODUTO DIGITAL");
        return "PRODUTO COM ID: " + context.getProductId() + " DESATIVADO COM SUCESSO!";
    }
}
