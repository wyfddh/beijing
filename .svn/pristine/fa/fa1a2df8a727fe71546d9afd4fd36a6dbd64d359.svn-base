package com.design.core.config;

import org.springframework.jdbc.core.JdbcTemplate;

import com.design.entity.CgformDefineEntity;


/**
 * 表的操作
 * @author jueyue
 *
 */
public interface DbTableServiceI {
	
	/**
	 * 创建表
	 * @param tableProperty
	 * @return SQL
	 */
	String createTableSQL(CgformDefineEntity tableProperty);
	
	/**
	 * 删除表
	 * @param tableProperty
	 * @return SQL
	 */
	String dropTableSQL(String tableName);
	/**
	 * 判断表格是否存在
	 * @param tableName
	 * @return SQL
	 */
	String createIsExitSql(String tableName);
	/**
	 * 更新表
	 * @param cgFormHead
	 * @param jdbcTemplate 
	 * @return SQL
	 */
	String updateTableSQL(CgformDefineEntity cgFormHead, JdbcTemplate jdbcTemplate);

}
