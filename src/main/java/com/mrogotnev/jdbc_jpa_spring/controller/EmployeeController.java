package com.mrogotnev.jdbc_jpa_spring.controller;

import com.mrogotnev.jdbc_jpa_spring.dto.EmplOnAllPrjDto;
import com.mrogotnev.jdbc_jpa_spring.entity.Employee;
import com.mrogotnev.jdbc_jpa_spring.entity.enums.JobTitle;
import com.mrogotnev.jdbc_jpa_spring.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/readEmployee/{id}")
    public Employee readEmployee(@PathVariable int id) {
        return employeeService.readEmployee(id);
    }

    @GetMapping("/readEmployeeWithTitle/{title}")
    public Employee readEmployee(@PathVariable JobTitle title) {
        return employeeService.readEmployeeWithTitle(title);
    }

    @PostMapping(value = "/createEmployee", consumes = {"application/json"})
    public int createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping ("/updateEmployee/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/getEmplOnAllPrjDto/{emplId}")
    public List<EmplOnAllPrjDto> getEmplOnAllPrjDto(@PathVariable int emplId) {
        return employeeService.getEmplOnAllPrjDto(emplId);
    }
}
