package com.example.demo;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.connection.PostgreSQLAdapter;
import com.example.demo.adapter.dto.CreateDTO;
import com.example.demo.adapter.dto.ICreateDTO;
import com.example.demo.application.productFactory.factories.PhysicalProductFactory;
import com.example.demo.application.productFactory.factories.ProductFactory;
import com.example.demo.application.useCases.abstractions.ICreateProduct;
import com.example.demo.application.useCases.chainOfResponsability.baseHandler.IProductHandler;
import com.example.demo.application.useCases.chainOfResponsability.baseHandler.StartProductDeactivationHandler;
import com.example.demo.application.useCases.concreteUseCases.CreateProduct;
import com.example.demo.application.useCases.concreteUseCases.DeactivateProduct;
import com.example.demo.application.useCases.concreteUseCases.GetAllProducts;
import com.example.demo.application.useCases.concreteUseCases.GetProduct;
import com.example.demo.infra.repositorFactory.factories.PhysicalProductRepositoryFactory;
import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PhysicalProductIntegrationTest {

    @Test
    @DisplayName("Deve criar um produto fisico")
    void createPhysicalProduct() {

        Map<String, String> physicalProduct = new HashMap<>();

        physicalProduct.put("name", "Iphone 16");
        physicalProduct.put("description", "Iphone 16, 268GB, 8GB RAM");
        physicalProduct.put("price", "10000,00");
        physicalProduct.put("quantity", "129");

        IConnection connection = new PostgreSQLAdapter();
        ICreateDTO createDTO = new CreateDTO();
        RepositoryFactory repositoryFactory = new PhysicalProductRepositoryFactory(connection, createDTO);
        ProductFactory productFactory = new PhysicalProductFactory(createDTO);
        ICreateProduct createProduct = new CreateProduct(repositoryFactory, productFactory);

        createProduct.execute(physicalProduct);
    }

    @Test
    @DisplayName("deve recuperar um produto fisico")
    void getPhysicalProduct() {

        IConnection connection = new PostgreSQLAdapter();
        ICreateDTO createDTO = new CreateDTO();
        RepositoryFactory repository = new PhysicalProductRepositoryFactory(connection, createDTO);
        var product = new GetProduct(repository);

        var output = product.execute("300ec860-8d7f-403d-8c88-0388812b4ae6", "physical");

        assertThat(output.getAttribute("name")).isEqualTo("Mochila Anti-Furto");
    }

    @Test
    @DisplayName("deve recuperar todos os produtos digitais ativos")
    void getAllActivePhysicalProducts() {

        IConnection connection = new PostgreSQLAdapter();
        ICreateDTO createDTO = new CreateDTO();
        RepositoryFactory repository = new PhysicalProductRepositoryFactory(connection, createDTO);
        var product = new GetAllProducts(repository);

        var output = product.execute("physical");

        assertThat(output).isNotEmpty();
        output.forEach(p -> assertThat(p.getAttribute("active")).isEqualTo("true"));
    }

    @Test
    @DisplayName("deve decrementar 1 na quantidade em estoque do produto")
    void mustPerformLogicalQuantityDeletion() {
        IConnection connection = new PostgreSQLAdapter();
        ICreateDTO createDTO = new CreateDTO();
        RepositoryFactory repository = new PhysicalProductRepositoryFactory(connection, createDTO);
        IProductHandler chain = new StartProductDeactivationHandler();
        var product = new DeactivateProduct(repository, chain);
        var output = product.execute("621e00dd-b57a-47b0-99b8-1b84048a9c0d");

        assertThat(output).isEqualTo("ITEM DECREMENTADO COM SUCESSO");
    }

    @Test
    @DisplayName("deve decrementar inativar produto com quantidade igual a zero")
    void mustPerformLogicalDeletion() {
        IConnection connection = new PostgreSQLAdapter();
        ICreateDTO createDTO = new CreateDTO();
        RepositoryFactory repository = new PhysicalProductRepositoryFactory(connection, createDTO);
        IProductHandler chain = new StartProductDeactivationHandler();
        var product = new DeactivateProduct(repository, chain);
        var output = product.execute("300ec860-8d7f-403d-8c88-0388812b4ae6");

        assertThat(output).isEqualTo("ITEM DE ID: 300ec860-8d7f-403d-8c88-0388812b4ae6 INATIVADO COM SUCESSO");
    }
}
