CREATE DATABASE  IF NOT EXISTS `phxcvd19` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `phxcvd19`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: phxcvd19
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `phxswap`
--

DROP TABLE IF EXISTS `phxswap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phxswap` (
  `PkgId` int NOT NULL AUTO_INCREMENT,
  `SLICE` char(1) NOT NULL DEFAULT 'Y' COMMENT 'Y = Used in SLICE\\nN = Not used in SLICE',
  `CPD` char(1) NOT NULL DEFAULT 'N' COMMENT 'Y = Used in CPD\\nN = Not used in CPD',
  `PackageName` varchar(45) NOT NULL COMMENT 'Common name of package such as AngularJs or Drools',
  `CurrentVersion` varchar(45) NOT NULL COMMENT 'Version used in research.',
  `SwapListVersion` varchar(45) DEFAULT NULL COMMENT 'Version in swap list.',
  `PkgStatus` varchar(45) NOT NULL DEFAULT 'NO' COMMENT 'Allowed =\nNO -> Not tested yet\nTESTING\nYES ->Validated',
  `Problems` varchar(45) DEFAULT NULL COMMENT 'List any problems with this package found in testing',
  PRIMARY KEY (`PkgId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Shows the status and versions of packages as they are being tested in demo program.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phxswap`
--

LOCK TABLES `phxswap` WRITE;
/*!40000 ALTER TABLE `phxswap` DISABLE KEYS */;
INSERT INTO `phxswap` VALUES (1,'Y','N','DROOLS','drools-compiler 5.5.0',NULL,'NO',NULL),(2,'Y','N','AngularJS','AngularJS 1.3.13',NULL,'TESTING',NULL);
/*!40000 ALTER TABLE `phxswap` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-23 15:58:00
