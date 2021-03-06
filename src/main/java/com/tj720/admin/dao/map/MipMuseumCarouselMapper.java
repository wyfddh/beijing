package com.tj720.admin.dao.map;

import com.tj720.admin.model.MipMuseumCarousel;
import com.tj720.admin.model.MipMuseumCarouselExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MipMuseumCarouselMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int countByExample(MipMuseumCarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByExample(MipMuseumCarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insert(MipMuseumCarousel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int insertSelective(MipMuseumCarousel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    List<MipMuseumCarousel> selectByExample(MipMuseumCarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    MipMuseumCarousel selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExampleSelective(@Param("record") MipMuseumCarousel record, @Param("example") MipMuseumCarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByExample(@Param("record") MipMuseumCarousel record, @Param("example") MipMuseumCarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKeySelective(MipMuseumCarousel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_museum_carousel
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    int updateByPrimaryKey(MipMuseumCarousel record);
}