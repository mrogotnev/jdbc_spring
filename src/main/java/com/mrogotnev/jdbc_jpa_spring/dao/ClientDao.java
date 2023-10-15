package com.mrogotnev.jdbc_jpa_spring.dao;

import com.mrogotnev.jdbc_jpa_spring.entity.Client;
import com.mrogotnev.jdbc_jpa_spring.mappers.ClientMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Component
@AllArgsConstructor
public class ClientDao {
    private JdbcTemplate jdbcTemplate;
    public List<Client> getAllClients() {
        return jdbcTemplate.query("SELECT id_client, first_name, second_name, company_name FROM jdbc_schema.clients", new ClientMapper());
    }

    public Client readClient(int id) {
        return jdbcTemplate.query("SELECT * FROM jdbc_schema.clients WHERE id_client=?", new Object[]{id}, new ClientMapper())
                .stream().findAny().orElse(null);
    }

    public int createClient(Client client) {
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO jdbc_schema.clients (first_name, second_name, company_name) VALUES (?, ?, ?);";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getCompanyName());
            return ps;
        }, generatedKeyHolder);
        return generatedKeyHolder.getKey().intValue();
    }

    public void updateClient(int id, Client client) {
        jdbcTemplate.update("UPDATE jdbc_schema.clients SET first_name=?, second_name=?, company_name=? WHERE id_client=?",
                client.getFirstName(), client.getLastName(), client.getCompanyName(), id);
    }

    public void deleteClient(int id) {
        jdbcTemplate.update("DELETE FROM jdbc_schema.clients WHERE id_client=?", id);
    }
}
