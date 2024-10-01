package com.example.demo;

import com.example.demo.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    @Test
    @DisplayName("Deve criar um produto")
    void createProduct() {
        var product = new Product();
        product.setName("teclado");

        assertThat(product.getName()).isEqualTo("teclado");
    }
}
