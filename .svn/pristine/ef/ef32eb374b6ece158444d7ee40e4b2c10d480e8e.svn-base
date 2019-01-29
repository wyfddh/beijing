CREATE TABLE `cultural_safe_list` (
  `id` varchar(64) NOT NULL DEFAULT '' COMMENT '主键',
  `museum_id` varchar(100) DEFAULT NULL COMMENT '博物馆id',
  `fk_id` varchar(100) DEFAULT NULL COMMENT '附件id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(100) DEFAULT NULL COMMENT '创建人',
  `updater` varchar(100) DEFAULT NULL COMMENT '更新人',
  `delete_mark` varchar(10) DEFAULT '数据状态' COMMENT '状态标记（1：保存状态（博物馆可看） 2：提交状态（文物局可看））',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文物保管场所安全条件表';