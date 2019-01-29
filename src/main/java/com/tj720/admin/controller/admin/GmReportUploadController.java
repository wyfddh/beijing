package com.tj720.admin.controller.admin;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.common.util.FileUtil;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.POIUtil;
import com.tj720.admin.model.GmReportUpload;
import com.tj720.admin.model.MsgMapVo;
import com.tj720.admin.model.RegisterInfo;
import com.tj720.admin.service.GmBaseDisplayListService;
import com.tj720.admin.service.GmCollectionListService;
import com.tj720.admin.service.GmCollectionRepairListService;
import com.tj720.admin.service.GmCulturalProductsService;
import com.tj720.admin.service.GmEduProjectListService;
import com.tj720.admin.service.GmEmployeeTrainSituationService;
import com.tj720.admin.service.GmEquipmentRepairSituationService;
import com.tj720.admin.service.GmInoroutExhibitionListService;
import com.tj720.admin.service.GmMuseumMediaDevelopService;
import com.tj720.admin.service.GmReportUploadService;
import com.tj720.admin.service.GmScienceConferenceService;
import com.tj720.admin.service.GmScientificResearchListService;
import com.tj720.admin.service.GmTemporaryExhibitListService;
import com.tj720.admin.service.RegisterInfoService;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.utils.MyString;


@Controller
@RequestMapping("/gmReportUpload")
public class GmReportUploadController {
	@Autowired 
	private GmReportUploadService gmReportUploadService;
	
	@Autowired
	private RegisterInfoService registerInfoService;
	@Autowired
	private GmCollectionListService gmCollectionListService;
	@Autowired
	private GmCollectionRepairListService gmCollectionRepairListService;
	@Autowired
	private GmScienceConferenceService gmScienceConferenceService;
	@Autowired
	private GmScientificResearchListService gmScientificResearchListService;
	@Autowired
	private GmBaseDisplayListService gmBaseDisplayListService;
	@Autowired 
	private GmTemporaryExhibitListService gmTemporaryExhibitListService;
	@Autowired
	private GmInoroutExhibitionListService gmInoroutExhibitionListService;
	@Autowired
	private GmEduProjectListService gmEduProjectListService;
	@Autowired
	private GmCulturalProductsService gmCulturalProductsService;
	@Autowired
	private GmEquipmentRepairSituationService gmEquipmentRepairSituationService;
	@Autowired
	private GmEmployeeTrainSituationService gmEmployeeTrainSituationService;
	@Autowired
	private GmMuseumMediaDevelopService gmMuseumMediaDevelopService;
	
	
	
