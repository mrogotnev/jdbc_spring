delimiter \\
CREATE PROCEDURE get_all_employee()
BEGIN
	SELECT id_employee, first_name, second_name, job_title FROM jdbc_schema.employees;
END\\