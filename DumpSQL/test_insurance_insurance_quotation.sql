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
-- Table structure for table `insurance_quotation`
--

DROP TABLE IF EXISTS `insurance_quotation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insurance_quotation` (
  `result_id` bigint NOT NULL,
  `county` varchar(255) DEFAULT NULL,
  `mileage` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `quotation_id` bigint DEFAULT NULL,
  `regional_class` varchar(255) DEFAULT NULL,
  `result` double DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `vehicle_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`result_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance_quotation`
--

LOCK TABLES `insurance_quotation` WRITE;
/*!40000 ALTER TABLE `insurance_quotation` DISABLE KEYS */;
INSERT INTO `insurance_quotation` VALUES (69,'','10,001-20,000 km','10623',822568,'Commercial',150000,'Berlin','Car'),(70,'','5,001 - 10,000 km','09634',216588,'Commercial',60000,'Sachsen','Truck'),(71,NULL,'5,001 - 10,000 km','25727',816654,'Private',30000,'Schleswig-Holstein','Truck'),(72,'','10,001-20,000 km','57632',918270,'Commercial',60000,'Rheinland-Pfalz','MiniVan'),(73,'Dreisamtal','5,001 - 10,000 km','79256',147813,'Private',40000,'Baden-Württemberg','Motorcycle'),(74,'Eberswalde','5,001 - 10,000 km','16227',863756,'Commercial',60000,'Brandenburg','Truck'),(75,'','0-5,000 km','69239',680815,'Private',20000,'Hessen','Motorcycle'),(76,NULL,'5,001 - 10,000 km','38112',146826,'Commercial',60000,'Niedersachsen','Truck'),(77,NULL,'10,001-20,000 km','16348',303620,'Commercial',60000,'Brandenburg','MiniVan'),(78,NULL,'10,001-20,000 km','16348',937419,'Commercial',60000,'Brandenburg','MiniVan'),(79,NULL,'5,001 - 10,000 km','22607',279423,'Private',50000,NULL,'Car'),(80,NULL,'5,001 - 10,000 km','53498',279057,'Commercial',60000,'Rheinland-Pfalz','Truck'),(81,NULL,'5,001 - 10,000 km','44263',589307,'Commercial',60000,'Nordrhein-Westfalen','Truck'),(82,NULL,'5,001 - 10,000 km','18239',913715,'Commercial',60000,'Mecklenburg-Vorpommern','Truck'),(83,NULL,'5,001 - 10,000 km','79291',276219,'Commercial',60000,NULL,'Truck'),(84,NULL,'5,001 - 10,000 km','28203',145129,'Commercial',60000,'Bremen','Truck'),(85,NULL,'5,001 - 10,000 km','79256',168166,'Commercial',60000,NULL,'Truck'),(86,NULL,'5,001 - 10,000 km','79256',937302,'Commercial',60000,NULL,'Truck'),(87,NULL,'5,001 - 10,000 km','79256',691558,'Commercial',60000,'Bayern','Truck'),(88,NULL,'above 20,000 km','44263',421922,'Commercial',200000,'Nordrhein-Westfalen','Car'),(89,NULL,'above 20,000 km','79256',465079,'Commercial',120000,NULL,'Truck'),(90,NULL,'10,001-20,000 km','09456',819450,'Commercial',90000,'Sachsen','Truck'),(91,NULL,'0-5,000 km','16348',165144,'Private',25000,'Brandenburg','Car'),(92,NULL,'10,001-20,000 km','44263',615087,'Private',75000,'Nordrhein-Westfalen','Car'),(93,'Adelebsen','0-5,000 km','38124',761225,'Private',25000,'Niedersachsen','Car'),(94,'Schorfheide','5,001 - 10,000 km','16244',201327,'Commercial',60000,'Brandenburg','Truck'),(95,'Schallstadt','10,001-20,000 km','79853',448263,'Private',75000,'Nordrhein-Westfalen','Car');
/*!40000 ALTER TABLE `insurance_quotation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-01  1:23:54
