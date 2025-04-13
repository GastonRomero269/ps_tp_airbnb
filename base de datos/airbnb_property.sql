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
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `property` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `max_guests` int DEFAULT NULL,
  `price_per_night` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `host_id` bigint DEFAULT NULL,
  `rating` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKef6rf7039ccio3ht2ylr7ytr0` (`host_id`),
  CONSTRAINT `FKef6rf7039ccio3ht2ylr7ytr0` FOREIGN KEY (`host_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1,'2025-04-09','Cómodo para 2 personas','Buenos Aires, Argentina',2,100,'Casa de Campo en Palermo',1,3.8),(2,'2025-04-09','Vista al lago y chimenea','Bariloche, Argentina',4,180,'Cabaña en Bariloche',3,3.75),(3,'2025-04-09','Ideal para escapadas de fin de semana','Mendoza, Argentina',2,90,'Departamento en Mendoza',1,2.9),(4,'2025-04-09','Amplia casa con jardín','Córdoba, Argentina',5,150,'Cabaña  en Córdoba',3,4.8),(5,'2025-04-09','Pequeño pero acogedor','Salta, Argentina',2,75,'Departmento en Salta',1,4.7),(6,'2025-04-09','Ideal para escapadas de fin de semana','Lujan, Argentina',1,200,'Mansion en Lujan',3,4.9),(7,'2025-04-09','En pleno campo verde','Pilar, Argentina',4,400,'Casa particular en Pilar',1,4.1),(8,'2025-04-09','Vista al lago y chimenea','Pilar, Argentina',2,500,'Casa particular en Pilar',3,4.7),(9,'2025-04-09','Cómodo para 3 personas','Colonia Sacramento, Uruguay',3,460,'Mansion en Sacramento',1,2.7),(10,'2025-04-09','Ideal para escapadas de fin de semana','San Justo, Argentina',6,960,'Mansion en San Justo',3,1.9),(11,'2025-04-09','En pleno campo verde','Exaltacion Cruz, Argentina',3,490,'Casa de campo en Exaltacion Cruz',1,2.9),(12,'2025-04-09','Cómodo para 2 personas','Exaltacion Cruz, Argentina',6,800,'Departamento Exaltacion Cruz',3,4.8);
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
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
