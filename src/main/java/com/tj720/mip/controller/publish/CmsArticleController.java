package com.tj720.mip.controller.publish;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.common.constant.Constants;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.model.CmsArticle;
import com.tj720.admin.model.CmsSubject;
import com.tj720.admin.model.MipAttachment;
import com.tj720.admin.service.CmsArticleService;
import com.tj720.admin.service.CmsSubjectService;
import com.tj720.admin.service.MipAttachmentService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.OrgUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.TimeUtil;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/cmsArticel")
public class CmsArticleController extends BaseController<MipOrganization> {

	@Autowired
	private Config config;
	@Autowired
	private MipAttachmentService mipAttachmentService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private MipOrganizationService organizationService;
	@Autowired
	private IUserService userService;
	@Autowired
	private CmsArticleService cmsArticleService;
	@Autowired
    private CmsSubjectService cmsSubjectService;

	/**
	 * 去列表页面
	 * @return
	 */
	@CrossOrigin
	@RequestMapping("/goList.do")
	@ControllerAop(url="cmsArticel/goList.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goList(Model model) {
		String level = getLevel();//1:博物馆2：文物局
		model.addAttribute("level", level);
		
		UserDto user = (UserDto)this.session.getAttribute("user");
		String orgId = user.getOrgName();
		model.addAttribute("orgId", orgId);
		return "/WEB-INF/back/publish/cmsArticle/CmsArticleList.jsp";
	}
	
	/**
	 * 去新增页面
	 * @return
	 */
	@RequestMapping("/goAdd.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goAdd(String subjectId, Model model) {
		CmsSubject cmsSubject = cmsSubjectService.get(subjectId);
		model.addAttribute("subjectId", subjectId);
		if("1".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleAdd.jsp";
		}else if("2".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleAdd2.jsp";
		}else if("3".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleAdd3.jsp";
		}else if("4".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleAdd4.jsp";
		}else if("5".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleAdd5.jsp";
		}
		return "/WEB-INF/back/publish/cmsArticle/CmsArticleAdd.jsp";
	}
	
	/**
	 * 去编辑页面
	 * @return
	 */
	@RequestMapping("/goEdit.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goEdit(String id, Model model) {
		CmsArticle cmsArticle = cmsArticleService.get(id);
		model.addAttribute("article", cmsArticle);
		if(!StringUtils.isBlank(cmsArticle.getPdfUrl())) {
			MipAttachment mipAttachment = mipAttachmentService.get(cmsArticle.getPdfUrl());
			if(mipAttachment != null) {
				model.addAttribute("file_id", mipAttachment.getAttId());
				model.addAttribute("file_resultPath", mipAttachment.getAttPath());
				model.addAttribute("file_realFileName", mipAttachment.getAttName());
				model.addAttribute("file_isjunk", mipAttachment.getAttIsjunk());
				model.addAttribute("file_size", mipAttachment.getAttSize());
				model.addAttribute("file_typeCode", mipAttachment.getAttFileType());
			}else {
				cmsArticle.setPdfUrl("");
			}
		}
		CmsSubject cmsSubject = cmsSubjectService.get(cmsArticle.getSubjectId());
		if("1".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleEdit.jsp";
		}else if("2".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleEdit2.jsp";
		}else if("3".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleEdit3.jsp";
		}else if("4".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleEdit4.jsp";
		}else if("5".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleEdit5.jsp";
		}
		return "/WEB-INF/back/publish/cmsArticle/CmsArticleEdit.jsp";
	}
	
