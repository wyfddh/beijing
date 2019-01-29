package com.tj720.admin.model;

public class ESColumnModel {

	public ESColumnModel() {}
	/**
	 * id等特不需要分词检索的字段
	 * @param name
	 */
	public ESColumnModel(String name) {
		this.name = name;
	}
	/**
	 * 文档类需要分词检索的字段
	 * @param name
	 * @param type{string:会进行分词建议大文本使用，long：不分词,integer：不分词,date：不分词，注意json文件会将日期转换}
	 */
	public ESColumnModel(String name,String type) {
		this.name = name;
		this.type = type;
	}

	/**字段名*/
	private String name;
	
	/**
	 * 类型：String Long Date
	 * string:进行ik分词操作(text。。。等大文本字段)
	 * long:不进行分词
	 * integer:不进行分词(id...等字段)
	 * date:进行format(时间格式)
	 * 简介操作：如果是名字类需要检索的字段加string即可
	 */
	private String type;
	
	/**
	 * 选用分词器默认ik
	 */
	private String analyzer = "ik";
	
	/**
	 * 评分倍数
	 */
	private Integer boost = 1;
	/**字段名*/
	public String getName() {
		return name;
	}
	/**字段名*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 类型：String Long Date
	 * string:进行ik分词操作(text。。。等大文本字段)
	 * long:不进行分词
	 * integer:不进行分词(id...等字段)
	 * date:进行format(时间格式)
	 * 简介操作：如果是名字类需要检索的字段加string即可
	 */
	public String getType() {
		return type;
	}
	/**
	 * 类型：String Long Date
	 * string:进行ik分词操作(text。。。等大文本字段)
	 * long:不进行分词
	 * integer:不进行分词(id...等字段)
	 * date:进行format(时间格式)
	 * 简介操作：如果是名字类需要检索的字段加string即可
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 评分倍数
	 */
	public Integer getBoost() {
		return boost;
	}
	/**
	 * 评分倍数
	 */
	public void setBoost(Integer boost) {
		this.boost = boost;
	}
	
	public String isStore() {
		return "yes";
	}

	public String getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(String analyzer) {
		this.analyzer = analyzer;
	}
	
}
