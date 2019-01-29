-- 修改表结构，增加字段
ALTER TABLE mip_open_culturalrelic_info ADD COLUMN gj_open tinyint(4) NOT NULL DEFAULT '1' COMMENT '馆际公开（1:不公开,2：已公开）';
ALTER TABLE mip_open_culturalrelic_info ADD COLUMN approval_id varchar(64) DEFAULT NULL COMMENT '审批批号';
update mip_open_culturalrelic_info  set gj_open  = is_open;

-- 修改表结构，增加字段
ALTER TABLE mip_open_fossil_info ADD COLUMN gj_open tinyint(4) NOT NULL DEFAULT '1' COMMENT '馆际公开（1:不公开,2：已公开）';
ALTER TABLE mip_open_fossil_info ADD COLUMN approval_id varchar(64) DEFAULT NULL COMMENT '审批批号';
update mip_open_fossil_info set gj_open  = is_open;

-- 创建流程表
CREATE TABLE `mip_open_culturalrelic_info_approval` (
  `id` varchar(50) NOT NULL,
  `apply_dept` varchar(50) DEFAULT NULL COMMENT '申请单位',
  `apply_collect_count` int(10) DEFAULT NULL COMMENT '申请公开藏品数',
  `apply_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '申请时间',
  `status` tinyint(4) NOT NULL COMMENT '状态(1:待审核，2：审核通过，3：审核不通过)',
  `ext1` varchar(30) DEFAULT NULL COMMENT '备用字段',
  `ext2` varchar(30) DEFAULT NULL COMMENT '备用字段',
  `ext3` varchar(30) DEFAULT NULL COMMENT '备用字段',
  `ext4` varchar(30) DEFAULT NULL COMMENT '备用字段',
  `isdelete` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `creator_id` varchar(50) NOT NULL COMMENT '创建人',
  `updater_id` varchar(50) NOT NULL COMMENT '最后修改人',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公众服务公开审批表';

-- 创建静态库
create table mip_open_culturalrelic_info_static as select * from mip_open_culturalrelic_info;
create table mip_open_fossil_info_static as select * from mip_open_fossil_info;