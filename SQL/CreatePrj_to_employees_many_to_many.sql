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
