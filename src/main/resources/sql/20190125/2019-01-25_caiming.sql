ALTER TABLE `mip_organization`
ADD COLUMN `hide_relation_ship`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '隶属关系（系统初始化时放进去），页面不显示' AFTER `longitude`;

