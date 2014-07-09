-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 09, 2014 at 06:02 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `KeySeekerDB`
--
CREATE DATABASE IF NOT EXISTS `KeySeekerDB` DEFAULT CHARACTER SET latin1 COLLATE latin1_german1_ci;
USE `KeySeekerDB`;

-- --------------------------------------------------------

--
-- Table structure for table `ABILITY`
--

DROP TABLE IF EXISTS `ABILITY`;
CREATE TABLE IF NOT EXISTS `ABILITY` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MOVESPERTURN` int(11) NOT NULL,
  `ATTACK` int(11) NOT NULL,
  `LIFE` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci AUTO_INCREMENT=1 ;

--
-- Dumping data for table `ABILITY`
--

INSERT INTO `ABILITY` (`ID`, `MOVESPERTURN`, `ATTACK`, `LIFE`) VALUES
(0, 1, 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `ACCOUNT`
--

DROP TABLE IF EXISTS `ACCOUNT`;
CREATE TABLE IF NOT EXISTS `ACCOUNT` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) COLLATE latin1_german1_ci NOT NULL,
  `PASSWORD` varchar(45) COLLATE latin1_german1_ci NOT NULL,
  `EMAIL` varchar(45) COLLATE latin1_german1_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci AUTO_INCREMENT=99 ;

--
-- Dumping data for table `ACCOUNT`
--

INSERT INTO `ACCOUNT` (`ID`, `NAME`, `PASSWORD`, `EMAIL`) VALUES
(0, 'admin', '1234', 'Benny.Winter@yahoo.de');

-- --------------------------------------------------------

--
-- Table structure for table `CHARACTER`
--

DROP TABLE IF EXISTS `CHARACTER`;
CREATE TABLE IF NOT EXISTS `CHARACTER` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) COLLATE latin1_german1_ci NOT NULL,
  `IMAGE_ID` int(11) DEFAULT NULL,
  `ABILITY_ID` int(11) NOT NULL,
  `ACCOUNT_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Character_Image1` (`IMAGE_ID`),
  KEY `fk_Character_Ability1` (`ABILITY_ID`),
  KEY `fk_Character_Account1` (`ACCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

--
-- Dumping data for table `CHARACTER`
--

INSERT INTO `CHARACTER` (`ID`, `NAME`, `IMAGE_ID`, `ABILITY_ID`, `ACCOUNT_ID`) VALUES
(0, 'hero1', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `IMAGE`
--

DROP TABLE IF EXISTS `IMAGE`;
CREATE TABLE IF NOT EXISTS `IMAGE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PATH` varchar(200) COLLATE latin1_german1_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci AUTO_INCREMENT=1 ;

--
-- Dumping data for table `IMAGE`
--

INSERT INTO `IMAGE` (`ID`, `PATH`) VALUES
(0, '/home/benny/softwareprojekt-i/KeySeeker-png');

-- --------------------------------------------------------

--
-- Table structure for table `ITEM`
--

DROP TABLE IF EXISTS `ITEM`;
CREATE TABLE IF NOT EXISTS `ITEM` (
  `ITEM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) COLLATE latin1_german1_ci NOT NULL,
  `ID` int(11) NOT NULL,
  PRIMARY KEY (`ITEM_ID`),
  KEY `fk_Item_Ability1` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `CHARACTER`
--
ALTER TABLE `CHARACTER`
  ADD CONSTRAINT `fk_Character_Ability1` FOREIGN KEY (`ABILITY_ID`) REFERENCES `ABILITY` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Character_Account1` FOREIGN KEY (`ACCOUNT_ID`) REFERENCES `ACCOUNT` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Character_Image1` FOREIGN KEY (`IMAGE_ID`) REFERENCES `IMAGE` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `ITEM`
--
ALTER TABLE `ITEM`
  ADD CONSTRAINT `fk_Item_Ability1` FOREIGN KEY (`ID`) REFERENCES `ABILITY` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
