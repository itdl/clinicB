/*
Navicat MySQL Data Transfer

Source Server         : local_root
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : clinic

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-17 00:51:51
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
  `rpt_flg` int(1) DEFAULT NULL COMMENT '是否接诊(0:预约 1:接诊 2:取消）',
  `stood_time` int(3) DEFAULT NULL COMMENT '爽约次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='预约信息表';

-- ----------------------------
-- Records of clinic_client_register
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of clinic_client_user
-- ----------------------------
INSERT INTO `clinic_client_user` VALUES ('1', '', '0', '-1', '', '2017-04-11 00:00:00', '', '', '');
INSERT INTO `clinic_client_user` VALUES ('2', '', '0', '-1', '', '2017-04-11 00:00:00', '', '', '');
INSERT INTO `clinic_client_user` VALUES ('3', '', '0', '-1', '', '2017-04-11 00:00:00', '', '', '');
INSERT INTO `clinic_client_user` VALUES ('4', 'songshijun', '0', '1', '1212121212', '2017-04-11 00:00:00', '121212', '12121212121分为非法11', '1212121212');
INSERT INTO `clinic_client_user` VALUES ('5', 'songshijun', '0', '1', '1212121212', '2016-03-10 00:00:00', '121212', '12121212121分为非法11', '1212121212');
INSERT INTO `clinic_client_user` VALUES ('6', 'songshijun', '0', '1', '1212121212', '2016-03-09 00:00:00', '1212121211', '12121212121分为非法11', '12121212');
INSERT INTO `clinic_client_user` VALUES ('7', 'fsfa', '0', '1', '3123131', '2017-04-06 00:00:00', '32131', '313213', '21321313');
INSERT INTO `clinic_client_user` VALUES ('8', '法撒旦法', '0', '1', '123', '2017-04-08 00:00:00', '123', '3123123', '312312312');
INSERT INTO `clinic_client_user` VALUES ('9', '测试账号', '0', '1', '1234', '2017-04-12 00:00:00', '123', '12432411313', '123123123');

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
  `register_date` date NOT NULL,
  `register_time` varchar(5) COLLATE utf8_bin NOT NULL,
  `register_used` int(1) NOT NULL,
  PRIMARY KEY (`register_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of clinic_mgr_yyconfig
-- ----------------------------
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-04-16', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-04-17', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-04-18', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-04-19', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-04-20', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-04-21', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-04-22', '1,2,3', '1');
