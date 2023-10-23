delimiter \\
CREATE PROCEDURE get_empl_on_all_prj(IN id_empl INT)
BEGIN
	select employees.id_employee, employees.first_name, employees.second_name, employees.job_title, prj_to_employees_many_to_many.id_project, projects.prj_name, projects.prj_status
    from jdbc_schema.employees
    inner join prj_to_employees_many_to_many on employees.id_employee=prj_to_employees_many_to_many.id_employee
    inner join projects on prj_to_employees_many_to_many.id_project=projects.id_project where employees.id_employee=id_empl;
END\\