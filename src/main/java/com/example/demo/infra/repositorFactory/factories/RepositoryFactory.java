package com.example.demo.infra.repositorFactory.factories;

import com.example.demo.application.domain.Product;
import com.example.demo.application.domain.component.Category;
import com.example.demo.infra.repositorFactory.products.IRepository;

public abstract class RepositoryFactory {

    public abstract IRepository createRepository();

    public static RepositoryFactory getRepository(Product product) {
        if(product.getCategory().equals(Category.DIGITAL)) {
            return new DigitalProductFactory();
        }

        if(product.getCategory().equals(Category.PHYSICAL)) {
            return new PhysicalProductFactory();
        }

        return null;
    }
}
