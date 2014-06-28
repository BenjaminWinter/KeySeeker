-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 28, 2014 at 11:11 PM
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
-- RELATIONS FOR TABLE `ITEM`:
--   `ID`
--       `ABILITY` -> `ID`
--

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ITEM`
--
ALTER TABLE `ITEM`
  ADD CONSTRAINT `fk_Item_Ability1` FOREIGN KEY (`ID`) REFERENCES `ABILITY` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
