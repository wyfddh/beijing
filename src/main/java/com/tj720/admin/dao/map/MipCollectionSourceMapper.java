package com.tj720.admin.dao.map;

import com.tj720.admin.model.MipCollectionSource;
import com.tj720.admin.model.MipCollectionSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MipCollectionSourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_source
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int countByExample(MipCollectionSourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_source
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByExample(MipCollectionSourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_source
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_source
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insert(MipCollectionSource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_source
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insertSelective(MipCollectionSource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_source
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipCollectionSource> selectByExample(MipCollectionSourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_source
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    MipCollectionSource selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_source
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleSelective(@Param("record") MipCollectionSource record, @Param("example") MipCollectionSourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_source
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExample(@Param("record") MipCollectionSource record, @Param("example") MipCollectionSourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_source
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeySelective(MipCollectionSource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_source
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKey(MipCollectionSource record);
}