package com.tj720.mip.controller.publish;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.tj720.admin.common.constant.Constants;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.model.MipAttachment;
import com.tj720.admin.model.MipCarousel;
import com.tj720.admin.model.MipCarouselExample;
import com.tj720.admin.model.MipCarouselExample.Criteria;
import com.tj720.admin.model.MipCarouselPosition;
import com.tj720.admin.service.MipAttachmentService;
import com.tj720.admin.service.MipCarouselPositionService;
import com.tj720.admin.service.MipCarouselService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;


@Controller
@RequestMapping("/banner")
public class BannerController extends BaseController{
	@Autowired
	MipCarouselPositionService mipCarouselPositionService;
	
	@Autowired
	MipCarouselService mipCarouselService;
	
	@Autowired
	MipAttachmentService mipAttachmentService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private Config config;
	
	@RequestMapping("/goList.do")
	@ControllerAop(url="banner/goList.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goList(Model model){
		//查询所有轮播图位置
		List<MipCarouselPosition> positionList = mipCarouselPositionService.getPositionList();
		model.addAttribute("positionList", positionList);
		return "/WEB-INF/back/publish/bannerList.jsp";
	}
	
	@RequestMapping("/goAdd.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goAdd(Model model, String carouselPositionId){
		String hql = "from MipOrganization where status <> -127 ";
		List<MipOrganization> orgList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql, Tools.getMap());
		model.addAttribute("orgList",orgList);
		
