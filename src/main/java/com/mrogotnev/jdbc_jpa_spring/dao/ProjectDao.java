package com.mrogotnev.jdbc_jpa_spring.dao;

import com.mrogotnev.jdbc_jpa_spring.entity.Project;
import com.mrogotnev.jdbc_jpa_spring.mappers.ProjectMapper;
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
public class ProjectDao {
    private JdbcTemplate jdbcTemplate;
    public List<Project> getAllProjects() {
        return jdbcTemplate.query("SELECT id_project, prj_name, prj_status, id_client FROM jdbc_schema.projects", new ProjectMapper());
    }

    public Project readProject(int id) {
        return jdbcTemplate.query("SELECT * FROM jdbc_schema.projects WHERE id_project=?", new Object[]{id}, new ProjectMapper())
                .stream().findAny().orElse(null);
    }

    public int createProject(Project project) {
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO jdbc_schema.projects (prj_name, prj_status, id_client) VALUES (?, ?, ?);";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, project.getProjectName());
            ps.setBoolean(2, project.isStatus());
            ps.setInt(3, project.getClientId());
            return ps;
        }, generatedKeyHolder);
        return generatedKeyHolder.getKey().intValue();
    }

    public void updateProject(int id, Project project) {
        jdbcTemplate.update("UPDATE jdbc_schema.projects SET prj_name=?, prj_status=?, id_client=? WHERE id_project=?",
                project.getProjectName(), project.isStatus(), project.getClientId(), id);
    }

    public void deleteProject(int id) {
        jdbcTemplate.update("DELETE FROM jdbc_schema.projects WHERE id_project=?", id);
    }
}
