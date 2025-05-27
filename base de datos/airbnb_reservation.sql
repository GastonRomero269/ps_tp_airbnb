-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: airbnb
-- ------------------------------------------------------
-- Server version	9.2.0

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
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `status` enum('CANCELLED','CONFIRMED','PENDING') DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `guest_id` bigint DEFAULT NULL,
  `property_id` bigint DEFAULT NULL,
  `cantity_guests` int NOT NULL,
  `type_guest_id` bigint DEFAULT NULL,
  `method_pay` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaa0dx3r0k84a9iqffl3me67xa` (`guest_id`),
  KEY `FKc1js26be8wn824r1uhmpfe7qk` (`property_id`),
  KEY `FK7ii2te2jpj92w4wr7tb047dns` (`type_guest_id`),
  CONSTRAINT `FK7ii2te2jpj92w4wr7tb047dns` FOREIGN KEY (`type_guest_id`) REFERENCES `type_guests` (`id`),
  CONSTRAINT `FKaa0dx3r0k84a9iqffl3me67xa` FOREIGN KEY (`guest_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKc1js26be8wn824r1uhmpfe7qk` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,'2025-05-13','2025-06-09','2025-06-08','CONFIRMED',100,2,1,2,35,'Tarjeta Credito'),(2,'2025-04-09','2025-04-21','2025-04-14','CONFIRMED',1260,4,2,1,2,'Tarjeta Credito'),(3,'2025-04-09','2025-04-12','2025-04-10','CONFIRMED',180,5,3,1,3,'Tarjeta Credito'),(4,'2025-04-09','2025-05-04','2025-04-29','CANCELLED',750,2,4,1,4,'Tarjeta Credito'),(5,'2025-04-09','2025-04-18','2025-04-16','CONFIRMED',150,4,5,1,5,'Tarjeta Credito'),(6,'2025-04-11','2025-04-21','2025-04-16','CONFIRMED',275,1,2,1,6,'Tarjeta Credito'),(7,'2025-04-11','2025-04-21','2025-04-16','CANCELLED',100,2,3,1,7,'Tarjeta Credito'),(8,'2025-04-11','2025-04-21','2025-04-16','CONFIRMED',160,1,4,1,8,'Tarjeta Credito'),(9,'2025-04-11','2025-04-21','2025-04-16','CONFIRMED',400,4,5,1,9,'Tarjeta Credito'),(10,'2025-04-11','2025-04-21','2025-04-16','CANCELLED',480,2,3,1,10,'Tarjeta Credito'),(11,'2025-04-11','2025-04-18','2025-04-11','CONFIRMED',700,1,1,1,11,'Tarjeta Credito'),(12,'2025-04-11','2025-04-30','2025-04-25','CONFIRMED',500,1,1,1,12,'Tarjeta Credito'),(13,'2025-04-11','2025-05-03','2025-05-01','CONFIRMED',200,1,1,2,13,'Tarjeta Credito'),(14,'2025-04-11','2025-05-05','2025-05-04','CONFIRMED',100,1,1,1,14,'Tarjeta Credito'),(15,'2025-04-11','2025-05-07','2025-05-06','CONFIRMED',100,1,1,1,15,'Tarjeta Credito'),(16,'2025-04-12','2025-04-13','2025-04-12','CONFIRMED',180,1,2,4,16,'Tarjeta Credito'),(17,'2025-04-12','2025-05-09','2025-05-08','CONFIRMED',100,1,1,0,17,'Tarjeta Credito'),(18,'2025-04-12','2025-05-11','2025-05-10','CONFIRMED',100,1,1,0,18,'Tarjeta Credito'),(19,'2025-04-12','2025-05-13','2025-05-12','CONFIRMED',100,1,1,0,19,'Tarjeta Credito'),(20,'2025-04-12','2025-05-15','2025-05-14','CONFIRMED',100,1,1,0,20,'Tarjeta Credito'),(21,'2025-04-12','2025-05-17','2025-05-16','CONFIRMED',100,1,1,0,21,'Tarjeta Credito'),(22,'2025-04-13','2025-04-14','2025-04-13','CONFIRMED',800,1,12,0,22,'Tarjeta Credito'),(23,'2025-05-13','2026-06-03','2026-06-02','CONFIRMED',100,2,1,2,37,'Tarjeta Credito'),(24,'2025-05-13','2027-05-03','2027-05-02','CONFIRMED',500,2,8,2,36,'Tarjeta Credito'),(25,'2025-05-13','2025-05-23','2025-05-21','CONFIRMED',200,2,1,0,25,'Tarjeta Credito'),(26,'2025-05-13','2025-05-29','2025-05-27','CONFIRMED',300,2,4,0,26,'Tarjeta Credito'),(27,'2025-05-13','2025-05-20','2025-05-18','CONFIRMED',200,2,1,0,28,'Tarjeta Credito'),(28,'2025-05-13','2025-05-26','2025-05-24','CONFIRMED',200,2,1,0,29,'Tarjeta Credito'),(29,'2025-05-13','2025-05-30','2025-05-29','CONFIRMED',100,2,1,0,30,'Tarjeta Credito'),(30,'2025-05-13','2025-06-01','2025-05-31','CONFIRMED',100,2,1,0,31,'Tarjeta Credito'),(31,'2025-05-13','2025-06-03','2025-06-02','CONFIRMED',100,2,1,1,32,'Tarjeta Credito'),(32,'2025-05-13','2025-06-05','2025-06-04','CONFIRMED',100,2,1,0,33,'Tarjeta Credito'),(33,'2025-05-13','2025-06-07','2025-06-06','CONFIRMED',100,2,1,2,34,'Tarjeta Credito'),(34,'2025-05-27','2025-05-28','2025-05-27','CONFIRMED',800,2,12,6,38,'Tarjeta Credito'),(35,'2025-05-27','2025-05-28','2025-05-27','CONFIRMED',500,2,8,2,39,'Tarjeta Credito'),(36,'2025-05-27','2025-05-28','2025-05-27','CONFIRMED',490,2,11,3,40,'Tarjeta Credito');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-27 20:42:07
