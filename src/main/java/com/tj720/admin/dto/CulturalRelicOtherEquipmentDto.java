package com.tj720.admin.dto;

import com.tj720.admin.model.CulturalRelicOtherEquipment;

/**
* @author chengrongkai
* @version 创建时间：2018年12月24日 上午10:30:10
* @ClassName 类名称
* @Description 类描述
*/
public class CulturalRelicOtherEquipmentDto extends CulturalRelicOtherEquipment{
	private String orgId;
	private CulturalRelicOtherEquipment culturalRelicOtherEquipment;
	
	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}
	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * @return the culturalRelicOtherEquipment
	 */
	public CulturalRelicOtherEquipment getCulturalRelicOtherEquipment() {
		CulturalRelicOtherEquipment culturalRelicOtherEquipment = new CulturalRelicOtherEquipment();
		culturalRelicOtherEquipment.setId(super.getId());
		culturalRelicOtherEquipment.setOrgId(super.getOrgId());
		culturalRelicOtherEquipment.seteName(super.geteName());
		culturalRelicOtherEquipment.seteCount(super.geteCount());
		culturalRelicOtherEquipment.setExistEquipment(super.getExistEquipment());
		culturalRelicOtherEquipment.setPrice(super.getPrice());
		culturalRelicOtherEquipment.setPurchaseYear(super.getPurchaseYear());
		culturalRelicOtherEquipment.setScrapYear(super.getScrapYear());
		culturalRelicOtherEquipment.setSpecification(super.getSpecification());
		culturalRelicOtherEquipment.setUseFrequency(super.getUseFrequency());
		culturalRelicOtherEquipment.setDeleteMark(super.getDeleteMark());
		culturalRelicOtherEquipment.setCreater(super.getCreater());
		culturalRelicOtherEquipment.setCreateTime(super.getCreateTime());
		culturalRelicOtherEquipment.setRemark(super.getRemark());
		culturalRelicOtherEquipment.setSort(super.getSort());
		culturalRelicOtherEquipment.setSpareData1(super.getSpareData1());
		culturalRelicOtherEquipment.setSpareData2(super.getSpareData2());
		culturalRelicOtherEquipment.setSpareData3(super.getSpareData3());
		culturalRelicOtherEquipment.setUpdater(super.getUpdater());
		culturalRelicOtherEquipment.setUpdateTime(super.getUpdateTime());
		return culturalRelicOtherEquipment;
	}
	/**
	 * @param culturalRelicOtherEquipment the culturalRelicOtherEquipment to set
	 */
	public void setCulturalRelicOtherEquipment(CulturalRelicOtherEquipment culturalRelicOtherEquipment) {
		this.culturalRelicOtherEquipment = culturalRelicOtherEquipment;
	}
	
}
