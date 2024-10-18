package com.example.demo.application.useCases.chainOfResponsability.chainSteps;

import com.example.demo.application.useCases.chainOfResponsability.baseHandler.StartProductDeactivationHandler;
import com.example.demo.infra.repositorFactory.factories.IRepositoryFactoryProvider;
import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;

import java.util.UUID;

public class DeactivatePhysicalProductHandler extends StartProductDeactivationHandler {

    @Override
    public String updateAvailability(IRepositoryFactoryProvider repositoryProvider, String id) {
        var repositoryFactory = repositoryProvider.getFactory("physical");
        var repository = repositoryFactory.createRepository();
        var product = repository.getProduct(UUID.fromString(id));

        repository.delete(UUID.fromString(product.get().getAttribute("id")));
        return "ITEM DE ID: " + id + " INATIVADO COM SUCESSO";
    }
}
