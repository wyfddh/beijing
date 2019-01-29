package com.tj720.admin.dto;

import com.tj720.mip.vo.BaseVO;

/**
 * 安全保障Entity
 * @author chenshiya
 * @version 2018-05-18
 */
public class MuseumSafeEnsureDto extends BaseVO {

	  private String museumId;
	  private String riskProvision;//是否符合文物系统博物馆风险等级和安全防护级别的规定（GA27-2012）
	  private String conformanceNorm;//是否符合《文物系统博物馆安全防范工程设计规范》（GB/T 16571-2012）要求(1:是；0否)
	  private String safeSystem;//是否建立了安全保卫制度（1：是，0：否）
	  private String safeRecord;// 是否有定期安全保卫巡查记录（1：是；0：否）
	  private String safePlan;//是否建立了安全防范应急预案(1:是；0：否)',
	  private String safeInstallation; //是否配备了安防设施(1：是；0：否)
	  private String guardAgainstTheft;//防盗
	  private String lightProtection;// 防雷'
	  private String shockproof;// 防震
	  private String waterproof;//防水
	  private String fireDevice;// 是否配备了消防设施(1:是0：否)
	  private String fireSystem;//'是否建立了消防管理制度(1:是0：否)
	  private String fireCheckRecord;//是否有定期消防检查记录(1:是0：否)
	  private String tourSafety;//是否建立了参观游览安全管理办法(1:是0：否)
	  private String evacuationMap;//进出口处是否设置了安全疏散路线图(1:是0：否)
	  private String emergencyEquipment;//是否有应急设施设备(1:是0：否)
	  private String publicSafePlan;//是否建立了公共安全应急预案(1:是0：否)
	public String getMuseumId() {
		return museumId;
	}
	public void setMuseumId(String museumId) {
		this.museumId = museumId;
	}
	
	
	public String getRiskProvision() {
		return riskProvision;
	}
	public void setRiskProvision(String riskProvision) {
		this.riskProvision = riskProvision;
	}
	public String getConformanceNorm() {
		return conformanceNorm;
	}
	public void setConformanceNorm(String conformanceNorm) {
		this.conformanceNorm = conformanceNorm;
	}
	public String getSafeSystem() {
		return safeSystem;
	}
	public void setSafeSystem(String safeSystem) {
		this.safeSystem = safeSystem;
	}
	public String getSafeRecord() {
		return safeRecord;
	}
	public void setSafeRecord(String safeRecord) {
		this.safeRecord = safeRecord;
	}
	public String getSafePlan() {
		return safePlan;
	}
	public void setSafePlan(String safePlan) {
		this.safePlan = safePlan;
	}
	public String getSafeInstallation() {
		return safeInstallation;
	}
	public void setSafeInstallation(String safeInstallation) {
		this.safeInstallation = safeInstallation;
	}
	public String getGuardAgainstTheft() {
		return guardAgainstTheft;
	}
	public void setGuardAgainstTheft(String guardAgainstTheft) {
		this.guardAgainstTheft = guardAgainstTheft;
	}
	public String getLightProtection() {
		return lightProtection;
	}
	public void setLightProtection(String lightProtection) {
		this.lightProtection = lightProtection;
	}
	public String getShockproof() {
		return shockproof;
	}
	public void setShockproof(String shockproof) {
		this.shockproof = shockproof;
	}
	public String getWaterproof() {
		return waterproof;
	}
	public void setWaterproof(String waterproof) {
		this.waterproof = waterproof;
	}
	public String getFireDevice() {
		return fireDevice;
	}
	public void setFireDevice(String fireDevice) {
		this.fireDevice = fireDevice;
	}
	public String getFireSystem() {
		return fireSystem;
	}
	public void setFireSystem(String fireSystem) {
		this.fireSystem = fireSystem;
	}
	public String getFireCheckRecord() {
		return fireCheckRecord;
	}
	public void setFireCheckRecord(String fireCheckRecord) {
		this.fireCheckRecord = fireCheckRecord;
	}
	public String getTourSafety() {
		return tourSafety;
	}
	public void setTourSafety(String tourSafety) {
		this.tourSafety = tourSafety;
	}
	public String getEvacuationMap() {
		return evacuationMap;
	}
	public void setEvacuationMap(String evacuationMap) {
		this.evacuationMap = evacuationMap;
	}
	public String getEmergencyEquipment() {
		return emergencyEquipment;
	}
	public void setEmergencyEquipment(String emergencyEquipment) {
		this.emergencyEquipment = emergencyEquipment;
	}
	public String getPublicSafePlan() {
		return publicSafePlan;
	}
	public void setPublicSafePlan(String publicSafePlan) {
		this.publicSafePlan = publicSafePlan;
	}
	  
}