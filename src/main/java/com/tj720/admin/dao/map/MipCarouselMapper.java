package com.tj720.admin.dao.map;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.model.MipCarousel;
import com.tj720.admin.model.MipCarouselExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MipCarouselMapper extends BaseDao<MipCarousel>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int countByExample(MipCarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByExample(MipCarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insert(MipCarousel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insertSelective(MipCarousel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipCarousel> selectByExample(MipCarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    MipCarousel selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleSelective(@Param("record") MipCarousel record, @Param("example") MipCarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExample(@Param("record") MipCarousel record, @Param("example") MipCarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeySelective(MipCarousel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKey(MipCarousel record);
}