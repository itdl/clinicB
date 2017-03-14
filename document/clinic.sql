/*
Navicat MySQL Data Transfer

Source Server         : cllinic
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : clinic

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2017-03-14 22:14:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clinic_mgr_user
-- ----------------------------
DROP TABLE IF EXISTS `clinic_mgr_user`;
CREATE TABLE `clinic_mgr_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '管理员名称',
  `user_pwd` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户添加时间',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of clinic_mgr_user
-- ----------------------------
INSERT INTO `clinic_mgr_user` VALUES ('1', 'admin', '123', '2017-03-13 11:01:30');
SET FOREIGN_KEY_CHECKS=1;
