package com.example.demo.application.useCases;

import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;
import com.example.demo.application.productFactory.factories.ProductFactory;

import java.util.Map;

public class CreateProduct implements ICreateProduct {

    @Override
    public void execute(Map<String, String> attributes) {
        // switch factory
        var factory = ProductFactory.getFactory(attributes);
        var product = factory.createProduct();
        product.create(attributes);

        // switch repository
        var repository = RepositoryFactory.getRepository(product.get())
                .createRepository();
        repository.save(product.get());
    }



}
