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
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_npxm0a43gggukpajv1wi6y6vc` (`LOGIN`)
) ENGINE=MyISAM;

-- ----------------------------
-- Records of account
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM;

-- ----------------------------
-- Records of department
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM;

-- ----------------------------
-- Records of document
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM;

-- ----------------------------
-- Records of document_type
-- ----------------------------

-- ----------------------------
-- Table structure for `examination`
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `CHECKED` bit(1) DEFAULT NULL,
  `DOCUMENT_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM;

-- ----------------------------
-- Records of examination
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM;

-- ----------------------------
-- Records of role
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM;
