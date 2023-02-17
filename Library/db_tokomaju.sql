-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 17 Feb 2023 pada 14.01
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tokomaju`
--
CREATE DATABASE IF NOT EXISTS `db_tokomaju` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `db_tokomaju`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

DROP TABLE IF EXISTS `barang`;
CREATE TABLE `barang` (
  `id_barang` varchar(8) NOT NULL,
  `id_kategori` varchar(8) NOT NULL,
  `id_sales` varchar(8) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `harga_pokok` int(15) NOT NULL,
  `harga_jual` int(15) NOT NULL,
  `status` int(1) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`id_barang`, `id_kategori`, `id_sales`, `nama_barang`, `harga_pokok`, `harga_jual`, `status`, `created_at`, `updated_at`) VALUES
('BA00001', 'KA00000', 'SA00001', 'Barang 1', 10000, 20000, 0, '2023-02-13 18:41:30', '2023-02-13 18:53:09'),
('BA00002', 'KA00001', 'SA00001', 'Barang 2', 25000, 30000, 0, '2023-02-13 20:30:46', '2023-02-13 20:30:46'),
('BA00003', 'KA00000', 'SA00002', 'Barang 3', 10000, 20000, 0, '2023-02-13 21:27:28', '2023-02-13 21:27:28'),
('BA00004', 'KA00000', 'SA00001', 'Barang 4', 20000, 50000, 0, '2023-02-13 21:27:49', '2023-02-13 21:27:49'),
('BA00005', 'KA00000', 'SA00001', 'Barang 5', 2000, 5000, 0, '2023-02-13 21:28:02', '2023-02-13 21:28:02'),
('BA00006', 'KA00001', 'SA00001', 'Barang 6', 50000, 100000, 0, '2023-02-13 21:28:42', '2023-02-13 21:28:42'),
('BA00007', 'KA00000', 'SA00002', 'Barang 7', 20000, 50000, 0, '2023-02-13 21:33:59', '2023-02-13 21:33:59'),
('BA00008', 'KA00001', 'SA00002', 'Barang 8', 3000, 6000, 0, '2023-02-13 21:48:27', '2023-02-13 21:48:27');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

DROP TABLE IF EXISTS `kategori`;
CREATE TABLE `kategori` (
  `id_kategori` varchar(8) NOT NULL,
  `nama_kategori` varchar(50) NOT NULL,
  `status` int(1) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`, `status`, `created_at`, `updated_at`) VALUES
('KA00000', 'Tidak Ada', 0, '2023-02-13 18:39:21', '2023-02-13 18:39:21'),
('KA00001', 'Freon', 0, '2023-02-13 18:38:37', '2023-02-13 18:38:37');

-- --------------------------------------------------------

--
-- Struktur dari tabel `notasales`
--

DROP TABLE IF EXISTS `notasales`;
CREATE TABLE `notasales` (
  `id_nota` varchar(10) NOT NULL,
  `id_sales` varchar(8) NOT NULL,
  `total` int(20) NOT NULL,
  `tanggal_pelunasan` datetime DEFAULT NULL,
  `remark` text DEFAULT NULL,
  `status` int(1) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `notasales`
--

INSERT INTO `notasales` (`id_nota`, `id_sales`, `total`, `tanggal_pelunasan`, `remark`, `status`, `created_at`, `updated_at`) VALUES
('160223_01', 'SA00001', 200000, NULL, '', 0, '2023-02-16 21:23:03', '2023-02-16 21:23:03'),
('160223_02', 'SA00001', 1000000, NULL, '', 0, '2023-02-16 21:25:18', '2023-02-16 21:25:18');

-- --------------------------------------------------------

--
-- Struktur dari tabel `sales`
--

DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales` (
  `id_sales` varchar(8) NOT NULL,
  `nama_sales` varchar(50) NOT NULL,
  `alamat_sales` varchar(50) NOT NULL,
  `nohp_sales` varchar(13) NOT NULL,
  `status` int(1) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `sales`
--

INSERT INTO `sales` (`id_sales`, `nama_sales`, `alamat_sales`, `nohp_sales`, `status`, `created_at`, `updated_at`) VALUES
('SA00001', 'Digital Teknik', 'Jl Kapuk Raya No 10C RT/RW : 03/11', '021-54390960', 0, '2023-02-12 00:10:44', '2023-02-12 00:17:04'),
('SA00002', 'Hidayah Jaya Electric', 'Surabaya', '082234408876', 0, '2023-02-12 00:27:02', '2023-02-12 00:27:02');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indeks untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indeks untuk tabel `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id_sales`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
