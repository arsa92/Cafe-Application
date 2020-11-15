-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2020 at 09:41 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cafe`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `id_bill` int(11) NOT NULL,
  `table_number` int(11) DEFAULT NULL,
  `bill_time` timestamp NULL DEFAULT current_timestamp(),
  `id_restaurant` int(11) NOT NULL,
  `waiterName` varchar(100) NOT NULL,
  `finalAmount` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`id_bill`, `table_number`, `bill_time`, `id_restaurant`, `waiterName`, `finalAmount`) VALUES
(20, 1, '2020-05-02 22:23:11', 1, 'Waiter 1', 908),
(21, 1, '2020-03-01 23:21:32', 1, 'Waiter 2', 572),
(22, 1, '2020-05-19 00:09:07', 1, 'Waiter 3', 1666),
(23, 1, '2020-04-01 13:13:12', 1, 'Waiter 1', 685),
(24, 1, '2020-06-10 09:05:19', 1, 'Waiter 5', 490),
(25, 1, '2020-07-26 20:44:59', 1, 'Filip', 9359),
(26, 4, '2020-07-26 23:10:20', 1, 'Filip', 7435),
(27, 1, '2020-07-26 23:31:47', 1, 'Filip', 1624),
(28, 4, '2020-07-26 23:37:45', 1, 'Filip', 1337),
(29, 1, '2020-07-26 23:38:18', 1, 'Filip', 987),
(30, 1, '2020-07-27 09:27:29', 1, 'Filip', 1587),
(31, 0, '2020-07-27 10:22:08', 1, 'Filip', 0),
(32, 0, '2020-07-27 10:23:31', 1, 'Filip', 0),
(33, 0, '2020-07-27 10:25:01', 1, 'Filip', 0),
(34, 1, '2020-07-27 10:25:59', 1, 'Filip', 1337),
(35, 0, '2020-07-27 10:52:45', 1, 'Filip', 1237),
(36, 0, '2020-07-27 10:54:34', 1, 'Filip', 20),
(37, 0, '2020-07-27 12:58:43', 1, 'Filip', 1237),
(38, 1, '2020-07-27 13:02:16', 1, 'Filip', 0),
(39, 0, '2020-07-27 13:02:23', 1, 'Filip', 0),
(40, 0, '2020-07-27 13:03:29', 1, 'Filip', 40),
(41, 0, '2020-07-27 13:04:30', 1, 'Filip', 40),
(42, 0, '2020-07-27 13:09:01', 1, 'Filip', 20),
(43, 1, '2020-08-01 20:18:37', 1, 'Filip', 1399),
(44, 1, '2020-08-01 20:19:32', 1, 'Filip', 357),
(45, 0, '2020-08-01 20:19:35', 1, 'Filip', 357),
(46, 0, '2020-08-05 13:14:14', 1, 'Filip', 4101),
(47, 0, '2020-08-13 13:25:38', 1, 'Filip', 1587),
(48, 0, '2020-08-13 13:28:25', 1, 'Filip', 3174),
(49, 0, '2020-08-13 13:43:13', 1, 'Filip', 1237),
(50, 0, '2020-08-13 14:07:56', 1, 'Filip', 2474),
(51, 0, '2020-09-02 22:07:20', 1, 'Filip', 2674),
(52, 0, '2020-09-02 22:08:03', 1, 'Filip', 2474),
(53, 0, '2020-09-02 22:08:57', 1, 'Filip', 196),
(54, 0, '2020-09-02 22:12:16', 1, 'Filip', 5348),
(55, 0, '2020-09-02 22:15:24', 1, 'Filip', 400),
(56, 0, '2020-09-02 22:16:58', 1, 'Filip', 200),
(57, 0, '2020-09-02 22:18:43', 1, 'Filip', 200),
(58, 0, '2020-09-02 22:21:13', 1, 'Filip', 500),
(59, 0, '2020-09-02 22:22:25', 1, 'Filip', 500),
(60, 0, '2020-09-02 22:23:30', 1, 'Filip', 200),
(61, 0, '2020-09-02 22:24:41', 1, 'Filip', 200),
(62, 0, '2020-09-02 22:25:45', 1, 'Filip', 800),
(63, 0, '2020-09-02 22:26:34', 1, 'Filip', 600),
(64, 0, '2020-09-02 22:28:06', 1, 'Filip', 600),
(65, 0, '2020-09-02 22:30:17', 1, 'Filip', 800),
(66, 0, '2020-09-02 22:31:44', 1, 'Filip', 600),
(67, 0, '2020-09-03 00:56:51', 1, 'Filip', 5348),
(68, 0, '2020-09-03 13:25:14', 1, 'Filip', 1435),
(69, 0, '2020-11-15 19:34:16', 1, 'Filip', 98),
(70, 0, '2020-11-15 19:37:17', 1, 'Filip', 4948),
(71, 0, '2020-11-15 19:58:29', 1, 'Filip', 1237);

-- --------------------------------------------------------

--
-- Table structure for table `bill_orders_map`
--

CREATE TABLE `bill_orders_map` (
  `id_bill` int(11) NOT NULL,
  `id_order` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill_orders_map`
