package com.example.demo.application.productFactory.products;

import com.example.demo.adapter.dto.ICreateDTO;
import com.example.demo.adapter.dto.OutputProductDTO;
import com.example.demo.application.domain.component.Category;
import com.example.demo.application.domain.Product;

import java.util.Map;
import java.util.UUID;

public class PhysicalProduct extends Product implements IProduct {

    private Integer quantity;
    private final ICreateDTO createDTO;

    public PhysicalProduct(ICreateDTO createDTO) {
        this.createDTO = createDTO;
    }

    @Override
    public void create(Map<String, String> attributes) {
        this.setId(UUID.randomUUID());
        this.setName(attributes.get("name"));
        this.setDescription(attributes.get("description"));
        this.setPriceInCents(attributes.get("price"));
        this.setQuantity(Integer.parseInt(attributes.get("quantity")));
        this.setCategory(Category.PHYSICAL);
    }

    @Override
    public OutputProductDTO get() {
        return createDTO.createOutputPhysicalProductDto(
                this.getId(),
                this.getName(),
                this.getDescription(),
                this.getQuantity(),
                this.getPriceInCents(),
                this.getCategory()
        );
    }

    public Integer getQuantity() {
        return quantity;
    }

    private void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
