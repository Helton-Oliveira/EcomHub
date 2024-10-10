package com.example.demo.infra.repositorFactory.products;

import com.example.demo.adapter.dto.OutputProductDTO;

import java.util.UUID;

public interface IRepository {
    Boolean save(OutputProductDTO product);
    OutputProductDTO getProduct(UUID id);
}