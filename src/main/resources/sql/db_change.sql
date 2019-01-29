-- -------藏品年代表mip_year_type----------

--
-- 设置年代表中年代排序
--
update `mip_year_type` a,mip_year_type2 b set a.sequence = b.sequence where a.id = b.id;

--
-- 设置年代表中年代的简称short_name
--
ALTER TABLE `mip_year_type` ADD `short_name` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '简称';
update `mip_year_type` a, `mip_year_type2` b set a.short_name = b.short_name where a.id = b.id;


-- ------博物馆组织机构表mip_organization------------

--
-- 设置博物馆经纬度
--
ALTER TABLE `mip_organization` ADD `latitude` DOUBLE NOT NULL DEFAULT '0' COMMENT '经度' ;
ALTER TABLE `mip_organization` ADD `longitude` DOUBLE NOT NULL DEFAULT '0' COMMENT '纬度' ;
update `mip_organization` a, `mip_organization2` b set a.`latitude` = b.`latitude`,a.`longitude`=b.`longitude` where a.id = b.id;

--
-- 新开放博物馆添加经纬度
--
UPDATE `mip_organization` SET `latitude` = '125.410149',`longitude` = '43.844284' WHERE `mip_organization`.`id` = 351;
UPDATE `mip_organization` SET `latitude` = '125.424676',`longitude` = '43.833637' WHERE `mip_organization`.`id` = 352;
UPDATE `mip_organization` SET `latitude` = '125.3843',`longitude` = '43.864018' WHERE `mip_organization`.`id` = 354;
UPDATE `mip_organization` SET `latitude` = '126.553979',`longitude` = '43.826333' WHERE `mip_organization`.`id` = 380;
UPDATE `mip_organization` SET `latitude` = '126.068343',`longitude` = '44.992299' WHERE `mip_organization`.`id` = 438;


-- --------藏品分类表mip_collection_category

--
-- 分类名称缩写
--
ALTER TABLE `mip_collection_category` ADD `short_name` VARCHAR(10) NOT NULL DEFAULT '' COMMENT '缩写' ;
update `mip_collection_category` a,`mip_collection_category2` b set a.short_name = b.short_name where a.id = b.id;

--
-- 修改藏品分类的排序
--
update `mip_collection_category` set sequence = 1000 where `id` = '10';
update `mip_collection_category` set sequence = 2000 where `id` = '2';
update `mip_collection_category` set sequence = 3000 where `id` = '3';
update `mip_collection_category` set sequence = 4000 where `id` = '4';
update `mip_collection_category` set sequence = 5000 where `id` = '1';
update `mip_collection_category` set sequence = 6000 where `id` = '5';
update `mip_collection_category` set sequence = 7000 where `id` = '25';
update `mip_collection_category` set sequence = 8000 where `id` = '26';
update `mip_collection_category` set sequence = 9000 where `id` = '22';
update `mip_collection_category` set sequence = 11000 where `id` = '14';
update `mip_collection_category` set sequence = 12000 where `id` = '31';
update `mip_collection_category` set sequence = 13000 where `id` = '9';
update `mip_collection_category` set sequence = 14000 where `id` = '6';
update `mip_collection_category` set sequence = 15000 where `id` = '24';
update `mip_collection_category` set sequence = 16000 where `id` = '12';
update `mip_collection_category` set sequence = 17000 where `id` = '13';
update `mip_collection_category` set sequence = 18000 where `id` = '27';
update `mip_collection_category` set sequence = 19000 where `id` = '8';
update `mip_collection_category` set sequence = 20000 where `id` = '19';
update `mip_collection_category` set sequence = 21000 where `id` = '15';
update `mip_collection_category` set sequence = 22000 where `id` = '11';
update `mip_collection_category` set sequence = 23000 where `id` = '7';
update `mip_collection_category` set sequence = 24000 where `id` = '20';
update `mip_collection_category` set sequence = 25000 where `id` = '18';
update `mip_collection_category` set sequence = 26000 where `id` = '33';
update `mip_collection_category` set sequence = 27000 where `id` = '17';
update `mip_collection_category` set sequence = 27000 where `id` = '16';
update `mip_collection_category` set sequence = 27000 where `id` = '28';
update `mip_collection_category` set sequence = 28000 where `id` = '21';
update `mip_collection_category` set sequence = 29000 where `id` = '29';
update `mip_collection_category` set sequence = 30000 where `id` = '23';
update `mip_collection_category` set sequence = 31000 where `id` = '32';
update `mip_collection_category` set sequence = 32000 where `id` = '30';
update `mip_collection_category` set sequence = 50000 where `id` = '39';
update `mip_collection_category` set sequence = 34000 where `id` = '34';
UPDATE `mip_collection_category` SET `sequence` = '35000' WHERE `id` = '38';
UPDATE `mip_collection_category` SET `sequence` = '36000' WHERE `mip_collection_category`.`id` = '35';
UPDATE `mip_collection_category` SET `sequence` = '37000' WHERE `mip_collection_category`.`id` = '36';
UPDATE `mip_collection_category` SET `sequence` = '38000' WHERE `mip_collection_category`.`id` = '37';

-- -----公开藏品表mip_open_collection_info---------

--
-- 藏品公开表插入数据（文物）
--
insert into `mip_open_collection_info`(`id`,`gs_No`,`name`,`collection_unit`,`collection_level`,`year_type`,`collections_category`,`description`,`f_audio`,`f_video`,`three_dimensional_collection`,`picture_ids`,`click_counts`,`collected_counts`,`sequence`,`is_high_quality`) 
select `id`,`gs_No`,`name`,`collection_unit`,`collection_level`,`year_type`,`collections_category`,`description`,`f_audio`,`f_video`,`three_dimensional_collection`,`picture_ids`,`click_counts`,`collected_counts`,`sequence`,`is_high_quality` 
from mip_open_culturalrelic_info
where is_open = 2 and status > 0;

