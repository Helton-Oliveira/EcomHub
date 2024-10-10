package com.example.demo.application.useCases;

import com.example.demo.adapter.dto.OutputProductDTO;
import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;

import java.util.UUID;

public class GetProduct implements IGetProduct{

    @Override
    public OutputProductDTO execute(String id, String category) {
        var factory = RepositoryFactory.getRepository(category);
        var repository = factory.createRepository();

        return repository.getProduct(UUID.fromString(id));
    }
}
