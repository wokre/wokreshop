-- MySQL Workbench Synchronization
-- Generated: 2021-11-13 22:06
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: bohyun

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE TABLE IF NOT EXISTS `homework`.`member` (
    `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL,
    `nick_name` VARCHAR(30) NOT NULL,
    `password` VARCHAR(30) NOT NULL,
    `mobile` VARCHAR(15) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `sex` VARCHAR(1) NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `homework`.`order` (
    `id` INT(10) UNSIGNED NOT NULL,
    `member_id` INT(10) UNSIGNED NOT NULL,
    `order_number` VARCHAR(12) NOT NULL,
    `product_name` VARCHAR(100) NOT NULL,
    `payment_date` DATETIME NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
