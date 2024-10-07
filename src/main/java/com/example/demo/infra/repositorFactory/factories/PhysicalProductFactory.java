package com.example.demo.infra.repositorFactory.factories;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.connection.PostgreSQLAdapter;
import com.example.demo.infra.repositorFactory.products.IRepository;
import com.example.demo.infra.repositorFactory.products.PhysicalProductDatabase;

public class PhysicalProductFactory extends RepositoryFactory {
    @Override
    public IRepository createRepository() {
        IConnection connection = new PostgreSQLAdapter();
        return new PhysicalProductDatabase(connection);
    }
}
