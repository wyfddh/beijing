package com.tj720.admin.controller.admin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.model.GmAudit;
import com.tj720.admin.model.GmReportForm;
import com.tj720.admin.model.GmReportUpload;
import com.tj720.admin.model.RegisterInfo;
import com.tj720.admin.service.GmAuditService;
import com.tj720.admin.service.GmReportFormService;
import com.tj720.admin.service.GmReportUploadService;
import com.tj720.admin.service.RegisterInfoService;
import com.tj720.mip.dto.AdminSearchListDto;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;


@RequestMapping("/registerInfo")
@Controller
public class GmRegisterInfoController extends BaseController{
		
	@Autowired 
	private RegisterInfoService registerInfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired 
	private GmReportFormService gmReportFormService;
	@Autowired
	private GmReportUploadService gmReportUploadService;
	@Autowired
	private GmAuditService gmAuditService;
	
	@RequestMapping("/getInfoList")
	@AuthPassport
	public String gmreportlist (RegisterInfo registerInfo,
			@RequestParam(defaultValue="1" ,name="page") Integer currentPage,
			@RequestParam(defaultValue = "15")int size,String area,String unit,Model model) throws MyException {
		
		Calendar cal = Calendar.getInstance();
		int nowYear = cal.get(Calendar.YEAR);
		
		int maxYear = 0;
		
		model.addAttribute("registerInfo", registerInfo);
		AdminSearchListDto adminSearchListDto = new AdminSearchListDto();
		adminSearchListDto.setArea(area);
		adminSearchListDto.setUnit(unit);
		model.addAttribute("dto", adminSearchListDto); 
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = us.getOrgId();
		MipOrganization org = mipOrganizationService.get(orgId);
		//查询组织机构的组织类型
		String orgTypeId = org.getOrgTypeId();
		String museumId = orgId;
		model.addAttribute("orgTypeId", orgTypeId);
		model.addAttribute("name", org.getName());
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		//定义分页
		Page page= new Page(size);
		page.setCurrentPage(currentPage);
		page.setSize(size); 
		
		map.put("name", registerInfo.getName());
		map.put("orgTypeId", orgTypeId);
		map.put("museumId", museumId);
		map.put("area", area);
		map.put("unit", unit);
		map.put("years", registerInfo.getYears());
		
		Integer count = registerInfoService.countList1(map);
		page.setAllRow(count);
		Integer start = page.getStart();
		Integer end = start + page.getSize();
		
		map.put("start", start);
		map.put("end", end-start); 
		//查询分页后的数据集合
		List<RegisterInfo> infoList = registerInfoService.findList1(map);
		JsonResult gmList = new JsonResult(1,infoList,page);
		model.addAttribute("gmList", gmList);
		//转成json格式方便页面js直接遍历
		String jsonString = JSON.toJSONString(infoList);
		model.addAttribute("jsonString", jsonString);
		
		//文物局
		if ("1".equals(orgTypeId)) {
			
			
			for (RegisterInfo info : infoList) {
				if (StringUtils.isBlank(info.getId())) {
					info.setYears(nowYear-1);
				}
			} 
			
			
			
			Integer gmYear = nowYear - 1;
			//查询填写申报的总记录
			List<RegisterInfo> li = registerInfoService.selectAll(gmYear);
			
			model.addAttribute("count", li.size());
			//查询博物馆总数
			int allCount = registerInfoService.selectAllCount(museumId);
			model.addAttribute("allCount", allCount-li.size());
			//查询所有区文委
			//List<MipOrganization> mipOrganizationArea = mipOrganizationService.getListById(orgId);
			List<MipOrganization> mipOrganizationArea =mipOrganizationService.getListByOrgTypeId("2");
			model.addAttribute("area", mipOrganizationArea);
			if (StringUtils.isNotBlank(area)) {
				//查询已选择的市下的所有博物馆
				List<MipOrganization> mipOrganizationUnit = mipOrganizationService.getListByArea(area);
				model.addAttribute("unit", mipOrganizationUnit);
			}
			
			
		} else {  // 市及以下
			
			try {
				maxYear = registerInfoService.getMaxYears(museumId);
				
			} catch (Exception e) {
				
			}
			
			//查询该市文物局
			MipOrganization mipOrganizationArea =  mipOrganizationService.get(orgId);
			List<MipOrganization> mipOrganizationAreas = new ArrayList<MipOrganization>();
			mipOrganizationAreas.add(mipOrganizationArea);
			model.addAttribute("area", mipOrganizationAreas); 
			//查询已选择的市下的所有博物馆
			if (StringUtils.isNotBlank(area)) {
				List<MipOrganization> mipOrganizationUnit = mipOrganizationService.getListByArea(area);
				model.addAttribute("unit", mipOrganizationUnit);
			}
		} 
		
		if ("1".equals(orgTypeId) || "2".equals(orgTypeId)) {
			return "/WEB-INF/back/gm/auditList.jsp"; 
		} else {
			model.addAttribute("maxYear", maxYear);
			model.addAttribute("nowYear", nowYear);
			return "/WEB-INF/back/gm/registerInfo.jsp";
			
		}
		
	}
	
