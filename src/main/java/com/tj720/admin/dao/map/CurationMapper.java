package com.tj720.admin.dao.map;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.model.Curation;
import com.tj720.admin.model.CurationExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CurationMapper extends BaseDao<Curation>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ext_curation
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int countByExample(CurationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ext_curation
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByExample(CurationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ext_curation
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ext_curation
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insert(Curation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ext_curation
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insertSelective(Curation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ext_curation
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<Curation> selectByExampleWithBLOBs(CurationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ext_curation
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<Curation> selectByExample(CurationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ext_curation
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    Curation selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ext_curation
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleSelective(@Param("record") Curation record, @Param("example") CurationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ext_curation
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") Curation record, @Param("example") CurationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ext_curation
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExample(@Param("record") Curation record, @Param("example") CurationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ext_curation
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeySelective(Curation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ext_curation
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(Curation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ext_curation
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKey(Curation record);
}