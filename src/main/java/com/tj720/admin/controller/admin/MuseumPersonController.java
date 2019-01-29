package com.tj720.admin.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.common.constant.Constants;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.admin.dto.MuseumDepartmentDto;
import com.tj720.admin.dto.MuseumPersonDto;
import com.tj720.admin.dto.Node;
import com.tj720.admin.dto.PersonAwardRecordDto;
import com.tj720.admin.dto.PersonCertificationDto;
import com.tj720.admin.model.CmsSubject;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.admin.service.IMuseumDepartmentService;
import com.tj720.admin.service.IMuseumPersonService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/**
 * 人员情况Controller
 * @author chenshiya
 * @version 2018-05-17
 */
@Controller
@RequestMapping("/museumPerson")
public class MuseumPersonController extends BaseController{

	@Autowired
	private IMuseumPersonService museumPersonService;
	@Autowired
	private IMuseumBaseInfoService museumBaseInfoService;
	@Autowired
	private IMuseumDepartmentService departmentService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;

	/**
	 * 人员列表页面
	 * @param 
	 * @return
	 */
	@RequestMapping("goList.do")
	public ModelAndView goList(String museumId){
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/museumPerson.jsp");
		String level = getLevel();//1:博物馆2：文物局
		modelAndView.addObject("level", level);
		modelAndView.addObject("museumId", museumId);
		return modelAndView;
	}
	
