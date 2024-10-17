package com.example.demo.infra.repositorFactory.products;

import java.util.UUID;

public interface IRepositoryUpdateMethod extends IRepository{
    Boolean update(UUID id, Integer quantity);
}
