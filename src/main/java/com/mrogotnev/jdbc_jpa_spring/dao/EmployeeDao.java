package com.mrogotnev.jdbc_jpa_spring.dao;

import com.mrogotnev.jdbc_jpa_spring.dto.EmplOnAllPrjDto;
import com.mrogotnev.jdbc_jpa_spring.entity.Employee;
import com.mrogotnev.jdbc_jpa_spring.entity.enums.JobTitle;
import com.mrogotnev.jdbc_jpa_spring.mappers.EmplOnAllPrjDtoMapper;
import com.mrogotnev.jdbc_jpa_spring.mappers.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public List<Employee> getAllWorkers() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_all_employee");
        Map<String, Object> out = simpleJdbcCall.execute();
        return (List<Employee>) out.get("#result-set-1");
    }

    public Employee readEmployee(int id) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("read_employee")
                .returningResultSet("employees", new EmployeeMapper());
        Map<String, Object> out = simpleJdbcCall.execute(
                new MapSqlParameterSource("id_empl", id));
        List<Employee> employees = (List<Employee>) out.get("employees");
        return employees.get(0);
    }

    public int createEmployee(Employee employee) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_employee");
        Map<String, Object> out = simpleJdbcCall.execute(
                new MapSqlParameterSource("first_name_empl", employee.getFirstName())
                        .addValue("second_name_empl", employee.getLastName())
                        .addValue("job_title_empl", employee.getJobTitle()));
        return (int) out.get("id_employee_empl");
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
