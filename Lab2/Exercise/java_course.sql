-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 22, 2023 at 10:39 PM
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
-- Database: `java_course`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `reset_auto_increment` ()   BEGIN
    DECLARE max_id INT;
    
    -- Step 1: Find the maximum value of the column 'id'
    SELECT MAX(id) INTO max_id FROM products;
    
    -- Step 2: Set the auto-increment value
    SET @sql = CONCAT('ALTER TABLE products AUTO_INCREMENT = ', max_id + 1);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(20) NOT NULL,
  `price` int(11) NOT NULL,
  `color` varchar(30) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `color`, `brand`, `description`, `quantity`) VALUES
(1, 'Samsung Galaxy S21', 1200, 'Black', 'Samsung', 'Powerful smartphone with great camera', 50),
(2, 'iPhone 12 Pro Max', 1500, 'Gold', 'Apple', 'High-end smartphone with advanced features', 30),
(3, 'Google Pixel 6', 900, 'White', 'Google', 'Flagship phone with excellent camera capabilities', 40),
(4, 'Xiaomi Mi 11', 800, 'Blue', 'Xiaomi', 'Affordable flagship phone with top-notch performance', 25),
(5, 'OnePlus 9 Pro', 1000, 'Silver', 'OnePlus', 'Premium smartphone with fast charging and smooth display', 35),
(6, 'LG G8 ThinQ', 700, 'Gray', 'LG', 'Feature-packed phone with exceptional audio quality', 20),
(7, 'Samsung Galaxy S22', 1300, 'Black', 'Samsung', 'Powerful smartphone with even better camera', 60),
(8, 'iPhone 13 Pro Max', 1600, 'Gold', 'Apple', 'High-end smartphone with even more advanced features', 40),
(9, 'Google Pixel 7', 1000, 'White', 'Google', 'Flagship phone with even more excellent camera capabilities', 50),
(10, 'Xiaomi Mi 12', 900, 'Blue', 'Xiaomi', 'Affordable flagship phone with even more top-notch performance', 30),
(11, 'OnePlus 10 Pro', 1100, 'Silver', 'OnePlus', 'Premium smartphone with even faster charging and smoother display', 45),
(12, 'LG V70 ThinQ', 800, 'Gray', 'LG', 'Feature-packed phone with even more exceptional audio quality', 25),
(13, 'Samsung Galaxy Note ', 1400, 'Black', 'Samsung', 'Powerful smartphone with great camera and stylus support', 70),
(14, 'iPhone 13 mini', 1000, 'Gold', 'Apple', 'High-end smartphone in a smaller form factor', 35),
(15, 'Google Pixel 6a', 700, 'White', 'Google', 'Affordable phone with excellent camera capabilities', 60),
(16, 'Xiaomi Redmi Note 11', 600, 'Blue', 'Xiaomi', 'Affordable phone with great performance and features', 40),
(17, 'OnePlus Nord 3', 800, 'Silver', 'OnePlus', 'Affordable phone with smooth display and fast charging', 55),
(18, 'LG K92 5G', 400, 'Gray', 'LG', 'Budget-friendly phone with 5G support', 30),
(19, 'Realme GT Neo 3', 700, 'Black', 'Realme', 'Affordable phone with fast charging and powerful processor', 50),
(20, 'POCO X4 Pro 5G', 500, 'Blue', 'POCO', 'Budget-friendly phone with great performance and features', 45),
(21, 'Asus ROG Phone 6 Pro', 1500, 'Silver', 'Asus', 'Gaming phone with powerful processor and smooth display', 35),
(22, 'Sony Xperia 1 IV', 1300, 'Black', 'Sony', 'Smartphone with high-end camera and display', 40),
(23, 'Nokia XR20', 600, 'Gray', 'Nokia', 'Rugged smartphone with long battery life', 30),
(24, 'Motorola Edge 30 Pro', 1000, 'Black', 'Motorola', 'Smartphone with curved display and fast charging', 45),
(25, 'Tecno Phantom X2 Pro', 900, 'Blue', 'Tecno', 'Smartphone with premium design and features', 40),
(26, 'Infinix Note 12 Pro', 700, 'Silver', 'Infinix', 'Affordable smartphone with great performance and features', 55),
(27, 'Vivo X80 Pro', 1200, 'Black', 'Vivo', 'Smartphone with high-end camera and display', 35),
(28, 'Oppo Find X5 Pro', 1400, 'Blue', 'Oppo', 'Smartphone with premium design and features', 40),
(29, 'Google Pixel Buds Pr', 200, 'White', 'Google', 'Wireless earbuds with active noise cancellation', 30),
(30, 'Apple AirPods Pro', 250, 'Black', 'Apple', 'Wireless earbuds with active noise cancellation', 25),
(31, 'Sony WF-1000XM4', 300, 'Blue', 'Sony', 'Wireless earbuds with active noise cancellation', 20),
(32, 'Sennheiser Momentum ', 250, 'Silver', 'Sennheiser', 'Wireless earbuds with excellent sound quality', 15),
(33, 'Jabra Elite 7 Pro', 200, 'Black', 'Jabra', 'Wireless earbuds with great active noise cancellation', 10),
(34, 'Samsung Galaxy Z Fol', 2000, 'Black', 'Samsung', 'Foldable smartphone with powerful features', 20),
(35, 'iPhone SE 2022', 600, 'White', 'Apple', 'Affordable iPhone with latest A15 Bionic chip', 30),
(36, 'Google Pixel 6 Pro', 1100, 'Blue', 'Google', 'Flagship phone with excellent camera capabilities and long battery life', 40),
(37, 'Xiaomi 12 Pro', 1000, 'Silver', 'Xiaomi', 'Affordable flagship phone with great performance and camera', 50),
(38, 'OnePlus 10T', 900, 'Black', 'OnePlus', 'Affordable flagship phone with fast charging and smooth display', 60),
(39, 'LG Wing', 800, 'Gray', 'LG', 'Unique smartphone with two swiveling displays', 25),
(40, 'Realme GT Neo 3T', 600, 'Blue', 'Realme', 'Affordable phone with fast charging and powerful processor', 50),
(41, 'POCO X4 GT', 400, 'Silver', 'POCO', 'Budget-friendly phone with great performance and features', 45),
(42, 'Asus Zenfone 9', 700, 'Black', 'Asus', 'Compact phone with great performance and camera', 35),
(43, 'Sony Xperia 10 IV', 600, 'White', 'Sony', 'Smartphone with long battery life and water resistance', 40),
(44, 'Nokia X30', 500, 'Gray', 'Nokia', 'Affordable smartphone with sustainable design', 30),
(45, 'Motorola Edge 30', 800, 'Black', 'Motorola', 'Smartphone with OLED display and fast charging', 45),
(46, 'Tecno Phantom X2', 700, 'Blue', 'Tecno', 'Smartphone with premium design and features', 40),
(47, 'Infinix Note 12', 600, 'Silver', 'Infinix', 'Affordable smartphone with great performance and features', 55),
(48, 'Vivo X80 Lite', 500, 'Black', 'Vivo', 'Affordable smartphone with great camera and display', 35),
(49, 'Oppo Find X5', 700, 'Blue', 'Oppo', 'Smartphone with premium design and features', 40),
(50, 'Samsung Galaxy Tab S', 1500, 'Black', 'Samsung', 'High-end tablet with powerful performance and large display', 20),
(51, 'iPad Pro 2022', 1200, 'White', 'Apple', 'High-end tablet with powerful M1 chip and Liquid Retina display', 30),
(52, 'Microsoft Surface Pr', 1000, 'Blue', 'Microsoft', '2-in-1 tablet with powerful performance and Windows 11', 40),
(53, 'Xiaomi Pad 5 Pro', 800, 'Silver', 'Xiaomi', 'Affordable tablet with great performance and display', 50),
(54, 'Lenovo Tab P11 Plus', 600, 'Black', 'Lenovo', 'Affordable tablet with great performance and features', 60),
(55, 'Samsung The Frame 65', 2000, 'Black', 'Samsung', '4K Smart TV with picture frame design', 20),
(56, 'LG C2 OLED 65-inch', 2500, 'White', 'LG', '4K OLED Smart TV with excellent picture quality', 30),
(57, 'Sony A80J OLED 65-in', 3000, 'Silver', 'Sony', '4K OLED Smart TV with excellent sound quality', 40),
(58, 'TCL 6-Series Roku TV', 800, 'Black', 'TCL', 'Affordable 4K Roku Smart TV with great picture quality', 50),
(60, 'Samsung Galaxy A52', 400, 'Violet', 'Samsung', 'Mid-range phone with a vibrant display', 20),
(61, 'Motorola Edge', 800, 'Silver', 'Motorola', 'Phone with curved edge display and good battery life', 15),
(62, 'Sony Xperia 5 II', 1100, 'Blue', 'Sony', 'Compact phone with powerful camera capabilities', 10),
(63, 'Huawei P30 Pro', 900, 'Aurora', 'Huawei', 'Phone with excellent low-light camera performance', 25),
(64, 'Nokia 9 PureView', 600, 'Black', 'Nokia', 'Phone with unique 5-camera array', 30),
(65, 'Xiaomi Redmi Note 10', 300, 'White', 'Xiaomi', 'Budget-friendly phone with a large display', 40),
(66, 'Google Pixel 5a', 700, 'Black', 'Google', 'Phone with stock Android experience and great camera', 20);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
