package com.tj720.admin.dao.map;

import com.tj720.admin.model.CulturalRelicOtherEquipment;
import com.tj720.admin.model.CulturalRelicOtherEquipmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CulturalRelicOtherEquipmentMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cultural_relic_other_equipment
	 * @mbg.generated  Mon Dec 24 12:07:05 CST 2018
	 */
	long countByExample(CulturalRelicOtherEquipmentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cultural_relic_other_equipment
	 * @mbg.generated  Mon Dec 24 12:07:05 CST 2018
	 */
	int deleteByExample(CulturalRelicOtherEquipmentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cultural_relic_other_equipment
	 * @mbg.generated  Mon Dec 24 12:07:05 CST 2018
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cultural_relic_other_equipment
	 * @mbg.generated  Mon Dec 24 12:07:05 CST 2018
	 */
	int insert(CulturalRelicOtherEquipment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cultural_relic_other_equipment
	 * @mbg.generated  Mon Dec 24 12:07:05 CST 2018
	 */
	int insertSelective(CulturalRelicOtherEquipment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cultural_relic_other_equipment
	 * @mbg.generated  Mon Dec 24 12:07:05 CST 2018
	 */
	List<CulturalRelicOtherEquipment> selectByExample(CulturalRelicOtherEquipmentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cultural_relic_other_equipment
	 * @mbg.generated  Mon Dec 24 12:07:05 CST 2018
	 */
	CulturalRelicOtherEquipment selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cultural_relic_other_equipment
	 * @mbg.generated  Mon Dec 24 12:07:05 CST 2018
	 */
	int updateByExampleSelective(@Param("record") CulturalRelicOtherEquipment record,
			@Param("example") CulturalRelicOtherEquipmentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cultural_relic_other_equipment
	 * @mbg.generated  Mon Dec 24 12:07:05 CST 2018
	 */
	int updateByExample(@Param("record") CulturalRelicOtherEquipment record,
			@Param("example") CulturalRelicOtherEquipmentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cultural_relic_other_equipment
	 * @mbg.generated  Mon Dec 24 12:07:05 CST 2018
	 */
	int updateByPrimaryKeySelective(CulturalRelicOtherEquipment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cultural_relic_other_equipment
	 * @mbg.generated  Mon Dec 24 12:07:05 CST 2018
	 */
	int updateByPrimaryKey(CulturalRelicOtherEquipment record);

	List<CulturalRelicOtherEquipment> getByOrgId(@Param("orgId") String orgId,@Param("flag") String flag);
}