	/**
	 * 查询人员列表
	 * @param personDto
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/personList.do")
	public JSONObject list(String museumId,String department,String personName,@RequestParam(defaultValue = "10") int size, 
			@RequestParam(defaultValue = "1",name = "page") int currentPage) {
		String level = getLevel();//1:博物馆2：文物局
		//查询部门下面所有的子部门
		List<MuseumDepartmentDto> leafList = new ArrayList<MuseumDepartmentDto>();
		getLeafList(leafList,department);
		String departIdList[]=new String[leafList.size()];
		for(int i=0;i<leafList.size();i++){
			departIdList[i]=leafList.get(i).getId();
		}
		
		Map<String,Object> countMap = new HashMap<String, Object>();
		countMap.put("museumId", museumId);
		countMap.put("flag", level);
		countMap.put("personName", personName);
		countMap.put("departIdList", departIdList);
		Integer count = museumPersonService.getCount(countMap);
		
		//分页
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		page.setAllRow(count);
		
		Map<String,Object> map = new HashMap<String, Object>();
		Integer startInt = page.getStart();
		Integer endInt = page.getSize()+startInt;
		map.put("start", startInt);
		map.put("end", endInt-startInt);
		map.put("museumId", museumId);
		map.put("personName", personName);
		map.put("flag", level);
		map.put("departIdList", departIdList);
		
		List<MuseumPersonDto> personList = museumPersonService.selectList(map);
		
		for(MuseumPersonDto info :personList){
			String depName = "";
			String depId = info.getDepartment();
			MuseumDepartmentDto departmentDto = departmentService.getById(depId);
			List<String> nameList = new ArrayList<String>();
			nameList.add(departmentDto.getDepName());
			getDepartName(nameList,depId);
			for(int i=nameList.size()-1;i>=0;i--){
				depName += " "+nameList.get(i);
			}
			info.setDepartmentName(depName);
		}
		
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg",""); 
        jsonObject.put("count", page.getAllRow());
        jsonObject.put("data", personList);
		return jsonObject;
	}

	private List<String> getDepartName(List<String> nameList,String depId){
		MuseumDepartmentDto departmentDto = departmentService.getParentDepartInfo(depId);
		if(departmentDto!=null && departmentDto.getLevel()>1){
			nameList.add(departmentDto.getDepName());
			getDepartName(nameList,departmentDto.getId());
		}
		return nameList;
	}
	private List<MuseumDepartmentDto> getLeafList(List<MuseumDepartmentDto> leafList,String pId){
		MuseumDepartmentDto departmentDto = new MuseumDepartmentDto();
		departmentDto.setId(pId);
		leafList.add(departmentDto);
		List<MuseumDepartmentDto> list =  departmentService.selectDepartByFid(pId);
		for(MuseumDepartmentDto info : list) {
			getLeafList(leafList,info.getId());
        }
		return leafList;
	}
	@RequestMapping("/certificationList.do")
	public ModelAndView certificationList(String personId,String museumId) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/certificationList.jsp");
		String level = getLevel();//1:博物馆2：文物局
		modelAndView.addObject("level", level);
		List<PersonCertificationDto> certificationList = museumPersonService.selectCertificationList(personId);
		modelAndView.addObject("certificationList", certificationList);
		modelAndView.addObject("personId", personId);
		modelAndView.addObject("museumId", museumId);
		return modelAndView;
	}

	@RequestMapping("/awardList.do")
	public ModelAndView awardList(String personId,String museumId) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/awardList.jsp");
		List<PersonAwardRecordDto> awardList = museumPersonService.selectAwardList(personId);
		modelAndView.addObject("awardList", awardList);
		modelAndView.addObject("personId", personId);
		modelAndView.addObject("museumId", museumId);
		String level = getLevel();//1:博物馆2：文物局
		modelAndView.addObject("level", level);
		return modelAndView;
	}
	/**
	 * 人员基础信息页面
	 */
	@RequestMapping("/personInfo.do")
	public ModelAndView form(String personId,String museumId,String department) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/personDetail.jsp");
		if(StringUtils.isNotEmpty(personId)){
			MuseumPersonDto info = museumPersonService.selectForm(personId);
			modelAndView.addObject("personInfo", info);
			modelAndView.addObject("personId", personId);
		}
		modelAndView.addObject("museumId", museumId);
		modelAndView.addObject("department", department);
		String level = getLevel();//1:博物馆2：文物局
		modelAndView.addObject("level", level);
		return modelAndView;
	}

	/**
	 * 保存人员基础信息
	 */
	@ResponseBody
	@RequestMapping("/savePerson.do")
	public JsonResult savePerson(MuseumPersonDto personDto) throws Exception{
		JsonResult result = null;
		try {
			String serviceId = personDto.getId();
			if(StringUtils.isNotEmpty(serviceId)){
				museumPersonService.update(personDto);
			}else{
				personDto.setFlag("1");
				personDto.setId(IdUtils.nextId(personDto));
				museumPersonService.insert(personDto);
			}
			MuseumDataProgressDto progressInfo = new MuseumDataProgressDto();
			progressInfo.setPersonPer("1");//人员填写完成
			progressInfo.setMuseumId(personDto.getMuseumId());
			progressInfo.setFlag("1");
			int count =museumBaseInfoService.updateProgress(progressInfo);
			if(count>0){
				MuseumDataProgressDto pro = museumBaseInfoService.getDetail(personDto.getMuseumId(),"1");
				MuseumDataProgressDto updateInfo = new MuseumDataProgressDto();
				updateInfo.setAllDataPer(Utils.progressIsFull(pro));
				updateInfo.setMuseumId(personDto.getMuseumId());
				updateInfo.setFlag("1");
				museumBaseInfoService.updateProgress(updateInfo);
				Map<String,String> resultMap = new HashMap<String,String>();
				resultMap.put("personId", personDto.getId());
				resultMap.put("museumId", personDto.getMuseumId());
				resultMap.put("department", personDto.getDepartment());
				result = new JsonResult(1,resultMap);
			}else{
				result = new JsonResult(0,"保存失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			result = new JsonResult(0,"保存失败");
			
		}
		return result;
	}
	
	/**
	 * 删除人员
	 */
	@ResponseBody
	@RequestMapping("/deletePerson.do")
	public JsonResult delete(String personId) {
		JsonResult result = null;
		int num =museumPersonService.deleteByLogic(personId);
		if(num>0){
			result = new JsonResult(1,"删除成功");
		}else{
			result = new JsonResult(0,"删除失败");
		}
		return result;
	}

	/**
	 * 删除获奖情况
	 */
	@ResponseBody
	@RequestMapping("/awardDelete.do")
	public JsonResult awardDelete(String id) {
		JsonResult result = null;
		int num = museumPersonService.deleteAward(id);
		if(num>0){
			result = new JsonResult(1,"删除成功");
		}else{
			result = new JsonResult(0,"删除失败");
		}
		return result;
	}

	/**
	 * 删除人员资质证书
	 */
	@ResponseBody
	@RequestMapping("/certificationDelete.do")
	public JsonResult certificationDelete(String id) {
		JsonResult result = null;
		int num = museumPersonService.deleteCertification(id);
		if(num>0){
			result = new JsonResult(1,"删除成功");
		}else{
			result = new JsonResult(0,"删除失败");
		}
		return result;
	}


	/**
	 * 保存资质证书
	 */
	@ResponseBody
	@RequestMapping("/certificationSave.do")
	public JsonResult certificationSave(String certificationListStr,String museumId) throws Exception{
		JsonResult result = null;
		try {
			JSONArray jsonArray=JSONArray.fromObject(certificationListStr);
			List<PersonCertificationDto> certificationList =(List<PersonCertificationDto>)JSONArray.toCollection(jsonArray,PersonCertificationDto.class);

			for(PersonCertificationDto certificationInfo: certificationList){
				if(StringUtils.isNotBlank(certificationInfo.getId())){
					museumPersonService.updateCertification(certificationInfo);
				}else{
					museumPersonService.insertCertification(certificationInfo);
				}
			}
			result= new JsonResult(1,"保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			result= new JsonResult(0,"保存失败");
		}
		
		return result;
	}

	/**
	 * 保存获奖情况
	 */
	@ResponseBody
	@RequestMapping("/awardSave.do")
	public JsonResult awardSave(String awardListStr,String museumId) throws Exception{
		JsonResult result = null;
		try {
			JSONArray jsonArray=JSONArray.fromObject(awardListStr);
			List<PersonAwardRecordDto> awardRecordDtoList =(List<PersonAwardRecordDto>)JSONArray.toCollection(jsonArray,PersonAwardRecordDto.class);

			for(PersonAwardRecordDto awardRecordInfo: awardRecordDtoList){
				if(StringUtils.isNotBlank(awardRecordInfo.getId())){
					museumPersonService.updateAward(awardRecordInfo);
				}else{
					museumPersonService.insertAward(awardRecordInfo);
				}
			}
			result = new JsonResult(1,"保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			result = new JsonResult(0,"保存失败");
		}
		
		return result;
	}
	
	/**
	 * 获取部门列表数据(列表树使用)
	 * @param 
	 * @return
	 */
	@RequestMapping("departTree.do")
	@ResponseBody
	public JsonResult ztreeList(String museumId){
		List<MuseumDepartmentDto> departmentDtoList = departmentService.selectList(museumId);
		//如果部门没有任何数据，则新增一个跟节点，以博物馆名称命名
		if(departmentDtoList.size()==0){
			MipOrganization organization = mipOrganizationService.get(museumId);
			String museumName = organization.getName();
			MuseumDepartmentDto departmentDto = new MuseumDepartmentDto();
			departmentDto.setId(IdUtils.nextId(departmentDto));
			departmentDto.setMuseumId(museumId);
			departmentDto.setfId("0");
			departmentDto.setDepName(museumName);
			departmentDto.setStatus("1");
			departmentDto.setLevel(1);
			departmentService.insert(departmentDto);
			departmentDtoList = departmentService.selectList(museumId);
		}
		List<Node> nodeList = new ArrayList<>();
		convertSubject2Node(departmentDtoList, nodeList);
		return new JsonResult(Constants.RES_SUCCESS, nodeList);
	}
	
	/**
	 * 部门转换为node树
	 * @param subjectList
	 * @param nodeList
	 */
	private void convertSubject2Node(List<MuseumDepartmentDto> subjectList, List<Node> nodeList) {
		if(CollectionUtils.isEmpty(subjectList)) {
			return;
		}
		int i = 0;
		for(MuseumDepartmentDto departmentDto : subjectList){
			Boolean isOpen = i == 0 ? true : false;
			Node node = new Node(departmentDto.getId(), departmentDto.getfId(), departmentDto.getDepName(), isOpen);
			nodeList.add(node);
		}
	}
	
	/**
	 * 新增部门页面
	 * @param 
	 * @return
	 */
	@RequestMapping("/addDep.do")
	public ModelAndView addDep(String museumId){
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/addDepartment.jsp");
		
		List<MuseumDepartmentDto> departmentDtoList = departmentService.selectList(museumId);
		List<Node> nodeList = new ArrayList<>();
		convertSubject2Node(departmentDtoList, nodeList);
		String level = getLevel();//1:博物馆2：文物局
		modelAndView.addObject("level", level);
		modelAndView.addObject("museumId", museumId);
		modelAndView.addObject("nodeList", JSON.toJSON(nodeList));
		return modelAndView;
	}
	
	/**
	 * 修改部门页面
	 * @param 
	 * @return
	 */
	@RequestMapping("/editDep.do")
	public ModelAndView editDep(String museumId){
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/editDepartment.jsp");
		List<MuseumDepartmentDto> departmentDtoList = departmentService.selectList(museumId);
		List<Node> nodeList = new ArrayList<>();
		convertSubject2Node(departmentDtoList, nodeList);
		String level = getLevel();//1:博物馆2：文物局
		modelAndView.addObject("level", level);
		modelAndView.addObject("museumId", museumId);
		modelAndView.addObject("nodeList", JSON.toJSON(nodeList));
		return modelAndView;
	}
	
	/**
	 * 删除部门页面
	 * @param 
	 * @return
	 */
	@RequestMapping("/goDelete.do")
	public ModelAndView goDelete(String museumId){
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/deleteDepartment.jsp");
		List<MuseumDepartmentDto> departmentDtoList = departmentService.selectList(museumId);
		List<Node> nodeList = new ArrayList<>();
		convertSubject2Node(departmentDtoList, nodeList);
		String level = getLevel();//1:博物馆2：文物局
		modelAndView.addObject("level", level);
		modelAndView.addObject("museumId", museumId);
		modelAndView.addObject("nodeList", JSON.toJSON(nodeList));
		return modelAndView;
	}
	
	/**
	 * 保存和更新部门
	 * @param 
	 * @return
	 */
	@RequestMapping("/saveDep.do")
	@ResponseBody
	public JsonResult saveDep(MuseumDepartmentDto departmentDto){
		JsonResult result = null;
		int num;
		if(StringUtils.isNotBlank(departmentDto.getId())){
			num = departmentService.update(departmentDto);
			if(num>0){
				result = new JsonResult(1,"保存成功");
			}else{
				result = new JsonResult(0,"保存失败");
			}
		} else {
			MuseumDepartmentDto fDto = departmentService.getById(departmentDto.getfId());
			if(fDto==null){
				result = new JsonResult(0,"保存失败，系统异常");
			}
			Integer flevel = fDto.getLevel() !=null? fDto.getLevel() : 0;
			departmentDto.setLevel(flevel+1);
			departmentDto.setStatus("1");
			num=departmentService.insert(departmentDto);
			if(num>0){
				result = new JsonResult(1,"保存成功");
			}else{
				result = new JsonResult(0,"保存失败");
			}
		}
		return result;
	}
	
	/**
	 * 删除部门
	 * @param 
	 * @return
	 */
	@RequestMapping("/deleteDep.do")
	@ResponseBody
	public JsonResult deleteDep(String id,String museumId){
		JsonResult result = null;
		if(StringUtils.isNotBlank(id)){
			//查询下面是否存在部门
			try {
				List<MuseumDepartmentDto> departmentList = departmentService.getDepByParentId(id);
				if(departmentList.size() == 0) {
					//查询部门下面是否有人员
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("start", 1);
					map.put("end", 9999);
					map.put("museumId", museumId);
					map.put("flag", "1");
					String departIdList[]=new String[1];
					departIdList[0]=id;
					map.put("departIdList", departIdList);
					List<MuseumPersonDto> personList = museumPersonService.selectList(map);
					if(personList.size()>0){
						result= new JsonResult(2,"部门中有人员记录，请删除人员后重新操作");
					}else{
						MuseumDepartmentDto departmentDto = new MuseumDepartmentDto();
						departmentDto.setId(id);
						departmentDto.setStatus("0");
						int num = departmentService.update(departmentDto);
						if(num>0){
							result = new JsonResult(1,"删除成功");
						}else{
							result = new JsonResult(0,"删除失败");
						}
					}
				}else {
					result= new JsonResult(2,"部门下存在子部门，请删除子部门后重新操作");
				}
			} catch (Exception e) {
				e.printStackTrace();
				result= new JsonResult(2,"参数错误");
			}
		} else {
			result= new JsonResult(2,"参数错误");
		}
		return result;
	}

    private String encodeStr(String str) {  
        try {  
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
}