-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
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
  `PackageName` varchar(45) NOT NULL DEFAULT 'none' COMMENT 'Common name of package such as AngularJs or Drools',
  `CurrentVersion` varchar(45) NOT NULL DEFAULT '0' COMMENT 'Version used in research.',
  `SwapListVersion` varchar(45) DEFAULT NULL COMMENT 'Version in swap list.',
  `PkgStatus` varchar(45) NOT NULL DEFAULT 'NO' COMMENT 'Allowed =\nNO -> Not tested yet\nTESTING\nYES ->Validated',
  `Problems` varchar(500) DEFAULT 'none' COMMENT 'List any problems with this package found in testing',
  `url` varchar(25) DEFAULT '/home' COMMENT 'url for cots page.',
  PRIMARY KEY (`PkgId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Shows the status and versions of packages as they are being tested in demo program.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phxswap`
--

LOCK TABLES `phxswap` WRITE;
/*!40000 ALTER TABLE `phxswap` DISABLE KEYS */;
INSERT INTO `phxswap` VALUES (1,'Y','N','DROOLS','drools-compiler 5.5.0','1','drools.png','Overview. Drools is a Business Rules Management System (BRMS) solution. It provides a core Business Rules Engine (BRE), a web authoring and rules management application (Drools Workbench), full runtime support for Decision Model and Notation (DMN) models at Conformance level 3 and an Eclipse IDE plugin for core development.. Drools is open source software, released under the Apache License 2.0.','/drools'),(2,'Y','N','AngularJS','AngularJS 1.3.13','1','angular.jpeg','AngularJS was designed from ground up to be testable. It encourages behavior-view separation, comes pre-bundled with mocks, and takes full advantage of dependency injection. It also comes with end-to-end scenario runner which eliminates test flakiness by understanding the inner workings of AngularJS.','/angular'),(3,'Y','N','Bootstrap','Bootstrap 3.3.1','Bootstrap 3.3.5-6','bootstrap.png','Bootstrap. Build responsive, mobile-first projects on the web with the world\'s most popular front-end component library. Bootstrap is an open source toolkit for developing with HTML, CSS, and JS. Quickly prototype your ideas or build your entire app with our Sass variables and mixins, responsive grid system, extensive prebuilt components, and ...','/bootstrap'),(4,'N','Y','Bootstrap','Bootstrap 3.3.6','Bootstrap 3.3.6','bootstrap.png','Bootstrap. Build responsive, mobile-first projects on the web with the world\'s most popular front-end component library. Bootstrap is an open source toolkit for developing with HTML, CSS, and JS. Quickly prototype your ideas or build your entire app with our Sass variables and mixins, responsive grid system, extensive prebuilt components, and ...','/bootstrap'),(5,'Y','N','Java 7','Java 1.7.0_191 (Oracle JDK)','Java 1.7.0_191 (Oracle JDK)','java.png','Java is a general-purpose programming language that is class-based, object-oriented, and designed to have as few implementation dependencies as possible. It is intended to let application developers write once, run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation. Java applications are typically compiled to bytecode ...','/java'),(6,'N','Y','Java 8','Java 1.8.0_172 (Oracle JDK)','Java 1.8.0_172 (Oracle JDK)','java.png','Java is a general-purpose programming language that is class-based, object-oriented, and designed to have as few implementation dependencies as possible. It is intended to let application developers write once, run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation. Java applications are typically compiled to bytecode ...','/java'),(7,'Y','N','Apache Tomcat','Apache Tomcat 7.0.81','1','tomcat8.png','The Apache Tomcat software is developed in an open and participatory environment and released under the Apache License version 2. The Apache Tomcat project is intended to be a collaboration of the best-of-breed developers from around the world. We invite you to participate in this open development project.','/tomcat'),(8,'N','Y','Apache Tomcat','Apache Tomcat 8.0.30','1','tomcat8.png','The Apache Tomcat software is developed in an open and participatory environment and released under the Apache License version 2. The Apache Tomcat project is intended to be a collaboration of the best-of-breed developers from around the world. We invite you to participate in this open development project.','/tomcat'),(9,'Y','N','MySQL','mysql-connector-java 5.1.31','mysql-connector-java 5.1.31','mysql.png','MySQL is a database system that runs on a server. MySQL is ideal for both small and large applications. MySQL is very fast, reliable, and easy to use. MySQL uses standard SQL. MySQL compiles on a number of platforms. MySQL is free to download and use. MySQL is developed, distributed, and supported by Oracle Corporation.','/sql'),(10,'N','Y','MySQL','mysql-connector-java 5.1.37','1','mysql.png','MySQL is a database system that runs on a server. MySQL is ideal for both small and large applications. MySQL is very fast, reliable, and easy to use. MySQL uses standard SQL. MySQL compiles on a number of platforms. MySQL is free to download and use. MySQL is developed, distributed, and supported by Oracle Corporation.','/sql'),(11,'Y','N','JBoss','jboss-transactions-api 1.2 spec-1.0.0','1','jboss.jpeg','Overview. Drools is a Business Rules Management System (BRMS) solution. It provides a core Business Rules Engine (BRE), a web authoring and rules management application (Drools Workbench), full runtime support for Decision Model and Notation (DMN) models at Conformance level 3 and an Eclipse IDE plugin for core development.. Drools is open source software, released under the Apache License 2.0.','/jboss'),(16,'N','Y','AngularJs','AngularJs 1.5.0','AngularJs 1.5.0','angular.jpeg','AngularJS was designed from ground up to be testable. It encourages behavior-view separation, comes pre-bundled with mocks, and takes full advantage of dependency injection. It also comes with end-to-end scenario runner which eliminates test flakiness by understanding the inner workings of AngularJS.','/angular'),(17,'Y','N','RESTful Web Services','Version A','1','rest.png','What Are RESTful Web Services? RESTful web services are built to work best on the Web. Representational State Transfer (REST) is an architectural style that specifies constraints, such as the uniform interface, that if applied to a web service induce desirable properties, such as performance, scalability, and modifiability, that enable services to work best on the Web.','/rest'),(18,'N','Y','RESTful Web Services','Version B','1','rest.png','What Are RESTful Web Services? RESTful web services are built to work best on the Web. Representational State Transfer (REST) is an architectural style that specifies constraints, such as the uniform interface, that if applied to a web service induce desirable properties, such as performance, scalability, and modifiability, that enable services to work best on the Web.','/rest'),(19,'Y','Y','Hibernate','hibernate-jpa-2.1-api 1.0.0','hibernate-jpa-2.1-api 1.0.0','hibernate.jpeg','Hibernate is a popular Object Relational Mapping (ORM) framework that aims at simplifying database programming for developers. Hibernate was developed before JPA. And after JPA becomes a standard, Hibernate restructures itself to become an implementation of JPA. The Hibernate framework consists of several components: Hibernate ORM, Hibernate ...','/hibernate'),(20,'Y','N','POI','poi-3.9','poi-3.17','poi.png','Apache POI, a project run by the Apache Software Foundation, and previously a sub-project of the Jakarta Project, provides pure Java libraries for reading and writing files in Microsoft Office formats, such as Word, PowerPoint and Excel. ','/poi'),(21,'Y','N','JPA','hibernate-jpa-2.1-api 1.0.0','hibernate-jpa-2.1-api 1.0.0','jpa.png','Any enterprise application performs database operations by storing and retrieving vast amounts of data. Despite all the available technologies for storage management, application developers normally struggle to perform database operations efficiently.','/jpa');
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

-- Dump completed on 2020-05-20 22:00:36
