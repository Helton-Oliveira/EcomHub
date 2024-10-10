package com.example.demo.infra.repositorFactory.factories;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.connection.PostgreSQLAdapter;
import com.example.demo.adapter.dto.CreateDTO;
import com.example.demo.adapter.dto.ICreateDTO;
import com.example.demo.infra.repositorFactory.products.DigitalProductDatabase;
import com.example.demo.infra.repositorFactory.products.IRepository;

public class DigitalProductFactory extends RepositoryFactory{
    @Override
    public IRepository createRepository() {
        IConnection connection = new PostgreSQLAdapter();
        ICreateDTO createDTO = new CreateDTO();
        return new DigitalProductDatabase(connection, createDTO);
    }
}
