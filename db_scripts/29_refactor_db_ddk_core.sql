-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.23-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5293
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for ddk_core
DROP DATABASE IF EXISTS `ddk_core`;
CREATE DATABASE IF NOT EXISTS `ddk_core` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ddk_core`;

-- Dumping structure for table ddk_core.course
DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NOT NULL,
  `discipline_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `group_lead_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `course_group_id_fk` (`group_id`),
  KEY `course_discipline_id_fk` (`discipline_id`),
  KEY `course_teacher_id_fk` (`teacher_id`),
  CONSTRAINT `course_discipline_id_fk` FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`id`),
  CONSTRAINT `course_group_id_fk` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`),
  CONSTRAINT `course_teacher_id_fk` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table ddk_core.course: ~0 rows (approximately)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`id`, `teacher_id`, `discipline_id`, `group_id`, `group_lead_id`) VALUES
	(2, 1, 1, 1, 1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Dumping structure for table ddk_core.discipline
DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `discipline_type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `discipline_id_uindex` (`id`),
  KEY `discipline_discipline_type_id_fk` (`discipline_type_id`),
  CONSTRAINT `discipline_discipline_type_id_fk` FOREIGN KEY (`discipline_type_id`) REFERENCES `discipline_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table ddk_core.discipline: ~0 rows (approximately)
/*!40000 ALTER TABLE `discipline` DISABLE KEYS */;
INSERT INTO `discipline` (`id`, `name`, `discipline_type_id`) VALUES
	(1, 'jgk', 1);
/*!40000 ALTER TABLE `discipline` ENABLE KEYS */;

-- Dumping structure for table ddk_core.discipline_type
DROP TABLE IF EXISTS `discipline_type`;
CREATE TABLE IF NOT EXISTS `discipline_type` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ddk_core.discipline_type: ~1 rows (approximately)
/*!40000 ALTER TABLE `discipline_type` DISABLE KEYS */;
INSERT INTO `discipline_type` (`id`, `name`) VALUES
	(1, 'fdkghd');
/*!40000 ALTER TABLE `discipline_type` ENABLE KEYS */;

-- Dumping structure for table ddk_core.group
DROP TABLE IF EXISTS `group`;
CREATE TABLE IF NOT EXISTS `group` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `classroom_num` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ddk_core.group: ~1 rows (approximately)
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` (`id`, `name`, `classroom_num`) VALUES
	(1, 'sgdfyt', '65');
/*!40000 ALTER TABLE `group` ENABLE KEYS */;

-- Dumping structure for table ddk_core.lesson
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE IF NOT EXISTS `lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `lesson_id_uindex` (`id`),
  KEY `lesson_group_id_fk` (`group_id`),
  KEY `lesson_room_id_fk` (`room_id`),
  KEY `lesson_course_id_fk` (`course_id`),
  KEY `lesson_lesson_type_id_fk` (`type_id`),
  CONSTRAINT `lesson_course_id_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `lesson_group_id_fk` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`),
  CONSTRAINT `lesson_lesson_type_id_fk` FOREIGN KEY (`type_id`) REFERENCES `lesson_type` (`id`),
  CONSTRAINT `lesson_room_id_fk` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ddk_core.lesson: ~0 rows (approximately)
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;

-- Dumping structure for table ddk_core.lesson_type
DROP TABLE IF EXISTS `lesson_type`;
CREATE TABLE IF NOT EXISTS `lesson_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `lesson_type_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ddk_core.lesson_type: ~0 rows (approximately)
/*!40000 ALTER TABLE `lesson_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `lesson_type` ENABLE KEYS */;

-- Dumping structure for table ddk_core.room
DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` int(11) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `number` varchar(64) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `room_id_uindex` (`id`),
  KEY `room_room_type_id_fk` (`type_id`),
  CONSTRAINT `room_room_type_id_fk` FOREIGN KEY (`type_id`) REFERENCES `room_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ddk_core.room: ~0 rows (approximately)
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
/*!40000 ALTER TABLE `room` ENABLE KEYS */;

-- Dumping structure for table ddk_core.room_type
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE IF NOT EXISTS `room_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `room_type_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table ddk_core.room_type: ~3 rows (approximately)
/*!40000 ALTER TABLE `room_type` DISABLE KEYS */;
INSERT INTO `room_type` (`id`, `name`) VALUES
	(1, 'computer class'),
	(2, 'lecture class'),
	(3, 'labaratory');
/*!40000 ALTER TABLE `room_type` ENABLE KEYS */;

-- Dumping structure for table ddk_core.student
DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_id_uindex` (`id`),
  KEY `fk_student_user_idx` (`user_id`),
  KEY `fk_student_group1_idx` (`group_id`),
  CONSTRAINT `fk_student_group1` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ddk_core.student: ~0 rows (approximately)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Dumping structure for table ddk_core.teacher
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `teacher_id_uindex` (`id`),
  KEY `fk_teacher_user1_idx` (`user_id`),
  CONSTRAINT `fk_teacher_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table ddk_core.teacher: ~0 rows (approximately)
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`id`, `user_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

-- Dumping structure for table ddk_core.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ddk_core.user: ~1 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `first_name`, `last_name`) VALUES
	(1, 'dfgh', 'dgf', 'dfg');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
