-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: pronosticosdb
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `equipo_id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`equipo_id`),
  UNIQUE KEY `equipo_id_UNIQUE` (`equipo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (1,'Argentina'),(2,'Brasil'),(3,'Francia'),(4,'Alemania'),(5,'España'),(6,'Italia');
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participante`
--

DROP TABLE IF EXISTS `participante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participante` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `puntos` int unsigned DEFAULT NULL,
  `cantidad_aciertos` int unsigned DEFAULT NULL,
  `email` varchar(70) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `participanteID_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante`
--

LOCK TABLES `participante` WRITE;
/*!40000 ALTER TABLE `participante` DISABLE KEYS */;
INSERT INTO `participante` VALUES (1,NULL,NULL,'juanmbrubius@gmail.com','Juan Manuel Brios'),(2,NULL,NULL,'darinob@hotmail.com','Darío Espindola '),(3,NULL,NULL,'locura.87@gmail.com','Miguel Ohara'),(4,NULL,NULL,'martinmb@gmail.com','Martin Marino'),(5,NULL,NULL,'exequielxintos','Exequiel Martinez');
/*!40000 ALTER TABLE `participante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partido` (
  `partido_id` int unsigned NOT NULL AUTO_INCREMENT,
  `goles_equipo_1` tinyint unsigned NOT NULL,
  `goles_equipo_2` tinyint unsigned NOT NULL,
  `resultado` enum('GANA1','EMPATE','GANA2') NOT NULL,
  `equipo1_id` int unsigned NOT NULL,
  `equipo2_id` int unsigned NOT NULL,
  PRIMARY KEY (`partido_id`),
  UNIQUE KEY `partido_id_UNIQUE` (`partido_id`),
  KEY `equipo_id_idx` (`equipo1_id`),
  KEY `equipo2_id_idx` (`equipo2_id`),
  CONSTRAINT `equipo1_id` FOREIGN KEY (`equipo1_id`) REFERENCES `equipo` (`equipo_id`),
  CONSTRAINT `equipo2_id` FOREIGN KEY (`equipo2_id`) REFERENCES `equipo` (`equipo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
INSERT INTO `partido` VALUES (1,2,0,'GANA1',1,2),(2,3,3,'EMPATE',3,4),(3,1,3,'GANA2',5,6),(4,3,1,'GANA1',4,6),(5,4,0,'GANA1',1,5),(6,0,0,'EMPATE',2,3),(7,2,3,'GANA2',6,2),(8,3,2,'GANA1',1,3),(9,3,2,'GANA1',5,4);
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pronostico`
--

DROP TABLE IF EXISTS `pronostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pronostico` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `resultado_propuesto` enum('GANA1','EMPATE','GANA2') NOT NULL,
  `partido_id` int unsigned NOT NULL,
  `Participante_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Pronostico_Partido1_idx` (`partido_id`),
  KEY `fk_Pronostico_Participante1_idx` (`Participante_id`),
  CONSTRAINT `fk_Pronostico_Participante1` FOREIGN KEY (`Participante_id`) REFERENCES `participante` (`id`),
  CONSTRAINT `fk_Pronostico_Partido1` FOREIGN KEY (`partido_id`) REFERENCES `partido` (`partido_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pronostico`
--

LOCK TABLES `pronostico` WRITE;
/*!40000 ALTER TABLE `pronostico` DISABLE KEYS */;
INSERT INTO `pronostico` VALUES (1,'GANA1',1,1),(2,'GANA2',2,1),(3,'EMPATE',3,1),(4,'EMPATE',4,1),(5,'GANA2',5,1),(6,'GANA1',6,1),(7,'EMPATE',7,1),(8,'GANA2',8,1),(9,'EMPATE',9,1),(10,'GANA1',1,2),(11,'GANA1',2,2),(12,'GANA2',3,2),(13,'GANA2',4,2),(14,'GANA1',5,2),(15,'EMPATE',6,2),(16,'GANA2',7,2),(17,'GANA2',8,2),(18,'EMPATE',9,2),(19,'EMPATE',1,3),(20,'GANA1',2,3),(21,'GANA2',3,3),(22,'GANA2',4,3),(23,'GANA1',5,3),(24,'GANA2',6,3),(25,'GANA2',7,3),(26,'GANA2',8,3),(27,'GANA1',9,3),(28,'EMPATE',1,4),(29,'EMPATE',2,4),(30,'GANA2',3,4),(31,'GANA2',4,4),(32,'GANA2',5,4),(33,'GANA1',6,4),(34,'GANA1',7,4),(35,'GANA2',8,4),(36,'GANA1',9,4),(37,'GANA2',1,5),(38,'GANA1',2,5),(39,'GANA2',3,5),(40,'EMPATE',4,5),(41,'EMPATE',5,5),(42,'GANA2',6,5),(43,'GANA1',7,5),(44,'GANA2',8,5),(45,'GANA1',9,5);
/*!40000 ALTER TABLE `pronostico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ronda`
--

DROP TABLE IF EXISTS `ronda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ronda` (
  `numero_ronda` int unsigned NOT NULL,
  `partido_id` int unsigned NOT NULL,
  PRIMARY KEY (`numero_ronda`,`partido_id`),
  UNIQUE KEY `partido_id_UNIQUE` (`partido_id`),
  KEY `fk_Ronda_Partido1_idx` (`partido_id`),
  CONSTRAINT `fk_Ronda_Partido1` FOREIGN KEY (`partido_id`) REFERENCES `partido` (`partido_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ronda`
--

LOCK TABLES `ronda` WRITE;
/*!40000 ALTER TABLE `ronda` DISABLE KEYS */;
INSERT INTO `ronda` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,9);
/*!40000 ALTER TABLE `ronda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-28 19:38:07
