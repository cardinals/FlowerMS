/*
Navicat MySQL Data Transfer

Source Server         : 本地MySQL
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : flower

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2016-07-15 09:57:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admins`
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `admin` varchar(20) NOT NULL,
  `status` tinyint(4) DEFAULT '0',
  `password` varchar(80) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('1000', 'admintest', '1', '123', '163.com');

-- ----------------------------
-- Table structure for `flowers`
-- ----------------------------
DROP TABLE IF EXISTS `flowers`;
CREATE TABLE `flowers` (
  `flowerID` int(11) NOT NULL AUTO_INCREMENT,
  `flowerName` varchar(50) NOT NULL,
  `price` decimal(12,2) DEFAULT '0.00',
  `images` varchar(100) DEFAULT '',
  `remarks` text,
  `number` int(11) DEFAULT '0',
  PRIMARY KEY (`flowerID`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flowers
-- ----------------------------
INSERT INTO `flowers` VALUES ('39', '虎皮兰', '20.00', 'yujinxiang.png', '三角梅', '300');
INSERT INTO `flowers` VALUES ('40', '茉莉花', '25.00', '/upload/7/8/7eb4c328-4718-4454-8007-3c0e5cf7fcec_.jpg', '茉莉花很香', '300');
INSERT INTO `flowers` VALUES ('41', '玫瑰花', '30.00', '/upload/14/1/5e3ad013-7b6c-43b3-8899-f12359460cec_.jpeg', '七夕大促销', '400');
INSERT INTO `flowers` VALUES ('42', '栀子花', '20.00', '/upload/13/9/73c1c55e-2324-4c28-bde2-7bb49064b96d_.jpeg', '栀子花开呀开', '100');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `orderDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sendtime` datetime NOT NULL,
  `receiveName` varchar(40) NOT NULL,
  `receiveTel` varchar(40) NOT NULL,
  `receiveAdd` varchar(100) NOT NULL,
  `payState` tinyint(4) DEFAULT '0',
  `salesman` int(11) NOT NULL,
  `sendState` tinyint(4) DEFAULT '0',
  `remarks` text,
  `status` tinyint(4) DEFAULT '0',
  `flowerID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `sendName` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `salesman` (`salesman`),
  KEY `flowerID` (`flowerID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('8', '2016-07-15 09:40:02', '2016-07-16 13:26:42', 'JAck', '11111111111', '美国', '0', '105', '3', '备注2', '1', '34', '300', 'Coselding');
INSERT INTO `orders` VALUES ('9', '2016-07-15 09:48:22', '2016-07-16 13:35:02', 'JAck', '11111111111', '美国', '0', '105', '3', '备注2', '1', '34', '300', 'Coselding');
INSERT INTO `orders` VALUES ('10', '2016-07-15 09:53:21', '2015-01-01 00:00:00', '李世民', '13222222222', '唐朝长安', '1', '107', '0', '穿越时空的爱恋', '0', '41', '10', '高晓松');
INSERT INTO `orders` VALUES ('11', '2016-07-15 09:54:55', '2017-03-04 10:08:00', 'helloworld', '13111111111', '大数据世界', '0', '104', '1', 'MapReduce', '2', '40', '20', 'hadoop');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `cardID` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `username_key` (`username`),
  UNIQUE KEY `cardID_key` (`cardID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin', '370205198703164258', '13654269874', '福建省厦门市', '111@qq.com');
INSERT INTO `user` VALUES ('2', 'tomcat', 'e10adc3949ba59abbe56e057f20f883e', 'admin', '370205198703165489', '13654269544', '山东省青岛市', '222@qq.com');

-- ----------------------------
-- Table structure for `worker`
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `workerID` int(11) NOT NULL AUTO_INCREMENT,
  `workername` varchar(40) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`workerID`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES ('102', 'asscii', '0');
INSERT INTO `worker` VALUES ('103', 'sda', '0');
INSERT INTO `worker` VALUES ('104', 'qqqqqq', '0');
INSERT INTO `worker` VALUES ('105', 'worker2', '1');
INSERT INTO `worker` VALUES ('106', 'wfewe', '0');
INSERT INTO `worker` VALUES ('107', 'worker1', '1');
