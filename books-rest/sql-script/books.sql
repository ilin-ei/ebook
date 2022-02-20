DROP DATABASE IF EXISTS `books`;
CREATE DATABASE IF NOT EXISTS `books`;
USE `books`;

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

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