package com.tj720.admin.dao.map;

import com.tj720.admin.model.MipCollectionStorageState;
import com.tj720.admin.model.MipCollectionStorageStateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MipCollectionStorageStateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_storage_state
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int countByExample(MipCollectionStorageStateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_storage_state
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByExample(MipCollectionStorageStateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_storage_state
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_storage_state
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insert(MipCollectionStorageState record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_storage_state
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insertSelective(MipCollectionStorageState record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_storage_state
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipCollectionStorageState> selectByExample(MipCollectionStorageStateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_storage_state
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    MipCollectionStorageState selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_storage_state
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleSelective(@Param("record") MipCollectionStorageState record, @Param("example") MipCollectionStorageStateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_storage_state
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExample(@Param("record") MipCollectionStorageState record, @Param("example") MipCollectionStorageStateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_storage_state
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeySelective(MipCollectionStorageState record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_storage_state
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKey(MipCollectionStorageState record);
}