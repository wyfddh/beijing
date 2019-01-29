package com.tj720.mip.controller.gov;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.model.GovLegalType;
import com.tj720.admin.service.GovLegalService;
import com.tj720.admin.service.GovLegalTypeService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.User;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/legalType")
public class GovLegalTypeController extends BaseController{

	@Autowired
	private GovLegalTypeService govLegalTypeService;
	@Autowired
	private IUserService userService;
	@Autowired 
	private GovLegalService govLegalService;

	@RequestMapping("/list.do")
	@AuthPassport
	public String list() {

		return "/WEB-INF/back/gov/govLegalTypeList.jsp";
	}


	@RequestMapping("/dataList.do")
	@ResponseBody
	@AuthPassport
	public JSONObject dataList(String typeName,@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "10") int size) {

		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		Map<String,Object> map = new HashMap<String, Object>();
		GovLegalType govLegalType = new GovLegalType();
		if (StringUtils.isNotBlank(typeName)) {
			map.put("typeName", typeName);
			govLegalType.setTypeName(typeName);
		}
		//查询记录总条数
		Integer count = govLegalTypeService.countList(govLegalType);
		page.setAllRow(count);
		Integer start = page.getStart();
		Integer end = start + page.getSize();
		map.put("start", start);
		map.put("end", end-start);
		//查询分页后的数据集合

		List<GovLegalType> legalTypeList = govLegalTypeService.getList(map);
		String jsonString = JSON.toJSONString(legalTypeList);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg",""); 
		jsonObject.put("count", count);
		jsonObject.put("data", jsonString);

		return jsonObject;
	}

	@RequestMapping("/toAdd.do")
	@AuthPassport
	public String toAdd() {
		return "/WEB-INF/back/gov/govLegalTypeAdd.jsp";
	}

	@RequestMapping("/save.do")
	@ResponseBody
	@AuthPassport
	public String save(String typeName,String kind,String pid,String type,String id) {
		String msg = "";
		Date date = new Date();
		// 当前登录者
		User user = userService.get(Tools.getUser().getId());

		GovLegalType govLegalType = null;
		//原来有二级联动
//		//1新增2修改
//		if (type.equals("1")) {
//			govLegalType = new GovLegalType();
//			String nextId = IdUtils.nextId(govLegalType);
//			govLegalType.setId(nextId);
//			govLegalType.setKind(kind);
//			if (StringUtils.isNotBlank(pid)) {
//				govLegalType.setPid(pid);
//			}
//			govLegalType.setCreator(user.getId());
//			govLegalType.setCreateTime(date);
//		} else if (type.equals("2")) {
//			govLegalType = govLegalTypeService.getById(id);
//		}
//		govLegalType.setTypeName(typeName);
//		govLegalType.setUpdateTime(date);
//		govLegalType.setUpdateUser(user.getId());
		
		//现在没有
		//1新增2修改
		if (type.equals("1")) {
			govLegalType = new GovLegalType();
			String nextId = IdUtils.nextId(govLegalType);
			govLegalType.setId(nextId);
			govLegalType.setKind(kind);
			
			govLegalType.setCreator(user.getId());
			govLegalType.setCreateTime(date);
		} else if (type.equals("2")) {
			govLegalType = govLegalTypeService.getById(id);
		}
		govLegalType.setTypeName(typeName);
		govLegalType.setUpdateTime(date);
		govLegalType.setUpdateUser(user.getId());
		
		try {
			if (type.equals("1")) {
				govLegalTypeService.save(govLegalType); 
			} else {
				govLegalTypeService.update(govLegalType);
			}
			msg = "1";
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
			msg = "2";
			return msg;
		}

	}

//	@RequestMapping("/getFirstKind.do")
//	@ResponseBody
//	@AuthPassport
//	public JsonResult getFirstKind() {
//		JsonResult jsonResult = null;
//		try {
//			List<GovLegalType> firstKindList = govLegalTypeService.getFirstKindList();
//			jsonResult = new JsonResult(1, firstKindList);
//		} catch (Exception e) {
//			jsonResult = new JsonResult(2, null);
//		}
//
//
//		return jsonResult;
//	}
	@RequestMapping("/getKind.do")
	@ResponseBody
	@AuthPassport
	public JsonResult getKind() {
		JsonResult jsonResult = null;
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			List<GovLegalType> kindList = govLegalTypeService.getKindList();
			List<GovLegalType> firstKindList = new ArrayList<GovLegalType>();
			List<GovLegalType> secondKindList = new ArrayList<GovLegalType>();
			for (GovLegalType govLegalType : kindList) {
				if (govLegalType.getKind().equals("1")) {
					firstKindList.add(govLegalType);
				} else if (govLegalType.getKind().equals("2")) {
					secondKindList.add(govLegalType);
				}
			}
			map.put("firstKindList", firstKindList);
			map.put("secondKindList", secondKindList);
			jsonResult = new JsonResult(1, map);
		} catch (Exception e) {
			jsonResult = new JsonResult(2, null);
		}


		return jsonResult;
	}

	@RequestMapping("/del.do")
	@ResponseBody
	@AuthPassport
	public JSONObject del(String id,String kind) {
		JSONObject jsonObject = new JSONObject();
		if (StringUtils.isNotBlank(id)) {
			try {
				Integer count = govLegalService.countByLegalTypeId(id);
				if (count > 0) {
					jsonObject.put("msg", 3);//该分类下有法律法规，不允许删除
					
				} else {
					if (kind.equals("2")) {
						govLegalTypeService.delById(id);
					} else if (kind.equals("1")) {
						govLegalTypeService.delAllById(id);
					}
					jsonObject.put("msg", 1);
				}
			} catch (Exception e) {
				jsonObject.put("msg", 2);
			}
		}
		return jsonObject;
	}

	@RequestMapping("/check.do")
	@ResponseBody
	@AuthPassport
	public JsonResult check(String typeName) {
		JsonResult result = new JsonResult(1);
		List<GovLegalType> typeList = govLegalTypeService.getAllKind();

		for (GovLegalType govLegalType : typeList) {
			if (typeName.equals(govLegalType.getTypeName())) {
				result = new JsonResult(2);
				break;
			}
		}

		return result;
	}
}
