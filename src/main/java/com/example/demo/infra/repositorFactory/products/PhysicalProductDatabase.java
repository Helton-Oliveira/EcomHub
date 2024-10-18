package com.example.demo.infra.repositorFactory.products;

import com.example.demo.adapter.connection.IConnection;
import com.example.demo.adapter.dto.ICreateOutputDTO;
import com.example.demo.adapter.dto.OutputProductDTO;
import com.example.demo.application.domain.component.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PhysicalProductDatabase implements IRepositoryUpdateMethod{

    private final IConnection connection;
    private final ICreateOutputDTO createDTO;

    public PhysicalProductDatabase(IConnection connection, ICreateOutputDTO createDTO) {
        this.connection = connection;
        this.createDTO = createDTO;
    }

    @Override
    public Boolean save(OutputProductDTO product) {
        try {
            var st = connection.query("INSERT INTO physical_products (id, name, description, price_in_cents, quantity, category, active) VALUES (?, ?, ?, ?, ?, ?, ?)");
            buildInsertion(st, product);
            var result = st.executeUpdate();
            if (result <= 0) {
                return false;
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public Optional<OutputProductDTO> getProduct(UUID id) {
        try {
            var st = connection.query("SELECT * FROM physical_products WHERE id = ?");
            st.setObject(1, id);
            var result = st.executeQuery();

            if (result.next()) {
               return Optional.ofNullable(reBuild(result));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<OutputProductDTO> getAll() {

        List<OutputProductDTO> physicalProductList = new ArrayList<>();

        try {
            var st = connection.query("SELECT * FROM physical_products WHERE active IN ('TRUE')");
            var result = st.executeQuery();

            while (result.next()) {
                physicalProductList.add(reBuild(result));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return physicalProductList;
    }

    @Override
    public Boolean update(UUID id, Integer quantity) {
        try {
            var st = connection.query("UPDATE physical_products SET quantity = quantity - ? WHERE id = ?");
            st.setInt(1, quantity);
            st.setObject(2, id);
            var result = st.executeUpdate();

            if (result == 0) {
                return false;
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public Boolean delete(UUID id) {
        try {
            var st = connection.query("UPDATE physical_products SET active = ? WHERE id = ?");
            st.setBoolean(1, false);
            st.setObject(2, id);
            var result = st.executeUpdate();

            if (result == 0) {
                return false;
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private void buildInsertion(PreparedStatement st, OutputProductDTO product) throws SQLException {
        st.setObject(1, UUID.fromString(product.getAttribute("id")));
        st.setString(2, product.getAttribute("name"));
        st.setString(3, product.getAttribute("description"));
        st.setInt(4, Integer.parseInt(product.getAttribute("priceInCents")));
        st.setInt(5, Integer.parseInt(product.getAttribute("quantity")));
        st.setString(6, product.getAttribute("category"));
        st.setBoolean(7, Boolean.parseBoolean(product.getAttribute("active")));
    }

    private OutputProductDTO reBuild(ResultSet st) throws SQLException {
        return createDTO.createOutputPhysicalProductDto(
                (UUID) st.getObject("id"),
                st.getString("name"),
                st.getString("description"),
                st.getInt("quantity"),
                st.getInt("price_in_cents"),
                Category.valueOf(st.getString("category")),
                st.getBoolean("active")
        );
    }
}
