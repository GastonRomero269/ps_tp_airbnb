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
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `rating` double NOT NULL,
  `guest_id` bigint DEFAULT NULL,
  `property_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkdprhv0bus71rvfwhw2e7207t` (`guest_id`),
  KEY `FK4r8tpgi3hq2ldtvry1gh0vgo` (`property_id`),
  CONSTRAINT `FK4r8tpgi3hq2ldtvry1gh0vgo` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`),
  CONSTRAINT `FKkdprhv0bus71rvfwhw2e7207t` FOREIGN KEY (`guest_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'Excelente lugar y anfitrión muy amable.','2025-04-09',5,2,1),(2,'Muy lindo pero algo frío por las noches.','2025-04-09',4,4,2),(3,'Perfecto para desconectar un finde.','2025-04-09',5,5,3),(4,'Todo bien salvo por el WiFi.','2025-04-09',3,2,4),(5,'Agradable y tranquilo.','2025-04-09',4,4,5),(6,'Hermosa vista y entorno natural inmejorable.','2025-04-10',5,1,6),(7,'Un poco alejado del centro, pero tranquilo.','2025-04-10',4,3,7),(8,'No había agua caliente la primera noche.','2025-04-10',2,2,8),(9,'Perfecto para ir en pareja.','2025-04-10',5,4,9),(10,'Lo disfrutamos mucho, volveríamos sin dudas.','2025-04-10',5,5,10),(11,'El lugar estaba limpio y ordenado.','2025-04-10',4,1,11),(12,'Anfitrión muy atento y servicial.','2025-04-10',5,2,12),(13,'No cumplió con lo prometido en las fotos.','2025-04-10',2,3,1),(14,'Zona muy segura, ideal para familias.','2025-04-10',5,4,2),(15,'La calefacción no funcionaba bien.','2025-04-10',3,5,3),(16,'Cerca de todo y muy cómodo.','2025-04-10',5,1,4),(17,'Un poco ruidoso por la noche.','2025-04-10',3,2,5),(18,'Cabaña súper equipada y acogedora.','2025-04-10',5,3,6),(19,'Tuvimos problemas con el check-in.','2025-04-10',3,4,7),(20,'Ideal para unas vacaciones tranquilas.','2025-04-10',5,5,8),(21,'La limpieza podría mejorar.','2025-04-10',3,1,9),(22,'Todo excelente, tal como lo esperábamos.','2025-04-10',5,2,10),(23,'No había buena señal de internet.','2025-04-10',2,3,11),(24,'Espacioso y con buena ubicación.','2025-04-10',4,4,12),(25,'Volveremos el próximo verano.','2025-04-10',5,5,1),(26,'Un poco alejado del centro, pero tranquilo.','2025-04-09',5,2,1),(27,'Excelente lugar y anfitrión muy amable.','2025-04-09',5,3,2),(28,'No había agua caliente la primera noche.','2025-04-09',5,4,3),(29,'Perfecto para desconectar un finde.','2025-04-09',5,5,4),(30,'Excelente lugar y anfitrión muy amable.','2025-04-09',5,1,5),(31,'Hermosa vista y entorno natural inmejorable.','2025-04-11',4.6,1,1),(32,'Perfecto para desconectar un finde.','2025-04-11',4.6,1,1),(33,'Volveremos el próximo verano.','2025-04-11',1,1,1),(34,'No había buena señal de internet.','2025-04-13',1,1,2);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-13 16:01:42
