package com.example.demo.application.useCases;

import com.example.demo.application.useCases.statePattern.DeactivateDigitalProductState;
import com.example.demo.application.useCases.statePattern.DecrementPhysicalProductStockProductState;
import com.example.demo.application.useCases.statePattern.IProductState;
import com.example.demo.infra.repositorFactory.factories.RepositoryFactory;
import com.example.demo.infra.repositorFactory.products.IRepositoryUpdateMethod;

public class DeleteProduct implements IDeleteProduct {

    private final RepositoryFactory repositoryFactory;
    private IProductState state;
    private final String productId;

    public DeleteProduct(RepositoryFactory repositoryFactory, String productId, String category) {
        this.repositoryFactory = repositoryFactory;
        this.productId = productId;

        var repository = repositoryFactory.createRepository(category);

        if("physical".equalsIgnoreCase(category)) {
            this.state = new DecrementPhysicalProductStockProductState( this, (IRepositoryUpdateMethod) repository);
        } else {
            this.state = new DeactivateDigitalProductState(this, repository);
        }
    }

    @Override
    public String execute() {
        return state.transitState();
    }

    public IProductState getState() {
        return state;
    }

    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public void setState(IProductState state) {
        this.state = state;
    }
}
