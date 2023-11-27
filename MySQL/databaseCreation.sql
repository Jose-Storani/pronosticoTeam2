-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pronosticosDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pronosticosDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pronosticosDB` DEFAULT CHARACTER SET utf8 ;
USE `pronosticosDB` ;

-- -----------------------------------------------------
-- Table `pronosticosDB`.`Participante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pronosticosDB`.`Participante` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `puntos` INT UNSIGNED NULL,
  `cantidad_aciertos` INT UNSIGNED NULL,
  `email` VARCHAR(70) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `participanteID_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pronosticosDB`.`Equipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pronosticosDB`.`Equipo` (
  `equipo_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`equipo_id`),
  UNIQUE INDEX `equipo_id_UNIQUE` (`equipo_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pronosticosDB`.`Partido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pronosticosDB`.`Partido` (
  `partido_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `goles_equipo_1` TINYINT(20) UNSIGNED NOT NULL,
  `goles_equipo_2` TINYINT(20) UNSIGNED NOT NULL,
  `resultado` ENUM("GANA1", "EMPATE", "GANA2") NOT NULL,
  `equipo1_id` INT UNSIGNED NOT NULL,
  `equipo2_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`partido_id`),
  UNIQUE INDEX `partido_id_UNIQUE` (`partido_id` ASC) VISIBLE,
  INDEX `equipo_id_idx` (`equipo1_id` ASC) VISIBLE,
  INDEX `equipo2_id_idx` (`equipo2_id` ASC) VISIBLE,
  CONSTRAINT `equipo1_id`
    FOREIGN KEY (`equipo1_id`)
    REFERENCES `pronosticosDB`.`Equipo` (`equipo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `equipo2_id`
    FOREIGN KEY (`equipo2_id`)
    REFERENCES `pronosticosDB`.`Equipo` (`equipo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pronosticosDB`.`Pronostico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pronosticosDB`.`Pronostico` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `resultado_propuesto` ENUM("GANA1", "EMPATE", "GANA2") NOT NULL,
  `partido_id` INT UNSIGNED NOT NULL,
  `Participante_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pronostico_Partido1_idx` (`partido_id` ASC) VISIBLE,
  INDEX `fk_Pronostico_Participante1_idx` (`Participante_id` ASC) VISIBLE,
  CONSTRAINT `fk_Pronostico_Partido1`
    FOREIGN KEY (`partido_id`)
    REFERENCES `pronosticosDB`.`Partido` (`partido_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pronostico_Participante1`
    FOREIGN KEY (`Participante_id`)
    REFERENCES `pronosticosDB`.`Participante` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pronosticosDB`.`Ronda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pronosticosDB`.`Ronda` (
  `numero_ronda` INT UNSIGNED NOT NULL,
  `partido_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`numero_ronda`, `partido_id`),
  INDEX `fk_Ronda_Partido1_idx` (`partido_id` ASC) VISIBLE,
  UNIQUE INDEX `partido_id_UNIQUE` (`partido_id` ASC) VISIBLE,
  CONSTRAINT `fk_Ronda_Partido1`
    FOREIGN KEY (`partido_id`)
    REFERENCES `pronosticosDB`.`Partido` (`partido_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
