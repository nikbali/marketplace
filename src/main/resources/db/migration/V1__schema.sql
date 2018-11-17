CREATE DATABASE  IF NOT EXISTS `hackaton`
USE `hackaton`;

-- порядок важен
DROP TABLE IF EXISTS `operation`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `user_roles`;
DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `partner`;
DROP TABLE IF EXISTS `tag_client`;
DROP TABLE IF EXISTS `tag`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(40) NOT NULL,
  `password` varchar(100) NOT NULL,
  `fio` varchar(200) NULL,
  `card_number` bigint(20) NULL,
  `balance` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_users_username` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_roles_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_roles_role_id` (`role_id`),
  CONSTRAINT `fk_user_roles_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `fk_user_roles_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) NOT NULL,
  `okved` varchar(20) DEFAULT '47.9',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `partner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `account_number` bigint(20) NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_users_username` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(140) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `amount` double DEFAULT  NULL,
  `image1` varchar(2000) DEFAULT NULL,
  `image2` varchar(2000) DEFAULT NULL,
  `partner_id` bigint(20) DEFAULT NULL,
  `tag_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Partner` FOREIGN KEY (`partner_id`) REFERENCES `partner`(`id`),
  CONSTRAINT `FK_Tag` FOREIGN KEY (`tag_id`) REFERENCES `tag`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `operation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Product` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`),
  CONSTRAINT `FK_User`    FOREIGN KEY (`user_id`) REFERENCES `users`(`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `tag_client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_User_MM`   FOREIGN KEY (`user_id`) REFERENCES `users`(`id`),
  CONSTRAINT `FK_Tag_MM`    FOREIGN KEY (`tag_id`) REFERENCES `tag`(`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT IGNORE INTO roles(name) VALUES('ROLE_USER');
INSERT IGNORE INTO roles(name) VALUES('ROLE_ADMIN');