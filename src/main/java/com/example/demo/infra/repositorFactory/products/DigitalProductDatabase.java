package com.example.demo.infra.repositorFactory.products;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.application.domain.Product;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DigitalProductDatabase implements IRepository{

    private final IConnection connection;

    public DigitalProductDatabase(IConnection connection) {
        this.connection = connection;
    }

    @Override
    public Boolean save(Product product) {
        try {
            var st = connection.query("INSERT INTO digital_products (id, name, description, price_in_cents, file_format, file_size, category) VALUES (?, ?, ?, ?, ?, ?, ?)");
            buildInsertion(st, product);
            var result = st.executeUpdate();
            if(result != 0) {
                return true;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Product getProduct() {
        return null;
    }

    private void buildInsertion(PreparedStatement st, Product product) throws SQLException {
        st.setObject(1, product.getId());
        st.setString(2, product.getName());
        st.setString(3, product.getDescription());
        st.setInt(4, product.getPriceInCents());
        st.setString(5, product.getFileFormat());
        st.setString(6, product.getFileSize());
        st.setString(7, String.valueOf(product.getCategory()));
    }
}
