-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2023 at 05:14 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentmanagementinformation`
--
CREATE DATABASE IF NOT EXISTS `studentmanagementinformation` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `studentmanagementinformation`;

-- --------------------------------------------------------

--
-- Table structure for table `certificatemanagement`
--

CREATE TABLE `certificatemanagement` (
  `CertificateID` int(11) NOT NULL,
  `StudentID` varchar(10) DEFAULT NULL,
  `CertificateName` varchar(250) DEFAULT NULL,
  `IssueDate` date DEFAULT NULL,
  `ExpiryDate` date DEFAULT NULL,
  `Grade` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `certificatemanagement`
--

INSERT INTO `certificatemanagement` (`CertificateID`, `StudentID`, `CertificateName`, `IssueDate`, `ExpiryDate`, `Grade`) VALUES
(5, '81600662', 'Python', '2023-12-12', '2023-12-26', 10),
(6, '124F2105', 'Java', '2022-11-15', '2022-11-29', 9.5),
(7, '124F2105', 'C++', '2021-09-20', '2021-10-04', 8.7),
(8, '124F2105', 'JavaScript', '2023-08-03', '2023-08-17', 9.8),
(9, '124F2105', 'Python', '2024-07-12', '2024-07-26', 9.9),
(10, '124F2105', 'Ruby', '2022-06-08', '2022-06-22', 8.5),
(11, '124F2105', 'Swift', '2023-05-04', '2023-05-18', 9.2),
(12, '124F2105', 'PHP', '2024-04-01', '2024-04-15', 8.9),
(13, '124F2105', 'TypeScript', '2021-03-15', '2021-03-29', 9.7),
(14, '124F2105', 'Go', '2022-02-10', '2022-02-24', 8.3),
(15, '124F2105', 'Kotlin', '2023-01-05', '2023-01-19', 9.4),
(16, '417H7150', 'Java', '2022-11-15', '2022-11-29', 9.5),
(17, '417H7150', 'C++', '2021-09-20', '2021-10-04', 8.7),
(18, '417H7150', 'JavaScript', '2023-08-03', '2023-08-17', 9.8),
(19, '417H7150', 'Python', '2024-07-12', '2024-07-26', 9.9),
(20, '417H7150', 'Ruby', '2022-06-08', '2022-06-22', 8.5),
(21, '417H7150', 'Swift', '2023-05-04', '2023-05-18', 9.2),
(22, '417H7150', 'PHP', '2024-04-01', '2024-04-15', 8.9),
(23, '417H7150', 'TypeScript', '2021-03-15', '2021-03-29', 9.7),
(24, '417H7150', 'Go', '2022-02-10', '2022-02-24', 8.3),
(25, '417H7150', 'Kotlin', '2023-01-05', '2023-01-19', 9.4),
(26, '718H3921', 'Java', '2022-11-15', '2022-11-29', 9.5),
(27, '718H3921', 'C++', '2021-09-20', '2021-10-04', 8.7),
(28, '718H3921', 'JavaScript', '2023-08-03', '2023-08-17', 9.8),
(29, '718H3921', 'Python', '2024-07-12', '2024-07-26', 9.9),
(30, '718H3921', 'Ruby', '2022-06-08', '2022-06-22', 8.5),
(31, '718H3921', 'Swift', '2023-05-04', '2023-05-18', 9.2),
(32, '718H3921', 'PHP', '2024-04-01', '2024-04-15', 8.9),
(33, '718H3921', 'TypeScript', '2021-03-15', '2021-03-29', 9.7),
(34, '718H3921', 'Go', '2022-02-10', '2022-02-24', 8.3),
(35, '718H3921', 'Kotlin', '2023-01-05', '2023-01-19', 9.4),
(36, '422F7398', 'Java', '2022-11-15', '2022-11-29', 9.5),
(37, '422F7398', 'C++', '2021-09-20', '2021-10-04', 8.7),
(38, '422F7398', 'JavaScript', '2023-08-03', '2023-08-17', 9.8),
(39, '422F7398', 'Python', '2024-07-12', '2024-07-26', 9.9),
(40, '422F7398', 'Ruby', '2022-06-08', '2022-06-22', 8.5),
(41, '422F7398', 'Swift', '2023-05-04', '2023-05-18', 9.2),
(42, '422F7398', 'PHP', '2024-04-01', '2024-04-15', 8.9),
(43, '422F7398', 'TypeScript', '2021-03-15', '2021-03-29', 9.7),
(44, '422F7398', 'Go', '2022-02-10', '2022-02-24', 8.3),
(45, '422F7398', 'Kotlin', '2023-01-05', '2023-01-19', 9.4),
(46, '81702592', 'Java', '2022-11-15', '2022-11-29', 1),
(47, '81702592', 'C++', '2021-09-20', '2021-10-04', 8.7),
(48, '81702592', 'JavaScript', '2023-08-03', '2023-08-17', 9.8),
(49, '81702592', 'Python', '2024-07-12', '2024-07-26', 9.9),
(50, '81702592', 'Ruby', '2022-06-08', '2022-06-22', 8.5),
(51, '81702592', 'Swift', '2023-05-04', '2023-05-18', 9.2),
(52, '81702592', 'PHP', '2024-04-01', '2024-04-15', 8.9),
(53, '81702592', 'TypeScript', '2021-03-15', '2021-03-29', 9.7),
(54, '81702592', 'Go', '2022-02-10', '2022-02-24', 8.3),
(55, '81702592', 'Kotlin', '2023-01-05', '2023-01-19', 9.4),
(56, 'C20F2139', 'Java', '2022-11-15', '2022-11-29', 9.5),
(57, 'C20F2139', 'C++', '2021-09-20', '2021-10-04', 8.7),
(58, 'C20F2139', 'JavaScript', '2023-08-03', '2023-08-17', 9.8),
(59, 'C20F2139', 'Python', '2024-07-12', '2024-07-26', 9.9),
(60, 'C20F2139', 'Ruby', '2022-06-08', '2022-06-22', 8.5),
(61, 'C20F2139', 'Swift', '2023-05-04', '2023-05-18', 9.2),
(62, 'C20F2139', 'PHP', '2024-04-01', '2024-04-15', 8.9),
(63, 'C20F2139', 'TypeScript', '2021-03-15', '2021-03-29', 9.7),
(64, 'C20F2139', 'Go', '2022-02-10', '2022-02-24', 8.3),
(65, 'C20F2139', 'Kotlin', '2023-01-05', '2023-01-19', 9.4),
(66, 'H1501394', 'Java', '2022-11-15', '2022-11-29', 9.5),
(67, 'H1501394', 'C++', '2021-09-20', '2021-10-04', 8.7),
(68, 'H1501394', 'JavaScript', '2023-08-03', '2023-08-17', 9.8),
(69, 'H1501394', 'Python', '2024-07-12', '2024-07-26', 9.9),
(76, 'C23F9724', 'Java', '2022-11-15', '2022-11-29', 9.5),
(77, 'C23F9724', 'C++', '2021-09-20', '2021-10-04', 8.7),
(78, 'C23F9724', 'JavaScript', '2023-08-03', '2023-08-17', 9.8),
(79, 'C23F9724', 'Python', '2024-07-12', '2024-07-26', 9.9),
(80, 'C23F9724', 'Ruby', '2022-06-08', '2022-06-22', 8.5),
(81, 'C23F9724', 'Swift', '2023-05-04', '2023-05-18', 9.2),
(82, 'C23F9724', 'PHP', '2024-04-01', '2024-04-15', 8.9),
(83, 'C23F9724', 'TypeScript', '2021-03-15', '2021-03-29', 9.7),
(84, 'C23F9724', 'Go', '2022-02-10', '2022-02-24', 8.3),
(85, 'C23F9724', 'Kotlin', '2023-01-05', '2023-01-19', 9.4),
(101, '115H0871', 'Swift', '2023-05-04', '2023-05-18', 9.2),
(102, '115H0871', 'PHP', '2024-04-01', '2024-04-15', 8.9),
(103, '115H0871', 'TypeScript', '2021-03-15', '2021-03-29', 9.7),
(104, '115H0871', 'Go', '2022-02-10', '2022-02-24', 8.3),
(105, '115H0871', 'Kotlin', '2023-01-05', '2023-01-19', 9.4);

-- --------------------------------------------------------

--
-- Table structure for table `loginhistory`
--

CREATE TABLE `loginhistory` (
  `LoginHistoryID` int(11) NOT NULL,
  `UserID` int(11) DEFAULT NULL,
  `TimeLogin` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loginhistory`