--
-- 化石
--
insert into `mip_open_collection_info`(`id`,`gs_No`,`name`,`collection_unit`,`collection_level`,`year_type`,`collections_category`,`description`,`f_audio`,`f_video`,`three_dimensional_collection`,`picture_ids`,`click_counts`,`collected_counts`,`sequence`,`is_high_quality`) 
select `id`,`gs_No`,`name`,`collection_unit`,`collection_level`,`year_type`,`collections_category`,`description`,`f_audio`,`f_video`,`three_dimensional_collection`,`picture_ids`,`click_counts`,`collected_counts`,`sequence`,`is_high_quality` 
from mip_open_fossil_info
where is_open = 2 and status > 0;

--
-- 将藏品表中化石子分类都变成标本化石
--
update `mip_open_collection_info` set collections_category = 34 where collections_category in (35,36,37);

--
-- 给藏品类型插入值
--
update `mip_open_collection_info` a, `mip_open_culturalrelic_info` b set a.`collection_type` = b.`collection_type` where a.id = b.id;
update `mip_open_collection_info` a, `mip_open_fossil_info` b set a.`collection_type` = b.`collection_type` where a.id = b.id;



-- -----藏品条件表mip_year_category---------

--
-- 藏品条件表插入数据
--
insert into `mip_year_category`(collections_category, year_type, collection_unit)  
SELECT distinct collections_category, year_type, collection_unit 
FROM `mip_open_collection_info` 
where `collections_category` != '' and `year_type` != '' order by collections_category, year_type;

--
-- 给city_id插入数据
--
update `mip_year_category` a, `mip_organization` b set a.city_id = b.city_id where a.collection_unit=b.id;

--
-- 添加主键UUID
--
ALTER TABLE `mip_year_category` ADD `id` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '主键id' ;
update `mip_year_category` set id = UUID();
update `mip_year_category` set id = replace(id,'-','');
ALTER TABLE `mip_year_category` ADD PRIMARY KEY(`id`);

--
-- 设置藏品条件表中年代的排序
--
update `mip_year_category` a,`mip_year_type` b set a.year_sequence = b.sequence where a.year_type = b.id;

--
-- 设置藏品条件表中分类顺序
--
update `mip_year_category` set sequence = 1000 where `collections_category` = '10';
update `mip_year_category` set sequence = 2000 where `collections_category` = '2';
update `mip_year_category` set sequence = 3000 where `collections_category` = '3';
update `mip_year_category` set sequence = 4000 where `collections_category` = '4';
update `mip_year_category` set sequence = 5000 where `collections_category` = '1';
update `mip_year_category` set sequence = 6000 where `collections_category` = '5';
update `mip_year_category` set sequence = 7000 where `collections_category` = '25';
update `mip_year_category` set sequence = 8000 where `collections_category` = '26';
update `mip_year_category` set sequence = 9000 where `collections_category` = '22';
update `mip_year_category` set sequence = 11000 where `collections_category` = '14';
update `mip_year_category` set sequence = 12000 where `collections_category` = '31';
update `mip_year_category` set sequence = 13000 where `collections_category` = '9';
update `mip_year_category` set sequence = 14000 where `collections_category` = '6';
update `mip_year_category` set sequence = 15000 where `collections_category` = '24';
update `mip_year_category` set sequence = 16000 where `collections_category` = '12';
update `mip_year_category` set sequence = 17000 where `collections_category` = '13';
update `mip_year_category` set sequence = 18000 where `collections_category` = '27';
update `mip_year_category` set sequence = 19000 where `collections_category` = '8';
update `mip_year_category` set sequence = 20000 where `collections_category` = '19';
update `mip_year_category` set sequence = 21000 where `collections_category` = '15';
update `mip_year_category` set sequence = 22000 where `collections_category` = '11';
update `mip_year_category` set sequence = 23000 where `collections_category` = '7';
update `mip_year_category` set sequence = 24000 where `collections_category` = '20';
update `mip_year_category` set sequence = 25000 where `collections_category` = '18';
update `mip_year_category` set sequence = 26000 where `collections_category` = '33';
update `mip_year_category` set sequence = 27000 where `collections_category` = '17';
update `mip_year_category` set sequence = 27000 where `collections_category` = '16';
update `mip_year_category` set sequence = 27000 where `collections_category` = '28';
update `mip_year_category` set sequence = 28000 where `collections_category` = '21';
update `mip_year_category` set sequence = 29000 where `collections_category` = '29';
update `mip_year_category` set sequence = 30000 where `collections_category` = '23';
update `mip_year_category` set sequence = 31000 where `collections_category` = '32';
update `mip_year_category` set sequence = 32000 where `collections_category` = '30';
update `mip_year_category` set sequence = 50000 where `collections_category` = '39';
update `mip_year_category` set sequence = 34000 where `collections_category` = '34';


-- --------博物馆信息表mip_museum_info--------------

--
-- 博物馆logo
--
ALTER TABLE `mip_museum_info` ADD `logo` VARCHAR(100) NOT NULL COMMENT '博物馆logo' ;


--
-- 博物馆信息皮肤
--
ALTER TABLE `mip_museum_info` ADD `thin_id` INT NOT NULL DEFAULT '0' COMMENT '皮肤编号';