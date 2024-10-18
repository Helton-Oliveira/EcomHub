package com.example.demo.application.useCases.chainOfResponsability.baseHandler;

import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;

public interface IProductHandler {
    String updateAvailability(RepositoryFactory repository, String id);
    void setNextHandle(IProductHandler nextHandle);
}
