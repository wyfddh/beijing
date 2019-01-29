package com.tj720.admin.dto;

import java.util.List;
import com.tj720.admin.model.CulturalRelicEquipmentDetail;
import com.tj720.admin.model.CulturalRelicMainEquipment;
import com.tj720.admin.model.CulturalRelicOtherEquipment;
/**
* @author chengrongkai
* @version 创建时间：2018年8月21日 下午4:30:05
* @ClassName 类名称
* @Description 类描述
*/
public class CulturalRelicEquipmentDetailDto {
	private String isFull;
	private List<CulturalRelicMainEquipment> culturalRelicMainEquipment;
	
	private List<CulturalRelicOtherEquipment> culturalRelicOtherEquipment;
	private String orgId;
	public String getIsFull() {
		return isFull;
	}
	public void setIsFull(String isFull) {
		this.isFull = isFull;
	}
	
	/**
	 * @return the culturalRelicOtherEquipment
	 */
	public List<CulturalRelicOtherEquipment> getCulturalRelicOtherEquipment() {
		return culturalRelicOtherEquipment;
	}
	/**
	 * @param culturalRelicOtherEquipment the culturalRelicOtherEquipment to set
	 */
	public void setCulturalRelicOtherEquipment(List<CulturalRelicOtherEquipment> culturalRelicOtherEquipment) {
		this.culturalRelicOtherEquipment = culturalRelicOtherEquipment;
	}
	/**
	 * @return the culturalRelicMainEquipment
	 */
	public List<CulturalRelicMainEquipment> getCulturalRelicMainEquipment() {
		return culturalRelicMainEquipment;
	}
	/**
	 * @param culturalRelicMainEquipment the culturalRelicMainEquipment to set
	 */
	public void setCulturalRelicMainEquipment(List<CulturalRelicMainEquipment> culturalRelicMainEquipment) {
		this.culturalRelicMainEquipment = culturalRelicMainEquipment;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
}
