package com.example.demo.factory;

import com.example.demo.DigitalProduct.digitalFactory.DigitalProductFactory;
import com.example.demo.factory.products.IProduct;
import com.example.demo.physicalProduct.physicalFactory.PhysicalProductFactory;

public abstract class ProductFactory {
       public abstract IProduct createProduct();

       public static ProductFactory getFactory(String type) {
               if (type.equalsIgnoreCase("digital")) {
                       return new DigitalProductFactory();
               }

               if(type.equalsIgnoreCase("physic")) {
                        return new PhysicalProductFactory();   
               }

               return null;
       }
}