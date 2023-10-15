package com.mrogotnev.jdbc_jpa_spring.mappers;

import com.mrogotnev.jdbc_jpa_spring.entity.ProjectsIDAndEmployeesID;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrjIdAndEmplIdMapper implements RowMapper<ProjectsIDAndEmployeesID> {
    @Override
    public ProjectsIDAndEmployeesID mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProjectsIDAndEmployeesID(
                rs.getInt("id_project"),
                rs.getInt("id_employee")
        ) ;
    }
}
