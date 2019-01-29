package com.tj720.admin.controller.admin;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.NumberUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.common.vo.SysDictVo;
import com.tj720.admin.dao.map.MipSearchMapper;
import com.tj720.admin.dto.MipSearchDto;
import com.tj720.admin.dto.MuseumBaseHouseDto;
import com.tj720.admin.dto.MuseumBaseInfoDto;
import com.tj720.admin.dto.MuseumCollectionDto;
import com.tj720.admin.dto.MuseumCostDto;
import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.admin.dto.MuseumDigitizationDto;
import com.tj720.admin.dto.MuseumDisplayShowDto;
import com.tj720.admin.dto.MuseumHouseBuildingDto;
import com.tj720.admin.dto.MuseumPersonDto;
import com.tj720.admin.dto.MuseumPublicServiceDto;
import com.tj720.admin.dto.MuseumSafeEnsureDto;
import com.tj720.admin.dto.MuseumShowRoomDto;
import com.tj720.admin.dto.MuseumWarehouseDto;
import com.tj720.admin.dto.PersonAwardRecordDto;
import com.tj720.admin.dto.PersonCertificationDto;
import com.tj720.admin.dto.SelectDto;
import com.tj720.admin.model.CmsSubject;
import com.tj720.admin.model.MipAttachment;
import com.tj720.admin.service.CmsSubjectService;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.admin.service.IMuseumCollectionInfoService;
import com.tj720.admin.service.IMuseumCostService;
import com.tj720.admin.service.IMuseumDigitizationService;
import com.tj720.admin.service.IMuseumDisplayShowService;
import com.tj720.admin.service.IMuseumHouseBuildingService;
import com.tj720.admin.service.IMuseumPersonService;
import com.tj720.admin.service.IMuseumPromotionService;
import com.tj720.admin.service.IMuseumPublicServiceService;
import com.tj720.admin.service.IMuseumSafeEnsureService;
import com.tj720.admin.service.IMuseumShowRoomService;
import com.tj720.admin.service.IMuseumWarehouseService;
import com.tj720.admin.service.MipAttachmentService;
import com.tj720.admin.service.MipSearchService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.ExportExcelUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.OrgUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

import net.sf.json.JSONArray;

/**
 * 博物馆基础资料Controller
 * @author chenshiya
 * @version 2018-05-17
 */
@Controller
@RequestMapping("/museuminfo")
public class MuseumBaseInfoController extends BaseController{
	@Autowired
	private IMuseumBaseInfoService museumBaseInfoService;
	@Autowired
	private IMuseumHouseBuildingService museumHouseBuildingService;
	@Autowired
	private IMuseumCostService museumCostService;
	@Autowired
	private IMuseumPublicServiceService publicService;
	@Autowired
	private IMuseumDigitizationService digitizationService;
	@Autowired
	private IMuseumWarehouseService warehouseService;
	@Autowired
	private IMuseumPromotionService promotionSerivce;
	@Autowired
	private IMuseumPersonService museumPersonService;
	@Autowired
	private MipAttachmentService mipAttachmentService;
	@Autowired
	private IMuseumCollectionInfoService collectionService;
	@Autowired
	private IMuseumDisplayShowService displayShowService;
	@Autowired
	private IMuseumShowRoomService showRoomService;
	@Autowired
	private IMuseumSafeEnsureService safeEnsureService;
	@Autowired
	private Config config;
	@Autowired
	private IMipOrganizationService mipOrganizationService;	
	@Autowired
	private com.tj720.admin.service.IMipOrganizationService imipOrganizationService;
	@Autowired
	private MipOrganizationService organizationService;
	@Autowired
	private MipSearchService searchService;
	@Autowired
	private CmsSubjectService cmsSubjectService;
	@Autowired
	private MipSearchMapper mipSearchMapper;
	@Autowired
	private IUserService userService;
	
