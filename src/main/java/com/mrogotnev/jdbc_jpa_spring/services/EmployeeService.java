package com.mrogotnev.jdbc_jpa_spring.services;

import com.mrogotnev.jdbc_jpa_spring.dto.EmplOnAllPrjDto;
import com.mrogotnev.jdbc_jpa_spring.entity.Employee;
import com.mrogotnev.jdbc_jpa_spring.dao.EmployeeDao;
import com.mrogotnev.jdbc_jpa_spring.entity.enums.JobTitle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class EmployeeService {
    private EmployeeDao employeeDao;
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllWorkers();
    }

    public Employee readEmployee(int id) {
        return employeeDao.readEmployee(id);
    }

    public int createEmployee(Employee employee) {
        return employeeDao.createEmployee(employee);
    }

    public void updateEmployee(int id, Employee employee) {
        employeeDao.updateEmployee(id, employee);
    }

    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    public List<Employee> readEmployeeWithTitle(JobTitle title) {
        return employeeDao.readEmployeeWithTitle(title);
    }
    public List<EmplOnAllPrjDto> getEmplOnAllPrjDto (int emplId) {
        return employeeDao.getEmplOnAllPrjDto(emplId);
    }
}