	@RequestMapping("/form")
	@AuthPassport
	public String form(@ModelAttribute("msgMapVo") MsgMapVo msgMapVo,@ModelAttribute("redirectReportId") String redirectReportId,
			@RequestParam(value="reportId", required=false) String reportId,Model model) {
		
		if (!StringUtils.isBlank(redirectReportId)) {
			reportId = redirectReportId;
		}
		RegisterInfo registerInfo = registerInfoService.getById(reportId);
		
		model.addAttribute("registerInfo", registerInfo);
		Map<Integer, String> msgMap = msgMapVo.getMsgMapVo();
		String jsonMsgList = "";
		if (!MyString.isEmpty(msgMap)) {
			jsonMsgList = JSON.toJSONString(msgMap);
		} else {
			jsonMsgList = JSON.toJSONString("success");
		}
		model.addAttribute("jsonMsgList", jsonMsgList);
		if (StringUtils.isBlank(reportId)) {
			return "redirect:/registerInfo/getInfoList.do";
		} else {
			
			List<GmReportUpload> reportList = gmReportUploadService.getByReportId(reportId);
			//转成json格式方便页面js直接遍历
			String jsonString = JSON.toJSONString(reportList);
			model.addAttribute("jsonString", jsonString);
			
			//初始化创建28条数据状态为0未上传
			
			if (reportList.size() <= 0) {
				for (int i = 0; i < 28; i++) {
					GmReportUpload gmReportUpload = new GmReportUpload();
					gmReportUpload.setId(IdUtils.nextId(gmReportUpload));
					gmReportUpload.setReportId(reportId);
					gmReportUpload.setUoloadStatus("0");
					reportList.add(gmReportUpload);
				}
				reportList.get(0).setRealName("附件1博物馆章程");
				reportList.get(1).setRealName("附件2博物馆财务管理制度");
				reportList.get(2).setRealName("附件3博物馆年度审计报告、财务报表或决算报告");
				reportList.get(3).setRealName("附件4博物馆安全防范制度");
				reportList.get(4).setRealName("附件5由公安部门出具的博物馆风险等级达标证明");
				reportList.get(5).setRealName("附件6消防部门给博物馆出具的消防达标证明");
				reportList.get(6).setRealName("附件7博物馆藏品管理制度");
				reportList.get(7).setRealName("附件8博物馆藏品备案、确权情况证明");
				reportList.get(8).setRealName("附件9藏品征集清单");
				reportList.get(9).setRealName("附件10馆内藏品修复清单");
				reportList.get(10).setRealName("附件11馆内重度腐蚀文物清单");
				reportList.get(11).setRealName("附件12举办、参加学术会议情况");
				reportList.get(12).setRealName("附件13研究成果清单");
				reportList.get(13).setRealName("附件14博物馆展厅平面图");
				reportList.get(14).setRealName("附件15基本陈列清单");
				reportList.get(15).setRealName("附件16临时展览清单");
				reportList.get(16).setRealName("附件17引进输出展览清单");
				reportList.get(17).setRealName("附件18博物馆展览、讲解词备案情况证明");
				reportList.get(18).setRealName("附件19博物馆展览简介");
				reportList.get(19).setRealName("附件20博物馆讲解");
				reportList.get(20).setRealName("附件21教育项目清单");
				reportList.get(21).setRealName("附件22文化产品开发清单");
				reportList.get(22).setRealName("附件23博物馆网站、新媒体服务建设情况");
				reportList.get(23).setRealName("附件24设备购置和设备维修情况");
				reportList.get(24).setRealName("附件25员工专业进修、培训活动情况");
				reportList.get(25).setRealName("附件26获奖证明材料");
				reportList.get(26).setRealName("附件27自评分材料");
				reportList.get(27).setRealName("附件28其他（可提交展览和教育活动现场图片资料或文字简介）");
				gmReportUploadService.saveList(reportList);
			}
			
			
			return "/WEB-INF/back/gm/reportUploadForm.jsp";
		}
	}
	