--

INSERT INTO `loginhistory` (`LoginHistoryID`, `UserID`, `TimeLogin`) VALUES
(12, 1, '2023-12-16 10:44:44'),
(13, 1, '2023-12-16 10:52:07');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(250) DEFAULT NULL,
  `BeginningYear` int(11) DEFAULT NULL,
  `EndYear` int(11) DEFAULT NULL,
  `Major` varchar(250) DEFAULT NULL,
  `EducationQuality` varchar(250) DEFAULT NULL,
  `Phone` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--


INSERT INTO `student` (`ID`, `Name`, `BeginningYear`, `EndYear`, `Major`, `EducationQuality`, `Phone`) VALUES
('115H0871', 'Ethan Davis', 2015, 2019, 'INDUSTRIAL DESIGN', 'HIGH QUALITY', '0888999888'),
('124F2105', 'Olivia Wilson', 2024, 2028, 'INDUSTRIAL DESIGN', 'JOINT PROGRAM', '0888999000'),
('417H7150', 'Michael Brown', 2017, 2021, 'ELECTRICAL ENGINEERING', 'HIGH QUALITY', '0888111222'),
('422F7398', 'Liam Brown', 2022, 2026, 'ELECTRICAL ENGINEERING', 'JOINT PROGRAM', '0999888777'),
('515F5192', 'Max Anderson', 2015, 2019, 'INFORMATION TECHNOLOGY', 'JOINT PROGRAM', '0888111888'),
('718H3921', 'Alex Johnson', 2018, 2022, 'BUSINESS ADMINISTRATION', 'HIGH QUALITY', '0988555222'),
('721F0078', 'Evelyn Brown', 2021, 2025, 'BUSINESS ADMINISTRATION', 'JOINT PROGRAM', '0911000111'),
('81600662', 'Christopher Lee', 2016, 2020, 'CIVIL ENGINEERING', 'REGULAR QUALITY', '0444555666'),
('81702592', 'Grace Jackson', 2017, 2021, 'CIVIL ENGINEERING', 'REGULAR QUALITY', '0888111222'),
('C20F2139', 'Jane Smith', 2020, 2024, 'MECHANICAL ENGINEERING', 'JOINT PROGRAM', '0919876543'),
('C23F9724', 'Oscar Martinez', 2023, 2027, 'MECHANICAL ENGINEERING', 'JOINT PROGRAM', '0999333222'),
('H1501394', 'William Miller', 2015, 2019, 'DATA SCIENCE', 'REGULAR QUALITY', '0222333444');




