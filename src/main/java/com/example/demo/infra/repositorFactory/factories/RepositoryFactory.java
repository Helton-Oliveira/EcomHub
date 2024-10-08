package com.example.demo.infra.repositorFactory.factories;

import com.example.demo.adapter.dto.OutputProductDTO;
import com.example.demo.application.domain.component.Category;
import com.example.demo.infra.repositorFactory.products.IRepository;

public abstract class RepositoryFactory {

    public abstract IRepository createRepository();

    public static RepositoryFactory getRepository(OutputProductDTO product) {
        if(product.getAttribute("category").equals(Category.DIGITAL.name())) {
            return new DigitalProductFactory();
        }

        if(product.getAttribute("category").equals(Category.PHYSICAL.name())) {
            return new PhysicalProductFactory();
        }

        return null;
    }
}
