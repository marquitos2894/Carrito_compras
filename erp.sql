-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.25-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para nasadd2
CREATE DATABASE IF NOT EXISTS `nasadd2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `nasadd2`;


-- Volcando estructura para procedimiento nasadd2.I_SO_DET
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `I_SO_DET`(
in p_so_no int,
in p_so_li int,
in p_item_cd char(15),
in p_qty_no Double,
in p_item_unit_p Double,
in p_item_tax_pe Double,
in p_tax_va Double
)
begin 
	insert into xp_so_det (so_no,line_no,item_cd,qty_no,item_unit_price_va,item_tax_pe,tax_va)
		values(p_so_no,p_so_li,p_item_cd,p_qty_no,p_item_unit_p,p_item_tax_pe,p_tax_va);
end//
DELIMITER ;


-- Volcando estructura para procedimiento nasadd2.I_SO_HEA
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `I_SO_HEA`(
in p_so_no int,
in p_cus_id char(20),
in p_zone_cd char(15),
in p_paymet_cd char(15),
in p_region_cd int
)
begin
insert into xp_so_hea (so_no,cus_id,zone_cd,paymet_cd,region_cd) values(p_so_no,p_cus_id,p_zone_cd,p_paymet_cd,p_region_cd);
end//
DELIMITER ;


-- Volcando estructura para procedimiento nasadd2.max_so_no_hea
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `max_so_no_hea`()
begin
	select * from xp_so_hea order by so_no desc limit 1;
end//
DELIMITER ;


-- Volcando estructura para procedimiento nasadd2.V_IMAGE
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `V_IMAGE`( IN p_item_cd VARCHAR(15)
)
BEGIN
	SELECT * FROM xp_image WHERE item_cd = p_item_cd;
END//
DELIMITER ;


-- Volcando estructura para procedimiento nasadd2.V_ITEM
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `V_ITEM`()
BEGIN
	SELECT * FROM xp_item;
END//
DELIMITER ;


-- Volcando estructura para procedimiento nasadd2.V_ITEM_UNO
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `V_ITEM_UNO`( IN p_item_cd char(15))
BEGIN
	SELECT * FROM xp_item WHERE item_cd = p_item_cd;
END//
DELIMITER ;


-- Volcando estructura para procedimiento nasadd2.V_PAYMENT
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `V_PAYMENT`()
BEGIN
	SELECT * FROM XP_PAYMET;
END//
DELIMITER ;


-- Volcando estructura para procedimiento nasadd2.V_REGION
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `V_REGION`(
IN p_zone_cd char(15)
)
BEGIN 
	SELECT * FROM XP_REGION WHERE zone_cd = p_zone_cd;
END//
DELIMITER ;


-- Volcando estructura para procedimiento nasadd2.V_REGION2
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `V_REGION2`(
)
BEGIN 
	SELECT * FROM XP_REGION ;
END//
DELIMITER ;


-- Volcando estructura para procedimiento nasadd2.V_SO_DET
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `V_SO_DET`(in p_so_no int)
begin
select * from xp_so_det where so_no = p_so_no;
end//
DELIMITER ;


-- Volcando estructura para procedimiento nasadd2.V_SO_HEA
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `V_SO_HEA`()
BEGIN
	SELECT * FROM xp_so_hea;
END//
DELIMITER ;


-- Volcando estructura para procedimiento nasadd2.V_SO_HEA_2
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `V_SO_HEA_2`()
BEGIN
	select max(sh.so_no), sh.cus_id,sh.zone_cd,sh.paymet_cd  from xp_so_hea sh;
END//
DELIMITER ;


-- Volcando estructura para procedimiento nasadd2.V_SO_HEA_MAX
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `V_SO_HEA_MAX`()
BEGIN
	select max(so_no) from xp_so_hea;
END//
DELIMITER ;


-- Volcando estructura para procedimiento nasadd2.V_SO_HEA_UNO
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `V_SO_HEA_UNO`(in p_so_no int)
begin
	select  sh.so_no,cu.cus_id,cu.cus_name,cu.cus_address,cu.cus_mail,zo.zone_ds,re.region_ds,pa.paymet_ds
	from xp_so_hea sh inner join xp_customer cu
	on sh.cus_id = cu.cus_id 
	inner join xp_zone zo on  zo.zone_cd = sh.zone_cd
	inner join xp_region re on re.region_cd = sh.region_cd
	inner join xp_paymet pa on pa.paymet_cd = sh.paymet_cd
	where so_no = p_so_no;
end//
DELIMITER ;


-- Volcando estructura para procedimiento nasadd2.V_ZONE
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `V_ZONE`()
begin 
	select * from xp_zone;
end//
DELIMITER ;


-- Volcando estructura para tabla nasadd2.xp_customer
CREATE TABLE IF NOT EXISTS `xp_customer` (
  `cus_id` char(20) NOT NULL,
  `cus_name` varchar(50) DEFAULT NULL,
  `cus_address` varchar(80) DEFAULT NULL,
  `cus_mail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla nasadd2.xp_customer: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `xp_customer` DISABLE KEYS */;