	/**
	 * 博物馆基础资料列表页面
	 * @param 
	 * @return
	 */
	@RequestMapping("/museumList.do")
	@ResponseBody
	@AuthPassport
	public ModelAndView goList(){
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/museumList.jsp");
		//区域列表
		String key = "dict_area";
		List<Map<String,Object>> areaList = museumBaseInfoService.getAreaList();
		if(areaList.size()>0){
			modelAndView.addObject("areaList",areaList);
		}
		//机构类型
		key = "org_type";
		List<SysDictVo> typeList = museumBaseInfoService.getDictListByKey(key);
		if(typeList.size()>0){
			modelAndView.addObject("typeList",typeList);
		}
		return modelAndView;
	}
	
	/**
	 * 查询机构资料列表
	 */
	@RequestMapping("/getMuseumList.do")
	@ResponseBody
	@AuthPassport
	public JSONObject list(@RequestParam(defaultValue = "10") int size, 
			@RequestParam(defaultValue = "1",name = "currentPage") int currentPage,String museumName,String museumType,String area) {
		
		String model=(String)session.getAttribute("model");
		
		if(StringUtils.isNotBlank(model)) {
			if("zzOrg".equals(model)) {
				museumType = "4";
			}else if("scOrg".equals(model)) {
				museumType = "5";
			}
		}
		
		MuseumBaseInfoDto museumBaseInfo = new MuseumBaseInfoDto();
		museumBaseInfo.setMuseumName(museumName);
		museumBaseInfo.setMuseumType(museumType);
		museumBaseInfo.setArea(area);
		
		//查登录组织下所有的子单位
		List<String> orgIdList = new ArrayList<String>();
		String orgId = getOrgId();
		List<com.tj720.admin.model.MipOrganization> orglist = new ArrayList<com.tj720.admin.model.MipOrganization>();
		List<com.tj720.admin.model.MipOrganization> organizations = mipOrganizationService.getChildListByPid(Integer.valueOf(orgId), orglist);
		for(com.tj720.admin.model.MipOrganization org:organizations){
			String typeId = org.getOrgTypeId();
			String id = String.valueOf(org.getId());
			//查博物馆，文物修复资质单位，其他文物收藏单位
			if("3".equals(typeId) ||"4".equals(typeId)||"5".equals(typeId)){
				orgIdList.add(id);
			}
		}
		museumBaseInfo.setOrgIdList(orgIdList);
		
		//分页
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		Integer count = museumBaseInfoService.getCount(museumBaseInfo);
		page.setAllRow(count);
		
		museumBaseInfo.setStartInt(page.getStart());
		museumBaseInfo.setEndInt(page.getSize());
		
		//查机构列表
		List<MuseumBaseInfoDto> museumBaseInfoList = museumBaseInfoService.selectMuseumList(museumBaseInfo);
		
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg",""); 
        jsonObject.put("count", page.getAllRow());
        jsonObject.put("data", museumBaseInfoList);
		return jsonObject;
	}
	
