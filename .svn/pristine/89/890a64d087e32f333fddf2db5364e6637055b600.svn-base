/**
 * 
 */
package com.tj720.admin.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.CmsArticleMapper;
import com.tj720.admin.dao.map.MipSpreadtrumMapper;
import com.tj720.admin.service.CmsArticleService;
import com.tj720.admin.service.SpreadtrumService;
import com.tj720.mip.dto.SpreadtrumDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Page;

/**
 * @author 程荣凯
 *
 */
@Service("SpreadtrumServiceImpl")
public class SpreadtrumServiceImpl implements SpreadtrumService{
	@Autowired
	private MipSpreadtrumMapper mipSpreadtrumMapper;
	@Autowired
	private CmsArticleMapper cmsArticleMapper;
	@Autowired
	private CmsArticleService articleService;
	@Autowired
	HttpServletRequest request;
	@Autowired
	Config config;
	
	@Override
	public JsonResult getSpreadtrumList(String orderCondition, Page page) throws ParseException {
		int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		Integer allCounts = mipSpreadtrumMapper.countSpreadtrumListInterface(orderCondition);
		page.setAllRow(allCounts);
		List<HashMap> temp  = mipSpreadtrumMapper.getSpreadtrumListInterface(orderCondition, startRow, page.getSize());
		if(null != temp){
			for (int i = 0; i < temp.size(); i++) {
				HashMap map = temp.get(i);
				//获取点赞数量
				String id = (String) map.get("id");
				HashMap<String,Object> comment = articleService.getCommentByArticleId(id);
				if(comment !=null){
					String ip = Utils.getIpAddr(request);;
					Integer count = articleService.countCommentByArticleId(id,ip);
					boolean hasCommend = false;
					if(count>0){
						hasCommend = true;
					}
					comment.put("hasCommend", hasCommend);
					map.put("comment", comment);
					
				}else{
					comment = new HashMap<String,Object>();
					comment.put("hasCommend", false);
					map.put("comment", comment);
				}
				if(map.get("pictureId") != null){
					map.put("pictureId",config.getRootUrl()+map.get("pictureId"));
				}
				if(map.get("beginTime") != null){
					map.put("beginTime", new SimpleDateFormat("yyyy-MM-dd").format(map.get("beginTime")));
				}
				if(map.get("endTime") != null){
					map.put("endTime", new SimpleDateFormat("yyyy-MM-dd").format(map.get("endTime")));
					String endTime = (String) map.get("endTime");
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					Date endDate = sdf.parse(endTime);
					long s1 = endDate.getTime();//将时间转为毫秒
					long s2 = System.currentTimeMillis();//得到当前的毫秒
					long  day = (s1-s2)/1000/60/60/24;
					if(day<0){
						map.put("day","已结束");
					}else{
						map.put("day",day);
					}
				}
				if(map.get("publishTime") != null){
					SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd，yyyy",  
			                Locale.ENGLISH); 
					map.put("publishTime", sdf.format(map.get("publishTime")));
				}
			}
		}
		return new JsonResult(1,temp,page);
	}

	@Override
	public JsonResult getVirtualExibitionHallList(Page page) {
		int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		Integer allCounts = mipSpreadtrumMapper.countVirtualExibitionHallList();
		page.setAllRow(allCounts);
		List<HashMap> temp  = mipSpreadtrumMapper.getVirtualExibitionHallList(startRow, page.getSize());
		if(null != temp){
			for (int i = 0; i < temp.size(); i++) {
				HashMap map = temp.get(i);
				if(map.get("pictureId") != null){
					map.put("pictureId",config.getRootUrl()+map.get("pictureId"));
				}				
			}
		}
		return new JsonResult(1,temp,page);
	}

	@Override
	public HashMap getSpreadtrumByCondition(String orgId, String id) {
		HashMap map = mipSpreadtrumMapper.getSpreadtrumByCondition(orgId, id);
		if(map.get("pictureId") != null){
			map.put("pictureId",config.getRootUrl()+map.get("pictureId"));
		}
		if(map.get("beginTime") != null){
			map.put("beginTime", new SimpleDateFormat("yyyy-MM-dd").format(map.get("beginTime")));
		}
		if(map.get("endTime") != null){
			map.put("endTime", new SimpleDateFormat("yyyy-MM-dd").format(map.get("endTime")));
		}
		return map;
	}

	@Override
	public JsonResult getPictureByPicId(String attFkId, String attId, Page page) {
		int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		Integer allCounts = mipSpreadtrumMapper.countPictureByPicId(attFkId, attId);
		page.setAllRow(allCounts);
		List<HashMap> map  = mipSpreadtrumMapper.getPictureByPicId(attFkId, attId, startRow, page.getSize());
		for (int i = 0; i < map.size(); i++) {
			HashMap temp = map.get(i);
			temp.put("attPath", addRootUrl(temp.get("attPath")==null?"":temp.get("attPath").toString()));
		}
		
		return new JsonResult(1,map,page);
	}

	@Override
	public HashMap getVirtualExibitionHallByCondition(String orgId, String id) {
		HashMap map = mipSpreadtrumMapper.getVirtualExibitionHallByCondition(orgId, id);
		return map;
	}
	
	private String addRootUrl(String url){
		if(null != url || url == ""){
			return config.getRootUrl()+url;
		}
		else{
			return url;
		}
	}

	@Override
	public JsonResult getWebSpreadtrumList(String key, String area, Page page) throws ParseException {
		int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		Integer allCounts = mipSpreadtrumMapper.countWebSpreadtrumList(key,area);
		page.setAllRow(allCounts);
		List<HashMap<String,Object>> temp  = mipSpreadtrumMapper.getWebSpreadtrumList(key,area,startRow, page.getSize());
		if(null != temp){
			for (int i = 0; i < temp.size(); i++) {
				HashMap<String,Object> map = temp.get(i);
				if(map.get("pictureId") != null){
					map.put("pictureId",config.getRootUrl()+map.get("pictureId"));
				}
				if(map.get("beginTime") != null){
					map.put("beginTime", new SimpleDateFormat("yyyy/MM/dd").format(map.get("beginTime")));
				}
				if(map.get("endTime") != null){
					map.put("endTime", new SimpleDateFormat("yyyy/MM/dd").format(map.get("endTime")));
					String endTime = (String) map.get("endTime");
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
					Date endDate = sdf.parse(endTime);
					long s1 = endDate.getTime();//将时间转为毫秒
					long s2 = System.currentTimeMillis();//得到当前的毫秒
					long  day = (s1-s2)/1000/60/60/24;
					if(day<0){
						map.put("day","已结束");
					}else{
						map.put("day",day);
					}
				}
			}
		}
		return new JsonResult(1,temp,page);
	}

}
