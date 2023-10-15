package com.mrogotnev.jdbc_jpa_spring.services;

import com.mrogotnev.jdbc_jpa_spring.dao.ProjectDao;
import com.mrogotnev.jdbc_jpa_spring.entity.Project;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class JdbcProjectService {
    private ProjectDao projectDao;

    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }

    public Project readProject(int id) {
        return projectDao.readProject(id);
    }

    public int createProject(Project project) {
        return projectDao.createProject(project);
    }

    public void updateProject(int id, Project project) {
        projectDao.updateProject(id, project);
    }

    public void deleteProject(int id) {
        projectDao.deleteProject(id);
    }


}
