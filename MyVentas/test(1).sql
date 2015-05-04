-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-05-2015 a las 06:35:11
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `test`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
`id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `customer`
--

INSERT INTO `customer` (`id`, `name`, `email`, `status`) VALUES
(1, 'Arturo M.', 'amatos@dinersclub.com.pe', 0),
(2, 'Katya A.', 'karanda@dinersclub.com.pe', 0),
(3, 'Flor A.', 'falvarez@dinersclub.com.pe', 0),
(4, 'Hansel P.', 'hpaz@proveedordcp.com.pe', 0),
(5, 'Arturo T.', 'atorres@dinersclub.com.pe', 0),
(6, 'Willy F.', 'wfrias@dinersclub.com.pe', 0),
(7, 'Rommel K.', 'rkerrigan@dinersclub.com.pe', 0),
(8, 'Flor R.', 'frivera@dinersclub.com.pe', 0),
(9, 'Juan Contreras', 'fyasuda@dinersclub.com.pe', 0),
(10, 'Mihai Ch.', 'mchavez@dinersclub.com.pe', 0),
(11, 'Jorge H.', 'jhuaman@dinersclub.com.pe', 0),
(12, 'Esmer G.', 'egarcia@dinersclub.com.pe', 0),
(13, 'Alaan P.', 'aplacencia@dinersclub.com.pe', 0),
(14, 'Julio M.', 'juliomt@dinersclub.com.pe', 0),
(15, 'Carlos P.', 'cpalomaressa@dinersclub.com.pe', 0),
(16, 'Jaime M.', 'jmuro@dinersclub.com.pe', 0),
(17, 'Pamela V.', 'pvilela@dinersclub.com.pe', 0),
(18, 'Cindy B.', 'cbazan@dinersclub.com.pe', 0),
(19, 'Miguel C.', 'mcisneros@dinersclub.com.pe', 0),
(20, 'Yris D.', 'ydiaz@dinersclub.com.pe', 0),
(21, 'Jaime S.', 'jsalazar@dinersclub.com.pe', 0),
(22, 'Stephanie S.', 'ssantisteban@dinersclub.com.pe', 0),
(23, 'Carlos Z.', 'czavala@dinersclub.com.pe', 0),
(24, 'Rosa T.', 'rtorres@dinersclub.com.pe', 0),
(25, 'Pepito', 'jramos@dinersclub.com.pe', 0),
(26, 'Jorge N.', 'jnavarro@proveedordcp.com.pe', 0),
(27, 'Mario H.', 'produdc@dinersclub.com.pe', 0),
(28, 'David R.', 'drodriguez@dinersclub.com.pe', 0),
(29, 'Yesenia A.', 'yaquino@proveedordcp.com.pe', 0),
(30, 'Saul G.', 'sgonzales@dinersclub.com.pe', 0),
(31, 'Javier E.', 'jescudero@dinersclub.com.pe', 0),
(32, 'Edson T.', 'etorres@dinersclub.com.pe', 0),
(33, 'Jesús A.', 'jaguirre@dinersclub.com.pe', 0),
(34, 'Dany M.', 'dmachaca@dinersclub.com.pe', 0),
(35, 'Fernando R.', 'produdc@dinersclub.com.pe', 0),
(36, 'Annie Z.', 'azamora@dinersclub.com.pe', 0),
(37, 'Juan B.', 'jblanco@dinersclub.com.pe ', 0),
(38, 'Fiorella', 'fbaca@dinersclub.com.pe ', 0),
(39, 'Angie G.', 'agallardo@dinersclub.com.pe', 0),
(40, 'David L.', 'dlopezc@dinersclub.com.pe', 0),
(41, 'Jose M.', 'jmota@proveedordcp.com.pe', 0),
(42, 'Barney S.', 'bsuarez@proveedordcp.com.pe', 0),
(43, 'Jorge Maza', 'jmaza@proveedordcp.com.pe', 0),
(44, 'Sandy Alvarez', 'salvarez@dinersclub.com.pe', 0),
(45, 'Alexandra L.', 'mlaguna@dinersclub.com.pe ', 0),
(46, 'Juan C.', 'jcontreras@proveedordcp.com.pe', 0),
(47, 'Dafne H.', 'dhiyo@dinersclub.com.pe', 0),
(48, 'Deysi L.', 'dluque@dinersclub.com.pe', 0),
(49, 'Dante H.', '', 0),
(50, 'Oscar', 'produdc@dinersclub.com.pe', 0);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `debt_detail_by_customer`
--
CREATE TABLE IF NOT EXISTS `debt_detail_by_customer` (
`id_product` int(11)
,`product_name` varchar(50)
,`price` double(3,2)
,`full_price` double(3,2)
,`quantity` int(11)
,`order_date` datetime
,`comment` varchar(50)
,`customer_name` varchar(100)
,`email` varchar(50)
,`id_customer` int(11)
);
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `order`
--

CREATE TABLE IF NOT EXISTS `order` (
`id` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '1',
  `price` double(3,2) NOT NULL DEFAULT '1.00',
  `full_price` double(3,2) NOT NULL DEFAULT '1.00',
  `order_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL DEFAULT '0',
  `comment` varchar(50) DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `order`
