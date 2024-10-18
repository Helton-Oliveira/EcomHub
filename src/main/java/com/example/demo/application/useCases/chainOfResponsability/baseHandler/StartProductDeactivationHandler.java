package com.example.demo.application.useCases.chainOfResponsability.baseHandler;

import com.example.demo.application.useCases.chainOfResponsability.chainSteps.DeactivateDigitalProductHandler;
import com.example.demo.infra.repositorFactory.factories.IRepositoryFactoryProvider;

public class StartProductDeactivationHandler implements IProductHandler {

    protected IProductHandler nextHandle;

    @Override
    public String updateAvailability(IRepositoryFactoryProvider repository, String id) {
        this.setNextHandle(new DeactivateDigitalProductHandler());
        return nextHandle.updateAvailability(repository, id);
    }

    @Override
    public void setNextHandle(IProductHandler nextHandle) {
        this.nextHandle = nextHandle;
    }
}
