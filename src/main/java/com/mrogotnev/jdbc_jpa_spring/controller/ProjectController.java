package com.mrogotnev.jdbc_jpa_spring.controller;

import com.mrogotnev.jdbc_jpa_spring.entity.Project;
import com.mrogotnev.jdbc_jpa_spring.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProjectController {
    private ProjectService projectService;

    @GetMapping("/getAllProjects")
    public List<Project> getAllEmployees() {
        return projectService.getAllProjects();
    }

    @GetMapping("/readProject/{id}")
    public Project readProject(@PathVariable int id) {
        return projectService.readProject(id);
    }

    @PostMapping(value = "/createProject", consumes = {"application/json"})
    public int createEmployee(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @PutMapping("/updateProject/{id}")
    public void updateProject(@PathVariable int id, @RequestBody Project project) {
        projectService.updateProject(id, project);
    }

    @DeleteMapping("/deleteProject/{id}")
    public void deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
    }
}
