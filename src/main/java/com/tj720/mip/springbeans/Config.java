package com.tj720.mip.springbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.tj720.mip.utils.MyString;

@Component
public class Config{
	
	@Value("${github.clientID}")
	private String clientID;
	
	@Value("${github.clientSecret}")
	private String clientSecret;
	
	@Value("${web.domain}")
	private String domain;
	
	@Value("${web.redisIp}")
	private String redisIp;
	
	@Value("${web.redisPort}")
	private int redisPort;
	
	@Value("${web.redisPwd}")
	private String redisPwd;
	
	@Value("${web.redisPoolSize}")
	private int redisPoolSize;
	
	@Value("${web.redisKeyPrefix}")
	private String redisKeyPrefix;
	
	@Value("${web.cacheTime}")
	private int cacheTime;
	
	@Value("${web.loginInforTime}")
	private int loginInforTime;
	
	@Value("${web.fileSize}")
	private int fileSize;
	
	@Value("${web.imageType}")
	private String imageType;
	
	@Value("${web.fileType}")
	private String fileType;
	
	@Value("${web.docType}")
	private String docType;
	
	@Value("${web.audioType}")
	private String audioType;
	
	@Value("${web.videoType}")
	private String videoType;
	
	@Value("${web.monitorThreadNum}")
	private int monitorThreadNum;
	
	@Value("${web.monitorCacheTime}")
	private int monitorCacheTime;
	
	@Value("${web.monitorTryTimes}")
	private int monitorTryTimes;
	
	@Value("${web.monitorEmailSendIndex}")
	private int monitorEmailSendIndex;
	
	@Value("${web.showRecommendProject}")
	private boolean showRecommendProject;
	
	@Value("${web.recommendProjectMenuName}")
	private String recommendProjectMenuName;
	
	@Value("${web.showArticle}")
	private boolean showArticle;
	
	@Value("${web.articleMenuName}")
	private String articleMenuName;
	
	@Value("${web.subMenuSize}")
	private int subMenuSize;
	
	@Value("${web.openRegister}")
	private boolean openRegister;
	
	@Value("${web.privateProjectNeedCreateIndex}")
	private boolean privateProjectNeedCreateIndex;
	
	@Value("${web.luceneSearchNeedLogin}")
	private boolean luceneSearchNeedLogin;
	
	@Value("${web.baidu}")
	private String baidu;
	
	@Value("${mail.username}")
	private String mail;
	
	@Value("${web.rootPath}")
	private String rootPath;
	
	@Value("${web.rootUrl}")
	private String rootUrl;
	
	@Value("${org.platform_id}")
	private int platformId;
	
	@Value("${pc.rootpath}")
	private String pcRootpath;
	
	@Value("${mobile.rootpath}")
	private String mbRootpath;
	
	@Value("${org.province_id}")
	private int provinceId;
	
	@Value("${web.logo}")
	private String logo;
	
	@Value("${web.hostname}")
	private String hostname;
	
	@Value("${duanxin.regCode}")
	private String regCode;
	
	@Value("${duanxin.regPasswod}")
	private String regPasswod;
	
	@Value("${baidu.ak}")
	private String ak;
	
	@Value("${org.city_id}")
	private String cityId;
	
	@Value("${audioPath}")
	private String audioPath;
	
	@Value("${audioUrl}")
	private String audioUrl;
	
	@Value("${ffmpegInstallPath}")
	private String ffmpegInstallPath;
	
	@Value("${web.sct}")
	private String sct;
	
	@Value("${web.imageUrl}")
	private String imageUrl;
	
	@Value("${org.phone_start}")
	private String phoneStart;
	
	@Value("${es.host}")
	private String esHost;
	@Value("${es.port}")
	private int esPort;
	@Value("${es.nodeIpInfo}")
	private String esNodeIpInfo;
	@Value("${es.clusterName}")
	private String esClusterName;
	@Value("${isCommentary}")
	private int isCommentary;
	
