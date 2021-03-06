package com.tj720.admin.dao.map;

import com.tj720.admin.model.GovLegal;
import com.tj720.admin.model.GovLegalExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GovLegalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int countByExample(GovLegalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int deleteByExample(GovLegalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int insert(GovLegal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int insertSelective(GovLegal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    List<GovLegal> selectByExampleWithBLOBs(GovLegalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    List<GovLegal> selectByExample(GovLegalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    GovLegal selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int updateByExampleSelective(@Param("record") GovLegal record, @Param("example") GovLegalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") GovLegal record, @Param("example") GovLegalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int updateByExample(@Param("record") GovLegal record, @Param("example") GovLegalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int updateByPrimaryKeySelective(GovLegal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(GovLegal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int updateByPrimaryKey(GovLegal record);

	List<GovLegal> getList(Map<String, Object> map);

	List<GovLegal> getPublisherList();

	Integer countList(GovLegal govLegal);

	Integer countByLegalTypeId(String id);
	
	List<GovLegal> getGovListForDesk(Map<String,String> map);
	
	GovLegal getGovByid(String id);
	
}