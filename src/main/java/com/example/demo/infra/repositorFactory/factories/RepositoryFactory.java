package com.example.demo.infra.repositorFactory.factories;

import com.example.demo.infra.repositorFactory.products.IRepository;

public interface RepositoryFactory {
   IRepository createRepository(String category);
}
