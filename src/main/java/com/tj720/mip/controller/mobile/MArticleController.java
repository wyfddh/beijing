package com.tj720.mip.controller.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dto.ArticleDto;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.dto.BjMuseumBaseInfo;
import com.tj720.mip.framework.JsonResult;
import com.tj720.admin.service.CmsArticleService;
import com.tj720.admin.service.GuideService;
//import com.tj720.admin.service.MipOrganizationService;
import com.tj720.mip.utils.Aes;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;

@Controller("articleMobileController")
@RequestMapping("/m/article")
public class MArticleController extends BaseController{
	@Autowired
	private CmsArticleService articleService;
	@Autowired
	HttpServletRequest request;
	// 根据分类获取文章
		@RequestMapping(value="/getArticleListByType.do",produces={"application/json;charset=UTF-8"})
		@ResponseBody
		public String getArticleListByType(String subjectId, @RequestParam(defaultValue = "10") int size,
				@RequestParam(defaultValue = "1") int currentPage) {
			try {
				// 分页page
				Page page = new Page();
				page.setSize(size);
				page.setCurrentPage(currentPage);
				List<ArticleDto> articleDtos = new ArrayList<ArticleDto>();
				JsonResult jsonResult = new JsonResult(1,articleDtos);
				// 判断是subjectId是否为空
				if (MyString.isEmpty(subjectId)) {
					return  "参数错误，未选中正确的分类！";
				}
				jsonResult = articleService.getArticleListByType(subjectId, page);
				JSONObject object = (JSONObject) JSONObject.toJSON(jsonResult);
				String str = object.toJSONString();
				return str;
				//return jsonResult;
			} catch (Exception e) {
				e.printStackTrace();
				return  "系统异常，请联系管理员！";
				//return new JsonResult(0, "系统异常");
			}
		}
		@RequestMapping(value="/getArticleListByUniqueType.do",produces={"application/json;charset=UTF-8"})
		@ResponseBody
		public String getArticleListByUniqueType(String uniqueName, @RequestParam(defaultValue = "10") int size,
				@RequestParam(defaultValue = "1") int currentPage) {
			try {
				// 分页page
				Page page = new Page();
				page.setSize(size);
				page.setCurrentPage(currentPage);
				List<ArticleDto> articleDtos = new ArrayList<ArticleDto>();
				JsonResult jsonResult = new JsonResult(1,articleDtos);
				// 判断是subjectId是否为空
				if (MyString.isEmpty(uniqueName)) {
					return  "参数错误，未选中正确的分类！";
				}		
				jsonResult = articleService.getArticleListByUniqueType1(uniqueName,null, page);
				JSONObject object = (JSONObject) JSONObject.toJSON(jsonResult);
				String str = object.toJSONString();
				return str;
				//return jsonResult;
			} catch (Exception e) {
				e.printStackTrace();
				return  "系统异常，请联系管理员！";
				//return new JsonResult(0, "系统异常");
			}
		}
		@RequestMapping(value="/getOtherArticleList.do",produces={"application/json;charset=UTF-8"})
		@ResponseBody
		public JsonResult getOtherArticleList(@RequestParam String id,@RequestParam String uniqueName, @RequestParam(defaultValue = "10") int size,
				@RequestParam(defaultValue = "1") int currentPage) {
			try {

//				List<ArticleDto> articleDtos = new ArrayList<ArticleDto>();				
				// 判断是subjectId是否为空
				if (MyString.isEmpty(uniqueName)) {
					return new JsonResult(0,"参数不正确");
				}	
				Page page = new Page();
				page.setSize(size);
				page.setCurrentPage(currentPage);
				List<ArticleDto> articleDtos = articleService.getOtherArticleListByUniqueName(id, uniqueName,page);				
				JsonResult jsonResult = new JsonResult(1,articleDtos);
				return jsonResult;
				//return jsonResult;
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(0,"系统异常，请联系管理员！");
				//return new JsonResult(0, "系统异常");
			}
		}

