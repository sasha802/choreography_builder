-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: localhost    Database: dance_builder
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.16.04.1

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
-- Table structure for table `dance_type`
--

DROP TABLE IF EXISTS `dance_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dance_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `beats_per_minute` int(11) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dance_type`
--

LOCK TABLES `dance_type` WRITE;
/*!40000 ALTER TABLE `dance_type` DISABLE KEYS */;
INSERT INTO `dance_type` VALUES (1,'Rumba',95,'2018-09-17 12:11:00','2018-09-17 12:11:00',_binary '\0'),(2,'Waltz',85,'2018-09-17 12:30:06','2018-09-17 12:30:06',_binary '\0'),(3,'Swing',150,'2018-09-17 12:30:29','2018-09-17 12:30:29',_binary '\0');
/*!40000 ALTER TABLE `dance_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `name` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'2018-09-17 12:06:57','2018-09-17 12:06:57',_binary '\0','user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `step`
--

DROP TABLE IF EXISTS `step`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `step` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `lead_description` varchar(10000) NOT NULL,
  `follower_description` varchar(1000) NOT NULL,
  `demo_link` varchar(10000) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `dance_type_id` int(11) NOT NULL,
  `level` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `step_dance_type` (`dance_type_id`),
  CONSTRAINT `step_dance_type` FOREIGN KEY (`dance_type_id`) REFERENCES `dance_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `step`
--

LOCK TABLES `step` WRITE;
/*!40000 ALTER TABLE `step` DISABLE KEYS */;
INSERT INTO `step` VALUES (16,'Basic','Chasse to side - LRL, Chasse to side - RLR, Left foot back, away from partner, Replace weight to right foot','Chasse to side - RLR, Chasse to side - LRL, Right foot back away from partner, Replace weight to left foot.',NULL,'2018-10-17 23:04:49','2018-10-17 23:04:49',_binary '\0',3,'basic'),(17,'Throwout','Compact chasse to side - LRL - ended with left foot forward, Chasse to side - RLR, Left foot back away from partner, Replace weight to right foot','Chasse forward or 3 forward passing steps in promenade position - RLR, Right foot back away from partner, \nReplace weight to left foot',NULL,'2018-10-17 23:09:43','2018-10-17 23:09:43',_binary '\0',3,'basic'),(18,'Link','Compact chasse forward, LRL. Chasse to side & slightly back in fallaway position, RLR. Left foot back in fallaway position. \n    Replace weight to right foot in promenade position.','Chasse forward towards man\'s right side, RLR. Chasse to side & slightly back in fallaway position, LRL. Right foot back in fallaway position. \n    Replace weight to left foot in promenade position.',NULL,'2018-10-17 23:18:35','2018-10-17 23:18:35',_binary '\0',3,'basic'),(19,'Underarm Turn to R','Chasse to side, LRL. Chasse to side, RLR, ended in open facing position. Left foot back, away from partner. Replace weight to right foot.','Chasse to side, RLR, ended forward. Chasse to side, LRL, ended in open facing position. Right foot back. Replace weight to left foot.',NULL,'2018-10-17 23:22:08','2018-10-17 23:22:08',_binary '\0',3,'basic'),(20,'Underarm Turn to L.','Chasse to side, LRL. Chasse to side, RLR. Left foot back, away from partner. Replace weight to right foot.','Chasse to side, ended back. RLR. Chasse to side, LRL. Right foot back, away from partner. Replace weight to left foot.',NULL,'2018-10-17 23:23:43','2018-10-17 23:23:43',_binary '\0',3,'basic'),(21,'Cuddle Wrap','Compact chasse in place, LRL. Chasse backwards, RLR. Left foot back. Replace weight to right foot. Compact chasse in place, LRL. \n    Chasse to side, RLR, ended in open facing position, two-hand hold. Left foot back, away from partner. Replace weight to right foot.','Chasse to side, RLR, ended back. Chasse backwards, LRL. Right foot back. Replace weight to left foot. Chasse forward, RLR.\n    Chasse to side, LRL, ended in open facing position, two-hand hold. Right foot back, away from partner. Replace weight to left foot.',NULL,'2018-10-17 23:29:28','2018-10-17 23:29:28',_binary '\0',3,'intermidiate'),(22,'Back Pass','Chasse forward, LRL. Chasse to side, RLR, ended in open facing position. Left foot back, away from partner. Replace weight to right foot.','Chasse forward, RLR, past man\'s right side. Chasse to side, LRL, behind man\'s back, ended in open facing position. Right foot back, away from partner. Right foot back, away from partner.',NULL,'2018-10-17 23:33:16','2018-10-17 23:33:16',_binary '\0',3,'intermidiate'),(23,'Alternating Underarm Turns','Chasse side (ended back), LRL. Chasse side, RLR, ended in open facing position. Left foot back, away from partner. Replace weight to right foot. \n    Chasse forward, LRL, under raised RH-LH hold. Chasse to side, RLR, ended in open facing position. Left foot back, away from partner. Replace weight to right foot.','Chasse to side (ended back), RLR, under raised LH-RH hold. End in open facing position. Chasse to side, LRL. Right foot back, away from partner.\n    Replace weight to left foot. Chasse forward, RLR. Chasse to side, LRL, ended in open facing position. Right foot back, away from partner. Replace weight to left foot.',NULL,'2018-10-17 23:36:19','2018-10-17 23:36:19',_binary '\0',3,'intermidiate'),(24,'Single Overhead Loop','Chasse to side, LRL. Chasse to side, RLR, in counter-promenade position. Left foot back, away from partner, in open facing position. Replace weight to right foot.','Chasse to side, ended back. RLR. Chasse to side, LRL, in counter-promenade position. Right foot back, away from partner, in open facing position. Replace weight to left foot.',NULL,'2018-10-17 23:38:40','2018-10-17 23:38:40',_binary '\0',3,'intermidiate'),(25,'Double Overhead Loop','Compact chasse in place, LRL. Compact chasse in place, RLR. Left foot back, away from partner. Replace weight to right foot.','Compact chasse in place, RLR. Compact chasse in place, LRL. Left foot back, away from partner. Replace weight to right foot.',NULL,'2018-10-17 23:40:29','2018-10-17 23:40:29',_binary '\0',3,'intermidiate'),(26,'Closed Tuck-In Turn Turn','Compact chasse in place, LRL. Chasse to side, RLR, ended in open facing position. Left foot back, away from partner. Replace weight to right foot.','Promenade position. Compact chasse in place, RLR. Compact chasse in place, LRL, ended in open facing position. Right foot back, away from partner. Replace weight to left foot.',NULL,'2018-10-18 00:15:32','2018-10-18 00:15:32',_binary '\0',3,'advanced'),(27,'American Spin Tuck-In','Compact chasse in place, LRL. Compact chasse in place, RLR. Left foot back, away from partner. Replace weight to right foot.','Forward chasse, RLR. Compact chasse turning in place, LRL, ended in open facing position. Right foot back, away from partner. Replace weight to left foot.',NULL,'2018-10-18 00:17:39','2018-10-18 00:17:39',_binary '\0',3,'advanced'),(28,'Shoulder Spin Tuck-In','Chasse to side, LRL. Chasse forward, RLR. Left foot back, away from partner. Replace weight to right foot.','Chasse to side, RLR, passing in front of man, moving toward his right side. Three small side steps, LRL (pivots). Right foot back, away from partner. Replace weight to left foot.',NULL,'2018-10-18 00:20:02','2018-10-18 00:20:02',_binary '\0',3,'advanced'),(29,'Continuous Tuck-In Turn','Chasse to side, LRL. Compact chasse in place, RLR. Chasse to side, LRL. Compact chasse in place, RLR.','Chasse to side, RLR, in shadow position in front of man, moving toward his right side. Chasse to side, LRL. Chasse to side, RLR. Chasse to side, LRL.',NULL,'2018-10-18 00:21:41','2018-10-18 00:21:41',_binary '\0',3,'advanced'),(30,'Lindy Basic Turning to Right','Chasse diagonally forward, LRL, ended side. Right foot forward & across left foot in cross-body position. Replace weight to left foot in cross-body position.\n    Chasse to side, RLR, ended side & slightly back. Left foot back, away from partner in open facing position. Replace weight to right foot.','Chasse diagonally forward, RLR, ended side. Left foot back in cross-body position. Replace weight to right foot in cross-body position. Chasse diagonally forward, LRL, ended side.\n    Right foot back, away from partner in open facing position. Replace weight to left foot.',NULL,'2018-10-18 00:24:40','2018-10-18 00:24:40',_binary '\0',3,'advanced'),(31,'Natural Turn','Right foot forward. Left foot side. Close right foot to left foot. Left foot back. Right foot side. Close left foot to right foot.','Left foot back. Right foot side. Close left foot to right foot. Right foot forward. Left foot side. Close right foot to left foot.',NULL,'2018-10-18 01:08:49','2018-10-18 01:08:49',_binary '\0',2,'basic'),(32,'Reverse Turn','Left foot forward. Right foot side. Close left foot to right foot. Right foot back. Left foot side. Close right foot to left foot.','Right foot back. Left foot side. Close right foot to left foot. Left foot forward. Right foot side. Close left foot to right foot.',NULL,'2018-10-18 01:11:14','2018-10-18 01:11:14',_binary '\0',2,'basic'),(33,'Natural Spin Turn','Right foot forward. Left foot side. Close right foot to left foot. Left foot back (pivot). Right foot forward in CBMP. Left foot side & slightly back.','Left foot back. Right foot side. Right foot side. Close left foot to right foot. Right foot forward (pivoting action).\n    Left foot back and slightly side, then brush right foot to left foot. Right foot diagonally forward.',NULL,'2018-10-18 01:14:18','2018-10-18 01:14:18',_binary '\0',2,'basic'),(34,'Whisk','Left foot forward. Right foot side & slightly forward. Cross left foot behind right foot in promenade position.','Right foot back. Left foot diagonally back. Cross right foot behind left foot in promenade position.',NULL,'2018-10-18 01:15:29','2018-10-18 01:15:29',_binary '\0',2,'basic'),(35,'Chasse','Right foot forward & across in promenade position and CBMP. Left foot side & slightly forward. Close right foot to left foot. Left foot side & slightly forward.\n    Right foot forward in CBMP, outside partner, as first step of following figure.','Left foot forward & across in promenade position and CBMP. Right foot side. Close left foot to right foot. Right foot side & slightly back. \n    Left foot back in CBMP, partner outside, as first step of following figure.',NULL,'2018-10-18 01:18:01','2018-10-18 01:18:01',_binary '\0',2,'basic'),(36,'Closed Impetus','Left foot back. Close right foot to left foot (heel turn). Left foot side & slightly back. Right foot back, as first step of following figure.','Right foot forward. Left foot side. Brush right foot to left foot. Right foot diagonally forward. Left foot forward, as first step of following figure.',NULL,'2018-10-18 01:20:47','2018-10-18 01:20:47',_binary '\0',2,'intermidiate'),(37,'Hesitation Change','Right foot forward. Left foot side. Close right foot to left foot. Left foot back. Right foot side, small step (heel pull). \n    Close left foot to right foot, without weight.','Left foot back. Right foot side. Close left foot to right foot. Right foot forward. Left foot side. Close right foot to left foot, without weight.',NULL,'2018-10-18 01:23:13','2018-10-18 01:23:13',_binary '\0',2,'intermidiate'),(38,'Outside Change','Left foot back. Right foot back. Left foot side & slightly forward. Right foot forward in CBMP, outside partner on right (as first step of following figure).','Right foot forward. Left foot forward. Right foot side & slightly back. Left foot back in CBMP, partner outside on right (as first step of following figure).',NULL,'2018-10-18 01:24:54','2018-10-18 01:24:54',_binary '\0',2,'intermidiate'),(39,'Reverse Corte','Right foot back. Close left foot to right foot, without weight. Hold position. Left foot back in CBMP, partner outside, as first step of following figure.','Left foot forward. Right foot side. Close left foot to right foot. Right foot forward in CBMP, outside partner, as first step of following figure.',NULL,'2018-10-18 01:26:43','2018-10-18 01:26:43',_binary '\0',2,'intermidiate'),(40,'Back Whisk','Left foot back in CBMP, partner outside on right. Right foot diagonally back. Cross left foot behind right foot in promenade position.','Right foot forward in CBMP, outside partner on right. Left foot side. Cross right foot behind left foot in promenade position.',NULL,'2018-10-18 01:28:15','2018-10-18 01:28:15',_binary '\0',2,'intermidiate'),(41,'Weave','Right foot back. Left foot forward. Right foot side. Left foot back in CBMP, partner outside. \n    Right foot back. Right foot back. Right foot forward in CBMP, outside partner, as first step of following figure.','Left foot forward. Right foot back. Left foot side. Right foot forward in CBMP, outside partner. Left foot forward. Left foot forward.\n    Right foot side & slightly back. Left foot back in CBMP, partner outside, as first step of following figure.',NULL,'2018-10-18 01:32:05','2018-10-18 01:32:05',_binary '\0',2,'advanced'),(42,'Double Reverse Spin','Left foot forward. Right foot side. Close left foot to right foot without weight (toe pivot).','Right foot back. Close right foot to left foot (heel turn). Right foot side & slightly back. Cross left foot in front of right foot.',NULL,'2018-10-18 01:33:24','2018-10-18 01:33:24',_binary '\0',2,'advanced'),(43,'Reverse Pivot','Right foot back in CBMP, small step, pivoting to left with LF held in CBMP.','Left foot forward in CBMP, small step, pivoting to left with right foot held in CBMP.',NULL,'2018-10-18 01:34:19','2018-10-18 01:34:19',_binary '\0',2,'advanced'),(44,'Forward Lock','Right foot forward in CBMP, outside partner. Left foot diagonally forward. Cross right foot behind left foot. Left foot diagonally forward.\n    Right foot forward in CBMP, outside partner, as first step of following figure.','Left foot back in CBMP, partner outside. Right foot back. Cross left foot in front of right foot. Right foot diagonally back. \n    Left foot back in CBMP, partner outside, as first step of following figure.',NULL,'2018-10-18 01:36:15','2018-10-18 01:36:15',_binary '\0',2,'advanced'),(45,'Closed Telemark','Left foot forward. Right foot side. Left foot side & slightly forward. Right foot forward in CBMP, outside partner, as first step of following figure.','Right foot back. Close left foot to right foot (heel turn). \n    Right foot side & slightly back. Left foot back in CBMP, partner outside, as first step of following figure.',NULL,'2018-10-18 01:38:32','2018-10-18 01:38:32',_binary '\0',2,'advanced'),(46,'Basic Movements','Right foot back. Replace weight to left foot. Right foot side. Left foot forward. Replace weight to right foot. Left foot side & slightly back.','Right foot back. Close left foot to right foot (heel turn). \n    Right foot side & slightly back. Left foot back in CBMP, partner outside, as first step of following figure.',NULL,'2018-10-18 01:48:48','2018-10-18 01:48:48',_binary '\0',1,'basic'),(47,'New York','Left foot forward in left side-by-side position. Replace weight to right foot. Left foot side in open promenade position. \n    Right foot forward in right side-by-side position. Replace weight to left foot. Right foot side in open promenade position.','Right foot forward in right side-by-side position. Replace weight to left foot. Right foot side in open promenade position. \n    Left foot forward in left side-by-side position. Replace weight to right foot. Left foot side in open promenade position.',NULL,'2018-10-18 01:51:11','2018-10-18 01:51:11',_binary '\0',1,'basic'),(48,'Underarm Turns to R & L','Left foot forward. Replace weight to right foot. Left foot side. Right foot back. Replace weight to left foot. Right foot side.','Right foot forward, in line with left foot, ended back. Replace weight to left foot. Right foot side. Left foot forward, in line with right foot, ended back.\n    Replace weight to right foot. Left foot side.',NULL,'2018-10-18 01:53:38','2018-10-18 01:53:38',_binary '\0',1,'basic'),(49,'Shoulder to Shoulder','Left foot forward towards lady\'s left side. Replace weight to right foot. Left foot side & slightly forward. Right foot forward towards lady\'s right side.\n     Replace weight to left foot. Right foot side & slightly forward.','Right foot back. Replace weight to left foot, towards man\'s left side. Right foot side & slightly back. Left foot back. \n    Replace weight to right foot, towards man\'s right side. Left foot side & slightly back.',NULL,'2018-10-18 01:57:25','2018-10-18 01:57:25',_binary '\0',1,'basic');
/*!40000 ALTER TABLE `step` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_custom_steps`
--

DROP TABLE IF EXISTS `user_custom_steps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_custom_steps` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `step_name` varchar(200) DEFAULT NULL,
  `dance_name` varchar(200) DEFAULT NULL,
  `lead_description` varchar(1000) DEFAULT NULL,
  `follower_description` varchar(1000) DEFAULT NULL,
  `level` varchar(200) DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `users_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_custom_steps_users` (`users_id`),
  CONSTRAINT `user_custom_steps_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_custom_steps`
--

LOCK TABLES `user_custom_steps` WRITE;
/*!40000 ALTER TABLE `user_custom_steps` DISABLE KEYS */;
INSERT INTO `user_custom_steps` VALUES (134,'Underarm Rurn','Rumba','underarmTurn.png','underarmTurn.png','basic','2018-10-14 17:15:38','2018-10-14 17:15:38',_binary '',31),(135,'Box Step','Rumba','boxstep.gif','boxstepF.png','basic','2018-10-17 02:46:18','2018-10-17 02:46:18',_binary '',31),(136,'Underarm Rurn','Rumba','underarmTurn.png','underarmTurn.png','basic','2018-10-17 02:47:03','2018-10-17 02:47:03',_binary '',31),(137,'Box Step','Rumba','boxstep.gif','boxstepF.png','basic','2018-10-17 02:47:09','2018-10-17 02:47:09',_binary '',31),(138,'test','test','test','test','test','2018-10-17 02:47:26','2018-10-17 02:47:26',_binary '',31),(139,'Alternating Underarm Turns','Swing','Chasse side (ended back), LRL. Chasse side, RLR, ended in open facing position. Left foot back, away from partner. Replace weight to right foot.     Chasse forward, LRL, under raised RH-LH hold. Chasse to side, RLR, ended in open facing position. Left foot back, away from partner. Replace weight to right foot.','Chasse to side (ended back), RLR, under raised LH-RH hold. End in open facing position. Chasse to side, LRL. Right foot back, away from partner.    Replace weight to left foot. Chasse forward, RLR. Chasse to side, LRL, ended in open facing position. Right foot back, away from partner. Replace weight to left foot.','intermidiate','2018-10-17 23:41:10','2018-10-17 23:41:10',_binary '\0',31),(140,'Link','Swing','Compact chasse forward, LRL. Chasse to side','Chasse forward towards man\'s right side, RLR. Chasse to side','basic','2018-10-17 23:42:12','2018-10-17 23:42:12',_binary '',31),(141,'Box Step','Rumba','boxstep.gif','boxstepF.png','basic','2018-10-17 23:42:38','2018-10-17 23:42:38',_binary '',31),(142,'Basic','Swing','Chasse to side - LRL, Chasse to side - RLR, Left foot back, away from partner, Replace weight to right foot','Chasse to side - RLR, Chasse to side - LRL, Right foot back away from partner, Replace weight to left foot.','basic','2018-10-17 23:42:49','2018-10-17 23:42:49',_binary '',31),(143,'Basic','Swing','Chasse to side - LRL, Chasse to side - RLR, Left foot back, away from partner, Replace weight to right foot','Chasse to side - RLR, Chasse to side - LRL, Right foot back away from partner, Replace weight to left foot.','basic','2018-10-17 23:44:02','2018-10-17 23:44:02',_binary '',31),(144,'Link','Swing','Compact chasse forward, LRL. Chasse to side','Chasse forward towards man\'s right side, RLR. Chasse to side','basic','2018-10-17 23:45:31','2018-10-17 23:45:31',_binary '',31),(145,'Box Step','Rumba','boxstep.gif','boxstepF.png','basic','2018-10-17 23:45:48','2018-10-17 23:45:48',_binary '',31),(146,'Basic','Swing','Chasse to side - LRL, Chasse to side - RLR, Left foot back, away from partner, Replace weight to right foot','Chasse to side - RLR, Chasse to side - LRL, Right foot back away from partner, Replace weight to left foot.','basic','2018-10-17 23:45:55','2018-10-17 23:45:55',_binary '\0',31),(147,'Link','Swing','Compact chasse forward, LRL. Chasse to side','Chasse forward towards man\'s right side, RLR. Chasse to side','basic','2018-10-17 23:47:57','2018-10-17 23:47:57',_binary '\0',31),(148,'Basic','Swing','Chasse to side - LRL, Chasse to side - RLR, Left foot back, away from partner, Replace weight to right foot','Chasse to side - RLR, Chasse to side - LRL, Right foot back away from partner, Replace weight to left foot.','basic','2018-10-17 23:49:50','2018-10-17 23:49:50',_binary '\0',31),(149,'Hand to Hand','Rumba','test','test','basic','2018-10-17 23:50:53','2018-10-17 23:50:53',_binary '',31),(150,'Throwout','Swing','Compact chasse to side - LRL - ended with left foot forward, Chasse to side - RLR, Left foot back away from partner, Replace weight to right foot','Chasse forward or 3 forward passing steps in promenade position - RLR, Right foot back away from partner, Replace weight to left foot','basic','2018-10-18 00:09:01','2018-10-18 00:09:01',_binary '\0',31),(151,'Alternating Underarm Turns','Swing','Chasse side (ended back), LRL. Chasse side, RLR, ended in open facing position. Left foot back, away from partner. Replace weight to right foot.     Chasse forward, LRL, under raised RH-LH hold. Chasse to side, RLR, ended in open facing position. Left foot back, away from partner. Replace weight to right foot.','Chasse to side (ended back), RLR, under raised LH-RH hold. End in open facing position. Chasse to side, LRL. Right foot back, away from partner.    Replace weight to left foot. Chasse forward, RLR. Chasse to side, LRL, ended in open facing position. Right foot back, away from partner. Replace weight to left foot.','intermidiate','2018-10-18 00:10:16','2018-10-18 00:10:16',_binary '',31),(152,'Double Overhead Loop','Swing','Compact chasse in place, LRL. Compact chasse in place, RLR. Left foot back, away from partner. Replace weight to right foot.','Compact chasse in place, RLR. Compact chasse in place, LRL. Left foot back, away from partner. Replace weight to right foot.','intermidiate','2018-10-18 00:11:14','2018-10-18 00:11:14',_binary '\0',31),(153,'Throwout','Swing','Compact chasse to side - LRL - ended with left foot forward, Chasse to side - RLR, Left foot back away from partner, Replace weight to right foot','Chasse forward or 3 forward passing steps in promenade position - RLR, Right foot back away from partner, Replace weight to left foot','basic','2018-10-18 00:34:48','2018-10-18 00:34:48',_binary '\0',31),(154,'test','test','test','step','step','2018-10-18 00:35:13','2018-10-18 00:35:13',_binary '\0',31),(155,'Back Pass','Swing','Chasse forward, LRL. Chasse to side, RLR, ended in open facing position. Left foot back, away from partner. Replace weight to right foot.','Chasse forward, RLR, past man\'s right side. Chasse to side, LRL, behind man\'s back, ended in open facing position. Right foot back, away from partner. Right foot back, away from partner.','intermidiate','2018-10-18 01:03:43','2018-10-18 01:03:43',_binary '\0',31),(156,'Reverse Turn','Waltz','Left foot forward. Right foot side. Close left foot to right foot. Right foot back. Left foot side. Close right foot to left foot.','Right foot back. Left foot side. Close right foot to left foot. Left foot forward. Right foot side. Close left foot to right foot.','basic','2018-10-18 01:11:45','2018-10-18 01:11:45',_binary '\0',31),(157,'Chasse','Waltz','Right foot forward','Left foot forward','basic','2018-10-18 01:18:18','2018-10-18 01:18:18',_binary '\0',31),(158,'Double Reverse Spin','Waltz','Left foot forward. Right foot side. Close left foot to right foot without weight (toe pivot).','Right foot back. Close right foot to left foot (heel turn). Right foot side','advanced','2018-10-18 01:38:39','2018-10-18 01:38:39',_binary '\0',31),(159,'Link','Swing','Compact chasse forward, LRL. Chasse to side','Chasse forward towards man\'s right side, RLR. Chasse to side','basic','2018-10-18 01:57:45','2018-10-18 01:57:45',_binary '\0',31),(160,'Natural Spin Turn','Waltz','Right foot forward. Left foot side. Close right foot to left foot. Left foot back (pivot). Right foot forward in CBMP. Left foot side','Left foot back. Right foot side. Right foot side. Close left foot to right foot. Right foot forward (pivoting action).    Left foot back and slightly side, then brush right foot to left foot. Right foot diagonally forward.','basic','2018-10-18 01:57:52','2018-10-18 01:57:52',_binary '\0',31);
/*!40000 ALTER TABLE `user_custom_steps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_dance`
--

DROP TABLE IF EXISTS `user_dance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_dance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `users_id` int(11) NOT NULL,
  `dance_type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_dance_dance_type` (`dance_type_id`),
  KEY `user_dance_users` (`users_id`),
  CONSTRAINT `user_dance_dance_type` FOREIGN KEY (`dance_type_id`) REFERENCES `dance_type` (`id`),
  CONSTRAINT `user_dance_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_dance`
--

LOCK TABLES `user_dance` WRITE;
/*!40000 ALTER TABLE `user_dance` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_dance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `user_dance_view`
--

DROP TABLE IF EXISTS `user_dance_view`;
/*!50001 DROP VIEW IF EXISTS `user_dance_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `user_dance_view` AS SELECT 
 1 AS `first_name`,
 1 AS `last_name`,
 1 AS `user_id`,
 1 AS `dance_name`,
 1 AS `/*!50_id`,
 1 AS `beats_per_minute`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `user_role_view`
--

DROP TABLE IF EXISTS `user_role_view`;
/*!50001 DROP VIEW IF EXISTS `user_role_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `user_role_view` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `email`,
 1 AS `password`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(500) NOT NULL,
  `first_name` varchar(500) NOT NULL,
  `email` varchar(1000) NOT NULL,
  `password` varchar(200) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Coyne','Joe','jcoyne','114','2018-09-26 01:06:16','2018-09-26 01:06:16',_binary '\0',1),(3,'Fred','Flintstone','fflintstone','123','2018-09-26 01:06:16','2018-09-26 01:06:16',_binary '\0',1),(4,'test','test','test','2222','2018-09-26 01:48:07','2018-09-26 01:48:07',_binary '\0',1),(5,'Kisik','Mini','minini','112','2018-09-28 02:09:17','2018-09-28 02:09:17',_binary '\0',1),(6,'test','test','test','3333','2018-09-29 01:04:25','2018-09-29 01:04:25',_binary '\0',1),(7,'Hello','Test','test','3k3k','2018-09-29 21:35:25','2018-09-29 21:35:25',_binary '\0',1),(8,'Viki','Logans','vike@mail.com','22hhgk','2018-09-29 23:14:18','2018-09-29 23:14:18',_binary '\0',1),(9,'Victor','Long','victor@mail.com','222go','2018-10-03 03:04:08','2018-10-03 03:04:08',_binary '\0',1),(10,'Long','Victor','victor@mail.com','3333','2018-10-03 03:04:26','2018-10-03 03:04:26',_binary '\0',1),(11,'Lol','Kisik','kisik@mail.com','kisik333','2018-10-03 03:07:04','2018-10-03 03:07:04',_binary '\0',1),(12,'hello','Luna','hello','21','2018-10-04 02:29:58','2018-10-04 02:29:58',_binary '\0',1),(13,'mak','Kisik','kkkkk','222','2018-10-06 16:06:44','2018-10-06 16:06:44',_binary '\0',1),(14,'Nikon','Mike','nono','111','2018-10-06 16:18:59','2018-10-06 16:18:59',_binary '\0',1),(30,'Dev','Sasha','sasha@dev.com','888','2018-10-13 18:28:13','2018-10-13 18:28:13',_binary '\0',1),(31,'Smith','John','get','get','2018-10-13 18:40:43','2018-10-13 18:40:43',_binary '\0',1),(32,'Kisik','StasK','stas','111','2018-10-13 20:22:07','2018-10-13 20:22:07',_binary '\0',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_role`
--

DROP TABLE IF EXISTS `users_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_role` (
  `id` int(11) NOT NULL,
  `users_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `users_role_role` (`role_id`),
  KEY `users_role_users` (`users_id`),
  CONSTRAINT `users_role_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `users_role_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_role`
--

LOCK TABLES `users_role` WRITE;
/*!40000 ALTER TABLE `users_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `user_dance_view`
--

/*!50001 DROP VIEW IF EXISTS `user_dance_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_dance_view` AS select 1 AS `first_name`,1 AS `last_name`,1 AS `user_id`,1 AS `dance_name`,1 AS `/*!50_id`,1 AS `beats_per_minute` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `user_role_view`
--

/*!50001 DROP VIEW IF EXISTS `user_role_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_role_view` AS select `r`.`id` AS `id`,`r`.`name` AS `name`,`u`.`email` AS `email`,`u`.`password` AS `password` from (`role` `r` join `users` `u` on((`u`.`role_id` = `r`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-17 20:58:25
