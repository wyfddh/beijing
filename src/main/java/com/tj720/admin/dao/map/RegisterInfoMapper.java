package com.tj720.admin.dao.map;

import com.tj720.admin.model.RegisterInfo;
import com.tj720.admin.model.RegisterInfoExample;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.utils.Page;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RegisterInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report
     *
     * @mbggenerated Fri Mar 23 15:56:38 CST 2018
     */
    int countByExample(RegisterInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report
     *
     * @mbggenerated Fri Mar 23 15:56:38 CST 2018
     */
    int deleteByExample(RegisterInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report
     *
     * @mbggenerated Fri Mar 23 15:56:38 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report
     *
     * @mbggenerated Fri Mar 23 15:56:38 CST 2018
     */
    int insert(RegisterInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report
     *
     * @mbggenerated Fri Mar 23 15:56:38 CST 2018
     */
    int insertSelective(RegisterInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report
     *
     * @mbggenerated Fri Mar 23 15:56:38 CST 2018
     */
    List<RegisterInfo> selectByExample(RegisterInfoExample example);
    

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report
     *
     * @mbggenerated Fri Mar 23 15:56:38 CST 2018
     */
    RegisterInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report
     *
     * @mbggenerated Fri Mar 23 15:56:38 CST 2018
     */
    int updateByExampleSelective(@Param("record") RegisterInfo record, @Param("example") RegisterInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report
     *
     * @mbggenerated Fri Mar 23 15:56:38 CST 2018
     */
    int updateByExample(@Param("record") RegisterInfo record, @Param("example") RegisterInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report
     *
     * @mbggenerated Fri Mar 23 15:56:38 CST 2018
     */
    int updateByPrimaryKeySelective(RegisterInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gm_report
     *
     * @mbggenerated Fri Mar 23 15:56:38 CST 2018
     */
    int updateByPrimaryKey(RegisterInfo record);

	
	int getMaxYears(String museumId);

	List<RegisterInfo> findListByMuseumId(String museumId);

	List<RegisterInfo> getByEntity(RegisterInfo registerInfo);

	List<RegisterInfo> selectAll(Integer gmYear);

	int selectAllCount(String museumId);

	List<RegisterInfo> findList1(HashMap<String, Object> map);

	List<MipOrganization> selectAllCount1(String museumId);

	Integer countList1(HashMap<String, Object> map);


	
}