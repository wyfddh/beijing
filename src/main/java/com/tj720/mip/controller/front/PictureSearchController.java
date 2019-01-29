package com.tj720.mip.controller.front;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.DigestInputStream;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.tj720.mip.dto.PictureSearchCollectionsDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.ICollectionCategoryService;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IMipOpenFossilInfoService;
import com.tj720.mip.inter.service.table.IPictureSearchConfigService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.inter.service.table.IYearTypeService;
import com.tj720.mip.model.CollectionCategory;
import com.tj720.mip.model.MipOpenCulturalrelicInfo;
import com.tj720.mip.model.MipOpenFossilInfo;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.PictureSearchConfig;
import com.tj720.mip.model.YearType;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.ImageSearchThread;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.PictureSearchUtil;
import com.tj720.mip.utils.Tools;

@Controller("frontPictureSearchController")
@RequestMapping("/front/picturesearch")
public class PictureSearchController extends BaseController<Picture> {
	@Autowired
	private IPictureSearchConfigService pictureSearchConfigService;
	@Autowired
	private IPictureService pictureService;
	@Autowired
	private IMipOpenCulturalrelicInfoService collectionService;
	@Autowired
	private IMipOpenFossilInfoService fossilService;
	@Autowired
	private ICollectionCategoryService colletionCategoryService;
	@Autowired
	private IYearTypeService yearTypeService;
	@Autowired
	private Config config;

