/** 
 * <pre>项目名称:mip 
 * 文件名称:OtherSpreadtrumController.java 
 * 包名:com.tj720.mip.controller.content 
 * 创建日期:2017年2月13日上午11:07:25 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.controller.content;

import java.io.IOException; 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.dto.MipOrganizationDto;
import com.tj720.mip.framework.ErrorInfos;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.OutsideAndAbroadService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.OutsideAndAbroad;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.Spreadtrum;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.PictureService;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.DateFormartUtil;
import com.tj720.mip.utils.HqlWhere;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/** 
 * <pre>项目名称：mip    
 * 类名称：OtherSpreadtrumController    
 * 类描述：    其他展讯的控制层(包括省外跟国外的展讯)
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月13日 上午11:07:25    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月13日 上午11:07:25    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("otherSpreadtrum")
public class OtherSpreadtrumController extends BaseController<OutsideAndAbroad>{
	@Autowired
	private OutsideAndAbroadService otherSpreadtrumService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private UserService userService;
	@Autowired
	private PictureService pictureService;//图片表的service
	@Autowired
	private Config config;//常量的取法
	/**
	 * <pre>getSpreadtrum(后台查询省外跟国外的展讯列表)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年2月13日 上午11:09:51    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年2月13日 上午11:09:51    
	 * 修改备注： 
	 * @param spreadtrum
	 * @param currentPage
	 * @param size
	 * @return
	 * @throws MyException</pre>
	 */
	@RequestMapping("getOtherSpreadtrum")
	//@AuthPassport
	public String getOtherSpreadtrum(@ModelAttribute OutsideAndAbroad otherSpreadtrum,@RequestParam(defaultValue="1" ,name="page") Integer currentPage,String keys,ModelMap modelMap) throws MyException{
		//发布单位只有省级和地级才有此输入框-------------未完成
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Page page= new Page(15);
		page.setCurrentPage(currentPage);
		Long staTime = null;
		Long endTime = null;
		if(otherSpreadtrum.getStaTime() != null && !otherSpreadtrum.getStaTime().equals("")){
			staTime = Long.valueOf(HqlWhere.transform_date(otherSpreadtrum.getStaTime()));
		}
		if(otherSpreadtrum.getOverTime() != null && !otherSpreadtrum.getOverTime().equals("")){
			endTime = Long.valueOf(HqlWhere.transform_date(otherSpreadtrum.getOverTime()));
		}
		String seachhql = otherSpreadtrumService.getSeachHql(otherSpreadtrum,keys,staTime,endTime);
		@SuppressWarnings("unchecked")
		List<OutsideAndAbroad> outList = (List<OutsideAndAbroad>) otherSpreadtrumService.queryByHql(seachhql, Tools.getMap(), page);
//		图片表数据
		/*List<Picture> piList = new ArrayList<Picture>();
		for (OutsideAndAbroad out : outList) {
			//图片表数据
			if(!MyString.isEmpty(out.getId())){
				Picture picture = pictureService.get(out.getPicture());
				piList.add(picture);
			}
		}*/
		for (OutsideAndAbroad spr : outList) {
			if(spr.getBeginTime() != null && spr.getBeginTime()!= 0){
				java.util.Date date = new java.util.Date(spr.getBeginTime() * 1000);
				spr.setStaTime(sim.format(date));
			}
			if(spr.getEndTime() != null && spr.getEndTime()!= 0){
				java.util.Date date = new java.util.Date(spr.getEndTime() * 1000);
				spr.setOverTime(sim.format(date));
			}
			if(spr.getPublishTime() != null && spr.getPublishTime()!= 0){
				java.util.Date date = new java.util.Date(spr.getPublishTime() * 1000);
				spr.setIssueTime(sim.format(date));
			}
			if(spr.getUserName() != null && !spr.getUserName().equals(0)){
				User user = userService.get(spr.getUserName());
				spr.setNickName(user.getNickName());
			}
		}
		JsonResult otherSpreList = new JsonResult(1,outList,page,
				Tools.getMap("publish", otherSpreadtrum.getPublish(),"userName" ,otherSpreadtrum.getUserName(),
						     "content|like",keys,"headline|or",keys,"beginTime",staTime,"endTime",
						     endTime,"type",otherSpreadtrum.getType(),"musExhibition|or",keys));
		modelMap.put("otherSpreList", otherSpreList);
		modelMap.put("otherSpreadtrum", otherSpreadtrum);
		modelMap.put("keys", keys);
		modelMap.put("pcRootPath", config.getPcRootpath());
		if(otherSpreadtrum.getType() == 1){
			return "/WEB-INF/back/content/other_spre_list.jsp";
		}
		return "/WEB-INF/back/content/abroad/abroad_spre_list.jsp";
	}
	//前台查询展讯的列表
	@RequestMapping("getReceptionSpreadtrum")
	@ResponseBody
	//@AuthPassport
	public JsonResult getReceptionSpreadtrum(@ModelAttribute OutsideAndAbroad otherSpreadtrum,@RequestParam(defaultValue="1") Integer currentPage){

		Page page= new Page(6);
		page.setCurrentPage(currentPage);
		//0是未发布(取消发布)状态,1是发布状态
		Map<String,Object> new_map = Tools.getMap("publish", 1,"type",otherSpreadtrum.getType());
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		List<OutsideAndAbroad> otherSpreList = otherSpreadtrumService.findByMap(new_map," new OutsideAndAbroad(id, headline,beginTime, endTime, musExhibition, content,picture,type) ", page,null);
		List<Picture> piList = new ArrayList<Picture>();
		for (OutsideAndAbroad out : otherSpreList) {
			//图片表数据
			if(!MyString.isEmpty(out.getId())){
				Picture picture = pictureService.get(out.getPicture());
				piList.add(picture);
			}
		}
		for (OutsideAndAbroad outSprea : otherSpreList) {
			if(outSprea.getBeginTime() != null && outSprea.getEndTime()!= null){
				outSprea.setStaTime("");
				outSprea.setOverTime("");
			}
			String content = outSprea.getContent();
			if(content != null && !content.equals("")){
				String txtcontent = content.replaceAll("<[^>]*>", ""); //剔出<html>的标签  
		        txtcontent = txtcontent.replaceAll("<a>\\s*|\t|\r|\n</a>", "");//去除字符串中的空格,回车,换行符,制表符  
		        outSprea.setContent(txtcontent);
			}
		}
		if(piList.size() > 1){
			for (Picture picture : piList) {
				for (OutsideAndAbroad outside : otherSpreList) {
					if(!MyString.isEmpty(picture.getId())){
						if (picture.getId().equals(String.valueOf(outside.getPicture()))) {
							outside.setPictureThumb(config.getRootUrl()+picture.getUrl());
						}
					}
				}
			}
		}
		if(page.getTotalPage() < currentPage){
			otherSpreList.clear();
		}
		return new JsonResult(1,otherSpreList,page,null);
	}
	
	//前台详情查看
	@RequestMapping("getOneData")
	@ResponseBody
	//@AuthPassport
	public JsonResult getOneData(@ModelAttribute OutsideAndAbroad otherSpreadtrum,@RequestParam(defaultValue="1") Integer type) throws MyException{
		OutsideAndAbroad model = null;
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		if(!MyString.isEmpty(otherSpreadtrum.getId())){
			if(!otherSpreadtrum.getId().equals(Const.NULL_ID)){
					model= otherSpreadtrumService.get(otherSpreadtrum.getId());
					model.setStaTime("");
					model.setOverTime("");
					if(model.getUserName() != null && !model.getUserName().equals("")){
						User user = userService.get(model.getUserName());
						model.setNickName(user.getNickName());
					}
					if(!MyString.isEmpty(model.getPicture())){
						Picture picture = pictureService.get(model.getPicture());
						model.setPictureThumb(config.getRootUrl()+picture.getUrl());
					}
			}else{
				return new JsonResult(1,ErrorInfos.getMessage("111113"));
			}
		}
		Map<String,Object> dateMap = new HashMap<>();
		dateMap.put("headline",model.getHeadline() );
		dateMap.put("staTime",model.getStaTime() );
		dateMap.put("overTime", model.getOverTime());
		dateMap.put("musExhibition", model.getMusExhibition());
		dateMap.put("picture", model.getPictureThumb());
		if(type == 1){
			dateMap.put("content", model.getContent());
			return new JsonResult(1,dateMap);
		}
		if(type == 2 && model.getContent() != null && !model.getContent().equals("")){
			String txtcontent = model.getContent().replaceAll("<[^>]*>", ""); //剔出<html>的标签  
	        txtcontent = txtcontent.replaceAll("</?(?!img|/?br|h\\d)[^>]+>", "");//去除字符串中的空格,回车,换行符,制表符  
	        model.setContent(txtcontent);
	        dateMap.put("content", model.getContent());
	        return new JsonResult(1,dateMap);
		}
		return new JsonResult(1,ErrorInfos.getMessage("111116"));
	}
	//删除一条信息
	@RequestMapping("deleteSpreadtrum")
	@ResponseBody
	@AuthPassport(authority="contentAdmin")
	public void deleteSpreadtrum(@ModelAttribute OutsideAndAbroad otherSpreadtrum){
//			0取消发布,1发布
		OutsideAndAbroad model = null;
		if(!otherSpreadtrum.getId().equals(Const.NULL_ID)){
			model= otherSpreadtrumService.get(otherSpreadtrum.getId());
		}
		if(model != null){
			if(model.getPublish() == 0){
				otherSpreadtrumService.delete(otherSpreadtrum);
			} 
		}
	}
	/**
	 * <pre>addAndUpdate(修改或者增加的方法)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年2月13日 下午1:59:46    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年2月13日 下午1:59:46    
	 * 修改备注： 
	 * @param spreadtrum
	 * @return
	 * @throws MyException
	 * @throws IOException</pre>
	 */
	@RequestMapping("addOrUpdate")
	@AuthPassport(authority="contentAdmin")
	public String addOrUpdate(@ModelAttribute OutsideAndAbroad otherSpreadtrum,Model map){
		OutsideAndAbroad  model = null;
		if(!MyString.isEmpty(otherSpreadtrum.getId())){
			if(!otherSpreadtrum.getId().equals(Const.NULL_ID)){
				model= otherSpreadtrumService.get(otherSpreadtrum.getId());
				//未发布数据
				if(model.getPublish() == 0 && model.getPublish() != 1){
					if(otherSpreadtrum.getStaTime() != null && !otherSpreadtrum.getStaTime().equals("")){
						otherSpreadtrum.setBeginTime(Long.valueOf(HqlWhere.transform_date(otherSpreadtrum.getStaTime())));
					}
					if(otherSpreadtrum.getOverTime() != null && !otherSpreadtrum.getOverTime().equals("")){
						otherSpreadtrum.setEndTime(Long.valueOf(HqlWhere.transform_date(otherSpreadtrum.getOverTime())));
					}
					otherSpreadtrum.setPublish(model.getPublish());
					otherSpreadtrum.setCreateTime(model.getCreateTime());
					otherSpreadtrumService.update(otherSpreadtrum);
				}
			}
		}else{
			otherSpreadtrum.setPublish((byte) 0);
			if(otherSpreadtrum.getStaTime() != null && !otherSpreadtrum.getStaTime().equals("")){
				otherSpreadtrum.setBeginTime(Long.valueOf(HqlWhere.transform_date(otherSpreadtrum.getStaTime())));
			}
			if(otherSpreadtrum.getOverTime() != null && !otherSpreadtrum.getOverTime().equals("")){
				otherSpreadtrum.setEndTime(Long.valueOf(HqlWhere.transform_date(otherSpreadtrum.getOverTime())));
			}
			otherSpreadtrum.setUserName(Tools.getUser().getId());
			otherSpreadtrumService.save(otherSpreadtrum);
			Picture picture = pictureService.get(otherSpreadtrum.getPicture());
			picture.setObjectId(otherSpreadtrum.getId());
			pictureService.update(picture);
		}
		map.addAttribute("type",otherSpreadtrum.getType());
		return "redirect:/otherSpreadtrum/getOtherSpreadtrum.do";
	}
	
	/**
	 * <pre>updatePublish(发布/取消发布的方法)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年2月13日 下午4:10:12    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年2月13日 下午4:10:12    
	 * 修改备注： 
	 * @param spreadtrum
	 * @return</pre>
	 */
	@RequestMapping("updatePublish")
	@ResponseBody
	@AuthPassport(authority="contentAdmin")
	public String updatePublish(@ModelAttribute OutsideAndAbroad otherSpreadtrum){
		OutsideAndAbroad model = null;
		if(!MyString.isEmpty(otherSpreadtrum.getId())){
			if(!otherSpreadtrum.getId().equals(Const.NULL_ID)){
				model= otherSpreadtrumService.get(otherSpreadtrum.getId());
				if(model.getPublish() == 0){
					model.setPublish((byte)1);
					model.setPublishTime(new Date().getTime() / 1000);
					try {
						otherSpreadtrumService.update(model);
					} catch (Exception e) {
						return "/WEB-INF/back/error.jsp";
					}
				} else if(model.getPublish() == 1){
					model.setPublish((byte)0);
					model.setPublishTime((long)0);
					try {
						otherSpreadtrumService.update(model);
					} catch (Exception e) {
						return "/WEB-INF/back/error.jsp";
					}
				}
			}
		}
		return "success"; 
	}
	
	//跳转到增加页面
	@RequestMapping("toOutSpreAdd")
	@AuthPassport(authority="contentAdmin")
	public String toOutSpreAdd(@ModelAttribute OutsideAndAbroad otherSpreadtrum,ModelMap map){
		User user = userService.get(Tools.getUser().getId());
		if(otherSpreadtrum.getType() == 1){
			map.put("nickName", user.getNickName());
			return "/WEB-INF/back/content/other_spre_add.jsp";
		}
		map.put("nickName", user.getNickName());
		return "/WEB-INF/back/content/abroad/abroad_spre_add.jsp";
	}
	//后台  修改前的回显
	@RequestMapping("getOutSprInfo")
	//@AuthPassport
	@AuthPassport(authority="contentAdmin")
	public String getOutSprInfo(@ModelAttribute OutsideAndAbroad otherSpreadtrum,ModelMap modelMap) throws MyException{
		OutsideAndAbroad model = null;
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		if(!MyString.isEmpty(otherSpreadtrum.getId())){
			if(!otherSpreadtrum.getId().equals(Const.NULL_ID)){
					model= otherSpreadtrumService.get(otherSpreadtrum.getId());
					if(model.getBeginTime() != null && model.getBeginTime()!= 0){
						java.util.Date date = new java.util.Date(model.getBeginTime() * 1000);
						model.setStaTime(sim.format(date));
					}
					if(model.getEndTime() != null && model.getEndTime()!= 0){
						java.util.Date date = new java.util.Date(model.getEndTime() * 1000);
						model.setOverTime(sim.format(date));
					}
					if(model.getUserName() != null && !model.getUserName().equals("")){
						User user = userService.get(model.getUserName());
						model.setNickName(user.getNickName());
					}
					if(!MyString.isEmpty(model.getPicture())){
						Picture picture = pictureService.get(model.getPicture());
						model.setPictureThumb(config.getRootUrl()+picture.getUrl());
					}
			}else{
				return "/WEB-INF/back/error.jsp";
			}
		}
		modelMap.put("otherSpre", model);
		return "/WEB-INF/back/content/other_spre_Info.jsp";
	}
	
	
	
}
