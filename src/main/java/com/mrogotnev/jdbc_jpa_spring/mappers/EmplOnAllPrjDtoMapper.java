package com.mrogotnev.jdbc_jpa_spring.mappers;

import com.mrogotnev.jdbc_jpa_spring.dto.EmplOnAllPrjDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmplOnAllPrjDtoMapper implements RowMapper<EmplOnAllPrjDto> {
    @Override
    public EmplOnAllPrjDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new EmplOnAllPrjDto(
                rs.getInt("id_employee"),
                rs.getInt("id_project"),
                rs.getString("prj_name"),
                rs.getBoolean("prj_status")
        );
    }
}
