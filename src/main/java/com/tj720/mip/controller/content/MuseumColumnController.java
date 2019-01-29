/** 
 * <pre>项目名称:mip  
 * 文件名称:MuseumColumnController.java 
 * 包名:com.tj720.mip.controller.content 
 * 创建日期:2017年1月18日下午3:59:30 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.controller.content;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tj720.mip.model.MuseumSubject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IMuseumSubject;
import com.tj720.mip.inter.service.table.MuseumColumnService;
import com.tj720.mip.inter.service.table.MuseumInfoService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MuseumColumn;
import com.tj720.mip.model.MuseumInfo;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/** 
 * <pre>项目名称：mip    
 * 类名称：MuseumColumnController    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月18日 下午3:59:30    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月18日 下午3:59:30    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("museumColumn")
public class MuseumColumnController {
	@Autowired
	private IMuseumSubject museumSubject;//博物馆信息
	@Autowired
	private MuseumColumnService columnService;
	@Autowired
	private UserService userService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private MuseumInfoService museumInfoService;//博物馆信息
	//后台查看栏目列表
	//@AuthPassport
	//传的是博物馆的id
	@RequestMapping("getMuseumColumn")
	public String getMuseumColumn(ModelMap map,HttpServletRequest request){
		Object museumInfoId = request.getSession().getAttribute("museumInfoId");
		String orgId = "";
		if(museumInfoId != null){
			String museumId = museumInfoId.toString();
			MuseumInfo museumInfo = museumInfoService.get(museumId);
			orgId = museumInfo.getOrgId().toString();
		}
		if(museumInfoId == null){
			User user = userService.get(Tools.getUser().getId());
			if (!MyString.isEmpty(user)) {
				orgId = user.getOrgId();
			}
		}
		
		MipOrganization orga = mipOrganizationService.get(orgId);
		
		
		
		List<MuseumInfo> museumList = null;
		if(!MyString.isEmpty(orga.getId())){
			museumList = museumInfoService.findByMap(Tools.getMap("orgId",orga.getId()), " new MuseumInfo(id,museumName,introduce,buyTicket, "
					+ "nearby,visitNotes, serviceInformation, orgId,spreOpen,virOpen) ", null, null);
		}
		if(museumList.size() > 0){
			map.put("museum", museumList.get(0));
		}
		return "/WEB-INF/back/content/museum/museum_column.jsp";
	}
	
	//把开启的栏目抛向前台
	@RequestMapping("selectMuseumColumn")
	@ResponseBody
	//@AuthPassport
	public JsonResult selectMuseumColumn() throws MyException{
		Page page= new Page(15);
		//测试的时候写1,后面就是哪个博物馆来我开哪个  =============需要改
		Map<String,Object> map = Tools.getMap("comuseum", 1);
		return new JsonResult(1,columnService.findByMap(map," new MuseumColumn( coName, coType, coModel, comanage, comuseum) ",page,null),page,
				Tools.getMap("comuseum", 1));
	}
	
	
	
	//跳转馆内藏品
	@RequestMapping("toObjectPage")
	public String toObjectPage(){
		//一普藏品的页面
		return "redirect:/***/***.do";
	}
	
	
	//跳转展览管理页面
	@RequestMapping("toSpreadtrumPage")
	public String toSpreadtrumPage(){
		//展览管理的页面
		return "redirect:/spreadtrum/getSpreadtrum.do";
	}
	
	
	//跳转虚拟展厅列表
	@RequestMapping("toVirtualPage")
	public String toVirtualPage(){
		return "redirect:/virtual/getVirtual.do";
	}
	
	//文章模型栏目单条的查看
	@ResponseBody
	@RequestMapping("getArticleType")
	//@AuthPassport
	public JsonResult getArticleType(@ModelAttribute MuseumColumn column) throws MyException{
		MuseumColumn model;
		if(!column.getId().equals(Const.NULL_ID)){
			model= columnService.get(column.getId());
			//hasPermission( cacheService.getProject(model.getProjectId()), view);
		}else{
			model=new MuseumColumn();
		}
		return new JsonResult(1,model);
	}
	
	
	//编辑文章模型
	@ResponseBody
	@RequestMapping("updateArticleType")
	public void updateArticleType(@ModelAttribute MuseumColumn column){
		if(!MyString.isEmpty(column.getId())){
			columnService.update(column);
		}
	}

	//内部人员新建栏目
	@ResponseBody
	@RequestMapping("addMuColumn")
	//@AuthPassport
	//传的是所有模型的值(下拉列表框1-->文章模型2--->列表模型)
	public JsonResult addMuColumn(Integer coModel) throws MyException{
		Map<String,Object> map = Tools.getMap("coModel", coModel);
		return new JsonResult(1,columnService.findByMap(map," new MuseumColumn( coName, coType, coModel, comanage) ",null,null),null,
				Tools.getMap("comuseum", coModel));
	}
	
	
	
	//---------------------------------------------------------审核未定
	
	
	
	//向前台抛的数据(审核已通过的)
	//编辑文章模型--等待需求
	@RequestMapping("updateSpreOpen")
	@ResponseBody
	public String updateSpreOpen(@ModelAttribute MuseumInfo  museum){
		MuseumInfo model = null;
		if(!MyString.isEmpty(museum.getId())){
			if(!museum.getId().equals(Const.NULL_ID)){
				model= museumInfoService.get(museum.getId());
				//未发布数据
					if(model.getSpreOpen() == 1){
						model.setSpreOpen((byte)0);
						try {
							museumInfoService.update(model);
							/*String sql = " update mip_spreadtrum set `status` = -128 ";
							museumInfoService.updateStatus(sql);*/
							String sql = " update Spreadtrum set publish = 0 where orgId = "+museum.getOrgId();
							museumInfoService.update(sql, Tools.getMap());
						} catch (Exception e) {
							return "/WEB-INF/back/error.jsp";
						}
					} else if(model.getSpreOpen() == 0){
						model.setSpreOpen((byte)1);
						try {
							museumInfoService.update(model);
//							String sql = " update Spreadtrum set status = -127 ";
//							museumInfoService.update(sql, Tools.getMap());
						} catch (Exception e) {
							return "/WEB-INF/back/error.jsp";
						}
					}
			}
		}
		return "success"; 
	}
	@RequestMapping("updateVirOpen")
	@ResponseBody
	public String updateVirOpen(@ModelAttribute MuseumInfo  museum){
		MuseumInfo model = null;
		if(!MyString.isEmpty(museum.getId())){
			if(!museum.getId().equals(Const.NULL_ID)){
				model= museumInfoService.get(museum.getId());
				//未发布数据
				if(model.getVirOpen() == 1){
					model.setVirOpen((byte)0);
					try {
						museumInfoService.update(model);
						String sql = " update VirtualShowroom set publish = 0 where orgId = "+museum.getOrgId();
						museumInfoService.update(sql, Tools.getMap());
					} catch (Exception e) {
						return "/WEB-INF/back/error.jsp";
					}
				} else if(model.getVirOpen() == 0){
					model.setVirOpen((byte)1);
					try {
						museumInfoService.update(model);
//						String sql = " update VirtualShowroom set status = -127 ";
//						museumInfoService.update(sql, Tools.getMap());
					} catch (Exception e) {
						return "/WEB-INF/back/error.jsp";
					}
				}
			}
		}
		return "success"; 
	}
	
	
	@RequestMapping("toUpdatePage")
	public String toUpdatePage(String title,String name,String id,ModelMap modelMap){
		User user = userService.get(Tools.getUser().getId());
		MipOrganization orga = mipOrganizationService.get(user.getOrgId());
		List<Map> museumList = null;
		List<MuseumSubject> subjectList = null;
		if(!MyString.isEmpty(orga.getId())){
//			String hql = "select new map("+name+" as name) from MuseumSubject where id = '"+id+"' ";
//			System.out.println("hql:"+hql);
//			museumList = museumSubject.getAttr(hql);
			subjectList = museumSubject.findByMap(Tools.getMap("id",id), " new MuseumSubject(id,orgId,name,description,subjectType,"
					+ "modelType,pId, createTime, status,sequence,createTime) ", null, null);
		}
		if(subjectList.size() > 0){
			modelMap.put("museumList", subjectList.get(0).getDescription());
			modelMap.put("name", subjectList.get(0).getDescription());
		}
		modelMap.put("title", title);
		modelMap.put("id", id);
		return "/WEB-INF/back/content/museum/column_Info.jsp";
	}
	
	
	@RequestMapping("updateMuseumColumn")
	public String updateMuseumColumn(String name, String value,String id){
  		MuseumInfo model = null;
  		List<MuseumSubject> subjectList = null;
//			String hql = "select new map("+name+" as name) from MuseumSubject where id = '"+id+"' ";
//			System.out.println("hql:"+hql);
//			museumList = museumSubject.getAttr(hql);
  		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String data = sdf.format(new Date());
			subjectList = museumSubject.findByMap(Tools.getMap("id",id), " new MuseumSubject(id,orgId,name,description,subjectType,"
					+ "modelType,pId, createTime, status,sequence,createTime) ", null, null);
			if(subjectList.size()>0){
				MuseumSubject ms = new MuseumSubject();
				ms.setId(subjectList.get(0).getId());
				ms.setName(subjectList.get(0).getName());
				ms.setOrgId(subjectList.get(0).getOrgId());
				ms.setStatus(subjectList.get(0).getStatus());
				ms.setSequence(subjectList.get(0).getSequence());
				ms.setDescription(value);
				ms.setUpdatedTime(data);
				museumSubject.update(ms);
			}
//		if(!MyString.isEmpty(id)){
//			if(!id.equals(Const.NULL_ID)){
//				model= museumInfoService.get(id);
//				if(!MyString.isEmpty(value)){
//					String sql = " update MuseumSubject set description = :"+value+" where id = :id";
//					museumSubject.update(sql, Tools.getMap(name,value,"id",id));
//				} else {
//					String sql = " update MuseumSubject set "+name+" = null where id =  '"+id+"'";
//					museumSubject.update(sql, Tools.getMap());
//					
//				}
//				
//			}
//		}
		return "redirect:/museuminfo/getMuseumPage.do";
	}
	
	@RequestMapping("delMuseumColumn")
 	public String delMuseumColumn(@RequestParam("id") String id) {
		
		MuseumSubject ms = new MuseumSubject();
		ms.setId(id); 
		museumSubject.delete(ms);
		return "redirect:/museuminfo/getMuseumPage.do";  
	}
	
	
}
