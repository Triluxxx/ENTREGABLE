/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19  Distrib 10.11.11-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: laboratorio_bd
-- ------------------------------------------------------
-- Server version	10.11.11-MariaDB-0+deb12u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `areas` (
  `id_area` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `laboratorista`
--

DROP TABLE IF EXISTS `laboratorista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratorista` (
  `id_laboratorista` bigint(20) NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) DEFAULT NULL,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `turno` varchar(255) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_laboratorista`),
  KEY `FKjkvldeh432oteao8iiif2aqef` (`id_usuario`),
  CONSTRAINT `FKjkvldeh432oteao8iiif2aqef` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medicos`
--

DROP TABLE IF EXISTS `medicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicos` (
  `id_medico` bigint(20) NOT NULL AUTO_INCREMENT,
  `especialidad` varchar(255) DEFAULT NULL,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_medico`),
  KEY `FKhei0g6fy15d5komevfsk1qepe` (`id_usuario`),
  CONSTRAINT `FKhei0g6fy15d5komevfsk1qepe` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `muestras`
--

DROP TABLE IF EXISTS `muestras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `muestras` (
  `id_muestra` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo_muestra` varchar(255) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `id_orden` bigint(20) NOT NULL,
  `id_tipo_muestra` bigint(20) NOT NULL,
  PRIMARY KEY (`id_muestra`),
  KEY `FKmwd05bep1y3tatfpwntx7jr73` (`id_orden`),
  KEY `FKix44v18vhay13ktuw5trow9c5` (`id_tipo_muestra`),
  CONSTRAINT `FKix44v18vhay13ktuw5trow9c5` FOREIGN KEY (`id_tipo_muestra`) REFERENCES `tipos_muestra` (`id`),
  CONSTRAINT `FKmwd05bep1y3tatfpwntx7jr73` FOREIGN KEY (`id_orden`) REFERENCES `ordenes` (`id_orden`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orden_parametro`
--

DROP TABLE IF EXISTS `orden_parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden_parametro` (
  `id_orden_parametro` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `id_orden` bigint(20) NOT NULL,
  `id_parametro` bigint(20) NOT NULL,
  PRIMARY KEY (`id_orden_parametro`),
  KEY `FKk7761mxx2jyf45vh78nkjakjp` (`id_orden`),
  KEY `FKsqr2xj9almwfoly5984os1owy` (`id_parametro`),
  CONSTRAINT `FKk7761mxx2jyf45vh78nkjakjp` FOREIGN KEY (`id_orden`) REFERENCES `ordenes` (`id_orden`),
  CONSTRAINT `FKsqr2xj9almwfoly5984os1owy` FOREIGN KEY (`id_parametro`) REFERENCES `parametros` (`id_parametro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orden_perfil`
--

DROP TABLE IF EXISTS `orden_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden_perfil` (
  `id_orden_perfil` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `id_orden` bigint(20) NOT NULL,
  `id_perfil` bigint(20) NOT NULL,
  PRIMARY KEY (`id_orden_perfil`),
  KEY `FKmy76p4n5ba667e8nbr5ixg7q4` (`id_orden`),
  KEY `FKa9a2m7lnyipjrvrsqafef3qj9` (`id_perfil`),
  CONSTRAINT `FKa9a2m7lnyipjrvrsqafef3qj9` FOREIGN KEY (`id_perfil`) REFERENCES `perfiles` (`id_perfil`),
  CONSTRAINT `FKmy76p4n5ba667e8nbr5ixg7q4` FOREIGN KEY (`id_orden`) REFERENCES `ordenes` (`id_orden`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ordenes`
--

DROP TABLE IF EXISTS `ordenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordenes` (
  `id_orden` bigint(20) NOT NULL AUTO_INCREMENT,
  `estado` enum('ANULADO','COMPLETADO','PENDIENTE','PROCESADO') DEFAULT NULL,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `tipo_orden` enum('INDIVIDUAL','PERFIL') DEFAULT NULL,
  `id_paciente` bigint(20) NOT NULL,
  `codigo_orden` varchar(30) NOT NULL,
  `id_laboratorista` bigint(20) NOT NULL,
  PRIMARY KEY (`id_orden`),
  UNIQUE KEY `UKkg305gu6d8kfjvn1dlxymanl4` (`codigo_orden`),
  KEY `FKhy1xt3e55q8vet4lta6sfl7au` (`id_paciente`),
  KEY `FKpfwjbka9867tps7c2iew0nmgj` (`id_laboratorista`),
  CONSTRAINT `FKhy1xt3e55q8vet4lta6sfl7au` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id_paciente`),
  CONSTRAINT `FKpfwjbka9867tps7c2iew0nmgj` FOREIGN KEY (`id_laboratorista`) REFERENCES `laboratorista` (`id_laboratorista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `pacientes` (
  `id_paciente` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `numero_historia` varchar(255) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_paciente`),
  KEY `FK34je9ip2cpgvy3m4ove9lmmqk` (`id_usuario`),
  CONSTRAINT `FK34je9ip2cpgvy3m4ove9lmmqk` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `parametros`
--

DROP TABLE IF EXISTS `parametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `parametros` (
  `id_parametro` bigint(20) NOT NULL AUTO_INCREMENT,
  `es_analisis` bit(1) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tipo_dato` enum('NUMBER','SELECT','TEXT') DEFAULT NULL,
  `id_unidad` bigint(20) NOT NULL,
  `id_tipo_muestra` bigint(20) NOT NULL,
  PRIMARY KEY (`id_parametro`),
  KEY `FKs5uk4ruvlpsstdybgsf8j1ehi` (`id_unidad`),
  KEY `FKrsltwroggy9hg91ujshw1n9q9` (`id_tipo_muestra`),
  CONSTRAINT `FKrsltwroggy9hg91ujshw1n9q9` FOREIGN KEY (`id_tipo_muestra`) REFERENCES `tipos_muestra` (`id`),
  CONSTRAINT `FKs5uk4ruvlpsstdybgsf8j1ehi` FOREIGN KEY (`id_unidad`) REFERENCES `unidades` (`id_unidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `perfil_parametro`
--

DROP TABLE IF EXISTS `perfil_parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil_parametro` (
  `id_perfil_parametro` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_parametro` bigint(20) NOT NULL,
  `id_perfil` bigint(20) NOT NULL,
  PRIMARY KEY (`id_perfil_parametro`),
  KEY `FKt2t6bsgmc9cwimdnsmjsspceh` (`id_parametro`),
  KEY `FKtj3sqpvt8ymh9juivwwu9ictc` (`id_perfil`),
  CONSTRAINT `FKt2t6bsgmc9cwimdnsmjsspceh` FOREIGN KEY (`id_parametro`) REFERENCES `parametros` (`id_parametro`),
  CONSTRAINT `FKtj3sqpvt8ymh9juivwwu9ictc` FOREIGN KEY (`id_perfil`) REFERENCES `perfiles` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfiles` (
  `id_perfil` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `id_area` bigint(20) NOT NULL,
  `id_tipo_muestra` bigint(20) NOT NULL,
  PRIMARY KEY (`id_perfil`),
  KEY `FKqu4ccag9q7pj97r8o997uihb0` (`id_area`),
  KEY `FKwt8f0wrn3jg5k6ryq1t11inv` (`id_tipo_muestra`),
  CONSTRAINT `FKqu4ccag9q7pj97r8o997uihb0` FOREIGN KEY (`id_area`) REFERENCES `areas` (`id_area`),
  CONSTRAINT `FKwt8f0wrn3jg5k6ryq1t11inv` FOREIGN KEY (`id_tipo_muestra`) REFERENCES `tipos_muestra` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipos_muestra`
--

DROP TABLE IF EXISTS `tipos_muestra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_muestra` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK9ljuo51221cb4ja96f31njcsr` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `unidades`
--

DROP TABLE IF EXISTS `unidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidades` (
  `id_unidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_unidad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipo_usuario` enum('ADMINISTRADOR','LABORATORISTA','MEDICO','PACIENTE') DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `valor_parametro`
--

DROP TABLE IF EXISTS `valor_parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `valor_parametro` (
  `id_valor_parametro` bigint(20) NOT NULL AUTO_INCREMENT,
  `valor` varchar(255) DEFAULT NULL,
  `id_parametro` bigint(20) NOT NULL,
  PRIMARY KEY (`id_valor_parametro`),
  KEY `FKboi2x46uc4m24ei011dt2ax0n` (`id_parametro`),
  CONSTRAINT `FKboi2x46uc4m24ei011dt2ax0n` FOREIGN KEY (`id_parametro`) REFERENCES `parametros` (`id_parametro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-03 10:45:17
