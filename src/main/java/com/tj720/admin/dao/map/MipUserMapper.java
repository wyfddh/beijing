package com.tj720.admin.dao.map;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.dto.MipUserDto;
import com.tj720.admin.model.Curation;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.model.MipUserExample;
import com.tj720.mip.model.UserRole;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MipUserMapper extends BaseDao<MipUser>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_user
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int countByExample(MipUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_user
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByExample(MipUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_user
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_user
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insert(MipUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_user
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insertSelective(MipUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_user
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipUser> selectByExampleWithBLOBs(MipUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_user
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipUser> selectByExample(MipUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_user
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    MipUser selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_user
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleSelective(@Param("record") MipUser record, @Param("example") MipUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_user
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") MipUser record, @Param("example") MipUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_user
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExample(@Param("record") MipUser record, @Param("example") MipUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_user
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeySelective(MipUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_user
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(MipUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_user
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKey(MipUser record);

	Integer countByMipUserDto(MipUserDto mipUserDto);

	List<MipUserDto> getListByMap(Map<String, Object> map);

	List<MipUserDto> getRoleName(List<UserRole> roleList);

	Integer getUserByOrg(String orgId);

	void deletById(String id);

	void updataStatus(Map<String, Object> map);

	Integer checkPhone(String phone);
}