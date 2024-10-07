package com.example.demo.infra.repositorFactory.factories;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.connection.PostgreSQLAdapter;
import com.example.demo.infra.repositorFactory.products.DigitalProductDatabase;
import com.example.demo.infra.repositorFactory.products.IRepository;

public class DigitalProductFactory extends RepositoryFactory{
    @Override
    public IRepository createRepository() {
        IConnection connection = new PostgreSQLAdapter();
        return new DigitalProductDatabase(connection);
    }
}
