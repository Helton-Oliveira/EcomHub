package com.example.demo.application.useCases.concreteUseCases;

import com.example.demo.application.productFactory.factories.IProductFactoryProvider;
import com.example.demo.application.useCases.abstractions.ICreateProduct;
import com.example.demo.infra.repositorFactory.factories.IRepositoryFactoryProvider;

import java.util.Map;

public class CreateProduct implements ICreateProduct {

    private final IRepositoryFactoryProvider repositoryProvider;
    private final IProductFactoryProvider productProvider;

    public CreateProduct(IRepositoryFactoryProvider repositoryProvider, IProductFactoryProvider productProvider) {
        this.repositoryProvider = repositoryProvider;
        this.productProvider = productProvider;
    }

    @Override
    public void execute(Map<String, String> attributes) {
        // switch factory
        var productFactory = productProvider.getFactory(attributes.get("category"));
        var product = productFactory.createFactoryProduct();
        product.create(attributes);

        // switch repository
        var repositoryFactory = repositoryProvider.getFactory(product.get().getAttribute("category"));
        var repository = repositoryFactory.createRepository();
        repository.save(product.get());
    }

}
