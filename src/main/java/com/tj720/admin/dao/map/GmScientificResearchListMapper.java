package com.tj720.admin.dao.map;

import com.tj720.admin.model.GmScientificResearchList;
import com.tj720.admin.model.GmScientificResearchListExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GmScientificResearchListMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_scientific_research_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int countByExample(GmScientificResearchListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_scientific_research_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int deleteByExample(GmScientificResearchListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_scientific_research_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_scientific_research_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int insert(GmScientificResearchList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_scientific_research_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int insertSelective(GmScientificResearchList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_scientific_research_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    List<GmScientificResearchList> selectByExample(GmScientificResearchListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_scientific_research_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    GmScientificResearchList selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_scientific_research_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByExampleSelective(@Param("record") GmScientificResearchList record, @Param("example") GmScientificResearchListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_scientific_research_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByExample(@Param("record") GmScientificResearchList record, @Param("example") GmScientificResearchListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_scientific_research_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByPrimaryKeySelective(GmScientificResearchList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_scientific_research_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByPrimaryKey(GmScientificResearchList record);

	void deleteByReportUploadId(String id);

	void insertBatch(List<GmScientificResearchList> list);
}