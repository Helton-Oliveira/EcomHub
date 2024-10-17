package com.example.demo.application.useCases.statePattern;

import com.example.demo.application.useCases.IDeleteProduct;
import com.example.demo.infra.repositorFactory.products.IRepository;
import com.example.demo.infra.repositorFactory.products.IRepositoryUpdateMethod;

import java.util.UUID;

public class DecrementPhysicalProductStockProductState implements IProductState {

    private final IDeleteProduct context;
    private final IRepositoryUpdateMethod repository;

    public DecrementPhysicalProductStockProductState(IDeleteProduct context, IRepositoryUpdateMethod repository) {
        this.context = context;
        this.repository = repository;
    }

    @Override
    public String transitState() {
        var product = repository.getProduct(UUID.fromString(context.getProductId()));
        int stock = Integer.parseInt(product.getAttribute("quantity"));
        if (stock > 0) {
            var result = repository.update(UUID.fromString(context.getProductId()), 1);

            return result ? "Sucesso" : "ERRO";
        }
        context.setState(new InactivatePhysicalProductState(context, repository));
        return context.execute();
    }
}