	@RequestMapping("upload")
	@AuthPassport
	public String upload(@RequestParam("status") int status,@RequestParam("reportId") String reportId,HttpServletRequest request,@RequestParam("file") MultipartFile[] files,Model model,RedirectAttributes redirectModel,@RequestParam("hideData") ArrayList<Integer> arr) throws Exception {
		RegisterInfo registerInfo = registerInfoService.getById(reportId);
		model.addAttribute("registerInfo", registerInfo);
		String reportName = registerInfo.getReportName();
		//Arrays.sort(arr);
		ConcurrentMap<Integer,String> msgMap = new ConcurrentHashMap<Integer,String>();
		for(int i=0;i<files.length;i++){
			if (!files[i].isEmpty()) { 
				//上传文件路径
				String path = request.getSession().getServletContext().getRealPath("/upload/") + reportName +"/";
				System.out.println(path);
				//上传文件名
				String filename = files[i].getOriginalFilename();
				//获取后缀名
				String suffix = filename.substring(filename.lastIndexOf("."));
				
				if (arr.get(i) == 1) {
					filename =  "附件1博物馆章程" + suffix;
				} else if (arr.get(i) == 2) {
					filename =  "附件2博物馆财务管理制度" + suffix;
				} else if (arr.get(i) == 3) {
					filename =  "附件3博物馆年度审计报告、财务报表或决算报告" + suffix;
				} else if (arr.get(i) == 4) {
					filename =  "附件4博物馆安全防范制度" + suffix;
				} else if (arr.get(i) == 5) {
					filename =  "附件5由公安部门出具的博物馆风险等级达标证明" + suffix;
				} else if (arr.get(i) == 6) {
					filename =  "附件6消防部门给博物馆出具的消防达标证明" + suffix;
				} else if (arr.get(i) == 7) {
					filename =  "附件7博物馆藏品管理制度" + suffix;
				} else if (arr.get(i) == 8) {
					filename =  "附件8博物馆藏品备案、确权情况证明" + suffix;
				} else if (arr.get(i) == 9) {
					filename =  "附件9藏品征集清单" + suffix;
				} else if (arr.get(i) == 10) {
					filename =  "附件10馆内藏品修复清单" + suffix;
				} else if (arr.get(i) == 11) {
					filename =  "附件11馆内重度腐蚀文物清单" + suffix;
				} else if (arr.get(i) == 12) {
					filename =  "附件12举办、参加学术会议情况" + suffix;
				} else if (arr.get(i) == 13) {
					filename =  "附件13研究成果清单" + suffix;
				} else if (arr.get(i) == 14) {
					filename =  "附件14博物馆展厅平面图" + suffix;
				} else if (arr.get(i) == 15) {
					filename =  "附件15基本陈列清单" + suffix;
				} else if (arr.get(i) == 16) {
					filename =  "附件16临时展览清单" + suffix;
				} else if (arr.get(i) == 17) {
					filename =  "附件17引进输出展览清单" + suffix;
				} else if (arr.get(i) == 18) {
					filename =  "附件18博物馆展览、讲解词备案情况证明" + suffix;
				} else if (arr.get(i) == 19) {
					filename =  "附件19博物馆展览简介" + suffix;
				} else if (arr.get(i) == 20) {
					filename =  "附件20博物馆讲解" + suffix;
				} else if (arr.get(i) == 21) {
					filename =  "附件21教育项目清单" + suffix;
				} else if (arr.get(i) == 22) {
					filename =  "附件22文化产品开发清单" + suffix;
				} else if (arr.get(i) == 23) {
					filename =  "附件23博物馆网站、新媒体服务建设情况" + suffix;
				} else if (arr.get(i) == 24) {
					filename =  "附件24设备购置和设备维修情况" + suffix;
				} else if (arr.get(i) == 25) {
					filename =  "附件25员工专业进修、培训活动情况" + suffix;
				} else if (arr.get(i) == 26) {
					filename =  "附件26获奖证明材料" + suffix;
				} else if (arr.get(i) == 27) {
					filename =  "附件27自评分材料" + suffix;
				} else if (arr.get(i) == 28) {
					filename =  "附件28其他（可提交展览和教育活动现场图片资料或文字简介）" + suffix;
				}
				String name = filename.substring(0,filename.lastIndexOf("."));
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("reportId", reportId);
				map.put("realName", name);
				
				GmReportUpload gmReportUpload = gmReportUploadService.getByRealyName(map);
				if (!MyString.isEmpty(gmReportUpload)) {
					System.out.println(path);
					System.out.println(File.separator);
					gmReportUpload.setUoloadUrl(reportName +"/" + File.separator + filename);
					gmReportUpload.setUoloadName(filename);
					gmReportUpload.setUoloadStatus("1");
					gmReportUploadService.update(gmReportUpload);
				}
				File filepath = new File(path,filename);
				//判断路径是否存在，如果不存在就创建一个
				if (!filepath.getParentFile().exists()) { 
					filepath.getParentFile().mkdirs();
				}
				String newpath = path + File.separator + filename;
				files[i].transferTo(new File(newpath));
				// 先删除再提取数据保存
				if (arr.get(i) == 9) {
					try {
					
						gmCollectionListService.deleteByReportUploadId(gmReportUpload.getId());
						List<String[]> readExcel = POIUtil.readExcel(files[i]);
						gmCollectionListService.extractData(readExcel, gmReportUpload.getId());
						
					} catch (Exception e) {
						e.printStackTrace();
						gmReportUpload.setUoloadUrl(null);
						gmReportUpload.setUoloadName(null);
						gmReportUpload.setUoloadStatus("0");
						gmReportUploadService.update(gmReportUpload);
						FileUtil.deleteFile(newpath);
						msgMap.put(9, "附件9数据格式错误，请检查后重新上传！");
					}
				} else if (arr.get(i) == 10) {
					try {
						
						gmCollectionRepairListService.deleteByReportUploadId(gmReportUpload.getId());
						List<String[]> readExcel = POIUtil.readExcel(files[i]);
						gmCollectionRepairListService.extractData(readExcel, gmReportUpload.getId());
					} catch (Exception e) {
						gmReportUpload.setUoloadUrl(null);
						gmReportUpload.setUoloadName(null);
						gmReportUpload.setUoloadStatus("0");
						gmReportUploadService.update(gmReportUpload);
						FileUtil.deleteFile(newpath);
						msgMap.put(10, "附件10数据格式错误，请检查后重新上传！");
					}
				} else if (arr.get(i) == 12) {
					try {
						
						gmScienceConferenceService.deleteByReportUploadId(gmReportUpload.getId());
						List<String[]> readExcel = POIUtil.readExcel(files[i]);
						gmScienceConferenceService.extractData(readExcel, gmReportUpload.getId());
					} catch (Exception e) {
						gmReportUpload.setUoloadUrl(null);
						gmReportUpload.setUoloadName(null);
						gmReportUpload.setUoloadStatus("0");
						gmReportUploadService.update(gmReportUpload);
						FileUtil.deleteFile(newpath);
						msgMap.put(12, "附件12数据格式错误，请检查后重新上传！");
					}
				} else if (arr.get(i) == 13) {
					try {
						
						gmScientificResearchListService.deleteByReportUploadId(gmReportUpload.getId());
						List<String[]> readExcel = POIUtil.readExcel(files[i]);
						gmScientificResearchListService.extractData(readExcel, gmReportUpload.getId());
					} catch (Exception e) {
						gmReportUpload.setUoloadUrl(null);
						gmReportUpload.setUoloadName(null);
						gmReportUpload.setUoloadStatus("0");
						gmReportUploadService.update(gmReportUpload);
						FileUtil.deleteFile(newpath);
						msgMap.put(13, "附件13数据格式错误，请检查后重新上传！");
					}
				} else if (arr.get(i) == 15) {
					try {
						
						gmBaseDisplayListService.deleteByReportUploadId(gmReportUpload.getId());
						List<String[]> readExcel = POIUtil.readExcel(files[i]);
						gmBaseDisplayListService.extractData(readExcel, gmReportUpload.getId());
					} catch (Exception e) {
						e.printStackTrace();
						gmReportUpload.setUoloadUrl(null);
						gmReportUpload.setUoloadName(null);
						gmReportUpload.setUoloadStatus("0");
						gmReportUploadService.update(gmReportUpload);
						FileUtil.deleteFile(newpath);
						msgMap.put(15, "附件15数据格式错误，请检查后重新上传！");
					}
				} else if (arr.get(i) == 16) {
					try {
						
						gmTemporaryExhibitListService.deleteByReportUploadId(gmReportUpload.getId());
						List<String[]> readExcel = POIUtil.readExcel(files[i]);
						gmTemporaryExhibitListService.extractData(readExcel, gmReportUpload.getId());
					} catch (Exception e) {
						gmReportUpload.setUoloadUrl(null);
						gmReportUpload.setUoloadName(null);
						gmReportUpload.setUoloadStatus("0");
						gmReportUploadService.update(gmReportUpload);
						FileUtil.deleteFile(newpath);
						msgMap.put(16, "附件16数据格式错误，请检查后重新上传！");
					}
				} else if (arr.get(i) == 17) {
					try {
						
						gmInoroutExhibitionListService.deleteByReportUploadId(gmReportUpload.getId());
						List<String[]> readExcel = POIUtil.readExcel(files[i]);
						gmInoroutExhibitionListService.extractData(readExcel, gmReportUpload.getId());
					} catch (Exception e) {
						gmReportUpload.setUoloadUrl(null);
						gmReportUpload.setUoloadName(null);
						gmReportUpload.setUoloadStatus("0");
						gmReportUploadService.update(gmReportUpload);
						FileUtil.deleteFile(newpath);
						msgMap.put(17, "附件17数据格式错误，请检查后重新上传！");
					}
				} else if (arr.get(i) == 21) {
					try {
						
						gmEduProjectListService.deleteByReportUploadId(gmReportUpload.getId());
						List<String[]> readExcel = POIUtil.readExcel(files[i]);
						gmEduProjectListService.extractData(readExcel, gmReportUpload.getId());
					} catch (Exception e) {
						gmReportUpload.setUoloadUrl(null);
						gmReportUpload.setUoloadName(null);
						gmReportUpload.setUoloadStatus("0");
						gmReportUploadService.update(gmReportUpload);
						FileUtil.deleteFile(newpath);
						msgMap.put(21, "附件21数据格式错误，请检查后重新上传！");
					}
				} else if (arr.get(i) == 22) {
					try {
						
						gmCulturalProductsService.deleteByReportUploadId(gmReportUpload.getId());
						List<String[]> readExcel = POIUtil.readExcel(files[i]);
						gmCulturalProductsService.extractData(readExcel, gmReportUpload.getId());
					} catch (Exception e) {
						gmReportUpload.setUoloadUrl(null);
						gmReportUpload.setUoloadName(null);
						gmReportUpload.setUoloadStatus("0");
						gmReportUploadService.update(gmReportUpload);
						FileUtil.deleteFile(newpath);
						msgMap.put(22, "附件22数据格式错误，请检查后重新上传！");
					}
				} else if (arr.get(i) == 23) {
					try {
						
						gmMuseumMediaDevelopService.deleteByReportUploadId(gmReportUpload.getId());
						InputStream is = files[i].getInputStream();
						String readDoc = POIUtil.readDoc(newpath, is);
						String substring1 = readDoc.substring(readDoc.indexOf("观众访问量：")+6, readDoc.indexOf("数目统计：")).trim();
						String substring2 = readDoc.substring(readDoc.indexOf("数目统计：")+5, readDoc.indexOf("博物馆网站建设情况整体效果展示（网站截图）：")).trim();
						gmMuseumMediaDevelopService.extractData(substring1,substring2, gmReportUpload.getId());
					} catch (Exception e) {
						e.printStackTrace();
						gmReportUpload.setUoloadUrl(null);
						gmReportUpload.setUoloadName(null);
						gmReportUpload.setUoloadStatus("0");
						gmReportUploadService.update(gmReportUpload);
						FileUtil.deleteFile(newpath);
						msgMap.put(23, "附件23数据格式错误，请检查后重新上传！");
					}
				} else if (arr.get(i) == 24) {
					try {
						
						gmEquipmentRepairSituationService.deleteByReportUploadId(gmReportUpload.getId());
						List<String[]> readExcel = POIUtil.readExcel(files[i]);
						gmEquipmentRepairSituationService.extractData(readExcel, gmReportUpload.getId());
					} catch (Exception e) {
						gmReportUpload.setUoloadUrl(null);
						gmReportUpload.setUoloadName(null);
						gmReportUpload.setUoloadStatus("0");
						gmReportUploadService.update(gmReportUpload);
						FileUtil.deleteFile(newpath);
						msgMap.put(24, "附件24数据格式错误，请检查后重新上传！");
					}
				} else if (arr.get(i) == 25) {
					try {
						
						gmEmployeeTrainSituationService.deleteByReportUploadId(gmReportUpload.getId());
						List<String[]> readExcel = POIUtil.readExcel(files[i]);
						gmEmployeeTrainSituationService.extractData(readExcel, gmReportUpload.getId());
					} catch (Exception e) {
						gmReportUpload.setUoloadUrl(null);
						gmReportUpload.setUoloadName(null);
						gmReportUpload.setUoloadStatus("0");
						gmReportUploadService.update(gmReportUpload);
						FileUtil.deleteFile(newpath);
						msgMap.put(25, "附件25数据格式错误，请检查后重新上传！");
					}
				}
				
			}
		}
		MsgMapVo msgMapVo = new MsgMapVo();
		msgMapVo.setMsgMapVo(msgMap);
		redirectModel.addFlashAttribute("msgMapVo", msgMapVo);
		redirectModel.addFlashAttribute("redirectReportId", reportId);
	
		if (msgMap.size() > 0) {
			return "redirect:/gmReportUpload/form.do";
		}
        if (status == 1) {
        	return "redirect:/registerInfo/getInfoList.do";
        } else {
        	return "/WEB-INF/back/gm/selfScore.jsp";
        }
	}
	
