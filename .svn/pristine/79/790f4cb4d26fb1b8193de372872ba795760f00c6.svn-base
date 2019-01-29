package com.tj720.mip.controller.collectionTopic;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.model.MipTopicType;
import com.tj720.admin.service.MipTopicTypeService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.utils.Page;

/**
 * 藏品专题
 * 
 * @author cm
 *
 */
@Controller
@RequestMapping("topicType")
public class MipTopicTypeController {

	@Autowired
	private MipTopicTypeService mipTopicTypeService;
	
	/**
	 * 去列表页面
	 * @return
	 */
	@RequestMapping("goList")
	@AuthPassport(authority = "contentCommon")
	@ControllerAop(url="topicType/goList.do")
	public String goList() {
		return "/WEB-INF/back/topic/mipTopicTypeList.jsp";
	}
	
	/**
	 * 去新增页面
	 * @return
	 */
	@RequestMapping("goAdd")
	@AuthPassport(authority = "contentCommon")
	public String goAdd() {
		return "/WEB-INF/back/topic/mipTopicTypeAdd.jsp";
	}
	
	@RequestMapping("getListData")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JSONObject getListData(String name, @RequestParam(defaultValue = "1", name = "page") Integer currentPage,
			@RequestParam(defaultValue = "10") int size) {
		Page page = new Page();
		page.setSize(size);
		page.setCurrentPage(currentPage);
		List<MipTopicType> list = mipTopicTypeService.getList(name, page);
		
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg",""); 
        jsonObject.put("count", page.getAllRow());
        jsonObject.put("data", list);
		return jsonObject;
	}
	
	@RequestMapping("deleteType")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult deleteType(String id) {
		int delete = mipTopicTypeService.delete(id);
		if(delete > 0) {
			return new JsonResult(1, "删除成功");
		}
		return new JsonResult(0, "删除失败");
	}
	
	@RequestMapping("addOrUpdate")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult addOrUpdate(MipTopicType topicType) {
		if(StringUtils.isBlank(topicType.getId())) {
			//新增
			String id = IdUtils.nextId(new MipTopicType());
			topicType.setId(id);
			topicType.setCreattime(new Date());
			topicType.setUpdatetime(new Date());
			int save = mipTopicTypeService.save(topicType);
			if(save > 0) {
				return new JsonResult(1, "保存成功");
			}
		}else {
			//编辑
			String id = topicType.getId();
			MipTopicType mipTopicType = mipTopicTypeService.get(id);
			if(mipTopicType == null) {
				return new JsonResult(0, "保存失败");
			}
			mipTopicType.setName(topicType.getName());
			mipTopicType.setDescribe(topicType.getDescribe());
			mipTopicType.setUpdatetime(new Date());
			int update = mipTopicTypeService.update(mipTopicType);
			if(update > 0) {
				return new JsonResult(1, "保存成功");
			}
		}
		return new JsonResult(0, "保存失败");
	}
	
	/**
	 * 获取下拉框列表
	 * @return
	 */
	@RequestMapping("getSelectList")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public JsonResult getSelectList() {
		Page page = new Page();
		page.setSize(10000);
		page.setCurrentPage(1);
		List<MipTopicType> list = mipTopicTypeService.getList(null, page);
		return new JsonResult(1, list);
	}
		
}
