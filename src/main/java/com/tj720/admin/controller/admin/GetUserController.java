package com.tj720.admin.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.examples.CreateCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.model.Curation;
import com.tj720.admin.model.CurationExample;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.model.MipUserExample;
import com.tj720.admin.model.MipUserExample.Criteria;
import com.tj720.admin.service.IMipUserService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/getUser")
public class GetUserController {
	
	@Autowired
	private IMipUserService mipUserService;
	@Autowired
	private UserService userService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;

	@RequestMapping("/user/userAdmin.do")
	public String getUser(@ModelAttribute MipUser mipUser,ModelMap modelMap,
			@RequestParam(defaultValue="1" ,name="page") Integer currentPage,@RequestParam(defaultValue = "10") int size,String nameType) throws ParseException{
		
		//获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User us = userService.get(userDto.getId());
		//获取用户的组织机构
		String orgId = us.getOrgId();
		MipOrganization org = mipOrganizationService.get(orgId);
		//查询组织机构的级别
		byte level = org.getLevel();
		MipUserExample example = new MipUserExample();
		//example中存入的信息当做页面回显使用 （修改后未删除）  criteria中数据当查询使用
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Criteria criteria = example.createCriteria();
		criteria.andStatusGreaterThan((byte)-1);
		criteria.andOrgIdEqualTo("0");
		if("1".equals(nameType)){
			example.setNameType("1");
		}else if("2".equals(nameType)){
			example.setNameType("2");
		}
		if(mipUser.getCreatOverTime()!=null&&!"".equals(mipUser.getCreatOverTime())){
			criteria.andCreatetimeLessThan(sdf.parse(mipUser.getCreatOverTime()));
			example.setCreatOverTime(mipUser.getCreatOverTime());
		}
		if(mipUser.getCreatStaTime()!=null&&!"".equals(mipUser.getCreatStaTime())){
			criteria.andCreatetimeGreaterThan(sdf.parse(mipUser.getCreatStaTime()));
			example.setCreatStaTime(mipUser.getCreatStaTime());
		}
		if(mipUser.getLastLongOverTime()!=null&&!"".equals(mipUser.getLastLongOverTime())){
			Date date = sdf.parse(mipUser.getLastLongOverTime());
			long time = date.getTime();
			int lastTimeE = (int) (time/1000 + 86400);
			example.setLastLongOverTime(""+lastTimeE);
			criteria.andLastLoginTimeLessThan(lastTimeE);
		}
		if(mipUser.getLastLongStaTime()!=null&&!"".equals(mipUser.getLastLongStaTime())){
			Date date = sdf.parse(mipUser.getLastLongStaTime());
			long time = date.getTime();
			int lastTimeS = (int) (time/1000);
			criteria.andLastLoginTimeGreaterThan(lastTimeS);
			example.setLastLongStaTime(""+lastTimeS);
		}
		if(mipUser.getNickName()!=null&&!"".equals(mipUser.getNickName())){
			criteria.andNickNameLike("%"+mipUser.getNickName()+"%");
			example.setNickName(mipUser.getNickName());
		}
		if(mipUser.getPhone()!=null&&!"".equals(mipUser.getPhone())){
			criteria.andPhoneLike("%"+mipUser.getPhone()+"%");
			example.setPhone(mipUser.getPhone());
		}
		List<MipUser> list = new ArrayList<MipUser>();
		int totle = mipUserService.allPage(example);
		example.setSize(size);
		example.setCurrentPage(currentPage);
		if(totle%10>0){
			example.setTotalPage(totle/size+1);
		}else{
			example.setTotalPage(totle/size);
		}
		if(currentPage>0){
			example.setStartPage((currentPage-1)*example.getSize());
//			if(currentPage*example.getSize()>totle){
//				example.setSize(totle-(currentPage-1)*example.getSize());
//			}
		}
		list = mipUserService.getUserList(example);
		example.setLastLongOverTime(mipUser.getLastLongOverTime());
		example.setLastLongStaTime(mipUser.getLastLongStaTime());
		modelMap.put("totle", totle);
		modelMap.put("userList", list);
		modelMap.put("example", example);
		modelMap.put("level", level);
		return "/WEB-INF/back/organization/user/getuser.jsp";
	}
	
	@RequestMapping("/user/delectUser.do")
	@ResponseBody
	public void delectMipUser(@ModelAttribute MipUser mipUser){
		if (!MyString.isEmpty(mipUser.getId())) {
			if (!mipUser.getId().equals(Const.NULL_ID)) {
				mipUser.setStatus((byte)-1);
				int a = mipUserService.updateStatus(mipUser);
				if(a!=1){
				}
			}
		}
	}
	
	@RequestMapping("/user/updateUserStatus.do")
	@ResponseBody
	public String updateUserStastus(@ModelAttribute MipUser mipUser){
		if (!MyString.isEmpty(mipUser.getId())) {
			if (!mipUser.getId().equals(Const.NULL_ID)) {
				if("0".equals(mipUser.getStatus())){
					mipUser.setStatus((byte)0);
				}
				if("1".equals(mipUser.getStatus())){
					mipUser.setStatus((byte)1);
				}
				
				int a = mipUserService.updateStatus(mipUser);
				if(a!=1){
					return "/WEB-INF/back/error.jsp";
				}
			}
		}
		return "success";
	}
}
