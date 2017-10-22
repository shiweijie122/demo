/*
Navicat MySQL Data Transfer

Source Server         : lpb_tpms
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ttms_01

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-07-06 16:40:47
*/

DROP database IF EXISTS ttms_01;
CREATE database ttms_01 DEFAULT CHARACTER SET utf8;
use ttms_01;
SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for aut_organizations
-- ----------------------------
DROP TABLE IF EXISTS `aut_organizations`;
CREATE TABLE `aut_organizations` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机构编号',
  `name` varchar(50) DEFAULT NULL COMMENT '机构名称',
  `code` varchar(10) DEFAULT NULL,
  `parentId` varchar(100) DEFAULT NULL COMMENT '上级机构编号',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `valid` tinyint(1) DEFAULT '1' COMMENT '有效标志',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '新增用户',
  `createdTime` datetime DEFAULT NULL COMMENT '新增时间',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '更新用户',
  `modifiedTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aut_organizations
-- ----------------------------
INSERT INTO `aut_organizations` VALUES ('1', '产品部门', 'PROD', null, '负责产品创建等', '0', 'Admin', '2017-06-12 09:23:59', 'Admin', '2017-06-13 16:15:16');
INSERT INTO `aut_organizations` VALUES ('2', '销售部门', 'SALE', null, '负责旅游产品的销售', '0', 'Admin', '2017-06-12 11:06:03', null, '2017-06-12 11:06:03');
INSERT INTO `aut_organizations` VALUES ('3', '财务部门', 'FINA', null, '负责公司财务管理。。。。', '0', 'Admin', '2017-06-12 11:06:35', null, '2017-06-14 11:04:38');
INSERT INTO `aut_organizations` VALUES ('5', '计调部', 'PLAN', null, '负责产品的售后操作..', '1', 'Admin', '2017-06-12 17:58:33', null, '2017-06-14 14:07:55');
INSERT INTO `aut_organizations` VALUES ('6', ' 行政部', 'EXEC', null, '行政部门。。。', '1', 'Admin', '2017-06-14 11:17:11', 'Admin', '2017-06-14 14:07:45');
INSERT INTO `aut_organizations` VALUES ('71', '行政1', 'EXEC', '6', '行政1', '1', 'Admin', '2017-06-14 18:20:13', 'Admin', '2017-06-23 10:58:57');
INSERT INTO `aut_organizations` VALUES ('72', '行政2', 'EXEC', '6', '行政2', '1', 'Admin', '2017-06-14 18:20:26', 'Admin', '2017-06-23 10:58:55');
INSERT INTO `aut_organizations` VALUES ('74', '财务A', 'FINA', '3', '财务A', '1', 'Admin', '2017-06-14 18:26:06', null, '2017-06-14 18:26:06');
INSERT INTO `aut_organizations` VALUES ('75', '财务B', 'FINA', '3', '财务B', '1', 'Admin', '2017-06-14 18:26:58', null, '2017-06-14 18:26:58');
INSERT INTO `aut_organizations` VALUES ('77', '欧美部', 'PROD', '1', '欧美部', '0', 'Admin', '2017-06-16 11:01:53', 'Admin', '2017-06-30 09:54:52');
INSERT INTO `aut_organizations` VALUES ('78', '日韩部', 'PROD', '1', '日韩部', '1', 'Admin', '2017-06-16 11:02:33', 'Admin', '2017-06-30 09:54:49');
INSERT INTO `aut_organizations` VALUES ('79', '东南部', 'PROD', '1', '东南部', '0', 'Admin', '2017-06-16 11:02:56', 'Admin', '2017-06-30 09:54:51');
INSERT INTO `aut_organizations` VALUES ('80', '西南部', 'PROD', '1', '西南部。。。', '1', 'Admin', '2017-06-16 11:17:55', 'Admin', '2017-06-30 09:54:55');
INSERT INTO `aut_organizations` VALUES ('81', '东北部', 'PROD', '1', '负责东北三省的产品', '1', 'Admin', '2017-06-16 11:18:55', null, '2017-06-30 09:56:01');
INSERT INTO `aut_organizations` VALUES ('82', '华中部', 'PROD', '1', '负责华中片区', '1', 'Admin', '2017-06-30 09:27:21', 'Admin', '2017-06-30 09:55:46');

-- ----------------------------
-- Table structure for aut_roles
-- ----------------------------
DROP TABLE IF EXISTS `aut_roles`;
CREATE TABLE `aut_roles` (
  `roleId` varchar(50) NOT NULL COMMENT '角色编号',
  `roleName` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `valid` tinyint(4) DEFAULT '1' COMMENT '有效标志',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '新增用户',
  `createdTime` datetime DEFAULT NULL COMMENT '新增时间',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '更新用户',
  `modifiedTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限表';

-- ----------------------------
-- Records of aut_roles
-- ----------------------------
INSERT INTO `aut_roles` VALUES ('1', '管理员', '管理员', '1', 'wangyi', '2017-02-22 17:15:25', 'testuser', '2017-03-24 11:07:20');
INSERT INTO `aut_roles` VALUES ('2', '项目经理', '负责启动项目', '1', 'testuser', '2017-03-31 16:31:24', 'testuser', '2017-03-31 16:31:24');
INSERT INTO `aut_roles` VALUES ('3', '财务部', '财务审批', '1', 'testuser', '2017-03-27 14:51:00', 'testuser', '2017-03-31 14:49:02');
INSERT INTO `aut_roles` VALUES ('4', '产品经理', '负责产品的的管理', '1', 'testuser', '2017-03-31 17:24:44', 'testuser', '2017-03-31 17:24:44');
INSERT INTO `aut_roles` VALUES ('6', '产品信息专员', '负责产品信息整理以及上线', '1', 'Admin', '2017-04-11 15:38:56', 'Admin', '2017-04-11 15:38:56');
INSERT INTO `aut_roles` VALUES ('7', '渠道运营经理', '渠道运营经理', '1', 'Admin', '2017-04-20 09:26:55', 'Admin', '2017-04-20 09:26:55');
INSERT INTO `aut_roles` VALUES ('8', '渠道运营专员', '渠道运营专员', '1', 'Admin', '2017-04-20 09:29:47', 'Admin', '2017-04-20 09:29:47');

