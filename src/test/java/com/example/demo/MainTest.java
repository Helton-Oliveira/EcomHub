package com.example.demo;

import com.example.demo.component.Category;
import com.example.demo.factory.ProductFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    @Test
    @DisplayName("Deve criar um produto")
    void createProduct() {
        var factory =  ProductFactory.getFactory("digital");
        var product = factory.createProduct();
        product.create("Design Patterns", "ebook sobre padroes de projeto", "140,00", "2GB", "ePUB, PDF");

       var instance = product.get();

       assertThat(instance.getName()).isEqualTo("Design Patterns");
       assertThat(instance.getCategory()).isEqualTo(Category.DIGITAL);
    }
}
