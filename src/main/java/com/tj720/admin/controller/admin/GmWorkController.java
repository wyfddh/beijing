package com.tj720.admin.controller.admin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.common.util.FileUtil;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.WordToHtml;
import com.tj720.admin.model.GmWork;
import com.tj720.admin.service.GmWorkService;
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
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;



@Controller
@RequestMapping("/gmWork")
public class GmWorkController {
	@Autowired
	private GmWorkService gmWorkService;
	@Autowired
	private UserService userService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired 
	private RegisterInfoService registerInfoService;
	@Autowired
	private Config config;
	
	
	@RequestMapping("/workList")
	@AuthPassport
	public String workList(GmWork gmWork,HttpServletRequest request,
			@RequestParam(defaultValue="1" ,name="page") Integer currentPage,
			@RequestParam(defaultValue = "10")int size,String area,String unit,
			Model model) throws MyException {
		
		Calendar cal = Calendar.getInstance();
		int nowYear = cal.get(Calendar.YEAR); 
		model.addAttribute("nowYear", nowYear);
		model.addAttribute("gmWork", gmWork);
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
		model.addAttribute("name", org.getName());
		String museumId = orgId;
//		String cityName = request.getParameter("cityName");
//		String provinceName = request.getParameter("provinceName");
//		if (!StringUtils.isBlank(cityName)) {
//			gmWork.setName(cityName);
//		} else if (!StringUtils.isBlank(provinceName)) {
//			gmWork.setName(provinceName);
//		} else {
//			
//		}
		//查询组织机构的组织类型
		String orgTypeId = org.getOrgTypeId();
		model.addAttribute("orgTypeId", orgTypeId);
		//定义分页
		Page page= new Page(10); 
		page.setCurrentPage(currentPage);
		page.setSize(size);
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("museumId", museumId);
		map.put("area", area);
		map.put("unit", unit);
		map.put("orgTypeId", orgTypeId);
		map.put("years", gmWork.getYears());
		map.put("name", gmWork.getName());
		Integer count = gmWorkService.countList(map);
		page.setAllRow(count);
		Integer start = page.getStart();
		Integer end = start + page.getSize();
		
		map.put("start", start);
		map.put("end", end-start);
		//查询分页后的数据集合
		List<GmWork> infoList = gmWorkService.findList1(map);
		//文物局
		if ("1".equals(orgTypeId)) {
			
			for (GmWork info : infoList) {
				info.setYears((nowYear - 1) + "");
			}
			JsonResult gmList = new JsonResult(1,infoList,page);
			model.addAttribute("gmList", gmList);
			
			String jsonString = JSON.toJSONString(infoList);
			model.addAttribute("jsonString", jsonString);
			int maxYears = 0;
			int newYears = 0;
			String gmYear = "";
			List<GmWork> findListByMuseumId = gmWorkService.findListByMuseumId(museumId);
			if (findListByMuseumId.size() > 0) {
				maxYears = gmWorkService.getMaxYears(museumId);
				newYears = maxYears + 1;
				gmYear = maxYears + "";
				
			} else {
				SimpleDateFormat df = new SimpleDateFormat("yyyy");
				String format = df.format(new Date());
				newYears = Integer.parseInt(format) - 1;
				gmYear = newYears + "";
			}
			model.addAttribute("maxYears", maxYears);
			
			//查询年度
			
			model.addAttribute("newYears", newYears);
			String workName = newYears +"年度"+ org.getName() + "工作总结";
			model.addAttribute("newWorkName", workName);
			//同年填写总结的博物馆数量
			int workCount = gmWorkService.selectAll(gmYear);
			model.addAttribute("workCount", workCount);
			//查询博物馆总数
			List<MipOrganization> all = registerInfoService.selectAllCount1(museumId);
			model.addAttribute("allCount", all.size()-workCount);
			//查询所有区文委
			List<MipOrganization> mipOrganizationArea =mipOrganizationService.getListByOrgTypeId("2");
			model.addAttribute("area", mipOrganizationArea);
			//查询已选择的市下的所有博物馆
			if (StringUtils.isNotBlank(area)) {
				List<MipOrganization> mipOrganizationUnit = mipOrganizationService.getListByArea(area);
				model.addAttribute("unit", mipOrganizationUnit);
			}
			
		} else {        // 其他
			
			JsonResult gmList = new JsonResult(1,infoList,page);
			model.addAttribute("gmList", gmList);
			
			String jsonString = JSON.toJSONString(infoList);
			model.addAttribute("jsonString", jsonString);
			int maxYears = 0;
			int newYears = 0;
			List<GmWork> findListByMuseumId = gmWorkService.findListByMuseumId(museumId);
			if (findListByMuseumId.size() > 0) {
				maxYears = gmWorkService.getMaxYears(museumId);
				newYears = maxYears + 1;
			} else {
				SimpleDateFormat df = new SimpleDateFormat("yyyy");
				String format = df.format(new Date());
				newYears = Integer.parseInt(format) - 1;
			}
			//查询年度
			
			model.addAttribute("newYears", newYears);
			String workName = newYears +"年度"+ org.getName() + "工作总结";
			model.addAttribute("newWorkName", workName);
			
			model.addAttribute("maxYears", maxYears);
			
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
			return "/WEB-INF/back/gm/workList2.jsp";
		} else {
			return "/WEB-INF/back/gm/workList.jsp";
		}
		
	}
	@RequestMapping("/mySummary")
	@AuthPassport
	public String mySummary(GmWork gmWork,@RequestParam(defaultValue="1" ,name="page") Integer currentPage,Model model) {
		
		Calendar cal = Calendar.getInstance();
		int nowYear = cal.get(Calendar.YEAR);
		model.addAttribute("nowYear", nowYear);
		
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = us.getOrgId();
		MipOrganization org = mipOrganizationService.get(orgId);
		model.addAttribute("name", org.getName());
		String museumId = orgId;
		//查询组织机构的级别
		String orgTypeId = org.getOrgTypeId();
		model.addAttribute("orgTypeId", orgTypeId);
		//定义分页
		Page page= new Page(15);
		page.setCurrentPage(currentPage);
		page.setSize(10);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("museumId", museumId);
		//查询记录总数
		Integer count = gmWorkService.countMySummary(map);
		page.setAllRow(count);
		Integer start = page.getStart();
		Integer end = start + page.getSize();
		
		map.put("start", start);
		map.put("end", end-start);
		map.put("orgTypeId", orgTypeId);
		//查询分页后的数据集合
		List<GmWork> infoList = gmWorkService.findMySummary(map);
		JsonResult gmList = new JsonResult(1,infoList,page);
		model.addAttribute("gmList", gmList);
		
		String jsonString = JSON.toJSONString(infoList);
		model.addAttribute("jsonString", jsonString);
		int maxYears = 0;
		int newYears = 0;
		List<GmWork> findListByMuseumId = gmWorkService.findListByMuseumId(museumId);
		if (findListByMuseumId.size() > 0) {
			maxYears = gmWorkService.getMaxYears(museumId);
			newYears = maxYears + 1;
		} else {
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String format = df.format(new Date());
			newYears = Integer.parseInt(format) - 1;
		}
		//查询年度
		model.addAttribute("newYears", newYears);
		String workName = newYears +"年度"+ org.getName() + "工作总结";
		model.addAttribute("newWorkName", workName);	
		
		model.addAttribute("maxYears", maxYears);
		return "/WEB-INF/back/gm/workList.jsp";
			
		
		
	}
	@RequestMapping("/upload")
	@AuthPassport
	public String upload(@RequestParam("id") String id,HttpServletRequest request,@RequestParam("file") MultipartFile file,Model model,@RequestParam("years") String years) throws IllegalStateException, IOException {
		
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = us.getOrgId();
		MipOrganization org = mipOrganizationService.get(orgId);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String format = df.format(new Date());
		
		String rootPath = config.getRootPath();
		
		String path = "";
		if (StringUtils.isBlank(id)) {
			
			String workName = years+"年度"+ org.getName() + "工作总结";
			
			
			//上传文件路径
//			String path = request.getSession().getServletContext().getRealPath("/upload/") + workName +"/";
			path =  rootPath + "workUpload/" + workName + "/";
			System.out.println(path);
			//上传文件名
			String filename = file.getOriginalFilename();
			File filepath = new File(path,filename);
			//判断路径是否存在，如果不存在就创建一个
			if (!filepath.getParentFile().exists()) { 
				filepath.getParentFile().mkdirs();
			}
			if(file.isEmpty()){
				System.out.println(111);
			}
			file.transferTo(new File(path + "/" + filename));
			
			GmWork gmWork = new GmWork();
			String nextid = IdUtils.nextId(gmWork);
			gmWork.setId(nextid);
			gmWork.setWorkName(workName);
			gmWork.setMuseumId(org.getId());
			gmWork.setYears(years);
			gmWork.setWorkStatus(0);
			gmWork.setFileUpload(workName + "/" + filename);
			
			
			
			//设置创建时间
			gmWork.setCreatDate(format);
			//第一次认为更新时间就是创建时间
			gmWork.setUpdateDate(format);
			gmWork.setUpdaterId(us.getId());
			
			gmWorkService.save(gmWork);
			
		} else {
			GmWork gmWork = gmWorkService.selectById(id);
			gmWork.setUpdateDate(format);
			gmWork.setUpdaterId(us.getId());
			// 如果文件是空，就是没修改，直接更新，否则更新上传文件
			if (file.getSize() != 0) {
				//上传文件路径
//				String path = request.getSession().getServletContext().getRealPath("/upload/") + gmWork.getWorkName() +"/";
				path =  rootPath + "workUpload/" + gmWork.getWorkName() + "/";
				
				System.out.println(path);
				//上传文件名
				String filename = file.getOriginalFilename();
				File filepath = new File(path,filename);
				
				//判断路径是否存在，如果不存在就创建一个
				if (!filepath.getParentFile().exists()) { 
					filepath.getParentFile().mkdirs();
				} 
				FileUtil.deleteFloderFile(path.substring(0, path.lastIndexOf("/")));
				
				file.transferTo(new File(path + "/" + filename));
				
				gmWork.setFileUpload(gmWork.getWorkName() + "/" + filename);
				
			}
			gmWorkService.update(gmWork);
		}
		
		return "redirect:/gmWork/mySummary.do";
	}
	
