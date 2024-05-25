create database users;
use users;

CREATE TABLE `users` (
                         `user_id` int NOT NULL AUTO_INCREMENT,
                         `username` varchar(100) NOT NULL,
                         `password` varchar(500) NOT NULL,
                         `email` varchar(100) NOT NULL,
                         `mobile_number` varchar(20) NOT NULL,
                         `created_at` DATETIME DEFAULT NULL,
                         `updated_at` DATETIME null,
                         `enabled` INT not null,
                         PRIMARY KEY (`user_id`)
);
