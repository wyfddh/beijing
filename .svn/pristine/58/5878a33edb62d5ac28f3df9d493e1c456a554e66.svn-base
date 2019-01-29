SET FOREIGN_KEY_CHECKS = 0;

--
-- Database: `jilin`
--

-- --------------------------------------------------------

--
-- 表的结构 `mip_open_collection_info`
--

DROP TABLE IF EXISTS `mip_open_collection_info`;
CREATE TABLE IF NOT EXISTS `mip_open_collection_info` (
  `id` varchar(50) NOT NULL DEFAULT '' COMMENT '主键id',
  `gs_No` varchar(100) NOT NULL DEFAULT '' COMMENT '普查编号',
  `name` varchar(512) NOT NULL DEFAULT '' COMMENT '名称',
  `collection_unit` varchar(100) NOT NULL DEFAULT '' COMMENT '博物馆ID',
  `collection_level` varchar(100) NOT NULL DEFAULT '' COMMENT '文物级别（1、一级，2、二级，3、三级，4、一般，5、未定级）',
  `year_type` varchar(50) NOT NULL DEFAULT '' COMMENT '年代id',
  `collections_category` varchar(100) NOT NULL DEFAULT '' COMMENT '文物类别id',
  `description` text COMMENT '藏品简介',
  `f_audio` varchar(255) NOT NULL DEFAULT '' COMMENT '音频介绍',
  `f_video` varchar(255) NOT NULL DEFAULT '' COMMENT '视频地址',
  `three_dimensional_collection` varchar(100) NOT NULL DEFAULT '' COMMENT '三维藏品',
  `picture_ids` varchar(8192) NOT NULL DEFAULT '' COMMENT '图片ids',
  `click_counts` int(11) DEFAULT '0' COMMENT '点击次数',
  `collected_counts` int(11) NOT NULL DEFAULT '0' COMMENT '收藏次数',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入时间',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `is_high_quality` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为精品（0：否；1：是）',
  `collection_type` varchar(50) NOT NULL DEFAULT '' COMMENT '藏品来源类型（0：来自文物表，1：来自化石表）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公开文物藏品表';

--
-- 表的结构 `mip_collection_category2`
--

DROP TABLE IF EXISTS `mip_collection_category2`;
CREATE TABLE IF NOT EXISTS `mip_collection_category2` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '文物类型名称',
  `short_name` varchar(10) NOT NULL DEFAULT '' COMMENT '名称缩写',
  `fc_counts` int(11) NOT NULL DEFAULT '0' COMMENT '一普数据出现次数',
  `open_counts` int(11) NOT NULL DEFAULT '0' COMMENT '公开表数据出现次数',
  `type` varchar(50) NOT NULL DEFAULT '' COMMENT '藏品类型',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='藏品分类表';

--
-- 表的结构 `mip_year_type2`
--

DROP TABLE IF EXISTS `mip_year_type2`;
CREATE TABLE IF NOT EXISTS `mip_year_type2` (
  `id` varchar(50) NOT NULL DEFAULT '' COMMENT '主键',
  `parentId` varchar(50) NOT NULL DEFAULT '' COMMENT '父Id',
  `code` varchar(50) NOT NULL DEFAULT '' COMMENT '编码',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '名称',
  `fullname` varchar(20) NOT NULL DEFAULT '' COMMENT '全称',
  `short_name` varchar(100) NOT NULL DEFAULT '' COMMENT '名称缩写',
  `fc_counts` int(11) NOT NULL DEFAULT '0' COMMENT '藏品数',
  `open_counts` int(11) NOT NULL DEFAULT '0' COMMENT '公开表',
  `path` varchar(256) NOT NULL DEFAULT '' COMMENT '节点结构字符串',
  `path_json` varchar(256) NOT NULL DEFAULT '' COMMENT 'json结构path',
  `path_name` varchar(256) NOT NULL DEFAULT '' COMMENT '年代路径名',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='年代表';

--
-- 表的结构 `mip_audio_like`
--

DROP TABLE IF EXISTS `mip_audio_like`;
CREATE TABLE IF NOT EXISTS `mip_audio_like` (
  `id` varchar(50) NOT NULL DEFAULT '' COMMENT '主键id',
  `user_id` varchar(50) NOT NULL DEFAULT '' COMMENT '点赞用户id',
  `audio_id` varchar(50) NOT NULL DEFAULT '' COMMENT '被点赞音频id',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 表的结构 `mip_collection_audio`
--

DROP TABLE IF EXISTS `mip_collection_audio`;
CREATE TABLE IF NOT EXISTS `mip_collection_audio` (
  `id` varchar(50) NOT NULL DEFAULT '' COMMENT '主键id',
  `collection_id` varchar(50) NOT NULL DEFAULT '' COMMENT '所属藏品id',
  `user_id` varchar(50) NOT NULL DEFAULT '' COMMENT '录制人',
  `is_official` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为官方上传（0：非官方，1：官方）',
  `url` varchar(100) NOT NULL DEFAULT '' COMMENT 'url地址',
  `like_counts` int(11) NOT NULL DEFAULT '0' COMMENT '点赞次数',
  `publish_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '发布时间',
  `duration` varchar(100) NOT NULL DEFAULT '' COMMENT '音频时长',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='藏品音频介绍';

--
-- 表的结构 `mip_organization2`
--

DROP TABLE IF EXISTS `mip_organization2`;
CREATE TABLE IF NOT EXISTS `mip_organization2` (
`id` int(10) unsigned NOT NULL COMMENT '自增主键',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '名称',
  `dwid` varchar(100) NOT NULL DEFAULT '' COMMENT '收藏单位编号',
  `base_name` varchar(64) NOT NULL DEFAULT '' COMMENT '名称',
  `shortname` varchar(64) NOT NULL DEFAULT '' COMMENT '地区名称',
  `org_type_id` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '组织类型id(无表)：1 政府, 2 博物馆',
  `parent_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '主管单位id',
  `level` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '层级',
  `path` varchar(64) NOT NULL DEFAULT '' COMMENT '层级路径',
  `platform_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '省平台id(无表)',
  `contact` varchar(32) NOT NULL DEFAULT '' COMMENT '联系人',
  `province_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '省id',
  `city_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '市id',
  `town_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '区县id',
  `address` varchar(128) NOT NULL DEFAULT '' COMMENT '通讯地址',
  `mobile` varchar(11) NOT NULL DEFAULT '' COMMENT '手机',
  `tel` varchar(11) NOT NULL DEFAULT '' COMMENT '电话',
  `fex` varchar(11) NOT NULL DEFAULT '' COMMENT '传真',
  `email` varchar(64) NOT NULL DEFAULT '' COMMENT '电子邮件',
  `info` varchar(255) NOT NULL DEFAULT '' COMMENT '描述',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `open` tinyint(4) NOT NULL DEFAULT '1' COMMENT '开放：0不对外开放,1对外开放',
  `collection_count` int(11) NOT NULL DEFAULT '0' COMMENT '藏品数量',
  `creator_uid` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建人用户id',
  `operator_uid` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '最后修改人用户id',
  `sequence` int(10) unsigned NOT NULL DEFAULT '50' COMMENT '排序',
  `updated_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '修改次数',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态：0待审核,1正常,127待删除,-127已删除',
  `isdelete` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `latitude` double NOT NULL DEFAULT '0' COMMENT '经度',
  `longitude` double NOT NULL DEFAULT '0' COMMENT '纬度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='组织机构表' AUTO_INCREMENT=465 ;

--
-- 表的结构 `mip_year_category`
--

DROP TABLE IF EXISTS `mip_year_category`;
CREATE TABLE IF NOT EXISTS `mip_year_category` (
  `collections_category` varchar(50) NOT NULL DEFAULT '' COMMENT '分类',
  `year_type` varchar(50) NOT NULL DEFAULT '' COMMENT '年代',
  `collection_unit` varchar(50) NOT NULL COMMENT '收藏单位id',
  `city_id` varchar(50) NOT NULL DEFAULT '' COMMENT '博物馆所属城市id',
  `counts` int(11) NOT NULL DEFAULT '0' COMMENT '藏品数目',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `year_sequence` int(11) NOT NULL DEFAULT '0' COMMENT '年代顺序'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


SET FOREIGN_KEY_CHECKS = 1;
