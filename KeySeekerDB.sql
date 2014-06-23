-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 23, 2014 at 12:13 PM
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

-- --------------------------------------------------------

--
-- Table structure for table `ABILITY`
--

CREATE TABLE IF NOT EXISTS `ABILITY` (
  `ABILITY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MOVESPERTURN` int(11) NOT NULL,
  `ATTACK` int(11) NOT NULL,
  `LIFE` int(11) NOT NULL,
  PRIMARY KEY (`ABILITY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `ACCOUNT`
--

CREATE TABLE IF NOT EXISTS `ACCOUNT` (
  `ACCOUNT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) COLLATE latin1_german1_ci NOT NULL,
  `PASSWORD` varchar(45) COLLATE latin1_german1_ci NOT NULL,
  `EMAIL` varchar(45) COLLATE latin1_german1_ci NOT NULL,
  PRIMARY KEY (`ACCOUNT_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `ACCOUNT`
--

INSERT INTO `ACCOUNT` (`ACCOUNT_ID`, `NAME`, `PASSWORD`, `EMAIL`) VALUES
(1, 'admin', '1234', 'Benny.Winter@yahoo.de');

-- --------------------------------------------------------

--
-- Table structure for table `CHARACTER`
--

CREATE TABLE IF NOT EXISTS `CHARACTER` (
  `CHARACTER_ID` int(11) NOT NULL,
  `NAME` varchar(45) COLLATE latin1_german1_ci NOT NULL,
  `IMAGE_ID` int(11) DEFAULT NULL,
  `ABILITY_ID` int(11) NOT NULL,
  `ACCOUNT_ID` int(11) NOT NULL,
  PRIMARY KEY (`CHARACTER_ID`),
  KEY `fk_Character_Image1` (`IMAGE_ID`),
  KEY `fk_Character_Ability1` (`ABILITY_ID`),
  KEY `fk_Character_Account1` (`ACCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

-- --------------------------------------------------------

--
-- Table structure for table `IMAGE`
--

CREATE TABLE IF NOT EXISTS `IMAGE` (
  `IMAGE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PATH` varchar(90) COLLATE latin1_german1_ci NOT NULL,
  PRIMARY KEY (`IMAGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `ITEM`
--

CREATE TABLE IF NOT EXISTS `ITEM` (
  `ITEM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) COLLATE latin1_german1_ci NOT NULL,
  `ABILITY_ID` int(11) NOT NULL,
  PRIMARY KEY (`ITEM_ID`),
  KEY `fk_Item_Ability1` (`ABILITY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `CHARACTER`
--
ALTER TABLE `CHARACTER`
  ADD CONSTRAINT `fk_Character_Image1` FOREIGN KEY (`IMAGE_ID`) REFERENCES `IMAGE` (`IMAGE_ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Character_Ability1` FOREIGN KEY (`ABILITY_ID`) REFERENCES `ABILITY` (`ABILITY_ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Character_Account1` FOREIGN KEY (`ACCOUNT_ID`) REFERENCES `ACCOUNT` (`ACCOUNT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `ITEM`
--
ALTER TABLE `ITEM`
  ADD CONSTRAINT `fk_Item_Ability1` FOREIGN KEY (`ABILITY_ID`) REFERENCES `ABILITY` (`ABILITY_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
