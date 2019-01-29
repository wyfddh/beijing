package com.tj720.admin.dao.map;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.model.MipCollectionAudio;
import com.tj720.admin.model.MipCollectionAudioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MipCollectionAudioMapper extends BaseDao<MipCollectionAudio>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_audio
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int countByExample(MipCollectionAudioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_audio
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByExample(MipCollectionAudioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_audio
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_audio
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insert(MipCollectionAudio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_audio
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insertSelective(MipCollectionAudio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_audio
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipCollectionAudio> selectByExample(MipCollectionAudioExample example);
    List<MipCollectionAudio> selectAllExample(MipCollectionAudioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_audio
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    MipCollectionAudio selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_audio
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleSelective(@Param("record") MipCollectionAudio record, @Param("example") MipCollectionAudioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_audio
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExample(@Param("record") MipCollectionAudio record, @Param("example") MipCollectionAudioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_audio
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeySelective(MipCollectionAudio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_collection_audio
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKey(MipCollectionAudio record);
}