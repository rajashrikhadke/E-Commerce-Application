-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: ecommerce
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `prodId` int NOT NULL,
  `prodName` varchar(50) NOT NULL,
  `prodDesc` varchar(255) DEFAULT NULL,
  `prodPrice` decimal(10,2) NOT NULL,
  `prodQuant` int NOT NULL,
  PRIMARY KEY (`prodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (101,' Apple MacBook 2020','8 GB RAM, 256 SSD',85000.00,5),(102,' One Plus Mobile',' 16 GB RAM, 128 GB Storage',37500.00,3),(103,' LG Android TV',' LG 55 Inch LED Ultra HD',58999.00,4),(104,' Redmi Smart TV','32 Inch HD TV with 20W Powerful Audio',16499.00,2),(105,' Samsung Galaxy S22 Ultra 5G Mobile',' 12 GB RAM, 128 GB Storage',74999.00,6),(106,' One Plus Y1S Android TV ','43 Inch Full HD LED Smart Android TV With Android 11 and Bazel-Less Frame',24999.00,3),(107,' SONY  Speakers','SONY HT-S20R with Dolby Digital, Subwoofer, Rear Speakers,400W Bluetooth Soundbar',15990.00,7),(108,' boAt Bluetooth Speaker',' boAt Stone 350 10 W Bluetooth Speakers',1697.00,5),(109,' Xiaomi Mi Band 6','1.56 inch Full Touch Screen Fitness Band,5ATM Waterproof,Wireless connection: Bluetooth 5.0(Black)',3500.00,3),(110,' Noise Colorfit Icon Buzz Smartwatch ','1.69 Inch TFT LCD Display, Bluetooth Calling, 9 Sports Modes',1799.00,4);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-20 21:50:25
