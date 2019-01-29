package com.tj720.admin.dao.map;

import com.tj720.admin.model.GmReportUpload;
import com.tj720.admin.model.GmReportUploadExample;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GmReportUploadMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    int countByExample(GmReportUploadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    int deleteByExample(GmReportUploadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    int insert(GmReportUpload record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    int insertSelective(GmReportUpload record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    List<GmReportUpload> selectByExample(GmReportUploadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    GmReportUpload selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    int updateByExampleSelective(@Param("record") GmReportUpload record, @Param("example") GmReportUploadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    int updateByExample(@Param("record") GmReportUpload record, @Param("example") GmReportUploadExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    int updateByPrimaryKeySelective(GmReportUpload record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report_upload
     *
     * @mbggenerated Wed Mar 28 12:15:25 CST 2018
     */
    int updateByPrimaryKey(GmReportUpload record);

	List<GmReportUpload> getByReportId(String reportId);

	void saveList(List<GmReportUpload> reportList);

	GmReportUpload getByRealyName(HashMap<String, String> map);
}