package com.example.demo.infra.repositorFactory.products;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.dto.OutputProductDTO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class DigitalProductDatabase implements IRepository{

    private final IConnection connection;

    public DigitalProductDatabase(IConnection connection) {
        this.connection = connection;
    }

    @Override
    public Boolean save(OutputProductDTO product) {
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
    public OutputProductDTO getProduct() {
        return null;
    }

    private void buildInsertion(PreparedStatement st, OutputProductDTO product) throws SQLException {
        st.setObject(1, UUID.fromString(product.getAttribute("id")));
        st.setString(2, product.getAttribute("name"));
        st.setString(3, product.getAttribute("description"));
        st.setInt(4, Integer.parseInt(product.getAttribute("priceInCents")));
        st.setString(5, product.getAttribute("fileFormat"));
        st.setString(6, product.getAttribute("fileSize"));
        st.setString(7, product.getAttribute("category"));
    }
}
