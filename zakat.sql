-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2019 at 03:14 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zakat`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `id_admin` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`, `id_admin`) VALUES
('admin', 'admin', 1);

-- --------------------------------------------------------

--
-- Table structure for table `mustahiq`
--

CREATE TABLE `mustahiq` (
  `id` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `golongan` varchar(20) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mustahiq`
--

INSERT INTO `mustahiq` (`id`, `nama`, `golongan`, `alamat`) VALUES
('1', 'dito', 'Fakir', 'di kosan'),
('2', 'rifqi', 'Gharim', 'di kosan juga'),
('3', 'ahmad', 'Ibnu Sabil', 'di kosan mungkin'),
('4', 'varel', 'Amil Zakat', 'di kosan gan');

-- --------------------------------------------------------

--
-- Table structure for table `muzzakki`
--

CREATE TABLE `muzzakki` (
  `idZakat` varchar(20) NOT NULL,
  `idMuzzakki` varchar(20) NOT NULL,
  `namaMuzzakki` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jiwa` varchar(20) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `total` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `muzzakki`
--

INSERT INTO `muzzakki` (`idZakat`, `idMuzzakki`, `namaMuzzakki`, `alamat`, `jiwa`, `jenis`, `total`) VALUES
('1', '2', 'ahmad', 'jalanin saja dulu', '2', 'Uang', '123123123'),
('4', '3', 'Dito', 'Di mana Aja', '3', 'Uang', '45000');

-- --------------------------------------------------------

--
-- Table structure for table `tabzakat`
--

CREATE TABLE `tabzakat` (
  `idZakat` varchar(20) NOT NULL,
  `id` varchar(20) NOT NULL,
  `namaZakat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabzakat`
--

INSERT INTO `tabzakat` (`idZakat`, `id`, `namaZakat`) VALUES
('1', '1', 'Zakat Fitrah'),
('2', '3', 'Zakat saja'),
('3', '4', 'Zakat Mungkin'),
('4', '2', 'Zakat gan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `mustahiq`
--
ALTER TABLE `mustahiq`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `muzzakki`
--
ALTER TABLE `muzzakki`
  ADD PRIMARY KEY (`idMuzzakki`),
  ADD KEY `idZakat` (`idZakat`) USING BTREE;

--
-- Indexes for table `tabzakat`
--
ALTER TABLE `tabzakat`
  ADD PRIMARY KEY (`idZakat`),
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tabzakat`
--
ALTER TABLE `tabzakat`
  ADD CONSTRAINT `tabzakat_ibfk_1` FOREIGN KEY (`id`) REFERENCES `mustahiq` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