--

INSERT INTO `bill_orders_map` (`id_bill`, `id_order`) VALUES
(20, 120),
(21, 121),
(21, 122),
(22, 123),
(22, 124),
(23, 126),
(23, 127),
(24, 129),
(25, 2),
(26, 2),
(27, 2),
(28, 2),
(29, 2),
(30, 2),
(31, 2),
(32, 2),
(33, 2),
(34, 2),
(35, 2),
(36, 2),
(37, 2),
(38, 2),
(39, 2),
(40, 2),
(41, 2),
(42, 2),
(43, 2),
(44, 2),
(45, 2),
(46, 2),
(47, 2),
(48, 2),
(49, 2),
(50, 2),
(51, 2),
(52, 2),
(53, 2),
(54, 2),
(55, 2),
(56, 2),
(57, 2),
(58, 2),
(59, 2),
(60, 2),
(61, 2),
(62, 2),
(63, 2),
(64, 2),
(65, 2),
(66, 2),
(67, 2),
(68, 2),
(69, 2),
(70, 2),
(71, 2);

-- --------------------------------------------------------

--
-- Table structure for table `existing_ingredients`
--

CREATE TABLE `existing_ingredients` (
  `id_existing_ingredients` int(11) NOT NULL,
  `id_restaurant` int(55) NOT NULL,
  `id_ingredient` int(55) NOT NULL,
  `quantity` double(20,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `existing_ingredients`
--

INSERT INTO `existing_ingredients` (`id_existing_ingredients`, `id_restaurant`, `id_ingredient`, `quantity`) VALUES
(1, 1, 3, 5.00),
(2, 1, 1, 3.00),
(4, 1, 17, 7.00),
(5, 1, 12, 5.60),
(6, 1, 6, 0.00),
(7, 1, 15, 54.00),
(51, 1, 8, 3.92),
(54, 1, 2, 30.10),
(58, 1, 7, 20.96),
(59, 1, 11, 10.20),
(62, 1, 4, 49.30),
(63, 1, 14, 10.90),
(65, 1, 9, 34.60),
(66, 1, 5, 8.00),
(68, 1, 21, 17.00),
(74, 1, 22, 11.00),
(75, 1, 23, 2.00),
(76, 1, 24, 15.00),
(77, 1, 25, 112.00),
(79, 1, 10, 11.00),
(80, 1, 13, 3.00),
(81, 1, 18, 8.00),
(83, 1, 12, 5.60),
(84, 1, 25, 14.00),
(85, 1, 23, 1.00),
(86, 1, 19, 3.00),
(87, 1, 20, 18.00),
(89, 1, 12, 5.60),
(91, 1, 26, 90.00),
(92, 1, 27, 12.00),
(94, 1, 21, 17.00),
(95, 1, 18, 31.00),
(117, 1, 28, 12.00),
(120, 1, 10, 11.00),
(121, 1, 21, 17.00),
(122, 1, 20, 12.00),
(130, 1, 38, 66.98),
(131, 1, 38, 66.98),
(132, 1, 39, 33.33),
(135, 1, 42, 22.22),
(136, 1, 43, 55.76),
(138, 1, 45, 1.00),
(141, 1, 48, 11.00),
(142, 1, 49, 0.00),
(143, 1, 50, 5.00),
(144, 1, 51, 2.00),
(146, 1, 53, 3.00);

-- --------------------------------------------------------

--
-- Table structure for table `ingredients`
--

CREATE TABLE `ingredients` (
  `id_ingredient` int(11) NOT NULL,
  `price` float NOT NULL,
  `ingredient_name` varchar(50) NOT NULL,
  `measurement_quantity` enum('l','kg','pieces') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ingredients`
--

INSERT INTO `ingredients` (`id_ingredient`, `price`, `ingredient_name`, `measurement_quantity`) VALUES
(1, 1237, 'Pina Colada', 'l'),
(2, 162, 'Pelinkovac', 'l'),
(3, 1337, 'Schweps', 'l'),
(4, 247, 'Jagermeister', 'l'),
(5, 1187, 'Grey Goose', 'l'),
(6, 1587, 'VermouthE', 'l'),
(7, 357, 'Sugar', 'kg'),
(8, 1367, 'Rum', 'l'),
(9, 82, 'Mineral Water', 'l'),
(10, 357, 'Lime', 'kg'),
(11, 1837, 'Tequila', 'l'),
(12, 287, 'Orange Juice', 'l'),
(13, 367, 'Pineapple Juice', 'kg'),
(14, 177, 'Champaigne', 'kg'),
(15, 987, 'Chicago Pizza', 'pieces'),
(17, 98, 'Fanta', 'pieces'),
(18, 62, 'Coffee', 'pieces'),
(19, 1036, 'St. Louis Pizza', 'pieces'),
(20, 437, 'Sandwich', 'pieces'),
(21, 2148, 'Pizza Napolitana', 'pieces'),
(22, 162, 'Salt', 'kg'),
(23, 977, 'Espresso Coffee', 'kg'),
(24, 55.55, 'Milk', 'l'),
(25, 187, 'Random', 'l'),
(26, 200, 'test', 'kg'),
(27, 122, 'Sprite', 'pieces'),
(28, 127, 'Seven Up', 'pieces'),
(29, 55.55, 'mejh', 'kg'),
(30, 10, 'arsa', 'pieces'),
(31, 55, 'ime', 'kg'),
(32, 5, 'm', 'kg'),
(33, 1, 'a', 'kg'),
(34, 5, 'b', 'kg'),
(35, 55.55, 'arsenije', 'kg'),
(36, 80, 'radivoje', 'kg'),
(37, 0.5, 'radivojcevic', 'kg'),
(38, 77.77, 'Cookie', 'pieces'),
(39, 33.33, 'Caramel Machiato', 'kg'),
(42, 22.22, 'Lemonade', 'kg'),
(43, 55.55, 'Bitter lemon', 'pieces'),
(45, 0, 'Sex on the Beach', 'pieces'),
(48, 1, 'Blue lagoon', 'pieces'),
(49, 1, 'Darth Vader', 'pieces'),
(50, 5, 'lola1', 'l'),
(51, 3, 'kiki', 'l'),
(53, 20, 'kafa', 'l');

-- --------------------------------------------------------

--
-- Table structure for table `order_offers`
--

CREATE TABLE `order_offers` (
  `id_order` int(11) NOT NULL,
  `table_number` int(11) NOT NULL,
  `price` double NOT NULL,
  `id_ingredient` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `restaurants`
--

CREATE TABLE `restaurants` (
  `id_restaurant` int(11) NOT NULL,
  `name_restaurant` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restaurants`
--

INSERT INTO `restaurants` (`id_restaurant`, `name_restaurant`) VALUES
(1, 'First Restaurant');

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_table`
--

CREATE TABLE `restaurant_table` (
  `id_restaurant_table` int(11) NOT NULL,
  `table_number` int(11) NOT NULL,
  `id_restaurant` int(11) NOT NULL,
  `table_status` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restaurant_table`
--

INSERT INTO `restaurant_table` (`id_restaurant_table`, `table_number`, `id_restaurant`, `table_status`) VALUES
(1, 1, 1, 0),
(2, 2, 1, 0),
(3, 3, 1, 0),
(4, 4, 1, 0),
(31, 5, 1, 0),
(32, 8, 1, 0),
(33, 9, 1, 0),
(34, 10, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `role_name` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id_role`, `role_name`) VALUES
(1, 'owner'),
(2, 'manager'),
(3, 'waiter');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `first_name` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `status` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `first_name`, `username`, `password`, `status`) VALUES
(1, 'Admin', 'admin', 'admin', 1),
(2, 'Filip', 'arsa', 'arsa', 1),
(3, 'Dejan', 'deki', 'deki', 1),
(4, 'zavrsni', 'rad', '12', NULL),
(5, 'b', 'b', '14', 0),
(6, 'miha', 'mejhic', 'mejhic', 0),
(7, 'lmao', 'testiranje', 'a', 0),
(8, 'profesor', 'predrag', 'pejovic92', 0),
(9, 'a', 'a', 'a', 0),
(10, 'Filip Arsenijevic', 'Arsenita', 'arsa123', 0),
(11, 'e', 'e', 'e', 0),
(12, 'testadmin', 'admierer', '123', 0),
(13, 'tata', 'tata', '123', 1),
(14, 'Radivoje', 'radicevic', '09575', 1),
(15, 'rada', 'rada', '12345', 1),
(16, 'tesa', 'tesanovic', '555333', 1),
(17, 'y', 'y', 'y', 1),
(18, 'i', 'i', '1', 1),
(19, 'f', 'f', '1', 0),
(20, 'a', 'a', '1', 0),
(21, 'a', 'a', '1', 1),
(22, '', '', '', 0),
(23, '', '', '', 0),
(24, 'hey', 'hey', 'aehae', 0),
(25, 'Mirjana', 'Mirce', 'Mirce', 0),
(26, '', '', '', 0),
(27, 'a', 'a', '123', 0),
(28, 'testerica', 'lolerika', 'lolerica', 0),
(29, 'kristijan', 'golubovickris', '1234', 0),
(30, '', '', '', 0),
(31, 'test', 'test', 'test', 0),
(32, 'java', 'java', 'java', 0),
(33, 'nekitamo', 'nekilik', 'brat', 0),
(34, 'gastoz', 'gastoz', 'marinkovic', 0),
(35, 'aca', 'mejh', '123', 0),
(36, 'a', 'a', '123', 0),
(37, 'a', 'a', '123', 0),
(38, 'carnojevic', 'a', '123', 0),
(39, 'hehe', 'hehe', '123', 0),
(40, 'pp', 'pp', '123', 0),
(41, 'dejan', 'bogica', '1234', 0),
(42, 'marina', 'marina', '12345', 0),
(43, 'meks', 'meks', '12345', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_restaurant_map`
--

CREATE TABLE `user_restaurant_map` (
  `id_user` int(11) NOT NULL,
  `id_restaurant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_restaurant_map`
--

INSERT INTO `user_restaurant_map` (`id_user`, `id_restaurant`) VALUES
(1, 1),
(1, 1),
(2, 1),
(2, 1),
(2, 1),
(3, 1),
(3, 1),
(3, 1),
(3, 1),
(3, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(15, 1),
(16, 1),
(17, 1),
(18, 1),
(19, 1),
(20, 1),
(21, 1),
(22, 1),
(23, 1),
(24, 1),
(25, 1),
(26, 1),
(27, 1),
(28, 1),
(29, 1),
(30, 1),
(31, 1),
(32, 1),
(33, 1),
(34, 1),
(35, 1),
(36, 1),
(37, 1),
(38, 1),
(39, 1),
(40, 1),
(41, 1),
(42, 1),
(43, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_role_map`
--

CREATE TABLE `user_role_map` (
  `id_user` int(11) NOT NULL,
  `id_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_role_map`
--

INSERT INTO `user_role_map` (`id_user`, `id_role`) VALUES
(1, 1),
(3, 2),
(2, 3),
(8, 3),
(9, 3),
(10, 3),
(11, 3),
(12, 3),
(13, 3),
(14, 3),
(15, 1),
(16, 1),
(17, 1),
(18, 1),
(19, 3),
(20, 3),
(21, 1),
(22, 3),
(23, 3),
(24, 3),
(25, 3),
(26, 3),
(27, 3),
(28, 3),
(29, 3),
(30, 3),
(31, 3),
(32, 3),
(33, 3),
(34, 3),
(35, 3),
(36, 3),
(37, 3),
(38, 3),
(39, 3),
(40, 3),
(41, 3),
(42, 3),
(43, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id_bill`),
  ADD KEY `bill_ibfk_1` (`table_number`),
  ADD KEY `bill_ibfk_3` (`id_restaurant`);

--
-- Indexes for table `bill_orders_map`
--
ALTER TABLE `bill_orders_map`
  ADD KEY `id_bill` (`id_bill`),
  ADD KEY `id_order` (`id_order`);

--
-- Indexes for table `existing_ingredients`
--
ALTER TABLE `existing_ingredients`
  ADD PRIMARY KEY (`id_existing_ingredients`),
  ADD KEY `mejh` (`id_ingredient`),
  ADD KEY `mejh2` (`id_restaurant`);

--
-- Indexes for table `ingredients`
--
ALTER TABLE `ingredients`
  ADD PRIMARY KEY (`id_ingredient`),
  ADD UNIQUE KEY `ingredient_name` (`ingredient_name`),
  ADD UNIQUE KEY `ingredient_name_2` (`ingredient_name`),
  ADD UNIQUE KEY `ingredient_name_3` (`ingredient_name`),
  ADD UNIQUE KEY `ingredient_name_4` (`ingredient_name`);

--
-- Indexes for table `order_offers`
--
ALTER TABLE `order_offers`
  ADD PRIMARY KEY (`id_order`);

--
-- Indexes for table `restaurants`
--
ALTER TABLE `restaurants`
  ADD PRIMARY KEY (`id_restaurant`),
  ADD UNIQUE KEY `name_restaurant` (`name_restaurant`);

--
-- Indexes for table `restaurant_table`
--
ALTER TABLE `restaurant_table`
  ADD PRIMARY KEY (`id_restaurant_table`),
  ADD KEY `id_restaurant` (`id_restaurant`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `user_restaurant_map`
--
ALTER TABLE `user_restaurant_map`
  ADD KEY `id_restaurant` (`id_restaurant`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `user_role_map`
--
ALTER TABLE `user_role_map`
  ADD KEY `id_role` (`id_role`),
  ADD KEY `id_user` (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `id_bill` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;

--
-- AUTO_INCREMENT for table `existing_ingredients`
--
ALTER TABLE `existing_ingredients`
  MODIFY `id_existing_ingredients` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=147;

--
-- AUTO_INCREMENT for table `ingredients`
--
ALTER TABLE `ingredients`
  MODIFY `id_ingredient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `order_offers`
--
ALTER TABLE `order_offers`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=712;

--
-- AUTO_INCREMENT for table `restaurants`
--
ALTER TABLE `restaurants`
  MODIFY `id_restaurant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `restaurant_table`
--
ALTER TABLE `restaurant_table`
  MODIFY `id_restaurant_table` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill_ibfk_3` FOREIGN KEY (`id_restaurant`) REFERENCES `restaurants` (`id_restaurant`);

--
-- Constraints for table `bill_orders_map`
--
ALTER TABLE `bill_orders_map`
  ADD CONSTRAINT `bill_orders_map_ibfk_1` FOREIGN KEY (`id_bill`) REFERENCES `bill` (`id_bill`);

--
-- Constraints for table `existing_ingredients`
--
ALTER TABLE `existing_ingredients`
  ADD CONSTRAINT `mejh` FOREIGN KEY (`id_ingredient`) REFERENCES `ingredients` (`id_ingredient`),
  ADD CONSTRAINT `mejh2` FOREIGN KEY (`id_restaurant`) REFERENCES `restaurants` (`id_restaurant`);

--
-- Constraints for table `restaurant_table`
--
ALTER TABLE `restaurant_table`
  ADD CONSTRAINT `restaurant_table_ibfk_1` FOREIGN KEY (`id_restaurant`) REFERENCES `restaurants` (`id_restaurant`);

--
-- Constraints for table `user_restaurant_map`
--
ALTER TABLE `user_restaurant_map`
  ADD CONSTRAINT `user_restaurant_map_ibfk_1` FOREIGN KEY (`id_restaurant`) REFERENCES `restaurants` (`id_restaurant`),
  ADD CONSTRAINT `user_restaurant_map_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `user_role_map`
--
ALTER TABLE `user_role_map`
  ADD CONSTRAINT `user_role_map_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`),
  ADD CONSTRAINT `user_role_map_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
