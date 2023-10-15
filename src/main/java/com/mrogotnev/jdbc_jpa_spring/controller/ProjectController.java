package com.mrogotnev.jdbc_jpa_spring.controller;

import com.mrogotnev.jdbc_jpa_spring.entity.Project;
import com.mrogotnev.jdbc_jpa_spring.services.JdbcProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProjectController {
    private JdbcProjectService jdbcProjectService;

    @GetMapping("/getAllProjects")
    public List<Project> getAllEmployees() {
        return jdbcProjectService.getAllProjects();
    }

    @GetMapping("/readProject/{id}")
    public Project readProject(@PathVariable int id) {
        return jdbcProjectService.readProject(id);
    }

    @PostMapping(value = "/createProject", consumes = {"application/json"})
    public int createEmployee(@RequestBody Project project) {
        return jdbcProjectService.createProject(project);
    }

    @PutMapping("/updateProject/{id}")
    public void updateProject(@PathVariable int id, @RequestBody Project project) {
        jdbcProjectService.updateProject(id, project);
    }

    @DeleteMapping("/deleteProject/{id}")
    public void deleteProject(@PathVariable int id) {
        jdbcProjectService.deleteProject(id);
    }
}
