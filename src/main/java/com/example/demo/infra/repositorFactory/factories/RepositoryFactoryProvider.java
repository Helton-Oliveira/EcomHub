package com.example.demo.infra.repositorFactory.factories;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.dto.ICreateOutputDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryFactoryProvider implements IRepositoryFactoryProvider{

    private final Map<String, RepositoryFactory> factoryMap = new HashMap<>();

    public RepositoryFactoryProvider(List<RepositoryFactory> factories, ICreateOutputDTO createOutputDTO, IConnection connection) {
        factoryMap.put("digital", new DigitalProductRepositoryFactory(connection, createOutputDTO));
        factoryMap.put("physical", new PhysicalProductRepositoryFactory(connection, createOutputDTO));
    }

    @Override
    public RepositoryFactory getFactory(String category) {
        RepositoryFactory factory = factoryMap.get(category.toLowerCase());
        if (factory == null) {
            throw new IllegalArgumentException("No factory found for category: " + category);
        }

        return factory;
    }
}
