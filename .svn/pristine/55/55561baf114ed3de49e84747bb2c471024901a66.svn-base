package com.tj720.admin.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.admin.base.controller.BaseController;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dto.MuseumBaseHouseDto;
import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.admin.dto.MuseumHouseBuildingDto;
import com.tj720.admin.dto.MuseumShowRoomDto;
import com.tj720.admin.dto.MuseumWarehouseDto;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.admin.service.IMuseumHouseBuildingService;
import com.tj720.admin.service.IMuseumShowRoomService;
import com.tj720.admin.service.IMuseumWarehouseService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.utils.MyString;

import net.sf.json.JSONArray;

/**
 * 博物馆基础资料Controller
 * @author chenshiya
 * @version 2018-06-27
 */
@Controller
@RequestMapping("/museumHouseBuilding")
public class MuseumHouseBuildingController extends BaseController{

	@Autowired
	private IMuseumHouseBuildingService museumHouseBuildingService;

	@Autowired
	private IMuseumBaseInfoService museumBaseInfoService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	
	@Autowired
	private IMuseumWarehouseService warehouseService;
	@Autowired
	private IMuseumShowRoomService showRoomService;
	/**
	 * 馆舍建筑页面
	 */
	@ResponseBody
	@RequestMapping("/list.do")
	public  ModelAndView list(String museumId) {
		
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/baseInfo/museumHouseBuild.jsp");
		String level = getLevel();//1:博物馆2：文物局
		modelAndView.addObject("level", level);
		//基础信息
		MuseumBaseHouseDto museumBaseHouseDto = museumHouseBuildingService.selectForm(museumId,level);
		modelAndView.addObject("base", museumBaseHouseDto);
		//馆舍信息
		List<MuseumHouseBuildingDto> houseInfoList = museumHouseBuildingService.selectList(museumId,level);
		if(houseInfoList.size()>0){
			modelAndView.addObject("houseList", houseInfoList);
		}
		//库房信息
		List<MuseumWarehouseDto> wareList = warehouseService.selectList(museumId,level);
		if(wareList.size()>0){
			modelAndView.addObject("wareList", wareList);
		}
		//展厅信息
		List<MuseumShowRoomDto> roomList = showRoomService.selectList(museumId,level);
		if(roomList.size()>0){
			modelAndView.addObject("roomList", roomList);
		}
		modelAndView.addObject("museumId", museumId);
		
		//查组织名称
		MipOrganization organization1 = mipOrganizationService.get(museumId);
		String museumName = organization1.getName();
		modelAndView.addObject("museumName", museumName);
		return modelAndView;
	}