		// 获取文章详情
		@RequestMapping(value="/getArticleById.do",produces={"application/json;charset=UTF-8"})
		@ResponseBody
		public String getArticleById(String id,String uniqueName,String type) {
			try {
				HashMap data =  new HashMap();
				ArticleDto article = new ArticleDto();
				if (MyString.isEmpty(id)) {
					return  "参数错误，未选中正确的文章！";
				}
				article = articleService.getArticleById(id);
				if(MyString.isEmpty(article)){
					return "未查询到数据！";
				}
				//查询关联文章
				Page page = new Page();
				page.setSize(100);
				page.setCurrentPage(1);
				JsonResult jsonResult = articleService.getArticleListByUniqueType1(uniqueName, null, page);
				ArticleDto beforeArticle =  new ArticleDto();
				ArticleDto currentArticle = new ArticleDto();
				ArticleDto afterArticle = new ArticleDto();
				int currentIndex = 0;
				if(!MyString.isEmpty(jsonResult)){
					List<ArticleDto> list = (List<ArticleDto>) jsonResult.getData();					
					for (int i = 0; i < list.size(); i++) {
						if(list.get(i).getId().equals(id)){
							currentArticle = list.get(i);
							if(i==0){
								if(list.size()!=1){
									afterArticle = list.get(i+1);
								}
								else{
									afterArticle = null;
								}
								beforeArticle = null;
								break;
							} 
							else if(i==list.size()-1){
								if(i != 0){
									beforeArticle = list.get(i-1);
								}
								else{
									beforeArticle = null;
								}
								afterArticle = null;
								break;
							}
							else{
								beforeArticle = list.get(i-1);
								afterArticle = list.get(i+1);
								break;
							}
						}
					}
				}
				//若查询关联文章
				if(!MyString.isEmpty(type)){
					if(MyString.isEmpty(uniqueName)){
						return  "参数错误！";
					}
					else{
						if(type.equals("0")){
							if(beforeArticle != null){
								String tempData = getArticleById(beforeArticle.getId(), uniqueName, null);
								return tempData;
							}else{
								return  "未查询到数据！";
							}
						}
						else if(type.equals("1")){
							if(afterArticle != null){
								String tempData = getArticleById(afterArticle.getId(), uniqueName, null);
								return tempData;
							}else{
								return  "未查询到数据！";
							}
						}
						
					}
				}
				//若查询详情页
				else{
					data.put("article", article);
					data.put("beforeArticle", true);
					data.put("afterArticle", false);
					if(!MyString.isEmpty(beforeArticle)){
						data.put("beforeArticle", true);
					}
					if(!MyString.isEmpty(afterArticle)){
						data.put("afterArticle", true);
					}
					//查询评论
					String ipaddress = Utils.getIpAddr(request);
					HashMap<String,Object> comment = articleService.getCommentByArticleId(id);
					Integer count = articleService.countCommentByArticleId(id,ipaddress);
					boolean hasCommend = false;
					if(count>0){
						hasCommend = true;
						HashMap<String,Object> info = articleService.getCommentByArticleIdAndIp(id, ipaddress);
						String commendType = info.get("commendType").toString();
						comment.put("commendType", commendType);
					}
					if(null != comment){
						comment.put("hasCommend", hasCommend);
						data.put("comment", comment);
					}else{
						comment = new HashMap<String,Object>();
						comment.put("hasCommend", hasCommend);
						data.put("comment", comment);
					}
				}
				JsonResult result = new JsonResult(1,data);
				JSONObject object = (JSONObject) JSONObject.toJSON(result);
				if(MyString.isEmpty(object)){
					return "未查询到数据！";
				}
				String str = object.toJSONString();
				return str;
			} catch (Exception e) {
				e.printStackTrace();
				return  "系统异常，请联系管理员！";
			}
		}
		/***
		 * 获取研究首页
		 * @param uniqueName yj
		 * @returnw
		 */
		@RequestMapping(value="/getThreeArticle.do",produces={"application/json;charset=UTF-8"})
		@ResponseBody
		public String getArticleBySubject(@RequestParam(defaultValue = "yj") String uniqueName) {
			if(MyString.isEmpty(uniqueName)){
				return  "传入参数有误，请联系管理员！";
			}
			try {			
				// 分页page
				
				List<Map<String,Object>> subjects = articleService.getChildrenSubject(uniqueName);
				JSONObject articles = new JSONObject();				
				if(!subjects.isEmpty() && subjects.size()>0){
					for (int i = 0; i < subjects.size(); i++) {
						if(subjects.get(i).get("uniqueName").equals("xssk")){
							Page page = new Page();
							page.setCurrentPage(1);
							page.setSize(4);
							List<ArticleDto> tempArticle = (List<ArticleDto>) articleService.getArticleList(subjects.get(i).get("subjectId").toString(),page);
							JsonResult jsonResult = new JsonResult(1,tempArticle,page);
							articles.put("xssk", jsonResult);
						}
						else if(subjects.get(i).get("uniqueName").equals("xslw")){
							Page page = new Page();
							page.setCurrentPage(1);
							page.setSize(8);
							List<ArticleDto> tempArticle = (List<ArticleDto>) articleService.getArticleList(subjects.get(i).get("subjectId").toString(),page);
							JsonResult jsonResult = new JsonResult(1,tempArticle,page);
							articles.put("xslw", jsonResult);
						}
						else if(subjects.get(i).get("uniqueName").equals("zjwt")){
							Page page = new Page();
							page.setCurrentPage(1);
							page.setSize(3);
							List<ArticleDto> tempArticle = (List<ArticleDto>) articleService.getArticleList(subjects.get(i).get("subjectId").toString(),page);
							JsonResult jsonResult = new JsonResult(1,tempArticle,page);
							articles.put("zjwt", jsonResult);
						}
						
					}
				}	
				if(MyString.isEmpty(articles)){
					return "未查询到数据!";
				}
				String str = articles.toJSONString();
				return str;
				//return jsonResult;
			} catch (Exception e) {
				e.printStackTrace();
				return  "系统异常，请联系管理员！";
				//return new JsonResult(0, "系统异常");
			}
		}
		
