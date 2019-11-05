-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 04, 2019 at 12:18 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id2942596_phasereach`
--

-- --------------------------------------------------------

--
-- Table structure for table `list_of_users`
--

CREATE TABLE `list_of_users` (
  `User ID` int(11) UNSIGNED NOT NULL,
  `Username` tinytext DEFAULT NULL,
  `Password` tinytext DEFAULT NULL,
  `Name` tinytext DEFAULT NULL,
  `Age` tinyint(3) UNSIGNED DEFAULT 0,
  `Sex` tinytext DEFAULT NULL,
  `Address` tinytext DEFAULT NULL,
  `City` tinytext DEFAULT NULL,
  `Country` tinytext DEFAULT NULL,
  `Postal Code` tinytext DEFAULT NULL,
  `Phone1` tinytext DEFAULT NULL,
  `Phone2` tinytext DEFAULT NULL,
  `Emergency Contact Name` tinytext DEFAULT NULL,
  `Emergency Contact Phone` tinytext DEFAULT NULL,
  `User Level` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  `Active Trial IDs` tinytext DEFAULT NULL,
  `Past Trial IDs` tinytext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This table contains all the patient and raters.';

--
-- Dumping data for table `list_of_users`
--

INSERT INTO `patient` (`username`, `password`, `name`, `age`, `sex`, `address`, `city`, `country`, `postal_code`, `phone1`, `phone2`, `emergency_contact_name`, `emergency_contact_phone`) VALUES
('Patient04', 'Patient04', 'Buckethead', 22, 'M', 'Nottingham Lace', 'City?', 'Soothsayer', '40591', '0999555222', NULL, 'GoldenEye', '072222111'),
('Patient01', 'Patient01', 'User001', 55, 'M', '0122 Cloud District', 'White Run', 'Skyrim', '50903', '9975137', '496842', 'Wife001', '031234567'),
('Patient02', 'Patient02', 'The Killers', 22, 'M', 'Miss Atomic Bomb', 'City?', 'Read My Mind', '555777', '65616378', '6518745', 'Shot At The Night', '02689186'),
('Patient03', 'Patient03', 'Kings Of Leon', 25, 'M', 'Use Somebody', 'City?', 'Pyro', '95971', '5165789', '6489135', 'King Of The Rodeo', '65489797');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `list_of_users`
--
ALTER TABLE `list_of_users`
  ADD PRIMARY KEY (`User ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `list_of_users`
--
ALTER TABLE `list_of_users`
  MODIFY `User ID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
