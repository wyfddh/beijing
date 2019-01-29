ALTER TABLE `cultural_relic_personnel_detail`
MODIFY COLUMN `spare_data1`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用工形式' AFTER `delete_mark`,
MODIFY COLUMN `spare_data2`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '是否为单位申请资质时的修复技术人员' AFTER `spare_data1`;


INSERT INTO sys_data_dictionary_t (`id`, `name`, `pid`, `pname`, `keystr`, `valuestr`, `sortnum`, `remark`, `status`, `create_time`, `creator_id`, `update_time`, `update_id`) VALUES ('3','BusinessSettings.HaveOrNot.3', '21', 'BusinessSettings.HaveOrNot', 'on', '有', '3', '', '1', '2018-09-20 17:30:58', 'admin', '2018-09-20 17:30:58', 'admin');