/*
Navicat MySQL Data Transfer

Source Server         : cllinic
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : clinic

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2017-04-24 14:02:11
*/

SET FOREIGN_KEY_CHECKS=0;

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
SET FOREIGN_KEY_CHECKS=1;
