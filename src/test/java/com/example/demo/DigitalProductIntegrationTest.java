package com.example.demo;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.connection.PostgreSQLAdapter;
import com.example.demo.adapter.dto.CreateOutputDTO;
import com.example.demo.adapter.dto.ICreateOutputDTO;
import com.example.demo.application.productFactory.factories.DigitalProductFactory;
import com.example.demo.application.productFactory.factories.ProductFactory;
import com.example.demo.application.useCases.concreteUseCases.CreateProduct;
import com.example.demo.application.useCases.concreteUseCases.DeactivateProduct;
import com.example.demo.application.useCases.concreteUseCases.GetAllProducts;
import com.example.demo.application.useCases.concreteUseCases.GetProduct;
import com.example.demo.application.useCases.chainOfResponsability.baseHandler.IProductHandler;
import com.example.demo.application.useCases.chainOfResponsability.baseHandler.StartProductDeactivationHandler;
import com.example.demo.infra.repositorFactory.factories.DigitalProductRepositoryFactory;
import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DigitalProductIntegrationTest {
/*

  */
/*  @Test
    @DisplayName("Deve criar um produto digital no database")
    void createProductDigitalOnDatabase() {

        Map<String, String> digitalProduct = new HashMap<>();

        digitalProduct.put("name", "Refactor");
        digitalProduct.put("description", "livro sobre refatoracao");
        digitalProduct.put("price", "200,00");
        digitalProduct.put("fileSize", "2GB");
        digitalProduct.put("fileFormat", "ePUB, PDF");

        IConnection connection = new PostgreSQLAdapter();
        ICreateOutputDTO createDTO = new CreateOutputDTO();
        RepositoryFactory repository = new DigitalProductRepositoryFactory(connection, createDTO);
        ProductFactory productFactory = new DigitalProductFactory(createDTO);

        var create = new CreateProduct(repository, productFactory);
        create.execute(digitalProduct);
    }*//*


    @Test
    @DisplayName("deve recuperar um produto digital")
    void getDigitalProduct() {

        IConnection connection = new PostgreSQLAdapter();
        ICreateOutputDTO createDTO = new CreateOutputDTO();
        RepositoryFactory repository = new DigitalProductRepositoryFactory(connection, createDTO);
        var product = new GetProduct(repository);

        var output = product.execute("0fb0f619-290d-485c-9dcf-dad15f26fe18", "digital");

        assertThat(output.getAttribute("name")).isEqualTo("Design Patterns");
    }


    @Test
    @DisplayName("deve recuperar todos os produtos digitais ativos")
    void getAllActiveDigitalProducts() {

        IConnection connection = new PostgreSQLAdapter();
        ICreateOutputDTO createDTO = new CreateOutputDTO();
        RepositoryFactory repository = new DigitalProductRepositoryFactory(connection, createDTO);
        var product = new GetAllProducts(repository);

        var output = product.execute("digital");

        assertThat(output).isNotEmpty();
        output.forEach(p -> assertThat(p.getAttribute("active")).isEqualTo("true"));
    }

    @Test
    @DisplayName("deve deletar logicamente um produto digital")
    void mustPerformLogicalDeletion() {
        IConnection connection = new PostgreSQLAdapter();
        ICreateOutputDTO createDTO = new CreateOutputDTO();
        RepositoryFactory repository = new DigitalProductRepositoryFactory(connection, createDTO);
        IProductHandler chain = new StartProductDeactivationHandler();
        var delete = new DeactivateProduct(repository, chain);
        var output = delete.execute("0fb0f619-290d-485c-9dcf-dad15f26fe18");

        assertThat(output).isEqualTo("ITEM DE ID: 0fb0f619-290d-485c-9dcf-dad15f26fe18 DESATIVADO COM SUCESSO!");
    }
*/

}
