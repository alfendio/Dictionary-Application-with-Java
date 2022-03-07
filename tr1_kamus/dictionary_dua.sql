-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 07, 2022 at 03:52 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dict_dua`
--

-- --------------------------------------------------------

--
-- Table structure for table `dictionary_dua`
--

CREATE TABLE `dictionary_dua` (
  `nomor` bigint(10) NOT NULL,
  `kata_indonesia` varchar(100) DEFAULT NULL,
  `jenis` varchar(100) DEFAULT NULL,
  `kata_inggris` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dictionary_dua`
--

INSERT INTO `dictionary_dua` (`nomor`, `kata_indonesia`, `jenis`, `kata_inggris`) VALUES
(1, 'kamu', 'kata ganti', 'you'),
(2, 'gelas', 'kata sifat', 'clear'),
(3, 'kita', 'kata ganti', 'we'),
(4, 'sekolah', 'kata benda', 'school'),
(5, 'bisa', 'kata kerja', 'can'),
(6, 'jalan', 'kata benda', 'road'),
(7, 'analisa', 'kata kerja', 'analytic'),
(8, 'teman', 'kata benda', 'friend'),
(9, 'malam', 'kata benda', 'night'),
(10, 'bersiul', 'kata kerja', 'wistle'),
(11, 'melihat', 'kata kerja', 'see'),
(12, 'kota', 'kata benda', 'city');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dictionary_dua`
--
ALTER TABLE `dictionary_dua`
  ADD PRIMARY KEY (`nomor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
