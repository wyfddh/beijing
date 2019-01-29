package com.tj720.mip.controller.publish;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.common.constant.Constants;
import com.tj720.admin.model.CmsFriendlyLink;
import com.tj720.admin.model.CmsFriendlyLinkExample;
import com.tj720.admin.model.CmsFriendlyLinkExample.Criteria;
import com.tj720.admin.service.CmsFriendlyLinkService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.TimeUtil;

@RequestMapping("/cmsFriendlyLink")
@Controller
public class CmsFriendlyLinkController extends BaseController{
	
	@Autowired
	private CmsFriendlyLinkService cmsFriendlyLinkService;

	@Autowired
	private Config config;

	/**
	 * 去列表页面
	 * @return
	 */
	@RequestMapping("/goList.do")
	@ControllerAop(url="cmsFriendlyLink/goList.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goList() {
		return "/WEB-INF/back/publish/CmsFriendlyLinkList.jsp";
	}
	
	/**
	 * 去新增页面
	 * @return
	 */
	@RequestMapping("/goAdd.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goAdd(String subjectId, Model model) {
		model.addAttribute("subjectId", subjectId);
		return "/WEB-INF/back/publish/CmsFriendlyLinkAdd.jsp";
	}
	
	/**
	 * 去编辑页面
	 * @return
	 */
	@RequestMapping("/goEdit.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goEdit(String id, Model model) {
		int valueId = -1;
		if(!StringUtils.isBlank(id)) {
			valueId = Integer.parseInt(id);
		}
		CmsFriendlyLink cmsFriendlyLink = cmsFriendlyLinkService.getCmsFriendlyLink(valueId);
		if(!StringUtils.isBlank(cmsFriendlyLink.getImgUrl())) {
			model.addAttribute("rootUrl", config.getRootUrl());
		}
		model.addAttribute("link", cmsFriendlyLink);
		return "/WEB-INF/back/publish/CmsFriendlyLinkEdit.jsp";
	}
	
