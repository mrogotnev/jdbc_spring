delimiter \\
CREATE PROCEDURE read_employee_with_title(IN job_title_empl varchar (40))
BEGIN
	SELECT * FROM jdbc_schema.employees WHERE job_title=job_title_empl;
END\\