	/**
	 * 保存馆舍建筑资料
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public JsonResult add(MuseumBaseHouseDto museumBaseHouseInfo, String isFull) throws Exception{
		JsonResult result = null;
		// 当前登录者
		Boolean change = false;
		try {
			String houseInfoId = museumBaseHouseInfo.getId();
			if(!MyString.isEmpty(houseInfoId)){
				
				//查修改前数据
				String museumId = museumBaseHouseInfo.getMuseumId();
				MuseumBaseHouseDto baseInfo = museumHouseBuildingService.selectForm(museumId,"1");
				
				//需要校验是否改变的字段
				String[] obj = {"allBuildingArea","allFloorArea","exhibitionArea","publicArea","collectionArea","officeArea","repairSite","repairArea"};
				change = Utils.isChanged(baseInfo,museumBaseHouseInfo,obj);
				//更新基础信息数据
				museumHouseBuildingService.updateBase(museumBaseHouseInfo);
			}else{
				//插入一条新增的基础信息数据
				museumBaseHouseInfo.setFlag("1");
				museumHouseBuildingService.insertBase(museumBaseHouseInfo);
			}
			if(change){
				//校验字段有变动
				//删除所有为flag=3状态的记录
				museumHouseBuildingService.deleteBase(museumBaseHouseInfo.getMuseumId(), "3");
	            //插入一条状态为3的修改记录数据（记录最新的修改记录）
				museumBaseHouseInfo.setFlag("3");
	            museumHouseBuildingService.insertBase(museumBaseHouseInfo);
			}
			//馆舍信息列表
			if(!MyString.isEmpty(museumBaseHouseInfo.getBuildListStr())){
				JSONArray jsonArray=JSONArray.fromObject(museumBaseHouseInfo.getBuildListStr());
				List<MuseumHouseBuildingDto> houseList =(List<MuseumHouseBuildingDto>)JSONArray.toCollection(jsonArray,MuseumHouseBuildingDto.class);
				if(houseList.size()>0){
					for(MuseumHouseBuildingDto houseInfo: houseList){
						Boolean changeHouse = false;
						if(!MyString.isEmpty(houseInfo.getId())){
							String id = houseInfo.getId();
							MuseumHouseBuildingDto oldMap = museumHouseBuildingService.selectBuildingById(id);
							String[] house = {"houseName","level","ownership","floorArea"};
							changeHouse = Utils.isChanged(oldMap,houseInfo,house);
							museumHouseBuildingService.update(houseInfo);
						}else{ 
							houseInfo.setFlag("1");
							museumHouseBuildingService.insert(houseInfo);
						}
						if(changeHouse){
							//插入一条状态为3的记录
							houseInfo.setFlag("3");
							museumHouseBuildingService.insert(houseInfo);
						}
					}
				}
			}
			
            //库房信息列表
			if(!MyString.isEmpty(museumBaseHouseInfo.getWarehouseListString())){
				JSONArray jsonArray=JSONArray.fromObject(museumBaseHouseInfo.getWarehouseListString());
				List<MuseumWarehouseDto> warehouseList =(List<MuseumWarehouseDto>)JSONArray.toCollection(jsonArray,MuseumWarehouseDto.class);
				if(warehouseList.size()>0){
					for(MuseumWarehouseDto houseInfo: warehouseList){
						Boolean changeWare = false;
						if(!MyString.isEmpty(houseInfo.getId())){
							String id = houseInfo.getId();
							MuseumWarehouseDto oldMap = warehouseService.selectForm(id);
							String[] ware = {"name","houseArea","collectionNeeds","completeRack","monitor","temperature","roomLighting",
									"fireFighting","guardAgainstTheft","lightProtection","waterproof","ventilationFacility",
									"corrosionProtection","mildewResistance","airPollution","insectControl"};
							changeWare = Utils.isChanged(oldMap,houseInfo,ware);
							//通过id查询数据库里面的记录和传入的值对比
							warehouseService.update(houseInfo);
						}else{ 
							houseInfo.setFlag("1");
							warehouseService.insert(houseInfo);
						}
						if(changeWare){
							//插入一条状态为3的记录
							houseInfo.setFlag("3");
							warehouseService.insert(houseInfo);
						}
					}
				}
			}
			
			//展厅列表
			if(!MyString.isEmpty(museumBaseHouseInfo.getShowHouseList())){
				JSONArray jsonArray=JSONArray.fromObject(museumBaseHouseInfo.getShowHouseList());
				List<MuseumShowRoomDto> showList =(List<MuseumShowRoomDto>)JSONArray.toCollection(jsonArray,MuseumShowRoomDto.class);
				if(showList.size()>0){
					for(MuseumShowRoomDto houseInfo: showList){
						Boolean changeRoom = false;
						if(!MyString.isEmpty(houseInfo.getId())){
							String id = houseInfo.getId();
							MuseumShowRoomDto oldMap = showRoomService.selectForm(id);
							String[] ware = {"name","area","roomLighting","collectionProtect","monitor","fireFighting","firePrevention",
									"guardAgainstTheft","lightProtection","shockproof","waterproof"};
							changeRoom = Utils.isChanged(oldMap,houseInfo,ware);
							showRoomService.update(houseInfo);
						}else{ 
							houseInfo.setFlag("1");
							showRoomService.insert(houseInfo);
						}
						if(changeRoom){
							//插入一条状态为3的记录,修改记录
							houseInfo.setFlag("3");
							showRoomService.insert(houseInfo);
						}
					}
				}
			}
			
			MuseumDataProgressDto progressInfo = new MuseumDataProgressDto();
			progressInfo.setHousePer(isFull);
			progressInfo.setMuseumId(museumBaseHouseInfo.getMuseumId());
			progressInfo.setFlag("1");
			int count =museumBaseInfoService.updateProgress(progressInfo);
			if(count>0){
				MuseumDataProgressDto pro = museumBaseInfoService.getDetail(museumBaseHouseInfo.getMuseumId(),"1");
				MuseumDataProgressDto updateInfo = new MuseumDataProgressDto();
				updateInfo.setAllDataPer(Utils.progressIsFull(pro));
				updateInfo.setMuseumId(museumBaseHouseInfo.getMuseumId());
				updateInfo.setFlag("1");
				museumBaseInfoService.updateProgress(updateInfo);
				result = new JsonResult(1, "保存成功！");
			}else{
				result = new JsonResult(0, "保存失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult(0, "保存失败！");
		}
		return result;
	}
	
	/**
	 * 删除馆舍建筑资料
	 */
	@RequestMapping("/deleteHouse.do")
	@ResponseBody
	public JsonResult delete(String id) {
		JsonResult result = null; 
		int num = museumHouseBuildingService.deleteByLogic(id);
		if(num>0){
			result = new JsonResult(1, "删除成功！");
		}else{
			result = new JsonResult(0, "删除失败！");
		}
		return result;
	}

	/**
	 * 删除库房
	 */
	@RequestMapping("/deleteWarehouse.do")
	@ResponseBody
	public JsonResult deleteWareHouse(String id) {
		JsonResult result = null;
		int num = warehouseService.deleteByLogic(id);
		if(num>0){
			result = new JsonResult(1, "删除成功！");
		}else{
			result = new JsonResult(0, "删除失败！");
		}
		return result;
	}
	
	/**
	 * 删除展厅
	 */
	@RequestMapping("/deleteRoom.do")
	@ResponseBody
	public JsonResult deleteRoom(String id) {
		JsonResult result = null;
		int num = showRoomService.deleteByLogic(id);
		if(num>0){
			result = new JsonResult(1, "删除成功！");
		}else{
			result = new JsonResult(0, "删除失败！");
		}
		return result;
	}
  
}