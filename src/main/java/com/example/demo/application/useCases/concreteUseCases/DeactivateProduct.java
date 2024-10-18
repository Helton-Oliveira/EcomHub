package com.example.demo.application.useCases.concreteUseCases;

import com.example.demo.application.useCases.abstractions.IDeactivateProduct;
import com.example.demo.application.useCases.chainOfResponsability.baseHandler.IProductHandler;
import com.example.demo.infra.repositorFactory.factories.IRepositoryFactoryProvider;
import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;

public class DeactivateProduct implements IDeactivateProduct {

    private final IRepositoryFactoryProvider repositoryProvider;
    private final IProductHandler chain;

    public DeactivateProduct(IRepositoryFactoryProvider repositoryProvider, IProductHandler chain) {
        this.repositoryProvider = repositoryProvider;
        this.chain = chain;
    }

    @Override
    public String execute(String id) {
        return chain.updateAvailability(repositoryProvider, id);
    }
}
