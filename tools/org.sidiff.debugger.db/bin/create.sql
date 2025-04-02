CREATE  TABLE IF NOT EXISTS `sidiff_log_db`.`logs` (
  `round` INT NOT NULL ,
  `timestamp` TIMESTAMP NOT NULL ,
  PRIMARY KEY (`round`) ,
  UNIQUE INDEX `id_UNIQUE` (`round` ASC) )
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `sidiff_log_db`.`similarities` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `logs_round` INT NOT NULL ,
  `object_a` VARCHAR(45) NOT NULL ,
  `object_b` VARCHAR(45) NOT NULL ,
  `similarity` FLOAT NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_similarities_logs1` (`logs_round` ASC) ,
  CONSTRAINT `fk_similarities_logs1`
    FOREIGN KEY (`logs_round` )
    REFERENCES `sidiff_log_db`.`logs` (`round` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `sidiff_log_db`.`correspondences` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `logs_round` INT NOT NULL ,
  `object_a` VARCHAR(45) NOT NULL ,
  `object_b` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_matchings_logs` (`logs_round` ASC) ,
  CONSTRAINT `fk_matchings_logs`
    FOREIGN KEY (`logs_round` )
    REFERENCES `sidiff_log_db`.`logs` (`round` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `sidiff_log_db`.`events` (
  `id` INT NOT NULL ,
  `event_type` VARCHAR(45) NOT NULL ,
  `round` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `sidiff_log_db`.`matching_events` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `events_id` INT NOT NULL ,
  `event_info` VARCHAR(45) NULL ,
  `object_a` VARCHAR(45) NULL ,
  `object_b` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_matching_events_events1` (`events_id` ASC) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  UNIQUE INDEX `events_id_UNIQUE` (`events_id` ASC) ,
  CONSTRAINT `fk_matching_events_events1`
    FOREIGN KEY (`events_id` )
    REFERENCES `sidiff_log_db`.`events` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `sidiff_log_db`.`iterativematching_events` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `events_id` INT NOT NULL ,
  `event_info` VARCHAR(45) NULL ,
  `switched_matcher` VARCHAR(45) NULL ,
  `new_round_number` INT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_iterativematching_events_events1` (`events_id` ASC) ,
  UNIQUE INDEX `events_id_UNIQUE` (`events_id` ASC) ,
  CONSTRAINT `fk_iterativematching_events_events1`
    FOREIGN KEY (`events_id` )
    REFERENCES `sidiff_log_db`.`events` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `sidiff_log_db`.`similaritycalculation_events` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `events_id` INT NOT NULL ,
  `event_info` VARCHAR(45) NULL ,
  `object_a` VARCHAR(45) NULL ,
  `object_b` VARCHAR(45) NULL ,
  `compare_function` VARCHAR(45) NULL ,
  `comparison_similarity_value` FLOAT NULL ,
  `result` FLOAT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_similaritycalculation_events_events1` (`events_id` ASC) ,
  UNIQUE INDEX `events_id_UNIQUE` (`events_id` ASC) ,
  CONSTRAINT `fk_similaritycalculation_events_events1`
    FOREIGN KEY (`events_id` )
    REFERENCES `sidiff_log_db`.`events` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
