package com.tj720.admin.dto;

import com.tj720.mip.vo.BaseVO;

/**
 * 陈列展览与社会服务Entity
 * @author chenshiya
 * @version 2018-05-25
 */
public class MuseumPublicServiceDto extends BaseVO{

	private String museumId;//'博物馆id',
	private String tv;//广播电视(1:有0：无)',
	private String newspaper;//报刊杂志(1:you 0无)',
	private String wechat;//'微信',
	private String weibo;//'微博',
	private String applets;//'小程序',
	private String website;// '网站',
	private String app;// 'APP',
	private String other;// '其他',
	private String logo;//'是否拥有博物馆品牌标志(1:是；0否)',
	private String creativeProduct;//'是否有特色文创产品',
	private String travelRecommend;// '是否为携程等旅游网推荐点',
	private String curator;//'是否有本馆的专业策展人',
	private Integer parkNum;//'停车位数量',
	private Integer toiletNum;//'公共厕所数量',
	private String goodsDepository;// '物品寄存处(1:有0：无)',
	private String foodService;// '餐饮服务设施(1有0无)',
	private String informationDesk;// '服务台/问询处(1:有0：无)',
	private String atm;//'ATM取款机(1:有0：无)',
	private String barrierFreeStructures;// '无障碍设施(1:有0：无)',
	private String motherRoom;// '是否有母婴室',
	private String productService;//'商品服务部(1：有0：无)',
	private String restingArea;// '观众休息设施(1:有0：无)',
	private String communicationService;// '是否有wifi(1:有0：无)',
	private String spotRescue;//'现场救援服务(1：有；0：无)',
	private String tourGuide;//'参观指引系统(1:有0：无)',
	private String freeUmbrella;//'免费雨伞(1:有0：无)',
	private String guideMap;//'是否有导览图',
	private String baseIntroduce;//'是否免费提供博物馆及展览介绍等基本信息资料',
	private Integer expostorNum;//'讲解员数量',
	private String basicCondition;//讲解员基本条件(1全部具有大学以上文化程度；2全部具有大专以上文化程度；3全部具有中专以上文化程度)',
	private String explainLanguage;//'讲解语种(1汉语、英语等2种以上外语；2汉语、英语；3仅汉语)',
	private String freeExplain;// '免费讲解服务(1全部免费讲解；2定时免费讲解；3无免费讲解)',
	private String expertExplain;//'是否有专家讲解服务',
	private String audioGuide;// '自助语音导览服务(1:是0否)',
	private String touchScreen;// '触摸屏导览服务(1:有0：否)',
	private String freeOpen;// '是否免费开放',
	private Integer freeDays;//'免费开放天数',
	private Integer freeVisitors;// '免费参观人数',
	private String freeOpenFunds;//是否有免费开放专项资金,
	private Integer openDays;//'全年开放时间',
	private String openNight;//'是否提供夜场开放服务',
	private Integer volunteerNum;//'志愿者数量',
	private String volunteerTime;// '志愿者服务时间(1每名志愿者每年服务时间不低于48小时；2每名志愿者每年服务时间不低于24小时；3每名志愿者每年服务时间不低于12小时)',
	private String volunteerPost;// '志愿者服务岗位',
	private String volunteerDistribution;// '志愿者人群分部',
	private String volunteerTeam;//'是否为北京文博志愿者总队注册成员',
	private String campActivities;//'有无冬夏令营活动',
	private String courseTitle;//'有无博物馆课程',
	private String courseTitleName;//博物馆课程名称
	private String educationActivities;// '特色社教活动',
	private Integer educationNumber;// '专职社教工作人员数量',
	private String buildingSchool;//'有无共建学校',
	private String parkNumEn;//'停车位数量'-是否满足观众需要,
	private String toiletNumEn;//'公共厕所数量'-是否满足观众需要,
	private String goodsDepositoryEn;// '物品寄存处(1:有0：无)'-是否满足观众需要,
	private String foodServiceEn;// '餐饮服务设施(1有0无)'-是否满足观众需要,
	private String informationDeskEn;// '服务台/问询处(1:有0：无)'-是否满足观众需要,
	private String atmEn;//'ATM取款机(1:有0：无)'-是否满足观众需要,
	private String barrierFreeStructuresEn;// '无障碍设施(1:有0：无)'-是否满足观众需要,
	private String motherRoomEn;// '是否有母婴室'-是否满足观众需要,
	private String productServiceEn;//'商品服务部(1：有0：无)'-是否满足观众需要,
	private String restingAreaEn;// '观众休息设施(1:有0：无)'-是否满足观众需要,
	private String communicationServiceEn;// '是否有wifi(1:有0：无)'-是否满足观众需要,
	private String spotRescueEn;//'现场救援服务(1：有；0：无)'-是否满足观众需要,
	private String tourGuideEn;//'参观指引系统(1:有0：无)'-是否满足观众需要,
	private String freeUmbrellaEn;//'免费雨伞(1:有0：无)'-是否满足观众需要,
	private String guideMapEn;//'是否有导览图'-是否满足观众需要,
	private String baseIntroduceEn;//'是否免费提供博物馆及展览介绍等基本信息资料'-是否满足观众需要,
	private String expostorNumEn;//'讲解员数量'-是否满足观众需要,
	private String basicConditionEn;//讲解员基本条件(1全部具有大学以上文化程度；2全部具有大专以上文化程度；3全部具有中专以上文化程度)'-是否满足观众需要,
	private String explainLanguageEn;//'讲解语种(1汉语、英语等2种以上外语；2汉语、英语；3仅汉语)'-是否满足观众需要,
	private String freeExplainEn;// '免费讲解服务(1全部免费讲解；2定时免费讲解；3无免费讲解)'-是否满足观众需要,
	private String expertExplainEn;//'是否有专家讲解服务'-是否满足观众需要,
	private String audioGuideEn;// '自助语音导览服务(1:是0否)'-是否满足观众需要,
	private String touchScreenEn;// '触摸屏导览服务(1:有0：否)'-是否满足观众需要,
	private String freeOpenStyle;//部分免费开放方式(1:讲解员2：无)
	
