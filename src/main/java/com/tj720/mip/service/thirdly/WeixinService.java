package com.tj720.mip.service.thirdly;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tj720.mip.constant.Constants;
import com.tj720.mip.model.MipCollectionAudio;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.MipCollectionAudioService;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.AuthUtil;
import com.tj720.mip.utils.DateFormartUtil;
import com.tj720.mip.utils.FFmpegUtils;
import com.tj720.mip.utils.FileUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.TimeShowUtil;
import com.tj720.mip.utils.TimeUtil;
import com.tj720.mip.utils.Tools;
import com.tj720.mip.utils.WeixinShareUtils;
import com.tj720.mip.vo.WeixinVo;

@Service
public class WeixinService {
	//公司号
	private final static String APP_ID = "wxd090fa3a78f4a083";
	private final static String APP_SECRET = "defa50d2e8274e24ece855c96e0c96a2";
	
	//测试号
	/*private final static String APP_ID = "wx2c825a36991a679e";
	private final static String APP_SECRET = "b8a6b797a3d8d21b3194d6ad4632d679";*/
	@Autowired
	private Config config;//常量的取法
	
	@Autowired
	UserService userService;
	@Autowired
	MipCollectionAudioService mipCollectionAudioService;
	@Autowired
	MipOrganizationService mipOrganizationService;
	/**
	 * web 端微信授权
	 * @param map
	 * @param url 
	 */
	public void wxWebAuth(Map<String, String> map, String url) {
		try{
			String jsapiTicket = getTicket();
			if(StringUtils.isBlank(jsapiTicket)){
				map.put(Constants.ERROR_CODE_NAME, "500");
			}
			String timestamp = Long.toString(System.currentTimeMillis() / 1000);
	        String nonceStr = UUID.randomUUID().toString();
	        String signature = WeixinShareUtils.getSignature(jsapiTicket, nonceStr, timestamp, url);
	        //map.put("url", url);
	        //map.put("jsapiTicket", jsapiTicket);
	        map.put("nonceStr", nonceStr);
	        map.put("timestamp", timestamp);
	        map.put("signature", signature);
	        map.put("appId", APP_ID); 
	        map.put(Constants.ERROR_CODE_NAME, "0"); 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getTicket() {
		try {
			String tokenStr = getAccessToken();
			if(StringUtils.isBlank(tokenStr)){
				tokenStr = getAccessToken();
			}
			if(StringUtils.isBlank(tokenStr)){
				return null;
			}
			// 获取ticket值
			String ticketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + tokenStr + "&type=jsapi";
			String ticketStr = null;
			String ticketJson = AuthUtil.doGetJsonStr(ticketUrl);
			WeixinVo ticketVo = JSONObject.parseObject(ticketJson, WeixinVo.class);
			ticketStr = ticketVo.getTicket();
			// 返回结果集
			return ticketStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

	/**
	 * 音频合成
	 * @param map
	 * @param ids
	 * @param collectionId 
	 */
	public void audioCompose(Map<String, Object> map, List<String> ids, String collectionId) {
		String userId = Tools.getUserId();
		if(StringUtils.isBlank(userId)){
			map.put(Constants.ERROR_CODE_NAME, Constants.ERROR_CODE_NO_LOGIN);
			return ;
		}
		User user = userService.get(userId);
		if(user == null){
			map.put(Constants.ERROR_CODE_NAME, Constants.ERROR_CODE_NO_LOGIN);
			return ;
		}
		String accessToken = getAccessToken();
		if(StringUtils.isBlank(accessToken)){
			accessToken = getAccessToken();
		}
		map.put(Constants.ERROR_CODE_NAME, Constants.ERROR_CODE_SUCCESS);
		if(StringUtils.isBlank(accessToken)){
			map.put(Constants.ERROR_CODE_NAME, Constants.ERROR_CODE_FAIL);
			return ;
		}
		if(CollectionUtils.isEmpty(ids)){
			map.put(Constants.ERROR_CODE_NAME, Constants.ERROR_CODE_PARAM_ISNULL);
			return;
		}
		String rootPath = config.getAudioPath() + System.currentTimeMillis();
		List<String> audioPathList = new ArrayList<String>();
		//从微信服务器下载音频数据存储
		processAudioPath(audioPathList, ids, accessToken, rootPath);
		String composePath = rootPath + File.separator + "compose.amr";
		String mp3RootPath =  config.getAudioPath() + TimeUtil.getCurYearOrMonth();
		File mp3File = new File(mp3RootPath);
		if(!mp3File.exists())
			mp3File.mkdir();
		String mp3Path = mp3RootPath + File.separator + System.currentTimeMillis() + ".mp3";
		
		//调用ffmpeg合成音频
		String concatPath = composeAudioForFFmpeg(audioPathList, rootPath, composePath);
		if(StringUtils.isNotBlank(composePath)){
			//System.out.println(cmdStr);
			//存数据库
			//获取音频时长
			String duration = getDurationForAudio(concatPath);
			if(StringUtils.isBlank(duration)){
				map.put(Constants.ERROR_CODE_NAME, Constants.ERROR_CODE_FAIL);
				return;
			}
			//amr 转mp3
			FFmpegUtils.amrConvertMp3(concatPath, mp3Path, config.getFfmpegInstallPath());
			if(Constants.isDelAudioTempFile){
				try {
					FileUtil.deleteFloderFile(rootPath);
					new File(rootPath).deleteOnExit();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			//构建音频对象
			MipCollectionAudio mipCollectionAudio = constructorCollectionAudio(user, collectionId, mp3Path, duration);
			MipCollectionAudio audio = mipCollectionAudioService.save(mipCollectionAudio);
			if(audio == null){
				map.put(Constants.ERROR_CODE_NAME, Constants.ERROR_CODE_FAIL);
			} else{
				audio.setUrl(config.getAudioUrl() + audio.getUrl());
				String avatarUrl = user.getAvatarUrl();
				if (!MyString.isEmpty(avatarUrl)) {
					audio.setAvatarUrl(config.getRootUrl() + avatarUrl);
				}
				String orgId = user.getOrgId();
				if (!MyString.isEmpty(orgId)) {
					MipOrganization mipOrganization = mipOrganizationService.get(orgId);
					if (!MyString.isEmpty(mipOrganization.getId())) {
						audio.setUserName(mipOrganization.getName());
					}
				} else {
					audio.setUserName(user.getNickName());
				}
//				audio.setUserName(user.getOrgName());
				Long currentTime = System.currentTimeMillis();
				Long publishTime = audio.getPublishTime();
				String publishTimeStr = TimeShowUtil.plTime(currentTime, publishTime);
				audio.setPublishTimeStr(publishTimeStr);
				map.put(Constants.OUTPUT_DATA_NAME, audio);
			}
		}
	}

	/**
	 * 获取音频时长
	 * 
	 * ffmpeg -i d:/mp3/d.amr3
	 * @param cmdStr
	 * @return
	 */
	private String getDurationForAudio(String path) {
		String cmdStr = FFmpegUtils.getDurationForFile(path, config.getFfmpegInstallPath());
		if(StringUtils.isBlank(cmdStr)){
			return null;
		}
		int index = cmdStr.lastIndexOf(" Duration:");
		if(index != -1){
			cmdStr = cmdStr.substring(index + 11);
			int lastIndex = cmdStr.indexOf(",");
			if(lastIndex != -1){
				cmdStr = cmdStr.substring(0, lastIndex);
				String strs[] = cmdStr.split(":");
		        int seconds = 0;
		        if (strs[0].compareTo("0") > 0) {
		        	seconds += Integer.valueOf(strs[0])*60*60;//秒
		        }
		        if(strs[1].compareTo("0")>0){
		        	seconds += Integer.valueOf(strs[1])*60;
		        }
		        if(strs[2].compareTo("0")>0){
		        	seconds += Math.round(Float.valueOf(strs[2]));
		        }
		        return seconds + "";
			}
		}
		return null;
	}

	/**
	 * 构建音频对象
	 * @param user
	 * @param collectionId
	 * @param composePath
	 * @param duration 
	 * @return
	 */
	private MipCollectionAudio constructorCollectionAudio(User user, String collectionId, String composePath, String duration) {
		MipCollectionAudio mipCollectionAudio = new MipCollectionAudio();
		mipCollectionAudio.setCollectionId(collectionId);
		mipCollectionAudio.setCreateTime(DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD_HH_mm_ss));
		mipCollectionAudio.setUserId(user.getId());
		String url = composePath.replace(config.getAudioPath(), "/");
		mipCollectionAudio.setUrl(url);
		int isOfficial = StringUtils.isNotBlank(user.getOrgId()) ? 1 : 0;
		mipCollectionAudio.setIsOfficial((byte)isOfficial);
		mipCollectionAudio.setStatus((byte)1);
		mipCollectionAudio.setPublishTime(System.currentTimeMillis());
//		duration = TimeShowUtil.tranMinSec(duration);
		mipCollectionAudio.setDuration(duration);
		return mipCollectionAudio;
	}

	//调用ffmpeg合成音频
	private String composeAudioForFFmpeg(List<String> audioPathList, String rootPath, String composePath) {
		if(CollectionUtils.isEmpty(audioPathList)) return null;
		
		String concatPath = audioPathList.size() > 1 ? rootPath + File.separator + "concat.amr" : audioPathList.get(0);
		if(audioPathList.size() > 1){
			//多个音频拼接
			boolean concatResult = concatAudio(audioPathList, concatPath);
			if(!concatResult) return null;
		}
		return concatPath; 
		/*String backgroundPath = config.getAudioPath() + File.separator + "background.amr";
		//混音合成
		return FFmpegUtils.composeAudio(concatPath, backgroundPath, composePath, config.getFfmpegInstallPath());*/
		/*boolean composeResult = composeAudio(concatPath, composePath);
		if(composeResult)
			return composePath;
		return null;*/
	}

	/**
	 * 多个音频拼接
	 * @param audioPathList
	 * @param concatPath
	 * @return
	 */
	private boolean concatAudio(List<String> audioPathList, String concatPath) {
		StringBuilder cmdBuilder = new StringBuilder();
		for(String audioPath :audioPathList){
			cmdBuilder.append("|" + audioPath);
		}
		if(cmdBuilder == null || cmdBuilder.length() <= 0){
			return false;
		}
		String cmd = "\"concat:" + cmdBuilder.substring(1) + "\"";
		/*String cmdStr = */
		FFmpegUtils.concatAudio(concatPath, cmd, config.getFfmpegInstallPath());
		File file = new File(concatPath);
		return  (file.exists() && file.length() > 0);
	}

	/** 
     * 执行指令 
     * @param cmd 执行指令 
     * @param getter 指令返回处理接口，若为null则不处理输出 
     */  
    private boolean exec( List<String> cmd ){  
        try {  
            ProcessBuilder builder = new ProcessBuilder();    
            builder.command(cmd);  
            builder.redirectErrorStream(true);
            Process proc = builder.start();  
            BufferedReader stdout = new BufferedReader(new InputStreamReader(proc.getInputStream()));  
            StringBuilder lineBuilder = new StringBuilder();
            String line;  
            while ((line = stdout.readLine()) != null) {
                lineBuilder.append(line);
            }  
            proc.waitFor();     
            stdout.close();
            return true;
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return false;
    }
	/**
	 * 从微信服务器下载音频数据存储
	 * @param audioPathList
	 * @param ids
	 * @param accessToken
	 * @param rootPath 
	 */
	private void processAudioPath(List<String> audioPathList, List<String> ids, String accessToken, String rootPath) {
		int i = 0;
		File file = new File(rootPath);
		if(!file.exists())
			file.mkdir();
		for(String mediaId : ids){
			String path = rootPath +File.separator+ i + ".amr";
			try {
				if(saveAudioToDisk(accessToken, mediaId, path)){
					audioPathList.add(path);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}
	}

	/**
	 * 获取访问token值
	 * 
	 * @return
	 */
	private String getAccessToken() {
		String tokenStr = null;
		try{
			String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APP_ID + "&secret=" + APP_SECRET;
			
			WeixinVo vo = AuthUtil.wxAtuhCacheMap.get(AuthUtil.WEIXIN_ACCESS_TOKEN_KEY);
			
			if(vo == null || System.currentTimeMillis() > vo.getExpiresTime()){
				System.out.println("*****************从微信加载accessToken******************" + TimeUtil.GetCurDateTime());
				String tokenJson = AuthUtil.doGetJsonStr(tokenUrl);
				WeixinVo tokenVo = JSONObject.parseObject(tokenJson, WeixinVo.class);
				if(tokenVo == null) return tokenStr;
				tokenStr = tokenVo.getAccess_token();
				//设置token的有效期
				tokenVo.setExpiresTime(System.currentTimeMillis() + 1 * 60 * 60 * 1000);
				AuthUtil.wxAtuhCacheMap.put(AuthUtil.WEIXIN_ACCESS_TOKEN_KEY, tokenVo);
			} else {
				System.out.println("*****millis=" +System.currentTimeMillis() + "********expiresTime=" +vo.getExpiresTime());
				tokenStr = vo.getAccess_token();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} 
		return tokenStr;
	}

	
  
    
	/**
	 * 
	 * @param accessToken
	 * @param mediaId
	 * @param name
	 * @param path
	 * @throws Exception
	 */
	private boolean saveAudioToDisk(String accessToken, String mediaId, String path)  
            throws Exception {  
        InputStream inputStream = getInputStream(accessToken, mediaId);  
        byte[] data = new byte[10240];  
        int len = 0;  
        FileOutputStream fileOutputStream = null;  
        try {  
            fileOutputStream = new FileOutputStream(path);  
            while ((len = inputStream.read(data)) != -1) {  
                fileOutputStream.write(data, 0, len);  
            } 
            return true;
        } catch (IOException e) {  
            e.printStackTrace();  
            return false;
        } finally {  
            if (inputStream != null) {  
                try {  
                    inputStream.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (fileOutputStream != null) {  
                try {  
                    fileOutputStream.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }
    /** 
     *  
     * 根据文件id下载文件 
     * @param mediaId 
     *            媒体id 
     *  
     * @throws Exception 
     */  
  
    private InputStream getInputStream(String accessToken, String mediaId) {  
        InputStream is = null;  
        String url = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="  
                + accessToken + "&media_id=" + mediaId;  
        try {  
            URL urlGet = new URL(url);  
            HttpURLConnection http = (HttpURLConnection) urlGet  
                    .openConnection();  
            http.setRequestMethod("GET"); // 必须是get方式请求  
            http.setRequestProperty("Content-Type",  
                    "application/x-www-form-urlencoded");  
            http.setDoOutput(true);  
            http.setDoInput(true);  
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒  
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒  
            http.connect();  
            // 获取文件转化为byte流  
            is = http.getInputStream();  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return is;  
  
    }  
}
