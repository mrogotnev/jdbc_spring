CREATE TABLE `jdbc_schema`.`clients` (
  `id_client` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `second_name` VARCHAR(45) NOT NULL,
  `company_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE INDEX `id_client_UNIQUE` (`id_client` ASC) VISIBLE);