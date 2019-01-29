package com.tj720.admin.dto;

import com.tj720.mip.vo.BaseVO;

/**
 * 信息智能化建设Entity
 * @author chenshiya
 * @version 2018-05-18
 */
public class MuseumDigitizationDto extends BaseVO {

	  private String museumId;
	  private String accessNet;//'是否可接入互联网(1:shi 0:fou )',
	  private String localNet;//'馆内局域网设施(1有0无)',
	  private String netAddress;// '公共网址(1是0否)',
	  private String wifiCover;//'馆内 WiFi覆盖(1是0否)',
	  private String managementSys; //'藏品智能管理系统(1:有；0：无)',
	  private String collectionSystem;//'藏品管理信息化系统(1:有0：无)',
	  private String digitalManagement;// '文物数字化资源管理(1:有0：无)',
	  private String collectionSoftware;// '藏品管理软件(1:有0：无)',
	  private String thematicLibrary;//'专题数据库(1:有0：无)',
	  private String infornationCollection;// '文物多维度媒体信息采集与加工(1:有0：无)',
	  private String threeD;//'3d(1:是0：否)',
	  private String overView;//'全景（1：有0：无）',
	  private String video;//音视频
	  private String knowledgeAnime;//'知识动漫(1：有；0无)',
	  private String game;//'益智游戏(1:有，0：无)',
	  private String ar;//'AR(增强现实)',
	  private String vr;//'VR（虚拟现实）',
	  private String virtualDisplay;// '数字化（虚拟）展览展示(1:有0：无)',
	  private String displayWall;/// '互动展示墙(1:有0：无)',
	  private String touchScreen;// '高端触摸屏(1：有0：无)',
	  private String shadow;//'投影（1：有0：无）',
	  private String autoAlarm;// '自动报警系统（1：有0：无）',
	  private String autoOutfire;// '自动灭火系统(1:有0：无)',
	  private String warehouseMonitor;// '文物库房安全监控系统',
	  private String  zhanchenMonitor;// '文库展陈安全监控(1:有0：无)',
	  private String yunshuMonitor;//'文物运输安全监控(1:有0：无)',
	  private String digitalOffice;//'是否有数字化办公系统(1:有0：无)',
	  
	public String getMuseumId() {
		return museumId;
	}
	public void setMuseumId(String museumId) {
		this.museumId = museumId;
	}
	public String getAccessNet() {
		return accessNet;
	}
	public void setAccessNet(String accessNet) {
		this.accessNet = accessNet;
	}
	public String getLocalNet() {
		return localNet;
	}
	public void setLocalNet(String localNet) {
		this.localNet = localNet;
	}
	public String getNetAddress() {
		return netAddress;
	}
	public void setNetAddress(String netAddress) {
		this.netAddress = netAddress;
	}
	public String getWifiCover() {
		return wifiCover;
	}
	public void setWifiCover(String wifiCover) {
		this.wifiCover = wifiCover;
	}
	public String getManagementSys() {
		return managementSys;
	}
	public void setManagementSys(String managementSys) {
		this.managementSys = managementSys;
	}
	public String getCollectionSystem() {
		return collectionSystem;
	}
	public void setCollectionSystem(String collectionSystem) {
		this.collectionSystem = collectionSystem;
	}
	public String getDigitalManagement() {
		return digitalManagement;
	}
	public void setDigitalManagement(String digitalManagement) {
		this.digitalManagement = digitalManagement;
	}
	public String getCollectionSoftware() {
		return collectionSoftware;
	}
	public void setCollectionSoftware(String collectionSoftware) {
		this.collectionSoftware = collectionSoftware;
	}
	public String getThematicLibrary() {
		return thematicLibrary;
	}
	public void setThematicLibrary(String thematicLibrary) {
		this.thematicLibrary = thematicLibrary;
	}
	public String getInfornationCollection() {
		return infornationCollection;
	}
	public void setInfornationCollection(String infornationCollection) {
		this.infornationCollection = infornationCollection;
	}
	public String getThreeD() {
		return threeD;
	}
	public void setThreeD(String threeD) {
		this.threeD = threeD;
	}
	public String getOverView() {
		return overView;
	}
	public void setOverView(String overView) {
		this.overView = overView;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getKnowledgeAnime() {
		return knowledgeAnime;
	}
	public void setKnowledgeAnime(String knowledgeAnime) {
		this.knowledgeAnime = knowledgeAnime;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public String getAr() {
		return ar;
	}
	public void setAr(String ar) {
		this.ar = ar;
	}
	public String getVr() {
		return vr;
	}
	public void setVr(String vr) {
		this.vr = vr;
	}
	public String getVirtualDisplay() {
		return virtualDisplay;
	}
	public void setVirtualDisplay(String virtualDisplay) {
		this.virtualDisplay = virtualDisplay;
	}
	public String getDisplayWall() {
		return displayWall;
	}
	public void setDisplayWall(String displayWall) {
		this.displayWall = displayWall;
	}
	public String getTouchScreen() {
		return touchScreen;
	}
	public void setTouchScreen(String touchScreen) {
		this.touchScreen = touchScreen;
	}
	public String getShadow() {
		return shadow;
	}
	public void setShadow(String shadow) {
		this.shadow = shadow;
	}
	public String getAutoAlarm() {
		return autoAlarm;
	}
	public void setAutoAlarm(String autoAlarm) {
		this.autoAlarm = autoAlarm;
	}
	public String getAutoOutfire() {
		return autoOutfire;
	}
	public void setAutoOutfire(String autoOutfire) {
		this.autoOutfire = autoOutfire;
	}
	public String getWarehouseMonitor() {
		return warehouseMonitor;
	}
	public void setWarehouseMonitor(String warehouseMonitor) {
		this.warehouseMonitor = warehouseMonitor;
	}
	public String getZhanchenMonitor() {
		return zhanchenMonitor;
	}
	public void setZhanchenMonitor(String zhanchenMonitor) {
		this.zhanchenMonitor = zhanchenMonitor;
	}
	public String getYunshuMonitor() {
		return yunshuMonitor;
	}
	public void setYunshuMonitor(String yunshuMonitor) {
		this.yunshuMonitor = yunshuMonitor;
	}
	public String getDigitalOffice() {
		return digitalOffice;
	}
	public void setDigitalOffice(String digitalOffice) {
		this.digitalOffice = digitalOffice;
	}

	  
}