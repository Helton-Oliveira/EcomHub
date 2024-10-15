package com.example.demo.infra.repositorFactory.products;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.dto.ICreateDTO;
import com.example.demo.adapter.dto.OutputProductDTO;

import java.util.List;
import java.util.UUID;

public class PhysicalProductDatabase implements IRepository{

    private final IConnection connection;
    private final ICreateDTO createDTO;

    public PhysicalProductDatabase(IConnection connection, ICreateDTO createDTO) {
        this.connection = connection;
        this.createDTO = createDTO;
    }

    @Override
    public Boolean save(OutputProductDTO product) {
        return true;
    }

    @Override
    public OutputProductDTO getProduct(UUID id) {
        return null;
    }

    @Override
    public List<OutputProductDTO> getAll() {
        return List.of();
    }

    @Override
    public Boolean delete(UUID id) {
        return false;
    }
}