	/**
	 * 去编辑页面
	 * @return
	 */
	@RequestMapping("/goView.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goView(String id, Model model) {
		CmsArticle cmsArticle = cmsArticleService.get(id);
		model.addAttribute("article", cmsArticle);
		if(!StringUtils.isBlank(cmsArticle.getPdfUrl())) {
			MipAttachment mipAttachment = mipAttachmentService.get(cmsArticle.getPdfUrl());
			if(mipAttachment != null) {
				model.addAttribute("file_id", mipAttachment.getAttId());
				model.addAttribute("file_resultPath", mipAttachment.getAttPath());
				model.addAttribute("file_realFileName", mipAttachment.getAttName());
				model.addAttribute("file_isjunk", mipAttachment.getAttIsjunk());
				model.addAttribute("file_size", mipAttachment.getAttSize());
				model.addAttribute("file_typeCode", mipAttachment.getAttFileType());
			}else {
				cmsArticle.setPdfUrl("");
			}
		}
		CmsSubject cmsSubject = cmsSubjectService.get(cmsArticle.getSubjectId());
		if("1".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleView.jsp";
		}else if("2".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleView2.jsp";
		}else if("3".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleView3.jsp";
		}else if("4".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleView4.jsp";
		}else if("5".equals(cmsSubject.getType())) {
			return "/WEB-INF/back/publish/cmsArticle/CmsArticleView5.jsp";
		}
		return "/WEB-INF/back/publish/cmsArticle/CmsArticleView.jsp";
	}
	
