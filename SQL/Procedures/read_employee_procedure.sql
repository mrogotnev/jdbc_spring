delimiter \\
CREATE PROCEDURE read_employee(IN id_empl INT)
BEGIN
	SELECT * FROM jdbc_schema.employees WHERE id_employee=id_empl;
END\\