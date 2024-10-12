package com.example.demo.infra.repositorFactory.factories;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.dto.ICreateDTO;
import com.example.demo.application.domain.component.Category;
import com.example.demo.infra.repositorFactory.products.IRepository;
import com.example.demo.infra.repositorFactory.products.PhysicalProductDatabase;

public class PhysicalProductRepositoryFactory implements RepositoryFactory {

    private final IConnection connection;
    private final ICreateDTO createDTO;

    public PhysicalProductRepositoryFactory(IConnection connection, ICreateDTO createDTO) {
        this.connection = connection;
        this.createDTO = createDTO;
    }
    @Override
    public IRepository createRepository(String category) {
        if(category.equalsIgnoreCase(Category.PHYSICAL.name())) {
            return new PhysicalProductDatabase(connection, createDTO);
        }
        return null;
    }
}
