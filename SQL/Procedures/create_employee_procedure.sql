delimiter \\
CREATE PROCEDURE create_employee(IN first_name_empl varchar(40), second_name_empl varchar(40), job_title_empl varchar(40),  OUT id_employee_empl INT)
BEGIN
	INSERT INTO jdbc_schema.employees (first_name, second_name, job_title) VALUES (first_name_empl, second_name_empl, job_title_empl);
	SELECT LAST_INSERT_ID() INTO id_employee_empl;
END\\