INSERT INTO `xp_customer` (`cus_id`, `cus_name`, `cus_address`, `cus_mail`) VALUES
	('45635', 'Peter Woo', 'Av. loo 421', 'woo@woo.com'),
	('45636', 'John Wayne', 'Av.Pou 1545', 'jwayne@gg.com');
/*!40000 ALTER TABLE `xp_customer` ENABLE KEYS */;


-- Volcando estructura para tabla nasadd2.xp_image
CREATE TABLE IF NOT EXISTS `xp_image` (
  `item_cd` char(15) NOT NULL,
  `image_no` int(11) NOT NULL,
  `image_im` longblob,
  PRIMARY KEY (`item_cd`,`image_no`),
  CONSTRAINT `xp_image_ibfk_1` FOREIGN KEY (`item_cd`) REFERENCES `xp_item` (`item_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla nasadd2.xp_image: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `xp_image` DISABLE KEYS */;
INSERT INTO `xp_image` (`item_cd`, `image_no`, `image_im`) VALUES
	('pendrive1TB', 1, _binary 0x32313336333430303341303033323030),
	('pendrive2TB', 1, _binary 0x3431303033343030334130303332303033383030323030303030);
/*!40000 ALTER TABLE `xp_image` ENABLE KEYS */;


-- Volcando estructura para tabla nasadd2.xp_item
CREATE TABLE IF NOT EXISTS `xp_item` (
  `item_cd` char(15) NOT NULL,
  `item_ds` char(200) DEFAULT NULL,
  `itemtype_cd` char(15) DEFAULT NULL,
  `item_cur_cd` char(3) DEFAULT NULL,
  `item_unit_price_va` double(16,4) DEFAULT NULL,
  `item_stock_va` double(16,4) DEFAULT NULL,
  `item_web_fg` int(11) DEFAULT NULL,
  `item_tax_pe` double(16,4) DEFAULT NULL,
  PRIMARY KEY (`item_cd`),
  KEY `itemtype_cd` (`itemtype_cd`),
  CONSTRAINT `xp_item_ibfk_1` FOREIGN KEY (`itemtype_cd`) REFERENCES `xp_itemtype` (`itemtype_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla nasadd2.xp_item: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `xp_item` DISABLE KEYS */;
INSERT INTO `xp_item` (`item_cd`, `item_ds`, `itemtype_cd`, `item_cur_cd`, `item_unit_price_va`, `item_stock_va`, `item_web_fg`, `item_tax_pe`) VALUES
	('pendrive1TB', 'pen drive 1 TB', 'pendrive', 'USD', 40.0000, 100.0000, 1, 2.0000),
	('pendrive2TB', 'pen drive 2 TB', 'pendrive', 'USD', 70.0000, 50.0000, 1, 0.0000);
/*!40000 ALTER TABLE `xp_item` ENABLE KEYS */;


-- Volcando estructura para tabla nasadd2.xp_itemtype
CREATE TABLE IF NOT EXISTS `xp_itemtype` (
  `itemtype_cd` char(15) NOT NULL,
  `itemtype_ds` char(200) DEFAULT NULL,
  PRIMARY KEY (`itemtype_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla nasadd2.xp_itemtype: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `xp_itemtype` DISABLE KEYS */;
INSERT INTO `xp_itemtype` (`itemtype_cd`, `itemtype_ds`) VALUES
	('pendrive', 'pendrive'),
	('smartphone', 'smartphone');
/*!40000 ALTER TABLE `xp_itemtype` ENABLE KEYS */;


-- Volcando estructura para tabla nasadd2.xp_paymet
CREATE TABLE IF NOT EXISTS `xp_paymet` (
  `paymet_cd` char(15) NOT NULL,
  `paymet_ds` char(200) DEFAULT NULL,
  PRIMARY KEY (`paymet_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla nasadd2.xp_paymet: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `xp_paymet` DISABLE KEYS */;
INSERT INTO `xp_paymet` (`paymet_cd`, `paymet_ds`) VALUES
	('ccvisasig', 'credit card visa asignature');
/*!40000 ALTER TABLE `xp_paymet` ENABLE KEYS */;


-- Volcando estructura para tabla nasadd2.xp_region
CREATE TABLE IF NOT EXISTS `xp_region` (
  `region_cd` int(11) NOT NULL AUTO_INCREMENT,
  `zone_cd` char(15) DEFAULT NULL,
  `region_ds` char(35) DEFAULT NULL,
  PRIMARY KEY (`region_cd`),
  KEY `zone_cd` (`zone_cd`),
  CONSTRAINT `xp_region_ibfk_1` FOREIGN KEY (`zone_cd`) REFERENCES `xp_zone` (`zone_cd`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla nasadd2.xp_region: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `xp_region` DISABLE KEYS */;
INSERT INTO `xp_region` (`region_cd`, `zone_cd`, `region_ds`) VALUES
	(1, 'zone01', 'Peru'),
	(2, 'zone01', 'Chile'),
	(3, 'zone01', 'Argentina'),
	(4, 'zone01', 'Colombia'),
	(5, 'zone01', 'Venezuela'),
	(6, 'zone02', 'España'),
	(7, 'zone02', 'Portugal'),
	(8, 'zone02', 'Francia'),
	(9, 'zone03', 'china'),
	(10, 'zone03', 'Japon');
/*!40000 ALTER TABLE `xp_region` ENABLE KEYS */;


-- Volcando estructura para tabla nasadd2.xp_scc
CREATE TABLE IF NOT EXISTS `xp_scc` (
  `scc_cd` char(15) NOT NULL,
  `scc_ds` char(200) DEFAULT NULL,
  PRIMARY KEY (`scc_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla nasadd2.xp_scc: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `xp_scc` DISABLE KEYS */;
INSERT INTO `xp_scc` (`scc_cd`, `scc_ds`) VALUES
	('fob01', 'fob 01');
/*!40000 ALTER TABLE `xp_scc` ENABLE KEYS */;


-- Volcando estructura para tabla nasadd2.xp_so_det
CREATE TABLE IF NOT EXISTS `xp_so_det` (
  `so_no` int(11) NOT NULL,
  `line_no` int(11) NOT NULL,
  `item_cd` char(15) DEFAULT NULL,
  `qty_no` double(5,2) DEFAULT NULL,
  `item_unit_price_va` double(16,4) DEFAULT NULL,
  `item_tax_pe` double(5,2) DEFAULT NULL,
  `tax_va` double(5,2) DEFAULT NULL,
  PRIMARY KEY (`so_no`,`line_no`),
  KEY `item_cd` (`item_cd`),
  CONSTRAINT `xp_so_det_ibfk_1` FOREIGN KEY (`so_no`) REFERENCES `xp_so_hea` (`so_no`),
  CONSTRAINT `xp_so_det_ibfk_2` FOREIGN KEY (`item_cd`) REFERENCES `xp_item` (`item_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla nasadd2.xp_so_det: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `xp_so_det` DISABLE KEYS */;
INSERT INTO `xp_so_det` (`so_no`, `line_no`, `item_cd`, `qty_no`, `item_unit_price_va`, `item_tax_pe`, `tax_va`) VALUES
	(2, 1, 'pendrive1TB', 1.00, 40.0000, 2.00, 8.00),
	(2, 2, 'pendrive1TB', 1.00, 40.0000, 2.00, 8.00),
	(3, 1, 'pendrive1TB', 1.00, 40.0000, 2.00, 8.00),
	(3, 2, 'pendrive2TB', 1.00, 70.0000, 0.00, 0.00),
	(4, 1, 'pendrive1TB', 5.00, 40.0000, 2.00, 8.00),
	(5, 1, 'pendrive1TB', 1.00, 40.0000, 2.00, 8.00);
/*!40000 ALTER TABLE `xp_so_det` ENABLE KEYS */;


-- Volcando estructura para tabla nasadd2.xp_so_hea
CREATE TABLE IF NOT EXISTS `xp_so_hea` (
  `so_no` int(11) NOT NULL,
  `cus_id` char(20) DEFAULT NULL,
  `zone_cd` char(15) DEFAULT NULL,
  `paymet_cd` char(15) DEFAULT NULL,
  `region_cd` int(11) NOT NULL,
  PRIMARY KEY (`so_no`),
  KEY `zone_cd` (`zone_cd`),
  KEY `paymet_cd` (`paymet_cd`),
  KEY `cus_id` (`cus_id`),
  KEY `region_cd` (`region_cd`),
  CONSTRAINT `xp_so_hea_ibfk_1` FOREIGN KEY (`zone_cd`) REFERENCES `xp_zone` (`zone_cd`),
  CONSTRAINT `xp_so_hea_ibfk_2` FOREIGN KEY (`paymet_cd`) REFERENCES `xp_paymet` (`paymet_cd`),
  CONSTRAINT `xp_so_hea_ibfk_3` FOREIGN KEY (`cus_id`) REFERENCES `xp_customer` (`cus_id`),
  CONSTRAINT `xp_so_hea_ibfk_4` FOREIGN KEY (`region_cd`) REFERENCES `xp_region` (`region_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla nasadd2.xp_so_hea: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `xp_so_hea` DISABLE KEYS */;
INSERT INTO `xp_so_hea` (`so_no`, `cus_id`, `zone_cd`, `paymet_cd`, `region_cd`) VALUES
	(1, '45636', 'zone01', 'ccvisasig', 1),
	(2, '45636', 'zone01', 'ccvisasig', 2),
	(3, '45636', 'zone02', 'ccvisasig', 7),
	(4, '45636', 'zone01', 'ccvisasig', 1),
	(5, '45636', 'zone01', 'ccvisasig', 1);
/*!40000 ALTER TABLE `xp_so_hea` ENABLE KEYS */;


-- Volcando estructura para tabla nasadd2.xp_so_shc
CREATE TABLE IF NOT EXISTS `xp_so_shc` (
  `so_no` int(11) NOT NULL,
  `line_no` int(11) NOT NULL,
  `scc_cd` char(15) NOT NULL,
  `scc_uni_va` double(5,2) DEFAULT NULL,
  `scc_total_va` double(5,2) DEFAULT NULL,
  PRIMARY KEY (`so_no`,`line_no`,`scc_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla nasadd2.xp_so_shc: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `xp_so_shc` DISABLE KEYS */;
INSERT INTO `xp_so_shc` (`so_no`, `line_no`, `scc_cd`, `scc_uni_va`, `scc_total_va`) VALUES
	(2, 1, 'fob01', 0.20, 2.00),
	(2, 2, 'fob01', 0.20, 0.40);
/*!40000 ALTER TABLE `xp_so_shc` ENABLE KEYS */;


-- Volcando estructura para tabla nasadd2.xp_zone
CREATE TABLE IF NOT EXISTS `xp_zone` (
  `zone_cd` char(15) NOT NULL,
  `zone_ds` char(200) DEFAULT NULL,
  PRIMARY KEY (`zone_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla nasadd2.xp_zone: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `xp_zone` DISABLE KEYS */;
INSERT INTO `xp_zone` (`zone_cd`, `zone_ds`) VALUES
	('zone01', 'America'),
	('zone02', 'Europa'),
	('zone03', 'Asia');
/*!40000 ALTER TABLE `xp_zone` ENABLE KEYS */;


-- Volcando estructura para tabla nasadd2.xp_zscc
CREATE TABLE IF NOT EXISTS `xp_zscc` (
  `scc_cd` char(15) NOT NULL,
  `zone_cd` char(15) NOT NULL,
  `scc_uni_va` double(5,2) DEFAULT NULL,
  PRIMARY KEY (`scc_cd`,`zone_cd`),
  KEY `zone_cd` (`zone_cd`),
  CONSTRAINT `xp_zscc_ibfk_1` FOREIGN KEY (`scc_cd`) REFERENCES `xp_scc` (`scc_cd`),
  CONSTRAINT `xp_zscc_ibfk_2` FOREIGN KEY (`zone_cd`) REFERENCES `xp_zone` (`zone_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla nasadd2.xp_zscc: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `xp_zscc` DISABLE KEYS */;
INSERT INTO `xp_zscc` (`scc_cd`, `zone_cd`, `scc_uni_va`) VALUES
	('fob01', 'zone01', 0.20);
/*!40000 ALTER TABLE `xp_zscc` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
