package com.example.demo.application.useCases.chainOfResponsability.chainSteps;

import com.example.demo.application.useCases.chainOfResponsability.baseHandler.StartProductDeactivationHandler;
import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;
import com.example.demo.infra.repositorFactory.products.IRepositoryUpdateMethod;

import java.util.UUID;

public class DecrementPhysicalProductStockHandler extends StartProductDeactivationHandler {

    @Override
    public String updateAvailability(RepositoryFactory repositoryFactory, String id) {
        var repository = (IRepositoryUpdateMethod) repositoryFactory.createRepository("physical");
        var product = repository.getProduct(UUID.fromString(id));

        if (Integer.parseInt(product.get().getAttribute("quantity")) != 0) {
            var result = repository.update(UUID.fromString(product.get().getAttribute("id")), 1);
            if (!result) throw new RuntimeException("ERRO NO HANDLER DE DECREMENTO");
            return "ITEM DECREMENTADO COM SUCESSO";
        }

        this.setNextHandle(new DeactivatePhysicalProductHandler());
        return nextHandle.updateAvailability(repositoryFactory, id);
    }

}