-- ----------------------------
-- Table structure for aut_role_rights
-- ----------------------------
DROP TABLE IF EXISTS `aut_role_rights`;
CREATE TABLE `aut_role_rights` (
  `roleId` varchar(50) NOT NULL COMMENT '角色编号',
  `functionId` varchar(50) NOT NULL COMMENT '功能编号',
  `valid` tinyint(4) DEFAULT '1' COMMENT '有效标志',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '新增用户',
  `createdTime` datetime DEFAULT NULL COMMENT '新增时间',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '更新用户',
  `modifiedTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`roleId`,`functionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aut_role_rights
-- ----------------------------
INSERT INTO `aut_role_rights` VALUES ('1', '0039', '1', 'Admin', '2017-04-18 17:24:01', 'Admin', '2017-04-18 17:24:01');
INSERT INTO `aut_role_rights` VALUES ('1', '0040', '1', 'Admin', '2017-04-18 17:24:50', 'Admin', '2017-04-18 17:24:50');
INSERT INTO `aut_role_rights` VALUES ('1', '0041', '1', 'Admin', '2017-04-18 17:24:54', 'Admin', '2017-04-18 17:24:54');
INSERT INTO `aut_role_rights` VALUES ('1', '0042', '1', 'Admin', '2017-04-18 17:24:56', 'Admin', '2017-04-18 17:24:56');
INSERT INTO `aut_role_rights` VALUES ('1', '0043', '1', 'Admin', '2017-04-18 17:24:59', 'Admin', '2017-04-18 17:24:59');
INSERT INTO `aut_role_rights` VALUES ('1', '0044', '1', 'Admin', '2017-04-18 17:25:01', 'Admin', '2017-04-18 17:25:01');
INSERT INTO `aut_role_rights` VALUES ('1', '0045', '1', 'Admin', '2017-04-18 17:25:04', 'Admin', '2017-04-18 17:25:04');
INSERT INTO `aut_role_rights` VALUES ('1', '0046', '1', 'Admin', '2017-04-18 17:25:13', 'Admin', '2017-04-18 17:25:13');
INSERT INTO `aut_role_rights` VALUES ('1', '0048', '1', 'Admin', '2017-04-18 17:25:16', 'Admin', '2017-04-18 17:25:16');
INSERT INTO `aut_role_rights` VALUES ('1', '0049', '1', 'Admin', '2017-04-18 17:25:19', 'Admin', '2017-04-18 17:25:19');
INSERT INTO `aut_role_rights` VALUES ('1', '0050', '1', 'Admin', '2017-04-18 17:25:21', 'Admin', '2017-04-18 17:25:21');
INSERT INTO `aut_role_rights` VALUES ('1', '0051', '1', 'Admin', '2017-04-18 17:25:24', 'Admin', '2017-04-18 17:25:24');
INSERT INTO `aut_role_rights` VALUES ('1', '0052', '1', 'Admin', '2017-04-18 17:25:27', 'Admin', '2017-04-18 17:25:27');
INSERT INTO `aut_role_rights` VALUES ('1', '0053', '1', 'Admin', '2017-04-18 17:25:30', 'Admin', '2017-04-18 17:25:30');
INSERT INTO `aut_role_rights` VALUES ('1', '0054', '1', 'Admin', '2017-04-18 17:25:32', 'Admin', '2017-04-18 17:25:32');
INSERT INTO `aut_role_rights` VALUES ('1', '0055', '1', 'Admin', '2017-04-18 17:25:35', 'Admin', '2017-04-18 17:25:35');
INSERT INTO `aut_role_rights` VALUES ('1', '0056', '1', 'Admin', '2017-04-18 17:25:38', 'Admin', '2017-04-18 17:25:38');
INSERT INTO `aut_role_rights` VALUES ('1', '0057', '1', 'Admin', '2017-04-18 17:25:42', 'Admin', '2017-04-18 17:25:42');
INSERT INTO `aut_role_rights` VALUES ('1', '0058', '1', 'Admin', '2017-04-18 17:25:45', 'Admin', '2017-04-18 17:25:45');
INSERT INTO `aut_role_rights` VALUES ('1', '0060', '1', 'Admin', '2017-04-18 17:25:48', 'Admin', '2017-04-18 17:25:48');
INSERT INTO `aut_role_rights` VALUES ('1', '0062', '1', 'Admin', '2017-04-18 17:25:50', 'Admin', '2017-04-18 17:25:50');
INSERT INTO `aut_role_rights` VALUES ('1', '0063', '1', 'Admin', '2017-04-18 17:25:53', 'Admin', '2017-04-18 17:25:53');
INSERT INTO `aut_role_rights` VALUES ('1', '0064', '1', 'Admin', '2017-04-18 17:25:56', 'Admin', '2017-04-18 17:25:56');
INSERT INTO `aut_role_rights` VALUES ('1', '0065', '1', 'Admin', '2017-04-18 17:25:58', 'Admin', '2017-04-18 17:25:58');
INSERT INTO `aut_role_rights` VALUES ('1', '0067', '1', 'Admin', '2017-04-18 17:26:01', 'Admin', '2017-04-18 17:26:01');
INSERT INTO `aut_role_rights` VALUES ('1', '0068', '1', 'Admin', '2017-04-18 17:26:04', 'Admin', '2017-04-18 17:26:04');
INSERT INTO `aut_role_rights` VALUES ('1', '0069', '1', 'Admin', '2017-04-18 17:26:43', 'Admin', '2017-04-18 17:26:43');
INSERT INTO `aut_role_rights` VALUES ('1', '0070', '1', 'Admin', '2017-04-18 17:26:46', 'Admin', '2017-04-18 17:26:46');
INSERT INTO `aut_role_rights` VALUES ('1', '0071', '1', 'Admin', '2017-04-18 17:26:48', 'Admin', '2017-04-18 17:26:48');
INSERT INTO `aut_role_rights` VALUES ('1', '0072', '1', 'Admin', '2017-04-18 17:26:51', 'Admin', '2017-04-18 17:26:51');
INSERT INTO `aut_role_rights` VALUES ('1', '0073', '1', 'Admin', '2017-04-18 17:26:54', 'Admin', '2017-04-18 17:26:54');
INSERT INTO `aut_role_rights` VALUES ('1', '0074', '1', 'Admin', '2017-04-18 17:26:56', 'Admin', '2017-04-18 17:26:56');
INSERT INTO `aut_role_rights` VALUES ('1', '0075', '1', 'Admin', '2017-04-18 17:27:00', 'Admin', '2017-04-18 17:27:00');
INSERT INTO `aut_role_rights` VALUES ('1', '0076', '1', 'Admin', '2017-04-18 17:27:02', 'Admin', '2017-04-18 17:27:02');
INSERT INTO `aut_role_rights` VALUES ('1', '0077', '1', 'Admin', '2017-04-18 17:27:05', 'Admin', '2017-04-18 17:27:05');
INSERT INTO `aut_role_rights` VALUES ('1', '0078', '1', 'Admin', '2017-04-18 17:27:07', 'Admin', '2017-04-18 17:27:07');
INSERT INTO `aut_role_rights` VALUES ('1', '0079', '1', 'Admin', '2017-04-18 17:27:10', 'Admin', '2017-04-18 17:27:10');
INSERT INTO `aut_role_rights` VALUES ('1', '0081', '1', 'Admin', '2017-04-18 17:27:13', 'Admin', '2017-04-18 17:27:13');
INSERT INTO `aut_role_rights` VALUES ('1', '0082', '1', 'Admin', '2017-04-18 17:27:16', 'Admin', '2017-04-18 17:27:16');
INSERT INTO `aut_role_rights` VALUES ('1', '0083', '1', 'Admin', '2017-04-18 17:27:19', 'Admin', '2017-04-18 17:27:19');
INSERT INTO `aut_role_rights` VALUES ('1', '0084', '1', 'Admin', '2017-04-18 17:27:21', 'Admin', '2017-04-18 17:27:21');
INSERT INTO `aut_role_rights` VALUES ('1', '0085', '1', 'Admin', '2017-04-18 17:27:24', 'Admin', '2017-04-18 17:27:24');
INSERT INTO `aut_role_rights` VALUES ('1', '0086', '1', 'Admin', '2017-04-18 17:27:27', 'Admin', '2017-04-18 17:27:27');
INSERT INTO `aut_role_rights` VALUES ('1', '0087', '1', 'Admin', '2017-04-18 17:27:30', 'Admin', '2017-04-18 17:27:30');
INSERT INTO `aut_role_rights` VALUES ('1', '0088', '1', 'Admin', '2017-04-18 17:27:38', 'Admin', '2017-04-18 17:27:38');
INSERT INTO `aut_role_rights` VALUES ('1', '0089', '1', 'Admin', '2017-04-18 17:27:41', 'Admin', '2017-04-18 17:27:41');
INSERT INTO `aut_role_rights` VALUES ('1', '0090', '1', 'Admin', '2017-04-18 17:27:43', 'Admin', '2017-04-18 17:27:43');
INSERT INTO `aut_role_rights` VALUES ('1', '0091', '1', 'Admin', '2017-04-18 17:27:46', 'Admin', '2017-04-18 17:27:46');
INSERT INTO `aut_role_rights` VALUES ('1', '0092', '1', 'Admin', '2017-04-18 17:27:49', 'Admin', '2017-04-18 17:27:49');
INSERT INTO `aut_role_rights` VALUES ('1', '0097', '1', 'Admin', '2017-04-18 17:27:52', 'Admin', '2017-04-18 17:27:52');
INSERT INTO `aut_role_rights` VALUES ('1', '0098', '1', 'Admin', '2017-04-18 17:27:54', 'Admin', '2017-04-18 17:27:54');
INSERT INTO `aut_role_rights` VALUES ('1', '0099', '1', 'Admin', '2017-04-18 17:27:58', 'Admin', '2017-04-18 17:27:58');
INSERT INTO `aut_role_rights` VALUES ('1', '0100', '1', 'Admin', '2017-04-18 17:28:01', 'Admin', '2017-04-18 17:28:01');
INSERT INTO `aut_role_rights` VALUES ('1', '0101', '1', 'Admin', '2017-04-18 17:28:06', 'Admin', '2017-04-18 17:28:06');
INSERT INTO `aut_role_rights` VALUES ('1', '0102', '1', 'Admin', '2017-04-18 17:28:10', 'Admin', '2017-04-18 17:28:10');
INSERT INTO `aut_role_rights` VALUES ('1', '0103', '1', 'Admin', '2017-04-18 17:21:34', 'Admin', '2017-04-18 17:28:57');
INSERT INTO `aut_role_rights` VALUES ('1', '0104', '1', 'Admin', '2017-04-18 17:29:17', 'Admin', '2017-04-18 17:29:17');
INSERT INTO `aut_role_rights` VALUES ('1', '0105', '1', 'Admin', '2017-04-18 17:29:20', 'Admin', '2017-04-18 17:29:20');
INSERT INTO `aut_role_rights` VALUES ('2', '0039', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0040', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0041', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0042', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0043', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0045', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0046', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0048', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0049', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0050', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0051', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0052', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0053', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0054', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0055', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0056', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0057', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0058', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0060', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0062', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0063', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0064', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0065', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0067', '1', 'Zhaoxin', '2017-04-18 17:35:23', 'Zhaoxin', '2017-04-18 17:35:23');
INSERT INTO `aut_role_rights` VALUES ('2', '0068', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0069', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0070', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0071', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0072', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0073', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0074', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0075', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0076', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0077', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0078', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0079', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0081', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0082', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0083', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0084', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0085', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0086', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0087', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0088', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0089', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0090', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0091', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0092', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0097', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0098', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0099', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0100', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0101', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0102', '1', 'Zhaoxin', '2017-04-18 17:35:24', 'Zhaoxin', '2017-04-18 17:35:24');
INSERT INTO `aut_role_rights` VALUES ('2', '0103', '1', 'Zhaoxin', '2017-04-18 17:35:25', 'Zhaoxin', '2017-04-18 17:35:25');
INSERT INTO `aut_role_rights` VALUES ('2', '0104', '1', 'Zhaoxin', '2017-04-18 17:35:25', 'Zhaoxin', '2017-04-18 17:35:25');
INSERT INTO `aut_role_rights` VALUES ('2', '0105', '1', 'Zhaoxin', '2017-04-18 17:35:25', 'Zhaoxin', '2017-04-18 17:35:25');
INSERT INTO `aut_role_rights` VALUES ('4', '0039', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:37');
INSERT INTO `aut_role_rights` VALUES ('4', '0040', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0041', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0042', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0043', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0044', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0045', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0046', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0048', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0049', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0050', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0051', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0052', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0053', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0060', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0062', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0063', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0069', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0070', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0071', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0072', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0073', '1', 'Admin', '2017-04-18 17:32:16', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0074', '1', 'Admin', '2017-04-18 17:32:17', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0075', '1', 'Admin', '2017-04-18 17:32:17', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0076', '1', 'Admin', '2017-04-18 17:32:17', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0077', '1', 'Admin', '2017-04-18 17:32:17', 'Zhaoxin', '2017-04-20 09:41:38');
INSERT INTO `aut_role_rights` VALUES ('4', '0078', '1', 'Admin', '2017-04-18 17:32:17', 'Zhaoxin', '2017-04-20 09:41:39');
INSERT INTO `aut_role_rights` VALUES ('6', '0039', '1', 'Admin', '2017-04-20 09:18:44', 'Admin', '2017-04-20 09:45:23');
INSERT INTO `aut_role_rights` VALUES ('6', '0040', '1', 'Admin', '2017-04-20 09:18:44', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0042', '1', 'Admin', '2017-04-20 09:18:44', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0043', '1', 'Admin', '2017-04-20 09:18:44', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0045', '1', 'Admin', '2017-04-20 09:18:44', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0046', '1', 'Admin', '2017-04-20 09:18:44', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0048', '1', 'Admin', '2017-04-20 09:18:44', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0051', '1', 'Admin', '2017-04-20 09:18:44', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0052', '1', 'Admin', '2017-04-20 09:18:44', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0053', '1', 'Admin', '2017-04-20 09:18:44', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0054', '1', 'Admin', '2017-04-20 09:18:44', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0055', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0056', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0057', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0058', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0060', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0062', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0063', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0069', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0070', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0071', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0072', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0073', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0074', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0075', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:24');
INSERT INTO `aut_role_rights` VALUES ('6', '0076', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:25');
INSERT INTO `aut_role_rights` VALUES ('6', '0077', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:25');
INSERT INTO `aut_role_rights` VALUES ('6', '0078', '1', 'Admin', '2017-04-20 09:18:45', 'Admin', '2017-04-20 09:45:25');
INSERT INTO `aut_role_rights` VALUES ('7', '0039', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0040', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0053', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0069', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0070', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0071', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0072', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0073', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0074', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0075', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0076', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0077', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0078', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0090', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0091', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0092', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0097', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0098', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0099', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('7', '0100', '1', 'Admin', '2017-04-20 09:29:27', 'Admin', '2017-04-20 09:29:27');
INSERT INTO `aut_role_rights` VALUES ('8', '0039', '1', 'Admin', '2017-04-20 09:30:53', 'Admin', '2017-04-20 09:30:53');
INSERT INTO `aut_role_rights` VALUES ('8', '0040', '1', 'Admin', '2017-04-20 09:30:53', 'Admin', '2017-04-20 09:30:53');
INSERT INTO `aut_role_rights` VALUES ('8', '0069', '1', 'Admin', '2017-04-20 09:30:53', 'Admin', '2017-04-20 09:30:53');
INSERT INTO `aut_role_rights` VALUES ('8', '0070', '1', 'Admin', '2017-04-20 09:30:53', 'Admin', '2017-04-20 09:30:53');
INSERT INTO `aut_role_rights` VALUES ('8', '0071', '1', 'Admin', '2017-04-20 09:30:53', 'Admin', '2017-04-20 09:30:53');
INSERT INTO `aut_role_rights` VALUES ('8', '0072', '1', 'Admin', '2017-04-20 09:30:53', 'Admin', '2017-04-20 09:30:53');
INSERT INTO `aut_role_rights` VALUES ('8', '0073', '1', 'Admin', '2017-04-20 09:30:54', 'Admin', '2017-04-20 09:30:54');
INSERT INTO `aut_role_rights` VALUES ('8', '0074', '1', 'Admin', '2017-04-20 09:30:54', 'Admin', '2017-04-20 09:30:54');
INSERT INTO `aut_role_rights` VALUES ('8', '0075', '1', 'Admin', '2017-04-20 09:30:54', 'Admin', '2017-04-20 09:30:54');
INSERT INTO `aut_role_rights` VALUES ('8', '0076', '1', 'Admin', '2017-04-20 09:30:54', 'Admin', '2017-04-20 09:30:54');
INSERT INTO `aut_role_rights` VALUES ('8', '0077', '1', 'Admin', '2017-04-20 09:30:54', 'Admin', '2017-04-20 09:30:54');
INSERT INTO `aut_role_rights` VALUES ('8', '0078', '1', 'Admin', '2017-04-20 09:30:54', 'Admin', '2017-04-20 09:30:54');
INSERT INTO `aut_role_rights` VALUES ('8', '0090', '1', 'Admin', '2017-04-20 09:30:54', 'Admin', '2017-04-20 09:30:54');
INSERT INTO `aut_role_rights` VALUES ('8', '0092', '1', 'Admin', '2017-04-20 09:30:54', 'Admin', '2017-04-20 09:30:54');
INSERT INTO `aut_role_rights` VALUES ('8', '0097', '1', 'Admin', '2017-04-20 09:30:54', 'Admin', '2017-04-20 09:30:54');
INSERT INTO `aut_role_rights` VALUES ('8', '0098', '1', 'Admin', '2017-04-20 09:30:54', 'Admin', '2017-04-20 09:30:54');
INSERT INTO `aut_role_rights` VALUES ('8', '0099', '1', 'Admin', '2017-04-20 09:30:54', 'Admin', '2017-04-20 09:30:54');
INSERT INTO `aut_role_rights` VALUES ('8', '0100', '1', 'Admin', '2017-04-20 09:30:54', 'Admin', '2017-04-20 09:30:54');

-- ----------------------------
-- Table structure for aut_users
-- ----------------------------
DROP TABLE IF EXISTS `aut_users`;
CREATE TABLE `aut_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) NOT NULL COMMENT '用户编号',
  `userName` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(50) DEFAULT NULL COMMENT '性别',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `grpIds` varchar(500) DEFAULT NULL COMMENT '所属机构',
  `orgIds` varchar(500) DEFAULT NULL COMMENT '所属组织',
  `deptId` int(11) DEFAULT NULL COMMENT '所属部门id',
  `userType` varchar(50) DEFAULT NULL COMMENT '用户属性',
  `userClass` varchar(50) DEFAULT NULL COMMENT '用户类别',
  `regDate` date DEFAULT NULL COMMENT '注册日期',
  `eMail` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `valid` tinyint(4) DEFAULT '1' COMMENT '有效标志',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '新增用户',
  `createdTime` datetime DEFAULT NULL COMMENT '新增时间',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '更新用户',
  `modifiedTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aut_users
-- ----------------------------
INSERT INTO `aut_users` VALUES ('1', 'U000000002', 'Admin', '王毅', 'M', 's2gWpZhumkn2yuCIarLqug==', 'GRP0052', 'DIS-山东广顺国际旅行社-2', '1', '0', '1', '2017-01-24', 'wangyi@lvyou.cn', '13872000534', '系统信息管理专员', '1', 'testuser', '2017-01-24 16:40:00', 'Admin', '2017-04-20 10:14:27');
INSERT INTO `aut_users` VALUES ('2', 'U000000003', 'Wangke', '王珂', 'M', 's2gWpZhumkn2yuCIarLqug==', 'GRP0044', 'DIS-山东广顺国际旅行社-2', '77', '0', '1', '2017-04-11', 'wangke@lvyou.com', '13623456789', '', '1', 'Admin', '2017-04-11 15:10:20', 'Admin', '2017-04-18 16:29:17');
INSERT INTO `aut_users` VALUES ('3', 'U000000004', 'Linda', '李琳', 'F', 's2gWpZhumkn2yuCIarLqug==', 'GRP0044', 'DIS-山东广顺国际旅行社-2', '78', '0', '1', '2017-04-11', 'lilin@lvyou.cn', '18612345678', '', '1', 'Admin', '2017-04-11 15:40:02', 'Admin', '2017-04-20 09:19:10');
INSERT INTO `aut_users` VALUES ('4', 'U000000005', 'Zhaoxin', '赵鑫', 'M', 's2gWpZhumkn2yuCIarLqug==', 'GRP0044', 'DIS-山东广顺国际旅行社-2', '79', '0', '1', '2017-04-11', 'zhaoxin@lvyou.cn', '18645678909', '', '1', 'Admin', '2017-04-11 15:56:02', 'Zhaoxin', '2017-04-20 09:42:44');
INSERT INTO `aut_users` VALUES ('5', 'U000000006', 'Zhangshuang', '张爽', 'F', 's2gWpZhumkn2yuCIarLqug==', null, 'CHN-携程旅游公司-13', '80', '1', '2', '2017-04-18', 'zhagnshaung@lvyou.cn', '13654321234', '', '1', null, '2017-04-18 11:39:49', null, '2017-04-18 13:18:58');
INSERT INTO `aut_users` VALUES ('6', 'U000000007', 'wangyue', '王月', 'M', 's2gWpZhumkn2yuCIarLqug==', null, 'CHN-携程旅游公司-13', '81', '1', '2', '2017-04-18', 'wangyue@lvyou.cn', '18765432334', '', '1', null, '2017-04-18 13:18:58', null, '2017-04-18 13:18:58');
INSERT INTO `aut_users` VALUES ('7', 'U000000008', 'limei', '李梅', 'F', 's2gWpZhumkn2yuCIarLqug==', null, 'CHN-驴妈妈网有限公司-15', '82', '1', '2', '2017-04-18', 'limei@lvyou.cn', '18654321234', '', '1', null, '2017-04-18 13:45:23', null, '2017-04-18 13:45:23');
INSERT INTO `aut_users` VALUES ('8', 'U000000009', 'zhangkeke', '张可可', 'F', 's2gWpZhumkn2yuCIarLqug==', null, 'CHN-去哪儿网有限公司-14', '79', '1', '2', '2017-04-18', 'zhangkk@lvyou.cn', '13678909876', '', '1', null, '2017-04-18 13:45:57', null, '2017-04-18 13:45:57');
INSERT INTO `aut_users` VALUES ('9', 'U000000010', 'Tom', '汤姆', 'M', 's2gWpZhumkn2yuCIarLqug==', 'GRP0053', 'DIS-山东广顺国际旅行社-2', '78', '0', '1', '2017-04-20', 'tom@lvyou.cn', '18567898769', '', '1', 'Admin', '2017-04-20 09:36:11', 'Admin', '2017-04-20 10:06:44');
INSERT INTO `aut_users` VALUES ('10', 'U000000011', 'Amy', '艾米', 'F', 's2gWpZhumkn2yuCIarLqug==', 'GRP0053', 'DIS-山东广顺国际旅行社-2', '80', '0', '1', '2017-04-20', 'aimi@lvyou.cn', '13567890980', '', '1', 'Admin', '2017-04-20 09:36:51', 'Admin', '2017-04-20 10:07:02');

-- ----------------------------
-- Table structure for aut_user_groups
-- ----------------------------
DROP TABLE IF EXISTS `aut_user_groups`;
CREATE TABLE `aut_user_groups` (
  `grpId` varchar(100) NOT NULL COMMENT '机构编号',
  `grpName` varchar(50) DEFAULT NULL COMMENT '机构名称',
  `parentId` varchar(100) DEFAULT NULL COMMENT '上级机构编号',
  `grpType` varchar(50) DEFAULT NULL COMMENT '机构类型',
  `orgId` varchar(50) DEFAULT NULL COMMENT '组织编号',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `valid` tinyint(4) DEFAULT '1' COMMENT '有效标志',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '新增用户',
  `createdTime` datetime DEFAULT NULL COMMENT '新增时间',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '更新用户',
  `modifiedTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`grpId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aut_user_groups
-- ----------------------------
INSERT INTO `aut_user_groups` VALUES ('GRP0006', '财务中心', '', '0', 'DIS-山东广顺国际旅行社-2', '一级部门', '1', 'Admin', '2017-04-11 14:25:00', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0007', '市场部', '', '0', 'DIS-山东广顺国际旅行社-2', '一级部门', '1', 'Admin', '2017-04-11 14:27:21', 'Admin', '2017-04-11 15:24:07');
INSERT INTO `aut_user_groups` VALUES ('GRP0008', '运营部', '', '0', 'DIS-山东广顺国际旅行社-2', '一级部门', '1', 'Admin', '2017-04-11 14:27:45', 'Admin', '2017-04-20 09:34:51');
INSERT INTO `aut_user_groups` VALUES ('GRP0009', '产品部', '', '0', 'DIS-山东广顺国际旅行社-2', '一级部门', '1', 'Admin', '2017-04-11 14:28:07', 'Admin', '2017-04-11 14:28:36');
INSERT INTO `aut_user_groups` VALUES ('GRP0011', '票务中心', '', '0', 'DIS-山东广顺国际旅行社-2', '一级部门', '1', 'Admin', '2017-04-11 14:35:59', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0012', '国内票务部', 'GRP0011', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:36:23', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0013', '国际散票部', 'GRP0011', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:36:43', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0014', '国际团体部', 'GRP0011', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:37:00', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0015', '票务客服部', 'GRP0011', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:37:27', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0016', '后台管理部', 'GRP0011', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:38:44', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0017', '国内中心', '', '0', 'DIS-山东广顺国际旅行社-2', '一级部门', '1', 'Admin', '2017-04-11 14:39:06', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0018', '国内专线', 'GRP0017', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:39:59', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0019', '外勤部', 'GRP0017', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:40:22', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0020', '国内综合部', 'GRP0017', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:40:43', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0021', '高铁部', 'GRP0017', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:41:36', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0022', '北京部', 'GRP0017', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:41:59', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0023', '华东部', 'GRP0017', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:42:17', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0024', '山东东北部', 'GRP0017', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:42:53', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0025', '山西内蒙部', 'GRP0017', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:43:20', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0026', '西北部', 'GRP0017', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:43:38', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0027', '西安中原部', 'GRP0017', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:43:57', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0028', '出境中心', '', '0', 'DIS-山东广顺国际旅行社-2', '一级部门', '1', 'Admin', '2017-04-11 14:44:26', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0029', '中东非洲专线', 'GRP0028', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:44:56', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0030', '签证部', 'GRP0028', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:47:26', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0031', '邮轮部', 'GRP0028', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:48:17', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0032', '美洲部', 'GRP0028', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:49:27', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0033', '澳纽部', 'GRP0028', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:49:51', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0034', '欧洲部', 'GRP0028', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:50:10', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0035', '日韩部', 'GRP0028', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:50:30', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0036', '台湾部', 'GRP0028', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:53:32', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0037', '东南亚部', 'GRP0028', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:55:25', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0041', '接待中心', '', '0', 'DIS-山东广顺国际旅行社-2', '一级部门', '1', 'Admin', '2017-04-11 14:59:24', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0042', '导游部', 'GRP0041', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 14:59:53', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0043', '咨询部', 'GRP0041', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 15:00:17', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0044', '产品研发部', 'GRP0009', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 15:02:46', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0045', '产品计调部', 'GRP0009', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 15:04:06', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0046', '财务部', 'GRP0006', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 15:15:35', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0047', '采购中心', '', '0', 'DIS-山东广顺国际旅行社-2', '一级部门', '1', 'Admin', '2017-04-11 15:23:00', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0048', '采购部', 'GRP0047', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 15:23:16', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0049', '市场销售部', 'GRP0007', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 15:28:21', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0050', '信息中心', '', '0', 'DIS-山东广顺国际旅行社-2', '一级部门', '1', 'Admin', '2017-04-11 16:03:40', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0051', '产品信息部', 'GRP0050', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 16:05:00', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0052', '系统信息部', 'GRP0050', '0', 'DIS-山东广顺国际旅行社-2', '二级部门', '1', 'Admin', '2017-04-11 16:07:38', null, null);
INSERT INTO `aut_user_groups` VALUES ('GRP0053', '渠道运营部', 'GRP0008', '0', 'DIS-山东广顺国际旅行社-2', '渠道运营部', '1', 'Admin', '2017-04-20 09:35:12', null, null);

-- ----------------------------
-- Table structure for aut_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `aut_user_roles`;
CREATE TABLE `aut_user_roles` (
  `roleId` varchar(50) NOT NULL COMMENT '角色编号',
  `userId` varchar(50) NOT NULL COMMENT '用户编号',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '新增用户',
  `createdTime` datetime DEFAULT NULL COMMENT '新增时间',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '更新用户',
  `modifiedTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`roleId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aut_user_roles
-- ----------------------------
INSERT INTO `aut_user_roles` VALUES ('1', 'U000000002', 'Admin', '2017-04-18 10:01:20', 'Admin', '2017-04-18 10:01:20');
INSERT INTO `aut_user_roles` VALUES ('2', 'U000000003', 'Admin', '2017-04-18 16:29:17', 'Admin', '2017-04-18 16:29:17');
INSERT INTO `aut_user_roles` VALUES ('2', 'U000000018', 'Admin', '2017-04-10 09:53:49', 'Admin', '2017-04-10 09:53:49');
INSERT INTO `aut_user_roles` VALUES ('2', 'U000000019', 'Admin', '2017-04-10 10:37:35', 'Admin', '2017-04-10 10:37:35');
INSERT INTO `aut_user_roles` VALUES ('2', 'U000000020', 'Admin', '2017-04-10 10:57:15', 'Admin', '2017-04-10 10:57:15');
INSERT INTO `aut_user_roles` VALUES ('4', 'U000000005', 'Zhaoxin', '2017-04-20 09:42:44', 'Zhaoxin', '2017-04-20 09:42:44');
INSERT INTO `aut_user_roles` VALUES ('6', 'U000000004', 'Admin', '2017-04-20 09:19:10', 'Admin', '2017-04-20 09:19:10');
INSERT INTO `aut_user_roles` VALUES ('7', 'U000000010', 'Admin', '2017-04-20 10:06:44', 'Admin', '2017-04-20 10:06:44');
INSERT INTO `aut_user_roles` VALUES ('8', 'U000000011', 'Admin', '2017-04-20 10:07:02', 'Admin', '2017-04-20 10:07:02');

-- ----------------------------
-- Table structure for product_class
-- ----------------------------
DROP TABLE IF EXISTS `product_class`;
CREATE TABLE `product_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类主键',
  `className` varchar(200) DEFAULT NULL COMMENT '分类名称',
  `parentId` int(11) DEFAULT NULL COMMENT '父类id ',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdUser` varchar(255) DEFAULT NULL COMMENT '创建人用户名',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedUser` varchar(255) DEFAULT NULL COMMENT '修改人用户名',
  `modifiedTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_class
-- ----------------------------
INSERT INTO `product_class` VALUES ('1', '出境游', null, null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-23 10:43:26');
INSERT INTO `product_class` VALUES ('2', '国内游', null, null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('3', '海岛游', null, null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('4', '欧美大国', '1', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('5', '澳非探秘', '1', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-23 10:40:24');
INSERT INTO `product_class` VALUES ('6', '日港澳', '1', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('7', '东南亚风情', '1', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('8', '海滨', '2', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-23 10:41:58');
INSERT INTO `product_class` VALUES ('9', '南方', '2', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-23 17:34:35');
INSERT INTO `product_class` VALUES ('10', '中东部', '2', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('11', '西北部', '2', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('12', '经济岛屿', '3', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('13', '专业岛屿', '3', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('14', '奢华岛屿', '3', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('15', '热门岛屿', '3', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('16', '美洲\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n', '4', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('17', '欧洲', '4', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('18', '澳洲', '4', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('19', '中东非', '5', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-23 15:00:55');
INSERT INTO `product_class` VALUES ('20', '日本', '6', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('21', '港澳', '6', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('22', '泰国', '7', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('23', '东南亚', '7', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('24', '海南', '12', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('25', '四川', '9', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-23 10:40:47');
INSERT INTO `product_class` VALUES ('26', '广西', '9', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('27', '山东', '10', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('28', '云南', '9', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('29', '贵州', '9', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('30', '重庆', '9', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('31', '湖南', '9', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('32', '湖北', '10', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('33', '江西', '9', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('34', '西藏', '11', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('35', '三亚', '12', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('36', '长滩岛', '12', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('37', '宿雾薄荷', '12', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('38', '杜马盖地', '12', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('39', '沙巴岛', '12', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('40', '芽庄', '12', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('41', '岘港', '12', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('42', '冲绳', '12', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('43', '苏梅岛', '13', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('44', '夏威夷', '13', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('45', '兰卡威', '13', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('46', '关岛', '13', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('47', '圣托里尼岛', '14', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('48', '大溪地', '14', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('49', '斐济岛', '14', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('50', '毛里求斯', '14', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('51', '塞舌尔', '14', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('52', '马尔代夫', '15', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('53', '巴厘岛', '15', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('54', '塞班岛', '15', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('55', '斯里兰卡', '15', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('56', '塞浦路斯', '15', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('57', '普吉岛', '15', null, 'Admin', '2017-06-08 11:13:44', 'Admin', '2017-06-08 11:13:44');
INSERT INTO `product_class` VALUES ('114', '福建', '8', null, 'Admin', '2017-06-23 10:40:53', 'Admin', '2017-06-23 10:40:53');
INSERT INTO `product_class` VALUES ('115', '威海', '8', null, 'Admin', '2017-06-23 10:40:58', 'Admin', '2017-06-23 10:40:58');
INSERT INTO `product_class` VALUES ('116', '大连', '8', null, 'Admin', '2017-06-23 10:41:02', 'Admin', '2017-06-23 10:41:02');
INSERT INTO `product_class` VALUES ('117', '秦皇岛', '8', null, 'Admin', '2017-06-23 10:41:13', 'Admin', '2017-06-23 16:50:46');
INSERT INTO `product_class` VALUES ('118', '兰州', '11', null, 'Admin', '2017-06-23 10:41:22', 'Admin', '2017-06-23 10:41:22');
INSERT INTO `product_class` VALUES ('119', '宁夏', '11', null, 'Admin', '2017-06-23 10:41:31', 'Admin', '2017-06-23 10:41:31');
INSERT INTO `product_class` VALUES ('121', '新疆', '11', null, 'Admin', '2017-06-23 10:41:42', 'Admin', '2017-06-23 10:41:42');
INSERT INTO `product_class` VALUES ('122', '北京', '10', null, 'Admin', '2017-06-23 10:41:49', 'Admin', '2017-06-23 10:41:49');
INSERT INTO `product_class` VALUES ('123', '上海', '10', null, 'Admin', '2017-06-23 10:41:54', 'Admin', '2017-06-23 10:41:54');
INSERT INTO `product_class` VALUES ('130', '东北部', '2', null, 'Admin', '2017-07-05 14:26:31', 'Admin', '2017-07-05 14:26:31');
INSERT INTO `product_class` VALUES ('131', '哈尔滨', '130', null, 'Admin', '2017-07-05 14:26:40', 'Admin', '2017-07-05 14:26:40');
INSERT INTO `product_class` VALUES ('132', '齐齐哈尔', '130', null, 'Admin', '2017-07-05 14:26:45', 'Admin', '2017-07-05 14:26:45');
INSERT INTO `product_class` VALUES ('133', '沈阳', '130', null, 'Admin', '2017-07-05 14:26:49', 'Admin', '2017-07-05 14:26:49');
INSERT INTO `product_class` VALUES ('134', '西安', '10', null, 'Admin', '2017-07-05 14:34:47', 'Admin', '2017-07-05 14:34:47');

-- ----------------------------
-- Table structure for product_distributions
-- ----------------------------
DROP TABLE IF EXISTS `product_distributions`;
CREATE TABLE `product_distributions` (
  `prodId` int(11) NOT NULL COMMENT '产品编号',
  `distId` int(11) NOT NULL COMMENT '分销商/渠道商编号',
  `distType` int(11) DEFAULT NULL COMMENT '分销商类型：  0:分销商    1：渠道商',
  `beginDate` date DEFAULT NULL COMMENT '销售开始日期',
  `endDate` date DEFAULT NULL COMMENT '销售结束日期',
  `distQty` int(11) DEFAULT '0' COMMENT '分配数量',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdUser` varchar(255) DEFAULT NULL COMMENT '创建人用户名',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedUser` varchar(255) DEFAULT NULL COMMENT '最后修改人姓名',
  `modifiedTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`prodId`,`distId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_distributions
-- ----------------------------
INSERT INTO `product_distributions` VALUES ('5', '15', '1', '2017-06-13', '2017-06-21', '21', null, 'Admin', '2017-06-15 11:05:07', 'Admin', '2017-06-22 14:38:40');
INSERT INTO `product_distributions` VALUES ('6', '13', '1', '2017-06-21', '2017-06-27', '16', null, 'Admin', '2017-06-12 16:44:45', 'Admin', '2017-06-29 14:14:22');
INSERT INTO `product_distributions` VALUES ('7', '9', '0', '2017-07-13', '2017-07-20', '20', null, 'Admin', '2017-07-05 14:42:49', 'Admin', '2017-07-05 14:42:49');
INSERT INTO `product_distributions` VALUES ('7', '14', '1', '2017-07-11', '2017-07-28', '10', null, 'Admin', '2017-07-05 16:31:19', 'Admin', '2017-07-05 16:31:19');

-- ----------------------------
-- Table structure for product_guidesinfo
-- ----------------------------
DROP TABLE IF EXISTS `product_guidesinfo`;
CREATE TABLE `product_guidesinfo` (
  `prodId` int(11) NOT NULL COMMENT '产品id',
  `guideId` int(11) NOT NULL COMMENT '导游id',
  `createdUser` varchar(255) DEFAULT NULL COMMENT '创建人用户名',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedUser` varchar(255) DEFAULT NULL COMMENT '最后修改人用户名',
  `modifiedTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`prodId`,`guideId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_guidesinfo
-- ----------------------------
INSERT INTO `product_guidesinfo` VALUES ('5', '1', 'Admin', '2017-06-15 11:04:25', 'Admin', '2017-06-15 11:04:25');
INSERT INTO `product_guidesinfo` VALUES ('5', '2', 'Admin', '2017-06-30 10:00:47', 'Admin', '2017-06-30 10:00:47');
INSERT INTO `product_guidesinfo` VALUES ('6', '1', 'Admin', '2017-06-15 10:27:09', 'Admin', '2017-06-15 10:27:09');
INSERT INTO `product_guidesinfo` VALUES ('6', '2', 'Admin', '2017-06-15 11:04:34', 'Admin', '2017-06-15 11:04:34');
INSERT INTO `product_guidesinfo` VALUES ('7', '1', 'Admin', '2017-07-05 15:08:50', 'Admin', '2017-07-05 15:08:50');
INSERT INTO `product_guidesinfo` VALUES ('7', '2', 'Admin', '2017-07-05 15:08:50', 'Admin', '2017-07-05 15:08:50');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `prodId` varchar(50) NOT NULL COMMENT '产品编号',
  `prodName` varchar(200) DEFAULT '' COMMENT '产品名称',
  `numId` int(11) DEFAULT NULL COMMENT '团号Id',
  `exText` varchar(500) DEFAULT NULL COMMENT '特殊提示',
  `prodIntro` varchar(2000) DEFAULT '' COMMENT '产品介绍',
  `srvcBeginDate` date DEFAULT NULL COMMENT '服务开始时间',
  `srvcEndDate` date DEFAULT NULL COMMENT '服务结束时间',
  `onlineDate` date DEFAULT NULL COMMENT '上架时间',
  `offlineDate` date DEFAULT NULL COMMENT '下架时间',
  `quantity` int(11) DEFAULT '0' COMMENT '预售数量',
  `minQty` int(11) DEFAULT '0' COMMENT '最低数量',
  `soldQty` int(11) DEFAULT '0' COMMENT '已售数量',
  `price` decimal(10,0) DEFAULT '0' COMMENT '产品价格',
  `classId` int(11) DEFAULT '0' COMMENT '产品分类编号',
  `nights` int(11) DEFAULT '0' COMMENT '晚数',
  `state` int(11) DEFAULT '0' COMMENT '产品状态  0：待售  1：上架   2：下架',
  `contientId` int(11) DEFAULT NULL COMMENT '目的地:预留字段',
  `startPlace` varchar(255) DEFAULT NULL COMMENT '出发地',
  `returnPlace` varchar(255) DEFAULT NULL COMMENT '返回地',
  `startDate` date DEFAULT NULL COMMENT '出发日期',
  `mgrId` int(11) DEFAULT NULL COMMENT '产品负责人编号',
  `endDate` date DEFAULT NULL COMMENT '返回日期',
  `note` varchar(2000) DEFAULT NULL COMMENT '备注',
  `createdUser` varchar(255) DEFAULT NULL COMMENT '创建人用户名',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedUser` varchar(255) DEFAULT NULL COMMENT '最后修改人用户名',
  `modifiedTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('5', 'TLCN20170503SYCJ01001', '梦幻天堂·赏鲸之旅', '3', '注意安全', '大溪地·波拉波拉岛圣瑞吉St Regis·与魔鬼鱼共舞+浮潜观鲸8天6晚 HOT', '2017-07-01', '2017-07-31', '2017-06-16', '2017-06-30', '40', '40', '0', '30000', '48', '7', '1', null, '北京', '大溪地', '2017-07-07', '3', '2017-07-15', '行程亮点\r\n【这就是大溪地波拉波拉岛】 \r\n★【岛屿天堂】波拉波拉岛圣瑞吉水上别墅，享受山峰雄姿和泻湖美景，世外桃源般奢华度假\r\n★【季节限定】7-10月，私人游船出海，寻觅座头鲸的身影，感受近距离观鲸的心跳 \r\n★【原野自然】四驱车探索大溪地最大的山谷，感受波利尼西亚文化传统，发掘大溪地的另种风情 \r\n★【奢华体验】坐落在私人岛屿上的娇韵诗水疗中心，美轮美奂的自然景致唤醒感官美妙体验 \r\n【HHtravel亮点】 \r\n★【与海狂欢】泻湖浮潜，日落巡航，喂食鲨鱼，与魔鬼鱼共舞，尽情狂欢 \r\n★【公务舱】甄选大溪地航空公务舱，尽享公务舱尊贵礼遇，舒适航程\r\n★【入住惊喜】递送一份令人难忘的惊喜礼品，在客房内尽情享用 \r\n★【极致服务】有求必应的管家理念，丰富多彩的活动，体贴周到的服务，满足大小客人的各种需求', 'Admin', '2017-06-09 16:24:36', 'Admin', '2017-06-13 10:44:06');
INSERT INTO `product_info` VALUES ('6', 'TLCN20170503HZCJ02001', '上天入地·奢豪之旅', '2', '注意安全', '行程亮点\r\n【走进黄金帝国·畅游奇迹未来】\r\n★度假必选：走进柏拉图理想国，在棕榈岛亚特兰蒂斯水上王国嬉戏踏浪！\r\n★沙漠冲沙：专属四驱车冲沙，骑骆驼、绘汉娜、感受阿拉伯奢华，诠释贝都因风情。\r\n★VIP尊享： 直升机凌空俯览奇迹之国，法拉利主题乐园点燃激情，从陆地到天空的跨越！\r\n★乐畅购物：在特产手表黄金的国度，一站式购物中心免税血拼壕购！\r\n【HHtravel亮点】\r\n★臻享航班：阿提哈德航空豪华商务舱往返平躺直飞，尽享空中飞行时光。\r\n★高端摘星：五六七八星酒店连住升级房型，成为奢华酒店的评鉴人。\r\n★美食盛宴：帆船海底餐+八星饕餮自助+迪拜塔高空景观餐。', '2017-07-07', '2017-07-31', '2017-06-16', '2017-06-30', '50', '48', '0', '70000', '19', '5', '1', null, '北京', '迪拜', '2017-07-08', '2', '2017-07-14', '阿联酋的国家航空公司·阿提哈德：\r\n阿提哈德当之无愧是全球优质航空公司之一，多次荣获世界旅游奖评选的奖项，也是英国曼城足球俱乐部的赞助商。', 'Admin', '2017-06-09 16:27:18', 'Admin', '2017-06-13 10:43:54');
INSERT INTO `product_info` VALUES ('7', 'TPCN-CHN-20170605-XA-11-001', '兵马俑制作+大明宫游览+拓片体验亲子文化游3晚4天 ', '10', '注意天气变化', '甄选悦椿温泉酒店，尽享泡汤之乐趣；精选凯悦湖景客房，揽南湖之美景；\r\n★兵马俑制作体验，寻找消失的军团；\r\n★模拟考古挖掘，用传统工艺拓出民族文化，从古文字和图案中品味秦唐风韵；\r\n★观皮影戏，感受民间戏曲艺术之乐趣；\r\n★实景历史剧《长恨歌》，骊山脚下再现大唐太平盛世；\r\n★全程专属车导，享无忧旅行；', '2017-07-13', '2017-07-28', '2017-07-14', '2017-07-27', '30', '28', '0', '5555', '134', '3', '1', null, '北京', '西安', '2017-07-20', '7', '2017-07-24', '★甄选悦椿温泉酒店，尽享泡汤之乐趣；精选凯悦湖景客房，揽南湖之美景；\r\n★兵马俑制作体验，寻找消失的军团；\r\n★模拟考古挖掘，用传统工艺拓出民族文化，从古文字和图案中品味秦唐风韵；\r\n★观皮影戏，感受民间戏曲艺术之乐趣；\r\n★实景历史剧《长恨歌》，骊山脚下再现大唐太平盛世；\r\n★全程专属车导，享无忧旅行；', 'Admin', '2017-07-05 14:41:18', 'Admin', '2017-07-05 15:23:34');
INSERT INTO `product_info` VALUES ('8', 'TPCN-CHN-20171207-HRB-10-001', '20171216哈尔滨冰灯豪华游', '9', '注意天气变化', '20171216哈尔滨冰灯豪华游', '2017-12-01', '2017-12-29', '2017-07-09', '2017-07-15', '30', '25', '0', '3000', '131', '4', '0', null, '北京', '哈尔滨', '2017-07-16', '6', '2017-07-21', '20171216哈尔滨冰灯豪华游', 'Admin', '2017-07-06 11:32:35', 'Admin', '2017-07-06 11:32:35');

-- ----------------------------
-- Table structure for product_pricepolicies
-- ----------------------------
DROP TABLE IF EXISTS `product_pricepolicies`;
CREATE TABLE `product_pricepolicies` (
  `prodId` int(11) NOT NULL COMMENT '产品id',
  `pricePolicyId` int(11) NOT NULL COMMENT '价格政策id',
  `createdUser` varchar(255) DEFAULT NULL COMMENT '创建人用户名',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedUser` varchar(255) DEFAULT NULL COMMENT '最后修改人用户名',
  `modifiedTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`prodId`,`pricePolicyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_pricepolicies
-- ----------------------------
INSERT INTO `product_pricepolicies` VALUES ('5', '1', 'Admin', '2017-06-21 11:37:29', 'Admin', '2017-06-21 11:37:29');
INSERT INTO `product_pricepolicies` VALUES ('5', '3', 'Admin', '2017-06-29 14:19:19', 'Admin', '2017-06-29 14:19:19');
INSERT INTO `product_pricepolicies` VALUES ('6', '1', 'Admin', '2017-06-27 10:20:50', 'Admin', '2017-06-27 10:20:50');
INSERT INTO `product_pricepolicies` VALUES ('6', '3', 'Admin', '2017-06-27 10:20:55', 'Admin', '2017-06-27 10:20:55');
INSERT INTO `product_pricepolicies` VALUES ('7', '3', 'Admin', '2017-07-05 15:04:31', 'Admin', '2017-07-05 15:04:31');

-- ----------------------------
-- Table structure for product_projects
-- ----------------------------
DROP TABLE IF EXISTS `product_projects`;
CREATE TABLE `product_projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物理主键',
  `prjId` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '项目编号',
  `prjName` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '项目名称',
  `deptId` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '归属部门',
  `beginDate` date DEFAULT NULL COMMENT '开始日期',
  `endDate` date DEFAULT NULL COMMENT '结束日期',
  `valid` tinyint(1) DEFAULT '1' COMMENT '有效(1: 启用 0: 禁用)',
  `note` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `createdUser` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '新增用户',
  `createdTime` datetime DEFAULT NULL COMMENT '新增时间',
  `modifiedUser` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '更新用户',
  `modifiedTime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of product_projects
-- ----------------------------
INSERT INTO `product_projects` VALUES ('1', 'TPCN-20170301-CHN-HN-09', '三亚春季项目', '79', '2017-03-01', '2017-06-30', '1', '三亚春季旅游项目', null, '2017-04-01 14:44:06', 'Admin', '2017-06-29 18:24:37');
INSERT INTO `product_projects` VALUES ('2', 'TPCN-20170301-CHN-HZ-08', '杭州春季旅游项目', '79', '2017-03-01', '2017-06-30', '1', '杭州春季(3-6月)旅游项目', null, '2017-04-01 14:45:36', 'Admin', '2017-06-29 18:24:20');
INSERT INTO `product_projects` VALUES ('3', 'TPCN-20170301-CHN-WEB-07', '川，青，藏春季旅游项目', '80', '2017-03-01', '2017-06-30', '1', '四川，青海，西藏春季旅游项目', null, '2017-04-01 14:47:41', 'Admin', '2017-06-29 18:24:03');
INSERT INTO `product_projects` VALUES ('4', 'TP-20170301-EUR-PAR-06', '北欧春季旅游项目', '77', '2017-03-01', '2017-05-31', '1', '国外春季旅游项目启动', null, '2017-04-05 11:52:39', 'Admin', '2017-06-29 18:23:43');
INSERT INTO `product_projects` VALUES ('5', 'TPCH-20170605-CHN-BJ-02', '北京6月三日游项目', '81', '2017-06-14', '2017-06-17', '1', '北京6月豪华三日游项目', 'Admin', '2017-06-05 15:52:59', 'Admin', '2017-06-29 18:21:44');
INSERT INTO `product_projects` VALUES ('6', 'TPCN-20170613-CHN-WH-04', '威海一日游', '77', '2017-06-13', '2017-06-14', '0', '威海一日游happy', 'Admin', '2017-06-05 15:38:40', 'Admin', '2017-06-29 18:22:06');
INSERT INTO `product_projects` VALUES ('7', 'TPCN-20170614-CHN-HN-03', '海南三日游', '79', '2017-06-14', '2017-06-15', '1', '海南三日游', 'Admin', '2017-06-05 15:44:13', 'Admin', '2017-06-29 18:21:36');
INSERT INTO `product_projects` VALUES ('8', 'TP-20170413-KRO-SE-05', '韩国五日游项目', '78', '2017-04-13', '2017-04-20', '0', '韩国五日游项目', null, '2017-04-11 16:13:30', 'Admin', '2017-06-29 18:23:11');
INSERT INTO `product_projects` VALUES ('10', 'TPCN-20171216-CHN-DB-01', '东北三省五日游项目', '81', '2017-12-13', '2017-12-18', '1', '东北三省豪华五日游项目', 'Admin', '2017-06-29 18:10:37', 'Admin', '2017-07-03 15:54:12');
INSERT INTO `product_projects` VALUES ('11', 'TPCN-CHN-20171207-HRB-10', '哈尔滨冰灯节冬季项目', '81', '2017-12-07', '2018-01-01', '1', '哈尔滨冰灯节冬季项目，三日，五日', 'Admin', '2017-07-05 14:28:15', 'Admin', '2017-07-05 14:28:35');
INSERT INTO `product_projects` VALUES ('12', 'TPCN-CHN-20170605-XA-11', '西安· 秦风唐韵', '82', '2017-07-13', '2017-07-28', '1', '西安· 秦风唐韵项目', 'Admin', '2017-07-05 14:36:46', null, '2017-07-05 14:36:46');

-- ----------------------------
-- Table structure for product_teams
-- ----------------------------
DROP TABLE IF EXISTS `product_teams`;
CREATE TABLE `product_teams` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机构编号',
  `tName` varchar(50) NOT NULL COMMENT '团名称',
  `prjId` int(11) DEFAULT NULL COMMENT '项目编号',
  `managerId` int(11) DEFAULT NULL COMMENT '负责人   此负责人是团和产品的负责人',
  `valid` tinyint(4) DEFAULT '1' COMMENT '有效标志',
  `note` varchar(500) DEFAULT '' COMMENT '团号说明',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '新增用户',
  `createdTime` datetime DEFAULT NULL COMMENT '新增时间',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '更新用户',
  `modifiedTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_teams
-- ----------------------------
INSERT INTO `product_teams` VALUES ('1', '20170305三亚七日六夜游团', '1', '4', '1', '20170305三亚七日六夜游团', 'Admin', '2017-06-27 15:46:54', 'Admin', '2017-06-28 17:59:49');
INSERT INTO `product_teams` VALUES ('2', '北欧10日9夜游团', '4', '2', '1', '北欧豪华10日游', 'Wangke', '2017-06-27 15:46:56', 'Admin', '2017-06-28 18:01:15');
INSERT INTO `product_teams` VALUES ('3', '杭州5日游团', '2', '8', '0', '20170405杭州5日游团', 'Linda', '2017-06-27 15:47:00', 'Admin', '2017-06-29 18:24:41');
INSERT INTO `product_teams` VALUES ('5', '20170604北京一日游团', '5', '6', '1', '北京豪华一日游团', 'Admin', '2017-06-28 15:55:38', 'Admin', '2017-07-03 16:14:41');
INSERT INTO `product_teams` VALUES ('6', '20170503威海一日游团', '6', '2', '1', '20170503威海一日游团', 'Admin', '2017-06-28 16:02:07', 'Admin', '2017-06-28 17:41:14');
INSERT INTO `product_teams` VALUES ('8', '20170506韩国五日游团', '8', '3', '0', '20170506韩国五日游团', 'Admin', '2017-07-03 15:39:05', 'Admin', '2017-07-03 16:14:42');
INSERT INTO `product_teams` VALUES ('9', '20171207哈尔滨冰灯节5日团', '11', '6', '1', '20171207哈尔滨冰灯节5日豪华团', 'Admin', '2017-07-05 14:31:26', 'Admin', '2017-07-05 14:31:46');
INSERT INTO `product_teams` VALUES ('10', '20170605西安4天3夜游团', '12', '7', '1', '20170605西安4天3夜游团', 'Admin', '2017-07-05 14:39:19', 'Admin', '2017-07-05 14:39:19');

-- ----------------------------
-- Table structure for product_tour_schedual
-- ----------------------------
DROP TABLE IF EXISTS `product_tour_schedual`;
CREATE TABLE `product_tour_schedual` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日程主键id',
  `prodId` int(11) NOT NULL COMMENT '产品主键',
  `scheName` varchar(50) DEFAULT NULL COMMENT '日程名称',
  `dayNumber` int(11) DEFAULT NULL COMMENT '日程序号',
  `schedualContent` varchar(3000) DEFAULT '' COMMENT '日程内容',
  `lodgeMessage` varchar(500) DEFAULT NULL COMMENT '住宿酒店信息',
  `breakFastMessage` varchar(500) DEFAULT NULL COMMENT '早餐信息',
  `lunchMessage` varchar(500) DEFAULT NULL COMMENT '午餐信息',
  `dinnerMessage` varchar(500) DEFAULT NULL COMMENT '晚餐信息',
  `createdUser` varchar(30) DEFAULT NULL COMMENT '创建人',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedUser` varchar(30) DEFAULT NULL COMMENT '最后修改人姓名',
  `modifiedTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_tour_schedual
-- ----------------------------
INSERT INTO `product_tour_schedual` VALUES ('16', '5', '前往帕皮提—波拉波拉岛·圣瑞吉度假村', '1', '出发搭乘国际航班经东京转机飞往大溪地，我们将于清晨时分抵达大溪地首都帕皮提，因为时差的关系，还是当天的早上哦，飞机降落在迷人的FAA’A国际机场，通关后进入迎宾大厅，由专人在机场鲜花接机，充斥着悠扬的大溪地常规乐曲与热情芬芳的栀子花颈圈，正以无比的热情欢迎您。\r\n稍作片刻休息，前往波拉波拉岛-圣瑞吉度假村，入住酒店休息。', '圣瑞吉度假村 The St. Regis Bora Bora Resort【Overwater Deluxe Island view Villa】', '机上轻食', '敬请自理 ', '敬请自理    ', 'Admin', '2017-06-13 14:01:47', 'Admin', '2017-06-13 14:01:47');
INSERT INTO `product_tour_schedual` VALUES ('17', '5', '波拉波拉岛（香槟日落双体船航行', '2', '行程：度假村内享用早餐后，自由活动。 您可以免费使用酒店的非机动水上设备：桨板、皮划艇、双轨帆船。\r\n\r\n☆推荐餐厅：Jean-George水上法式餐厅\r\n让乔治礁湖水上餐厅及酒吧悬于礁湖之上，坐拥壮丽的奥特马努山及日落美景，是度假村的高级法式及亚洲菜式特色餐厅。采用米其林3星级厨师冯格里奇顿先生的独创菜单并配以选择丰富的高级酒单，为您提供浪漫优雅的绝佳美食体验。\r\n\r\n今天为您安排了一项独特的活动体验——★香槟日落双体船航行。\r\n傍晚: 搭乘一艘40英呎长的双体船，驾驶向波拉波拉蓝色舄湖的日落浪漫之行，给您留下一个美丽的回忆。', ' 圣瑞吉度假村 The St. Regis Bora Bora Resort【Overwater Deluxe Island view Villa】', '度假村内享用', '敬请自理 ', '敬请自理 ', 'Admin', '2017-06-13 14:05:42', 'Admin', '2017-06-13 14:05:42');
INSERT INTO `product_tour_schedual` VALUES ('18', '5', '圣瑞吉度假村', '3', '度假村内享用早餐后自由活动，您可以参与波拉波拉圣瑞吉酒店各项活动。\r\n波拉波拉岛获得“太平洋上的珍珠”美誉，倚坐回廊之上，沐浴星空轻饮香槟，已是奢侈的盛宴；若漫天星空还不能满足您？不妨选择一颗岛上精致培育珍珠，将美好封存在饱满的光泽里。\r\n\r\n推荐行程：☆黑珍珠水下探寻之旅。\r\n潜入水下挑选您自己的黑珍珠！这将是一次多么独特的旅程。\r\n\r\n搭乘小船来到波拉波拉珍珠养殖场，在教练的带领下潜入2米左右深的泄湖中，采集属于您自己的那一只黑蝶贝。每一只黑蝶贝内部都会有一颗经过2年漫长孕育生长的成熟大溪地黑珍珠。你可以带走这颗只属于您的黑珍珠成为永恒的留念！\r\n预订提醒：建议8周岁以下儿童不下水；不想参与潜水的客人也可让教练下水后现场采部分珍珠后供您挑选，您可以从中选取一颗带走。\r\n\r\n活动结束后您还可以享用饮品(果汁、软饮、咖啡、茶或啤酒)和新鲜水果。\r\n之后自由活动，您可以尽情享受在天堂般的美景中的自由时光。', ' 圣瑞吉度假村 The St. Regis Bora Bora Resort【Overwater Deluxe Island view Villa】', '度假村内享用', '敬请自理   ', '敬请自理   ', 'Admin', '2017-06-13 14:06:56', 'Admin', '2017-06-13 14:06:56');
INSERT INTO `product_tour_schedual` VALUES ('19', '5', '波拉波拉岛（泻湖喂鲨+与魔鬼鱼共舞）', '4', '度假村享用早餐后，今天为您特别安排了★泻湖喂鲨鱼，与魔鬼鱼共舞的活动。\r\n\r\n今日将探访美丽的泻湖，与大溪地柔美晶莹的珍珠－波拉波拉，来一场美丽的邂逅。\r\n船将停留在礁石附近美丽的潜水点，在此您将经历无比令人兴奋的体验，除了缤纷热带鱼群环绕之外，教练利用诱饵吸引黑鳍鲨鱼群聚，鲨鱼身长约4-5英尺长，个性温驯无害。您可从船上观看到教练赤手喂食鲨鱼过程，或者直接下水依照指示亲手喂食他们。\r\n\r\n喂食鲨鱼的想法也许听来有点骇人，但它却是南太平洋旅游中一个非常普遍的活动，其发源地就在波拉波拉，您肯定不会忘记这难得的经验。和柠檬鲨亲密接触乍一听起来很可怕，但是其实在大溪地，除非故意激怒，否则柠檬鲨对人类几乎没有攻击型，您可以看到教练和鲨鱼嬉戏追逐，甚至拥抱它们。如果够胆量，您也大可以化身一条美人鱼，自己下水试一试和它们互动。 如果对鲨鱼无感，那么不如尝试和成群的魔鬼鱼一起在水中共舞吧。\r\n\r\n别忘了准备好水底相机拍下这难忘的经验，与家中亲朋好友分享这美丽的惊喜！\r\n而后船将停泊在迷人且隐密的\"motu tapu\" (塔布岛)，塔布岛是位于美丽性感小岛波拉波拉珊瑚礁泻湖内的一个私人小岛。这里曾经是女王举行重大仪式的地方，在古波利尼西亚时期，没有准许是不可以上岛的。所以命名这里为Tapu（意为禁止）岛。\r\n在这个岛上， 由F.W. Murnau于1931年导演拍摄了一步纪录南太平洋的电影－ Tapu.而中国著名的影视明星佟丽娅小姐和陈思成先生也是在这里许下了终身的誓言！\r\n\r\n我们将在这里享用一个地道的★波利尼西亚午餐（美味的烤鱼和烤肉），午餐后，您可以漫步在小岛上，或在水晶般清澈的泻湖中游泳。\r\n活动结束后返回度假村。', '圣瑞吉度假村 The St. Regis Bora Bora Resort【Overwater Deluxe Island view Villa】', '度假村内享用', '玻利尼西亚午餐', '敬请自理', 'Admin', '2017-06-13 14:07:57', 'Admin', '2017-06-13 14:07:57');
INSERT INTO `product_tour_schedual` VALUES ('20', '5', '波拉波拉岛Bora Bora／帕皮提', '5', '今天离开美丽的波拉波拉岛，返回大溪地首府帕皮提。抵达帕皮提后，安排专车接您前往酒店办理入住。\r\n\r\n推荐行程：\r\n☆这里是法属波利尼西亚行政中心的岛屿，可谓真正贴近朴实大溪地人的现代生活，Vai\'ete广场那有道地的美食摊贩，让您享受一顿道地随意的晚餐并体验当地人的夜生活，或找家完美的餐厅细细品味美食与这几天完美的假期。\r\n☆漫步在旧帕皮提区，依旧有着古波利尼西亚的图象。想更了解当地历史文化，大溪地博物馆是不错的选择。您还可以在首都帕皮提体验到精彩的夜生活，酒吧、夜总会、舞蹈和演出场所玲琅满目。', ' 艾美大溪地度假村 Le Meriden Tahiti', '度假村内享用', '敬请自理', '敬请自理', 'Admin', '2017-06-13 14:08:36', 'Admin', '2017-06-13 14:08:36');
INSERT INTO `product_tour_schedual` VALUES ('21', '5', '帕皮提（浮潜赏鲸+四驱车探险+浪漫法餐）', '6', '享用过早餐后，前往码头，今天将乘船出海，去追寻座头鲸的踪迹。\r\n\r\n★赏鲸之旅。每年7-11月，座头鲸会在南太平洋海域逗留5个月用来生产和哺育小鲸鱼宝宝。当宝宝有足够的体能时，10月底开始迁徙离开。登船后，工作人员会开船接近座头鲸的行进路线，经验丰富的向导还会指示您下水浮潜和这些巨大的海洋生物近距离接触的时机。\r\n*产品经理提醒：\r\n出海观鲸需视天气情况安排，如因天气原因可能取消。动物行踪有不确定性，无法保证一定能看到鲸。\r\n\r\n下午，搭乘四驱车开始★原野探险之旅。跳上四驱车，深入抵达岛内山谷，探索大溪地野性的一面，了解该地区的动植物群和风俗文化。\r\n晚餐前往★Le Coco\'s餐厅，在浪漫的氛围中享受美食。\r\nLe Coco\'s位于大溪地岛的西海岸，殖民风格的餐厅建筑，俯瞰着泻湖，享有清凉海风和Moorea岛的美景。Le Coco\'s餐厅以法国波利尼西亚美食和葡萄酒闻名。', '艾美大溪地度假村 Le Meriden Tahiti', '度假村内享用', '敬请自理', '法式晚餐  ', 'Admin', '2017-06-13 14:09:24', 'Admin', '2017-06-13 14:09:24');
INSERT INTO `product_tour_schedual` VALUES ('22', '5', '帕皮提／东京', '7', '今天凌晨由专人送您前往帕皮提国际机场，搭乘大溪地航空早班机飞往东京，由于时差原因，航班将于次日抵达东京。', '飞机住宿', '机上轻食', '机上轻食', '机上轻食', 'Admin', '2017-06-13 14:10:12', 'Admin', '2017-06-13 14:10:12');
INSERT INTO `product_tour_schedual` VALUES ('23', '5', '东京／温暖的家', '8', '今日在东京转机回到温暖的家', '飞机住宿', '机上轻食  ', '敬请自理 ', '敬请自理', 'Admin', '2017-06-13 14:10:57', 'Admin', '2017-06-13 14:10:57');
INSERT INTO `product_tour_schedual` VALUES ('24', '6', '北京首都机场集合', '1', '您将搭乘次日凌晨阿提哈德航空公司豪华公务舱，前往阿联酋首都——阿布扎比。\r\n\r\n阿联酋的国家航空公司·阿提哈德：\r\n阿提哈德当之无愧是全球优质航空公司之一，多次荣获世界旅游奖评选的奖项，也是英国曼城足球俱乐部的赞助商。', '', '敬请自理', '敬请自理', '敬请自理', 'Admin', '2017-06-13 14:13:13', 'Admin', '2017-06-13 14:13:13');
INSERT INTO `product_tour_schedual` VALUES ('25', '6', '北京/阿布扎比-迪拜', '2', '航班：北京（首都国际机场）01:10    →    阿布扎比（阿布扎比国际机场）06:30  阿联酋阿提哈德航空 EY889 商务舱   飞行时长（9:20）\r\n航班抵达，VIP专员将在廊桥恭候，随后协助办理通过海关，提取行李。私属导游将在机场大厅迎接您的到来，并陪同前往附近五星酒店享用早餐。\r\n\r\n上午：驱车前往迪拜市区及棕榈岛游览，午餐于棕榈岛享用。\r\n下午：办理入住亚特兰蒂斯酒店，在酒店内的水上世界尽兴踏浪戏水。\r\n\r\n亚特兰蒂斯水上世界:\r\n亚特兰蒂斯酒店内拥有中东及欧洲地区排名靠前的水上王国。您可以前往水世界冒险乐园参加水上云霄飞车、激流勇进、极速滑道等多个项目；或来到失落的空间，在这座沉落海底拥有上万种海洋生物的水下王国探秘。', ' 迪拜 Atlantis The Palm Hotel & Resort Dubai 棕榈岛亚特兰蒂斯度假酒店', '酒店享用', '中式料理', '亚特兰蒂斯酒店自助    ', 'Admin', '2017-06-13 14:13:58', 'Admin', '2017-06-13 14:13:58');
INSERT INTO `product_tour_schedual` VALUES ('26', '6', '迪拜', '3', '上午：今日睡到自然醒，享用早餐办理退房后，鸿鹄逸游为您特别安排直升机俯览棕榈岛。\r\n下午：办理入住以宏伟豪华见长的新古典风格建筑——范思哲酒店，体味范思哲先生的生活态度。稍作休憩，您将驱车进入沙漠腹地开展一场激动人心的沙漠冲沙。\r\n晚上：在沙漠营地头顶浩瀚星空，享用篝火晚宴，观赏曼妙的肚皮舞表演。\r\n【提示：2017年5月27日-6月26日为斋月，斋月期间沙漠冲沙活动无肚皮舞表演，此天沙漠冲沙活动结束后导游将带您返回范思哲酒店享用晚餐。】 \r\n\r\n直升机·高空俯瞰棕榈岛：\r\n搭乘直升飞机从空中鸟瞰这座堪称奇迹的城市：棕榈岛、地标性建筑等尽收眼底。迪拜这座不断刷新记录的城市和一半海洋一半沙漠的奇景，您在高空将感受得淋漓尽致。\r\n\r\n阿拉伯式的疯狂·沙漠冲沙：\r\n迪拜沙漠拥有适合冲沙的地形，您将乘坐专属四驱车沿着沙丘从下而上冲向顶峰，然后在沙峰沙谷间滑行。这是阿联酋乃至整个阿拉伯地区很受欢迎的民间运动之一，值得体验一番。', ' 迪拜 Palazzo Versace Dubai 范思哲酒店', '酒店享用', '西式套餐', '沙漠营地烧烤晚宴', 'Admin', '2017-06-13 14:14:37', 'Admin', '2017-06-13 14:14:37');
INSERT INTO `product_tour_schedual` VALUES ('27', '6', '迪拜', '4', '上午：在酒店享用早餐，办理退房后，您将搭乘当地特色水上的士Abra横跨迪拜湾，闲逛久负盛名的香料市场和黄金市场。\r\n下午：办理入住阿联酋地标性建筑——七星帆船酒店。\r\n\r\n帆船酒店倾力打造，专属您的“后花园”：\r\n卓美拉集团从芬兰购置10000平方米人工岛，分为7片海运到迪拜，拼接打造成了帆船酒店“后花园”。整体呈扇状向阿拉伯湾延伸100米，拥有凉台小屋、日光浴躺椅、泳池、餐厅以及酒吧。\r\n【花园仅针对入住酒店客人享用，尽享私密空间】\r\n\r\n这是一场调动您所有感官的用餐体验：\r\n晚餐为您特别安排在鼎鼎有名的Al Mahara帆船海底餐厅享用六道式。Al Mahara在阿拉伯语中的意思是“贝壳”，进入餐厅仿佛走进了水族馆，坐在柔软舒服的座椅上，渐渐地您会被在你身边游动的五颜六色的鱼群所迷倒，这是高端餐厅才能做到。餐厅的食物同样美味，由获奖厨师烹饪出的特别佳肴保证让您惊艳。（如有10岁以下儿童，将更换为其他餐厅）', ' 迪拜 Burj Al Arab 七星帆船酒店', '酒店享用', '西式套餐 ', '帆船酒店海底餐厅六道式', 'Admin', '2017-06-13 14:15:31', 'Admin', '2017-06-13 14:15:31');
INSERT INTO `product_tour_schedual` VALUES ('28', '6', '迪拜', '5', '上午：今日睡到自然醒，充分体验酒店内设施和管家服务。您可以携心爱之人在私属沙滩漫步，或在这金碧辉煌的酒店内四处游逛，毕竟其本身就是一个建筑杰作。\r\n下午：办理入住位于迪拜塔内的阿玛尼酒店，室内环境尽显美学品味，空气中弥漫着时尚生活的雅意。酒店直通迪拜购物中心Dubai Mall，玩转时尚，就在此刻！\r\n晚上：在高空餐厅享用晚餐同时，一览这座城市流光溢彩的高空景致。\r\n\r\n一站式购物中心·Dubai Mall：\r\n这里拥有着1200多家商店和160家餐饮店，云集全球各大奢华品牌旗舰店同时亦有许多特色商品出售。除了应有尽有的购物和美食，这里还有室内黄金交易市场，水族箱，溜冰场，主题公园及一个拥有22个放映厅的多元影院，全面的设施满足所有客户群体。\r\n\r\n唯美食与美景不可辜负:\r\n您将在评选为迪拜浪漫地之一的At.Mosphere餐厅享用晚餐。餐厅位于世界高楼哈利法塔（迪拜塔）122层，距离地平面1030米之上的云端，从餐厅俯瞰窗外，能够看到摇曳摆动的迪拜音乐喷泉以及点点星光的神秘阿拉伯湾。', ' 迪拜Armani Hotel 阿玛尼酒店', '酒店享用 ', '敬请自理', '高空浪漫景致餐厅', 'Admin', '2017-06-13 14:16:06', 'Admin', '2017-06-13 14:16:06');
INSERT INTO `product_tour_schedual` VALUES ('29', '6', '迪拜-阿布扎比', '6', '上午：今日睡到自然醒，办理退房后驱车返回阿布扎比。\r\n下午：您将游览谢赫扎耶德清真寺。随后办理入住八星酋长皇宫酒店，在这座据称皇室钟爱，能满足您“当国王的梦想”的酒店度过惬意时光。\r\n\r\n摄影极佳拍摄地·谢赫扎耶德清真寺:\r\n这座世界第三大清真寺耗资55亿美元建成。当您走进这个希腊汉白玉砌成的建筑群，头顶是施华洛世奇水晶镀金吊灯，四周是耗费46吨黄金装饰的石柱，地面是手工波斯地毯，擦肩而过是神秘的中东黑袍妇女，无论从什么角度拍摄，均是非常具有代表性的元素，圣洁的定格画面！', ' 阿布扎比 Emirates Palace Abu Dhabi 八星皇宫酒店', '酒店享用 ', '敬请自理', '八星皇宫酒店自助', 'Admin', '2017-06-13 14:16:44', 'Admin', '2017-06-13 14:16:44');
INSERT INTO `product_tour_schedual` VALUES ('30', '7', '初抵西安', '1', '【接机】【西安城墙】【大雁塔】\r\n当您乘坐的航班抵达咸阳机场，专属导游已经在机场接机处恭候您的到来，乘坐专属车前往凯悦酒店入住湖景房，开启您的考古文化之旅。\r\n在房间稍作休息后，前往参观中国古代著名的城垣建筑，也是保存最完整的古城墙-西安城墙。您可骑行或步行游览城墙，在城墙上触摸古老的城砖，感受历史留下来的痕迹，看城下来来往往的过客，又是另一番热闹的情景。\r\n下午迎着落日的余晖参观作为现存最早、规模最大的唐代四方楼阁式砖塔-大雁塔，这是佛塔这种古印度佛寺的建筑形式随佛教传入中原地区，并融入华夏文化的典型物证。而西游记中记录的唐三藏取回真经后，就是在这里开坛讲经，宣扬佛法', '西安凯悦酒店', '敬请自理   ', '敬请自理   ', '敬请自理   ', 'Admin', '2017-07-05 15:24:17', 'Admin', '2017-07-05 15:24:17');
INSERT INTO `product_tour_schedual` VALUES ('31', '7', '西安揽胜', '2', '【大明宫】【亲手制作拓片】【模拟考古】【陕西历史博物馆】【长恨歌】\r\n早餐后，前往有着“古都明珠，华夏宝库”之誉的陕西历史博物馆，其中商周青铜器精美绝伦，汉唐金银器独步全国，唐墓壁画举世无双，一上午的时间徜徉在艺术的殿堂，饱览中华大地上下五千年的历史文化，正可谓“给我三小时，还你一万年”。\r\n午餐过后，前往唐代的皇宫-大明宫，这里是世界历史上最宏伟壮观的建筑群，但连遭战乱，历经焚毁，目前只剩遗址，参观大明宫景区，学习唐朝历史文化，同时，通过模拟考古，直接面对面的感触历史，揭开考古面纱，学习考古知识，品味考古乐趣。通过拓片体验，拓出民族文化，体验古人传道教学之独到。\r\n晚餐过后，观看大型实景歌舞剧《长恨歌》，骊山脚下，皇宫高处，梨园内华灯溢彩，罗帐流光，缓歌慢舞，仙乐飘飘，在一片歌舞升平中梦回大唐……', '西安凯悦酒店', '敬请自理    ', '敬请自理    ', '敬请自理    ', 'Admin', '2017-07-05 15:24:47', 'Admin', '2017-07-05 15:24:47');
INSERT INTO `product_tour_schedual` VALUES ('32', '7', '深度探索', '3', '【兵马俑】【兵马俑DIY制作】【小雁塔观皮影】【悦椿享温泉】\r\n早餐后，酒店享用美味早餐，随后前往骊山参观兵马俑博物馆，秦兵马俑被誉为“世界第八大奇迹”，是当代最重要的考古发现之一。而在参观兵马俑之前，学习制作兵马俑，亲手制作一个独一无二的秦俑士兵。\r\n下午来到小雁塔，环境清幽，处处都是沧桑的百年老树，在安静很秀美环境中，感受历史的悠久，膜拜古人建筑技艺的高超。小雁塔是唐朝都城长安（西安）保留至今的两处重要建筑之一，塔形秀丽，被认为是唐代精美的佛教建筑艺术遗产。\r\n这里观看皮影戏，皮影戏又名灯影子，是我国民间一种古老而奇特的戏曲艺术，在关中地区很为流行。演出时，用一块白纱布做屏幕，操作皮影者站在屏幕下，把皮影贴到屏幕上，灯光从背后打出，观众做在相对方向观看。 晚上来到临潼悦椿温泉酒店用餐，并享温泉泡汤体验。', '西安临潼悦椿温泉酒店', '敬请自理    ', '敬请自理    ', '敬请自理    ', 'Admin', '2017-07-05 15:25:14', 'Admin', '2017-07-05 15:25:14');
INSERT INTO `product_tour_schedual` VALUES ('33', '7', '依依不舍', '4', '【豪华车送机】\r\n伴着清晨第一缕阳光从自然中醒来，慢悠悠的用过丰盛的早餐后，漫步酒店中，，呼吸着清新怡人的空气，收拾行囊，踏上归途。\r\n依依不舍这座有着千年历史文化的古城，随专属豪华专车踏上前往西安咸阳双流机场的归途，带着轻松愉悦的心灵回到温馨的家。', '', '敬请自理   ', '敬请自理   ', '敬请自理   ', 'Admin', '2017-07-05 15:25:41', 'Admin', '2017-07-05 15:25:41');

-- ----------------------------
-- Table structure for resource_attachments
-- ----------------------------
DROP TABLE IF EXISTS `resource_attachments`;
CREATE TABLE `resource_attachments` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '附件主键id',
  `title` varchar(50) DEFAULT NULL COMMENT '附件标题',
  `fileName` varchar(200) DEFAULT NULL COMMENT '文件名',
  `contentType` varchar(200) DEFAULT NULL COMMENT '文件类型',
  `filePath` varchar(200) DEFAULT NULL COMMENT '文件在服务器上的路径',
  `belongId` int(11) DEFAULT NULL COMMENT '附件归属于哪个id值',
  `belongerCategory` varchar(255) DEFAULT NULL COMMENT '附件归属者的类型  供应商/渠道商/分销商/产品。。。',
  `digest` varchar(200) DEFAULT NULL COMMENT '文件的MD5摘要',
  `valid` tinyint(1) DEFAULT '1' COMMENT '附件禁用启用    0：禁用    1：启用',
  `createdUser` varchar(255) DEFAULT NULL COMMENT '创建人用户名',
  `createdTime` datetime DEFAULT NULL COMMENT '创建事件',
  `modifiedUser` varchar(255) DEFAULT NULL COMMENT '最后修改人用户名',
  `modifiedTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_attachments
-- ----------------------------
INSERT INTO `resource_attachments` VALUES ('52', '附件1', '1.png', 'image/png', '\\uploads\\2017\\06\\20\\3df36dcb-15b3-403d-bb20-2ec1d575f5b9.png', '5', 'product', 'DzqbMICxLoY+wiSuJNw+hw==', '1', 'Admin', '2017-06-20 13:58:38', 'Admin', '2017-06-29 14:18:50');
INSERT INTO `resource_attachments` VALUES ('53', '附件2', '2.png', 'image/png', '\\uploads\\2017\\06\\20\\8235736f-e1ad-443f-a55f-d9369f37c725.png', '5', 'product', 'TWcXVj7SzkIjDxpPpaRR7g==', '1', 'Admin', '2017-06-20 13:58:48', 'Admin', '2017-06-29 14:18:53');
INSERT INTO `resource_attachments` VALUES ('54', '附件3', 'day11.md', 'application/octet-stream', '\\uploads\\2017\\06\\23\\8860f329-ef32-4998-9e2e-3cfe6e3616f5.md', '5', 'product', '2DSmoEsr8h6hdwka/84ATg==', '1', 'Admin', '2017-06-23 15:35:09', 'Admin', '2017-06-29 14:18:54');
INSERT INTO `resource_attachments` VALUES ('55', '附件1', '1.png', 'image/png', '\\uploads\\2017\\06\\27\\a5973f87-7633-42da-b28c-cc15eff5247f.png', '6', 'product', 'DzqbMICxLoY+wiSuJNw+hw==', '1', 'Admin', '2017-06-27 10:45:22', 'Admin', '2017-06-27 10:45:22');
INSERT INTO `resource_attachments` VALUES ('56', '附件4', 'day11.html', 'text/html', '\\uploads\\2017\\06\\27\\ea4f40a6-5684-471a-b03d-5a2c6e105930.html', '5', 'product', 'piOPzZD+Kc9HeqH+BZdutQ==', '0', 'Admin', '2017-06-27 10:50:09', 'Admin', '2017-06-29 14:18:54');
INSERT INTO `resource_attachments` VALUES ('57', '附件2', '2.png', 'image/png', '\\uploads\\2017\\06\\27\\32886024-c7b0-4a65-af98-f8f5da51b71a.png', '6', 'product', 'TWcXVj7SzkIjDxpPpaRR7g==', '1', 'Admin', '2017-06-27 10:50:53', 'Admin', '2017-06-27 10:50:53');
INSERT INTO `resource_attachments` VALUES ('59', '附件1', 'sql.txt', 'text/plain', '\\uploads\\2017\\07\\05\\d9936e62-effd-465a-b743-b941d8773f41.txt', '7', 'product', 'hwmsS3Thv5mAVU2/UhPIbw==', '1', 'Admin', '2017-07-05 15:04:50', 'Admin', '2017-07-05 15:08:23');
INSERT INTO `resource_attachments` VALUES ('60', '附件2', 'test.sql', 'application/octet-stream', '\\uploads\\2017\\07\\05\\66907643-0e35-48c3-929a-a923f25fd78c.sql', '7', 'product', 'onIO5Qj1DPXPqkjcm3gAig==', '1', 'Admin', '2017-07-05 15:08:32', 'Admin', '2017-07-05 15:08:32');

-- ----------------------------
-- Table structure for resource_guidesinfo
-- ----------------------------
DROP TABLE IF EXISTS `resource_guidesinfo`;
CREATE TABLE `resource_guidesinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '导游主键id',
  `certificateNo` varchar(100) DEFAULT NULL COMMENT '证书编号',
  `name` varchar(50) DEFAULT NULL COMMENT '中文名',
  `engName` varchar(50) DEFAULT NULL COMMENT '英文名',
  `gender` varchar(8) DEFAULT NULL COMMENT '性别   female,   male',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `language` varchar(200) DEFAULT NULL COMMENT '语言',
  `country` varchar(50) DEFAULT NULL COMMENT '国籍',
  `contact` varchar(100) DEFAULT NULL COMMENT '联系方式',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `valid` tinyint(1) DEFAULT '1' COMMENT '启用禁用  0：禁用   1：启用',
  `createdUser` varchar(255) DEFAULT NULL COMMENT '创建人用户名',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedUser` varchar(255) DEFAULT NULL COMMENT '最后修改人用户名',
  `modifiedTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_guidesinfo
-- ----------------------------
INSERT INTO `resource_guidesinfo` VALUES ('1', 'TR0001', '张丽', 'Lily', 'female', 'zhangli@tr.cn', '中文，英文', '中国', '13623456789', '年度十佳导游', '1', 'Admin', '2017-06-14 15:09:37', 'Admin', '2017-06-14 15:09:42');
INSERT INTO `resource_guidesinfo` VALUES ('2', 'TR0002', '马力', 'Mary', 'male', 'mali@tr.cn', '中文，英文', '中国', '13909876543', '年度十佳导游', '1', 'Admin', '2017-06-14 15:10:37', 'Admin', '2017-06-14 15:10:42');

-- ----------------------------
-- Table structure for resource_pricepolicies
-- ----------------------------
DROP TABLE IF EXISTS `resource_pricepolicies`;
CREATE TABLE `resource_pricepolicies` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '政策编号',
  `policyName` varchar(255) DEFAULT NULL COMMENT '政策名称',
  `quantity` int(11) DEFAULT '-1' COMMENT '政策最大数量   -1：数量没有限制',
  `minQty` int(11) DEFAULT '1' COMMENT '最低数量  ',
  `reduce` varchar(255) DEFAULT '0.00' COMMENT '价格优惠   可以是折扣  0.8，也可以是-300',
  `note` varchar(1000) DEFAULT NULL COMMENT '政策说明',
  `beginDate` date DEFAULT NULL COMMENT '开始日期',
  `endDate` date DEFAULT NULL COMMENT '结束日期',
  `valid` tinyint(1) DEFAULT '1' COMMENT '启用禁用   1:启用   0：禁用',
  `createdUser` varchar(255) DEFAULT NULL COMMENT '创建人用户名',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedUser` varchar(255) DEFAULT NULL COMMENT '最后修改人用户名',
  `modifiedTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_pricepolicies
-- ----------------------------
INSERT INTO `resource_pricepolicies` VALUES ('1', '限量优惠', '5', '5', '-2000', '报名前5名享受此优惠政策', '2017-06-16', '2017-06-30', '1', 'Admin', '2017-06-20 10:26:04', 'Admin', '2017-06-20 10:26:09');
INSERT INTO `resource_pricepolicies` VALUES ('2', '团购优惠', '-1', '5', '0.8', '5人团购享受8折优惠', '2017-06-16', '2017-06-30', '1', 'Admin', '2017-06-20 10:30:23', 'Admin', '2017-06-20 10:30:29');
INSERT INTO `resource_pricepolicies` VALUES ('3', '限时优惠', '-1', '1', '-1000', '现在报名即可享受7折优惠', '2017-07-12', '2017-07-29', '1', 'Admin', '2017-06-20 11:26:30', 'Admin', '2017-06-20 11:26:35');

-- ----------------------------
-- Table structure for res_companies
-- ----------------------------
DROP TABLE IF EXISTS `res_companies`;
CREATE TABLE `res_companies` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `compId` varchar(50) NOT NULL COMMENT '公司编号',
  `type` int(4) DEFAULT '0' COMMENT '类别 1: 供应商／2: 分销商／3: 渠道商',
  `deptId` int(11) DEFAULT NULL COMMENT '归属管理部门',
  `indCatg` varchar(50) DEFAULT NULL COMMENT '行业分类',
  `bussClass` varchar(50) DEFAULT NULL COMMENT '业务分类',
  `name` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `shortName` varchar(50) DEFAULT NULL COMMENT '公司简称',
  `phone` varchar(50) DEFAULT NULL COMMENT '公司电话',
  `fax` varchar(50) DEFAULT NULL COMMENT '公司传真',
  `homePage` varchar(50) DEFAULT NULL COMMENT '公司主页',
  `country` varchar(50) DEFAULT NULL COMMENT '公司地址-国家',
  `province` varchar(50) DEFAULT NULL COMMENT '公司地址-直辖市／省／自治区',
  `city` varchar(50) DEFAULT NULL COMMENT '公司地址-城市／区',
  `address` varchar(50) DEFAULT NULL COMMENT '公司地址-街道',
  `postNo` varchar(50) DEFAULT NULL COMMENT '公司地址-邮政编码',
  `introduction` varchar(500) DEFAULT NULL COMMENT '公司简介',
  `acctPeriod` varchar(50) DEFAULT NULL COMMENT '结算账期',
  `regCode` varchar(50) DEFAULT NULL COMMENT '注册信息-注册号',
  `regLegalRep` varchar(50) DEFAULT NULL COMMENT '注册信息-法人代表',
  `regCapital` decimal(18,2) DEFAULT NULL COMMENT '注册信息-注册资金',
  `bankCompName` varchar(50) DEFAULT NULL COMMENT '银行信息-单位名称',
  `bankName` varchar(50) DEFAULT NULL COMMENT '银行信息-开户银行',
  `bankAccount` varchar(50) DEFAULT NULL COMMENT '银行信息-账号',
  `taxCode` varchar(50) DEFAULT NULL COMMENT '银行信息-税号（统一信用代码）',
  `regAddress` varchar(50) DEFAULT NULL COMMENT '银行信息-地址',
  `regPhone` varchar(50) DEFAULT NULL COMMENT '银行信息-电话',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `attachPTO` varchar(500) DEFAULT NULL COMMENT '附件-经营许可证',
  `attachLicence` varchar(500) DEFAULT NULL COMMENT '附件-营业执照',
  `attachTaxReg` varchar(500) DEFAULT NULL COMMENT '附件-税务登记证',
  `attachRepID` varchar(500) DEFAULT NULL COMMENT '附件-法人身份证',
  `aprvState` tinyint(4) DEFAULT '0' COMMENT '审核标志',
  `aprvTime` datetime DEFAULT NULL COMMENT '审核时间',
  `aprvName` varchar(50) DEFAULT NULL COMMENT '审核人姓名',
  `valid` int(4) NOT NULL DEFAULT '1' COMMENT '有效标志   0：无效    1：有效',
  `createdUser` varchar(20) NOT NULL COMMENT '新增用户',
  `createdTime` datetime NOT NULL COMMENT '新增时间',
  `modifiedUser` varchar(20) NOT NULL COMMENT '更新用户',
  `modifiedTime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of res_companies
-- ----------------------------
INSERT INTO `res_companies` VALUES ('2', 'DIS-山东广顺国际旅行社-2', '2', null, 'R', null, '山东广顺国际旅行社', null, '', '', 'http://www.sdgslvs.cn', '中国', '山东济南', '东城区', '东三路28号', '200000', '', '1', 'SDGNLVS100002', '赵岩', '2000000.00', '山东国内旅行社有限公司', '工商银行', '6214098765431234567', '', '', '', '', null, null, null, null, '0', null, null, '1', 'U000000002', '2017-04-06 17:40:31', 'U000000002', '2017-04-12 11:15:37');
INSERT INTO `res_companies` VALUES ('4', 'SUP-海南国内旅行社-4', '1', null, 'L', null, '海南国内旅行社', null, '18767890987', '18767890987', 'http://hngnlvs.cn', '中国', '海南', '三亚', '云南路48号', '30000', '', '0', '', '', null, '', '', '', '', '', '', '', null, null, null, null, '0', null, null, '1', 'U000000002', '2017-04-07 14:47:56', 'U000000002', '2017-05-18 14:10:11');
INSERT INTO `res_companies` VALUES ('5', 'SUP-北京能源有限公司-5', '1', null, 'D', null, '北京能源有限公司', null, '13567890987', '13567890987', 'http://www.bjny.cn', '中国', '北京', '西城区', '西二环北路28号', '10000', '', '0', '', '', null, '', '', '', '', '', '', '', null, null, null, null, '0', null, null, '1', 'U000000002', '2017-04-07 14:49:02', 'U000000002', '2017-05-18 14:10:12');
INSERT INTO `res_companies` VALUES ('7', 'DIS-北京国际旅行社-7', '2', null, 'R', null, '北京国际旅行社', null, '18678909876', '', 'http://www.bjgjlvxs.cn', '中国', '北京', '海淀区', '西四环北路', '10000', '', '0', '', '', null, '', '', '', '', '', '', '', null, null, null, null, '0', null, null, '1', 'U000000002', '2017-04-12 11:15:12', 'U000000002', '2017-04-12 11:15:12');
INSERT INTO `res_companies` VALUES ('8', 'DIS-上海国际旅行社-8', '2', null, 'R', null, '上海国际旅行社', null, '13678909876', '', 'http://shanghailvxs.cn', '中国', '上海', '浦东区', '23号', '20000', '', '0', '', '', null, '', '', '', '', '', '', '', null, null, null, null, '0', null, null, '1', 'U000000002', '2017-04-12 11:21:16', 'U000000002', '2017-04-12 11:21:16');
INSERT INTO `res_companies` VALUES ('9', 'DIS-西安青年旅行社-9', '2', null, 'R', null, '西安青年旅行社', null, '18678909876', '', 'http://xianqlv.cn', '中国', '陕西', '西安', '玉石路', '710000', '', '0', '', '', null, '', '', '', '', '', '', '', null, null, null, null, '0', null, null, '1', 'U000000002', '2017-04-12 11:23:34', 'U000000002', '2017-04-12 11:23:34');
INSERT INTO `res_companies` VALUES ('10', 'SUP-康师傅矿泉水-10', '1', null, 'D', null, '康师傅有限公司', null, '18798765432', '', 'http://kangshifu.cn', '中国', '北京', '东城区', '23号', '1000000', '', '1', '', '', null, '', '', '', '', '', '', '', null, null, null, null, '0', null, null, '1', 'U000000002', '2017-04-12 11:29:26', 'U000000002', '2017-05-18 14:10:13');
INSERT INTO `res_companies` VALUES ('11', 'SUP-北京神州帽业有限公司-11', '1', null, 'C', null, '北京神州帽业有限公司', null, '13876543212', '', 'http://shenzhou.cn', '中国', '北京', '朝阳区', '建设大街45号', '1000000', '', '0', '', '', null, '', '', '', '', '', '', '', null, null, null, null, '0', null, null, '1', 'U000000002', '2017-04-12 11:31:21', 'U000000002', '2017-05-18 14:10:14');
INSERT INTO `res_companies` VALUES ('12', 'SUP-北京顺达客运有限公司-12', '1', null, 'G', null, '北京顺达客运有限公司', null, '18654321234', '', 'http://sdkeyun.cn', '中国', '北京', '丰台区', '五棵松48号', '1000000', '', '0', '', '', null, '', '', '', '', '', '', '', null, null, null, null, '0', null, null, '1', 'U000000002', '2017-04-12 11:34:21', 'U000000002', '2017-04-12 11:34:21');
INSERT INTO `res_companies` VALUES ('13', 'CHN-携程旅游公司-13', '3', null, 'I', null, '携程旅游公司', null, '15256789876', '', 'http://www.xiecheng.com', '中国', '北京', '朝阳区', '建设东路18号', '100000', '', '0', '', '', null, '', '', '', '', '', '', '', null, null, null, null, '0', null, null, '1', 'U000000002', '2017-04-12 13:52:11', 'U000000002', '2017-04-12 13:52:11');
INSERT INTO `res_companies` VALUES ('14', 'CHN-去哪儿网有限公司-14', '3', null, 'I', null, '去哪儿网有限公司', null, '18637489876', '', 'http://www.qunaer.com', '中国', '北京', '朝阳区', '建设东路23号', '100000', '', '0', '', '', null, '', '', '', '', '', '', '', null, null, null, null, '0', null, null, '1', 'U000000002', '2017-04-12 13:54:20', 'U000000002', '2017-04-12 13:54:20');
INSERT INTO `res_companies` VALUES ('15', 'CHN-驴妈妈网有限公司-15', '3', null, 'I', null, '驴妈妈网有限公司', null, '18627389876', '', 'http://www.lvmama.com', '中国', '北京', '朝阳区', '建设东路118号', '100000', '', '0', '', '', null, '', '', '', '', '', '', '', null, null, null, null, '0', null, null, '1', 'U000000002', '2017-04-12 13:55:32', 'U000000002', '2017-04-12 13:55:32');

-- ----------------------------
-- Table structure for sys_functions
-- ----------------------------
DROP TABLE IF EXISTS `sys_functions`;
CREATE TABLE `sys_functions` (
  `id` varchar(50) NOT NULL COMMENT '功能编号',
  `name` varchar(50) DEFAULT NULL COMMENT '功能名称',
  `parentId` varchar(50) DEFAULT NULL COMMENT '父功能编号',
  `nodePath` varchar(200) DEFAULT NULL COMMENT '功能全编号',
  `level` int(11) DEFAULT '0' COMMENT '层级',
  `url` varchar(200) DEFAULT NULL COMMENT '页面Url',
  `target` varchar(50) DEFAULT NULL COMMENT '框架名称',
  `note` varchar(500) DEFAULT NULL COMMENT '功能描述',
  `sort` int(11) DEFAULT '0' COMMENT '顺序号',
  `iconName` varchar(20) DEFAULT NULL COMMENT '图标名称',
  `iconOnly` tinyint(4) NOT NULL DEFAULT '1' COMMENT '仅图标',
  `valid` tinyint(4) NOT NULL DEFAULT '1' COMMENT '有效标志',
  `createdUser` varchar(20) NOT NULL COMMENT '新增用户',
  `createdTime` datetime NOT NULL COMMENT '新增时间',
  `modifiedUser` varchar(20) NOT NULL COMMENT '更新用户',
  `modifiedTime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_functions
-- ----------------------------
INSERT INTO `sys_functions` VALUES ('0001', '信息面板', '', '0001', '1', '', '', '', '10', 'icon-home', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0002', '消息中心', '', '0002', '1', '', '', '', '20', '', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0003', '产品管理', '', '0003', '1', '', '', '', '30', '', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0004', '销售管理', '', '0004', '1', '', '', '', '40', '', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0005', '资源管理', '', '0005', '1', '', '', '', '50', '', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0006', '财务管理', '', '0006', '1', '', '', '', '60', '', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0007', '供销管理', '', '0007', '1', '', '', '', '70', '', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0008', '系统管理', '', '0008', '1', '', '', '', '80', '', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0009', '信息面板', '0001', '0001/0009', '2', 'resource/dashBoardList.do', 'sub_content_iframe', '', '10', 'icon-home', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0011', '通知管理', '0002', '0002/0011', '2', '', '', '', '20', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0012', '项目', '0003', '0003/0012', '2', '', '', '', '10', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0013', '团号', '0003', '0003/0013', '2', '', '', '', '20', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0014', '产品', '0003', '0003/0014', '2', '', '', '', '30', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0016', '政策', '0003', '0003/0016', '2', '', '', '', '50', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0020', '订单', '0004', '0004/0020', '2', '', '', '', '20', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0023', '旅游资源', '0005', '0005/0023', '2', '', '', '', '10', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0024', '导游资源', '0005', '0005/0024', '2', '', '', '', '20', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0025', '附件', '0005', '0005/0027', '2', '', '', '', '10', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0026', '供应商', '0007', '0007/0026', '2', '', '', '', '40', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0027', '成本', '0006', '0006/0027', '2', '', '', '', '10', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0032', '渠道商', '0007', '0007/0032', '2', '', '', '', '10', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0035', '分销商', '0007', '0007/0035', '2', '', '', '', '40', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0036', '用户权限', '0008', '0008/0036', '2', '', '', '', '10', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0037', '系统配置', '0008', '0008/0037', '2', '', '', '', '20', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0038', '日志管理', '0008', '0008/0038', '2', '', '', '', '30', 'icon-desktop', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0040', '发布通知', '0011', '0002/0011/0040', '3', 'notice/publish.do', 'sub_content_iframe', '', '10', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0041', '通知管理', '0011', '0002/0011/0041', '3', 'notice/list.do', 'sub_content_iframe', '', '20', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0042', '项目信息管理', '0012', '0003/0012/0042', '3', 'project/manageUI.do', 'sub_content_iframe', '', '10', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0043', '团号管理', '0013', '0003/0013/0043', '3', 'team/list.do', 'sub_content_iframe', '', '20', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0045', '创建产品', '0014', '0003/0014/0045', '3', 'product/add.do', 'sub_content_iframe', '', '10', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0046', '产品列表', '0014', '0003/0014/0046', '3', 'product/list.do', 'sub_content_iframe', '', '20', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0048', '产品分类', '0014', '0003/0014/0048', '3', 'product/categoryList.do', 'sub_content_iframe', '', '40', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0052', '价格政策', '0016', '0003/0016/0052', '3', 'pricePolice/list.do', 'sub_content_iframe', '', '10', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0053', '分销商管理', '0035', '0007/0035/0053', '3', 'distributor/list.do', 'sub_content_iframe', '', '20', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0060', '订单管理', '0020', '0004/0020/0060', '3', 'XXX', 'sub_content_iframe', '', '10', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0069', '世界大洲', '0023', '0005/0023/0069', '3', 'continent/list.do', 'sub_content_iframe', '', '10', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0070', '国家地区', '0023', '0005/0023/0070', '3', 'country/list.do', 'sub_content_iframe', '', '20', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0071', '城市', '0023', '0005/0023/0071', '3', 'city/list.do', 'sub_content_iframe', '', '30', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0073', '导游信息管理', '0024', '0005/0024/0073', '3', 'guide/list.do', 'sub_content_iframe', '', '10', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0075', '附件管理', '0025', '0005/0025/0075', '3', 'XXX', 'sub_content_iframe', '', '10', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0077', '供应商管理', '0026', '0007/0026/0077', '3', 'supplier/list.do', 'sub_content_iframe', '', '10', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0079', '成本审核', '0027', '0006/0027/0079', '3', 'XXX', 'sub_content_iframe', '', '20', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0090', '渠道信息管理', '0032', '0007/0032/0090', '3', 'channel/list.do', 'sub_content_iframe', '', '10', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0091', '渠道商管理', '0032', '0007/0032/0091', '3', 'channel/channelerList.do', 'sub_content_iframe', '', '10', 'icon-angle-right', '0', '1', 'admin', '2017-07-04 16:32:42', 'admin', '2017-07-04 16:32:35');
INSERT INTO `sys_functions` VALUES ('0101', '用户管理', '0036', '0008/0036/0101', '3', 'systemUser/list.do', 'sub_content_iframe', '', '10', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0102', '组织机构管理', '0036', '0008/0036/0102', '3', 'org/manageUI.do', 'sub_content_iframe', '', '60', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0103', '权限管理', '0036', '0008/0036/0103', '3', 'authority/list.do', 'sub_content_iframe', '', '20', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0104', '系统参数', '0037', '0008/0037/0104', '3', 'systemParameter/list.do', 'sub_content_iframe', '', '30', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0105', '操作日志', '0038', '0008/0038/0105', '3', 'systemUserLog/list.do', 'sub_content_iframe', '', '50', 'icon-angle-right', '0', '1', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
INSERT INTO `sys_functions` VALUES ('0106', '系统日志', '0038', '0008/0038/0106', '3', 'XXXX', 'sub_content_iframe', '', '20', 'icon-angle-right', '0', '0', 'admin', '2017-01-12 19:21:43', 'admin', '2017-01-12 19:21:50');
