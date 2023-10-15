CREATE TABLE `jdbc_schema`.`employees` (
  `id_employee` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `second_name` VARCHAR(45) NOT NULL,
  job_title ENUM('Developer', 'Tester', 'Admin', 'Manager'),
  PRIMARY KEY (`id_employee`),
  UNIQUE INDEX `id_employee_UNIQUE` (`id_employee` ASC) VISIBLE);