package com.tj720.mip.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.tj720.mip.dto.ILuceneDto;
import com.tj720.mip.dto.SearchDto;
import com.tj720.mip.framework.base.BaseModel;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.utils.DateFormartUtil;
import com.tj720.mip.utils.MyString;


/**
 * @date 2016-01-06
 */
/**
 * @author WuYu
 *
 */
@Entity
@Table(name="mip_picture_search_config")
@GenericGenerator(name="Generator", strategy="com.tj720.mip.framework.IdGeneratorAutoIncrement")
public class PictureSearchConfig extends BaseModel implements Serializable,ILuceneDto{
	private static final long serialVersionUID = 1L;

	private int ssfSignatureLen=32;//SSF_SIGNATURE_LEN,
	private String ssfClientApi="https://api.productai.cn";//api请求地址,
	private String ssfClientVersion="1";//接口版本号,
	private String requestMethod="post";//提交方法,
	private String paiUserId="1762";//接口用户id,
	private String secretKey="6728cfe15947d2b5413b14e6ab115069";//secret_key,
	private String accessKeyId="7dd823e4b75fcef0e07f78bc90c08b48";//access_key_id,
	private String imageSetId="k1vl7dzw";//服务ID,
	private String serviceId="lzsiqi6s";//数据集ID,
	private int setPercentage=0;//数据集百分比,
	private String uid="";//最后操作用户id,
	private String updateTime=DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss);//修改时间,
	@Override
	public SearchDto toSearchDto(ICacheService cacheService) {
		// TODO Auto-generated method stub
		return null;
	}
	@Column(name="image_set_id")
	public String getImageSetId() {
		return imageSetId;
	}
	public void setImageSetId(String imageSetId) {
		this.imageSetId = imageSetId;
	}
	@Column(name="set_percentage")
	public int getSetPercentage() {
		return setPercentage;
	}
	public void setSetPercentage(int setPercentage) {
		this.setPercentage = setPercentage;
	}
	@Column(name="uid")
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Column(name="updateTime")
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	@Column(name="ssf_signature_len")
	public int getSsfSignatureLen() {
		return ssfSignatureLen;
	}
	public void setSsfSignatureLen(int ssfSignatureLen) {
		this.ssfSignatureLen = ssfSignatureLen;
	}
	@Column(name="ssf_client_api")
	public String getSsfClientApi() {
		return ssfClientApi;
	}
	public void setSsfClientApi(String ssfClientApi) {
		this.ssfClientApi = ssfClientApi;
	}
	
	@Column(name="ssf_client_version")
	public String getSsfClientVersion() {
		return ssfClientVersion;
	}
	public void setSsfClientVersion(String ssfClientVersion) {
		this.ssfClientVersion = ssfClientVersion;
	}
	@Column(name="request_method")
	public String getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	@Column(name="pai_user_id")
	public String getPaiUserId() {
		return paiUserId;
	}
	public void setPaiUserId(String paiUserId) {
		this.paiUserId = paiUserId;
	}
	@Column(name="secret_key")
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	@Column(name="access_key_id")
	public String getAccessKeyId() {
		return accessKeyId;
	}
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}
	@Column(name="service_id")
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
}