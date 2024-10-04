package com.example.demo;

import com.example.demo.domain.factory.DigitalProductFactory;
import com.example.demo.domain.factory.PhysicalProductFactory;
import com.example.demo.domain.factory.ProductFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    @DisplayName("Deve criar um produto")
    void createProduct() {
        var product = new DigitalProductFactory().createProduct();;
        product.create("nome", "decreicao", "12,00", null, null);

    }
}
