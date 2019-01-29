package com.tj720.admin.dao.map;

import com.tj720.admin.model.MipCollect;
import com.tj720.admin.model.MipCollectExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MipCollectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collect
     *
     * @mbggenerated Thu Jul 26 14:11:21 CST 2018
     */
    int countByExample(MipCollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collect
     *
     * @mbggenerated Thu Jul 26 14:11:21 CST 2018
     */
    int deleteByExample(MipCollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collect
     *
     * @mbggenerated Thu Jul 26 14:11:21 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collect
     *
     * @mbggenerated Thu Jul 26 14:11:21 CST 2018
     */
    int insert(MipCollect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collect
     *
     * @mbggenerated Thu Jul 26 14:11:21 CST 2018
     */
    int insertSelective(MipCollect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collect
     *
     * @mbggenerated Thu Jul 26 14:11:21 CST 2018
     */
    List<MipCollect> selectByExample(MipCollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collect
     *
     * @mbggenerated Thu Jul 26 14:11:21 CST 2018
     */
    MipCollect selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collect
     *
     * @mbggenerated Thu Jul 26 14:11:21 CST 2018
     */
    int updateByExampleSelective(@Param("record") MipCollect record, @Param("example") MipCollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collect
     *
     * @mbggenerated Thu Jul 26 14:11:21 CST 2018
     */
    int updateByExample(@Param("record") MipCollect record, @Param("example") MipCollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collect
     *
     * @mbggenerated Thu Jul 26 14:11:21 CST 2018
     */
    int updateByPrimaryKeySelective(MipCollect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collect
     *
     * @mbggenerated Thu Jul 26 14:11:21 CST 2018
     */
    int updateByPrimaryKey(MipCollect record);

	void delCollect(Map<String, String> map);

	List<MipCollect> getCollectsByUid(Map<String, Object> map);

	MipCollect getCollect(Map<String, String> map);

	List<MipCollect> getOrgByUserID(Map<String, Object> map);

	List<MipCollect> getColByUserID(Map<String, Object> map);

	Integer getCountColByUid(Map<String, Object> map);

}