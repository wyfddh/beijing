package com.tj720.admin.dao.map;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.model.MipWenchuang;
import com.tj720.admin.model.MipWenchuangExample;
import com.tj720.mip.utils.Page;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MipWenchuangMapper extends BaseDao<MipWenchuang> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_wenchuang
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int countByExample(MipWenchuangExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_wenchuang
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByExample(MipWenchuangExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_wenchuang
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_wenchuang
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insert(MipWenchuang record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_wenchuang
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insertSelective(MipWenchuang record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_wenchuang
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipWenchuang> selectByExampleWithBLOBs(MipWenchuangExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_wenchuang
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipWenchuang> selectByExample(MipWenchuangExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_wenchuang
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    MipWenchuang selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_wenchuang
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleSelective(@Param("record") MipWenchuang record, @Param("example") MipWenchuangExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_wenchuang
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") MipWenchuang record, @Param("example") MipWenchuangExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_wenchuang
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExample(@Param("record") MipWenchuang record, @Param("example") MipWenchuangExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_wenchuang
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeySelective(MipWenchuang record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_wenchuang
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(MipWenchuang record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_wenchuang
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKey(MipWenchuang record);
    
    //获取文创列表
    List<com.tj720.mip.model.MipWenchuang> selectListByKey(@Param("key") String key, @Param("publish") String publish,  @Param("categoryId") String categoryId, @Param("staPrice") String staPrice, @Param("overPrice") String overPrice, @Param("orgId") String orgId, @Param("orgList") List<String> orgList, @Param("pageSize") Integer pageSize, @Param("startRow") Integer startRow, @Param("currentOrg") String currentOrg);
    //获取文创列表分页总数
    int countListByKey(@Param("key") String key, @Param("publish") String publish,  @Param("categoryId") String categoryId, @Param("staPrice") String staPrice, @Param("overPrice") String overPrice, @Param("orgId") String orgId, @Param("orgList") List<String> orgList, @Param("currentOrg") String currentOrg);
    
    //获取相关文创列表
    List<com.tj720.mip.model.MipWenchuang> getReleList(@Param("currentId") String currentId, @Param("categoryId") String categoryId, @Param("pageSize") Integer pageSize);
    
}