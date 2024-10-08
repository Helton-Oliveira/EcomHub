package com.example.demo;

import com.example.demo.application.domain.component.Category;
import com.example.demo.application.productFactory.factories.ProductFactory;
import com.example.demo.application.useCases.CreateProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    @Test
    @DisplayName("Deve criar um produto digital")
    void createProductDigital() {

        Map<String, String> digitalProduct = new HashMap<>();

        digitalProduct.put("name", "Design Patterns");
        digitalProduct.put("description", "ebook sobre padroes de projeto");
        digitalProduct.put("price", "69,90");
        digitalProduct.put("fileSize", "130KB");
        digitalProduct.put("fileFormat", "ePUB, PDF");

        var factory =  ProductFactory.getFactory(digitalProduct);
        var product = factory.createProduct();
        product.create(digitalProduct);

       var instance = product.get();

        System.out.println(instance.getAttribute("category"));

       assertThat(instance.getAttribute("name")).isEqualTo("Design Patterns");
       assertThat(instance.getAttribute("category")).isEqualTo(Category.DIGITAL.name());
    }

    @Test
    @DisplayName("Deve criar um produto fisico")
    void createProductPhysical() {

        Map<String, String> physicalProduct = new HashMap<>();

        physicalProduct.put("name", "Design Patterns");
        physicalProduct.put("description", "livro do Gof");
        physicalProduct.put("price", "290,00");
        physicalProduct.put("quantity", "100");

        var factory =  ProductFactory.getFactory(physicalProduct);
        var product = factory.createProduct();
        product.create(physicalProduct);

        var instance = product.get();

        assertThat(instance.getAttribute("id")).isNotNull();
        assertThat(instance.getAttribute("name")).isEqualTo("Design Patterns");
        assertThat(instance.getAttribute("category")).isEqualTo(Category.PHYSICAL.name());
    }

    @Test
    @DisplayName("Deve criar um produto digital no database")
    void createProductDigitalOnDatabase() {

        Map<String, String> digitalProduct = new HashMap<>();

        digitalProduct.put("name", "O mundo de sofia");
        digitalProduct.put("description", "livro sobre filosofia");
        digitalProduct.put("price", "80,00");
        digitalProduct.put("fileSize", "100KB");
        digitalProduct.put("fileFormat", "ePUB, PDF");

        var create = new CreateProduct();
        create.execute(digitalProduct);
    }

}
