package com.example.demo.application.useCases.statePattern;

import com.example.demo.application.useCases.IDeleteProduct;
import com.example.demo.infra.repositorFactory.products.IRepository;

import java.util.UUID;

public class InactivatePhysicalProductState implements IProductState{

    private final IDeleteProduct context;
    private final IRepository repository;

    public InactivatePhysicalProductState(IDeleteProduct context, IRepository repository) {
        this.context = context;
        this.repository = repository;
    }

    @Override
    public String transitState() {
        var product = repository.delete(UUID.fromString(context.getProductId()));
        if(!product) throw new RuntimeException("ERRO AO TORNAR PRODUTO INATIVO");
        return "PRODUTO INATIVADO COM SUCESSO";
    }
}