	@ResponseBody
	@RequestMapping("form")
	@AuthPassport
	public GmWork form(@RequestParam("id") String id,Model model){
		
		GmWork gmWork = gmWorkService.selectById(id);
		String fileUpload = gmWork.getFileUpload();
		String fileName = fileUpload.substring(fileUpload.lastIndexOf("/")+1);
		gmWork.setFileUpload(fileName);
		
		return gmWork;
	}
	
	@RequestMapping("submit")
	@AuthPassport
	public String submit(@RequestParam("id") String id,Model model) {
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String format = df.format(new Date());
		
		GmWork gmWork = gmWorkService.selectById(id);
		gmWork.setWorkStatus(1);
		gmWork.setUpdateDate(format);
		gmWork.setUpdaterId(us.getId());
		gmWorkService.update(gmWork);
		
		
		return "redirect:/gmWork/mySummary.do";
	}
	
	@RequestMapping("download")
	@AuthPassport
	public ResponseEntity<byte[]> download(@RequestParam("id") String id,HttpServletRequest request,HttpServletResponse response) {
		
		GmWork gmWork = gmWorkService.selectById(id);
		String workName = gmWork.getWorkName();
		String fileUpload = gmWork.getFileUpload();
		String fileName = fileUpload.substring(fileUpload.indexOf("/")+1, fileUpload.length());
		System.out.println(fileName);
		try {
	            request.setCharacterEncoding("UTF-8");//设定请求字符编码
	    } catch (UnsupportedEncodingException e1) {
	            e1.printStackTrace();
	    }
        java.io.BufferedInputStream bis = null;//创建输入输出流
        java.io.BufferedOutputStream bos = null;
//	        String ctxPath = request.getSession().getServletContext().getRealPath("/") + "upload/";//获取文件真实路径
//        String ctxPath = request.getSession().getServletContext().getRealPath("/upload/") + workName +"/";
        
        String ctxPath = config.getRootPath() + "workUpload/" + workName + "/";
        System.out.println(ctxPath);
        String downLoadPath = ctxPath + fileName;
        System.out.println(downLoadPath);
        try {
            long fileLength = new File(downLoadPath).length();//获取文件长度
            response.setContentType("application/x-msdownload;");//下面这三行是固定形式
//	            response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
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
                    e.printStackTrace();
                }
            if (bos != null)
                try {
                    bos.close();//关闭输出流
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return null;
	}
	
	@AuthPassport
	@ResponseBody
	@RequestMapping(value = "show",produces={"text/html;charset=UTF-8;","application/json;"})
	public String show(@RequestParam("id") String id,Model model,HttpServletRequest request) throws Throwable {
		
		GmWork gmWork = gmWorkService.selectById(id);
//		String fileUpload = request.getSession().getServletContext().getRealPath("/upload/")+ gmWork.getFileUpload();
		
		String fileUpload = config.getRootPath() + "workUpload/" + gmWork.getFileUpload();

		File file = new File(fileUpload); 
		if(file.exists()){
			System.out.println(1);
		}
		//前缀
		String path = fileUpload.substring(0, fileUpload.lastIndexOf("/")+1);
		
		//后缀
		String fileName = fileUpload.substring(fileUpload.lastIndexOf("/")+1);
		String msg = "";
		try {
//			if (file.getName().endsWith(".docx") || file.getName().endsWith(".DOCX")) {
//				Convert.docxToHtml(path,fileName);
//				
//			} else {
//				Convert.docToHtml(path, fileName);
//			} 
			WordToHtml.convertWordToHtml(path, fileName);
			msg = "ok";
		} catch (Exception e) {
			e.printStackTrace();
			try {
				WordToHtml.docToHtml(path, fileName);
				msg = "ok";
			} catch (Exception e2) {
				e2.printStackTrace();
				msg = "error";
			}
		}
		String fileUrl = config.getRootUrl() + "workUpload/" + gmWork.getFileUpload().substring(0, gmWork.getFileUpload().lastIndexOf("/")+1) + "index.html";
		Map<String,String> map = new HashMap<String,String>();
		
		String name = gmWork.getWorkName();
		map.put("name", name);
		map.put("msg", msg);
		map.put("fileUrl", fileUrl);
		System.out.println(name);
		String jsonString = JSON.toJSONString(map);
		return jsonString; 
	}
	
	 
}
