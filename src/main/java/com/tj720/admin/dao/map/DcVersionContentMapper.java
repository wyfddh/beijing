package com.tj720.admin.dao.map;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.model.DcVersionContent;
import com.tj720.admin.model.DcVersionContentExample;

public interface DcVersionContentMapper extends BaseDao<DcVersionContent>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_version_content
     *
     * @mbggenerated Thu Dec 07 17:38:19 CST 2017
     */
    int countByExample(DcVersionContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_version_content
     *
     * @mbggenerated Thu Dec 07 17:38:19 CST 2017
     */
    int deleteByExample(DcVersionContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_version_content
     *
     * @mbggenerated Thu Dec 07 17:38:19 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_version_content
     *
     * @mbggenerated Thu Dec 07 17:38:19 CST 2017
     */
    int insert(DcVersionContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_version_content
     *
     * @mbggenerated Thu Dec 07 17:38:19 CST 2017
     */
    int insertSelective(DcVersionContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_version_content
     *
     * @mbggenerated Thu Dec 07 17:38:19 CST 2017
     */
    List<DcVersionContent> selectByExampleWithBLOBs(DcVersionContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_version_content
     *
     * @mbggenerated Thu Dec 07 17:38:19 CST 2017
     */
    List<DcVersionContent> selectByExample(DcVersionContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_version_content
     *
     * @mbggenerated Thu Dec 07 17:38:19 CST 2017
     */
    DcVersionContent selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_version_content
     *
     * @mbggenerated Thu Dec 07 17:38:19 CST 2017
     */
    int updateByExampleSelective(@Param("record") DcVersionContent record, @Param("example") DcVersionContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_version_content
     *
     * @mbggenerated Thu Dec 07 17:38:19 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") DcVersionContent record, @Param("example") DcVersionContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_version_content
     *
     * @mbggenerated Thu Dec 07 17:38:19 CST 2017
     */
    int updateByExample(@Param("record") DcVersionContent record, @Param("example") DcVersionContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_version_content
     *
     * @mbggenerated Thu Dec 07 17:38:19 CST 2017
     */
    int updateByPrimaryKeySelective(DcVersionContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_version_content
     *
     * @mbggenerated Thu Dec 07 17:38:19 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(DcVersionContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_version_content
     *
     * @mbggenerated Thu Dec 07 17:38:19 CST 2017
     */
    int updateByPrimaryKey(DcVersionContent record);
    
    int countByAreaCount(DcVersionContentExample example);
    
    int countByOrgCount(DcVersionContentExample example);
    
    int countByOrgList(Map<String, Object> example);
    
    int countByAreaCountNew(DcVersionContentExample example);
}