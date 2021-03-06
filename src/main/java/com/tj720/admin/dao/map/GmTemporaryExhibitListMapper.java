package com.tj720.admin.dao.map;

import com.tj720.admin.model.GmTemporaryExhibitList;
import com.tj720.admin.model.GmTemporaryExhibitListExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GmTemporaryExhibitListMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_temporary_exhibit_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int countByExample(GmTemporaryExhibitListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_temporary_exhibit_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int deleteByExample(GmTemporaryExhibitListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_temporary_exhibit_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_temporary_exhibit_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int insert(GmTemporaryExhibitList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_temporary_exhibit_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int insertSelective(GmTemporaryExhibitList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_temporary_exhibit_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    List<GmTemporaryExhibitList> selectByExample(GmTemporaryExhibitListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_temporary_exhibit_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    GmTemporaryExhibitList selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_temporary_exhibit_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByExampleSelective(@Param("record") GmTemporaryExhibitList record, @Param("example") GmTemporaryExhibitListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_temporary_exhibit_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByExample(@Param("record") GmTemporaryExhibitList record, @Param("example") GmTemporaryExhibitListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_temporary_exhibit_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByPrimaryKeySelective(GmTemporaryExhibitList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_temporary_exhibit_list
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByPrimaryKey(GmTemporaryExhibitList record);

	void deleteByReportUploadId(String id);

	void insertBatch(List<GmTemporaryExhibitList> list);
}