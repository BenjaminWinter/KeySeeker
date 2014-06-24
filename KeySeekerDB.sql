SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `KeySeekerDB` ;
CREATE SCHEMA IF NOT EXISTS `KeySeekerDB` DEFAULT CHARACTER SET latin1 COLLATE latin1_german1_ci ;
USE `KeySeekerDB` ;

-- -----------------------------------------------------
-- Table `KeySeekerDB`.`ACCOUNT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `KeySeekerDB`.`ACCOUNT` ;

CREATE  TABLE IF NOT EXISTS `KeySeekerDB`.`ACCOUNT` (
  `ACCOUNT_ID` INT NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(45) NOT NULL ,
  `PASSWORD` VARCHAR(45) NOT NULL ,
  `EMAIL` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ACCOUNT_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `KeySeekerDB`.`IMAGE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `KeySeekerDB`.`IMAGE` ;

CREATE  TABLE IF NOT EXISTS `KeySeekerDB`.`IMAGE` (
  `IMAGE_ID` INT NOT NULL AUTO_INCREMENT ,
  `PATH` VARCHAR(90) NOT NULL ,
  PRIMARY KEY (`IMAGE_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `KeySeekerDB`.`ABILITY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `KeySeekerDB`.`ABILITY` ;

CREATE  TABLE IF NOT EXISTS `KeySeekerDB`.`ABILITY` (
  `ABILITY_ID` INT NOT NULL AUTO_INCREMENT ,
  `MOVESPERTURN` INT NOT NULL ,
  `ATTACK` INT NOT NULL ,
  `LIFE` INT NOT NULL ,
  PRIMARY KEY (`ABILITY_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `KeySeekerDB`.`CHARACTER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `KeySeekerDB`.`CHARACTER` ;

CREATE  TABLE IF NOT EXISTS `KeySeekerDB`.`CHARACTER` (
  `CHARACTER_ID` INT NOT NULL ,
  `NAME` VARCHAR(45) NOT NULL ,
  `IMAGE_ID` INT NULL ,
  `ABILITY_ID` INT NOT NULL ,
  `ACCOUNT_ID` INT NOT NULL ,
  PRIMARY KEY (`CHARACTER_ID`) ,
  INDEX `fk_Character_Image1` (`IMAGE_ID` ASC) ,
  INDEX `fk_Character_Ability1` (`ABILITY_ID` ASC) ,
  INDEX `fk_Character_Account1` (`ACCOUNT_ID` ASC) ,
  CONSTRAINT `fk_Character_Image1`
    FOREIGN KEY (`IMAGE_ID` )
    REFERENCES `KeySeekerDB`.`IMAGE` (`IMAGE_ID` )
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Character_Ability1`
    FOREIGN KEY (`ABILITY_ID` )
    REFERENCES `KeySeekerDB`.`ABILITY` (`ABILITY_ID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Character_Account1`
    FOREIGN KEY (`ACCOUNT_ID` )
    REFERENCES `KeySeekerDB`.`ACCOUNT` (`ACCOUNT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `KeySeekerDB`.`ITEM`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `KeySeekerDB`.`ITEM` ;

CREATE  TABLE IF NOT EXISTS `KeySeekerDB`.`ITEM` (
  `ITEM_ID` INT NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(45) NOT NULL ,
  `ABILITY_ID` INT NOT NULL ,
  PRIMARY KEY (`ITEM_ID`) ,
  INDEX `fk_Item_Ability1` (`ABILITY_ID` ASC) ,
  CONSTRAINT `fk_Item_Ability1`
    FOREIGN KEY (`ABILITY_ID` )
    REFERENCES `KeySeekerDB`.`ABILITY` (`ABILITY_ID` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
