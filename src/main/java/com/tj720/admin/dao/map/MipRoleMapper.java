package com.tj720.admin.dao.map;

import com.tj720.admin.model.MipRole;
import com.tj720.admin.model.MipRoleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MipRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_role
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int countByExample(MipRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_role
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByExample(MipRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_role
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_role
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insert(MipRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_role
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insertSelective(MipRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_role
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipRole> selectByExample(MipRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_role
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    MipRole selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_role
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleSelective(@Param("record") MipRole record, @Param("example") MipRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_role
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExample(@Param("record") MipRole record, @Param("example") MipRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_role
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeySelective(MipRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_role
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKey(MipRole record);

	List<MipRole> getList();

}