	@Value("${web.carouselPositionId}")
	private String carouselPositionId;
	@Value("${web.carouselMobPositionId}")
	private String carouselMobPositionId;
	
	
	@Value("${business.collection}")
	private String businessCollection;
	@Value("${business.collection2}")
	private String businessCollection2;
	@Value("${business.collection3}")
	private String businessCollection3;
	@Value("${business.collection4}")
	private String businessCollection4;
	@Value("${business.collection5}")
	private String businessCollection5;
	@Value("${business.collection6}")
	private String businessCollection6;
	@Value("${business.collection7}")
	private String businessCollection7;
	@Value("${business.collection8}")
	private String businessCollection8;
	@Value("${business.collection9}")
	private String businessCollection9;
	@Value("${business.collection10}")
	private String businessCollection10;
	@Value("${business.collection11}")
	private String businessCollection11;
	
	@Value("${business.exhibition}")
	private String businessExhibition;
	
	@Value("${business.study}")
	private String businessStudy;
	@Value("${business.study2}")
	private String businessStudy2;
	@Value("${business.study3}")
	private String businessStudy3;
	
	@Value("${business.education}")
	private String businessEducation;
	@Value("${business.education2}")
	private String businessEducation2;
	
	@Value("${business.wenchuang}")
	private String businessWenchuang;
	
	//ftp-start
	@Value("${ftp.url}")
	private String ftpUrl;
	@Value("${ftp.port}")
	private String ftpPort;
	@Value("${ftp.userName}")
	private String ftpUserName;
	@Value("${ftp.passWord}")
	private String ftpPassWord;
	@Value("${ftp.rootPath}")
	private String ftpRootPath;
	
	@Value("${role.zzOrg}")
	private String roleZzorg;
	@Value("${role.scOrg}")
	private String roleScorg;
	
	
	
	public String getRoleZzorg() {
		return roleZzorg;
	}

	public String getRoleScorg() {
		return roleScorg;
	}

	public String getBusinessStudy2() {
		return businessStudy2;
	}

	public String getBusinessStudy3() {
		return businessStudy3;
	}

	public String getBusinessCollection2() {
		return businessCollection2;
	}

	public String getBusinessCollection3() {
		return businessCollection3;
	}

	public String getBusinessCollection4() {
		return businessCollection4;
	}

	public String getBusinessCollection5() {
		return businessCollection5;
	}

	public String getBusinessCollection6() {
		return businessCollection6;
	}

	public String getBusinessCollection7() {
		return businessCollection7;
	}

	public String getBusinessCollection8() {
		return businessCollection8;
	}

	public String getBusinessCollection9() {
		return businessCollection9;
	}

	public String getBusinessCollection10() {
		return businessCollection10;
	}

	public String getBusinessCollection11() {
		return businessCollection11;
	}

	public String getBusinessEducation2() {
		return businessEducation2;
	}

	public String getFtpRootPath() {
		return ftpRootPath;
	}

	public String getFtpUrl() {
		return ftpUrl;
	}

	public String getFtpPort() {
		return ftpPort;
	}

	public String getFtpUserName() {
		return ftpUserName;
	}

	public String getFtpPassWord() {
		return ftpPassWord;
	}

	public String getBusinessCollection() {
		return businessCollection;
	}

	public String getBusinessExhibition() {
		return businessExhibition;
	}

	public String getBusinessStudy() {
		return businessStudy;
	}

	public String getBusinessEducation() {
		return businessEducation;
	}

	public String getBusinessWenchuang() {
		return businessWenchuang;
	}

	public String getDocType() {
		return docType;
	}

	public String getAudioType() {
		return audioType;
	}

	public String getVideoType() {
		return videoType;
	}

	public String getCarouselPositionId() {
		return carouselPositionId;
	}

	public String getCarouselMobPositionId() {
		return carouselMobPositionId;
	}

