package com.tj720.admin.dao.map;

import com.tj720.admin.model.MipYearCategory;
import com.tj720.admin.model.MipYearCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MipYearCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_year_category
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int countByExample(MipYearCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_year_category
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByExample(MipYearCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_year_category
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_year_category
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insert(MipYearCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_year_category
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insertSelective(MipYearCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_year_category
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipYearCategory> selectByExample(MipYearCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_year_category
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    MipYearCategory selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_year_category
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleSelective(@Param("record") MipYearCategory record, @Param("example") MipYearCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_year_category
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExample(@Param("record") MipYearCategory record, @Param("example") MipYearCategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_year_category
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeySelective(MipYearCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_year_category
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKey(MipYearCategory record);
}