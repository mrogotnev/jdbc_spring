package com.mrogotnev.jdbc_jpa_spring.services;

import com.mrogotnev.jdbc_jpa_spring.dao.JdbcProjectToEmployeeDao;
import com.mrogotnev.jdbc_jpa_spring.entity.ProjectsIDAndEmployeesID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PrjAndEmplService {
    private JdbcProjectToEmployeeDao jdbcProjectToEmployeeDao;
    public List<ProjectsIDAndEmployeesID> getAllProjectsIdAndEmployeeID() {
        return jdbcProjectToEmployeeDao.getAllProjectsIdAndEmployeeID();
    }

    public List<ProjectsIDAndEmployeesID> getPrjIdAndAllEmpl(int id) {
        return jdbcProjectToEmployeeDao.getPrjIdAndAllEmpl(id);
    }

    public void createPrjIdAndAllEmpl(ProjectsIDAndEmployeesID projectsIDAndEmployeesID) {
        jdbcProjectToEmployeeDao.createPrjIdAndAllEmpl(projectsIDAndEmployeesID);
    }

    public void updatePrjIdAndAllEmpl(int prjId, int emplId, ProjectsIDAndEmployeesID projectsIDAndEmployeesID) {
        jdbcProjectToEmployeeDao.updatePrjIdAndAllEmpl(prjId, emplId, projectsIDAndEmployeesID);
    }

    public void deletePrjIdAndAllEmpl(int prjId, int emplId) {
        jdbcProjectToEmployeeDao.deletePrjIdAndAllEmpl(prjId, emplId);
    }
}
