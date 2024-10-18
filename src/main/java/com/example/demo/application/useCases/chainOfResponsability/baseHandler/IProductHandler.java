package com.example.demo.application.useCases.chainOfResponsability.baseHandler;

import com.example.demo.infra.repositorFactory.factories.IRepositoryFactoryProvider;

public interface IProductHandler {
    String updateAvailability(IRepositoryFactoryProvider repository, String id);
    void setNextHandle(IProductHandler nextHandle);
}
