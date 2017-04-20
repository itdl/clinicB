/*
Navicat MySQL Data Transfer

Source Server         : cllinic
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : clinic

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2017-04-20 13:53:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clinic_client_register
-- ----------------------------
DROP TABLE IF EXISTS `clinic_client_register`;
CREATE TABLE `clinic_client_register` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `register_date` date DEFAULT NULL,
  `register_time` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  `rpt_type` int(1) DEFAULT NULL COMMENT '接诊类型（1:初诊 1:复诊）',
  `work_info` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `work_addr` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `rpt_flg` int(1) DEFAULT NULL COMMENT '是否接诊(0:预约 1:接诊 2:取消 3:爽约）',
  `stood` int(1) DEFAULT NULL COMMENT '是否爽约',
  `is_cancel` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='预约信息表';

-- ----------------------------
-- Records of clinic_client_register
-- ----------------------------
INSERT INTO `clinic_client_register` VALUES ('1', '1', '2017-04-16', '1', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');
INSERT INTO `clinic_client_register` VALUES ('2', '1', '2017-04-16', '2', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');
INSERT INTO `clinic_client_register` VALUES ('3', '1', '2017-04-16', '2', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');
INSERT INTO `clinic_client_register` VALUES ('4', '1', '2017-04-16', '3', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');
INSERT INTO `clinic_client_register` VALUES ('5', '1', '2017-04-16', '2', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');
INSERT INTO `clinic_client_register` VALUES ('6', '1', '2017-04-16', '1', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');
INSERT INTO `clinic_client_register` VALUES ('7', '1', '2017-04-16', '1', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');
INSERT INTO `clinic_client_register` VALUES ('8', '1', '2017-04-17', '1', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');
INSERT INTO `clinic_client_register` VALUES ('9', '1', '2017-04-17', '3', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');
INSERT INTO `clinic_client_register` VALUES ('10', '1', '2017-04-17', '2', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');
INSERT INTO `clinic_client_register` VALUES ('11', '1', '2017-04-17', '1', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');

-- ----------------------------
-- Table structure for clinic_client_user
-- ----------------------------
DROP TABLE IF EXISTS `clinic_client_user`;
CREATE TABLE `clinic_client_user` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `user_sex` int(1) DEFAULT NULL,
  `user_idtype` int(3) DEFAULT NULL,
  `user_isshefn` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `user_birthday` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `user_jzd` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_sms` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of clinic_client_user
-- ----------------------------
INSERT INTO `clinic_client_user` VALUES ('1', 'songshijun', '0', '1', '1212121212', '2017-04-19 10:44:56', '123456', '辽宁大连黑石礁街', '18642826976');
INSERT INTO `clinic_client_user` VALUES ('2', 'fsfa', '0', '1', '3123131', '2017-04-19 10:44:58', '32131', '313213', '21321313');
INSERT INTO `clinic_client_user` VALUES ('3', '法撒旦法', '0', '1', '123', '2017-04-19 10:45:02', '123', '3123123', '312312312');
INSERT INTO `clinic_client_user` VALUES ('4', '测试账号', '0', '1', '1234', '2017-04-19 10:45:08', '123', '12432411313', '123123123');

-- ----------------------------
-- Table structure for clinic_mgr_drug
-- ----------------------------
DROP TABLE IF EXISTS `clinic_mgr_drug`;
CREATE TABLE `clinic_mgr_drug` (
  `code` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '商品编码',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '商品名称',
  `type` int(3) NOT NULL COMMENT '商品类型',
  `attention` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '注意事项',
  `price` double(10,2) DEFAULT NULL COMMENT '处方价格',
  `format` varchar(20) COLLATE utf8_bin DEFAULT '' COMMENT '规格',
  `prd_date` timestamp NULL DEFAULT NULL COMMENT '生产日期',
  `valid_date` timestamp NULL DEFAULT NULL COMMENT '有效日期',
  `shape` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '性状',
  `counts` int(8) DEFAULT '0' COMMENT '药品数量',
  `prd_phone` varchar(20) COLLATE utf8_bin DEFAULT '' COMMENT '生产厂商电话',
  `prd_firm` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '厂家地址',
  `uses` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '用途',
  `dosage` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用量',
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`type`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='药品表';

-- ----------------------------
-- Records of clinic_mgr_drug
-- ----------------------------

-- ----------------------------
-- Table structure for clinic_mgr_order
-- ----------------------------
DROP TABLE IF EXISTS `clinic_mgr_order`;
CREATE TABLE `clinic_mgr_order` (
  `order_no` varchar(40) COLLATE utf8_bin NOT NULL COMMENT '订单号码',
  `order_date` timestamp NULL DEFAULT NULL COMMENT '订单生成日期',
  `order_status` int(1) NOT NULL COMMENT '订单状态',
  `drug_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '药品名称',
  `drug_count` int(8) DEFAULT NULL COMMENT '药品数量',
  `drug_type` int(3) DEFAULT NULL COMMENT '药品类型',
  `pay_flag` int(1) DEFAULT NULL COMMENT '支付标志',
  `cus_ser_status` varchar(20) COLLATE utf8_bin DEFAULT '' COMMENT '售后状态',
  `unit_price` double(10,2) DEFAULT NULL COMMENT '单价',
  `all_price` double(10,2) DEFAULT NULL COMMENT '总价格',
  PRIMARY KEY (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of clinic_mgr_order
-- ----------------------------

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

-- ----------------------------
-- Table structure for clinic_mgr_yyconfig
-- ----------------------------
DROP TABLE IF EXISTS `clinic_mgr_yyconfig`;
CREATE TABLE `clinic_mgr_yyconfig` (
  `register_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '预约时间',
  `register_time` varchar(5) COLLATE utf8_bin NOT NULL COMMENT '预约时间1:上午 2:下午 3:晚上',
  `register_used` int(1) NOT NULL COMMENT '停诊信息1:正常接诊 0:停诊',
  PRIMARY KEY (`register_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of clinic_mgr_yyconfig
-- ----------------------------
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-04-16 00:00:00', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-04-17 00:00:00', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-04-18 00:00:00', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-04-19 00:00:00', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-04-20 00:00:00', '1,2,3', '0');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-04-21 00:00:00', '1,2,3', '0');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-04-22 00:00:00', '1,2,3', '1');
SET FOREIGN_KEY_CHECKS=1;