--

INSERT INTO `order` (`id`, `id_product`, `id_customer`, `quantity`, `price`, `full_price`, `order_date`, `status`, `comment`) VALUES
(1, 20, 6, 1, 1.50, 1.50, '2015-05-18 22:29:04', 0, ''),
(2, 16, 26, 1, 1.00, 1.00, '2015-05-18 22:30:40', 0, ''),
(3, 11, 11, 1, 1.50, 1.50, '2015-05-18 22:32:12', 0, ''),
(4, 16, 34, 1, 1.00, 1.00, '2015-05-18 22:32:53', 0, ''),
(5, 20, 34, 1, 1.50, 1.50, '2015-05-18 22:33:20', 0, ''),
(6, 16, 17, 1, 1.00, 1.00, '2015-05-18 22:33:52', 0, ''),
(7, 20, 11, 2, 1.50, 3.00, '2015-05-18 22:35:00', 0, ''),
(8, 11, 15, 2, 1.50, 3.00, '2015-05-18 22:35:44', 0, ''),
(9, 11, 13, 1, 1.50, 1.50, '2015-05-18 22:36:13', 0, ''),
(10, 16, 7, 1, 1.00, 1.00, '2015-05-18 22:38:15', 0, ''),
(11, 16, 32, 1, 1.00, 1.00, '2015-05-18 22:38:48', 0, ''),
(12, 16, 13, 1, 1.00, 1.00, '2015-05-18 22:40:28', 0, ''),
(13, 11, 1, 2, 1.50, 3.00, '2015-05-18 22:57:02', 0, ''),
(14, 10, 1, 2, 2.00, 4.00, '2015-05-18 22:57:14', 0, ''),
(15, 6, 35, 1, 2.00, 2.00, '2015-05-18 22:58:10', 0, ''),
(16, 6, 32, 1, 2.00, 2.00, '2015-05-18 22:58:47', 0, ''),
(17, 16, 37, 1, 1.00, 1.00, '2015-05-18 22:59:44', 0, ''),
(18, 11, 10, 4, 1.50, 6.00, '2015-05-18 23:00:26', 0, ''),
(19, 6, 10, 2, 2.00, 4.00, '2015-05-18 23:00:43', 0, ''),
(20, 18, 16, 1, 1.00, 1.00, '2015-05-18 23:01:28', 0, ''),
(21, 10, 16, 1, 2.00, 2.00, '2015-05-18 23:01:40', 0, ''),
(22, 16, 26, 2, 0.50, 1.00, '2015-05-18 23:02:51', 0, ''),
(23, 16, 22, 2, 1.00, 2.00, '2015-05-18 23:05:37', 0, ''),
(24, 10, 22, 1, 2.00, 2.00, '2015-05-18 23:05:52', 0, ''),
(25, 18, 22, 1, 1.00, 1.00, '2015-05-18 23:06:05', 0, ''),
(26, 10, 6, 1, 2.00, 2.00, '2015-05-18 23:06:24', 0, ''),
(27, 10, 11, 3, 2.00, 6.00, '2015-05-18 23:06:49', 0, ''),
(28, 10, 7, 1, 2.00, 2.00, '2015-05-18 23:07:10', 0, ''),
(29, 16, 46, 1, 1.00, 1.00, '2015-05-18 23:08:09', 0, ''),
(30, 1, 31, 1, 1.00, 1.00, '2015-05-18 23:08:39', 0, ''),
(31, 18, 2, 1, 1.00, 1.00, '2015-05-18 23:08:58', 0, ''),
(32, 18, 26, 2, 1.00, 2.00, '2015-05-18 23:09:49', 0, ''),
(33, 18, 50, 3, 1.00, 3.00, '2015-05-18 23:10:57', 0, ''),
(34, 18, 4, 1, 1.00, 1.00, '2015-05-18 23:11:21', 0, ''),
(35, 18, 14, 1, 1.00, 1.00, '2015-05-18 23:11:48', 0, ''),
(36, 18, 4, 1, 1.00, 1.00, '2015-05-18 23:12:43', 0, ''),
(37, 1, 32, 2, 0.50, 1.00, '2015-05-18 23:14:36', 0, ''),
(38, 18, 17, 1, 1.00, 1.00, '2015-05-18 23:15:26', 0, ''),
(39, 1, 20, 1, 1.00, 1.00, '2015-05-18 23:15:56', 0, ''),
(40, 18, 15, 1, 1.00, 1.00, '2015-05-18 23:16:25', 0, ''),
(41, 15, 6, 1, 1.50, 1.50, '2015-05-18 23:17:03', 0, ''),
(42, 1, 20, 1, 1.00, 1.00, '2015-05-18 23:18:17', 0, ''),
(43, 1, 18, 3, 1.00, 3.00, '2015-05-18 23:18:54', 0, ''),
(44, 16, 18, 1, 1.00, 1.00, '2015-05-18 23:19:32', 0, ''),
(45, 16, 9, 1, 1.00, 1.00, '2015-05-18 23:19:32', 0, ''),
(46, 17, 16, 1, 1.00, 1.00, '2015-05-18 23:24:00', 0, ''),
(47, 16, 16, 1, 1.00, 1.00, '2015-05-18 23:24:13', 0, ''),
(48, 1, 31, 1, 1.00, 1.00, '2015-05-18 23:24:39', 0, ''),
(49, 1, 1, 2, 1.00, 2.00, '2015-05-18 23:25:13', 0, ''),
(50, 1, 11, 2, 1.00, 2.00, '2015-05-18 23:25:26', 0, ''),
(51, 1, 7, 1, 1.00, 1.00, '2015-05-18 23:26:30', 0, ''),
(52, 17, 7, 2, 1.00, 2.00, '2015-05-18 23:27:15', 0, ''),
(53, 17, 26, 2, 1.00, 2.00, '2015-05-18 23:28:02', 0, ''),
(54, 17, 32, 1, 1.00, 1.00, '2015-05-18 23:28:36', 0, ''),
(55, 1, 32, 1, 1.00, 1.00, '2015-05-18 23:28:50', 0, ''),
(56, 17, 15, 1, 0.50, 0.50, '2015-05-18 23:30:06', 0, ''),
(57, 17, 11, 1, 1.00, 1.00, '2015-05-18 23:30:51', 0, ''),
(58, 16, 23, 2, 0.50, 1.00, '2015-05-18 23:31:23', 0, ''),
(59, 16, 37, 1, 1.00, 1.00, '2015-05-18 23:31:56', 0, ''),
(60, 1, 26, 2, 1.00, 2.00, '2015-05-18 23:32:37', 0, ''),
(61, 17, 11, 2, 1.00, 2.00, '2015-05-18 23:33:09', 0, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
`id` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL DEFAULT '0',
  `payment_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` double(3,2) NOT NULL DEFAULT '0.00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `payments_by_customer`
--
CREATE TABLE IF NOT EXISTS `payments_by_customer` (
`id_product` int(11)
,`amount` double(3,2)
,`payment_date` datetime
,`name` varchar(100)
,`email` varchar(50)
,`id_customer` int(11)
);
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE IF NOT EXISTS `product` (
`id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` double(3,2) NOT NULL DEFAULT '0.00',
  `low_price` double(3,2) NOT NULL DEFAULT '0.00',
  `status` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `low_price`, `status`) VALUES
(1, 'Keke vainilla', 1.00, 0.50, 0),
(2, 'Empanada', 2.00, 1.00, 0),
(3, 'Tarteleta', 2.50, 1.25, 0),
(4, 'Salteña', 2.00, 1.00, 0),
(5, 'Cachito grande', 2.00, 1.00, 0),
(6, 'Pionono', 2.00, 1.00, 0),
(7, 'Keke de naranja', 1.50, 0.75, 0),
(8, 'Tekeños', 0.33, 0.16, 0),
(9, 'Pie', 2.00, 1.00, 0),
(10, 'Enrollado de hot-dog', 2.00, 1.00, 0),
(11, 'Keke Cereza/Castaña', 1.50, 0.75, 0),
(12, 'Rollo lucuma', 2.50, 1.25, 0),
(13, 'Otros', 1.00, 0.50, 0),
(14, 'Cupcake', 3.00, 1.50, 0),
(15, 'Cachito chico', 1.50, 0.75, 0),
(16, 'Keke marmoleado', 1.00, 0.50, 0),
(17, 'Alfajor', 1.00, 0.50, 0),
(18, 'Budin chico', 1.00, 0.50, 0),
(19, 'Budin', 1.50, 0.75, 0),
(20, 'Empanada de queso', 1.50, 0.75, 0),
(21, 'Crossaint de queso', 1.50, 0.75, 0);

-- --------------------------------------------------------

--
-- Estructura para la vista `debt_detail_by_customer`
--
DROP TABLE IF EXISTS `debt_detail_by_customer`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `debt_detail_by_customer` AS select `p`.`id` AS `id_product`,`p`.`name` AS `product_name`,`o`.`price` AS `price`,`o`.`full_price` AS `full_price`,`o`.`quantity` AS `quantity`,`o`.`order_date` AS `order_date`,`o`.`comment` AS `comment`,`c`.`name` AS `customer_name`,`c`.`email` AS `email`,`c`.`id` AS `id_customer` from ((`product` `p` join `order` `o` on((`p`.`id` = `o`.`id_product`))) join `customer` `c` on((`o`.`id_customer` = `c`.`id`)));

-- --------------------------------------------------------

--
-- Estructura para la vista `payments_by_customer`
--
DROP TABLE IF EXISTS `payments_by_customer`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `payments_by_customer` AS select `p`.`id` AS `id_product`,`p`.`amount` AS `amount`,`p`.`payment_date` AS `payment_date`,`c`.`name` AS `name`,`c`.`email` AS `email`,`c`.`id` AS `id_customer` from (`payment` `p` join `customer` `c` on((`p`.`id_customer` = `c`.`id`))) order by `p`.`payment_date` desc;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `customer`
--
ALTER TABLE `customer`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `name` (`name`);

--
-- Indices de la tabla `order`
--
ALTER TABLE `order`
 ADD PRIMARY KEY (`id`,`id_product`,`id_customer`), ADD KEY `FK_order_product` (`id_product`), ADD KEY `FK_order_customer` (`id_customer`);

--
-- Indices de la tabla `payment`
--
ALTER TABLE `payment`
 ADD PRIMARY KEY (`id`,`id_customer`), ADD KEY `FK_payment_customer` (`id_customer`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `name` (`name`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `customer`
--
ALTER TABLE `customer`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=51;
--
-- AUTO_INCREMENT de la tabla `order`
--
ALTER TABLE `order`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=62;
--
-- AUTO_INCREMENT de la tabla `payment`
--
ALTER TABLE `payment`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `product`
--
ALTER TABLE `product`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `order`
--
ALTER TABLE `order`
ADD CONSTRAINT `FK_order_customer` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id`),
ADD CONSTRAINT `FK_order_product` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Filtros para la tabla `payment`
--
ALTER TABLE `payment`
ADD CONSTRAINT `FK_payment_customer` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
