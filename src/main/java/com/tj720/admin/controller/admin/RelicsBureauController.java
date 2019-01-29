package com.tj720.admin.controller.admin;
/**
* @author chengrongkai
* @version 创建时间：2018年8月15日 下午3:38:34
* @ClassName 类名称
* @Description 文物修复单位
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dto.CollectionCategoryDto;
import com.tj720.admin.dto.CulturalRelicEquipmentDetailDto;
import com.tj720.admin.dto.CulturalRelicOtherEquipmentDto;
import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.admin.model.CulturalManageList;
import com.tj720.admin.model.CulturalRelicInfo;
import com.tj720.admin.model.CulturalRelicMainEquipment;
import com.tj720.admin.model.CulturalRelicOtherEquipment;
import com.tj720.admin.model.CulturalRelicPersonnelDetail;
import com.tj720.admin.model.CulturalSafeList;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.admin.service.MipCollectionCategoryService;
import com.tj720.admin.service.RelicsBureauService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/relicsBureau")
public class RelicsBureauController extends BaseController{
	
	@Autowired
	private RelicsBureauService relicsBureauService;
	@Autowired
	private UserService userService;
	@Autowired
	private IMuseumBaseInfoService museumBaseInfoService;
	@Autowired
	IMipOrganizationService mipOrganizationService;	
	@Autowired
	MipCollectionCategoryService mipCollectionCategoryService;	
	
	
	
	/**
	 * 基本信息
	 * @param relicsBureauId 文物修复单位ID
	 *
	 * @return 基本信息页面
	 */
	@RequestMapping("/relicsBureauInfo.do")
	@AuthPassport
	public String relicsBureauInfo(@RequestParam String relicsBureauId,Model model){
		String level = getLevel();//1:博物馆2：文物局
		String orgType = getOrgTypeId();//组织类型
		model.addAttribute("level", level);
		model.addAttribute("orgType", orgType);
		CulturalRelicInfo culturalRelicInfo = new CulturalRelicInfo();
		if (StringUtils.isNotBlank(relicsBureauId)) {
			model.addAttribute("orgId", relicsBureauId);
			culturalRelicInfo = relicsBureauService.getByOrgId(relicsBureauId);
			String ratifiedBusinessRange = culturalRelicInfo==null?"":culturalRelicInfo.getRatifiedBusinessRange();
			if (!MyString.isEmpty(culturalRelicInfo) && !MyString.isEmpty(ratifiedBusinessRange)) {
				List<String> repairs = new ArrayList<>();
				repairs = Arrays.asList(ratifiedBusinessRange.split(","));
				List<CollectionCategoryDto> collectionCategoryList = mipCollectionCategoryService.collectionCategoryList(1);
				for (CollectionCategoryDto dto : collectionCategoryList) {
					for (String repair : repairs) {
						if(dto.getId().equals(repair)) {
							dto.setChecked("1");
							break;
						}
					}
				}
				model.addAttribute("collectionCategoryList",collectionCategoryList);
			}else {
				model.addAttribute("collectionCategoryList",new ArrayList<CollectionCategoryDto>());
			}
			if (MyString.isEmpty(culturalRelicInfo)) {
				culturalRelicInfo = new CulturalRelicInfo();
				MipOrganization organization = mipOrganizationService.get(relicsBureauId);
				String museumName = organization.getName();
				culturalRelicInfo.setcName(museumName);
			}
			model.addAttribute("culturalRelicInfo", culturalRelicInfo);
		}
		return "/WEB-INF/back/baseInfo/relicsBureau/relicsBureauList.jsp";
	}
	
	
	@RequestMapping("/relicsBureauSave.do")
	@ResponseBody
	@AuthPassport
	public JsonResult relicsBureauSave(CulturalRelicInfo culturalRelicInfo,String isFull) {
		
		if (!MyString.isEmpty(culturalRelicInfo)) {
			String userId = Tools.getUser().getId();
			culturalRelicInfo.setUpdateTime(new Date());
			culturalRelicInfo.setUpdater(userId);
			int num = 0;
			try {
				//修改
				if (StringUtils.isNotBlank(culturalRelicInfo.getId())) {
					culturalRelicInfo.setDeleteMark("1");
					relicsBureauService.update(culturalRelicInfo);
					
					//删除所有为3状态的记录
					relicsBureauService.deleteInfo(culturalRelicInfo.getOrgId(),"3");
					//插入一条状态为3的修改记录数据
					String id = IdUtils.nextId(culturalRelicInfo);
					culturalRelicInfo.setId(id);
					culturalRelicInfo.setDeleteMark("3");
					culturalRelicInfo.setCreater(userId);
					culturalRelicInfo.setCreateTime(new Date());
					num = relicsBureauService.insert(culturalRelicInfo);
					
				} else {  //新增
					String id = IdUtils.nextId(culturalRelicInfo);
					culturalRelicInfo.setId(id);
					culturalRelicInfo.setDeleteMark("1");
					culturalRelicInfo.setCreater(userId);
					culturalRelicInfo.setCreateTime(new Date());
					num = relicsBureauService.insert(culturalRelicInfo);
				}
				
				if(num>0){
					MuseumDataProgressDto progressInfo = new MuseumDataProgressDto();
					progressInfo.setBasePer(isFull);
					progressInfo.setMuseumId(culturalRelicInfo.getOrgId());
					progressInfo.setFlag("1");
					int count =museumBaseInfoService.updateProgress(progressInfo);
					if(count>0){
						MuseumDataProgressDto pro = museumBaseInfoService.getDetail(culturalRelicInfo.getOrgId(),"1");
						MuseumDataProgressDto updateInfo = new MuseumDataProgressDto();
						updateInfo.setAllDataPer(Utils.RelicsBureauIsFull(pro));
						updateInfo.setMuseumId(culturalRelicInfo.getOrgId());
						updateInfo.setFlag("1");
						museumBaseInfoService.updateProgress(updateInfo);
						return new JsonResult(1);
					}else{
						return new JsonResult(0);
					}
				}else{
					return new JsonResult(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(0,"系统异常");
			}
			
		} else {
			return new JsonResult(0,"系统异常");
		}
	}
	
	
	
	
	/**
	 * 获取主要技术人员列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/list.do")
	@AuthPassport
	public String list(@RequestParam String relicsBureauId, Model model){
		String level = getLevel();//1:博物馆2：文物局
		String orgType = getOrgTypeId();//组织类型
		model.addAttribute("level", level);
		model.addAttribute("orgType", orgType);
		model.addAttribute("orgId", relicsBureauId);
		return "/WEB-INF/back/baseInfo/relicsBureau/relicsBureauPersonList.jsp";
	}

	/**
	 * 获取主要技术人员列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/goAdd.do")
	@AuthPassport
	public String goAdd(@RequestParam String relicsBureauId, @RequestParam String editId, @RequestParam String opt, Model model){
		String level = getLevel();//1:博物馆2：文物局
		String orgType = getOrgTypeId();//组织类型
		model.addAttribute("level", level);
		model.addAttribute("orgType", orgType);
		model.addAttribute("orgId", relicsBureauId);
		model.addAttribute("opt", opt);
		
		CulturalRelicPersonnelDetail personDetailInfo = relicsBureauService.get(editId);
		List<String> repairs = new ArrayList<>();
		if(personDetailInfo != null && StringUtils.isNotBlank(personDetailInfo.getId())) {
			model.addAttribute("personDetailInfo", personDetailInfo);
			String repairSpecialty = personDetailInfo.getRepairSpecialty();
			repairs = Arrays.asList(repairSpecialty.split(","));
		}else {
			model.addAttribute("personDetailInfo", new CulturalRelicPersonnelDetail());
		}
		
		List<CollectionCategoryDto> collectionCategoryList = mipCollectionCategoryService.collectionCategoryList(1);
		for (CollectionCategoryDto dto : collectionCategoryList) {
			for (String repair : repairs) {
				if(dto.getId().equals(repair)) {
					dto.setChecked("1");
					break;
				}
			}
		}
		model.addAttribute("collectionCategory", collectionCategoryList);
		model.addAttribute("repairs", repairs);
		return "/WEB-INF/back/baseInfo/relicsBureau/relicsBureauPersonAdd.jsp";
	}
	
	/**
	 * 获取主要技术人员列表数据
	 * @param relicsBureauId 文物修复单位ID
	 * @param relicsBureauName 文物修复单位名称
	 * @return 机构人员情况页面
	 */
	@RequestMapping("/getListData.do")
	@ResponseBody
	@AuthPassport
	public JSONObject getListData(@RequestParam String relicsBureauId){
		String level = getLevel();//1:博物馆2：文物局
		String orgType = getOrgTypeId();//组织类型
		JSONObject jsonObject = new JSONObject();
		if (StringUtils.isNotBlank(relicsBureauId)) {
			List<CulturalRelicPersonnelDetail> list1 = relicsBureauService.getPersonDetailInfo(relicsBureauId, level);
			for (CulturalRelicPersonnelDetail detail : list1) {
				String repairSpecialty = detail.getRepairSpecialty();
				if(StringUtils.isNotBlank(repairSpecialty)) {
					List<String> repairs = Arrays.asList(repairSpecialty.split(","));
					if(repairs != null && repairs.size() > 0) {
						String collectionSplitStringByIdList = mipCollectionCategoryService.getCollectionSplitStringByIdList(repairs);
						detail.setRepairSpecialty(collectionSplitStringByIdList);
					}
				}
			}
			jsonObject.put("code", 0);
			jsonObject.put("msg",""); 
			jsonObject.put("count", list1.size());
			jsonObject.put("data", list1);
		}
		return jsonObject;
	}

	/**
	 * 主要技术人员保存或者修改
	 * @param personnelDetail
	 * @return
	 */
	@RequestMapping("/personnelDetailSaveOrUpdate.do")
	@ResponseBody
	@AuthPassport
	public JsonResult personnelDetailSaveOrUpdate(CulturalRelicPersonnelDetail personnelDetail){
		String userId = Tools.getUser().getId();
		String orgId = personnelDetail.getOrgId();
		if(StringUtils.isBlank(userId)) {
			return new JsonResult(0, "请重新登陆");
		}
		try {
			if (personnelDetail != null && StringUtils.isNotBlank(personnelDetail.getId())) {
				personnelDetail.setUpdater(userId);
				personnelDetail.setUpdateTime(new Date());
				relicsBureauService.updatePersonDetail(personnelDetail);
			}else {
				String nextId = IdUtils.nextId(personnelDetail);
				personnelDetail.setId(nextId);
				personnelDetail.setCreater(userId);
				personnelDetail.setCreateTime(new Date());
				personnelDetail.setUpdater(userId);
				personnelDetail.setUpdateTime(new Date());
				personnelDetail.setDeleteMark("1");
				relicsBureauService.insertPersonDetail(personnelDetail);
			}
			MuseumDataProgressDto progressInfo = new MuseumDataProgressDto();
			progressInfo.setPersonPer("1");
			progressInfo.setMuseumId(orgId);
			progressInfo.setFlag("1");
			int count =museumBaseInfoService.updateProgress(progressInfo);
			if(count>0){
				MuseumDataProgressDto pro = museumBaseInfoService.getDetail(orgId,"1");
				MuseumDataProgressDto updateInfo = new MuseumDataProgressDto();
				updateInfo.setAllDataPer(Utils.RelicsBureauIsFull(pro));
				updateInfo.setMuseumId(orgId);
				updateInfo.setFlag("1");
				museumBaseInfoService.updateProgress(updateInfo);
				return new JsonResult(1);
			}else{
				return new JsonResult(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0);
		}
	}
	
	//人员详细删除
	@RequestMapping("/deleteDetail.do")
	@ResponseBody
	@AuthPassport
	public JsonResult deleteDetail(String id) {
		if (StringUtils.isNotBlank(id)) {
			try {
				relicsBureauService.deleteDetail(id);
				return new JsonResult(1);
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(0);
			}
		} else {
			return new JsonResult(0);
		}
	}
	
	
	/**
	 * 主要仪器设备
	 * @param relicsBureauId 文物修复单位ID
	 * @return 主要仪器设备页面
	 */
	@RequestMapping("/goList.do")
	@AuthPassport
	public ModelAndView list(@RequestParam String relicsBureauId){
		ModelAndView modle = new ModelAndView("/WEB-INF/back/baseInfo/relicsBureau/relicsBureauEquipment.jsp");
		modle.addObject("relicsBureauId", relicsBureauId);
		//查组织名称
		MipOrganization organization = mipOrganizationService.get(relicsBureauId);
		String museumName = organization.getName();
		modle.addObject("museumName", museumName);
		String level = getLevel();//1:博物馆2：文物局
		modle.addObject("level", level);
		int status = 0;
		List<CulturalRelicMainEquipment> info = relicsBureauService.getEquipmentByOrgId(relicsBureauId,level);
		if(null == info || info.size() == 0){
			modle.addObject("list",0);	
			status = 0;
		}else{
			modle.addObject("list",info);
			
			status = 1;
		}
		List<CulturalRelicOtherEquipment> otherInfo = relicsBureauService.getOtherEquipmentByOrgId(relicsBureauId,level);
		modle.addObject("otherInfo",otherInfo);
		modle.addObject("status",status);
		return modle;
	}
	
	@RequestMapping("/goOtherEquiment.do")
	@AuthPassport
	public ModelAndView addOtherEquiment(@RequestParam String relicsBureauId){
		ModelAndView modle = new ModelAndView("/WEB-INF/back/baseInfo/relicsBureau/otherEquipment.jsp");
		modle.addObject("orgId", relicsBureauId);
		//查组织名称
		MipOrganization organization = mipOrganizationService.get(relicsBureauId);
		String museumName = organization.getName();
		modle.addObject("museumName", museumName);
		String level = getLevel();//1:博物馆2：文物局
		modle.addObject("level", level);
	
		return modle;
	}
	
	@RequestMapping("/goEditOtherEquiment.do")
	@AuthPassport
	public ModelAndView editOtherEquiment(@RequestParam String relicsBureauId,@RequestParam String id){
		ModelAndView modle = new ModelAndView("/WEB-INF/back/baseInfo/relicsBureau/otherEquipment.jsp");
		modle.addObject("orgId", relicsBureauId);
		//查组织名称
		MipOrganization organization = mipOrganizationService.get(relicsBureauId);
		String museumName = organization.getName();
		modle.addObject("museumName", museumName);
		String level = getLevel();//1:博物馆2：文物局
		modle.addObject("level", level);
		CulturalRelicOtherEquipment culturalRelicOtherEquipment = relicsBureauService.getOtherEquipmentById(id);
		modle.addObject("culturalRelicOtherEquipment", culturalRelicOtherEquipment);
		modle.addObject("type", "edit");
		return modle;
	}
	
	@RequestMapping("/goShowOtherEquiment.do")
	public ModelAndView showOtherEquiment(@RequestParam String relicsBureauId,@RequestParam String id){
		ModelAndView modle = new ModelAndView("/WEB-INF/back/baseInfo/relicsBureau/otherEquipment.jsp");
		modle.addObject("orgId", relicsBureauId);
		//查组织名称
		MipOrganization organization = mipOrganizationService.get(relicsBureauId);
		String museumName = organization.getName();
		modle.addObject("museumName", museumName);
		String level = getLevel();//1:博物馆2：文物局
		modle.addObject("level", level);
		CulturalRelicOtherEquipment culturalRelicOtherEquipment = relicsBureauService.getOtherEquipmentById(id);
		modle.addObject("culturalRelicOtherEquipment", culturalRelicOtherEquipment);
		modle.addObject("type", "show");
		return modle;
	}
	
	@RequestMapping("/getOtherEquiment.do")
	@ResponseBody
	@AuthPassport
	public JSONObject getOtherEquiment(@RequestParam String relicsBureauId){		
		String level = getLevel();//1:博物馆2：文物局
		List<CulturalRelicOtherEquipment> culturalRelicOtherEquipment = relicsBureauService.getOtherEquipmentByOrgId(relicsBureauId, level);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg","");
		jsonObject.put("data", culturalRelicOtherEquipment);
		return jsonObject;
	}
	
	
	
	/**
	 *
	 * @param culturalRelicInfo
	 * @param isFull
	 * @return
	 */
	@RequestMapping("/saveEquipment.do")
	@ResponseBody
	@AuthPassport
	public JsonResult saveEquipment(@RequestBody CulturalRelicEquipmentDetailDto data){
		List<CulturalRelicMainEquipment> culturalRelicMainEquipment = data.getCulturalRelicMainEquipment();
		String isFull = data.getIsFull();
		if (!MyString.isEmpty(culturalRelicMainEquipment)) {
			String userId = Tools.getUser().getId();
			int num = 0;
			String orgId = data.getOrgId();
			try {
			for (int i = 0; i < culturalRelicMainEquipment.size(); i++) {
				CulturalRelicMainEquipment temp = culturalRelicMainEquipment.get(i);
				if(null == temp){
					break;
				}
				temp.setUpdateTime(new Date());
				temp.setUpdater(userId);
				temp.setOrgId(orgId);
				//修改
				if (StringUtils.isNotBlank(temp.getId())) {
					if(temp.getSpareData1().equals("2")){
						num = relicsBureauService.deleteEquipmentByPrimary(temp.getId());
					}else{	
						num = relicsBureauService.updateEquipment(temp);
					}
					
				} else {  //新增
					String id = IdUtils.nextId(temp);
					temp.setId(id);
					temp.setDeleteMark("1");
					temp.setCreateTime(new Date());
					temp.setCreater(userId);
					temp.setDataType("1");
					num = relicsBureauService.insertEquipment(temp);
				}
			}
									
				if(num>0){
					MuseumDataProgressDto progressInfo = new MuseumDataProgressDto();
					progressInfo.setDigitizationPer(isFull);
					progressInfo.setMuseumId(orgId);
					progressInfo.setFlag("1");
					int count =museumBaseInfoService.updateProgress(progressInfo);
					if(count>0){
						MuseumDataProgressDto pro = museumBaseInfoService.getDetail(orgId,"1");
						MuseumDataProgressDto updateInfo = new MuseumDataProgressDto();
						updateInfo.setAllDataPer(Utils.RelicsBureauEquipmentIsFull(pro));
						updateInfo.setMuseumId(orgId);
						updateInfo.setFlag("1");
						museumBaseInfoService.updateProgress(updateInfo);
						return new JsonResult(1);
					}else{
						return new JsonResult(0);
					}
				}else{
					return new JsonResult(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(0,"系统异常");
			}
			
		} else {
			return new JsonResult(0,"系统异常");
		}
	}
	
	@RequestMapping("/saveOtherEquipment.do")
	@ResponseBody
	@AuthPassport
	public JsonResult saveOtherEquipment(CulturalRelicOtherEquipmentDto data){
		CulturalRelicOtherEquipment culturalRelicOtherEquipment = data.getCulturalRelicOtherEquipment();
		if (!MyString.isEmpty(culturalRelicOtherEquipment)) {
			String userId = Tools.getUser().getId();
			int num1 = 0;
			String orgId = data.getOrgId();
			try {		
				culturalRelicOtherEquipment.setUpdateTime(new Date());
				culturalRelicOtherEquipment.setUpdater(userId);
				culturalRelicOtherEquipment.setOrgId(orgId);
					//修改
					if (StringUtils.isNotBlank(culturalRelicOtherEquipment.getId())) {					
						num1 = relicsBureauService.updateOtherEquipment(culturalRelicOtherEquipment);						
					} else {  //新增
						String id = IdUtils.nextId(culturalRelicOtherEquipment);
						culturalRelicOtherEquipment.setId(id);
						culturalRelicOtherEquipment.setDeleteMark("1");
						culturalRelicOtherEquipment.setCreateTime(new Date());
						culturalRelicOtherEquipment.setCreater(userId);
						num1 = relicsBureauService.insertOtherEquipment(culturalRelicOtherEquipment);
					}
					return new JsonResult(1);
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(0,"系统异常");
			}
			
		} else {
			return new JsonResult(0,"系统异常");
		}
	}
	
	@RequestMapping("/deleteOtherEquipment.do")
	@ResponseBody
	@AuthPassport
	public JsonResult deleteOtherEquipment(@RequestParam String id){	
		if (!MyString.isEmpty(id)) {
			try {		
				relicsBureauService.deleteOtherEquipmentByPrimary(id);
				return new JsonResult(1);
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(0,"系统异常");
			}
			
		} else {
			return new JsonResult(0,"参数有误");
		}
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
			//基本资料
			baseInfo(museumId);
			//机构人员
			orgPerson(museumId);
			//设备
			relicEquipment(museumId);
			//文物保管场所安全条件
			safeList(museumId);
			//主要管理制度和质量管理体系
			manageList(museumId);
			//提交完成度信息
			progressData(museumId);
			result ="1";
		} catch (Exception e) {
			e.printStackTrace();
			result="0";
		}
		return result;
	}
	//提交基本信息
	private void baseInfo(String museumId) {
		String flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		List<CulturalRelicInfo> infoList = relicsBureauService.getBaseInfo(museumId,flag);
		flag = "2";
		relicsBureauService.deleteInfo(museumId,flag);
		if (infoList.size() > 0) {
			for (int i = 0;i < infoList.size();i++) {
				CulturalRelicInfo culturalRelicInfo = infoList.get(i);
				culturalRelicInfo.setDeleteMark(flag);
				relicsBureauService.insertPlus(culturalRelicInfo);
			}
		}
		flag = "3";
		List<CulturalRelicInfo> editInfoList = relicsBureauService.getBaseInfo(museumId,flag);
		if (editInfoList.size() > 0) {
			for (int i = 0;i < editInfoList.size();i++) {
				CulturalRelicInfo culturalRelicInfo = editInfoList.get(i);
				flag = "4";
				culturalRelicInfo.setDeleteMark(flag);
				relicsBureauService.update(culturalRelicInfo);
			}
		}
	}
	//提交机构人员信息
	private void orgPerson(String museumId) {
		String flag1 = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		List<CulturalRelicPersonnelDetail> personDetailInfo = relicsBureauService.getPersonDetailInfo(museumId,flag1);
		flag1 = "2";
		relicsBureauService.deletePersonDetail(museumId, flag1);
		if (personDetailInfo.size() > 0) {
			for (int i = 0;i < personDetailInfo.size();i++) {
				CulturalRelicPersonnelDetail personnelDetail = personDetailInfo.get(i);
				personnelDetail.setDeleteMark(flag1);
				relicsBureauService.insertPersonDetailPlus(personnelDetail);
			}
		}
		flag1 = "3";
		List<CulturalRelicPersonnelDetail> editPersonDetailInfo = relicsBureauService.getPersonDetailInfo(museumId,flag1);
		if (editPersonDetailInfo.size() > 0) {
			for (int i = 0;i < editPersonDetailInfo.size();i++) {
				CulturalRelicPersonnelDetail personnelDetail = editPersonDetailInfo.get(i);
				flag1 = "4";
				personnelDetail.setDeleteMark(flag1);
				relicsBureauService.updatePersonDetail(personnelDetail);
			}
		}
	}
	private void relicEquipment(String museumId) {
		String flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		List<CulturalRelicMainEquipment> base = relicsBureauService.getEquipmentByOrgId(museumId,flag);
		relicsBureauService.deleteEquipment(museumId, "2");//删除所有为2状态的记录
		if(base!=null && base.size()>0){
			for (int i = 0; i < base.size(); i++) {
				CulturalRelicMainEquipment temp = base.get(i);
				
				flag = "2";
				temp.setDeleteMark(flag);
				temp.setDataType("1");
				relicsBureauService.insertEquipmentPlus(temp);//插入一条状态2的记录
			}
		}
		flag = "3";
		List<CulturalRelicMainEquipment> editBase = relicsBureauService.getEquipmentByOrgId(museumId,flag);
		if(editBase!=null && editBase.size()>0){
			for (int i = 0; i < editBase.size(); i++) {
				CulturalRelicMainEquipment temp = editBase.get(i);
				flag = "4";
				temp.setDeleteMark("4");
				relicsBureauService.updateEquipment(temp);//将状态为3的记录更新为4
			}
			
		}
		//其他设备
		String flag1 = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		List<CulturalRelicOtherEquipment> base1 = relicsBureauService.getOtherEquipmentByOrgId(museumId,flag1);
		relicsBureauService.deleteOtherEquipment(museumId, "2");//删除所有为2状态的记录
		if(base!=null && base.size()>0){
			for (int i = 0; i < base1.size(); i++) {
				CulturalRelicOtherEquipment temp = base1.get(i);
				
				flag1 = "2";
				temp.setDeleteMark(flag1);
				relicsBureauService.insertOtherEquipmentPlus(temp);//插入一条状态2的记录
			}
		}
		flag1 = "3";
		List<CulturalRelicOtherEquipment> editBase1 = relicsBureauService.getOtherEquipmentByOrgId(museumId,flag1);
		if(editBase!=null && editBase1.size()>0){
			for (int i = 0; i < editBase1.size(); i++) {
				CulturalRelicOtherEquipment temp = editBase1.get(i);
				flag1 = "4";
				temp.setDeleteMark("4");
				relicsBureauService.updateOtherEquipment(temp);//将状态为3的记录更新为4
			}
			
		}
	}
	
	private void safeList(String museumId) {
		String flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		List<CulturalSafeList> safeList= relicsBureauService.getCulturalSafeFileList(museumId,flag);
		relicsBureauService.deleteSafe(museumId, "2");//删除所有为2状态的记录
		if(safeList!=null && safeList.size()>0){
			for (int i = 0; i < safeList.size(); i++) {
				CulturalSafeList temp = safeList.get(i);
				
				flag = "2";
				temp.setDeleteMark(flag);
				relicsBureauService.insertSafe(temp);//插入一条状态2的记录
			}
		}
	}
	
	
	private void manageList(String museumId) {
		String flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		List<CulturalManageList> safeList= relicsBureauService.getCulturalManageFileList(museumId,flag);
		relicsBureauService.deleteManage(museumId, "2");//删除所有为2状态的记录
		if(safeList!=null && safeList.size()>0){
			for (int i = 0; i < safeList.size(); i++) {
				CulturalManageList temp = safeList.get(i);
				flag = "2";
				temp.setDeleteMark(flag);
				relicsBureauService.insertManage(temp);//插入一条状态2的记录
			}
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
	
	/**
	 * 文物保管场所安全条件
	 * @param relicsBureauId 文物修复单位ID
	 * @return 文物保管场所安全条件页面
	 */
	@RequestMapping("/safeFileList.do")
	@AuthPassport
	public ModelAndView safeFileList(@RequestParam String relicsBureauId){
		ModelAndView modle = new ModelAndView("/WEB-INF/back/baseInfo/relicsBureau/relicsSafeFile.jsp");
		modle.addObject("museumId", relicsBureauId);
		String level = getLevel();//1:博物馆2：文物局
		modle.addObject("level", level);
		return modle;
	}
	
	/**
	 * 根据博物馆id查询文物保管场所安全条件附件列表
	 * @param museumId
	 * @return
	 */
	@RequestMapping(value = "/getCulturalSafeFileList.do")
	@ResponseBody
	@AuthPassport
	public JsonResult getCulturalSafeFileList(String museumId,String level){
		try {
			List<CulturalSafeList> safeList= relicsBureauService.getCulturalSafeFileList(museumId,level);
			return  new JsonResult(1,safeList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(0,"查询失败");
		}

	}
	
	/**
	 * 保存文物保管场所安全条件附件列表
	 * @param museumId
	 * @return
	 */
	@RequestMapping(value = "/saveCulturalSafeFileList.do")
	@ResponseBody
	@AuthPassport
	public JsonResult saveCulturalSafeFileList(String fileStr,String  museumId){
		try {
			JSONArray jsonArray=JSONArray.fromObject(fileStr);
			List<CulturalSafeList> safeList =(List<CulturalSafeList>)JSONArray.toCollection(jsonArray,CulturalSafeList.class);
			JsonResult result = relicsBureauService.saveCulturalSafeFileList(safeList,museumId);
			return  result;
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(0,"查询失败");
		}

	}
	
	
	/**
	 * 主要管理制度和质量管理体系
	 * @param relicsBureauId 文物修复单位ID
	 * @return 主要管理制度和质量管理体系页面
	 */
	@RequestMapping("/manageFileList.do")
	@AuthPassport
	public ModelAndView manageFileList(@RequestParam String relicsBureauId){
		ModelAndView modle = new ModelAndView("/WEB-INF/back/baseInfo/relicsBureau/relicsManageFile.jsp");
		modle.addObject("museumId", relicsBureauId);
		String level = getLevel();//1:博物馆2：文物局
		modle.addObject("level", level);
		return modle;
	}
	
	/**
	 * 根据博物馆id查询主要管理制度和质量管理体系附件列表
	 * @param museumId
	 * @return
	 */
	@RequestMapping(value = "/getCulturalManageFileList.do")
	@ResponseBody
	@AuthPassport
	public JsonResult getCulturalManageFileList(String museumId,String level){
		try {
			List<CulturalManageList> safeList= relicsBureauService.getCulturalManageFileList(museumId,level);
			return  new JsonResult(1,safeList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(0,"查询失败");
		}

	}
	
	/**
	 * 保存主要管理制度和质量管理体系附件列表
	 * @param museumId
	 * @return
	 */
	@RequestMapping(value = "/saveCulturalManageFileList.do")
	@ResponseBody
	@AuthPassport
	public JsonResult saveCulturalManageFileList(String fileStr,String  museumId){
		try {
			JSONArray jsonArray=JSONArray.fromObject(fileStr);
			List<CulturalManageList> safeList =(List<CulturalManageList>)JSONArray.toCollection(jsonArray,CulturalManageList.class);
			JsonResult result = relicsBureauService.saveCulturalManageFileList(safeList,museumId);
			return  result;
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(0,"查询失败");
		}

	}
}
