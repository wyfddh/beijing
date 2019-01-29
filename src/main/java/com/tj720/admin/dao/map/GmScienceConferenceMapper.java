package com.tj720.admin.dao.map;

import com.tj720.admin.model.GmScienceConference;
import com.tj720.admin.model.GmScienceConferenceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GmScienceConferenceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_science_conference
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int countByExample(GmScienceConferenceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_science_conference
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int deleteByExample(GmScienceConferenceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_science_conference
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_science_conference
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int insert(GmScienceConference record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_science_conference
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int insertSelective(GmScienceConference record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_science_conference
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    List<GmScienceConference> selectByExample(GmScienceConferenceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_science_conference
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    GmScienceConference selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_science_conference
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByExampleSelective(@Param("record") GmScienceConference record, @Param("example") GmScienceConferenceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_science_conference
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByExample(@Param("record") GmScienceConference record, @Param("example") GmScienceConferenceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_science_conference
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByPrimaryKeySelective(GmScienceConference record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_science_conference
     *
     * @mbggenerated Wed Apr 11 14:08:20 CST 2018
     */
    int updateByPrimaryKey(GmScienceConference record);

	void deleteByReportUploadId(String id);

	void insertBatch(List<GmScienceConference> list);
}