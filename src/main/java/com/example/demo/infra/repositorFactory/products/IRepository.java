package com.example.demo.infra.repositorFactory.products;

import com.example.demo.adapter.dto.OutputProductDTO;

public interface IRepository {
    Boolean save(OutputProductDTO product);
    OutputProductDTO getProduct();
}