	public String getMuseumId() {
		return museumId;
	}
	public void setMuseumId(String museumId) {
		this.museumId = museumId;
	}
	public String getTv() {
		return tv;
	}
	public void setTv(String tv) {
		this.tv = tv;
	}
	public String getNewspaper() {
		return newspaper;
	}
	public void setNewspaper(String newspaper) {
		this.newspaper = newspaper;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getWeibo() {
		return weibo;
	}
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
	public String getApplets() {
		return applets;
	}
	public void setApplets(String applets) {
		this.applets = applets;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getCreativeProduct() {
		return creativeProduct;
	}
	public void setCreativeProduct(String creativeProduct) {
		this.creativeProduct = creativeProduct;
	}
	public String getTravelRecommend() {
		return travelRecommend;
	}
	public void setTravelRecommend(String travelRecommend) {
		this.travelRecommend = travelRecommend;
	}
	public String getCurator() {
		return curator;
	}
	public void setCurator(String curator) {
		this.curator = curator;
	}
	public Integer getParkNum() {
		return parkNum;
	}
	public void setParkNum(Integer parkNum) {
		this.parkNum = parkNum;
	}
	public Integer getToiletNum() {
		return toiletNum;
	}
	public void setToiletNum(Integer toiletNum) {
		this.toiletNum = toiletNum;
	}
	public String getGoodsDepository() {
		return goodsDepository;
	}
	public void setGoodsDepository(String goodsDepository) {
		this.goodsDepository = goodsDepository;
	}
	public String getFoodService() {
		return foodService;
	}
	public void setFoodService(String foodService) {
		this.foodService = foodService;
	}
	public String getInformationDesk() {
		return informationDesk;
	}
	public void setInformationDesk(String informationDesk) {
		this.informationDesk = informationDesk;
	}
	public String getAtm() {
		return atm;
	}
	public void setAtm(String atm) {
		this.atm = atm;
	}
	public String getBarrierFreeStructures() {
		return barrierFreeStructures;
	}
	public void setBarrierFreeStructures(String barrierFreeStructures) {
		this.barrierFreeStructures = barrierFreeStructures;
	}
	public String getMotherRoom() {
		return motherRoom;
	}
	public void setMotherRoom(String motherRoom) {
		this.motherRoom = motherRoom;
	}
	public String getProductService() {
		return productService;
	}
	public void setProductService(String productService) {
		this.productService = productService;
	}
	public String getRestingArea() {
		return restingArea;
	}
	public void setRestingArea(String restingArea) {
		this.restingArea = restingArea;
	}
	public String getCommunicationService() {
		return communicationService;
	}
	public void setCommunicationService(String communicationService) {
		this.communicationService = communicationService;
	}
	public String getSpotRescue() {
		return spotRescue;
	}
	public void setSpotRescue(String spotRescue) {
		this.spotRescue = spotRescue;
	}
	public String getTourGuide() {
		return tourGuide;
	}
	public void setTourGuide(String tourGuide) {
		this.tourGuide = tourGuide;
	}
	public String getFreeUmbrella() {
		return freeUmbrella;
	}
	public void setFreeUmbrella(String freeUmbrella) {
		this.freeUmbrella = freeUmbrella;
	}
	public String getGuideMap() {
		return guideMap;
	}
	public void setGuideMap(String guideMap) {
		this.guideMap = guideMap;
	}
	public String getBaseIntroduce() {
		return baseIntroduce;
	}
	public void setBaseIntroduce(String baseIntroduce) {
		this.baseIntroduce = baseIntroduce;
	}
	public Integer getExpostorNum() {
		return expostorNum;
	}
	public void setExpostorNum(Integer expostorNum) {
		this.expostorNum = expostorNum;
	}
	public String getBasicCondition() {
		return basicCondition;
	}
	public void setBasicCondition(String basicCondition) {
		this.basicCondition = basicCondition;
	}
	public String getExplainLanguage() {
		return explainLanguage;
	}
	public void setExplainLanguage(String explainLanguage) {
		this.explainLanguage = explainLanguage;
	}
	public String getFreeExplain() {
		return freeExplain;
	}
	public void setFreeExplain(String freeExplain) {
		this.freeExplain = freeExplain;
	}
	public String getExpertExplain() {
		return expertExplain;
	}
	public void setExpertExplain(String expertExplain) {
		this.expertExplain = expertExplain;
	}
	public String getAudioGuide() {
		return audioGuide;
	}
	public void setAudioGuide(String audioGuide) {
		this.audioGuide = audioGuide;
	}
	public String getTouchScreen() {
		return touchScreen;
	}
	public void setTouchScreen(String touchScreen) {
		this.touchScreen = touchScreen;
	}
	public String getFreeOpen() {
		return freeOpen;
	}
	public void setFreeOpen(String freeOpen) {
		this.freeOpen = freeOpen;
	}
	public Integer getFreeDays() {
		return freeDays;
	}
	public void setFreeDays(Integer freeDays) {
		this.freeDays = freeDays;
	}
	public Integer getFreeVisitors() {
		return freeVisitors;
	}
	public void setFreeVisitors(Integer freeVisitors) {
		this.freeVisitors = freeVisitors;
	}
	public String getFreeOpenFunds() {
		return freeOpenFunds;
	}
	public void setFreeOpenFunds(String freeOpenFunds) {
		this.freeOpenFunds = freeOpenFunds;
	}
	public Integer getOpenDays() {
		return openDays;
	}
	public void setOpenDays(Integer openDays) {
		this.openDays = openDays;
	}
	public String getOpenNight() {
		return openNight;
	}
	public void setOpenNight(String openNight) {
		this.openNight = openNight;
	}
	public Integer getVolunteerNum() {
		return volunteerNum;
	}
	public void setVolunteerNum(Integer volunteerNum) {
		this.volunteerNum = volunteerNum;
	}
	public String getVolunteerTime() {
		return volunteerTime;
	}
	public void setVolunteerTime(String volunteerTime) {
		this.volunteerTime = volunteerTime;
	}
	public String getVolunteerPost() {
		return volunteerPost;
	}
	public void setVolunteerPost(String volunteerPost) {
		this.volunteerPost = volunteerPost;
	}
	public String getVolunteerDistribution() {
		return volunteerDistribution;
	}
	public void setVolunteerDistribution(String volunteerDistribution) {
		this.volunteerDistribution = volunteerDistribution;
	}
	public String getVolunteerTeam() {
		return volunteerTeam;
	}
	public void setVolunteerTeam(String volunteerTeam) {
		this.volunteerTeam = volunteerTeam;
	}
	public String getCampActivities() {
		return campActivities;
	}
	public void setCampActivities(String campActivities) {
		this.campActivities = campActivities;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getEducationActivities() {
		return educationActivities;
	}
	public void setEducationActivities(String educationActivities) {
		this.educationActivities = educationActivities;
	}
	public Integer getEducationNumber() {
		return educationNumber;
	}
	public void setEducationNumber(Integer educationNumber) {
		this.educationNumber = educationNumber;
	}
	public String getBuildingSchool() {
		return buildingSchool;
	}
	public void setBuildingSchool(String buildingSchool) {
		this.buildingSchool = buildingSchool;
	}
	public String getParkNumEn() {
		return parkNumEn;
	}
	public void setParkNumEn(String parkNumEn) {
		this.parkNumEn = parkNumEn;
	}
	public String getToiletNumEn() {
		return toiletNumEn;
	}
	public void setToiletNumEn(String toiletNumEn) {
		this.toiletNumEn = toiletNumEn;
	}
	public String getGoodsDepositoryEn() {
		return goodsDepositoryEn;
	}
	public void setGoodsDepositoryEn(String goodsDepositoryEn) {
		this.goodsDepositoryEn = goodsDepositoryEn;
	}
	public String getFoodServiceEn() {
		return foodServiceEn;
	}
	public void setFoodServiceEn(String foodServiceEn) {
		this.foodServiceEn = foodServiceEn;
	}
	public String getInformationDeskEn() {
		return informationDeskEn;
	}
	public void setInformationDeskEn(String informationDeskEn) {
		this.informationDeskEn = informationDeskEn;
	}
	public String getAtmEn() {
		return atmEn;
	}
	public void setAtmEn(String atmEn) {
		this.atmEn = atmEn;
	}
	public String getBarrierFreeStructuresEn() {
		return barrierFreeStructuresEn;
	}
	public void setBarrierFreeStructuresEn(String barrierFreeStructuresEn) {
		this.barrierFreeStructuresEn = barrierFreeStructuresEn;
	}
	public String getMotherRoomEn() {
		return motherRoomEn;
	}
	public void setMotherRoomEn(String motherRoomEn) {
		this.motherRoomEn = motherRoomEn;
	}
	public String getProductServiceEn() {
		return productServiceEn;
	}
	public void setProductServiceEn(String productServiceEn) {
		this.productServiceEn = productServiceEn;
	}
	public String getRestingAreaEn() {
		return restingAreaEn;
	}
	public void setRestingAreaEn(String restingAreaEn) {
		this.restingAreaEn = restingAreaEn;
	}
	public String getCommunicationServiceEn() {
		return communicationServiceEn;
	}
	public void setCommunicationServiceEn(String communicationServiceEn) {
		this.communicationServiceEn = communicationServiceEn;
	}
	public String getSpotRescueEn() {
		return spotRescueEn;
	}
	public void setSpotRescueEn(String spotRescueEn) {
		this.spotRescueEn = spotRescueEn;
	}
	public String getTourGuideEn() {
		return tourGuideEn;
	}
	public void setTourGuideEn(String tourGuideEn) {
		this.tourGuideEn = tourGuideEn;
	}
	public String getFreeUmbrellaEn() {
		return freeUmbrellaEn;
	}
	public void setFreeUmbrellaEn(String freeUmbrellaEn) {
		this.freeUmbrellaEn = freeUmbrellaEn;
	}
	public String getGuideMapEn() {
		return guideMapEn;
	}
	public void setGuideMapEn(String guideMapEn) {
		this.guideMapEn = guideMapEn;
	}
	public String getBaseIntroduceEn() {
		return baseIntroduceEn;
	}
	public void setBaseIntroduceEn(String baseIntroduceEn) {
		this.baseIntroduceEn = baseIntroduceEn;
	}
	public String getExpostorNumEn() {
		return expostorNumEn;
	}
	public void setExpostorNumEn(String expostorNumEn) {
		this.expostorNumEn = expostorNumEn;
	}
	public String getBasicConditionEn() {
		return basicConditionEn;
	}
	public void setBasicConditionEn(String basicConditionEn) {
		this.basicConditionEn = basicConditionEn;
	}
	public String getExplainLanguageEn() {
		return explainLanguageEn;
	}
	public void setExplainLanguageEn(String explainLanguageEn) {
		this.explainLanguageEn = explainLanguageEn;
	}
	public String getFreeExplainEn() {
		return freeExplainEn;
	}
	public void setFreeExplainEn(String freeExplainEn) {
		this.freeExplainEn = freeExplainEn;
	}
	public String getExpertExplainEn() {
		return expertExplainEn;
	}
	public void setExpertExplainEn(String expertExplainEn) {
		this.expertExplainEn = expertExplainEn;
	}
	public String getAudioGuideEn() {
		return audioGuideEn;
	}
	public void setAudioGuideEn(String audioGuideEn) {
		this.audioGuideEn = audioGuideEn;
	}
	public String getTouchScreenEn() {
		return touchScreenEn;
	}
	public void setTouchScreenEn(String touchScreenEn) {
		this.touchScreenEn = touchScreenEn;
	}
	public String getFreeOpenStyle() {
		return freeOpenStyle;
	}
	public void setFreeOpenStyle(String freeOpenStyle) {
		this.freeOpenStyle = freeOpenStyle;
	}
	public String getCourseTitleName() {
		return courseTitleName;
	}
	public void setCourseTitleName(String courseTitleName) {
		this.courseTitleName = courseTitleName;
	}

}