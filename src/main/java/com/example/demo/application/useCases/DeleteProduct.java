package com.example.demo.application.useCases;

import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;

import java.util.UUID;

public class DeleteProduct implements IDeleteProduct{

    private final RepositoryFactory repositoryFactory;

    public DeleteProduct(RepositoryFactory repositoryFactory) {
        this.repositoryFactory = repositoryFactory;
    }

    @Override
    public String execute(String id, String category) {

       var repository = repositoryFactory.createRepository(category);
       var result = repository.delete(UUID.fromString(id));

        if(!result) throw new RuntimeException("Id not Found!");

        return "Item de id: " + id + " deletado com sucesso!";
    }
}
