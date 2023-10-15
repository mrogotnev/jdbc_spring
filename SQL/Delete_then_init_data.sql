delimiter //
CREATE PROCEDURE delete_then_init_data()
BEGIN 
	DELETE FROM jdbc_schema.prj_to_employees_many_to_many;
    DELETE FROM jdbc_schema.employees;
    DELETE FROM jdbc_schema.projects;
    DELETE FROM jdbc_schema.clients;
    
    
    ALTER TABLE jdbc_schema.employees AUTO_INCREMENT = 1;
    ALTER TABLE jdbc_schema.projects AUTO_INCREMENT = 1;
    ALTER TABLE jdbc_schema.clients AUTO_INCREMENT = 1;
    
	INSERT INTO jdbc_schema.employees (first_name, second_name, job_title) VALUES 
    ('Ivan', 'Ivanov', 'Developer'),
	('Ferod', 'Ferorov', 'Developer'),
    ('Aleksandr', 'Aleksandrov', 'Tester'),
    ('Aleksey', 'Alekseyev', 'Tester'),
    ('Olga', 'Ivanova', 'Tester'),
    ('Evgeniy', 'Evgenyev', 'Tester'),
    ('Sergey', 'Sergeev', 'Manager'),
    ('Anton', 'Antonov', 'Manager'),
    ('Mihail', 'Antonov', 'Admin'),
    ('Maria', 'Ivanova', 'Admin');
    
    INSERT INTO jdbc_schema.clients (first_name, second_name, company_name) VALUES ('Roman', 'Romanov', 'Big Red Team'),
	('Anastatia', 'Sergeeva', 'Small Blue Team');
    
    INSERT INTO jdbc_schema.projects (prj_name, prj_status, id_client) VALUES ('Big intresting project', 1, 
    (SELECT clients.id_client FROM jdbc_schema.clients WHERE clients.first_name='Roman' AND clients.second_name='Romanov')),
    ('Small intresting project', 0, 
    (SELECT clients.id_client FROM jdbc_schema.clients WHERE clients.first_name='Anastatia' AND clients.second_name='Sergeeva'));
    
    INSERT INTO jdbc_schema.prj_to_employees_many_to_many (id_project, id_employee) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 7), (1, 10),
    (2, 2), (2, 6), (2, 8), (2, 9);
END//

CALL delete_then_init_data();
	SELECT * FROM jdbc_schema.clients;
    SELECT * FROM jdbc_schema.employees;
    SELECT * FROM jdbc_schema.projects;
    SELECT * FROM jdbc_schema.prj_to_employees_many_to_many;