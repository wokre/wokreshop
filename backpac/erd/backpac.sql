CREATE TABLE`member` (
    `member_id` varchar(50) NOT NULL,
    `name` VARCHAR(20) NOT NULL,
    `nick_name` VARCHAR(30) NOT NULL,
    `password` VARCHAR(30) NOT NULL,
    `mobile` VARCHAR(20) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `sex` VARCHAR(1) NULL DEFAULT NULL,
    PRIMARY KEY (`member_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE `orders` (
    `id` INT(10) UNSIGNED auto_increment NOT NULL,
    `member_id` varchar(50) NOT NULL,
    `order_number` VARCHAR(12) NOT NULL,
    `product_name` VARCHAR(100) NOT NULL,
    `payment_date` DATETIME NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;