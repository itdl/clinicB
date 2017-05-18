/*
Navicat MySQL Data Transfer

Source Server         : cllinic
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : clinic

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2017-05-18 23:11:32
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='预约信息表';

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
INSERT INTO `clinic_client_register` VALUES ('12', '1', '2017-04-22', '1', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');
INSERT INTO `clinic_client_register` VALUES ('13', '1', '2017-04-22', '1', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');
INSERT INTO `clinic_client_register` VALUES ('14', '1', '2017-04-22', '1', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');
INSERT INTO `clinic_client_register` VALUES ('15', '1', '2017-04-22', '1', '1', '软件工程师', '高新园区', '发烧，流鼻涕', '0', '0', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of clinic_client_user
-- ----------------------------
INSERT INTO `clinic_client_user` VALUES ('1', 'songshijun', '0', '1', '1212121212', '2017-04-19 10:44:56', '123456', '辽宁大连黑石礁街', '18642826976');
INSERT INTO `clinic_client_user` VALUES ('2', 'fsfa', '0', '1', '3123131', '2017-04-19 10:44:58', '32131', '313213', '21321313');
INSERT INTO `clinic_client_user` VALUES ('3', '法撒旦法', '0', '1', '123', '2017-04-19 10:45:02', '123', '3123123', '312312312');
INSERT INTO `clinic_client_user` VALUES ('4', '测试账号', '0', '1', '1234', '2017-04-19 10:45:08', '123', '12432411313', '123123123');
INSERT INTO `clinic_client_user` VALUES ('6', 'fss', '0', '1', '210283199009164012', '2017-05-03 00:00:00', '123', '1232131', '155555555');
INSERT INTO `clinic_client_user` VALUES ('7', 'aa', '0', '1', '210283199009164012', '2017-05-10 00:00:00', '123', '131231', '18642826976');

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
  `create_date` timestamp NULL DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`type`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='药品表';

-- ----------------------------
-- Records of clinic_mgr_drug
-- ----------------------------
INSERT INTO `clinic_mgr_drug` VALUES ('321', '32131', '321', '312', null, '312', '2017-04-27 00:00:00', '2017-04-04 00:00:00', '312', '312', '321', '321', '321', '312', '321', '2017-04-27 12:51:29', null);
INSERT INTO `clinic_mgr_drug` VALUES ('213132', '12312', '3123', '3123112', null, '32131', '2017-04-20 00:00:00', '2017-04-18 00:00:00', '321', '123', '312', '312', '21', '123', '12', '2017-04-27 12:51:03', null);

-- ----------------------------
-- Table structure for clinic_mgr_role
-- ----------------------------
DROP TABLE IF EXISTS `clinic_mgr_role`;
CREATE TABLE `clinic_mgr_role` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `auths` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of clinic_mgr_role
-- ----------------------------
INSERT INTO `clinic_mgr_role` VALUES ('-1', '超级管理员', '1,2,3,4,5');
INSERT INTO `clinic_mgr_role` VALUES ('1', '普通管理员', '1,2,3');
INSERT INTO `clinic_mgr_role` VALUES ('2', '医生', '1');

-- ----------------------------
-- Table structure for clinic_mgr_staff
-- ----------------------------
DROP TABLE IF EXISTS `clinic_mgr_staff`;
CREATE TABLE `clinic_mgr_staff` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '标识id号',
  `edu` int(2) DEFAULT NULL COMMENT '学历 1：博士 2：硕士 3：本科 4：专科 5：高中 6：初中',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '员工名称',
  `card` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '身份证id',
  `phone` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '电话',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `birthday` timestamp NULL DEFAULT NULL COMMENT '出生年月',
  `year_work` double(4,1) DEFAULT NULL COMMENT '工作年限',
  `pro` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '职位',
  `old_pro` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '曾任职位',
  `isjob` int(1) DEFAULT NULL COMMENT '是否在职 1:在职 2:离职',
  `job_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '入职日期',
  `unjob_date` timestamp NULL DEFAULT NULL COMMENT '离职日期',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '住址',
  `pay` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '薪资',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='员工登记信息';

-- ----------------------------
-- Records of clinic_mgr_staff
-- ----------------------------
INSERT INTO `clinic_mgr_staff` VALUES ('1', '3', '南巷', '2101000000', '18642826976', '1', '20', '1990-04-14 09:00:00', '3.0', '护士', '医院护士护理', '1', '2017-05-05 15:41:57', null, '鞍山', '3500');
INSERT INTO `clinic_mgr_staff` VALUES ('2', '3', '南巷', '2101000000', '18642826976', '1', '20', '1990-04-14 09:00:00', '3.0', '护士', '医院护士护理', '1', '2017-05-05 15:41:57', null, '鞍山', '3500');

-- ----------------------------
-- Table structure for clinic_mgr_user
-- ----------------------------
DROP TABLE IF EXISTS `clinic_mgr_user`;
CREATE TABLE `clinic_mgr_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '管理员名称',
  `user_pwd` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户添加时间',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `user_role` int(4) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of clinic_mgr_user
-- ----------------------------
INSERT INTO `clinic_mgr_user` VALUES ('1', 'root', 'root', '2017-03-13 11:01:30', '-1');
INSERT INTO `clinic_mgr_user` VALUES ('2', 'admin', 'admin', '2017-03-13 11:01:30', '1');
INSERT INTO `clinic_mgr_user` VALUES ('3', 'doctor', 'doctor', '2017-03-13 11:01:30', '2');

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
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-05-03 00:00:00', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-05-04 00:00:00', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-05-05 00:00:00', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-05-06 00:00:00', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-05-07 00:00:00', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-05-08 00:00:00', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-05-09 00:00:00', '1,2', '0');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-05-10 00:00:00', '1,2,3', '1');
INSERT INTO `clinic_mgr_yyconfig` VALUES ('2017-05-11 00:00:00', '1,2', '0');
SET FOREIGN_KEY_CHECKS=1;
