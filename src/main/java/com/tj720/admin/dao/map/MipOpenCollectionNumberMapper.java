package com.tj720.admin.dao.map;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.model.MipOpenCollectionNumber;
import com.tj720.admin.model.MipOpenCollectionNumberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MipOpenCollectionNumberMapper extends BaseDao<MipOpenCollectionNumber>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_open_collection_number
     *
     * @mbggenerated Fri Oct 27 09:27:24 CST 2017
     */
    int countByExample(MipOpenCollectionNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_open_collection_number
     *
     * @mbggenerated Fri Oct 27 09:27:24 CST 2017
     */
    int deleteByExample(MipOpenCollectionNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_open_collection_number
     *
     * @mbggenerated Fri Oct 27 09:27:24 CST 2017
     */
    int deleteByPrimaryKey(Integer number);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_open_collection_number
     *
     * @mbggenerated Fri Oct 27 09:27:24 CST 2017
     */
    int insert(MipOpenCollectionNumber record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_open_collection_number
     *
     * @mbggenerated Fri Oct 27 09:27:24 CST 2017
     */
    int insertSelective(MipOpenCollectionNumber record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_open_collection_number
     *
     * @mbggenerated Fri Oct 27 09:27:24 CST 2017
     */
    List<MipOpenCollectionNumber> selectByExample(MipOpenCollectionNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_open_collection_number
     *
     * @mbggenerated Fri Oct 27 09:27:24 CST 2017
     */
    MipOpenCollectionNumber selectByPrimaryKey(Integer number);
    MipOpenCollectionNumber selectById(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_open_collection_number
     *
     * @mbggenerated Fri Oct 27 09:27:24 CST 2017
     */
    int updateByExampleSelective(@Param("record") MipOpenCollectionNumber record, @Param("example") MipOpenCollectionNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_open_collection_number
     *
     * @mbggenerated Fri Oct 27 09:27:24 CST 2017
     */
    int updateByExample(@Param("record") MipOpenCollectionNumber record, @Param("example") MipOpenCollectionNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_open_collection_number
     *
     * @mbggenerated Fri Oct 27 09:27:24 CST 2017
     */
    int updateByPrimaryKeySelective(MipOpenCollectionNumber record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_open_collection_number
     *
     * @mbggenerated Fri Oct 27 09:27:24 CST 2017
     */
    int updateByPrimaryKey(MipOpenCollectionNumber record);
}