	/**
	 * 文章列表数据请求
	 * 
	 * @param page
	 * @param key
	 * @param startDate
	 * @param endDate
	 * @param status
	 * @param publisher
	 * @return
	 */
	@RequestMapping("/getListData.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JSONObject getListData(String key, String status, String subjectId,
			@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int size) {
		Page page = new Page();
    	page.setSize(size);
    	page.setCurrentPage(currentPage);
        List<CmsArticle> list = null;
        LoginInfoDto userDto = Tools.getUser();
        User user = userService.get(userDto.getId());
        try {
        	List<com.tj720.admin.model.MipOrganization> allByProvince = organizationService.getList();
        	List<com.tj720.admin.model.MipOrganization> sonOrg = OrgUtil.getSonOrg(allByProvince, Integer.parseInt(user.getOrgId()), true);
        	List<String> orgList = new ArrayList<>();
        	for (com.tj720.admin.model.MipOrganization org : sonOrg) {
        		if(org != null) {
        			orgList.add(org.getId()+"");
        		}
			}
        	if(orgList == null || orgList.size() == 0) {
        		orgList = null;
        	}
        	list = cmsArticleService.getArticleList(key, status, subjectId, orgList, page, user.getOrgId());
        } catch (ParseException e) {
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
     * 添加或发布文章
     */
    @RequestMapping(value="/save")
    @ResponseBody
    @AuthPassport(authority = "SystemAdmin")
    public JsonResult save(CmsArticle cmsArticle, String file_id, String file_resultPath, String file_realFileName,
    		String file_isjunk, String file_size, String file_typeCode) {
        try {
            if (cmsArticle != null) {
            	LoginInfoDto us = Tools.getUser();
            	User user = userService.get(us.getId());
            	cmsArticle.setPublisher(user.getOrgId());
            	cmsArticle.setId(IdUtils.nextId(CmsArticle.class));
                String pdfUrl = cmsArticle.getPdfUrl();
                cmsArticle.setType("1");
                if (StringUtils.isNotBlank(pdfUrl)) {
                	cmsArticle.setPdfUrl(file_id);		//附件表id
                	cmsArticle.setType("3");
                	
                	MipAttachment attchment = new MipAttachment();
                	attchment.setAttId(file_id);
                	attchment.setAttPath(file_resultPath);
                	attchment.setAttName(file_realFileName);
                	attchment.setAttIsjunk(file_isjunk);
                	attchment.setAttSize(Long.parseLong(file_size));
                	attchment.setAttFileType(Integer.parseInt(file_typeCode));
                	attchment.setAttType("cms_article");
                	attchment.setAttFkId(cmsArticle.getId());
                	attchment.setAttDate(new Date());
                	attchment.setAttrUser(user.getId());
                	mipAttachmentService.create(attchment);
                }
                //获取最大排序
                int maxPosBySubject = cmsArticleService.getMaxPosBySubject(cmsArticle.getSubjectId());
                cmsArticle.setPos(maxPosBySubject);
                
                //cmsArticle.setSubjectId(subjectId);\
                // 根据subjectId查询dn的值
                CmsSubject cmsSubject = cmsSubjectService.get(cmsArticle.getSubjectId());
                cmsArticle.setDn(cmsSubject.getDn());
                if("2".equals(cmsArticle.getStatus())) {		//发布
                	cmsArticle.setStatus("2");		//当传入发布时
                	cmsArticle.setPublishTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS_NO));
                }else {
                	cmsArticle.setStatus("1");		//默认为编辑状态
                }
                cmsArticle.setCreateTime(TimeUtil.GetCurDateTime());
                cmsArticle.setModifyTime(TimeUtil.GetCurDateTime());
                cmsArticle.setViewCounts(0);
                int result = cmsArticleService.create(cmsArticle);
                if (result > 0) {
                    return new JsonResult(Constants.RES_SUCCESS, "保存成功", 0, null);
                } else {
                    return new JsonResult(Constants.RES_FAIL, "保存失败", 0, null);
                }
            } else {
                return new JsonResult(Constants.RES_FAIL, "保存文章参数错误", 0, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(Constants.RES_FAIL, "系统异常", 0, null);
        }
    }
    
    /**
     * 修改文章
     */
    @RequestMapping(value="/modify")
    @ResponseBody
    @AuthPassport(authority = "SystemAdmin")
    public JsonResult modify(CmsArticle cmsArticle, String file_id, String file_resultPath, String file_realFileName,
    		String file_isjunk, String file_size, String file_typeCode) {
    	LoginInfoDto us = Tools.getUser();
    	User user = userService.get(us.getId());
        cmsArticle.setPublisher(user.getOrgId());
        CmsArticle oldArticle = cmsArticleService.get(cmsArticle.getId());
        try {
            String rootPath = config.getRootUrl();
			String titleImageSrc = cmsArticle.getTitleImageSrc();
			String vedioUrl = cmsArticle.getVedioUrl();
			String pdfUrl = cmsArticle.getPdfUrl();
			String audioUrl = cmsArticle.getAudioUrl();
			cmsArticle.setType("1");
			if (StringUtils.isNotBlank(titleImageSrc)) {
			    titleImageSrc = titleImageSrc.replaceAll(rootPath, "");
			    cmsArticle.setTitleImageSrc(titleImageSrc);
			    cmsArticle.setType("1");
			} else {
			    cmsArticle.setTitleImageSrc(null);
			}
			if (StringUtils.isNotBlank(vedioUrl)) {
			    vedioUrl = vedioUrl.replaceAll(rootPath, "");
			    cmsArticle.setVedioUrl(vedioUrl);
			    cmsArticle.setType("2");
			} else {
			    cmsArticle.setVedioUrl(null);
			}
			if (StringUtils.isNotBlank(pdfUrl)) {
				pdfUrl = pdfUrl.replaceAll(rootPath, "");
				cmsArticle.setPdfUrl(pdfUrl);
				cmsArticle.setType("3");
				
				if(StringUtils.isBlank(oldArticle.getPdfUrl()) || !oldArticle.getPdfUrl().equals(pdfUrl)) {
					//首先删除原来的pdf
					mipAttachmentService.deleteFile(pdfUrl);
					MipAttachment attchment = new MipAttachment();
                	attchment.setAttId(file_id);
                	attchment.setAttPath(file_resultPath);
                	attchment.setAttName(file_realFileName);
                	attchment.setAttIsjunk(file_isjunk);
                	attchment.setAttSize(Long.parseLong(file_size));
                	attchment.setAttFileType(Integer.parseInt(file_typeCode));
                	attchment.setAttType("cms_article");
                	attchment.setAttFkId(cmsArticle.getId());
                	attchment.setAttDate(new Date());
                	attchment.setAttrUser(user.getId());
                	mipAttachmentService.create(attchment);
				}
			}else {
				cmsArticle.setPdfUrl(null);
			}
			if (StringUtils.isNotBlank(audioUrl)) {
				audioUrl = audioUrl.replaceAll(rootPath, "");
				cmsArticle.setAudioUrl(audioUrl);
			}
			cmsArticle.setCreateTime(DateUtil.StringToString(oldArticle.getCreateTime(), DateStyle.YYYY_MM_DD_HH_MM_SS_NO));
			cmsArticle.setModifyTime(TimeUtil.GetCurDateTime());
			cmsArticle.setPos(oldArticle.getPos());
			cmsArticle.setViewCounts(oldArticle.getViewCounts());
			cmsArticle.setCanComment(oldArticle.getCanComment());
			cmsArticle.setCommentCounts(oldArticle.getCommentCounts());
			cmsArticle.setMark(oldArticle.getMark());
			if("2".equals(cmsArticle.getStatus())) {
				cmsArticle.setPublishTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS_NO));
			}
			int result = cmsArticleService.update(cmsArticle);
			
			if (result > 0) {
			    return new JsonResult(Constants.RES_SUCCESS, "保存成功", 0, null);
			} else {
			    return new JsonResult(Constants.RES_FAIL, "保存失败", 0, null);
			}
        } catch (Exception e) {
        	e.printStackTrace();
            return new JsonResult(Constants.RES_FAIL, "系统异常");
        }
    }
    
