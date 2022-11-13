drop table if exists campaign;

CREATE TABLE if not exists `mydb`.`campaign` (
                                                 `id` INT NOT NULL,
                                                 `name` VARCHAR(45) NOT NULL,
    `keywords` VARCHAR(45) NOT NULL,
    `bidAmount` INT NOT NULL,
    `campaingFund` INT NOT NULL,
    `status` TINYINT NOT NULL,
    `town` VARCHAR(45) NOT NULL,
    `radius` INT NOT NULL,
    PRIMARY KEY (`id`));