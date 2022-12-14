-- MySQL Script generated by MySQL Workbench
-- Mon Dec 12 19:46:06 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema verdureiraCrud
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema verdureiraCrud
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `verdureiraCrud` DEFAULT CHARACTER SET utf8 ;
USE `verdureiraCrud` ;

-- -----------------------------------------------------
-- Table `verdureiraCrud`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `verdureiraCrud`.`Produto` (
  `idProduto` INT NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  `tamanho` VARCHAR(40) NOT NULL,
  `cor` VARCHAR(40) NULL,
  PRIMARY KEY (`idProduto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `verdureiraCrud`.`Fabricante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `verdureiraCrud`.`Fabricante` (
  `idFabricante` INT NOT NULL ,
  `nome` VARCHAR(255) NOT NULL,
  `idProduto` INT NOT NULL,
  PRIMARY KEY (`idFabricante`),
  INDEX `fk_Fabricante_Produto_idx` (`idProduto` ASC) ,
  CONSTRAINT `fk_Fabricante_Produto`
    FOREIGN KEY (`idProduto`)
    REFERENCES `verdureiraCrud`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

USE verdureiraCrud;