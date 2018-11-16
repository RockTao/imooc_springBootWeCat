/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-11-16 14:37:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `area_id` int(2) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(200) NOT NULL,
  `priority` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`area_id`),
  UNIQUE KEY `UK_AREA` (`area_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area` VALUES ('1', '北京', '3', null, '2018-11-16 11:16:37');
INSERT INTO `tb_area` VALUES ('5', '深圳', '6', '2018-11-16 11:43:46', '2018-11-16 11:57:17');
INSERT INTO `tb_area` VALUES ('6', '西二旗', '2', '2018-11-16 11:44:30', '2018-11-16 11:44:30');
INSERT INTO `tb_area` VALUES ('7', '西呗', '7', '2018-11-16 11:57:54', '2018-11-16 11:57:54');
INSERT INTO `tb_area` VALUES ('8', '国贸', '2', '2018-11-16 11:58:58', '2018-11-16 11:58:58');
