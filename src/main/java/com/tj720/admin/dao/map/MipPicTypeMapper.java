package com.tj720.admin.dao.map;

import com.tj720.admin.model.MipPicType;
import com.tj720.admin.model.MipPicTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MipPicTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_pic_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int countByExample(MipPicTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_pic_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByExample(MipPicTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_pic_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_pic_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insert(MipPicType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_pic_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insertSelective(MipPicType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_pic_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipPicType> selectByExample(MipPicTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_pic_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    MipPicType selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_pic_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleSelective(@Param("record") MipPicType record, @Param("example") MipPicTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_pic_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExample(@Param("record") MipPicType record, @Param("example") MipPicTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_pic_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeySelective(MipPicType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_pic_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKey(MipPicType record);
}