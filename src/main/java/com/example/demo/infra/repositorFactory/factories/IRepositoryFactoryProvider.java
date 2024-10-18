package com.example.demo.infra.repositorFactory.factories;

public interface IRepositoryFactoryProvider {
    RepositoryFactory getFactory(String category);
}
