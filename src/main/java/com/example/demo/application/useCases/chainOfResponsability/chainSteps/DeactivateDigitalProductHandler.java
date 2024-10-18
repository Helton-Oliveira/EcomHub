package com.example.demo.application.useCases.chainOfResponsability.chainSteps;

import com.example.demo.application.useCases.chainOfResponsability.baseHandler.StartProductDeactivationHandler;
import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;

import java.util.UUID;

public class DeactivateDigitalProductHandler extends StartProductDeactivationHandler {

    @Override
    public String updateAvailability(RepositoryFactory repositoryFactory, String id) {
        var repository = repositoryFactory.createRepository("digital");

        if(repository != null) {
            repository.delete(UUID.fromString(id));
            return "ITEM DE ID: " + id + " DESATIVADO COM SUCESSO!";
        }

        setNextHandle(new DecrementPhysicalProductStockHandler());
        return  nextHandle.updateAvailability(repositoryFactory, id);
    }

}
