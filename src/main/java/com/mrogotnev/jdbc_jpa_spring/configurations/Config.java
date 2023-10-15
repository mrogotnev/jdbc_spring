package com.mrogotnev.jdbc_jpa_spring.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {
    @Bean
    public DataSource mysqlJdbcDataSource() {
        DriverManagerDataSource jdbcDataSource = new DriverManagerDataSource();
        jdbcDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        jdbcDataSource.setUrl("jdbc:mysql://localhost:3306/jdbc_schema");
        jdbcDataSource.setUsername("root");
        jdbcDataSource.setPassword("Qwerty!23");
        return jdbcDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(mysqlJdbcDataSource());
    }
}
