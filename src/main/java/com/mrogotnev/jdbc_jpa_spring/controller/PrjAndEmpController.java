package com.mrogotnev.jdbc_jpa_spring.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mrogotnev.jdbc_jpa_spring.entity.ProjectsIDAndEmployeesID;
import com.mrogotnev.jdbc_jpa_spring.services.PrjAndEmplService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PrjAndEmpController {
    private PrjAndEmplService prjAndEmplService;

    @GetMapping("/getAllProjectsIdAndEmployeeID")
    public List<ProjectsIDAndEmployeesID> getAllProjectsIdAndEmployeeID() {
        return prjAndEmplService.getAllProjectsIdAndEmployeeID();
    }

    @GetMapping("getPrjIdAndAllEmpl/{id}")
    public List<ProjectsIDAndEmployeesID> getPrjIdAndAllEmpl(@PathVariable int id) {
        return prjAndEmplService.getPrjIdAndAllEmpl(id);
    }

    @PostMapping(value = "/createPrjAndEmpl", consumes = {"application/json"})
    public void createPrjAndEmpl(@RequestBody ProjectsIDAndEmployeesID projectsIDAndEmployeesID) {
        prjAndEmplService.createPrjIdAndAllEmpl(projectsIDAndEmployeesID);
    }

    @PutMapping("/updatePrjAndEmpl")
    public void updatePrjAndEmpl(@RequestBody ObjectNode json) {
        ProjectsIDAndEmployeesID projectsIDAndEmployeesID = new ProjectsIDAndEmployeesID(json.get("new_project_id").asInt(),
                json.get("new_employee_id").asInt());
        prjAndEmplService.updatePrjIdAndAllEmpl(json.get("old_project_id").asInt(), json.get("old_employee_id").asInt(),
                projectsIDAndEmployeesID);
    }

    @DeleteMapping(value = "/deletePrjAndEmpl", consumes = {"application/json"})
    public void deletePrjAndEmpl(@RequestBody ProjectsIDAndEmployeesID projectsIDAndEmployeesID) {
        prjAndEmplService.deletePrjIdAndAllEmpl(projectsIDAndEmployeesID.getProjectId(), projectsIDAndEmployeesID.getEmployeeId());
    }

}
