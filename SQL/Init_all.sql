CREATE SCHEMA `jdbc_schema` ;
USE `jdbc_schema`;

CREATE TABLE `jdbc_schema`.`clients` (
  `id_client` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `second_name` VARCHAR(45) NOT NULL,
  `company_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE INDEX `id_client_UNIQUE` (`id_client` ASC) VISIBLE);
  
CREATE TABLE `jdbc_schema`.`projects` (
  `id_project` INT NOT NULL AUTO_INCREMENT,
  `prj_name` VARCHAR(45) NOT NULL,
  `prj_status` TINYINT NOT NULL,
  `id_client` INT NOT NULL,
  PRIMARY KEY (`id_project`),
  UNIQUE INDEX `id_project_UNIQUE` (`id_project` ASC) VISIBLE,
  INDEX `id_client_idx` (`id_client` ASC) VISIBLE,
  CONSTRAINT `id_client`
    FOREIGN KEY (`id_client`)
    REFERENCES `jdbc_schema`.`clients` (`id_client`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `jdbc_schema`.`employees` (
  `id_employee` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `second_name` VARCHAR(45) NOT NULL,
  job_title ENUM('Developer', 'Tester', 'Admin', 'Manager'),
  PRIMARY KEY (`id_employee`),
  UNIQUE INDEX `id_employee_UNIQUE` (`id_employee` ASC) VISIBLE);
  
CREATE TABLE `jdbc_schema`.`prj_to_employees_many_to_many` (
  `id_project` INT NOT NULL,
  `id_employee` INT NOT NULL,
  INDEX `id_project_idx` (`id_project` ASC) VISIBLE,
  INDEX `id_employee_idx` (`id_employee` ASC) VISIBLE,
  CONSTRAINT `id_project`
    FOREIGN KEY (`id_project`)
    REFERENCES `jdbc_schema`.`projects` (`id_project`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_employee`
    FOREIGN KEY (`id_employee`)
    REFERENCES `jdbc_schema`.`employees` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

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

delimiter \\
CREATE PROCEDURE create_employee(IN first_name_empl varchar(40), second_name_empl varchar(40), job_title_empl varchar(40),  OUT id_employee_empl INT)
BEGIN
	INSERT INTO jdbc_schema.employees (first_name, second_name, job_title) VALUES (first_name_empl, second_name_empl, job_title_empl);
	SELECT LAST_INSERT_ID() INTO id_employee_empl;
END\\

delimiter \\
CREATE PROCEDURE delete_employee(IN id_empl INT)
BEGIN
	DELETE FROM jdbc_schema.prj_to_employees_many_to_many WHERE id_employee=id_empl;
	DELETE FROM jdbc_schema.employees WHERE id_employee=id_empl;
END\\

delimiter \\
CREATE PROCEDURE get_all_employee()
BEGIN
	SELECT id_employee, first_name, second_name, job_title FROM jdbc_schema.employees;
END\\

delimiter \\
CREATE PROCEDURE get_empl_on_all_prj(IN id_empl INT)
BEGIN
	select employees.id_employee, employees.first_name, employees.second_name, employees.job_title, prj_to_employees_many_to_many.id_project, projects.prj_name, projects.prj_status
    from jdbc_schema.employees
    inner join prj_to_employees_many_to_many on employees.id_employee=prj_to_employees_many_to_many.id_employee
    inner join projects on prj_to_employees_many_to_many.id_project=projects.id_project where employees.id_employee=id_empl;
END\\

delimiter \\
CREATE PROCEDURE read_employee(IN id_empl INT)
BEGIN
	SELECT * FROM jdbc_schema.employees WHERE id_employee=id_empl;
END\\

delimiter \\
CREATE PROCEDURE read_employee_with_title(IN job_title_empl varchar (40))
BEGIN
	SELECT * FROM jdbc_schema.employees WHERE job_title=job_title_empl;
END\\

delimiter \\
CREATE PROCEDURE update_employee(IN id_empl INT, first_name_empl varchar(40), second_name_empl varchar(40), job_title_empl varchar(40))
BEGIN
	UPDATE jdbc_schema.employees
    SET first_name = first_name_empl, second_name = second_name_empl, job_title = job_title_empl
    WHERE id_employee = id_empl;
END\\  

CALL delete_then_init_data();