delimiter \\
CREATE PROCEDURE update_employee(IN id_empl INT, first_name_empl varchar(40), second_name_empl varchar(40), job_title_empl varchar(40))
BEGIN
	UPDATE jdbc_schema.employees
    SET first_name = first_name_empl, second_name = second_name_empl, job_title = job_title_empl
    WHERE id_employee = id_empl;
END\\

