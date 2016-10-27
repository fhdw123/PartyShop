-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: partyshop
-- ------------------------------------------------------
-- Server version	5.7.15-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `vorname` varchar(45) NOT NULL,
  `nachname` varchar(45) NOT NULL,
  `passwort` varchar(45) NOT NULL,
  `rolle` varchar(45) NOT NULL,
  `gesperrt` int(1) NOT NULL,
  `strasse` varchar(45) NOT NULL,
  `hausnummer` varchar(45) NOT NULL,
  `postleitzahl` int(5) NOT NULL,
  `ort` varchar(45) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `mail_UNIQUE` (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('-1295959091','g','g','g','g','kunde',0,'g','g',23,'g'),('-190832153','jajakl','jajakl','jajakl','jajakl','kunde',0,'jajakl','jajakl',8565,'jajakl'),('-447728822','bg','bg','bg','bg','kunde',0,'bg','bg',5454,'bg'),('-651817813','mn','mn','mn','mn','kunde',0,'mn','mn',65677,'mn'),('-937158728','haiaiaiiaiaia','haiaiaiiaiaia','haiaiaiiaiaia','haiaiaiiaiaia','kunde',0,'haiaiaiiaiaia','haiaiaiiaiaia',1234,'haiaiaiiaiaia'),('1457365464','ichichichich','ichichichich','ichichichich','ichichichich','kunde',0,'ichichichich','ichichichich',12345,'ichichichich'),('2028659914','df','df','df','df','kunde',0,'df','df',13243,'df'),('381758169','rtr','rtr','rtr','rtr','kunde',0,'rtr','rtr',14213,'rtr'),('403744341','f','f','f','f','kunde',0,'f','f',123131,'f'),('637607835','123','123','123','123','kunde',0,'123','123',123,'123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-27  8:47:09
