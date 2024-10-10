package com.example.demo.infra.repositorFactory.factories;

import com.example.demo.adapter.dto.OutputProductDTO;
import com.example.demo.application.domain.component.Category;
import com.example.demo.infra.repositorFactory.products.IRepository;

public abstract class RepositoryFactory {

    public abstract IRepository createRepository();

    public static RepositoryFactory getRepository(String category) {
        if(category.equalsIgnoreCase(Category.DIGITAL.name())) {
            return new DigitalProductFactory();
        }

        if(category.equalsIgnoreCase(Category.PHYSICAL.name())) {
            return new PhysicalProductFactory();
        }

        return null;
    }
}