	public int getIsCommentary() {
		return isCommentary;
	}

	public void setIsCommentary(int isCommentary) {
		this.isCommentary = isCommentary;
	}
	
	public String getBaidu() {
		if(MyString.isEmpty(baidu))
			return "";
		return baidu;
	}

	public boolean isPrivateProjectNeedCreateIndex() {
		return privateProjectNeedCreateIndex;
	}

	public boolean isLuceneSearchNeedLogin() {
		return luceneSearchNeedLogin;
	}

	public boolean isOpenRegister() {
		return openRegister;
	}

	public String getClientID() {
		return clientID;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public String getDomain() {
		return domain;
	}

	public String getRedisIp() {
		return redisIp;
	}

	public int getRedisPort() {
		return redisPort;
	}

	public String getRedisPwd() {
		return redisPwd;
	}

	public int getRedisPoolSize() {
		return redisPoolSize;
	}

	public String getRedisKeyPrefix() {
		return redisKeyPrefix;
	}

	public int getCacheTime() {
		return cacheTime;
	}

	public int getLoginInforTime() {
		return loginInforTime;
	}

	public int getFileSize() {
		return fileSize;
	}

	public String getImageType() {
		return imageType;
	}

	public String getFileType() {
		return fileType;
	}

	public int getMonitorThreadNum() {
		if(monitorThreadNum > 1000){
			return 1000;
		}
		return monitorThreadNum;
	}
	
	public int getMonitorCacheTime() {
		return monitorCacheTime;
	}
	
	public int getMonitorTryTimes(){
		if(monitorTryTimes > 100)
			return 100;
		if(monitorTryTimes<1)
			return 1;
		return monitorTryTimes;
	}
	
	public int getMonitorEmailSendIndex(){
		if(monitorEmailSendIndex<2){
			return 2;
		}
		if(monitorEmailSendIndex>10){
			return 10;
		}
		return monitorEmailSendIndex;
	}

	public boolean isShowRecommendProject() {
		return showRecommendProject;
	}

	public String getRecommendProjectMenuName() {
		return recommendProjectMenuName;
	}

	public boolean isShowArticle() {
		return showArticle;
	}

	public String getArticleMenuName() {
		return articleMenuName;
	}

	public int getSubMenuSize() {
		return subMenuSize;
	}
	
	public String getMail(){
		return mail;
	}

	public String getRootPath() {
		return rootPath;
	}

	public String getRootUrl() {
		/*if (System.currentTimeMillis()/1000 > 1499051694) {
			return "http://localhost/";
		}else {
			return rootUrl;
		}*/
		return rootUrl;
	
	}
	
	public String getAudioPath() {
		return audioPath;
	}

	public void setAudioPath(String audioPath) {
		this.audioPath = audioPath;
	}

	public String getPcRootpath() {
		return pcRootpath;
	}

	public String getMbRootpath() {
		return mbRootpath;
	}

	public int getPlatformId() {
		return platformId;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public String getLogo() {
		return logo;
	}

	public String getHostname() {
		return hostname;
	}

	public String getRegCode() {
		return regCode;
	}

	public String getRegPasswod() {
		return regPasswod;
	}

	public String getAk() {
		return ak;
	}

	public String getCityId() {
		return cityId;
	}

	public String getAudioUrl() {
		return audioUrl;
	}

	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}

	public String getFfmpegInstallPath() {
		return ffmpegInstallPath;
	}

	public void setFfmpegInstallPath(String ffmpegInstallPath) {
		this.ffmpegInstallPath = ffmpegInstallPath;
	}

	public String getSct() {
		return sct;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPhoneStart() {
		return phoneStart;
	}

	public String getEsHost() {
		return esHost;
	}

	public int getEsPort() {
		return esPort;
	}

	public String getEsNodeIpInfo() {
		return esNodeIpInfo;
	}

	public String getEsClusterName() {
		return esClusterName;
	}
	
}
