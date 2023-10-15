package com.mrogotnev.jdbc_jpa_spring.dao;

import com.mrogotnev.jdbc_jpa_spring.dto.EmplOnAllPrjDto;
import com.mrogotnev.jdbc_jpa_spring.entity.Employee;
import com.mrogotnev.jdbc_jpa_spring.entity.enums.JobTitle;
import com.mrogotnev.jdbc_jpa_spring.mappers.EmplOnAllPrjDtoMapper;
import com.mrogotnev.jdbc_jpa_spring.mappers.EmployeeMapper;
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
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public List<Employee> getAllWorkers() {
        return jdbcTemplate.query("SELECT id_employee, first_name, second_name, job_title FROM jdbc_schema.employees", new EmployeeMapper());
    }

    public Employee readEmployee(int id) {
        return jdbcTemplate.query("SELECT * FROM jdbc_schema.employees WHERE id_employee=?", new Object[]{id}, new EmployeeMapper())
                .stream().findAny().orElse(null);
    }

    public int createEmployee(Employee employee) {
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO jdbc_schema.employees (first_name, second_name, job_title) VALUES (?, ?, ?);";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getJobTitle().name());
            return ps;
        }, generatedKeyHolder);
        return generatedKeyHolder.getKey().intValue();
    }

    public void updateEmployee(int id, Employee employee) {
        jdbcTemplate.update("UPDATE jdbc_schema.employees SET first_name=?, second_name=?, job_title=? WHERE id_employee=?",
                employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), id);
    }

    public void deleteEmployee(int id) {
        jdbcTemplate.update("DELETE FROM jdbc_schema.employees WHERE id_employee=?", id);
    }

    public Employee readEmployeeWithTitle(JobTitle title) {
        return jdbcTemplate.query("SELECT * FROM jdbc_schema.employees WHERE job_title=?", new Object[]{title.toString()}, new EmployeeMapper())
                .stream().findAny().orElse(null);
    }

    public List<EmplOnAllPrjDto> getEmplOnAllPrjDto (int emplId) {
        String sql = "select employees.id_employee, employees.first_name, employees.second_name, employees.job_title, prj_to_employees_many_to_many.id_project, projects.prj_name, projects.prj_status" +
                " from jdbc_schema.employees" +
                " inner join prj_to_employees_many_to_many on employees.id_employee=prj_to_employees_many_to_many.id_employee" +
                " inner join projects on prj_to_employees_many_to_many.id_project=projects.id_project where employees.id_employee=?;";
        return jdbcTemplate.query(sql, new Object[]{emplId}, new EmplOnAllPrjDtoMapper());
    }
}
