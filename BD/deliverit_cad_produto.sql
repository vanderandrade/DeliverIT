CREATE DATABASE  IF NOT EXISTS `deliverit` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `deliverit`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: deliverit
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cad_produto`
--

DROP TABLE IF EXISTS `cad_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cad_produto` (
  `codProduto` int(11) NOT NULL AUTO_INCREMENT,
  `nomeProduto` varchar(45) NOT NULL,
  `precoProduto` float NOT NULL,
  `qtdEstoque` int(11) NOT NULL,
  `codCategoria` int(11) NOT NULL,
  PRIMARY KEY (`codProduto`),
  KEY `codCategoria_idx` (`codCategoria`),
  CONSTRAINT `codCategoria` FOREIGN KEY (`codCategoria`) REFERENCES `cad_categoria` (`codCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cad_produto`
--

LOCK TABLES `cad_produto` WRITE;
/*!40000 ALTER TABLE `cad_produto` DISABLE KEYS */;
INSERT INTO `cad_produto` VALUES (6,'FITINHA',888,88888,9),(7,'teste',1,123,10),(8,'Testando',123,1231,9),(9,'Testando',12311,1231,9),(10,'Testandos',12311,1231,9),(11,'Chave De Fenda',5,200,10);
/*!40000 ALTER TABLE `cad_produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-20 15:13:44
