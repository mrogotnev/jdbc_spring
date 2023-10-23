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
import org.springframework.stereotype.Component;

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
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_employee");
        Map<String, Object> out = simpleJdbcCall.execute(
                new MapSqlParameterSource("id_empl", id)
                        .addValue("first_name_empl", employee.getFirstName())
                        .addValue("second_name_empl", employee.getLastName())
                        .addValue("job_title_empl", employee.getJobTitle()));
    }

    public void deleteEmployee(int id) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_employee");
        Map<String, Object> out = simpleJdbcCall.execute(new MapSqlParameterSource("id_empl", id));
    }

    public List<Employee> readEmployeeWithTitle(JobTitle title) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("read_employee_with_title")
                .returningResultSet("employees", new EmployeeMapper());
        Map<String, Object> out = simpleJdbcCall.execute(
                new MapSqlParameterSource("job_title_empl", title));
        return  (List<Employee>) out.get("employees");
    }

    public List<EmplOnAllPrjDto> getEmplOnAllPrjDto (int emplId) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_empl_on_all_prj")
                .returningResultSet("employees", new EmplOnAllPrjDtoMapper());
        Map<String, Object> out = simpleJdbcCall.execute(
                new MapSqlParameterSource("id_empl", emplId));
        return  (List<EmplOnAllPrjDto>) out.get("employees");
    }
}
