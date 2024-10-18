package com.example.demo.application.useCases.concreteUseCases;

import com.example.demo.adapter.dto.OutputProductDTO;
import com.example.demo.application.useCases.abstractions.IGetAllProducts;
import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;

import java.util.List;

public class GetAllProducts implements IGetAllProducts {

    private final RepositoryFactory factory;

    public GetAllProducts(RepositoryFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<OutputProductDTO> execute(String category) {
        var repository = factory.createRepository(category);
        if(repository.getAll().isEmpty()) throw new RuntimeException("ERRO! Consulta mal sucedida!");
        return repository.getAll();
    }
}
