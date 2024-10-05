package com.example.demo.domain.factory;

import com.example.demo.domain.factory.products.IProduct;

import java.util.Optional;

public abstract class ProductFactory {
       public abstract IProduct createProduct();

       public static ProductFactory getFactory(String fileFormat, String fileSize) {
               if (fileFormat != null && fileSize != null) {
                       return new DigitalProductFactory();
               } else {
                       return new PhysicalProductFactory();
               }
       }
}