		// 文博资讯单独接口  取资讯和公告两种数据
		@RequestMapping(value="/getTwoArticle.do",produces={"application/json;charset=UTF-8"})
		@ResponseBody
		public String getTwoArticle(@RequestParam(defaultValue = "zx") String uniqueName) {
			if(MyString.isEmpty(uniqueName)){
				return  "传入参数有误，请联系管理员！";
			}
			try {			
				// 分页page				
				List<Map<String,Object>> subjects = articleService.getChildrenSubject(uniqueName);
				JSONObject articles = new JSONObject();				
				if(!subjects.isEmpty() && subjects.size()>0){
					for (int i = 0; i < subjects.size(); i++) {
						if(subjects.get(i).get("uniqueName").equals("xwdt")){
							Page page = new Page();
							page.setSize(4);
							page.setCurrentPage(1);
							List<ArticleDto> tempArticle = articleService.getArticleList(subjects.get(i).get("subjectId").toString(),page);
							JsonResult jsonResult = new JsonResult(1,tempArticle,page);							
							articles.put("xwdt", jsonResult);
						}
						else if(subjects.get(i).get("uniqueName").equals("tzgg")){
							Page page = new Page();
							page.setSize(4);
							page.setCurrentPage(1);
							List<ArticleDto> tempArticle =  articleService.getArticleList(subjects.get(i).get("subjectId").toString(),page);
							JsonResult jsonResult = new JsonResult(1,tempArticle,page);
							articles.put("tzgg", jsonResult);
						}
						
					}
				}		
				if(MyString.isEmpty(articles)){
					return "未查询到数据!";
				}
				String str = articles.toJSONString();
				return str;
				//return jsonResult;
			} catch (Exception e) {
				e.printStackTrace();
				return  "系统异常，请联系管理员！";
				//return new JsonResult(0, "系统异常");
			}
		}
		
		/**
		 * 设置文章/活动评论
		 * @param id
		 * @param type
		 * @return
		 */
		@RequestMapping(value="/setComment.do",produces={"application/json;charset=UTF-8"})
		@ResponseBody
		public JsonResult setComment(@RequestParam String id,@RequestParam String type) {
			String ipaddress = Utils.getIpAddr(request);
			if(null == ipaddress){
				return new JsonResult(0,"请求非法");
			}
			try {
				if (MyString.isEmpty(id)) {
					return new JsonResult(0,"参数不正确");
				}				
				Integer count = articleService.countCommentByArticleId(id,ipaddress);
				HashMap<String,Object> data = new HashMap<String,Object>();
				if(count == 0){						
						int result = articleService.insertComment(id,ipaddress,type);
						if(result == 1){
							data = articleService.getCommentByArticleId(id);
						}
						else{
							return new JsonResult(0,"您已评论过，请勿重复评论");
						}
					}
				else{
					int result = articleService.updateComment(id,ipaddress,type);
					data = articleService.getCommentByArticleId(id);
					if(result == 1){
						data = articleService.getCommentByArticleId(id);
					}
					else{
						return new JsonResult(0,"系统异常");
					}
				}
				JsonResult jsonResult = new JsonResult(1,data);
				return jsonResult;
				//return jsonResult;
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(0,"系统异常，请联系管理员！");
				//return new JsonResult(0, "系统异常");
			}
		}
		/**
		 * 获取文章/活动的评论
		 * @param id
		 * @return
		 */
		@RequestMapping(value="/getComment.do",produces={"application/json;charset=UTF-8"})
		@ResponseBody
		public JsonResult getComment(@RequestParam String id){
			String ipaddress = Utils.getIpAddr(request);
			if(null == ipaddress){
				return new JsonResult(0,"请求非法");
			}
			try{
				HashMap<String,Object> data = articleService.getCommentByArticleId(id);
				Integer count = articleService.countCommentByArticleId(id,ipaddress);
				//当前请求是否已经评论过
				boolean hasCommend = false;
				if(count>0){
					hasCommend = true;
				}
				data.put("hasCommend", hasCommend);
				return new JsonResult(1,data);
			}catch(Exception e){
				e.printStackTrace();
				return new JsonResult(0,e.getMessage());
			}
		}
		

}
