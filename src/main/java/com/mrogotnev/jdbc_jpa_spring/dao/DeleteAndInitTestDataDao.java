package com.mrogotnev.jdbc_jpa_spring.dao;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.util.Map;

@AllArgsConstructor
@Component
public class DeleteAndInitTestDataDao {
    private JdbcTemplate jdbcTemplate;

    public void deleteAndInitTestData() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("delete_then_init_data");
        Map<String, Object> out = simpleJdbcCall.execute();
    }
}
