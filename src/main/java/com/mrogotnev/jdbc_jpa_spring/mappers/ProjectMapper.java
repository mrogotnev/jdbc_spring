package com.mrogotnev.jdbc_jpa_spring.mappers;

import com.mrogotnev.jdbc_jpa_spring.entity.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Project(
                rs.getInt("id_project"),
                rs.getString("prj_name"),
                rs.getBoolean("prj_status"),
                rs.getInt("id_client")
        );
    }
}
