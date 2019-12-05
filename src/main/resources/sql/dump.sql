-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sharding
-- ------------------------------------------------------
-- Server version	8.0.18

--
-- Table structure for table `dynamic`
--
create schema if not exists sharding collate utf8mb4_0900_ai_ci;

use sharding;

DROP TABLE IF EXISTS `dynamic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dynamic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dynamic`
--

LOCK TABLES `dynamic` WRITE;
/*!40000 ALTER TABLE `dynamic` DISABLE KEYS */;
INSERT INTO `dynamic` VALUES (1,1,'小黑的第一条动态'),(2,1,'小黑的第二条动态'),(3,2,'小白的第一条动态'),(4,2,'小白的第二条动态'),(5,3,'小黄的第一条动态'),(6,3,'小黄的第二条动态'),(7,4,'小红的第一条动态'),(8,4,'小红的第二条动态');
/*!40000 ALTER TABLE `dynamic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dynamic0`
--

DROP TABLE IF EXISTS `dynamic0`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dynamic0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dynamic0`
--

LOCK TABLES `dynamic0` WRITE;
/*!40000 ALTER TABLE `dynamic0` DISABLE KEYS */;
/*!40000 ALTER TABLE `dynamic0` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dynamic1`
--

DROP TABLE IF EXISTS `dynamic1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dynamic1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dynamic1`
--

LOCK TABLES `dynamic1` WRITE;
/*!40000 ALTER TABLE `dynamic1` DISABLE KEYS */;
INSERT INTO `dynamic1` VALUES (1,1,'小黑的第一条动态'),(2,1,'小黑的第二条动态');
/*!40000 ALTER TABLE `dynamic1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dynamic2`
--

DROP TABLE IF EXISTS `dynamic2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dynamic2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dynamic2`
--

LOCK TABLES `dynamic2` WRITE;
/*!40000 ALTER TABLE `dynamic2` DISABLE KEYS */;
INSERT INTO `dynamic2` VALUES (1,2,'小白的第一条动态'),(2,2,'小白的第二条动态');
/*!40000 ALTER TABLE `dynamic2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dynamic3`
--

DROP TABLE IF EXISTS `dynamic3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dynamic3` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dynamic3`
--

LOCK TABLES `dynamic3` WRITE;
/*!40000 ALTER TABLE `dynamic3` DISABLE KEYS */;
INSERT INTO `dynamic3` VALUES (1,3,'小黄的第一条动态'),(2,3,'小黄的第二条动态');
/*!40000 ALTER TABLE `dynamic3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dynamic4`
--

DROP TABLE IF EXISTS `dynamic4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dynamic4` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dynamic4`
--

LOCK TABLES `dynamic4` WRITE;
/*!40000 ALTER TABLE `dynamic4` DISABLE KEYS */;
INSERT INTO `dynamic4` VALUES (1,4,'小红的第一条动态'),(2,4,'小红的第二条动态');
/*!40000 ALTER TABLE `dynamic4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dynamic5`
--

DROP TABLE IF EXISTS `dynamic5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dynamic5` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dynamic5`
--

LOCK TABLES `dynamic5` WRITE;
/*!40000 ALTER TABLE `dynamic5` DISABLE KEYS */;
/*!40000 ALTER TABLE `dynamic5` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dynamic6`
--

DROP TABLE IF EXISTS `dynamic6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dynamic6` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dynamic6`
--

LOCK TABLES `dynamic6` WRITE;
/*!40000 ALTER TABLE `dynamic6` DISABLE KEYS */;
/*!40000 ALTER TABLE `dynamic6` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dynamic7`
--

DROP TABLE IF EXISTS `dynamic7`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dynamic7` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dynamic7`
--

LOCK TABLES `dynamic7` WRITE;
/*!40000 ALTER TABLE `dynamic7` DISABLE KEYS */;
/*!40000 ALTER TABLE `dynamic7` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dynamic8`
--

DROP TABLE IF EXISTS `dynamic8`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dynamic8` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dynamic8`
--

LOCK TABLES `dynamic8` WRITE;
/*!40000 ALTER TABLE `dynamic8` DISABLE KEYS */;
/*!40000 ALTER TABLE `dynamic8` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dynamic9`
--

DROP TABLE IF EXISTS `dynamic9`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dynamic9` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dynamic9`
--

LOCK TABLES `dynamic9` WRITE;
/*!40000 ALTER TABLE `dynamic9` DISABLE KEYS */;
/*!40000 ALTER TABLE `dynamic9` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_record`
--

DROP TABLE IF EXISTS `login_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='登录记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_record`
--

LOCK TABLES `login_record` WRITE;
/*!40000 ALTER TABLE `login_record` DISABLE KEYS */;
INSERT INTO `login_record` VALUES (1,1,'2019-12-02 07:05:30'),(2,2,'2019-12-02 06:05:40'),(3,3,'2019-12-02 07:06:06');
/*!40000 ALTER TABLE `login_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `avatar` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'小黑','kjdaksidfskfla',1,NULL),(2,'小白','djakfjsiiej',1,NULL),(3,'小黄','djakdjflaksjfskj',1,NULL),(4,'小红','dalkjfklkasjfl',1,NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-05 14:36:54