	/**
	 * 详情页
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/museumDetail.do")
	@AuthPassport
	public ModelAndView museumDetail(String museumId) {
		
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/museumDetail.jsp");
		String level = getLevel();//1:博物馆2：文物局
		//博物馆人员登录查询组织id
		String orgId = getOrgId();
		//只有从机构资料列表进来的请求museumId才有值
		if(StringUtils.isEmpty(museumId)){
			museumId = orgId;
		}
		MipOrganization organization = mipOrganizationService.get(museumId);
		String orgType = organization.getOrgTypeId();
		modelAndView.addObject("orgId", orgId);//超级管理员orgid=0
		modelAndView.addObject("orgType", orgType);
		modelAndView.addObject("level", level);
		MuseumDataProgressDto resultMap = museumBaseInfoService.getDetail(museumId,level);
		if(resultMap != null){
			modelAndView.addObject("result", resultMap);
		}
		
		//查询上传提交时间
		MuseumDataProgressDto levelTwoMap = museumBaseInfoService.getDetail(museumId,"2");
		String updateTime = levelTwoMap.getStrUpdatTime();
		String tipMessage = "";
		if(StringUtils.isNotEmpty(updateTime)){
			tipMessage = "上次提交时间  "+updateTime;
		}else{
			tipMessage="未提交单位资料";
		}
		modelAndView.addObject("tipMessage", tipMessage);
		return modelAndView;
	}
	
	/**
	 * 博物馆基本资料加载
	 * @param museumId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/museumBaseInfo.do",produces = {"text/html;charset=utf-8"})
	@AuthPassport
	public ModelAndView museumBaseInfo(String museumId) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/museumBaseInfo.jsp");
		modelAndView.addObject("museumId", museumId);
		//查组织名称
		MipOrganization organization = mipOrganizationService.get(museumId);
		String museumName = organization.getName();
		modelAndView.addObject("museumName", museumName);
		String level = getLevel();//1:博物馆2：文物局
		modelAndView.addObject("level", level);
		MuseumBaseInfoDto result = museumBaseInfoService.selectMuseumById(museumId,level);
		if(result != null){
			modelAndView.addObject("result", result);
			
			//获取附件数据
			List<MipAttachment> attchmentList = mipAttachmentService.getListByFkid("bj_museum_base_info", result.getMuseumId());
			List<Map<String, String>> attchmentDtoList = new ArrayList<>();
			for (MipAttachment attchment : attchmentList) {
				Map<String, String> map1 = new HashMap<>();
				map1.put("id", attchment.getAttId());
				map1.put("resultPath", attchment.getAttPath());
				map1.put("realFileName", attchment.getAttName());
				map1.put("isjunk", attchment.getAttIsjunk());
				map1.put("size", attchment.getAttSize()+"");
				map1.put("typeCode", attchment.getAttFileType()+"");
				map1.put("isnew", "0");
				attchmentDtoList.add(map1);
			}
			modelAndView.addObject("uploads", JSONObject.toJSONString(attchmentDtoList));//附件json
			
			//图片数据
			String imageUrl = result.getImageUrl();
			String pictureUrl = "";
			if(StringUtils.isNotEmpty(imageUrl)){
				pictureUrl = MyString.isEmpty(config.getRootUrl()) ? "" : (config.getRootUrl() + imageUrl); 
				result.setPictureUrl(pictureUrl);
			}
		}
		//区域列表
		List<Map<String,Object>> areaList = museumBaseInfoService.getAreaList();
		if(areaList.size()>0){
			modelAndView.addObject("areaList",areaList);
		}
		
		//上级主管
		MipOrganization parenOrg = mipOrganizationService.get(organization.getParentId());
		if(parenOrg!=null){
			modelAndView.addObject("parentOrgName",parenOrg.getName());
		}
		return modelAndView;
	}
	
	
	/**
	 * 保存博物馆基础资料
	 */
	@RequestMapping("/museuminfoSave.do")
	@ResponseBody
	@AuthPassport
	public String save(MuseumBaseInfoDto museumBaseInfo,String isFull,String uploads){
		String result = "";
		try {
			String userNameBase64=museumBaseInfo.getGeography();  
			byte[] userNameByte = Base64.decodeBase64(userNameBase64.getBytes("UTF-8"));    
			String geography = new String(userNameByte);//获得解密后的用户名  
			museumBaseInfo.setGeography(geography);
			String userId = Tools.getUser().getId();
			//保存附件
			List<MipAttachment> attchList = new ArrayList<>();
			String attachment_ids = "";
			if(!StringUtil.isBlank(uploads)) {
				JSONArray fromObject = JSONArray.fromObject(uploads);
				for (int i = 0; i < fromObject.size(); i++) {
					net.sf.json.JSONObject jsonObject = fromObject.getJSONObject(i);
					String attchid = jsonObject.getString("id");
					String isjunk = jsonObject.getString("isjunk");
					String isnew = jsonObject.getString("isnew");
					
					if(!StringUtil.isBlank(isnew) && "1".equals(isnew)) {		//新文件保存
						MipAttachment cAttchment = new MipAttachment();
						cAttchment.setAttId(jsonObject.getString("id"));			//id
						cAttchment.setAttIsjunk(jsonObject.getString("isjunk"));			//是否删除
						cAttchment.setAttName(jsonObject.getString("realFileName"));			//原始文件名称
						cAttchment.setAttSize(jsonObject.getLong("size"));			//大小
						cAttchment.setAttPath(jsonObject.getString("resultPath"));		//上传后的相对路径
						cAttchment.setAttDate(new Date());			//上传时间
						cAttchment.setAttFileType(jsonObject.getInt("typeCode"));		//文件类型
						cAttchment.setAttrUser(userId);		//上传人
						cAttchment.setAttType("bj_museum_base_info");		//关联表名称
						cAttchment.setAttFkId(museumBaseInfo.getMuseumId());		//关联表id
						
						attachment_ids += attchid + ",";
						attchList.add(cAttchment);
					}else {		//旧文件
						if("1".equals(isjunk)) {		//需要删除的文件
							mipAttachmentService.deleteFile(attchid);
						}else {
							attachment_ids += attchid + ",";
						}
					}
				}
				if(!StringUtil.isBlank(attachment_ids)) {
					attachment_ids = attachment_ids.substring(0, attachment_ids.length()-1);
				}
			}
			//批量保存文件
			if(attchList != null && attchList.size() > 0) {
				mipAttachmentService.batchSave(attchList);
			}
			museumBaseInfo.setManageWay(attachment_ids);//插入附件id连接串
			int num =  museumBaseInfoService.saveBaseInfo(museumBaseInfo);
			
			if(StringUtils.isNotEmpty(geography)){
				//取经纬度  存到org表
				String substring = geography.substring(geography.indexOf("center=") + 7, geography.indexOf("&zoom"));
				String[] split = substring.split(",");
				MipOrganization mipOrganization = new MipOrganization();
				mipOrganization = organizationService.get(museumBaseInfo.getMuseumId());
				mipOrganization.setLatitude(Double.parseDouble(split[0])); 
				mipOrganization.setLongitude(Double.parseDouble(split[1]));
				organizationService.update(mipOrganization);
			}
			
			if(num>0){
				MuseumDataProgressDto progressInfo = new MuseumDataProgressDto();
				progressInfo.setBasePer(isFull);
				progressInfo.setMuseumId(museumBaseInfo.getMuseumId());
				progressInfo.setFlag("1");
				int count =museumBaseInfoService.updateProgress(progressInfo);
				if(count>0){
					MuseumDataProgressDto pro = museumBaseInfoService.getDetail(museumBaseInfo.getMuseumId(),"1");
					MuseumDataProgressDto updateInfo = new MuseumDataProgressDto();
					updateInfo.setAllDataPer(Utils.progressIsFull(pro));
					updateInfo.setMuseumId(museumBaseInfo.getMuseumId());
					updateInfo.setFlag("1");
					museumBaseInfoService.updateProgress(updateInfo);
					result = "1";
				}else{
					result = "0";
				}
			}else{
				result = "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "0";
		}
		return result;
	}
	
	/**
	 * 详情页面保存
	 */
	@RequestMapping("/saveDetail.do")
	@ResponseBody
	@AuthPassport
	public String saveDetail(String museumId){
		String result = "";
		try {
			//博物馆基础资料
			baseMuseum(museumId);
			//馆舍建筑与基础设施
			houseBulid(museumId);
			//经费来源与保障
			cost(museumId);
			//陈列展览与社会服务
			serviceMuseum(museumId);
			//机构人员信息
			person(museumId);
			//信息智能化建设
			digitization(museumId);
			//安全保障
			safeEnsure(museumId);
			//藏品管理与科学研究
			collection(museumId);
			//提交完成度信息
			progressData(museumId);
			result ="1";
		} catch (Exception e) {
			e.printStackTrace();
			result="0";
		}
		return result;
	}
	
	private void baseMuseum(String museumId) {
		String flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		MuseumBaseInfoDto base = museumBaseInfoService.selectMuseumById(museumId,flag);
		if(base!=null){
			flag = "2";
			museumBaseInfoService.deleteBase(museumId, flag);//删除所有为2状态的记录
			base.setFlag(flag);
			museumBaseInfoService.insertBase(base);//插入一条状态2的记录
		}
		flag = "3";
		MuseumBaseInfoDto editBase = museumBaseInfoService.selectMuseumById(museumId,flag);
		if(editBase!=null){
			flag = "4";
			editBase.setFlag("4");
			museumBaseInfoService.updateFlag(editBase);//将状态为3的记录更新为4
		}
	}
	
	private void houseBulid(String museumId){
		String flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		MuseumBaseHouseDto base = museumHouseBuildingService.selectForm(museumId,flag);
		if(base!=null){
			flag = "2";
			museumHouseBuildingService.deleteBase(museumId, flag);//删除所有为2状态的记录
			base.setFlag(flag);
			museumHouseBuildingService.insertBase(base);//插入一条状态2的记录
		}
		flag = "3";
		MuseumBaseHouseDto editBase = museumHouseBuildingService.selectForm(museumId,flag);
		if(editBase!=null){
			flag = "4";
			editBase.setFlag("4");
			museumHouseBuildingService.updateFlag(editBase);//将状态为3的记录更新为4
		}
		//馆舍信息部分
		flag = "1";
		List<MuseumHouseBuildingDto> houseInfoList = museumHouseBuildingService.selectList(museumId,flag);
		flag = "2";
		museumHouseBuildingService.deleteBaseTwo(museumId, flag);//删除所有为2状态的记录
		for(MuseumHouseBuildingDto info:houseInfoList){
			info.setFlag("2");
			museumHouseBuildingService.insert(info);//插入一条状态2的记录
		}
		
		List<MuseumHouseBuildingDto> list = museumHouseBuildingService.selectList(museumId,"3");
		for(MuseumHouseBuildingDto info:list){
			info.setFlag("4");
			museumHouseBuildingService.updateFlagTwo(info);//将状态为3的记录更新为4
		}
		
		//库房信息部分
		flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		List<MuseumWarehouseDto> wareList = warehouseService.selectList(museumId,flag);
		flag = "2";
		warehouseService.deleteBase(museumId, flag);//删除所有为2状态的记录
		for(MuseumWarehouseDto info:wareList){
			info.setFlag("2");
			warehouseService.insert(info);//插入一条状态2的记录
		}
		flag="3";
		List<MuseumWarehouseDto> recordlist = warehouseService.selectList(museumId,flag);
		for(MuseumWarehouseDto info:recordlist){
			info.setFlag("4");
			warehouseService.update(info);//将状态为3的记录更新为4
		}
		//展厅信息部分
		flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		List<MuseumShowRoomDto> roomList = showRoomService.selectList(museumId,flag);
		flag = "2";
		showRoomService.deleteBase(museumId, flag);//删除所有为2状态的记录
		for(MuseumShowRoomDto info:roomList){
			info.setFlag("2");
			showRoomService.insert(info);//插入一条状态2的记录
		}
		flag="3";
		List<MuseumShowRoomDto> recordRoomlist = showRoomService.selectList(museumId,flag);
		for(MuseumShowRoomDto info:recordRoomlist){
			info.setFlag("4");
			showRoomService.update(info);//将状态为3的记录更新为4
		}
	}
	
	private void cost(String museumId){
		String flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		List<MuseumCostDto> costList = museumCostService.selectCostList(museumId,flag);
		flag = "2";
		museumCostService.deleteBase(museumId, flag);//删除所有为2状态的记录
		for(MuseumCostDto info:costList){
			info.setFlag("2");
			museumCostService.insertCost(info);//插入一条状态2的记录
		}
	}
	
	private void serviceMuseum(String museumId){
		String flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		MuseumPublicServiceDto base = publicService.selectForm(museumId,flag);
		if(base!=null){
			flag = "2";
			publicService.deleteBase(museumId, flag);//删除所有为2状态的记录
			base.setFlag(flag);
			publicService.insert(base);//插入一条状态2的记录
		}
		flag = "3";
		MuseumPublicServiceDto editBase = publicService.selectForm(museumId,flag);
		if(editBase!=null){
			flag = "4";
			editBase.setFlag(flag);
			publicService.updateFlag(editBase);//将状态为3的记录更新为4
		}
		
		//基本陈列信息列表
		List<MuseumDisplayShowDto> costList = displayShowService.selectShowList(museumId,flag);
		flag = "2";
		displayShowService.deleteBase(museumId, flag);//删除所有为2状态的记录
		for(MuseumDisplayShowDto info:costList){
			info.setFlag("2");
			displayShowService.insertShow(info);//插入一条状态2的记录
		}
		
		flag = "3";
		List<MuseumDisplayShowDto> recordList = displayShowService.selectShowList(museumId,flag);
		for(MuseumDisplayShowDto record:recordList){
			flag = "4";
			record.setFlag(flag);
			displayShowService.updateFlag(record);//将状态为3的记录更新为4
		}
	}
	
	private void digitization(String museumId){
		String flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		MuseumDigitizationDto base = digitizationService.selectForm(museumId,flag);
		if(base!=null){
			flag = "2";
			digitizationService.deleteBase(museumId, flag);//删除所有为2状态的记录
			base.setFlag(flag);
			digitizationService.insertDigitization(base);//插入一条状态2的记录
		}
		flag = "3";
		MuseumDigitizationDto editBase = digitizationService.selectForm(museumId,flag);
		if(editBase!=null){
			flag = "4";
			editBase.setFlag(flag);
			digitizationService.updateFlag(editBase);//将状态为3的记录更新为4
		}
	}
	
	private void safeEnsure(String museumId){
		String flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		MuseumSafeEnsureDto base = safeEnsureService.selectForm(museumId,flag);
		if(base!=null){
			flag = "2";
			safeEnsureService.deleteBase(museumId, flag);//删除所有为2状态的记录
			base.setFlag(flag);
			safeEnsureService.insertSafeEnsure(base);//插入一条状态2的记录
		}
		flag = "3";
		MuseumSafeEnsureDto editBase = safeEnsureService.selectForm(museumId,flag);
		if(editBase!=null){
			flag = "4";
			editBase.setFlag(flag);
			safeEnsureService.updateFlag(editBase);//将状态为3的记录更新为4
		}
	}
	
	private void person(String museumId){
		String flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		List<MuseumPersonDto> personList = museumPersonService.selectAllPerson(museumId,flag);
		flag = "2";
		museumPersonService.deleteBase(museumId, flag);//删除所有为2状态的记录
		for(MuseumPersonDto info:personList){
			String beforeId = info.getId();
			String afterId = IdUtils.nextId(info);
			info.setId(afterId);
			info.setFlag("2");
			museumPersonService.insert(info);//插入一条状态2的记录
			List<PersonAwardRecordDto> awardList = museumPersonService.selectAwardList(beforeId);
			for(PersonAwardRecordDto awardInfo:awardList){
				awardInfo.setPersonId(afterId);
				museumPersonService.insertAward(awardInfo);
			}
			
			List<PersonCertificationDto> cerList = museumPersonService.selectCertificationList(beforeId);
			for(PersonCertificationDto cerInfo:cerList){
				cerInfo.setPersonId(afterId);
				museumPersonService.insertCertification(cerInfo);
			}
		}
	}
	
	private void collection(String museumId){
		String flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		MuseumCollectionDto base = collectionService.selectForm(museumId,flag);
		if(base!=null){
			flag = "2";
			collectionService.deleteBase(museumId, flag);//删除所有为2状态的记录
			base.setFlag(flag);
			collectionService.insert(base);//插入一条状态2的记录
		}
		flag = "3";
		MuseumCollectionDto editBase = collectionService.selectForm(museumId,flag);
		if(editBase!=null){
			flag = "4";
			editBase.setFlag(flag);
			collectionService.updateFlag(editBase);//将状态为3的记录更新为4
		}
	}
	
	private void progressData(String museumId){
		String flag = "1";
		MuseumDataProgressDto pro = museumBaseInfoService.getDetail(museumId,flag);//博物馆级别数据
		String userId = Tools.getUser().getId();
		pro.setUpdateId(userId);
		pro.setUpdateTime(new Date());
		pro.setFlag("2");
		museumBaseInfoService.updateProgress(pro);//更新文物局级别数据
	}
	
	private String encodeStr(String str) {  
        try {  
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    } 
	
	/**
	 * 汇总数据
	 * @return
	 */
	@RequestMapping("/museumStatistics.do")
	@ControllerAop(url="museuminfo/museumStatistics.do")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView museumStatistics() {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/museumStatistics.jsp");
		try { 
			String type = "0";//type=0表示汇总查询
			List<MipSearchDto> myQuery = searchService.getList("1",type);
			modelAndView.addObject("myQuery", myQuery);
			List<MipSearchDto> otherQuery = searchService.getList(null,type);
			modelAndView.addObject("otherQuery", otherQuery);
			return modelAndView;
		} catch (Exception e) {  
	        e.printStackTrace();  
	        return null;  
	    }  		
	}
	
	/**
	 * 明细数据
	 * @return
	 */
	@RequestMapping("/museumDetailData.do")
	@ControllerAop(url="museuminfo/museumDetailData.do")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView museumDetailData() {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/museumDetailData.jsp");
		try { 
			String type = "1";//type=1表示明细查询
			List<MipSearchDto> myQuery = searchService.getList("1",type);
			modelAndView.addObject("myQuery", myQuery);
			List<MipSearchDto> otherQuery = searchService.getList(null,type);
			modelAndView.addObject("otherQuery", otherQuery);
			return modelAndView;
		} catch (Exception e) {  
	        e.printStackTrace();  
	        return null;  
	    }  		
	}
	
	
	/**
	 * 单位列表数据
	 * @return
	 */
	@RequestMapping("/selectMuseum.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JSONObject selectMuseum() {
		LoginInfoDto user = Tools.getUser();
		if(StringUtils.isBlank(user.getId())) {
			JSONObject jsonObject = new JSONObject();
	        jsonObject.put("code", 1);
	        jsonObject.put("msg","error"); 
	        jsonObject.put("data", null);
			return jsonObject;
		}
		
		User user2 = userService.get(user.getId());
		
		try { 
			List<com.tj720.admin.model.MipOrganization> allmuseumList = imipOrganizationService.getMuseumList();
			List<com.tj720.admin.model.MipOrganization> museumList = new ArrayList<>();
			MipOrganization mipOrganization2 = organizationService.get(user2.getOrgId());
			if(mipOrganization2 != null && "1".equals(mipOrganization2.getOrgTypeId())) {
				//文物局
				museumList = allmuseumList;
			}else {
				//其他
				museumList = OrgUtil.getSonOrg(allmuseumList, NumberUtils.stringToInt(user2.getOrgId(), 0), false);
			}
			List<SelectDto> selectMuseum = new ArrayList<SelectDto>();
			for(com.tj720.admin.model.MipOrganization mipOrganization : museumList){
				SelectDto select = new SelectDto();
				select.setName(mipOrganization.getName());
				select.setValue(mipOrganization.getId().toString());
				selectMuseum.add(select);
			}	
			JSONObject jsonObject = new JSONObject();
	        jsonObject.put("code", 0);
	        jsonObject.put("msg","success"); 
	        jsonObject.put("data", selectMuseum);
			return jsonObject;
		} catch (Exception e) {  
	        e.printStackTrace();  
	        return null;  
	    }
				
	}
	
	/**
	 * 查询
	 * @return
	 */
	@RequestMapping("/query.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JSONObject query(String queryTerms,String queryOrgs,String type,String sqlstr,String curPid) {
		try { 
			if(!StringUtils.isBlank(curPid)){
				sqlstr = mipSearchMapper.getSqlById(curPid);
			}
			//先把查询条件存数据库	
			List<Map<String,Object>> map = searchService.query(queryOrgs,queryTerms,type,sqlstr);
			JSONObject jsonObject = new JSONObject();
	        jsonObject.put("code", 0);
	        jsonObject.put("success","1"); 
	        jsonObject.put("data", map);
			return jsonObject;
		} catch (Exception e) {  
	        e.printStackTrace();  
	        return null;  
	    }		
	}
	
	/**
	 * 保存查询条件
	 * @return
	 */
	@RequestMapping("/saveQuery.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String saveQuery(String queryTerms,String queryOrgs,String queryName,String type,String curPid) {
		try { 
			//先把查询条件存数据库	
			searchService.save(queryOrgs,queryTerms,queryName,type,curPid);
			return "1";
		} catch (Exception e) {  
	        e.printStackTrace();  
	        return "2";  
	    }
				
	}
	/**
	 * 保存查询页面
	 * @return
	 */
	@RequestMapping("/openSave.do")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView openSave(String queryTerms,String queryOrgs,String type,String curPid) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/addQuery.jsp");
		modelAndView.addObject("queryTerms", queryTerms);
		modelAndView.addObject("queryOrgs", queryOrgs);
		modelAndView.addObject("type", type);
		modelAndView.addObject("curPid", curPid);
		return modelAndView;
	}
	
	/**
	 * 获取直属单位数据
	 * @return
	 */
	@RequestMapping("/getOrgs.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String getOrgs() {
		try { 
			String orgs = "";
			List<String> orgList = imipOrganizationService.getOrgs();
			for(String org: orgList ){
				orgs += org+",";
			}
			orgs = orgs.substring(0,orgs.length()-1);
			return orgs;
		} catch (Exception e) {  
	        e.printStackTrace();  
	        return null;  
	    }
				
	}
	
	/**
	 * ---综合查询数据导出
	 * @param queryOrgs queryTerms
	 * @return
	 */
	@RequestMapping("/export.do")
	@AuthPassport(authority = "SystemAdmin")
	public void export(String queryOrgs, String queryTerms,String type, String sqlstr,String curPid,HttpServletResponse response) {
		//表头数据
		List<String> titleList = new ArrayList<String>();
		titleList.add("序号");
		titleList.add("组织名称");
		String fileName = "数据统计";		
		String[] queryTermArr = queryTerms.split(",");
		List<String> queryTermList = Arrays.asList(queryTermArr);
		List<CmsSubject> subjectList = new ArrayList<CmsSubject>();
		if("0".equals(type)){
			subjectList = cmsSubjectService.getSubjectList(null,null,"2");
		}else if("1".equals(type)){
			subjectList = cmsSubjectService.getSubjectList(null,null,"3");
		}
		for(CmsSubject subject : subjectList){
			if(queryTermList.contains(subject.getUniqueName())){
				titleList.add(subject.getName());
			}
		}
		//数组去重
		for( int  i  =   0 ; i  <  titleList.size()  -   1 ; i ++ ){       
		      for( int  j  =  titleList.size()  -   1 ; j  >  i; j -- ){       
		           if  (titleList.get(j).equals(titleList.get(i))){       
		        	   titleList.remove(j);       
		            }        
		       }
		}     
		String[] title = titleList.toArray(new String[titleList.size()]);
		if(!StringUtils.isBlank(curPid)){
			sqlstr = mipSearchMapper.getSqlById(curPid);
		}
		List<Map<String,Object>> list = searchService.query(queryOrgs,queryTerms,type,sqlstr);
		List<Object[]> dataList = new ArrayList<>();
		for (Map<String,Object> map : list) {
			List<Object> data = new ArrayList<Object>();
			data.add("1");
			if("0".equals(type)){
				data.add(map.get("col0"));
			}else if("1".equals(type)){
				data.add(map.get("d_col0"));
			}
			for(String colString : queryTermList){
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					if(colString.equals(entry.getKey())){
						data.add(entry.getValue());
					}
				}
			}
			Object[] dataArr = data.toArray(new Object[data.size()]);
			dataList.add(dataArr);			
		}
		//导出
		ExportExcelUtil exportExcelUtil = new ExportExcelUtil(fileName, title, dataList, response);
		try {
			exportExcelUtil.export();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}