	/**
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/search.do")
	@ResponseBody
	public JsonResult search(String picId,String url,@RequestParam(defaultValue = "15") int limit, HttpServletRequest request) throws MyException {
		System.out.println("搜图开始："+new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(System.currentTimeMillis()));
		boolean isLocal=isLocalHost(request.getRequestURL().toString());
		PictureSearchConfig searchConfig=pictureSearchConfigService.get("1");
		if(!PictureSearchUtil.checkConfig(searchConfig))
			PictureSearchUtil.setConfig(searchConfig);
		String searchUrl=null;
		String searchFile=null;
		if(!MyString.isEmpty(picId)){
			Picture pic = pictureService.get(picId);
			searchUrl=MyString.isEmpty(pic.getThumb1())?config.getRootUrl()+pic.getUrl():config.getRootUrl()+pic.getThumb1();
			searchFile=config.getRootPath()+pic.getUrl();
		}
		if(isLocal){
			if(!MyString.isEmpty(searchFile)){
				String response_content=null;
				System.out.println(searchFile);
				try {
					response_content = PictureSearchUtil.searchByFile(searchFile);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(response_content);
				System.out.println("查询开始："+new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(System.currentTimeMillis()));
				if(!MyString.isEmpty(response_content))
					return this.translateSearch(response_content, limit);
			}
			if(MyString.isEmpty(searchUrl)&&!MyString.isEmpty(url)){
				searchUrl=url;
			}
			if(!MyString.isEmpty(searchUrl)){
				try {
					String response_content = PictureSearchUtil.searchByUrl(searchUrl);
					System.out.println("查询开始："+new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(System.currentTimeMillis()));
					if(!MyString.isEmpty(response_content))
						return this.translateSearch(response_content,limit);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			if(!MyString.isEmpty(searchFile)){
				if(MyString.isEmpty(searchUrl)&&!MyString.isEmpty(url)){
					searchUrl=url;
				}
				if(!MyString.isEmpty(searchUrl)){
					try {
						String response_content = PictureSearchUtil.searchByUrl(searchUrl);
						System.out.println("查询开始："+new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(System.currentTimeMillis()));
						if(!MyString.isEmpty(response_content))
							return this.translateSearch(response_content,limit);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				String response_content=null;
				try {
					response_content = PictureSearchUtil.searchByFile(searchFile);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("查询开始："+new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(System.currentTimeMillis()));
				if(!MyString.isEmpty(response_content))
					return this.translateSearch(response_content, limit);
			}
		}
		return new JsonResult(-1, "找不到相似藏品");
	}
	protected JsonResult translateSearch(String content,int limit){
		class SearchAttr{
			public int type=0;
			public List<String> wheres1=new ArrayList<String>();
			public List<String> wheres2=new ArrayList<String>();
		}
		List<Double> scores=new ArrayList<Double>();
		List<String> metadatas=new ArrayList<String>();
		List<String> urls=new ArrayList<String>();
		List<SearchAttr> searchs=new ArrayList<SearchAttr>();
		List<String> ids= new ArrayList<String>(); 
		List<PictureSearchCollectionsDto> result=new ArrayList<PictureSearchCollectionsDto>();
		if(!MyString.isEmpty(content)){
	        JSONObject jsonObject=JSONObject.parseObject(content);
	        content=jsonObject.toJSONString();
			Pattern p=Pattern.compile("(\"score\":[\\d\\.]+\\,*)|(\"metadata\":\"[^\"]+\"\\,*)|(\"url\":\"[^\"]+\"\\,*)");
			Matcher m=p.matcher(content);
			while(m.find()){
				String[] strs=m.group().replace(",","").split(":",2);
				switch(strs[0]){
				case "\"score\"":
					scores.add(Double.valueOf(strs[1]));
					break;
				case "\"metadata\"":
					metadatas.add(strs[1].replace("\"", ""));
					break;
				case "\"url\"":
					urls.add(strs[1].replace("\"", ""));
					break;
				}
	    	}
			System.out.println(metadatas);
			int count=Math.min(metadatas.size(), scores.size());
			//wuyu:设置查询条件
			for(int i=0;i<count;i++){
				SearchAttr searchAttr=new SearchAttr();
				String metadata=metadatas.get(i);
				String[] recs=metadata.split("&");
				List<String> ands=new ArrayList<String>();
				for(String rec : recs){
					String[] strs=rec.split(":");
					switch(strs[0]){
					case "gsNo":
						searchAttr.wheres1.add("where gsNo='"+strs[1]+"'");
					case "collectionsCategory":
						CollectionCategory collectionCategory=colletionCategoryService.getByHql("from CollectionCategory where name ='"+strs[1]+"'");
						if(!MyString.isEmpty(collectionCategory)){
							if(collectionCategory.getType().equals("文物"))
								searchAttr.type=1;
							else if(collectionCategory.getType().equals("化石"))
								searchAttr.type=2;
							ands.add("collectionsCategory='"+strs[1]+"'");
						}
						break;
					case "yearType":
						String str=(strs[1].lastIndexOf("|")>0?strs[1].substring(strs[1].lastIndexOf("|")+1):strs[1]);
						if(!MyString.isEmpty(str)){
							YearType yearType=yearTypeService.getByHql("from YearType where fullname = '"+str+"'");
							if(!MyString.isEmpty(yearType)){
								if(yearType.getCode().charAt(0)!='1'){
									searchAttr.type=1;
									ands.add("yearType="+yearType.getId());
								}else{
									searchAttr.type=2;
									switch(yearType.getPath().split(",").length){
									case 1://宙
										ands.add("yearTypeEon="+yearType.getId());
										break;
									case 2://代
										ands.add("yearTypeEra="+yearType.getId());
										break;
									case 3://纪
										ands.add("yearTypeEpoch="+yearType.getId());
										break;
									}
								}
							}
						}
						break;
					case "name":
						if(!MyString.isEmpty(strs[1])){
							String name=strs[1].replace("，，", ",");
							searchAttr.wheres2.add("where locate('"+name+"',indexName)>0 OR locate('"+name+"',formerly)>0 OR locate('"+name+"',foreignName)>0");
						}
						break;
					}
				}
				if(!MyString.isEmpty(ands)){
					StringBuffer tmp = new StringBuffer();
					for(String and : ands){
						tmp.append(" and ").append(and);
					}
					tmp.replace(0,4,"where");
					searchAttr.wheres2.add(tmp.toString());
				}
				searchs.add(searchAttr);
			}
			//wyu:每一个where条件进行查询，直至藏品数量达到limit个
			count=0;
			//查Where1
			for(SearchAttr search1 : searchs){
				if(count>=limit)break;
				for(String where:search1.wheres1){
					//查文物
					if(count>=limit)break;
					if(search1.type!=2){
						String hql = "from MipOpenCulturalrelicInfo "+where+" and isOpen=2 ";
						List<MipOpenCulturalrelicInfo> moList = (List<MipOpenCulturalrelicInfo>) collectionService.queryLimitByHql(hql, limit);
						for(MipOpenCulturalrelicInfo o : moList){
							if(!ids.contains(o.getId())){
								PictureSearchCollectionsDto rec=getCollectionDto(o);
								if(rec!=null){
									ids.add(rec.getId());
									result.add(rec);
									count++;
									if(count>=limit)break;
								}
							}
						}
					}
					//查化石
					if(search1.type!=1){
						if(count>=limit)break;
						String hql = "from MipOpenFossilInfo "+where+" and isOpen=2 ";
						List<MipOpenFossilInfo> moList = (List<MipOpenFossilInfo>) fossilService.queryLimitByHql(hql, limit);
						for(MipOpenFossilInfo o : moList){
							if(!ids.contains(o.getId())){
								PictureSearchCollectionsDto rec=getFossilDto(o);
								if(rec!=null){
									ids.add(rec.getId());
									result.add(rec);
									count++;
									if(count>=limit)break;
								}
							}
						}
					}
				}
			}
//			System.out.println(count);
//			System.out.println(limit);
//			System.out.println(searchs.size());
			//查Where2
			for(SearchAttr search2 : searchs){
				if(count>=limit)break;
				for(String where:search2.wheres2){
					if(count>=limit)break;
					//查文物
					if(search2.type!=2){
						String hql = "from MipOpenCulturalrelicInfo "+where+" and isOpen=2 ";
						List<MipOpenCulturalrelicInfo> moList = (List<MipOpenCulturalrelicInfo>) collectionService.queryLimitByHql(hql, limit);
						for(MipOpenCulturalrelicInfo o : moList){
							if(!ids.contains(o.getId())){
								PictureSearchCollectionsDto rec=getCollectionDto(o);
								if(rec!=null){
									ids.add(rec.getId());
									result.add(rec);
									count++;
									if(count>=limit)break;
								}
							}
						}
					}
					//查化石
					if(search2.type!=1){
						if(count>=limit)break;
						String hql = "from MipOpenFossilInfo "+where+" and isOpen=2 ";
						List<MipOpenFossilInfo> moList = (List<MipOpenFossilInfo>) fossilService.queryLimitByHql(hql, limit);
						for(MipOpenFossilInfo o : moList){
							if(!ids.contains(o.getId())){
								PictureSearchCollectionsDto rec=getFossilDto(o);
								if(rec!=null){
									ids.add(rec.getId());
									result.add(rec);
									count++;
									if(count>=limit)break;
								}
							}
						}
					}
				}
			}
			System.out.println("查询结束："+new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(System.currentTimeMillis()));
			if(result.size()>0)
				return new JsonResult(1,result);
		}
		return new JsonResult(-1,"找不到相似藏品！");
	}
	protected PictureSearchCollectionsDto getCollectionDto(MipOpenCulturalrelicInfo o){
		PictureSearchCollectionsDto result=new PictureSearchCollectionsDto();
		result.setType("1");
		result.setId(o.getId());
		result.setName(o.getName());
		result.setThreeDimensionalCollection(MyString.isEmpty(o.getThreeDimensionalCollection())?"":"1");
		result.setfVideo(MyString.isEmpty(o.getfVideo())?"":"1");
		result.setfAudio(MyString.isEmpty(o.getfAudio())?"":"1");
		YearType yearType = yearTypeService.get(o.getYearType());
		if(!MyString.isEmpty(yearType))
			result.setYearType(yearType.getFullname());
		if(!MyString.isEmpty((o.getId()))){
			String picHql="from Picture where object_id='"+o.getId()+"' order by isMain desc,url";
			Picture pic = pictureService.getByHql(picHql);
			if(!MyString.isEmpty(pic)){
				result.setThumb1(config.getRootUrl()+pic.getThumb1());
				result.setThumb1Width(pic.getThumb1Width());
				result.setThumb1Height(pic.getThumb1Height());
				result.setThumb2(config.getRootUrl()+pic.getThumb2());
				result.setThumb2Width(pic.getThumb2Width());
				result.setThumb2Height(pic.getThumb2Height());
				result.setThumb3(config.getRootUrl()+pic.getThumb3());
				result.setThumb3Width(pic.getThumb3Width());
				result.setThumb3Height(pic.getThumb3Height());
			}
		}
		return result;
	}
	protected PictureSearchCollectionsDto getFossilDto(MipOpenFossilInfo o){
		PictureSearchCollectionsDto result=new PictureSearchCollectionsDto();
		result.setType("2");
		result.setId(o.getId());
		result.setName(o.getName());
		result.setThreeDimensionalCollection(MyString.isEmpty(o.getThreeDimensionalCollection())?"":"1");
		result.setfVideo(MyString.isEmpty(o.getfVideo())?"":"1");
		result.setfAudio(MyString.isEmpty(o.getfAudio())?"":"1");
		YearType yearType = yearTypeService.get(o.getYearType());
		if(!MyString.isEmpty(yearType))
			result.setYearType(yearType.getFullname());
		if(!MyString.isEmpty((o.getId()))){
			String picHql="from Picture where object_id='"+o.getId()+"' order by isMain desc,url";
			Picture pic = pictureService.getByHql(picHql);
			if(!MyString.isEmpty(pic)){
				result.setThumb1(config.getRootUrl()+pic.getThumb1());
				result.setThumb1Width(pic.getThumb1Width());
				result.setThumb1Height(pic.getThumb1Height());
				result.setThumb2(config.getRootUrl()+pic.getThumb2());
				result.setThumb2Width(pic.getThumb2Width());
				result.setThumb2Height(pic.getThumb2Height());
				result.setThumb3(config.getRootUrl()+pic.getThumb3());
				result.setThumb3Width(pic.getThumb3Width());
				result.setThumb3Height(pic.getThumb3Height());
			}
		}
		return result;
	}
	protected boolean isLocalHost(String url){
		final String[] localList={"localhost","127.0.0.1","192.168","172.16","172.17","172.18","172.19","172.20","172.21","172.22","172.23","172.24","172.25","172.26","172.27","172.28","172.29","172.30","172.31","10."};
		for(String local:localList){
			if(url.contains(local))
				return true;
		}
		return false;
	}
}