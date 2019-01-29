package com.tj720.admin.dao.map;

import com.tj720.admin.model.GovLegalType;
import com.tj720.admin.model.GovLegalTypeExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GovLegalTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal_type
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int countByExample(GovLegalTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal_type
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int deleteByExample(GovLegalTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal_type
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal_type
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int insert(GovLegalType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal_type
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int insertSelective(GovLegalType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal_type
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    List<GovLegalType> selectByExample(GovLegalTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal_type
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    GovLegalType selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal_type
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int updateByExampleSelective(@Param("record") GovLegalType record, @Param("example") GovLegalTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal_type
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int updateByExample(@Param("record") GovLegalType record, @Param("example") GovLegalTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal_type
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int updateByPrimaryKeySelective(GovLegalType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gov_legal_type
     *
     * @mbggenerated Mon Jul 02 16:00:33 CST 2018
     */
    int updateByPrimaryKey(GovLegalType record);

	List<GovLegalType> getFirstKindList();

	Integer countList(GovLegalType govLegalType);

	List<GovLegalType> getList(Map<String, Object> map);

	void delAllById(String id);

	List<GovLegalType> getSecondKindList(String firstKindId);

	List<GovLegalType> getAllKind();

	List<GovLegalType> getKindList();
}