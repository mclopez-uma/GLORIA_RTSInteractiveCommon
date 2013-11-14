CREATE TABLE `gloria`.`RepObservingPlan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(255)  NOT NULL,
  `owner` INT  NOT NULL,
  `type` INT  NOT NULL,
  `user` VARCHAR(255)  NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE(`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `gloria`.`RepFile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(255)  NOT NULL,
  `type` INT  NOT NULL,
  `contentType` INT  NOT NULL,
  `date` TIMESTAMP,
  `opId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE(`uuid`),
  CONSTRAINT `fk_repfile_repobservingplan` FOREIGN KEY (`opId`) REFERENCES `RepObservingPlan` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `gloria`.`RepFileFormat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `format` INT  NOT NULL,
  `fileId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_repfileformat_repfile` FOREIGN KEY (`fileId`) REFERENCES `RepFile` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `gloria`.`Repository` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(1024)  NOT NULL,
  `cod` INT  NOT NULL,
  `connUrl` VARCHAR(2048)  NOT NULL,
  `publicUrl` VARCHAR(2048)  NOT NULL,
  `description` VARCHAR(2048)  NOT NULL,
  `active` INT  NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

