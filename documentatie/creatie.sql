-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 06, 2015 at 05:25 PM
-- Server version: 5.7.9
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `project_jee_2015`
--

-- --------------------------------------------------------

--
-- Table structure for table `Adres`
--

CREATE TABLE `Adres` (
  `anr` int(11) NOT NULL,
  `straatnaam` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `straatnr` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `postcode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `Adres`
--

INSERT INTO `Adres` (`anr`, `straatnaam`, `straatnr`, `postcode`) VALUES
(0, 'void', 'void', 0),
(4, 'klantStraat', '19', 1928);

-- --------------------------------------------------------

--
-- Table structure for table `Filiaal`
--

CREATE TABLE `Filiaal` (
  `fnr` int(11) NOT NULL,
  `fnaam` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `Filiaal`
--

INSERT INTO `Filiaal` (`fnr`, `fnaam`) VALUES
(1, 'filiaal 1');

-- --------------------------------------------------------

--
-- Table structure for table `Klant`
--

CREATE TABLE `Klant` (
  `knr` int(11) NOT NULL,
  `pnr` int(11) NOT NULL,
  `fnr` int(11) NOT NULL,
  `anr` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `Klant`
--

INSERT INTO `Klant` (`knr`, `pnr`, `fnr`, `anr`) VALUES
(1, 2, 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `Lening`
--

CREATE TABLE `Lening` (
  `lnr` int(11) NOT NULL,
  `anr` int(11) NOT NULL,
  `knr` int(11) NOT NULL,
  `interest` double NOT NULL,
  `saldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `Lening`
--

INSERT INTO `Lening` (`lnr`, `anr`, `knr`, `interest`, `saldo`) VALUES
(2, 0, 1, 0.02, 20000),
(3, 4, 1, 0.08, 15000);

-- --------------------------------------------------------

--
-- Table structure for table `Persoon`
--

CREATE TABLE `Persoon` (
  `pnr` int(11) NOT NULL,
  `pvoornaam` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pachternaam` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `userpass` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `usergroup` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `Persoon`
--

INSERT INTO `Persoon` (`pnr`, `pvoornaam`, `pachternaam`, `username`, `userpass`, `usergroup`) VALUES
(1, 'Roy', 'Scheerens', 'roy', 'pass', 'werknemer'),
(2, 'klant', 'klant', 'klant', 'pass', 'klant'),
(4, 'Matthias', 'Van Gestel', 'fenrig', 'pass', 'werknemer');

-- --------------------------------------------------------

--
-- Table structure for table `Variabele Lening`
--

CREATE TABLE `Variabele Lening` (
  `varnr` int(11) NOT NULL,
  `lnr` int(11) NOT NULL,
  `maxrente` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `Variabele Lening`
--

INSERT INTO `Variabele Lening` (`varnr`, `lnr`, `maxrente`) VALUES
(3, 3, 0.11);

-- --------------------------------------------------------

--
-- Table structure for table `Vaste Lening`
--

CREATE TABLE `Vaste Lening` (
  `vastnr` int(11) NOT NULL,
  `lnr` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `Vaste Lening`
--

INSERT INTO `Vaste Lening` (`vastnr`, `lnr`) VALUES
(1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `Werknemer`
--

CREATE TABLE `Werknemer` (
  `wnr` int(11) NOT NULL,
  `pnr` int(11) NOT NULL,
  `fnr` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `Werknemer`
--

INSERT INTO `Werknemer` (`wnr`, `pnr`, `fnr`) VALUES
(1, 4, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Adres`
--
ALTER TABLE `Adres`
  ADD PRIMARY KEY (`anr`);

--
-- Indexes for table `Filiaal`
--
ALTER TABLE `Filiaal`
  ADD PRIMARY KEY (`fnr`);

--
-- Indexes for table `Klant`
--
ALTER TABLE `Klant`
  ADD PRIMARY KEY (`knr`),
  ADD UNIQUE KEY `pnr_2` (`pnr`),
  ADD KEY `pnr` (`pnr`),
  ADD KEY `fnr` (`fnr`),
  ADD KEY `anr` (`anr`);

--
-- Indexes for table `Lening`
--
ALTER TABLE `Lening`
  ADD PRIMARY KEY (`lnr`),
  ADD KEY `anr` (`anr`),
  ADD KEY `knr` (`knr`);

--
-- Indexes for table `Persoon`
--
ALTER TABLE `Persoon`
  ADD PRIMARY KEY (`pnr`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `Variabele Lening`
--
ALTER TABLE `Variabele Lening`
  ADD PRIMARY KEY (`varnr`),
  ADD UNIQUE KEY `lnr` (`lnr`);

--
-- Indexes for table `Vaste Lening`
--
ALTER TABLE `Vaste Lening`
  ADD PRIMARY KEY (`vastnr`),
  ADD UNIQUE KEY `lnr` (`lnr`);

--
-- Indexes for table `Werknemer`
--
ALTER TABLE `Werknemer`
  ADD PRIMARY KEY (`wnr`),
  ADD UNIQUE KEY `pnr_2` (`pnr`),
  ADD KEY `pnr` (`pnr`),
  ADD KEY `fnr` (`fnr`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Adres`
--
ALTER TABLE `Adres`
  MODIFY `anr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `Filiaal`
--
ALTER TABLE `Filiaal`
  MODIFY `fnr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Klant`
--
ALTER TABLE `Klant`
  MODIFY `knr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Lening`
--
ALTER TABLE `Lening`
  MODIFY `lnr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `Persoon`
--
ALTER TABLE `Persoon`
  MODIFY `pnr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `Variabele Lening`
--
ALTER TABLE `Variabele Lening`
  MODIFY `varnr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `Vaste Lening`
--
ALTER TABLE `Vaste Lening`
  MODIFY `vastnr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Werknemer`
--
ALTER TABLE `Werknemer`
  MODIFY `wnr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Klant`
--
ALTER TABLE `Klant`
  ADD CONSTRAINT `Klant_ibfk_1` FOREIGN KEY (`pnr`) REFERENCES `Persoon` (`pnr`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Klant_ibfk_2` FOREIGN KEY (`fnr`) REFERENCES `Filiaal` (`fnr`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Klant_ibfk_3` FOREIGN KEY (`anr`) REFERENCES `Adres` (`anr`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Lening`
--
ALTER TABLE `Lening`
  ADD CONSTRAINT `Lening_ibfk_1` FOREIGN KEY (`knr`) REFERENCES `Klant` (`knr`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Lening_ibfk_2` FOREIGN KEY (`anr`) REFERENCES `Adres` (`anr`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Variabele Lening`
--
ALTER TABLE `Variabele Lening`
  ADD CONSTRAINT `Variabele Lening_ibfk_1` FOREIGN KEY (`lnr`) REFERENCES `Lening` (`lnr`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Vaste Lening`
--
ALTER TABLE `Vaste Lening`
  ADD CONSTRAINT `Vaste Lening_ibfk_1` FOREIGN KEY (`lnr`) REFERENCES `Lening` (`lnr`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Werknemer`
--
ALTER TABLE `Werknemer`
  ADD CONSTRAINT `fnrconstraint` FOREIGN KEY (`fnr`) REFERENCES `Filiaal` (`fnr`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pnrconstraint` FOREIGN KEY (`pnr`) REFERENCES `Persoon` (`pnr`) ON DELETE CASCADE ON UPDATE CASCADE;
