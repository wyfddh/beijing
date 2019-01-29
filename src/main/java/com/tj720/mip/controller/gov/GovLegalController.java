package com.tj720.mip.controller.gov;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.common.util.FileUtil;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.MipAttachmentMapper;
import com.tj720.admin.model.GovLegal;
import com.tj720.admin.model.GovLegalType;
import com.tj720.admin.model.MipAttachment;
import com.tj720.admin.service.GovLegalService;
import com.tj720.admin.service.GovLegalTypeService;
import com.tj720.admin.service.MipAttachmentService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.FtpUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;


@Controller
@RequestMapping("/legal")
public class GovLegalController extends BaseController{

	@Autowired 
	private GovLegalService govLegalService;
	@Autowired
	private GovLegalTypeService govLegalTypeService;
	@Autowired
	private IUserService userService;
	@Autowired
	private MipOrganizationService organizationService;
	@Autowired
	private MipAttachmentMapper mipAttachmentMapmper;
	@Autowired
	private MipAttachmentService mipAttachmentService;
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private Config config;
	
	private FtpUtil ftpUtil;


	@RequestMapping("/list.do")
	@AuthPassport
	@ControllerAop(url="legal/list.do")
	public String list(Model model) {
		return "/WEB-INF/back/gov/govLegalList.jsp";
	}

	@RequestMapping("/toAdd.do")
	@AuthPassport
	public String toAdd() {

		return "/WEB-INF/back/gov/govLegalAdd.jsp";
	}

	@RequestMapping("/toShow.do")
	@AuthPassport
	public String toShow() {

		return "/WEB-INF/back/gov/govLegalShow.jsp";
	}
	
