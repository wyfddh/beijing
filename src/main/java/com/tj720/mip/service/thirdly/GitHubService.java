package com.tj720.mip.service.thirdly;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.tj720.mip.dto.thirdly.GitHubAccessToken;
import com.tj720.mip.dto.thirdly.GitHubUser;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.HttpPostGet;
import com.tj720.mip.utils.Tools;

@Service
public class GitHubService {
	@Autowired
	private Config config;
	
	   public GitHubAccessToken getAccessToken(String code,String redirect_uri) throws Exception{
	        String url ="https://github.com/login/oauth/access_token";
	        Map<String,String> params = Tools.getStrMap("client_id",config.getClientID(),
	        		"client_secret",config.getClientSecret(),"code",code,"redirect_uri",redirect_uri);
	        
	        String rs = HttpPostGet.post(url, params, Tools.getStrMap("Accept","application/json"));
	        GitHubAccessToken accessToken = JSON.parseObject(rs,GitHubAccessToken.class);
	        if(accessToken == null || accessToken.getAccess_token() == null)
	            throw new MyException("000026");
	        return accessToken;
	    }

	    public GitHubUser getUser(String accessToken) throws Exception{
	        String url = "https://api.github.com/user?access_token="+accessToken;
	        String rs = HttpPostGet.get(url, null, null);
	        if(rs.contains("message"))
	        	throw new MyException("000026",rs);
	        return JSON.parseObject(rs,GitHubUser.class);
	    }

}
