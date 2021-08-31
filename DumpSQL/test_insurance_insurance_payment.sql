-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: test_insurance
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `insurance_payment`
--

DROP TABLE IF EXISTS `insurance_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insurance_payment` (
  `payment_id` bigint NOT NULL,
  `amount_paid` decimal(19,2) DEFAULT NULL,
  `date_of_payment` date DEFAULT NULL,
  `mode_of_payment` varchar(255) DEFAULT NULL,
  `quotation_id` bigint DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance_payment`
--

LOCK TABLES `insurance_payment` WRITE;
/*!40000 ALTER TABLE `insurance_payment` DISABLE KEYS */;
INSERT INTO `insurance_payment` VALUES (180738,120000.00,'2021-08-31',NULL,465079,'Success'),(191663,NULL,'2021-08-24',NULL,NULL,'Success'),(270906,40000.00,'2021-08-25',NULL,147813,'Success'),(364487,75000.00,'2021-09-01',NULL,448263,'Success'),(415710,60000.00,'2021-08-28',NULL,937419,'Success'),(551094,90000.00,'2021-08-31',NULL,819450,'Success'),(703691,60000.00,'2021-08-28',NULL,146826,'Success'),(736076,60000.00,'2021-08-25',NULL,863756,'Success'),(743582,60000.00,'2021-08-31',NULL,201327,'Success'),(822492,20000.00,'2021-08-25',NULL,680815,'Success'),(833736,25000.00,'2021-08-31',NULL,761225,'Success'),(838391,60000.00,'2021-08-24',NULL,216588,'Success'),(952180,25000.00,'2021-08-31',NULL,165144,'Success'),(958872,60000.00,'2021-08-25',NULL,918270,'Success');
/*!40000 ALTER TABLE `insurance_payment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-01  1:23:55