	@RequestMapping("downDemo")
	@AuthPassport
	public ResponseEntity<byte[]> downDemo(@RequestParam("filename") String fileName,HttpServletRequest request,HttpServletResponse response) throws IOException {
		/*if (fileName.equals("1")) {
			fileName = "附件9藏品征集清单模板.xlsx";
		}else if (fileName.equals("2")) {
			fileName = "附件10馆内藏品修复清单模板.xlsx";
		}else if (fileName.equals("3")) {
			fileName = "附件12举办、参加学术会议情况模板.xlsx";
		}else if (fileName.equals("4")) {
			fileName = "附件13研究成果清单模板.xlsx";
		}else if (fileName.equals("5")) {
			fileName = "附件15基本陈列清单模板.xlsx";
		}else if (fileName.equals("6")) {
			fileName = "附件16临时展览清单模板.xlsx";
		}else if (fileName.equals("7")) {
			fileName = "附件17引进、输出展览清单模板.xlsx";
		}else if (fileName.equals("8")) {
			fileName = "附件21教育项目清单模板.xlsx";
		}else if (fileName.equals("9")) {
			fileName = "附件22文化产品开发清单模板.xlsx";
		}else if (fileName.equals("10")) {
			fileName = "附件23博物馆网站、新媒体服务建设情况模板.docx";
		}else if (fileName.equals("11")) {
			fileName = "附件24设备购置和设备维修情况模板.xlsx";
		}else if (fileName.equals("12")) {
			fileName = "附件25员工专业进修、培训活动情况模板.xlsx";
		}*/
		if (fileName.equals("1")) {
			fileName = "attachment9.xlsx";
		}else if (fileName.equals("2")) {
			fileName = "attachment10.xlsx";
		}else if (fileName.equals("3")) {
			fileName = "attachment12.xlsx";
		}else if (fileName.equals("4")) {
			fileName = "attachment13.xlsx";
		}else if (fileName.equals("5")) {
			fileName = "attachment15.xlsx";
		}else if (fileName.equals("6")) {
			fileName = "attachment16.xlsx";
		}else if (fileName.equals("7")) {
			fileName = "attachment17.xlsx";
		}else if (fileName.equals("8")) {
			fileName = "attachment21.xlsx";
		}else if (fileName.equals("9")) {
			fileName = "attachment22.xlsx";
		}else if (fileName.equals("10")) {
			fileName = "attachment23.docx";
		}else if (fileName.equals("11")) {
			fileName = "attachment24.xlsx";
		}else if (fileName.equals("12")) {
			fileName = "attachment25.xlsx";
		}
        System.out.println(fileName);
        response.setContentType("application/vnd.ms-excel;charset=UTF-8"); /*设定相应类型 编码*/
        try {
            request.setCharacterEncoding("UTF-8");//设定请求字符编码
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        java.io.BufferedInputStream bis = null;//创建输入输出流
        java.io.BufferedOutputStream bos = null;

//        String ctxPath = request.getSession().getServletContext().getRealPath("/") + "upload/";//获取文件真实路径
        //  String ctxPath = request.getSession().getServletContext().getRealPath("/模板/");
        String ctxPath = request.getSession().getServletContext().getRealPath("/attachment/");
        System.out.println(ctxPath);
        String downLoadPath = ctxPath + fileName;
        //downLoadPath = new String(downLoadPath.getBytes("utf-8"), "GBK");
        System.out.println(downLoadPath);
        try {
        	File file = new File(downLoadPath);
            long fileLength = file.length();//获取文件长度
            System.out.println(fileLength);
            response.setContentType("application/x-msdownload;");//下面这三行是固定形式
            // response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            String downFileName = "";
            if (fileName.equals("attachment9.xlsx")) {
            	downFileName = "附件9藏品征集清单模板.xlsx";
			}else if (fileName.equals("attachment10.xlsx")) {
				downFileName = "附件10馆内藏品修复清单模板.xlsx";
			}else if (fileName.equals("attachment12.xlsx")) {
				downFileName = "附件12举办、参加学术会议情况模板.xlsx";
			}else if (fileName.equals("attachment13.xlsx")) {
				downFileName = "附件13研究成果清单模板.xlsx";
			}else if (fileName.equals("attachment15.xlsx")) {
				downFileName = "附件15基本陈列清单模板.xlsx";
			}else if (fileName.equals("attachment16.xlsx")) {
				downFileName = "附件16临时展览清单模板.xlsx";
			}else if (fileName.equals("attachment17.xlsx")) {
				downFileName = "附件17引进、输出展览清单模板.xlsx";
			}else if (fileName.equals("attachment21.xlsx")) {
				downFileName = "附件21教育项目清单模板.xlsx";
			}else if (fileName.equals("attachment22.xlsx")) {
				downFileName = "附件22文化产品开发清单模板.xlsx";
			}else if (fileName.equals("attachment23.docx")) {
				downFileName = "附件23博物馆网站、新媒体服务建设情况模板.docx";
			}else if (fileName.equals("attachment24.xlsx")) {
				downFileName = "附件24设备购置和设备维修情况模板.xlsx";
			}else if (fileName.equals("attachment25.xlsx")) {
				downFileName = "附件25员工专业进修、培训活动情况模板.xlsx";
			}
            
            
            response.setHeader("Content-disposition", "attachment; filename=" +  URLEncoder.encode(downFileName, "UTF-8"));
           
            response.setHeader("Content-Length", String.valueOf(fileLength));
            bis = new BufferedInputStream(new FileInputStream(file));//创建输入输出流实例
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
	
	
	
}		
	

