package com.example.demo.application.productFactory.factories;

import com.example.demo.application.productFactory.products.IProduct;

import java.util.Map;

public abstract class ProductFactory {
       public abstract IProduct createProduct();

       public static ProductFactory getFactory(Map<String, String> attribute) {
               if (attribute.containsKey("fileFormat") && attribute.containsKey("fileSize")) {
                       return new DigitalProductFactory();
               }

               if(attribute.containsKey("quantity")) {
                        return new PhysicalProductFactory();   
               }

               return null;
       }
}