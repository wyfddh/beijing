package com.tj720.mip.controller.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.model.MipSpreadtrum;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.admin.service.MipSpreadtrumService;
import com.tj720.admin.service.SpreadtrumService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;

@Controller
@RequestMapping("m/spreadtrum")
public class MSpreadtrumController{
	@Autowired
	private MipSpreadtrumService spreadtrumService;
	@Autowired
	private UserService userService;	
	@Autowired
	private Config config;//常量的取法
	@Autowired
	SpreadtrumService spreadtrumServiceInterface;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	
	@Autowired
	private IMuseumBaseInfoService iMuseumBaseInfoService;

	@RequestMapping("/getSpreadtrumList.do")
	@ResponseBody
	public JsonResult getSpreadtrumList(String key,String area,
			@RequestParam(defaultValue="1") Integer currentPage,@RequestParam(defaultValue="15")Integer size){
		Page page= new Page(size);
		page.setCurrentPage(currentPage);
		try{
			JsonResult spreadtrumLsit = spreadtrumServiceInterface.getWebSpreadtrumList(key,area,page);
			return spreadtrumLsit;
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(0,"系统异常，请联系管理员");
		}
	}
	
	@RequestMapping("/getSpreadtrumById.do")
	@ResponseBody
	public JsonResult getSpreadtrumById(@RequestParam String id,String orgId){
		try{
			//获取数据
			HashMap<String,Object> data = new HashMap<String,Object>();
			@SuppressWarnings("unchecked")
			HashMap<String,Object> Spreadtrum = spreadtrumServiceInterface.getSpreadtrumByCondition(orgId,id);	
			data.put("Spreadtrum", Spreadtrum);
			//点击量加一
			addOnclick(id);
			return new JsonResult(1,data);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(0,"系统异常，请联系管理员");
		}
	}
	@RequestMapping("/getAreaList.do")
	@ResponseBody
	public JsonResult getAreaList(){
		try{
			//获取数据
			List<Map<String, Object>> data =  new ArrayList<Map<String,Object>>();
			data = iMuseumBaseInfoService.getAreaList();
			return new JsonResult(1,data);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(0,"系统异常，请联系管理员");
		}
	}
	
	
	//点击+1
		@RequestMapping("/addOnclick.do")
		@ResponseBody
		public void addOnclick(String id) throws MyException{
			if(!MyString.isEmpty(id)){
					if(!id.equals(Const.NULL_ID)){
						MipSpreadtrum spreadtrum = spreadtrumService.get(id);
						Long clickNumber = (long)spreadtrum.getClickNumber();
						spreadtrum.setClickNumber(++clickNumber);
						spreadtrumService.update(spreadtrum);
					}
				}
		}
		
		
}