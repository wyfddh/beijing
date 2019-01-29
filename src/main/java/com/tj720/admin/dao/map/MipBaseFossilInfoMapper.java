package com.tj720.admin.dao.map;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.model.MipBaseFossilInfo;
import com.tj720.admin.model.MipBaseFossilInfoExample;
import com.tj720.admin.model.MipBaseFossilInfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MipBaseFossilInfoMapper extends BaseDao<MipBaseFossilInfo>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_base_fossil_info
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int countByExample(MipBaseFossilInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_base_fossil_info
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByExample(MipBaseFossilInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_base_fossil_info
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_base_fossil_info
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insert(MipBaseFossilInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_base_fossil_info
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insertSelective(MipBaseFossilInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_base_fossil_info
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipBaseFossilInfoWithBLOBs> selectByExampleWithBLOBs(MipBaseFossilInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_base_fossil_info
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipBaseFossilInfo> selectByExample(MipBaseFossilInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_base_fossil_info
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    MipBaseFossilInfoWithBLOBs selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_base_fossil_info
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleSelective(@Param("record") MipBaseFossilInfoWithBLOBs record, @Param("example") MipBaseFossilInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_base_fossil_info
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") MipBaseFossilInfoWithBLOBs record, @Param("example") MipBaseFossilInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_base_fossil_info
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExample(@Param("record") MipBaseFossilInfo record, @Param("example") MipBaseFossilInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_base_fossil_info
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeySelective(MipBaseFossilInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_base_fossil_info
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(MipBaseFossilInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_base_fossil_info
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKey(MipBaseFossilInfo record);
}