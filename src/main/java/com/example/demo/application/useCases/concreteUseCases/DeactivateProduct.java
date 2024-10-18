package com.example.demo.application.useCases.concreteUseCases;

import com.example.demo.application.useCases.abstractions.IDeactivateProduct;
import com.example.demo.application.useCases.chainOfResponsability.baseHandler.IProductHandler;
import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;

public class DeactivateProduct implements IDeactivateProduct {

    private final RepositoryFactory repositoryFactory;
    private final IProductHandler chain;

    public DeactivateProduct(RepositoryFactory repositoryFactory, IProductHandler chain) {
        this.repositoryFactory = repositoryFactory;
        this.chain = chain;
    }

    @Override
    public String execute(String id) {
        return chain.updateAvailability(repositoryFactory, id);
    }
}
