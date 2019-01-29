package com.tj720.mip.controller.back;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IMipOpenFossilInfoService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IPictureSearchConfigService;
import com.tj720.mip.inter.service.table.IPictureSearchSetService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.PictureSearchConfig;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.PictureSearchUtil;
import com.tj720.mip.utils.ImageSearchThread;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/back/pictureSearch")
public class PictureSearchController extends BaseController<Picture> {
	private ImageSearchThread thread=null;

	@Autowired
	private IPictureSearchConfigService pictureSearchConfigService;
	@Autowired
	private IPictureSearchSetService pictureSearchSetService;
	@Autowired
	private IPictureService pictureService;
	@Autowired
	private IMipOpenCulturalrelicInfoService collectionService;
	@Autowired
	private IMipOpenFossilInfoService fossilService;
	@Autowired
	private Config config;
	@Autowired
	private UserService userService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;

	private Double process=0.0;
	private String threadStatus="";
	private String status="未开始";
	private String message="";
	private String error="";
	/**
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/index.do")
	@ResponseBody
	public ModelAndView index() throws MyException {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/picture/picturesearch.jsp");
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = us.getOrgId();
		MipOrganization org = mipOrganizationService.get(orgId);
		//查询组织机构的级别
		byte level = org.getLevel();
		mod.addObject("level", level);
		return mod;
	}
	@RequestMapping("/start.do")
	@ResponseBody
	public String start(String setPercentage) throws MyException {
//		CollectionAttributesDto attrs=new CollectionAttributesDto();
//		String hql = "SELECT new com.tj720.mip.dto.CollectionAttributesDto(c.name AS collectionsCategory,o.gsNo,o.name,o.formerly,o.foreignName,"
//				+ "y.pathName as yearType) FROM MipOpenCulturalrelicInfo o, CollectionCategory c,YearType y where o.collectionsCategory=c.id AND "
//				+ "o.yearType=y.id AND o.isOpen >0 AND o.status > 0";
//		attrs=(CollectionAttributesDto)collectionService.getDtoByHql(hql);
		PictureSearchConfig searchConfig=pictureSearchConfigService.get("1");
		if(!PictureSearchUtil.checkConfig(searchConfig))
			PictureSearchUtil.setConfig(searchConfig);
		searchConfig.setSetPercentage(new Integer(setPercentage));
		pictureSearchConfigService.update(searchConfig);
		if(MyString.isEmpty(thread))
			thread=new ImageSearchThread();
		if(thread.getState()==Thread.State.NEW){
			thread.pictureSearchConfigService=pictureSearchConfigService;
			thread.searchConfig=searchConfig;
			thread.pictureSearchSetService=pictureSearchSetService;
			thread.pictureService=pictureService;
			thread.collectionService=collectionService;
			thread.fossilService=fossilService;
			thread.rootPath=config.getRootPath()+"csv/";
			thread.rootUrl=config.getRootUrl();
			thread.setPriority(10);
			thread.start();
		}
		return "1";
	}
	@RequestMapping("/status.do")
	@ResponseBody
	public HashMap<String,String> status() throws MyException {
		HashMap<String,String>result=new HashMap<String,String>();
		if(MyString.isEmpty(thread)){
			result.put("process", new Double(process).toString());
			result.put("status", status);
			result.put("message", message);
			result.put("error", error);
			result.put("threadStatus", threadStatus);
		}else{
			result.put("process", new Double(thread.process).toString());
			result.put("status", thread.status);
			result.put("message", thread.message);
			result.put("error", thread.error);
			result.put("threadStatus", thread.getState().toString());
			if(thread.getState()==Thread.State.TERMINATED){
				this.process=thread.process;
				this.status=thread.status;
				this.message=thread.message;
				this.error=thread.error;
				this.threadStatus=thread.getState().toString();
				thread=null;
			}
		}
		return result;
	}


}