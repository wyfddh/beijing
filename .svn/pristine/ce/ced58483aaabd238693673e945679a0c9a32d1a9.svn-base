package com.tj720.admin.controller.admin;
/**
* @author chengrongkai
* @version 创建时间：2018年8月15日 下午3:44:46
* @ClassName 类名称
* @Description 文物收藏单位
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
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
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dto.MuseumBaseInfoDto;
import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.admin.model.CulturalOrgInfo;
import com.tj720.admin.model.MipAttachment;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.admin.service.RelicsUnitService;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/relicsUnitInfo")
public class RelicsUnitController extends BaseController{
	@Autowired
	RelicsUnitService relicsUnitService;
	@Autowired
    Config config;
	@Autowired
	IMipOrganizationService mipOrganizationService;	
	@Autowired
	IMuseumBaseInfoService museumBaseInfoService;
	/**
	 * 基本信息
	 * @param relicsUnitId 文物收藏单位Id
	 * @param relicsUnitName 文物收藏单位名称
	 * @return
	 */
	@RequestMapping("/relicsUnitInfo.do")
	@AuthPassport
	public ModelAndView relicsUnitInfo(@RequestParam String relicsUnitId){
		ModelAndView modle = new ModelAndView("/WEB-INF/back/baseInfo/relicsUnit/relicsUnitList.jsp");
		modle.addObject("relicsUnitId", relicsUnitId);
		//查组织名称
		MipOrganization organization = mipOrganizationService.get(relicsUnitId);
		String relicsUnitName = organization.getName();
		modle.addObject("relicsUnitName", relicsUnitName);
		String level = getLevel();//1:博物馆2：文物局
		modle.addObject("level", level);
		//只有从机构资料列表进来的请求relicsUnitId才有值
		CulturalOrgInfo result = relicsUnitService.selectRelicsUnitById(relicsUnitId,level);
		if(result != null){
			modle.addObject("result", result);						
		}		
		//上级主管
		MipOrganization parenOrg = mipOrganizationService.get(organization.getParentId());
		if(parenOrg!=null){
			modle.addObject("parentOrgName",parenOrg.getName());
		}
		
		//区域列表
		List<Map<String,Object>> areaList = museumBaseInfoService.getAreaList();
		if(areaList.size()>0){
			modle.addObject("areaList",areaList);
		}
		modle.addObject("level", level);
		return modle;
	}
	
	/**
	 * 保存博物馆基础资料
	 */
	@RequestMapping("/relicsUnitSave.do")
	@ResponseBody
	@AuthPassport
	public String save(CulturalOrgInfo culturalOrgInfo,String isFull,String uploads){
		String result = "";
		try {
			String userId = Tools.getUser().getId();
			int num =  relicsUnitService.saveBaseInfo(culturalOrgInfo);						
			if(num>0){
				MuseumDataProgressDto progressInfo = new MuseumDataProgressDto();
				progressInfo.setBasePer(isFull);
				progressInfo.setMuseumId(culturalOrgInfo.getOrgId());
				progressInfo.setFlag("1");
				int count =museumBaseInfoService.updateProgress(progressInfo);
				if(count>0){
					MuseumDataProgressDto pro = museumBaseInfoService.getDetail(culturalOrgInfo.getOrgId(),"1");
					MuseumDataProgressDto updateInfo = new MuseumDataProgressDto();
					updateInfo.setAllDataPer(Utils.RelicsUnitIsFull(pro));
					updateInfo.setMuseumId(culturalOrgInfo.getOrgId());
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
	 * 详情页
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/relicsUnitDetail.do")
	@AuthPassport
	public ModelAndView museumDetail(String relicsUnitId) {
		
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/relicsUnit/relicsUnitDetail.jsp");
		String level = getLevel();//1:博物馆2：文物局
		String orgType = getOrgTypeId();//组织类型
		//博物馆人员登录查询组织id
		String orgId = getOrgId();
		//只有从机构资料列表进来的请求museumId才有值
		if(StringUtils.isEmpty(relicsUnitId)){
			relicsUnitId = orgId;
		}
		
		modelAndView.addObject("orgId", orgId);//超级管理员orgid=0
		modelAndView.addObject("orgType", orgType);
		modelAndView.addObject("level", level);
		MuseumDataProgressDto resultMap = museumBaseInfoService.getDetail(relicsUnitId,level);
		if(resultMap != null){
			modelAndView.addObject("result", resultMap);
		}
		
		//查询上传提交时间
		MuseumDataProgressDto levelTwoMap = museumBaseInfoService.getDetail(relicsUnitId,"2");
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
	 * 详情页面保存
	 */
	@RequestMapping("/saveDetail.do")
	@ResponseBody
	@AuthPassport
	public String saveDetail(String museumId){
		String result = "";
		try {
			//博物馆基础资料
			baseInfo(museumId);
			//提交完成度信息
			progressData(museumId);
			result ="1";
		} catch (Exception e) {
			e.printStackTrace();
			result="0";
		}
		return result;
	}
	
	private void baseInfo(String museumId) {
		String flag = "1";//（1：保存状态（博物馆可看） 2：提交状态（文物局可看）；3：修改保存状态；4：修改提交状态（文物局可看））
		CulturalOrgInfo base = relicsUnitService.selectRelicsUnitById(museumId,flag);
		if(base!=null ){
			flag = "2";
			relicsUnitService.delBaseInfo(museumId, flag);//删除所有为2状态的记录
			base.setDeleteMark(flag);
			relicsUnitService.insertBaseInfoByFlag(base);//插入一条状态2的记录
		}
		flag = "3";
		CulturalOrgInfo editBase = relicsUnitService.selectRelicsUnitById(museumId,flag);
		if(editBase!=null){
			flag = "4";
			editBase.setDeleteMark("4");
			relicsUnitService.updateBaseInfoByFlag(editBase);//将状态为3的记录更新为4
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
}
