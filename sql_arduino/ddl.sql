CREATE TABLE IF NOT EXISTS users(
    `user_id` INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `dpi` VARCHAR(13) NOT NULL UNIQUE,
    `birthdate` DATETIME NOT NULL,
    `genre` ENUM('M', 'F', 'ND') NOT NULL,
    `password` VARCHAR(60) NOT NULL,
    `active` TINYINT(1) DEFAULT 1,
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS `visits`(
    `visit_id` INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `user_id` INTEGER UNSIGNDED NOT NULL,
    `date_of_visit` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT `visitor`
        FOREIGN KEY (`user_id`) REFERENCES users (`user_id`)
        ON DELETE NO ACTION
        ON UPDATE CASCADE
);

ALTER TABLE visits
ADD active TINYINT(1) NOT NULL DEFAULT 1;

INSERT INTO users (name, dpi, birthdate, genre, password) VALUES (?, ?, ?, ?, ?);

INSERT INTO visits (user_id) VALUES ( SELECT user_id FROM users WHERE user_id = ? );