	/**
	 * 友情链接列表查看
	 * @param modelMap
	 * @param size
	 * @param currentPage
	 * @param mipLog
	 * @return
	 */
	@RequestMapping("/getListData")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JSONObject getListData(@RequestParam(defaultValue="10") int size, @RequestParam(defaultValue="1") int currentPage){
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		List<CmsFriendlyLink> list = null;
		try {
			list = cmsFriendlyLinkService.listCmsFriendlyLink(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg",""); 
        jsonObject.put("count", page.getAllRow());
        jsonObject.put("data", list);
		return jsonObject;
	}
	
	/**
	 * 友情链接新增或保存
	 * @param model
	 * @param cmsFriendlyLink
	 * @return
	 */
	@RequestMapping("/addInfo.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult addInfo(Model model, CmsFriendlyLink cmsFriendlyLink){
		if(!MyString.isEmpty(cmsFriendlyLink)){
			if(!MyString.isEmpty(cmsFriendlyLink.getId())){
				CmsFriendlyLink cmsFriendlyLinkSave = cmsFriendlyLinkService.getCmsFriendlyLink(cmsFriendlyLink.getId());
				cmsFriendlyLinkSave.setTitle(cmsFriendlyLink.getTitle());
				cmsFriendlyLinkSave.setUrl(cmsFriendlyLink.getUrl());
				cmsFriendlyLinkSave.setModifyTime(TimeUtil.GetCurDateTime());
				cmsFriendlyLinkSave.setSequence(cmsFriendlyLink.getSequence());
				cmsFriendlyLinkSave.setImgUrl(cmsFriendlyLink.getImgUrl());
				cmsFriendlyLinkService.updateCmsFriendlyLink(cmsFriendlyLink);
				return new JsonResult(Constants.RES_SUCCESS, "友情链接修改成功");
			}
			cmsFriendlyLink.setId(null);		//自增长
			cmsFriendlyLink.setStatus("1");
			cmsFriendlyLink.setCreateTime(TimeUtil.GetCurDateTime());
			cmsFriendlyLink.setModifyTime(TimeUtil.GetCurDateTime());
			
			//查询当前最大排序，并+1
			CmsFriendlyLinkExample example = new CmsFriendlyLinkExample();
			Criteria criteria = example.createCriteria();
			criteria.andStatusEqualTo("1");	//1-正常  0-删除
			example.setSize(1);
			example.setStartPage(0);
			example.setOrderByClause("sequence desc");
			List<CmsFriendlyLink> selectListByExample = cmsFriendlyLinkService.selectListByExample(example);
			if(selectListByExample != null && selectListByExample.size() > 0) {
				cmsFriendlyLink.setSequence(selectListByExample.get(0).getSequence()+1);
			}else {
				cmsFriendlyLink.setSequence(0);
			}
			
			cmsFriendlyLinkService.insertCmsFriendlyLink(cmsFriendlyLink);
			return new JsonResult(Constants.RES_SUCCESS, "友情链接添加成功");
		}else{
			return new JsonResult(Constants.RES_FAIL, "保存信息有误");
		}
	}

	/**
	 * 友情链接删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult delete(String id){
		if(!StringUtil.isEmpty(id)) {
			Integer value_id = StringUtil.isEmpty(id)?null:Integer.parseInt(id);
			cmsFriendlyLinkService.delectCmsFriendlyLinkInfo(value_id);
			return new JsonResult(Constants.RES_SUCCESS, "友情链接删除成功");
		}else {
			return new JsonResult(Constants.RES_FAIL, "获取信息失败");
		}
	}

	@RequestMapping("/modifyInfo.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult modifyInfo(String id){
		if(!MyString.isEmpty(id)){
			Integer value_id = StringUtil.isEmpty(id)?null:Integer.parseInt(id);
			CmsFriendlyLink cmsFriendlyLink = cmsFriendlyLinkService.getCmsFriendlyLink(value_id);
			JsonResult jr = new JsonResult(Constants.RES_SUCCESS, cmsFriendlyLink);
			Map<String, String> other = new HashMap<String, String>();
			other.put("imgroot", config.getImageUrl());
			jr.setOthers(other);
			return jr;
		}else{
			return new JsonResult(Constants.RES_FAIL, "获取信息失败");
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
		Integer realId = StringUtil.isEmpty(id)?null:Integer.parseInt(id);
		CmsFriendlyLink cmsFriendlyLink = cmsFriendlyLinkService.getCmsFriendlyLink(realId);
		if(!MyString.isEmpty(cmsFriendlyLink)){
			CmsFriendlyLinkExample example = new CmsFriendlyLinkExample();
			Criteria criteria = example.createCriteria();
			criteria.andStatusEqualTo("1");	//1-正常  0-删除
			if("up".equals(type)) {
				criteria.andSequenceLessThanOrEqualTo(cmsFriendlyLink.getSequence());
				example.setOrderByClause("sequence desc");
			}else if("down".equals(type)) {
				criteria.andSequenceGreaterThanOrEqualTo(cmsFriendlyLink.getSequence());
				example.setOrderByClause("sequence");
			}
			example.setSize(2);
			example.setStartPage(0);
			List<CmsFriendlyLink> selectListByExample = cmsFriendlyLinkService.selectListByExample(example);
			
			if(selectListByExample != null && selectListByExample.size() > 0) {
				if(selectListByExample.size() == 1) {
					
				}else if(selectListByExample.size() == 2){
					Integer temp = 0;
					CmsFriendlyLink link1 = selectListByExample.get(0);
					CmsFriendlyLink link2 = selectListByExample.get(1);
					temp = link1.getSequence();
					link1.setSequence(link2.getSequence());
					link2.setSequence(temp);
					link1.setModifyTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS_NO));
					link2.setModifyTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS_NO));
					cmsFriendlyLinkService.updateCmsFriendlyLink(link1);
					cmsFriendlyLinkService.updateCmsFriendlyLink(link2);
				}
				return new JsonResult(Constants.RES_SUCCESS, "排序修改成功");
			}else {
				return new JsonResult(Constants.RES_FAIL, "排序修改失败");
			}
		}else{
			return new JsonResult(Constants.RES_FAIL, "该信息不存在");
		}
	}
	

	/**
	 * 友情链接列表查看-PC接口
	 * @param modelMap
	 * @param size
	 * @param currentPage
	 * @param mipLog
	 * @return
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public JsonResult getList(){
		Page page = new Page();
		page.setCurrentPage(1);
		page.setSize(20);
		List<CmsFriendlyLink> list = null;
		try {
			list = cmsFriendlyLinkService.listCmsFriendlyLink(page);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常");
		}
		return new JsonResult(1, list, page);
	}
}
