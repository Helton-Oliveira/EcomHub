package com.example.demo.application.useCases.concreteUseCases;

import com.example.demo.adapter.dto.OutputProductDTO;
import com.example.demo.application.useCases.abstractions.IGetAllProducts;
import com.example.demo.infra.repositorFactory.factories.IRepositoryFactoryProvider;

import java.util.List;

public class GetAllProducts implements IGetAllProducts {

    private final IRepositoryFactoryProvider provider;

    public GetAllProducts(IRepositoryFactoryProvider provider) {
        this.provider = provider;
    }

    @Override
    public List<OutputProductDTO> execute(String category) {
        var factory = provider.getFactory(category);
        var repository = factory.createRepository();
        if(repository.getAll().isEmpty()) throw new RuntimeException("ERRO! Consulta mal sucedida!");
        return repository.getAll();
    }
}
