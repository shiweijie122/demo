DROP database IF EXISTS ttmstest;
CREATE database ttmstest DEFAULT CHARACTER SET utf8;
use ttmstest;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tms_projects
-- ----------------------------
DROP TABLE IF EXISTS `tms_projects`;
CREATE TABLE `tms_projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL COMMENT '类型',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `beginDate` datetime DEFAULT NULL COMMENT '电话',
  `endDate` datetime DEFAULT NULL COMMENT '电子邮箱',
  `address` varchar(100) DEFAULT NULL COMMENT '电话',
  `valid` tinyint(1) DEFAULT '1' COMMENT '有效标志',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '新增时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '更新时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '更新用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tms_projects
-- ----------------------------
INSERT INTO `tms_projects` VALUES ('4', 'TPCN-20170701-CHN-PEK-001', '2017年澳大利亚乌鲁鲁马拉松', '2017-07-21 00:00:00', '2017-07-25 00:00:00', null, '1', '专属红土马拉松，乌鲁鲁巨岩10km排酸跑，高碳晚餐，赛后安排乌鲁鲁日落，卡塔丘塔徒步，特色原野星光秀', '2017-07-05 14:19:13', '2017-07-07 14:30:48', null, null);
INSERT INTO `tms_projects` VALUES ('5', 'TP-20170710-USA-NY-001', '2017美国纽约马拉松', '2017-08-01 00:00:00', '2017-08-08 00:00:00', null, '1', '跑步纵览纽约城市魅力，热情的观众和专业的跑步组织', '2017-07-05 14:19:14', '2017-07-06 15:52:44', null, null);
INSERT INTO `tms_projects` VALUES ('6', 'TP-20170710-DEU-BER-001', '2017德国柏林马拉松自由行', '2017-08-11 00:00:00', '2017-08-20 00:00:00', null, '1', '落地参团，往返接送机服务,赛前晚餐+赛后特色餐，全程专业摄影摄像', '2017-07-05 14:19:14', '2017-07-06 15:52:44', null, null);
INSERT INTO `tms_projects` VALUES ('7', 'TP-20170710-FIN-HEL-001', '2017 徒步北欧探梦布道石', '2017-09-10 00:00:00', '2017-09-20 00:00:00', null, '1', '勇攀布道石，全程四星酒店，浮士德，诗丽雅双游轮，畅游三峡湾，安徒生博物馆，伊埃斯科城堡', '2017-07-05 14:19:14', '2017-07-05 14:19:14', null, null);

-- ----------------------------
-- Table structure for tms_teams
-- ----------------------------
DROP TABLE IF EXISTS `tms_teams`;
CREATE TABLE `tms_teams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '团名称',
  `projectId` int(11) DEFAULT NULL COMMENT '项目id',
  `valid` tinyint(1) DEFAULT '1' COMMENT '是否有效',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tms_teams
-- ----------------------------
INSERT INTO `tms_teams` VALUES ('11', '2017美国纽约马拉松3日团', '5', '1', '2017美国纽约马拉松3日团Happy', '2017-07-06 10:34:23', '2017-07-06 10:34:23', null, null);
INSERT INTO `tms_teams` VALUES ('12', '2017美国纽约马拉松5日团', '5', '1', '2017美国纽约马拉松3日团Happy', '2017-07-06 10:34:23', '2017-07-06 10:34:23', null, null);
INSERT INTO `tms_teams` VALUES ('23', '2017美国纽约马拉松6日团', '5', '1', '2017美国纽约马拉松6日团.....', '2017-07-06 14:46:51', '2017-07-07 11:23:36', null, null);
INSERT INTO `tms_teams` VALUES ('24', '2017美国纽约马拉松7日团', '5', '1', '2017美国纽约马拉松7日团', '2017-07-06 14:53:57', '2017-07-07 11:23:36', null, null);
INSERT INTO `tms_teams` VALUES ('25', '2017 德国柏林马拉松3日游', '6', '0', '2017 德国柏林马拉松3日游。。。', '2017-07-06 16:00:37', '2017-07-06 16:43:50', null, null);
INSERT INTO `tms_teams` VALUES ('26', '2017 德国柏林马拉松4日游', '6', '0', '2017 德国柏林马拉松4日游.。。。', '2017-07-06 16:04:12', '2017-07-06 16:43:50', null, null);
