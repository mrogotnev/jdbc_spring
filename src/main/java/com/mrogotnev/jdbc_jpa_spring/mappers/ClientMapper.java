package com.mrogotnev.jdbc_jpa_spring.mappers;

import com.mrogotnev.jdbc_jpa_spring.entity.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Client(
                rs.getInt("id_client"),
                rs.getString("first_name"),
                rs.getString("second_name"),
                rs.getString("company_name")
        );
    }
}
