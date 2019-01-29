package com.tj720.mip.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.tj720.mip.vo.WeixinVo;

import net.sf.json.JSONObject;

public class AuthUtil {
	
	//公司
	public static final String APPID="wxd090fa3a78f4a083";
	public static final String APPSECRET="defa50d2e8274e24ece855c96e0c96a2";
	
	//微信测试号
	/*public static final String APPID="wx2c825a36991a679e";
	public static final String APPSECRET="b8a6b797a3d8d21b3194d6ad4632d679";*/

	public static final String WEIXIN_ACCESS_TOKEN_KEY = "wxAccessTokenKey";
	//微信授权缓存
	public static Map<String, WeixinVo> wxAtuhCacheMap = new HashMap<String, WeixinVo>();
	
	public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException{
		JSONObject jsonObject = null;
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = client.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			String result = EntityUtils.toString(entity,"UTF-8");
			jsonObject = JSONObject.fromObject(result);
		}
		httpGet.releaseConnection();
		return jsonObject;
		
	}
	public static String doGetJsonStr(String url) throws ClientProtocolException, IOException{
		String result = null;
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = client.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			result = EntityUtils.toString(entity,"UTF-8");
		}
		httpGet.releaseConnection();
		return result;
		
	}
}