	@AuthPassport
	@RequestMapping("/promiseList")
	public String promiseList(Model model) {
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = us.getOrgId();
		MipOrganization org = mipOrganizationService.get(orgId);
		String name = org.getName();
		model.addAttribute("name", name);
		int maxYears = 0;
		int newYears = 0;
		List<RegisterInfo> findListByMuseumId = registerInfoService.findListByMuseumId(orgId);
		if (findListByMuseumId.size() > 0) {
			maxYears = registerInfoService.getMaxYears(orgId);
			newYears = maxYears + 1;
		} else {
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String format = df.format(new Date());
			newYears = Integer.parseInt(format) - 1;
		}
		model.addAttribute("newYears", newYears);
		
		return "/WEB-INF/back/gm/promiseList.jsp";
	}
	@AuthPassport
	@RequestMapping("/reportForm")
	public String reportForm(@RequestParam("years") int years,Model model) {
		
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = us.getOrgId();
		MipOrganization org = mipOrganizationService.get(orgId);
		String name = org.getName();
		
		
		RegisterInfo registerInfo = new RegisterInfo();
		registerInfo.setYears(years);
		registerInfo.setMuseumId(org.getId());
		List<RegisterInfo> selectByEntity = registerInfoService.getByEntity(registerInfo);
		if (selectByEntity.size() > 0) {
			RegisterInfo registerInfo2 = selectByEntity.get(0);
			
			model.addAttribute("registerInfo", registerInfo2);
			GmReportForm gmReportForm = gmReportFormService.getByReportId(registerInfo2.getId());
			model.addAttribute("gmReportForm", gmReportForm);
		} else {
			
			String nextId = IdUtils.nextId(registerInfo);
			
			
			//生成id
			registerInfo.setId(nextId);
			//申报名
			registerInfo.setReportName(years + "年度" + name + "绩效考评申报");
			//吧组织机构的主键作为博物馆id
			registerInfo.setMuseumId(org.getId());
			//年度
			registerInfo.setYears(years);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String format = df.format(new Date());
			//设置创建时间
			registerInfo.setCreatDate(format);
			//第一次认为更新时间就是创建时间
			registerInfo.setUpdateDate(format);
			//第一次认为更新者就是创建者
			registerInfo.setUpdaterId(us.getId());
			//默认状态未提交
			registerInfo.setReportStatus(0);
			//默认由市审核
			registerInfo.setExamineLevel(1);
			
			registerInfoService.save(registerInfo);
			model.addAttribute("registerInfo", registerInfo);
			
			//新建一张默认表，方便用户输入
			GmReportForm gmReportForm = new GmReportForm();
			
			String id = IdUtils.nextId(gmReportForm);
			gmReportForm.setId(id);
			gmReportForm.setReportId(nextId);
			gmReportForm.setMuseumProperty(1);
			gmReportForm.setMuseumRelation(1);
			gmReportForm.setMuseumType("1");
			gmReportForm.setLegalPersonType("1");
			gmReportForm.setNowLevel(1);
			gmReportForm.setLegalPersonSex(0);
			gmReportForm.setEnvironmentControl(1);
			gmReportForm.setPreciousControl(1);
			gmReportForm.setExitAcademicCommittee(1);
			gmReportForm.setExitAcademicAwards(1);
			gmReportForm.setOpenDigitalExhibition(1);
			gmReportForm.setDevelopCultureProduct(1);
			gmReportForm.setExitNationalAward(1);
			gmReportForm.setExitVolunteering(1);
			gmReportForm.setExitRiskProof(1);
			gmReportForm.setExitFireProof(1);
			
			gmReportFormService.save(gmReportForm);
			model.addAttribute("gmReportForm", gmReportForm);
		}
		
		
		return "/WEB-INF/back/gm/reportForm.jsp";
	}
	@AuthPassport
	@RequestMapping("/selfScore")
	public String selfScore(Model model,RegisterInfo registerInfo) {
		
		RegisterInfo registerInfoNew = registerInfoService.getById(registerInfo.getId());
		model.addAttribute("registerInfo", registerInfoNew);
		
		registerInfo.setReportStatus(1);
		registerInfoService.update(registerInfo);
		
	
			
		//初始化审核
		GmAudit gmAudit = new GmAudit();
		String nextId = IdUtils.nextId(gmAudit);
		gmAudit.setId(nextId);
		gmAudit.setReportId(registerInfo.getId());
		//开始是市审核
		gmAudit.setAuditLevel(1);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String format = df.format(new Date());
		gmAudit.setUpdateDate(format);
		gmAuditService.save(gmAudit);
		
		return "redirect:/registerInfo/getInfoList.do";
	}
	