-- --------------------------------------------------------

--
-- Table structure for table `usermanagement`
--

CREATE TABLE `usermanagement` (
  `UserID` int(11) NOT NULL,
  `UserName` varchar(250) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `ProfilePicture` mediumtext DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `PhoneNumber` varchar(10) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL CHECK (`Status` in (0,1)),
  `UserRole` int(11) DEFAULT NULL CHECK (`UserRole` in (0,1,2))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usermanagement`
--

INSERT INTO `usermanagement` (`UserID`, `UserName`, `Password`, `ProfilePicture`, `Age`, `PhoneNumber`, `Status`, `UserRole`) VALUES
(1, 'admin', 'admin', '\\src\\main\\resources\\com\\Icon\\DefaultUserImage.png', 30, '1234567890', 0, 2),
(2, 'manager', '12345', '\\src\\main\\resources\\com\\Icon\\DefaultUserImage.png', 18, '0912323232', 0, 0),
(3, 'employee', '12345', '\\src\\main\\resources\\com\\Icon\\DefaultUserImage.png', 25, '0923127323', 0, 1),
(4, 'Hoang', '12345', '\\src\\main\\resources\\com\\Icon\\DefaultUserImage.png', 19, '0912321321', 0, 0),
(5, 'Anh', '12345', '\\src\\main\\resources\\com\\Icon\\DefaultUserImage.png', 20, '0812321321', 0, 0),
(6, 'Thu', '12345', '\\src\\main\\resources\\com\\Icon\\DefaultUserImage.png', 30, '0712312321', 0, 1),
(7, 'Thieu', '12345', '\\src\\main\\resources\\com\\Icon\\DefaultUserImage.png', 24, '0812321321', 0, 1),
(8, 'Hoa', '12354', '\\src\\main\\resources\\com\\Icon\\DefaultUserImage.png', 20, '0814133243', 0, 0),
(9, 'Anh Thu', '12345', '\\src\\main\\resources\\com\\Icon\\DefaultUserImage.png', 27, '0981232132', 0, 0),
(10, 'Thanh', '12345', '\\src\\main\\resources\\com\\Icon\\DefaultUserImage.png', 27, '0981232332', 0, 1);
--
-- Indexes for dumped tables
--

--
-- Indexes for table `certificatemanagement`
--
ALTER TABLE `certificatemanagement`
  ADD PRIMARY KEY (`CertificateID`),
  ADD KEY `StudentID` (`StudentID`);

--
-- Indexes for table `loginhistory`
--
ALTER TABLE `loginhistory`
  ADD PRIMARY KEY (`LoginHistoryID`),
  ADD KEY `FK_LoginHistory_UserID` (`UserID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `usermanagement`
--
ALTER TABLE `usermanagement`
  ADD PRIMARY KEY (`UserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `certificatemanagement`
--
ALTER TABLE `certificatemanagement`
  MODIFY `CertificateID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;

--
-- AUTO_INCREMENT for table `loginhistory`
--
ALTER TABLE `loginhistory`
  MODIFY `LoginHistoryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `usermanagement`
--
ALTER TABLE `usermanagement`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `certificatemanagement`
--
ALTER TABLE `certificatemanagement`
  ADD CONSTRAINT `certificatemanagement_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student` (`ID`) ON DELETE CASCADE;

--
-- Constraints for table `loginhistory`
--
ALTER TABLE `loginhistory`
  ADD CONSTRAINT `FK_LoginHistory_UserID` FOREIGN KEY (`UserID`) REFERENCES `usermanagement` (`UserID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
