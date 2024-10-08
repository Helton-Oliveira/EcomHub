package com.example.demo.infra.repositorFactory.products;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.dto.OutputProductDTO;

public class PhysicalProductDatabase implements IRepository{

    private final IConnection connection;

    public PhysicalProductDatabase(IConnection connection) {
        this.connection = connection;
    }

    @Override
    public Boolean save(OutputProductDTO product) {
        return true;
    }

    @Override
    public OutputProductDTO getProduct() {
        return null;
    }
}
