package com.example.demo.infra.config;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.connection.PostgreSQLAdapter;
import com.example.demo.adapter.controller.MediatorPattern.Mediator;
import com.example.demo.adapter.dto.CreateOutputDTO;
import com.example.demo.adapter.dto.ICreateOutputDTO;
import com.example.demo.application.productFactory.factories.*;
import com.example.demo.application.useCases.abstractions.ICreateProduct;
import com.example.demo.application.useCases.abstractions.IDeactivateProduct;
import com.example.demo.application.useCases.abstractions.IGetAllProducts;
import com.example.demo.application.useCases.abstractions.IGetProduct;
import com.example.demo.application.useCases.chainOfResponsability.baseHandler.IProductHandler;
import com.example.demo.application.useCases.chainOfResponsability.baseHandler.StartProductDeactivationHandler;
import com.example.demo.application.useCases.chainOfResponsability.chainSteps.DeactivateDigitalProductHandler;
import com.example.demo.application.useCases.chainOfResponsability.chainSteps.DeactivatePhysicalProductHandler;
import com.example.demo.application.useCases.chainOfResponsability.chainSteps.DecrementPhysicalProductStockHandler;
import com.example.demo.application.useCases.concreteUseCases.CreateProduct;
import com.example.demo.application.useCases.concreteUseCases.DeactivateProduct;
import com.example.demo.application.useCases.concreteUseCases.GetAllProducts;
import com.example.demo.application.useCases.concreteUseCases.GetProduct;
import com.example.demo.infra.repositorFactory.factories.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class Config {

    @Bean
    CreateProduct createProduct(IRepositoryFactoryProvider repositoryFactory, IProductFactoryProvider productFactory) {
        return new CreateProduct(repositoryFactory, productFactory);
    }

    @Bean
    DeactivateProduct deactivateProduct(IRepositoryFactoryProvider repositoryFactory, IProductHandler chain) {
        return new DeactivateProduct(repositoryFactory, chain);
    }

    @Bean
    GetAllProducts getAllProducts(IRepositoryFactoryProvider repositoryFactory) {
        return new GetAllProducts(repositoryFactory);
    }

    @Bean
    GetProduct getProduct(IRepositoryFactoryProvider repositoryFactory) {
        return new GetProduct(repositoryFactory);
    }

    @Bean @Primary
    StartProductDeactivationHandler startProductDeactivationHandler() {
        return new StartProductDeactivationHandler();
    }

    @Bean
    DeactivateDigitalProductHandler deactivateDigitalProductHandler() {
        return new DeactivateDigitalProductHandler();
    }

    @Bean
    DeactivatePhysicalProductHandler deactivatePhysicalProductHandler() {
        return new DeactivatePhysicalProductHandler();
    }

    @Bean
    DecrementPhysicalProductStockHandler decrementPhysicalProductStockHandler() {
        return new DecrementPhysicalProductStockHandler();
    }

    @Bean @Primary
    DigitalProductFactory digitalProduct(ICreateOutputDTO dto) {
        return new DigitalProductFactory(dto);
    }

    @Bean
    PhysicalProductFactory physicalProductFactory (ICreateOutputDTO dto) {
        return new PhysicalProductFactory(dto);
    }

    @Bean
    PostgreSQLAdapter postgreSQLAdapter() {
        return new PostgreSQLAdapter();
    }

    @Bean @Primary
    DigitalProductRepositoryFactory digitalProductRepositoryFactory(ICreateOutputDTO dto, IConnection connection) {
        return new DigitalProductRepositoryFactory(connection, dto);
    }

    @Bean
    PhysicalProductRepositoryFactory physicalProductRepositoryFactory(ICreateOutputDTO dto, IConnection connection) {
        return new PhysicalProductRepositoryFactory(connection, dto);
    }

    @Bean
    CreateOutputDTO createOutputDTO() {
        return new CreateOutputDTO();
    }

    @Bean
    Mediator mediator(IGetProduct getProduct, IGetAllProducts getAllProduct, ICreateProduct createProduct, IDeactivateProduct deactivateProduct) {
        return new Mediator(getProduct, getAllProduct, createProduct, deactivateProduct);
    }

    @Bean
    ProductFactoryProvider productFactoryProvider(List<ProductFactory> factories, ICreateOutputDTO createOutputDTO) {
        return new ProductFactoryProvider(factories, createOutputDTO);
    }

    @Bean
    RepositoryFactoryProvider repositoryFactoryProvider(List<RepositoryFactory> factories, ICreateOutputDTO createOutputDTO, IConnection connection) {
        return new RepositoryFactoryProvider(factories, createOutputDTO, connection);
    }
}
