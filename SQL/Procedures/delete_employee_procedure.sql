delimiter \\
CREATE PROCEDURE delete_employee(IN id_empl INT)
BEGIN
	DELETE FROM jdbc_schema.prj_to_employees_many_to_many WHERE id_employee=id_empl;
	DELETE FROM jdbc_schema.employees WHERE id_employee=id_empl;
END\\