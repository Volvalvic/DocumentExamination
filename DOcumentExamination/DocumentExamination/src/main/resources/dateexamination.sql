/*
Navicat MySQL Data Transfer

Source Server         : x
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : dateexamination

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2015-08-14 10:24:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dt_create` datetime NOT NULL,
  `dt_update` datetime NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `LOGIN` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `user_create` bigint(20) NOT NULL,
  `user_update` bigint(20) NOT NULL,
  `USER_TYPE_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_npxm0a43gggukpajv1wi6y6vc` (`LOGIN`),
  KEY `FK_is2p57yqeu50uw9mb4wp3doub` (`user_create`),
  KEY `FK_87y8v1ijgrfpj5jken8k56llc` (`user_update`),
  KEY `FK_92mtnvykool14rinqcpurikw1` (`USER_TYPE_ID`),
  KEY `FK_lpll0fwdfl4eqdqqc5rhpprjn` (`USER_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=cp1251;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '2015-04-24 10:53:56', '2015-04-24 10:53:53', 'vvolgina@serw.rzd', 'admin', 'admin', '1', '1', '1', '1');
INSERT INTO `account` VALUES ('2', '2015-08-14 09:15:47', '2015-08-14 09:15:47', 'ivanov@bk.ru', 'ivanov', 'ivanov', '1', '1', '1', '2');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dt_create` datetime NOT NULL,
  `dt_update` datetime NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `user_create` bigint(20) NOT NULL,
  `user_update` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_eusi5r0b3f0lu4tilt1o1rw5i` (`user_create`),
  KEY `FK_76hr095crgqj6b8eks0482edt` (`user_update`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=cp1251;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '2015-04-24 10:52:54', '2015-04-24 10:52:58', 'АСУ ТП', '1', '1');

-- ----------------------------
-- Table structure for `document`
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dt_create` datetime NOT NULL,
  `dt_update` datetime NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `FILE` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `NUMBER` varchar(255) DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `user_create` bigint(20) NOT NULL,
  `user_update` bigint(20) NOT NULL,
  `DOCUMENT_TYPE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_lr6mjmu4e3gaaquq1f6x8h9x4` (`user_create`),
  KEY `FK_6yt5m6fqak5mt362mhnoxj4ne` (`user_update`),
  KEY `FK_t5viwx449mtm363wjpjotx7tp` (`DOCUMENT_TYPE_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=cp1251;

-- ----------------------------
-- Records of document
-- ----------------------------
INSERT INTO `document` VALUES ('1', '2015-04-24 10:54:11', '2015-07-29 13:55:41', 'Тестовый документ', 'переменные.png', '12й', '12-54', '2015-07-07', '1', '1', null);
INSERT INTO `document` VALUES ('2', '2015-04-30 14:00:14', '2015-05-26 11:30:57', null, null, 'new', null, null, '1', '1', null);
INSERT INTO `document` VALUES ('3', '2015-07-03 12:07:36', '2015-07-03 12:07:36', '???°???????°???????°??', null, '?????????? ???????????µ????', '?°??-78', null, '1', '1', null);
INSERT INTO `document` VALUES ('4', '2015-07-03 12:24:54', '2015-07-03 12:24:54', 'dsadfdsfas', null, 'namename', 'num-ewe', null, '1', '1', null);
INSERT INTO `document` VALUES ('5', '2015-07-03 12:26:52', '2015-07-03 12:26:52', 'sdfsdfsdf', null, 'dcsdc', ' dcfdscds', null, '1', '1', null);
INSERT INTO `document` VALUES ('6', '2015-07-06 10:48:56', '2015-07-06 10:48:56', '???µ??????', null, '?????µ?????? ', '??????????', null, '1', '1', null);
INSERT INTO `document` VALUES ('7', '2015-07-07 11:24:13', '2015-07-07 11:24:13', '', null, '', 'rehterth', null, '1', '1', null);
INSERT INTO `document` VALUES ('8', '2015-07-14 10:32:20', '2015-07-14 10:32:20', 'фывфы', null, 'ывфыв', 'фывфы', null, '1', '1', null);
INSERT INTO `document` VALUES ('9', '2015-07-14 10:35:12', '2015-07-14 10:35:12', 'ывавыа', null, 'фыф', 'фыфыав', null, '1', '1', null);
INSERT INTO `document` VALUES ('10', '2015-07-14 11:53:17', '2015-07-14 11:53:17', 'sdcsd', 'jnxtn.docx', 'scdsdac', 'sdcsdc', null, '1', '1', null);
INSERT INTO `document` VALUES ('11', '2015-07-14 15:10:12', '2015-07-14 15:10:12', 'кпк', '№ 17-373 АИС Ноль письмо энергетикам1.pdf', 'укпкуп', 'укпк', null, '1', '1', null);
INSERT INTO `document` VALUES ('12', '2015-07-15 10:56:36', '2015-07-15 10:56:36', 'ewfwe', 'НТЭЦ по доработке АИС Ноль.pdf', 'efwwe', 'ewfwe', null, '1', '1', null);
INSERT INTO `document` VALUES ('13', '2015-07-15 11:06:52', '2015-07-15 11:06:52', ' епу', '№ 283 НТЭЦ  ввод новой версии АИС Ноль.pdf', 'terht ', 'енек', null, '1', '1', null);
INSERT INTO `document` VALUES ('14', '2015-07-16 10:15:14', '2015-07-16 10:15:14', '1вауац', null, '1ввыа', '1авыва', null, '1', '1', null);
INSERT INTO `document` VALUES ('15', '2015-07-16 10:18:28', '2015-07-16 10:18:28', '2пар', null, '2рпа', '2тап', null, '1', '1', null);
INSERT INTO `document` VALUES ('16', '2015-07-16 11:04:24', '2015-07-16 11:04:24', 'Тестовый документ', null, '12й', '12-54', null, '1', '1', null);
INSERT INTO `document` VALUES ('17', '2015-07-16 11:05:11', '2015-07-16 11:05:11', 'Тестовый документ', null, '12й', '12-54', null, '1', '1', null);
INSERT INTO `document` VALUES ('18', '2015-07-16 11:14:16', '2015-07-16 11:14:16', 'Тестовый документ', null, '12й', '12-54', null, '1', '1', null);
INSERT INTO `document` VALUES ('19', '2015-07-16 11:16:30', '2015-07-16 11:16:30', 'Тестовый документ', null, '12й', '12-54', null, '1', '1', null);
INSERT INTO `document` VALUES ('20', '2015-07-16 11:19:53', '2015-07-16 11:19:53', 'Тестовый документ', null, '12й', '12-54', null, '1', '1', null);
INSERT INTO `document` VALUES ('21', '2015-07-17 11:15:39', '2015-07-17 11:15:39', 'описание', '', 'неоено', 'пртопрт', '2015-07-30', '1', '1', '1');

-- ----------------------------
-- Table structure for `document_type`
-- ----------------------------
DROP TABLE IF EXISTS `document_type`;
CREATE TABLE `document_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dt_create` datetime NOT NULL,
  `dt_update` datetime NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `user_create` bigint(20) NOT NULL,
  `user_update` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_knvnavhay6oaklrs42nhj9jru` (`user_create`),
  KEY `FK_59ev61obqwlkpicem6w4mfmhk` (`user_update`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=cp1251;

-- ----------------------------
-- Records of document_type
-- ----------------------------
INSERT INTO `document_type` VALUES ('1', '2015-04-24 10:50:23', '2015-04-24 10:50:28', 'Телеграмма', '1', '1');

-- ----------------------------
-- Table structure for `examination`
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CHECKED` bit(1) DEFAULT NULL,
  `DOCUMENT_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_c4ca0qj8fsmrjak0dd91480b8` (`DOCUMENT_ID`),
  KEY `FK_c92acwije5atr57nb6txxsdkd` (`USER_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=cp1251;

-- ----------------------------
-- Records of examination
-- ----------------------------
INSERT INTO `examination` VALUES ('1', '', '1', '1', '2015-08-11');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dt_create` datetime NOT NULL,
  `dt_update` datetime NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `user_create` bigint(20) NOT NULL,
  `user_update` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_e6v15pumhx310ch8bd4dqt8de` (`user_create`),
  KEY `FK_pnkte8tntxwjb88wp03ypfauh` (`user_update`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=cp1251;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '2015-04-24 10:50:54', '2015-04-24 10:50:57', 'Админстратор', '1', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dt_create` datetime NOT NULL,
  `dt_update` datetime NOT NULL,
  `ADDITIONAL_INFO` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PATRONOMICNAME` varchar(255) DEFAULT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `SURNAME` varchar(255) DEFAULT NULL,
  `user_create` bigint(20) NOT NULL,
  `user_update` bigint(20) NOT NULL,
  `department` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6bttswv9v34tuo6m8vhugfqd4` (`user_create`),
  KEY `FK_5rnyrhonfng3hdke76hbf79ry` (`user_update`),
  KEY `FK_dvw6p1kbvojta1opx67o5bidt` (`department`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=cp1251;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2015-04-24 10:51:32', '2015-04-24 10:51:35', 'Админ, создающий пользователей', 'Admin', 'Adminovich', '5-89-40', 'Adminov', '1', '1', '1');
INSERT INTO `user` VALUES ('2', '2015-08-14 09:15:47', '2015-08-14 09:16:07', 'Тестовый пользователь1', 'Иван1', 'Иванович1', '892040899871', 'Иванов1', '1', '1', '1');