	//提交
	@RequestMapping("/submit")
	@AuthPassport
	public String submit(@RequestParam("reportId") String reportId,Model model) {
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		RegisterInfo registerInfo = registerInfoService.getById(reportId);
		model.addAttribute("registerInfo", registerInfo);
		registerInfo.setReportStatus(1);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String format = df.format(new Date());
		registerInfo.setUpdateDate(format);
		registerInfo.setUpdaterId(us.getId());
		registerInfoService.update(registerInfo);
		
		
		//初始化审核
		GmAudit gmAudit = gmAuditService.getByReportId(reportId);
		
		if (gmAudit == null) {
			gmAudit = new GmAudit();
			//开始是市审核
			gmAudit.setAuditLevel(1);
			String nextId = IdUtils.nextId(gmAudit);
			gmAudit.setId(nextId);
			gmAudit.setReportId(reportId);
			
			gmAuditService.save(gmAudit);
		} else {
			gmAudit.setCityReviewResult("");
			//开始是市审核
			gmAudit.setAuditLevel(1);
			gmAuditService.update(gmAudit);
		}
		
		
		return "redirect:/registerInfo/getInfoList.do";
	}
	
	@RequestMapping("/auditView")
	@AuthPassport
	public String auditView(@RequestParam("reportId") String reportId,Model model) throws ParseException {
		
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = us.getOrgId();
		MipOrganization org = mipOrganizationService.get(orgId);
		//查询组织机构的组织类型
		String orgTypeId = org.getOrgTypeId();
		
		RegisterInfo report = registerInfoService.getById(reportId);
		
		GmReportForm gmReportForm = gmReportFormService.getByReportId(reportId);
		
		GmAudit gmAudit = gmAuditService.getByReportId(reportId);
		
		
		//设置几个时间格式
		if (!StringUtils.isBlank(gmReportForm.getNowLevelDate())) {
			gmReportForm.setNowLevelDate(new SimpleDateFormat("yyyy年MM月").format(new SimpleDateFormat("yyyy-MM").parse(gmReportForm.getNowLevelDate())));
		}
		if (!StringUtils.isBlank(gmReportForm.getCreatDate())) {
			gmReportForm.setCreatDate(new SimpleDateFormat("yyyy年MM月dd日").format(new SimpleDateFormat("yyyy-MM-dd").parse(gmReportForm.getCreatDate())));
		}
		if (!StringUtils.isBlank(gmReportForm.getOpenDate())) {
			gmReportForm.setOpenDate(new SimpleDateFormat("yyyy年MM月").format(new SimpleDateFormat("yyyy-MM").parse(gmReportForm.getOpenDate())));
		}
		if (!StringUtils.isBlank(gmReportForm.getLegalPersonBirth())) {
			gmReportForm.setLegalPersonBirth(new SimpleDateFormat("yyyy年MM月").format(new SimpleDateFormat("yyyy-MM").parse(gmReportForm.getLegalPersonBirth())));
		}
		List<GmReportUpload> reportUploads = gmReportUploadService.getByReportId(reportId);
		
		model.addAttribute("report", report);
		model.addAttribute("gmReportForm", gmReportForm);
		model.addAttribute("reportUploads", reportUploads);
		model.addAttribute("gmAudit", gmAudit);
		model.addAttribute("orgTypeId", orgTypeId);
		
		//转成json格式
		String jsonString = JSON.toJSONString(reportUploads);
		model.addAttribute("jsonString", jsonString);
		
		String jsonStr = JSON.toJSONString(gmAudit);
		model.addAttribute("jsonStr", jsonStr);
		
		return "/WEB-INF/back/gm/auditView.jsp";
	}
	
