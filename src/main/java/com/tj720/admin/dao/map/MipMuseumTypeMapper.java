package com.tj720.admin.dao.map;

import com.tj720.admin.model.MipMuseumType;
import com.tj720.admin.model.MipMuseumTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MipMuseumTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int countByExample(MipMuseumTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByExample(MipMuseumTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insert(MipMuseumType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insertSelective(MipMuseumType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipMuseumType> selectByExample(MipMuseumTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    MipMuseumType selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleSelective(@Param("record") MipMuseumType record, @Param("example") MipMuseumTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExample(@Param("record") MipMuseumType record, @Param("example") MipMuseumTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeySelective(MipMuseumType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_type
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKey(MipMuseumType record);
}