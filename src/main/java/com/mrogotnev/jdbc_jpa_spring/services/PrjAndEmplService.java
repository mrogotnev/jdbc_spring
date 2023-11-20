package com.mrogotnev.jdbc_jpa_spring.services;

import com.mrogotnev.jdbc_jpa_spring.dao.ProjectToEmployeeDao;
import com.mrogotnev.jdbc_jpa_spring.entity.ProjectsIDAndEmployeesID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PrjAndEmplService {
    private ProjectToEmployeeDao projectToEmployeeDao;
    public List<ProjectsIDAndEmployeesID> getAllProjectsIdAndEmployeeID() {
        return projectToEmployeeDao.getAllProjectsIdAndEmployeeID();
    }

    public List<ProjectsIDAndEmployeesID> getPrjIdAndAllEmpl(int id) {
        return projectToEmployeeDao.getPrjIdAndAllEmpl(id);
    }

    public void createPrjIdAndAllEmpl(ProjectsIDAndEmployeesID projectsIDAndEmployeesID) {
        projectToEmployeeDao.createPrjIdAndAllEmpl(projectsIDAndEmployeesID);
    }

    public void updatePrjIdAndAllEmpl(int prjId, int emplId, ProjectsIDAndEmployeesID projectsIDAndEmployeesID) {
        projectToEmployeeDao.updatePrjIdAndAllEmpl(prjId, emplId, projectsIDAndEmployeesID);
    }

    public void deletePrjIdAndAllEmpl(int prjId, int emplId) {
        projectToEmployeeDao.deletePrjIdAndAllEmpl(prjId, emplId);
    }
}
