-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: partyshop
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
  `passwort` varchar(600) NOT NULL,
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
INSERT INTO `user` VALUES ('713ca7db-ba0d-4feb-bb57-e1eb3ef5bbfd','leon','Leon','Olfert','1ff86efe1360dfac85ba20cc152a436e74b21c5099dc56228e2842b239d1a33b1cbbc9f40d7d45a899f5ed7607ac8a99ba0b60d7cd3ccf6758b29a09137bd93c','kunde',0,'Carlo-Mierendorff-Str., 6a','Carlo-Mierendorff-Str.',33615,'Bielefeld'),('920541e1-41a0-4cdd-a5b3-c16db041f263','leon.ol95@googlemail.com','Leon','Olfert','1ff86efe1360dfac85ba20cc152a436e74b21c5099dc56228e2842b239d1a33b1cbbc9f40d7d45a899f5ed7607ac8a99ba0b60d7cd3ccf6758b29a09137bd93c','kunde',0,'Carlo-Mierendorff-Str., 6a','Carlo-Mierendorff-Str.',33615,'Bielefeld');
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

-- Dump completed on 2016-11-13 12:51:17
