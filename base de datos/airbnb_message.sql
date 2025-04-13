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
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `message_text` varchar(255) DEFAULT NULL,
  `timestamp` date DEFAULT NULL,
  `property_id` bigint DEFAULT NULL,
  `receiver_id` bigint DEFAULT NULL,
  `sender_id` bigint DEFAULT NULL,
  `next_message_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe0jls8qfy50gvtwee3egcypv` (`property_id`),
  KEY `FK86f0kc2mt26ifwupnivu6v8oa` (`receiver_id`),
  KEY `FKcnj2qaf5yc36v2f90jw2ipl9b` (`sender_id`),
  KEY `FKmvnc79e0jaqmiuyls52eoxb34` (`next_message_id`),
  CONSTRAINT `FK86f0kc2mt26ifwupnivu6v8oa` FOREIGN KEY (`receiver_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKcnj2qaf5yc36v2f90jw2ipl9b` FOREIGN KEY (`sender_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKe0jls8qfy50gvtwee3egcypv` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`),
  CONSTRAINT `FKmvnc79e0jaqmiuyls52eoxb34` FOREIGN KEY (`next_message_id`) REFERENCES `message` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,'Hola Carlos, ¿está disponible la semana próxima?','2025-04-09',1,1,2,52),(2,'¿Aceptan mascotas en la cabaña?','2025-04-09',2,1,2,53),(3,'¿Tiene cochera el loft?','2025-04-09',3,1,2,54),(4,'¿Puedo hacer check-in después de las 22h?','2025-04-09',4,1,2,56),(5,'¿La zona es segura por la noche?','2025-04-09',5,1,2,49),(49,'no','2025-04-13',5,2,1,61),(52,'no','2025-04-13',1,2,1,57),(53,'si','2025-04-13',2,2,1,58),(54,'si','2025-04-13',3,2,1,59),(56,'no','2025-04-13',4,2,1,60),(57,'genial, gracias','2025-04-13',1,1,2,65),(58,'genial, gracias','2025-04-13',2,1,2,68),(59,'genial, gracias','2025-04-13',3,1,2,NULL),(60,'genial, gracias','2025-04-13',4,1,2,NULL),(61,'genial, gracias','2025-04-13',5,1,2,66),(65,'Volve pronto!','2025-04-13',1,2,1,NULL),(66,'Cualquier cosa consulta!','2025-04-13',5,2,1,NULL),(67,'Nos vemos pronto!','2025-04-13',2,3,1,NULL),(68,'Me alegra poder ayudarte','2025-04-13',2,2,1,NULL);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
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
