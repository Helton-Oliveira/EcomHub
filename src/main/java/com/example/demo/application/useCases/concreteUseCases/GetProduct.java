package com.example.demo.application.useCases.concreteUseCases;

import com.example.demo.adapter.dto.OutputProductDTO;
import com.example.demo.application.useCases.abstractions.IGetProduct;
import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;

import java.util.UUID;

public class GetProduct implements IGetProduct {

    private final RepositoryFactory repositoryFactory;

    public GetProduct(RepositoryFactory repositoryFactory) {
        this.repositoryFactory = repositoryFactory;
    }

    @Override
    public OutputProductDTO execute(String id, String category) {
        var repository = repositoryFactory.createRepository(category);
        return repository.getProduct(UUID.fromString(id)).get();
    }
}