	@RequestMapping("auditDown")
	@AuthPassport
	public ResponseEntity<byte[]> auditDown(@RequestParam("reportId") String reportId,@RequestParam("filename") String fileName,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		RegisterInfo registerInfo = registerInfoService.getById(reportId);
		String reportName = registerInfo.getReportName();
		List<GmReportUpload> reportUploads = gmReportUploadService.getByReportId(reportId);
		for (GmReportUpload gmReportUpload : reportUploads) {
			if (fileName.equals(gmReportUpload.getRealName())) {
				fileName = gmReportUpload.getUoloadName();
			}
		}
		
        System.out.println(fileName);
//        response.setContentType("application/vnd.ms-excel;charset=utf-8"); /*设定相应类型 编码*/
        try {
            request.setCharacterEncoding("UTF-8");//设定请求字符编码
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        java.io.BufferedInputStream bis = null;//创建输入输出流
        java.io.BufferedOutputStream bos = null;

//        String ctxPath = request.getSession().getServletContext().getRealPath("/") + "upload/";//获取文件真实路径
        String ctxPath = request.getSession().getServletContext().getRealPath("/upload/") + reportName +"/";
        System.out.println(ctxPath);
        String downLoadPath = ctxPath + fileName;
        System.out.println(downLoadPath);
        try {
            long fileLength = new File(downLoadPath).length();//获取文件长度
            response.setContentType("application/x-msdownload;");//下面这三行是固定形式
//            response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            response.setHeader("Content-disposition", "attachment; filename=" +  URLEncoder.encode(fileName, "UTF-8"));
           
            response.setHeader("Content-Length", String.valueOf(fileLength));
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));//创建输入输出流实例
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];//创建字节缓冲大小
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null)
                try {
                    bis.close();//关闭输入流
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            if (bos != null)
                try {
                    bos.close();//关闭输出流
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return null;
	}
	//审核
	@RequestMapping("reviewResult1")
	@AuthPassport
	public String reviewResult1(@RequestParam("id") String reportId,@RequestParam("resultScore1") Integer resultScore,@RequestParam("reviewResult") String reviewResult,Model model) {
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		
		
		RegisterInfo registerInfo = registerInfoService.getById(reportId);
		registerInfo.setReportStatus(2);
		registerInfo.setResultScore(resultScore);
		registerInfo.setExamineLevel(2);
		registerInfoService.update(registerInfo);
		
		GmAudit gmAudit = gmAuditService.getByReportId(reportId);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String format = df.format(new Date());
		
//		gmAudit.setProvinceAuditDate(format);
//		gmAudit.setProvinceAuditerId(us.getId());
//		gmAudit.setProvinceAuditResult(resultScore);
//		gmAudit.setProvinceReviewResult(reviewResult);
		gmAudit.setCityAuditDate(format);
		gmAudit.setCityAuditerId(us.getId());
		gmAudit.setCityAuditResult(resultScore);
		gmAudit.setCityReviewResult(reviewResult);
		gmAudit.setAuditLevel(2);
		
		gmAudit.setUpdateDate(format);
		gmAuditService.update(gmAudit);
		
		return "redirect:/registerInfo/getInfoList.do";
	}
	//旧-市审核
	@RequestMapping("reviewResult3")
	@AuthPassport
	public String reviewResult3(@RequestParam("id") String reportId,@RequestParam("resultScore2") Integer resultScore,@RequestParam("reviewResult") String reviewResult,Model model) {
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		
		GmAudit gmAudit = gmAuditService.getByReportId(reportId);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String format = df.format(new Date());
		
		gmAudit.setCityAuditDate(format);
		gmAudit.setCityAuditerId(us.getId());
		gmAudit.setCityAuditResult(resultScore);
		gmAudit.setCityReviewResult(reviewResult);
		gmAudit.setUpdateDate(format);
		
		RegisterInfo registerInfo = registerInfoService.getById(reportId);
		
		if (resultScore == 0) {
			registerInfo.setReportStatus(3);
			registerInfoService.update(registerInfo);
			
		} else {
			//市审核完毕，进行省审核
			gmAudit.setAuditLevel(2);
			registerInfo.setExamineLevel(2);
			registerInfoService.update(registerInfo);
		}
		
		gmAuditService.update(gmAudit);
		
		return "redirect:/registerInfo/getInfoList.do";
	}
	//驳回
	@RequestMapping("reviewResult2")
	@AuthPassport
	public String reviewResul2(@RequestParam("id") String reportId,@RequestParam("reviewResult") String reviewResult,Model model) {
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		
		RegisterInfo registerInfo = registerInfoService.getById(reportId);
		
		registerInfo.setExamineLevel(1);
		registerInfo.setReportStatus(3);
		registerInfoService.update(registerInfo);
		
		GmAudit gmAudit = gmAuditService.getByReportId(reportId);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String format = df.format(new Date());
		
		
//		gmAudit.setProvinceAuditDate(format);
//		gmAudit.setProvinceAuditerId(us.getId());
//		gmAudit.setProvinceAuditResult(3);
//		gmAudit.setProvinceReviewResult(reviewResult);
		
		gmAudit.setCityAuditDate(format);
		gmAudit.setCityAuditerId(us.getId());
		gmAudit.setCityAuditResult(3);
		gmAudit.setCityReviewResult(reviewResult);
		gmAuditService.update(gmAudit);
		
		return "redirect:/registerInfo/getInfoList.do";
	}
}
