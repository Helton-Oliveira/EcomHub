package com.example.demo.application.useCases.concreteUseCases;

import com.example.demo.adapter.dto.OutputProductDTO;
import com.example.demo.application.useCases.abstractions.IGetProduct;
import com.example.demo.infra.repositorFactory.factories.IRepositoryFactoryProvider;

import java.util.UUID;

public class GetProduct implements IGetProduct {

    private final IRepositoryFactoryProvider provider;

    public GetProduct(IRepositoryFactoryProvider provider) {
        this.provider = provider;
    }

    @Override
    public OutputProductDTO execute(String id, String category) {

        var factory = provider.getFactory(category);
        var repository = factory.createRepository();
        var product = repository.getProduct(UUID.fromString(id));
        return product.orElse(null);
    }
}
