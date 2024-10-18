package com.example.demo.application.useCases.concreteUseCases;

import com.example.demo.application.useCases.abstractions.ICreateProduct;
import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;
import com.example.demo.application.productFactory.factories.ProductFactory;

import java.util.Map;

public class CreateProduct implements ICreateProduct {

    private final RepositoryFactory repositoryFactory;
    private final ProductFactory productFactory;

    public CreateProduct(RepositoryFactory repositoryFactory, ProductFactory productFactory) {
        this.repositoryFactory = repositoryFactory;
        this.productFactory = productFactory;
    }

    @Override
    public void execute(Map<String, String> attributes) {
        // switch factory
        var product = productFactory.createProduct(attributes);
        product.create(attributes);

        // switch repository
        var repository = repositoryFactory.createRepository(product.get().getAttribute("category"));
        repository.save(product.get());
    }



}
