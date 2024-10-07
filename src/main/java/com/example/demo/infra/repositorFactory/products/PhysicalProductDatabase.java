package com.example.demo.infra.repositorFactory.products;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.application.domain.Product;

public class PhysicalProductDatabase implements IRepository{

    private final IConnection connection;

    public PhysicalProductDatabase(IConnection connection) {
        this.connection = connection;
    }

    @Override
    public Boolean save(Product product) {
        return true;
    }

    @Override
    public Product getProduct() {
        return null;
    }
}
