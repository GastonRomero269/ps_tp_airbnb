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
-- Table structure for table `property_image`
--

DROP TABLE IF EXISTS `property_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `property_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `uploaded_at` date DEFAULT NULL,
  `property_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8myddv2ina4svuo189ju03v9o` (`property_id`),
  CONSTRAINT `FK8myddv2ina4svuo189ju03v9o` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property_image`
--

LOCK TABLES `property_image` WRITE;
/*!40000 ALTER TABLE `property_image` DISABLE KEYS */;
INSERT INTO `property_image` VALUES (1,'argentina-1.jpeg','2025-04-09',1),(2,'argentina-2.jpeg','2025-04-09',2),(3,'argentina-3.jpeg','2025-04-09',3),(4,'argentina-4.jpeg','2025-04-09',4),(5,'argentina-5.jpeg','2025-04-09',5),(6,'argentina-6.jpeg','2025-04-09',6),(7,'argentina-7.jpeg','2025-04-09',7),(8,'argentina-8.jpeg','2025-04-09',8),(9,'argentina-9.jpeg','2025-04-09',9),(10,'argentina-10.jpeg','2025-04-09',10),(11,'argentina-11.jpeg','2025-04-09',11),(12,'argentina-12.jpeg','2025-04-09',12),(13,'argentina-1-1.jpeg','2025-04-09',1),(14,'argentina-1-2.jpeg','2025-04-09',1),(15,'argentina-1-3.jpeg','2025-04-09',1),(16,'argentina-1-4.jpeg','2025-04-09',1),(17,'argentina-2-1.jpeg','2025-04-09',2),(18,'argentina-2-2.jpeg','2025-04-09',2),(19,'argentina-2-3.jpeg','2025-04-09',2),(20,'argentina-2-4.jpeg','2025-04-09',2),(21,'argentina-3-1.jpeg','2025-04-09',3),(22,'argentina-3-2.jpeg','2025-04-09',3),(23,'argentina-3-3.jpeg','2025-04-09',3),(24,'argentina-3-4.jpeg','2025-04-09',3),(25,'argentina-4-1.jpeg','2025-04-09',4),(26,'argentina-4-2.jpeg','2025-04-09',4),(27,'argentina-4-3.jpeg','2025-04-09',4),(28,'argentina-4-4.jpeg','2025-04-09',4),(29,'argentina-5-1.jpeg','2025-04-09',5),(30,'argentina-5-2.jpeg','2025-04-09',5),(31,'argentina-5-3.jpeg','2025-04-09',5),(32,'argentina-5-4.jpeg','2025-04-09',5),(33,'argentina-6-1.jpeg','2025-04-09',6),(34,'argentina-6-2.jpeg','2025-04-09',6),(35,'argentina-6-3.jpeg','2025-04-09',6),(36,'argentina-6-4.jpeg','2025-04-09',6),(37,'argentina-7-1.jpeg','2025-04-09',7),(38,'argentina-7-2.jpeg','2025-04-09',7),(39,'argentina-7-3.jpeg','2025-04-09',7),(40,'argentina-7-4.jpeg','2025-04-09',7),(41,'argentina-8-1.jpeg','2025-04-09',8),(42,'argentina-8-2.jpeg','2025-04-09',8),(43,'argentina-8-3.jpeg','2025-04-09',8),(44,'argentina-8-4.jpeg','2025-04-09',8),(45,'argentina-9-1.jpeg','2025-04-09',9),(46,'argentina-9-2.jpeg','2025-04-09',9),(47,'argentina-9-3.jpeg','2025-04-09',9),(48,'argentina-9-4.jpeg','2025-04-09',9),(49,'argentina-10-1.jpeg','2025-04-09',10),(50,'argentina-10-2.jpeg','2025-04-09',10),(51,'argentina-10-3.jpeg','2025-04-09',10),(52,'argentina-10-4.jpeg','2025-04-09',10),(53,'argentina-11-1.jpeg','2025-04-09',11),(54,'argentina-11-2.jpeg','2025-04-09',11),(55,'argentina-11-3.jpeg','2025-04-09',11),(56,'argentina-11-4.jpeg','2025-04-09',11),(57,'argentina-12-1.jpeg','2025-04-09',12),(58,'argentina-12-2.jpeg','2025-04-09',12),(59,'argentina-12-3.jpeg','2025-04-09',12),(60,'argentina-12-4.jpeg','2025-04-09',12);
/*!40000 ALTER TABLE `property_image` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-13 16:01:41
