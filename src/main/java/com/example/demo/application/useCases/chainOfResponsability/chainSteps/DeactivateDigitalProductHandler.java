package com.example.demo.application.useCases.chainOfResponsability.chainSteps;

import com.example.demo.application.useCases.chainOfResponsability.baseHandler.StartProductDeactivationHandler;
import com.example.demo.infra.repositorFactory.factories.IRepositoryFactoryProvider;

import java.util.UUID;

public class DeactivateDigitalProductHandler extends StartProductDeactivationHandler {

    @Override
    public String updateAvailability(IRepositoryFactoryProvider repositoryProvider, String id) {
        var repositoryFactory = repositoryProvider.getFactory("digital");
        var repository = repositoryFactory.createRepository();
        var product = repository.getProduct(UUID.fromString(id));

        if(product != null) {
            repository.delete(UUID.fromString(id));
            return "ITEM DE ID: " + id + " DESATIVADO COM SUCESSO!";
        }

        setNextHandle(new DecrementPhysicalProductStockHandler());
        return  nextHandle.updateAvailability(repositoryProvider, id);
    }

}
