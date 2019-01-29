package com.tj720.mip.controller.publish;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.common.util.Utils;
import com.tj720.admin.service.ActivityService;
import com.tj720.admin.service.CmsArticleService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.controller.BaseController;;
@Controller("activityControllerInterface")
@RequestMapping("/activity")
public class ActivityController extends BaseController{
	@Autowired
	ActivityService activityService;
	@Autowired
	private CmsArticleService articleService;
	@Autowired
	HttpServletRequest request;
	// 根据分类获取文章
			@RequestMapping(value="/getActivityListByType.do",produces={"application/json;charset=UTF-8"})
			@ResponseBody
			public JsonResult getArticleListByType(@RequestParam String activityCategory, @RequestParam(defaultValue = "10") int size,
					@RequestParam(defaultValue = "1") int currentPage) {
				try {
					// 分页page
					Page page = new Page();
					page.setSize(size);
					page.setCurrentPage(currentPage);
					// 判断是subjectId是否为空
					if (MyString.isEmpty(activityCategory)) {
						return  new JsonResult(0,"参数有误");
					}
					JsonResult jsonResult = activityService.getActivityListByType(activityCategory, null, page);
					return jsonResult;
					//return jsonResult;
				} catch (Exception e) {
					e.printStackTrace();
					return new JsonResult(0,"系统异常，请联系管理员！");
				}
			}
			
//			@RequestMapping(value="/getOtherArticleList.do",produces={"application/json;charset=UTF-8"})
//			@ResponseBody
//			public JsonResult getOtherArticleList(String id,String uniqueName) {
//				try {
//
////					List<ArticleDto> articleDtos = new ArrayList<ArticleDto>();				
//					// 判断是subjectId是否为空
//					if (MyString.isEmpty(uniqueName)) {
//						return new JsonResult(0,"参数不正确");
//					}				
//					List<ArticleDto> articleDtos = activityService.getOtherArticleListByUniqueName(id, uniqueName);				
//					JsonResult jsonResult = new JsonResult(1,articleDtos);
//					return jsonResult;
//					//return jsonResult;
//				} catch (Exception e) {
//					e.printStackTrace();
//					return new JsonResult(0,"系统异常，请联系管理员！");
//					//return new JsonResult(0, "系统异常");
//				}
//			}

			// 获取活动详情
			@RequestMapping(value="/getActivityById.do",produces={"application/json;charset=UTF-8"})
			@ResponseBody
			public JsonResult getActivityById(@RequestParam String activityId,String uniqueName,String type) {
				try {
					if (MyString.isEmpty(activityId)) {
						return new JsonResult(0,"参数错误，未选中正确的文章！");
					}
					HashMap activity = activityService.getActivityListById(activityId);
					HashMap data = new HashMap();
					//查询关联文章
					Page page = new Page();
					page.setSize(100);
					page.setCurrentPage(1);
					JsonResult jsonResult = activityService.getActivityListByType(uniqueName, null, page);
					HashMap beforeActivity =  new HashMap();
					HashMap currentActivity = new HashMap();
					HashMap afterActivity = new HashMap();
					int currentIndex = 0;
					if(!MyString.isEmpty(jsonResult)){
						List<HashMap> list = (List<HashMap>) jsonResult.getData();					
						for (int i = 0; i < list.size(); i++) {
							if(list.get(i).get("activityId").equals(activityId)){
								currentActivity = list.get(i);
								if(i==0 ){
									beforeActivity = null;
									if(list.size()!=1){
										afterActivity = list.get(i+1);
									}
									else{
										afterActivity = null;
									}
									break;
								}
								else if(i==list.size()-1){
									if(i != 0){
										beforeActivity = list.get(i-1);
									}
									else{
										beforeActivity = null;
									}
									afterActivity = null;
									break;
								}
								else{
									beforeActivity = list.get(i-1);								
									afterActivity = list.get(i+1);
									break;
								}
							}
						}
					}
					
					//若查询关联文章
					if(!MyString.isEmpty(type)){
						if(MyString.isEmpty(uniqueName)){
							return  new JsonResult(0,"参数错误！");
						}
						else{
							if(type.equals("0")){
								if(!beforeActivity.isEmpty()){
									JsonResult tempData = getActivityById(beforeActivity.get("activityId").toString(), uniqueName, null);
									return tempData;
								}else{
									return  new JsonResult(0,"未查询到数据！");
								}
							}
							else if(type.equals("1")){
								if(!afterActivity.isEmpty()){
									JsonResult tempData = getActivityById(afterActivity.get("activityId").toString(), uniqueName, null);
									return tempData;
								}else{
									return  new JsonResult(0,"未查询到数据！");
								}
							}
							
						}
					}
					//若查询详情页
					else{
						data.put("activity", activity);
						data.put("beforeActivity", false);
						data.put("afterActivity", false);
						if(null!=beforeActivity && !beforeActivity.isEmpty()){
							data.put("beforeActivity", true);
						}
						if(null!=afterActivity && !afterActivity.isEmpty()){
							data.put("afterActivity", true);
						}
						//查询评论
						String ipaddress = Utils.getIpAddr(request);
						HashMap<String,Object> comment = articleService.getCommentByArticleId(activityId);
						Integer count = articleService.countCommentByArticleId(activityId,ipaddress);
						boolean hasCommend = false;
						if(count>0){
							hasCommend = true;
							HashMap<String,Object> info = articleService.getCommentByArticleIdAndIp(activityId, ipaddress);
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
										
					return new JsonResult(1,data);
					//return new JsonResult(1, article);
				} catch (Exception e) {
					e.printStackTrace();
					return new JsonResult(0,"系统异常，请联系管理员！");
				}
			}
			
			
			// 获取亲子活动和学术讲座
			@RequestMapping(value="/getTwoActivity.do",produces={"application/json;charset=UTF-8"})
			@ResponseBody
			public JsonResult getTwoArticle(@RequestParam(defaultValue="1,2") String uniqueName) {
				if(MyString.isEmpty(uniqueName)){
					return new JsonResult(0,"传入参数有误，请联系管理员！");
				}
				try {			
					HashMap activitys = new HashMap();
					// 分页page
					
					if(uniqueName.contains(",")){
						String[] subjects = uniqueName.split(",");
						for (int i = 0; i < subjects.length; i++) {
							if(subjects[i].equals("1")){
								Page page = new Page();
								page.setSize(3);
								page.setCurrentPage(1);
								JsonResult tempActivity = activityService.getActivityListByType(subjects[i], null, page);
								activitys.put("qzhd", tempActivity);
							}
							else if(subjects[i].equals("2")){
								Page page = new Page();
								page.setSize(1);
								page.setCurrentPage(1);
								JsonResult tempActivity = activityService.getActivityListByType(subjects[i], null, page);
								activitys.put("xsjz", tempActivity);
							}
						}
					}	
					return new JsonResult(1,activitys);
					//return jsonResult;
				} catch (Exception e) {
					e.printStackTrace();
					return new JsonResult(0,"系统异常，请联系管理员！");
					//return new JsonResult(0, "系统异常");
				}
			}
}
