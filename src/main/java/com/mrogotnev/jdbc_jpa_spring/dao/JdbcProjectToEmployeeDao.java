package com.mrogotnev.jdbc_jpa_spring.dao;

import com.mrogotnev.jdbc_jpa_spring.entity.ProjectsIDAndEmployeesID;
import com.mrogotnev.jdbc_jpa_spring.mappers.PrjIdAndEmplIdMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class JdbcProjectToEmployeeDao {
    JdbcTemplate jdbcTemplate;

    public List<ProjectsIDAndEmployeesID> getAllProjectsIdAndEmployeeID() {
        return jdbcTemplate.query("SELECT * FROM jdbc_schema.prj_to_employees_many_to_many;", new PrjIdAndEmplIdMapper());
    }

    public List<ProjectsIDAndEmployeesID> getPrjIdAndAllEmpl(int id) {
        return jdbcTemplate.query("SELECT * FROM jdbc_schema.prj_to_employees_many_to_many WHERE id_project=?;", new Object[]{id}, new PrjIdAndEmplIdMapper());
    }

    public void createPrjIdAndAllEmpl(ProjectsIDAndEmployeesID projectsIDAndEmployeesID) {
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO jdbc_schema.prj_to_employees_many_to_many VALUES (?, ?);";
        jdbcTemplate.update(sql, projectsIDAndEmployeesID.getProjectId(), projectsIDAndEmployeesID.getEmployeeId());
    }

    public void updatePrjIdAndAllEmpl(int prjId, int emplId, ProjectsIDAndEmployeesID projectsIDAndEmployeesID) {
        jdbcTemplate.update("UPDATE jdbc_schema.prj_to_employees_many_to_many SET id_project=?, id_employee=? WHERE id_project=? AND id_employee=?",
                projectsIDAndEmployeesID.getProjectId(), projectsIDAndEmployeesID.getEmployeeId(), prjId, emplId);
    }

    public void deletePrjIdAndAllEmpl(int prjId, int emplId) {
        jdbcTemplate.update("DELETE FROM jdbc_schema.prj_to_employees_many_to_many WHERE id_project=? AND id_employee=?", prjId, emplId);
    }


}
