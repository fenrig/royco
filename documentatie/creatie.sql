CREATE TABLE `project_jee_2015`.`Filiaal` ( `fnr` INT NOT NULL AUTO_INCREMENT , `fnaam` VARCHAR(256) NOT NULL , PRIMARY KEY (`fnr`)) ENGINE = InnoDB;

CREATE TABLE `project_jee_2015`.`Persoon` ( `pnr` INT NOT NULL AUTO_INCREMENT , `pvoornaam` VARCHAR(256) NOT NULL , `pachternaam` VARCHAR(256) NOT NULL , PRIMARY KEY (`pnr`)) ENGINE = InnoDB;

ALTER TABLE `Persoon` ADD `username` VARCHAR(256) NOT NULL AFTER `pachternaam`, ADD `userpass` VARCHAR(20) NOT NULL AFTER `username`, ADD `usergroup` VARCHAR(100) NOT NULL AFTER `userpass`, ADD UNIQUE (`username`); 

CREATE TABLE `project_jee_2015`.`Werknemer` ( `wnr` INT NOT NULL AUTO_INCREMENT , `pnr` INT NOT NULL , `fnr` INT NOT NULL , PRIMARY KEY (`wnr`)) ENGINE = InnoDB;

ALTER TABLE `Werknemer` ADD INDEX(`fnr`); 

ALTER TABLE `Werknemer` ADD INDEX(`wnr`); 

CREATE TABLE `project_jee_2015`.`Adres` ( `anr` INT NOT NULL AUTO_INCREMENT , `straatnaam` VARCHAR(256) NOT NULL , `straatnr` VARCHAR(10) NOT NULL , `postcode` INT NOT NULL , PRIMARY KEY (`anr`)) ENGINE = InnoDB; 

CREATE TABLE `project_jee_2015`.`Klant` ( `knr` INT NOT NULL AUTO_INCREMENT , `pnr` INT NOT NULL , `fnr` INT NOT NULL , `anr` INT NOT NULL , PRIMARY KEY (`knr`), INDEX (`pnr`), INDEX (`fnr`), INDEX (`anr`)) ENGINE = InnoDB; 

CREATE TABLE `project_jee_2015`.`Lening` ( `lnr` INT NOT NULL , `anr` INT NOT NULL , `knr` INT NOT NULL , `interest` DOUBLE NOT NULL , `saldo` DOUBLE NOT NULL , PRIMARY KEY (`lnr`), INDEX (`anr`), INDEX (`knr`)) ENGINE = InnoDB;

ALTER TABLE `Lening` CHANGE `lnr` `lnr` INT(11) NOT NULL AUTO_INCREMENT;

CREATE TABLE `project_jee_2015`.`Vaste Lening` ( `vastnr` INT NOT NULL , `lnr` INT NOT NULL , PRIMARY KEY (`vastnr`), UNIQUE (`lnr`)) ENGINE = InnoDB; 

ALTER TABLE `Vaste Lening` CHANGE `vastnr` `vastnr` INT(11) NOT NULL AUTO_INCREMENT; 

CREATE TABLE `project_jee_2015`.`Variabele Lening` ( `varnr` INT NOT NULL , `lnr` INT NOT NULL , `maxrente` DOUBLE NOT NULL , PRIMARY KEY (`varnr`), UNIQUE (`lnr`)) ENGINE = InnoDB; 

ALTER TABLE `Variabele Lening` CHANGE `varnr` `varnr` INT(11) NOT NULL AUTO_INCREMENT; 
