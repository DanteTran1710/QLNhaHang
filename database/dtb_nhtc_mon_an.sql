-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: dtb_nhtc
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
-- Table structure for table `mon_an`
--

DROP TABLE IF EXISTS `mon_an`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mon_an` (
  `idMonAn` int NOT NULL AUTO_INCREMENT,
  `tenMonAn` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `giaMonAn` decimal(10,0) NOT NULL DEFAULT '0',
  `maLoaiMon` int NOT NULL,
  `anhMonAn` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idMonAn`),
  KEY `fk_monan_loaimon_idx` (`maLoaiMon`),
  CONSTRAINT `fk_monan_loaimon` FOREIGN KEY (`maLoaiMon`) REFERENCES `loai_mon` (`idLoaiMon`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mon_an`
--

LOCK TABLES `mon_an` WRITE;
/*!40000 ALTER TABLE `mon_an` DISABLE KEYS */;
INSERT INTO `mon_an` VALUES (1,'Chả mực bao hạnh nhân',245000,1,NULL),(2,'Chả tôm hạt điều',230000,1,NULL),(3,'Gỏi ngó sen',220000,1,NULL),(4,'Gỏi mực kiểu Thái',285000,1,NULL),(5,'Gỏi tai heo',240000,1,'https://res.cloudinary.com/dguzlcoru/image/upload/v1640354582/md6ydubd7rvkuaqanbgd.jpg'),(6,'Gỏi tôm thịt',270000,1,NULL),(7,'Súp cua',270000,1,NULL),(8,'Súp gà xé',210000,1,NULL),(9,'Súp hải sản',230000,1,NULL),(10,'Salad rau củ',170000,1,'https://res.cloudinary.com/dguzlcoru/image/upload/v1640354582/md6ydubd7rvkuaqanbgd.jpg'),(11,'Salad hải sản',200000,1,NULL),(12,'Salad táo tôm',180000,1,'https://res.cloudinary.com/dguzlcoru/image/upload/v1640354582/md6ydubd7rvkuaqanbgd.jpg'),(13,'Khoai tây chiên',150000,1,NULL),(14,'Khoai lang chiên',130000,1,NULL),(15,'Gà hấp lá chanh',365000,2,NULL),(16,'Gà ta rang muối',365000,2,NULL),(17,'Gà cuộn đút lò phô mai',390000,2,NULL),(18,'Gà bó xôi',350000,2,NULL),(19,'Gà ta quay mật ong',370000,2,NULL),(20,'Bò lúc lắc khoai tây',430000,2,NULL),(21,'Bò sốt tiêu đen - Bánh bao',470000,2,NULL),(22,'Bò xào thiên lý',415000,2,NULL),(23,'Bò hầm quế chi',300000,2,NULL),(24,'Bò hầm vang đỏ - Bánh mì',390000,2,NULL),(25,'Vịt quay',300000,2,NULL),(26,'Heo quay',270000,2,NULL),(27,'Cá tầm nướng riềng mẻ',370000,2,NULL),(28,'Cá điêu hồng chiên xù Tứ Xuyên',340000,2,NULL),(29,'Cá song hấp xì dầu',315000,2,NULL),(30,'Cá hồi bỏ lò sốt kem tươi',390000,2,NULL),(31,'Cá lăng hấp nấm',350000,2,NULL),(32,'Cơm tám Thái',240000,2,NULL),(33,'Cơm chiên dương châu',220000,2,NULL),(34,'Cơm chiên hải sản',250000,2,NULL),(35,'Tôm sú sốt me',335000,2,NULL),(36,'Tôm sú hấp trái dừa',335000,2,NULL),(37,'Xôi xéo mỡ hành',230000,2,NULL),(38,'Xôi cúc',230000,2,NULL),(39,'Lấu nấm hải sản',650000,2,NULL),(40,'Lẩu thái - Bún',530000,2,NULL),(41,'Lẩu uyên ương - Bún',550000,2,NULL),(42,'Lẩu cá bóp - Bún',615000,2,NULL),(43,'Lẩu Hokkaido - Mì Udon',700000,2,NULL),(44,'Lẩu gà - Bún',500000,2,NULL),(45,'Lẩu cua hai miền - Bún',630000,2,NULL),(46,'Trái cây theo mùa',200000,3,NULL),(47,'Rau cau uyên ương',110000,3,NULL),(48,'Chè củ năng tuyết nhĩ',125000,3,NULL),(49,'Chè sen long nhãn',150000,3,NULL),(50,'Chè Hồng Kông',170000,3,NULL),(51,'Kem Panna Cotta',250000,3,NULL),(52,'Bánh mousse dâu',245000,3,NULL),(53,'Bánh phô mai nướng sốt dâu rừng',270000,3,NULL),(54,'Bánh Passion Cheese',230000,3,NULL),(55,'Nước ngọt CocaCola',180000,4,NULL),(56,'Nước ngọt Pepsi',180000,4,NULL),(57,'Nước khoáng',75000,4,NULL),(58,'Sting',190000,4,NULL),(59,'Bò húc',230000,4,NULL),(60,'Bia Tiger xanh',380000,4,NULL),(61,'Bia Sài Gòn Lager',240000,4,NULL),(62,'Bia Heineken',440000,4,NULL),(63,'Bia Budweiser',410000,4,NULL),(64,'Bia Sapporo Blue Cap',310000,4,NULL),(65,'Xôi xéo NHTC',150000,2,'https://res.cloudinary.com/dguzlcoru/image/upload/v1640356527/d9nkyilfdxbe6aeioh37.jpg');
/*!40000 ALTER TABLE `mon_an` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-18 16:11:05
