DROP DATABASE  IF EXISTS `ebook1`;
CREATE DATABASE  IF NOT EXISTS `ebook1`;
USE `ebook1`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `user` (username,password,first_name,last_name,email)
VALUES 
('paul-atreides','$2a$10$Yubn.1Azsoo603RKBLFP..oFi3rtdCShC6f8gcWNpNhAKbx/BxsMm','Paul','Atreides','Muad`Dib@gmail.com'),
('leto-ii','$2a$10$Yubn.1Azsoo603RKBLFP..oFi3rtdCShC6f8gcWNpNhAKbx/BxsMm','Leto','Atreides','GoldenPath@gmail.com');

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `role` (name)
VALUES 
('ROLE_member'),('ROLE_admin');

DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_ROLE_idx` (`role_id`),
  
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `role` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `users_roles` (user_id,role_id)
VALUES 
(1, 1),
(2, 1),
(2, 2);

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `book_user`;
CREATE TABLE `book_user` (
  `book_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`,`user_id`),
  KEY `FK_USER_idx` (`user_id`),
  FOREIGN KEY (`book_id`) 
  REFERENCES `book` (`id`) 
  ON DELETE CASCADE ON UPDATE CASCADE,
  
  FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `book` VALUES
(1,'Dune','Frank Herbert'),
(2,'Call of Cthulhu','Hovard Lovecraft'),
(3,'Marina','Carlos Ruiz Zafon'),
(4,'Angel`s Game','Carlos Ruiz Zafon'),
(5,'Java. A Beginner`s Guide','Herbert Schildt'),
(6,'Digital Fortress','Dan Brown'),
(7,'The Stainless Steel Rat','Harry Harrison'),
(8,'Solaris','Stanislaw Lem'),
(9,'The Man Who Laughs','Victor Hugo'),
(10,'The Master and Margarita','Mikhail Bulgakov'),
(11,'The Day of the Triffids','John Wyndham'),
(12,'Hotel','Arthur Hailey'),
(13,'Fahrenheit 451','Ray Bradbury'),
(14,'Flowers for Algernon','Daniel Keyes'),
(15,'The Greatest Show on Earth. The Evidence for Evolution','Richard Dawkins'),
(16,'Midnight in the Garden of Good and Evil','John Berendt'),
(17,'The Martian Chronicles','Ray Bradbury'),
(18,'Great Expectations','Charles Dickens'),
(19,'The Shadow of the Wind','Carlos Ruiz Zafon'),
(20,'Airport','Arthur Hailey');