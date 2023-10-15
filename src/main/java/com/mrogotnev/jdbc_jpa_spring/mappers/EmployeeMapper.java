package com.mrogotnev.jdbc_jpa_spring.mappers;

import com.mrogotnev.jdbc_jpa_spring.entity.Employee;
import com.mrogotnev.jdbc_jpa_spring.entity.enums.JobTitle;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(
                rs.getInt("id_employee"),
                rs.getString("first_name"),
                rs.getString("second_name"),
                JobTitle.valueOf(rs.getString("job_title"))
        );
    }
}
