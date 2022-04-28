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
-- Table structure for table `su_kien`
--

DROP TABLE IF EXISTS `su_kien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `su_kien` (
  `idSuKien` int NOT NULL,
  `tenSuKien` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `loaiSanhSK` int NOT NULL,
  `loaiMonAnSK` int DEFAULT NULL,
  `dichVuKhac` int DEFAULT NULL,
  PRIMARY KEY (`idSuKien`),
  KEY `fk_sukien_sanhtiec_idx` (`loaiSanhSK`),
  KEY `fk_sukien_monan_idx` (`loaiMonAnSK`),
  KEY `fk_sukien_dichvu_idx` (`dichVuKhac`),
  CONSTRAINT `fk_sukien_dichvu` FOREIGN KEY (`dichVuKhac`) REFERENCES `dich_vu` (`idDichVu`),
  CONSTRAINT `fk_sukien_monan` FOREIGN KEY (`loaiMonAnSK`) REFERENCES `mon_an` (`idMonAn`),
  CONSTRAINT `fk_sukien_sanhtiec` FOREIGN KEY (`loaiSanhSK`) REFERENCES `sanh_tiec` (`idSanhTiec`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `su_kien`
--

LOCK TABLES `su_kien` WRITE;
/*!40000 ALTER TABLE `su_kien` DISABLE KEYS */;
/*!40000 ALTER TABLE `su_kien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-18 16:11:06
