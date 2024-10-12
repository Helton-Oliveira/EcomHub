package com.example.demo.infra.repositorFactory.factories;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.dto.ICreateDTO;
import com.example.demo.application.domain.component.Category;
import com.example.demo.infra.repositorFactory.products.DigitalProductDatabase;
import com.example.demo.infra.repositorFactory.products.IRepository;

public class DigitalProductRepositoryFactory implements RepositoryFactory{

    private final IConnection connection;
    private final ICreateDTO createDTO;

    public DigitalProductRepositoryFactory(IConnection connection, ICreateDTO createDTO) {
        this.connection = connection;
        this.createDTO = createDTO;
    }

    @Override
    public IRepository createRepository(String category) {
        if(category.equalsIgnoreCase(Category.DIGITAL.name())) {
            return new DigitalProductDatabase(connection, createDTO);
        }
        return null;
    }
}
