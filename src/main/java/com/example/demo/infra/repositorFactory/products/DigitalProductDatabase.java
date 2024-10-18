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
import java.lang.*;

public class DigitalProductDatabase implements IRepository {

    private final IConnection connection;
    private final ICreateOutputDTO createDTO;

    public DigitalProductDatabase(IConnection connection, ICreateOutputDTO createDTO) {
        this.connection = connection;
        this.createDTO = createDTO;
    }

    @Override
    public Boolean save(OutputProductDTO product) {
        try {
            var st = connection.query("INSERT INTO digital_products (id, name, description, price_in_cents, file_format, file_size, category, active) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
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
    public Optional<OutputProductDTO> getProduct(UUID id) {
        try {
            var st = connection.query("SELECT * FROM digital_products WHERE id = ?");
            st.setObject(1, id);
            var result = st.executeQuery();

            if (result.next()) {
               return Optional.ofNullable(reBuild(result));
            }
            connection.close();
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public List<OutputProductDTO> getAll() {
        List<OutputProductDTO> outputProductDTOList = new ArrayList<>();
        try {
            var st = connection.query("SELECT * FROM digital_products WHERE active IN ('TRUE')");
            var result = st.executeQuery();

            while (result.next()) {
                outputProductDTOList.add(reBuild(result));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return outputProductDTOList;
    }

    @Override
    public Boolean delete(UUID id) {
        try {
            var st = connection.query("UPDATE digital_products SET active = ? WHERE id = ?");
            st.setBoolean(1, false);
            st.setObject(2, id);
            var update = st.executeUpdate();

            if (update < 1) {
                return false;
            }

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
        st.setString(5, product.getAttribute("fileFormat"));
        st.setString(6, product.getAttribute("fileSize"));
        st.setString(7, product.getAttribute("category"));
        st.setBoolean(8, Boolean.parseBoolean(product.getAttribute("active")));
    }

    private OutputProductDTO reBuild(ResultSet st) throws SQLException {
        return createDTO.createOutputDigitalProductDto(
                (UUID) st.getObject("id"),
                st.getString("name"),
                st.getString("description"),
                st.getString("file_size"),
                st.getString("file_format"),
                st.getInt("price_in_cents"),
                Category.valueOf(st.getString("category")),
                st.getBoolean("active")
        );
    }
}
