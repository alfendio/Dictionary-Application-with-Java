-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 23 Des 2018 pada 09.40
-- Versi Server: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mhsiswa`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `mhsrmi`
--

CREATE TABLE IF NOT EXISTS `mhsrmi` (
  `npm` bigint(50) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `jurusan` varchar(50) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `phone` bigint(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mhsrmi`
--

INSERT INTO `mhsrmi` (`npm`, `nama`, `jurusan`, `alamat`, `phone`) VALUES
(201610225001, 'Kurokoo', 'Teknik Informatika', 'Numpang', 990909092),
(201610225200, 'Arry Febryan', 'Teknik Informatika', 'Kepo', 895333536852);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mhsrmi`
--
ALTER TABLE `mhsrmi`
  ADD PRIMARY KEY (`npm`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