	@RequestMapping("/toShowGov.do")
	@AuthPassport
	public ModelAndView toShowById(String id) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/gov/govLegalShow.jsp");
		GovLegal info = govLegalService.getGovByid(id);
		modelAndView.addObject("govInfo", info);
		return modelAndView; 
	}

	@RequestMapping("/dataList.do")
	@ResponseBody
	@AuthPassport
	public JSONObject dataList(String title,String firstKindId,String secondKindId,String dateRange,String publisher,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "10") int size) {


		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		Map<String,Object> map = new HashMap<String, Object>();
		GovLegal govLegal = new GovLegal();
		if (StringUtils.isNotBlank(title)) {
			map.put("title", title);
			govLegal.setTitle(title);
		}
		if (StringUtils.isNotBlank(firstKindId)) {
			map.put("firstKindId", firstKindId);
			govLegal.setFirstKindId(firstKindId);
		}
		if (StringUtils.isNotBlank(secondKindId)) {
			map.put("secondKindId", secondKindId);
			govLegal.setSecondKindId(secondKindId);
		}
		if (StringUtils.isNotBlank(dateRange)) {
			String[] split = dateRange.split("-");
			govLegal.setStartYear(split[0].trim());
			govLegal.setEndYear(split[1].trim());
			map.put("startYear", split[0].trim());
			map.put("endYear", split[1].trim());
		}
		if (StringUtils.isNotBlank(publisher)) {
			map.put("publisher", publisher);
			govLegal.setPublisher(publisher);
		}

		JSONObject jsonObject = new JSONObject();
		try {
			//查询记录总条数
			Integer count = govLegalService.countList(govLegal);
			page.setAllRow(count);
			Integer start = page.getStart();
			Integer end = start + page.getSize();
			map.put("start", start);
			map.put("end", end-start);
			//查询分页后的数据集合
			List<GovLegal> govLegalList = govLegalService.getList(map);
			
			String jsonString = JSON.toJSONString(govLegalList);

			jsonObject.put("code", 0);
			jsonObject.put("msg",""); 
			jsonObject.put("count", count);
			jsonObject.put("data", jsonString);


		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("code", 1);
			jsonObject.put("msg","数据异常"); 
			jsonObject.put("count", 0);
			jsonObject.put("data", "");
		}
		return jsonObject;
	}

	@RequestMapping("/headData.do")
	@ResponseBody
	@AuthPassport
	public JsonResult headData() {


		Map<String,Object> map = new HashMap<String, Object>();
		try {
			//获取一级二级数据
//			List<GovLegalType> firstKindList = govLegalTypeService.getFirstKindList();

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
			//获取发布单位
			List<GovLegal> publiserList = govLegalService.getPublisherList();
			map.put("firstKindList", firstKindList);
			map.put("secondKindList", secondKindList);
			map.put("publiserList", publiserList);
			JsonResult jsonResult = new JsonResult(1, map);
			return jsonResult;
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(2, null);
		}
	}

	@RequestMapping("/getSecondKindList.do")
	@ResponseBody
	@AuthPassport
	public JsonResult getSecondKindList(String firstKindId) {

		if (StringUtils.isNotBlank(firstKindId)) {
			List<GovLegalType> secondKindList = govLegalTypeService.getSecondKindList(firstKindId);
			return new JsonResult(1,secondKindList);
		} else {
			return new JsonResult(2,null);
		}
	}



	@RequestMapping(value="/save.do", produces="application/json;charset=UTF-8")
	@ResponseBody
	@AuthPassport
	public JsonResult save(GovLegal govLegal,String type,String isChange,String isNoneFile) {
		System.out.println("=========法律法规============="+govLegal.getRealFileName());
		JsonResult result = null;
		ftpUtil = new FtpUtil(config.getFtpUrl(), Integer.valueOf(config.getFtpPort()), config.getFtpUserName(), config.getFtpPassWord());
		
		Date date = new Date();
		User user = userService.get(Tools.getUser().getId());
		if (StringUtils.isNotBlank(type)) {
			MipAttachment mipAttachment = null;
			//1新增2修改
			if (type.equals("1")) {
				String legalId = IdUtils.nextId(govLegal);
				govLegal.setId(legalId);
				govLegal.setCreateTime(date);
				govLegal.setCreater(user.getId());
				govLegal.setUpdateTime(date);
				govLegal.setUpdateUser(user.getId());

				if (StringUtils.isNotBlank(govLegal.getRealFileName())) {
					mipAttachment = new MipAttachment();
					String attachId = IdUtils.nextId(mipAttachment);
					mipAttachment.setAttId(attachId);
					
					
					mipAttachment = handleMipAttachment(mipAttachment,govLegal,user.getId());

					govLegal.setAttachmentId(attachId);
				}
				try {
					govLegalService.save(govLegal);
					if (mipAttachment != null) {
						mipAttachmentService.save(mipAttachment);
					}
					result = new JsonResult(1,type);
				} catch (Exception e) {
					e.printStackTrace();
					result = new JsonResult(2,type);
				}

			} else if (type.equals("2")) {

				govLegal.setUpdateTime(date);
				govLegal.setUpdateUser(user.getId());
				try {
					//1更改上传文件，0未更改
					if (isChange.equals("1")) {
						String attachmentId = govLegal.getAttachmentId();
						//isNoneFile为1：上传文件被取消
						if (isNoneFile.equals("1")) {
							govLegal.setAttachmentId("");
							
							String path = config.getRootPath() + govLegal.getResultPath();
							ftpUtil.delFtpFile(path);
							
							mipAttachmentService.deleteByPrimaryKey(attachmentId);
						//上传文件更改
						} else {
							//非空修改，否则新增
							if (StringUtils.isNotBlank(attachmentId)) {
								mipAttachment = mipAttachmentService.get(attachmentId);
								MipAttachment handleMipAttachment = handleMipAttachment(mipAttachment,govLegal,user.getId());
								mipAttachmentService.update(handleMipAttachment);
							} else {
								mipAttachment = new MipAttachment();
								String attachId = IdUtils.nextId(mipAttachment);
								mipAttachment.setAttId(attachId);
								govLegal.setAttachmentId(attachId);
								
								MipAttachment handleMipAttachment = handleMipAttachment(mipAttachment,govLegal,user.getId());
								mipAttachmentService.save(handleMipAttachment);
							}
							
							
						}
					}
					govLegalService.update(govLegal);
					result = new JsonResult(1,type);
				} catch (Exception e) {
					e.printStackTrace();
					result = new JsonResult(2,type);
				}
			}
		}
		return result;
	}
	
	private MipAttachment handleMipAttachment(MipAttachment mipAttachment,GovLegal govLegal,String userId) {
		Date date = new Date();
		
		mipAttachment.setAttName(govLegal.getRealFileName());
		mipAttachment.setAttSize(Long.valueOf(govLegal.getSize()));
		mipAttachment.setAttPath(govLegal.getResultPath());
		mipAttachment.setAttIsjunk(govLegal.getIsjunk());		
		mipAttachment.setAttDate(date);
		mipAttachment.setAttType("gov_legal");		//业务表名称
		mipAttachment.setAttrUser(userId);
		mipAttachment.setAttFkId(govLegal.getId());		//业务表主键
		mipAttachment.setAttFileType(govLegal.getTypeCode());
		
		
		return mipAttachment;
	}

	@RequestMapping("/del.do")
	@ResponseBody
	@AuthPassport
	public JSONObject del(String id,String attachmentId) {
		JSONObject jsonObject = new JSONObject();
		if (StringUtils.isNotBlank(id)) {
			try {
				if (StringUtils.isNotBlank(attachmentId)) {

					govLegalService.delete(id);

					MipAttachment mipAttachment = mipAttachmentService.get(attachmentId);
					String path = config.getRootPath() + mipAttachment.getAttPath();
					mipAttachmentService.deleteByPrimaryKey(attachmentId);

					FileUtil.delFile(path);
					jsonObject.put("msg", 1);
				} else {
					govLegalService.delete(id);
					jsonObject.put("msg", 1);
				}
			} catch (Exception e) {
				e.printStackTrace();
				jsonObject.put("msg", 2);
			}
		}
		return jsonObject;
	}
}
