package com.example.demo.infra.repositorFactory.factories;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.dto.ICreateOutputDTO;
import com.example.demo.application.domain.component.Category;
import com.example.demo.infra.repositorFactory.products.IRepositoryUpdateMethod;
import com.example.demo.infra.repositorFactory.products.PhysicalProductDatabase;

public class PhysicalProductRepositoryFactory implements RepositoryFactory {

    private final IConnection connection;
    private final ICreateOutputDTO createDTO;

    public PhysicalProductRepositoryFactory(IConnection connection, ICreateOutputDTO createDTO) {
        this.connection = connection;
        this.createDTO = createDTO;
    }

    @Override
    public IRepositoryUpdateMethod createRepository() {
        return new PhysicalProductDatabase(connection, createDTO);
    }
}
