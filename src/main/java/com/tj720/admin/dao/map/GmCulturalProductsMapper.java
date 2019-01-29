package com.tj720.admin.dao.map;

import com.tj720.admin.model.GmCulturalProducts;
import com.tj720.admin.model.GmCulturalProductsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GmCulturalProductsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int countByExample(GmCulturalProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int deleteByExample(GmCulturalProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int insert(GmCulturalProducts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int insertSelective(GmCulturalProducts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    List<GmCulturalProducts> selectByExample(GmCulturalProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    GmCulturalProducts selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByExampleSelective(@Param("record") GmCulturalProducts record, @Param("example") GmCulturalProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByExample(@Param("record") GmCulturalProducts record, @Param("example") GmCulturalProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByPrimaryKeySelective(GmCulturalProducts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_cultural_products
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByPrimaryKey(GmCulturalProducts record);

	void deleteByReportUploadId(String id);

	void insertBatch(List<GmCulturalProducts> list);
}