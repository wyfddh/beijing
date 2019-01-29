package com.tj720.mip.controller.publish;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.tj720.admin.common.constant.Constants;
import com.tj720.admin.dto.Node;
import com.tj720.admin.model.CmsSubject;
import com.tj720.admin.service.CmsSubjectService;
import com.tj720.admin.service.GovNoticeService;
import com.tj720.admin.service.MipAreaService;
import com.tj720.admin.service.MipAttachmentService;
import com.tj720.admin.service.ReceiveNoticeService;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.SubjectNode;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;

@Controller
@RequestMapping("/cmsSubject")
public class CmsSubjectController extends BaseController<MipOrganization> {

	@Autowired
	private Config config;
	@Autowired
	private GovNoticeService govNoticeService;
	@Autowired
	private MipAttachmentService mipAttachmentService;
	@Autowired
	private ReceiveNoticeService receiveNoticeService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private MipAreaService mipAreaService;
	@Autowired
	private IUserService userService;
	@Autowired
	private CmsSubjectService cmsSubjectService;

	/**
	 * 获取栏目列表
	 * @param cmsSubject
	 * @return
	 */
	@RequestMapping("goList.do")
	@ControllerAop(url="cmsSubject/goList.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goList(CmsSubject cmsSubject,String type){
		return "/WEB-INF/back/publish/CmsSubjectList.jsp";
	}
	
	/**
	 * 去栏目新增页面
	 * @param cmsSubject
	 * @return
	 */
	@RequestMapping("goAdd.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goAdd(String type, Model model){
		CmsSubject cmsSubject = new CmsSubject();
		List<CmsSubject> subjectList = cmsSubjectService.getSubjectList(cmsSubject,type,"100");
		List<Node> nodeList = new ArrayList<>();
		convertSubject2Node(subjectList, nodeList);
		model.addAttribute("nodeList", JSON.toJSON(nodeList));
		model.addAttribute("type", type);
		return "/WEB-INF/back/publish/CmsSubjectAdd.jsp";
	}
	
	/**
	 * 去栏目编辑页面
	 * @param cmsSubject
	 * @return
	 */
	@RequestMapping("goEdit.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goEdit(String id,String type, Model model){
		if(!StringUtils.isBlank(id)) {
			CmsSubject cmsSubject = new CmsSubject();
			List<CmsSubject> subjectList = cmsSubjectService.getSubjectList(cmsSubject,type,"100");
			List<Node> nodeList = new ArrayList<>();
			convertSubject2Node(subjectList, nodeList);
			model.addAttribute("nodeList", JSON.toJSON(nodeList));
			cmsSubject = cmsSubjectService.get(id);
			model.addAttribute("subject", cmsSubject);
		}
		return "/WEB-INF/back/publish/CmsSubjectEdit.jsp";
	}
	
	/**
	 * 获取栏目列表数据
	 * @param cmsSubject
	 * @return
	 */
	@RequestMapping("list.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult list(CmsSubject cmsSubject,String type,@RequestParam(defaultValue = "1")String Pid){
		List<CmsSubject> subjectList = cmsSubjectService.getSubjectList(cmsSubject,type,Pid);
		List<Node> nodeList = new ArrayList<>();
		convertSubject2Node(subjectList, nodeList);
		return new JsonResult(Constants.RES_SUCCESS, nodeList);
	}
	
	/**
	 * 获取栏目列表数据(列表树使用)
	 * @param cmsSubject
	 * @return
	 */
	@RequestMapping("ztreeList.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult ztreeList(String type){
		List<SubjectNode> nodeList = cmsSubjectService.getSubjectListTreeByParentId1("100",type);
		return new JsonResult(Constants.RES_SUCCESS, JSONObject.toJSON(nodeList));
	}
	
	/**
	 * 栏目转换为node树
	 * @param subjectList
	 * @param nodeList
	 */
	private void convertSubject2Node(List<CmsSubject> subjectList, List<Node> nodeList) {
		if(CollectionUtils.isEmpty(subjectList)) {
			return;
		}
		int i = 0;
		for(CmsSubject cmsSubject : subjectList){
			Boolean isOpen = i == 0 ? true : false;
			Node node = new Node(cmsSubject.getId(), cmsSubject.getfId(), cmsSubject.getName(), isOpen,cmsSubject.getDescription(),cmsSubject.getType(),cmsSubject.getStatus(),cmsSubject.getUniqueName());
			nodeList.add(node);
		}
	}
	
	/**
	 * 保存和更新栏目
	 * @param cmsSubject
	 * @return
	 */
	@RequestMapping("/saveSubject.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult saveCmsSubject(CmsSubject cmsSubject){
		if(StringUtils.isNotBlank(cmsSubject.getId())){
			//update
			JsonResult modify = cmsSubjectService.modify(cmsSubject);
			return modify;
		} else {
			JsonResult save = cmsSubjectService.save(cmsSubject);
			return save;
		}
	}
	
	/**
	 * 根据唯一名称和id，判断唯一名称是否被其他栏目使用
	 * @param cmsSubject
	 * @return 返回使用的个数
	 */
	@RequestMapping("checkUniqueName.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult checkUniqueName(CmsSubject cmsSubject){
		if(StringUtil.isEmpty(cmsSubject.getUniqueName())) {
			return new JsonResult(Constants.RES_FAIL, "信息异常");
		}
		List<CmsSubject> subjectListByUniqueName = cmsSubjectService.getSubjectListByUniqueName(cmsSubject.getId(), cmsSubject.getUniqueName());
		if(subjectListByUniqueName == null || subjectListByUniqueName.size() == 0) {
			return new JsonResult(Constants.RES_SUCCESS, 0);
		}else {
			return new JsonResult(Constants.RES_SUCCESS, 1);
		}
	}
	
	/**
	 * 删除栏目
	 * @param cmsSubject
	 * @return
	 */
	@RequestMapping("/removeSubject.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult removeCmsSubject(String id){
		if(StringUtils.isNotBlank(id)){
			//查询下面是否存在栏目
			List<CmsSubject> subjectListByParentId = cmsSubjectService.getSubjectListByParentId(id);
			if(subjectListByParentId == null || subjectListByParentId.size() == 0) {
				CmsSubject cs = new CmsSubject();
				cs.setStatus("0");
				cs.setId(id);
				JsonResult modify = cmsSubjectService.modify(cs);
				return modify;
			}else {
				return new JsonResult(2,"栏目下存在子栏目，请删除子栏目后重新操作");
			}
		} else {
			return new JsonResult(2,"参数错误");
		}
	}
}
