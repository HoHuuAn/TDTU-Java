-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 08, 2023 at 08:07 PM
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
-- Database: `process1`
--

-- --------------------------------------------------------

--
-- Table structure for table `managers`
--

CREATE TABLE `managers` (
  `id` varchar(255) NOT NULL,
  `fullName` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `managers`
--

INSERT INTO `managers` (`id`, `fullName`, `email`, `password`) VALUES
('M001', 'John Doe', 'johndoe@example.com', 'password1234566785'),
('M002', 'Jane Smith', 'janesmith@example.com', 'password456123'),
('M003', 'Michael Johnson', 'michaeljohnson@example.com', 'password789'),
('M004', 'Emily Davis', 'emilydavis@example.com', 'passwordabc'),
('M005', 'David Wilson', 'davidwilson@example.com', 'passworddef'),
('M006', 'Sarah Anderson', 'sarahanderson@example.com', 'passwordghi'),
('M007', 'Robert Thompson', 'robertthompson@example.com', 'passwordjkl'),
('M008', 'Jessica Lee', 'jessicalee@example.com', 'passwordmno'),
('M009', 'Matthew Clark', 'matthewclark@example.com', 'passwordpqr'),
('M010', 'Olivia Turner', 'oliviaturner@example.com', 'passwordstu'),
('M011', 'Alex Johnson', 'alexjohnson@example.com', 'password123'),
('M012', 'Samantha Davis', 'samanthadavis@example.com', 'password456'),
('M013', 'Daniel Wilson', 'danielwilson@example.com', 'password789'),
('M014', 'Oliver Thompson', 'oliverthompson@example.com', 'passwordabc'),
('M015', 'Sophia Lee', 'sophialee@example.com', 'passworddef'),
('M016', 'Jacob Wilson', 'jacobwilson@example.com', 'password123'),
('M017', 'Isabella Anderson', 'isabellaanderson@example.com', 'password456'),
('M018', 'Ethan Thompson', 'ethanthompson@example.com', 'password789'),
('M019', 'Mia Lee', 'mialee@example.com', 'passwordabc'),
('M020', 'William Johnson', 'williamjohnson@example.com', 'passworddef'),
('M021', 'Ava Davis', 'avadavis@example.com', 'passwordghi'),
('M022', 'James Wilson', 'jameswilson@example.com', 'passwordjkl'),
('M023', 'Charlotte Thompson', 'charlottethompson@example.com', 'passwordmno789'),
('M024', 'Benjamin Lee', 'benjaminlee@example.com', 'passwordpqr789456'),
('M025', 'Harper Clark', 'harperclark@example.com', 'passwordstu123456');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `IsActive` tinyint(1) NOT NULL DEFAULT 1,
  `DateCreated` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `phone`, `IsActive`, `DateCreated`) VALUES
('521H0489', 'Hồ Hữu An', '521H0489@student.tdtu.edu.vn', '0906881769', 1, '2023-10-04 16:09:24'),
('user001', 'John Doe', 'john.doe@example.com', '1234567890', 1, '2023-10-03 14:25:46'),
('user002', 'Jane Smith', 'jane.smith@example.com', '9876543210', 1, '2023-10-03 14:25:46'),
('user003', 'Mike Johnson', 'mike.johnson@example.com', '5555555555', 1, '2023-10-03 14:25:46'),
('user004', 'Emily Johnson', 'emily.johnson@example.com', '5551234567', 0, '2023-10-03 14:26:41'),
('user005', 'Michael Brown', 'michael.brown@example.com', '9876543210', 0, '2023-10-03 14:26:41'),
('user006', 'Sarah Davis', 'sarah.davis@example.com', '1234567890', 0, '2023-10-03 14:26:41'),
('user007', 'David Wilson', 'david.wilson@example.com', '5555555555', 1, '2023-10-03 14:26:49'),
('user008', 'Jessica Thompson', 'jessica.thompson@example.com', '4444444444', 0, '2023-10-03 14:26:49'),
('user009', 'Daniel Anderson', 'daniel.anderson@example.com', '9999999999', 1, '2023-10-03 14:26:49'),
('user010', 'Olivia Martinez', 'olivia.martinez@example.com', '5557778888', 1, '2023-10-03 18:28:07'),
('user011', 'Christopher Lee', 'christopher.lee@example.com', '2223334444', 1, '2023-10-03 18:28:07'),
('user012', 'Sophia Taylor', 'sophia.taylor@example.com', '7778889999', 1, '2023-10-03 18:28:07'),
('user013', 'Robert Wilson', 'robert.wilson@example.com', '1112223333', 1, '2023-10-03 18:28:28'),
('user014', 'Jennifer Adams', 'jennifer.adams@example.com', '4445556666', 1, '2023-10-03 18:28:28'),
('user015', 'Andrew Smith', 'andrew.smith@example.com', '7778889999', 1, '2023-10-03 18:28:28'),
('user016', 'Amanda Johnson', 'amanda.johnson@example.com', '2223334444', 1, '2023-10-03 18:28:37'),
('user017', 'Matthew Davis', 'matthew.davis@example.com', '5556667777', 1, '2023-10-03 18:28:37'),
('user018', 'Elizabeth Brown', 'elizabeth.brown@example.com', '8889990000', 1, '2023-10-03 18:28:37'),
('user019', 'William Jones', 'william.jones@example.com', '4445556666', 1, '2023-10-04 12:06:15'),
('user020', 'Sophie Wilson', 'sophie.wilson@example.com', '7778889999', 1, '2023-10-04 12:06:15');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `managers`
--
ALTER TABLE `managers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
