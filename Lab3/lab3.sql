-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 05, 2023 at 12:52 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lab3`
--
CREATE DATABASE IF NOT EXISTS `lab3` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `lab3`;

-- --------------------------------------------------------

--
-- Table structure for table `manufacture`
--

DROP TABLE IF EXISTS `manufacture`;
CREATE TABLE `manufacture` (
  `ID` varchar(255) NOT NULL,
  `Employee` int(11) NOT NULL,
  `Location` varchar(255) NOT NULL,
  `Name` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `manufacture`
--

INSERT INTO `manufacture` (`ID`, `Employee`, `Location`, `Name`) VALUES
('1', 360000, 'Toyota City, Japan', 'Toyota'),
('10', 377000, 'Omaha, Nebraska, USA', 'Berkshire Hathaway'),
('11', 154000, 'Cupertino, California, USA', 'Apple'),
('12', 88000, 'Espoo, Finland', 'Nokia'),
('13', 7000, 'Libertyville, Illinois, USA', 'Motorola'),
('2', 673000, 'Wolfsburg, Germany', 'Volkswagen'),
('3', 317000, 'Amsterdam, Netherlands', 'Stellantis'),
('4', 157000, 'Detroit, Michigan, USA', 'General Motors'),
('5', 182000, 'Dearborn, Michigan, USA', 'Ford'),
('6', 287000, 'Seoul, South Korea', 'Samsung'),
('7', 63000, 'Hsinchu, Taiwan', 'TSMC'),
('8', 117000, 'Santa Clara, California, USA', 'Intel'),
('9', 896000, 'Tucheng, New Taipei City, Taiwan', 'Foxconn');

-- --------------------------------------------------------

--
-- Table structure for table `mobilephone`
--

DROP TABLE IF EXISTS `mobilephone`;
CREATE TABLE `mobilephone` (
  `ID` varchar(255) NOT NULL,
  `Color` varchar(128) NOT NULL,
  `Country` varchar(255) NOT NULL,
  `Name` varchar(128) NOT NULL,
  `Price` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `manufacture_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mobilephone`
--

INSERT INTO `mobilephone` (`ID`, `Color`, `Country`, `Name`, `Price`, `Quantity`, `manufacture_id`) VALUES
('1', 'Black', 'South Korea', 'Galaxy S22 Ultra', 30000000, 100, '6'),
('11', 'Black', 'South Korea', 'Galaxy S11', 25000000, 100, '6'),
('12', 'White', 'South Korea', 'Galaxy S12', 24000000, 100, '6'),
('13', 'Blue', 'South Korea', 'Galaxy S13', 34000000, 100, '6'),
('14', 'Green', 'South Korea', 'Galaxy S14', 29000000, 100, '6'),
('15', 'Red', 'South Korea', 'Galaxy S15', 28000000, 100, '6'),
('16', 'Black', 'South Korea', 'Galaxy S16', 36000000, 100, '6'),
('17', 'White', 'South Korea', 'Galaxy S17', 26000000, 100, '6'),
('18', 'Blue', 'South Korea', 'Galaxy S18', 30000000, 100, '6'),
('19', 'Green', 'South Korea', 'Galaxy S19', 30000000, 100, '6'),
('2', 'Silver', 'United States', 'iPhone 13 Pro Max', 40000000, 200, '11'),
('20', 'Red', 'South Korea', 'Galaxy S20', 30000000, 100, '6'),
('21', 'Silver', 'United States', 'iPhone 21 Pro Max', 40000000, 200, '11'),
('22', 'White', 'United States', 'iPhone 22 Pro Max', 40000000, 200, '11'),
('23', 'Pink', 'United States', 'iPhone 23 Pro Max', 50000000, 200, '11'),
('24', 'Black', 'United States', 'iPhone 24 Pro Max', 40000000, 200, '11'),
('25', 'Red', 'United States', 'iPhone 25 Pro Max', 50000000, 200, '11'),
('26', 'Silver', 'United States', 'iPhone 26 Pro Max', 40000000, 200, '11'),
('27', 'White', 'United States', 'iPhone 27 Pro Max', 40000000, 200, '11'),
('28', 'Gold', 'United States', 'iPhone 28 Pro Max', 52000000, 200, '11'),
('29', 'White', 'United States', 'iPhone 27 Air', 30000000, 200, '11'),
('3', 'White', 'United States', 'Pixel 6 Pro', 50000000, 300, '6'),
('30', 'Gold', 'United States', 'iPhone 28 Air', 55000000, 200, '11'),
('6', 'Gray', 'South Korea', 'Galaxy Z Fold 4', 34000000, 100, '6'),
('7', 'Gold', 'United States', 'iPhone 13 Pro', 45000000, 200, '11'),
('8', 'Black', 'United States', 'Pixel 6', 15000000, 300, '6');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `manufacture`
--
ALTER TABLE `manufacture`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `mobilephone`
--
ALTER TABLE `mobilephone`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKh9lufxsey2sle2nreof3pxyp4` (`manufacture_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mobilephone`
--
ALTER TABLE `mobilephone`
  ADD CONSTRAINT `FKh9lufxsey2sle2nreof3pxyp4` FOREIGN KEY (`manufacture_id`) REFERENCES `manufacture` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