    /**
     * 删除文章
     */
    @RequestMapping(value="/removeArticle")
    @ResponseBody
    @AuthPassport(authority = "SystemAdmin")
    public JsonResult removeArticle(String id) {
        try {
            if (id != null) {
                int result = cmsArticleService.removeArticleById(id);
                if (result > 0) {
                    return new JsonResult(Constants.RES_SUCCESS, "", 0, null);
                } else {
                    return new JsonResult(Constants.RES_FAIL, "删除失败", 0, null);
                }
            } else {
                return new JsonResult(Constants.RES_FAIL, "删除文章参数错误", 0, null);
            }
        } catch (Exception e) {
            return new JsonResult(Constants.RES_FAIL, "系统异常", 0, null);
        }
    }
    
    /**
     * 发布文章
     *0：已删除 1：编辑 2：发布
     * @param id
     * @return
     */
    @RequestMapping(value="publishArticle")
    @ResponseBody
    @AuthPassport(authority = "SystemAdmin")
    public JsonResult publishArticle(String id) {
    	HashMap<String, Object> map = new HashMap<>();
        CmsArticle cmsArticle = new CmsArticle();
        cmsArticle.setId(id);
        cmsArticle.setStatus("2");
    	cmsArticle.setPublishTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS_NO));
        int update = cmsArticleService.modifyByArticle(cmsArticle);
        return new JsonResult(1, "发布成功", 0, null);
    }

    /**
     * 取消发布文章
     *
     * @param id
     * @return
     */
    @RequestMapping(value="stopArticle")
    @ResponseBody
    @AuthPassport(authority = "SystemAdmin")
    public JsonResult stopArticle(String id) {
    	HashMap<String, Object> map = new HashMap<>();
        CmsArticle cmsArticle = new CmsArticle();
        cmsArticle.setId(id);
        cmsArticle.setStatus("1");
        int update = cmsArticleService.modifyByArticle(cmsArticle);
        return new JsonResult(1, "取消发布成功", 0, null);
    }
    
    /**
     * 提交待审批
     */
    @RequestMapping(value="saveData")
    @ResponseBody
    @AuthPassport(authority = "SystemAdmin")
    public JsonResult saveData(String tableName,String id) {
    	String sql = "";
    	if("mip_spreadtrum".equals(tableName)) {
    		sql = "update mip_spreadtrum set status = '3', updated_time = now()  where id= "+"'"+id+"'";
    	}
    	if("mip_activity".equals(tableName)) {
    		sql = "update mip_activity set status = '3'  where id= "+"'"+id+"'";
    	}
    	if("cms_article".equals(tableName)) {
    		Date updateTime = new Date();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
    		sql = "update cms_article set status = '3', modify_time = "+sdf.format(updateTime)+ "  where id= "+id;
    	}
    	if("mip_virtual_exibition_hall".equals(tableName)) {
    		sql = "update mip_virtual_exibition_hall set status = '3', viLastTime = now()  where id= "+"'"+id+"'";
    	}
    	if("mip_wenchuang".equals(tableName)) {
    		sql = "update mip_wenchuang set publish = 3  where id= "+"'"+id+"'";
    	}
        int update = cmsArticleService.updateSaveData(sql);
        if(update>0) {
        	return new JsonResult(1, "提交成功", 0, null);
        }else {
        	return new JsonResult(0, "提交失败", 0, null);
        }
    }
    
    /**
     * 审批或者退回
     */
    @RequestMapping(value="shenPi")
    @ResponseBody
    @AuthPassport(authority = "SystemAdmin")
    public JsonResult shenPi(String tableName,String id,String result,String message) {
    	String sql = "";
    	Date time = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		SimpleDateFormat sdfb = new SimpleDateFormat("yyyyMMddhh");
		String updateTime = sdf.format(time);
		String wcTime = sdfb.format(time);
    	if("cms_article".equals(tableName)){
	    	if("1".equals(result)){
	    		sql = "update cms_article set status =2, publish_time = "+updateTime+ "  where id= "+"'"+id+"'";
	    	}else{
	    		sql = "update cms_article set status =4, modify_time = "+updateTime+ ",message ="+"'"+message+"'"+"  where id= "+"'"+id+"'";
	    	}
	    }
	    if("mip_virtual_exibition_hall".equals(tableName)){
	    	if("1".equals(result)){
	    		sql = "update mip_virtual_exibition_hall set status = 1, publish_time = now()  where id= "+"'"+id+"'";
	    	}else{
	    		sql = "update mip_virtual_exibition_hall set status = 4, viLastTime = now(),message ="+"'"+message+"'"+"  where id= "+"'"+id+"'";
	    	}
	    }
	    
	    if("mip_spreadtrum".equals(tableName)){
	    	if("1".equals(result)){
	    		sql = "update mip_spreadtrum set status =1, publish_time = now()  where id= "+"'"+id+"'";
	    	}else{
	    		sql = "update mip_spreadtrum set status =4, updated_time = now(),message ="+"'"+message+"'"+"  where id= "+"'"+id+"'";
	    	}
		    	
	    }
	    if("mip_activity".equals(tableName)){
	    	if("1".equals(result)){
	    		sql = "update mip_activity set status =1, publish_time = now()   where id= "+"'"+id+"'";
	    	}else{
	    		sql = "update mip_activity set status =4, publish_time = now(),message ="+"'"+message+"'"+"  where id= "+"'"+id+"'";
	    	}
		    	
	    }
	    if("mip_wenchuang".equals(tableName)){
	    	if("1".equals(result)){
	    		sql = "update mip_wenchuang set publish =1, publish_time ="+wcTime+"   where id= "+"'"+id+"'";
	    	}else{
	    		sql = "update mip_wenchuang set publish =4, publish_time = "+wcTime+",message ="+"'"+message+"'"+"  where id= "+"'"+id+"'";
	    	}
		    	
	    }
        int update = cmsArticleService.updateSaveData(sql);
        if(update>0) {
        	return new JsonResult(1, "提交成功", 0, null);
        }else {
        	return new JsonResult(0, "提交失败", 0, null);
        }
    }
    
	@RequestMapping("/goPublish.do")
	@AuthPassport(authority = "SystemAdmin")
	public String goPublish(Model model,String id,String type,String message,String tableName) {
		model.addAttribute("id", id);
		model.addAttribute("pageType", type);
		model.addAttribute("message", message);
		model.addAttribute("tableName", tableName);
		return "/WEB-INF/back/publish/cmsArticle/GoPublish.jsp";
	}
}
