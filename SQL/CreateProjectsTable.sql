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
