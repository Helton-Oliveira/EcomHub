package com.example.demo;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.connection.PostgreSQLAdapter;
import com.example.demo.adapter.dto.CreateDTO;
import com.example.demo.adapter.dto.ICreateDTO;
import com.example.demo.application.productFactory.factories.DigitalProductFactory;
import com.example.demo.application.productFactory.factories.ProductFactory;
import com.example.demo.application.useCases.CreateProduct;
import com.example.demo.application.useCases.GetProduct;
import com.example.demo.infra.repositorFactory.factories.DigitalProductRepositoryFactory;
import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    @Test
    @DisplayName("Deve criar um produto digital no database")
    void createProductDigitalOnDatabase() {

        Map<String, String> digitalProduct = new HashMap<>();

        digitalProduct.put("name", "Rapido e Devagar");
        digitalProduct.put("description", "livro sobre psicologia");
        digitalProduct.put("price", "140,00");
        digitalProduct.put("fileSize", "470KB");
        digitalProduct.put("fileFormat", "ePUB, PDF");

        IConnection connection = new PostgreSQLAdapter();
        ICreateDTO createDTO = new CreateDTO();
        RepositoryFactory repository = new DigitalProductRepositoryFactory(connection, createDTO);
        ProductFactory productFactory = new DigitalProductFactory(createDTO);

        var create = new CreateProduct(repository, productFactory);
        create.execute(digitalProduct);
    }

    @Test
    @DisplayName("deve recuperar um produto digital")
    void getDigitalProduct() {

        IConnection connection = new PostgreSQLAdapter();
        ICreateDTO createDTO = new CreateDTO();
        RepositoryFactory repository = new DigitalProductRepositoryFactory(connection, createDTO);
        var product = new GetProduct(repository);

        var output = product.execute("0fb0f619-290d-485c-9dcf-dad15f26fe18", "digital");

        assertThat(output.getAttribute("name")).isEqualTo("Design Patterns");
    }

}