		model.addAttribute("carouselPositionId", carouselPositionId);
		return "/WEB-INF/back/publish/bannerAdd.jsp";
	}
	
	@RequestMapping("/goEdit.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goEdit(Model model, String id){
		String hql = "from MipOrganization where status <> -127 ";
		List<MipOrganization> orgList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql, Tools.getMap());
		model.addAttribute("orgList",orgList);
		
		MipCarousel mipCarousel = mipCarouselService.get(id);
		if(!StringUtils.isBlank(mipCarousel.getPictureId())) {
			MipAttachment mipAttachment = mipAttachmentService.get(mipCarousel.getPictureId());
			if(mipAttachment != null && !StringUtils.isBlank(mipAttachment.getAttPath())) {
				mipCarousel.setImgUrl(config.getImageUrl()+mipAttachment.getAttPath());
			}
			mipCarousel.setAttchment(mipAttachment);
		}
		model.addAttribute("banner", mipCarousel);
		return "/WEB-INF/back/publish/bannerEdit.jsp";
	}
	
	@RequestMapping("/getListData.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JSONObject index(Model model, String searchPositionId){
		JSONObject jsonObject = new JSONObject();
		if(StringUtil.isEmpty(searchPositionId)) {
			jsonObject.put("code", 1);
	        jsonObject.put("msg","数据异常"); 
	        jsonObject.put("count", 0);
	        jsonObject.put("data", null);
			return jsonObject;
		}
		// 获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		List<MipCarousel> list = mipCarouselService.getCarouselList(user.getOrgId(), searchPositionId);
		
        jsonObject.put("code", 0);
        jsonObject.put("msg",""); 
        jsonObject.put("count", list.size());
        jsonObject.put("data", list);
		return jsonObject;
	}
	
	
	@RequestMapping("/addInfo.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult addInfo(Model model, MipCarousel carousel, String file_id, String file_resultPath, String file_realFileName,
    		String file_isjunk, String file_size, String file_typeCode){
		// 获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		if(!MyString.isEmpty(carousel)){
			if(!MyString.isEmpty(carousel.getId())){
				MipCarousel carouselSave = mipCarouselService.getCarousel(carousel.getId());
				carouselSave.setTitle(carousel.getTitle());
				carouselSave.setUrl(carousel.getUrl());
				carouselSave.setCarouselPositionId(carousel.getCarouselPositionId());
				carouselSave.setPictureId(carousel.getPictureId());
				carouselSave.setOrgId(carousel.getOrgId());
				MipAttachment mipAttachment = mipAttachmentService.get(file_id);
				if(mipAttachment != null) {		//不为空则说明已经存在，轮播图没有换
				}else {		//不存在则说明轮播图被替换过
					MipAttachment attchment = new MipAttachment();
                	attchment.setAttId(file_id);
                	attchment.setAttPath(file_resultPath);
                	attchment.setAttName(file_realFileName);
                	attchment.setAttIsjunk(file_isjunk);
                	attchment.setAttSize(Long.parseLong(file_size));
                	attchment.setAttFileType(Integer.parseInt(file_typeCode));
                	attchment.setAttType("mip_carousel");
                	attchment.setAttFkId(carousel.getId());
                	attchment.setAttDate(new Date());
                	attchment.setAttrUser(user.getId());
                	mipAttachmentService.create(attchment);		//保存文件
				}
				carouselSave.setSequence(carousel.getSequence());
				carouselSave.setUid(user.getOrgId());
				carouselSave.setUpdatetime(new Date());
				mipCarouselService.updateCarousel(carouselSave);
				return new JsonResult(Constants.RES_SUCCESS, "轮播图修改成功");
			}
			carousel.setId(IdUtils.nextId(MipCarousel.class.getName()));
			carousel.setUid(user.getOrgId());
			carousel.setStatus((byte)1);
			carousel.setCreatetime(new Date());
			carousel.setUpdatetime(new Date());
			//查询当前最大排序，并+1
			MipCarouselExample example = new MipCarouselExample();
			Criteria criteria = example.createCriteria();
			criteria.andCarouselPositionIdEqualTo(carousel.getCarouselPositionId());
			criteria.andStatusEqualTo((byte)1);
			example.setPageSize(1);
			example.setStartRow(0);
			example.setOrderByClause("sequence desc");
			List<MipCarousel> carouselList = mipCarouselService.getCarouselList(example);
			if(carouselList != null && carouselList.size() > 0) {
				carousel.setSequence(carouselList.get(0).getSequence()+1);
			}else {
				carousel.setSequence(0);
			}
			
			//保存文件
			MipAttachment attchment = new MipAttachment();
        	attchment.setAttId(file_id);
        	attchment.setAttPath(file_resultPath);
        	attchment.setAttName(file_realFileName);
        	attchment.setAttIsjunk(file_isjunk);
        	attchment.setAttSize(Long.parseLong(file_size));
        	attchment.setAttFileType(Integer.parseInt(file_typeCode));
        	attchment.setAttType("mip_carousel");
        	attchment.setAttFkId(carousel.getId());
        	attchment.setAttDate(new Date());
        	attchment.setAttrUser(user.getId());
        	mipAttachmentService.create(attchment);		//保存文件
			
			mipCarouselService.insertCarouselInfo(carousel);
			return new JsonResult(Constants.RES_SUCCESS, "轮播图添加成功");
		}else{
			return new JsonResult(Constants.RES_FAIL, "保存信息有误");
		}
	}
	
	@RequestMapping("/removeBanner.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult removeBanner(String id){
		mipCarouselService.delectCarouselInfo(id);
		return new JsonResult(Constants.RES_SUCCESS, "轮播图删除成功");
	}
	
	/**
	 * 弹出轮播图编辑弹框
	 * @return
	 */
	@RequestMapping("/modifyInfo.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult modifyInfo(String id) {
		MipCarousel carousel = mipCarouselService.getCarousel(id);
		if(!MyString.isEmpty(carousel)){
			carousel.setImgUrl(config.getImageUrl()+carousel.getPictureId());
			return new JsonResult(Constants.RES_SUCCESS, carousel);
		}else{
			return new JsonResult(Constants.RES_FAIL, "该信息不存在");
		}
	}
	
	/**
	 * 修改排序
	 * @return
	 */
	@RequestMapping("/editSequence.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult editSequence(String id, String type) {
		MipCarousel carousel = mipCarouselService.getCarousel(id);
		String carouselPositionId = carousel.getCarouselPositionId();
		if(!MyString.isEmpty(carousel)){
			MipCarouselExample example = new MipCarouselExample();
			Criteria criteria = example.createCriteria();
			criteria.andCarouselPositionIdEqualTo(carouselPositionId);
			criteria.andStatusEqualTo((byte)1);
			if("up".equals(type)) {
				criteria.andSequenceLessThanOrEqualTo(carousel.getSequence());
				example.setOrderByClause("sequence desc");
			}else if("down".equals(type)) {
				criteria.andSequenceGreaterThanOrEqualTo(carousel.getSequence());
				example.setOrderByClause("sequence");
			}
			example.setPageSize(2);
			example.setStartRow(0);
			List<MipCarousel> carouselList = mipCarouselService.getCarouselList(example);
			
			if(carouselList != null && carouselList.size() > 0) {
				if(carouselList.size() == 1) {
					
				}else if(carouselList.size() == 2){
					Integer temp = 0;
					MipCarousel mipCarousel1 = carouselList.get(0);
					MipCarousel mipCarousel2 = carouselList.get(1);
					temp = mipCarousel1.getSequence();
					mipCarousel1.setSequence(mipCarousel2.getSequence());
					mipCarousel2.setSequence(temp);
					mipCarousel1.setUpdatetime(new Date());
					mipCarousel2.setUpdatetime(new Date());
					mipCarouselService.updateCarousel(mipCarousel1);
					mipCarouselService.updateCarousel(mipCarousel2);
				}
				return new JsonResult(Constants.RES_SUCCESS, "排序修改成功");
			}else {
				return new JsonResult(Constants.RES_FAIL, "排序修改失败");
			}
		}else{
			return new JsonResult(Constants.RES_FAIL, "该信息不存在");
		}
	}

}
