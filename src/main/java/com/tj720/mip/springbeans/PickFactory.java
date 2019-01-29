package com.tj720.mip.springbeans;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.PickDto;
import com.tj720.mip.enumeration.UserType;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.inter.service.tool.IPickService;
import com.tj720.mip.utils.Tools;

@Component
public class PickFactory {
	
	@Resource(name="pickService")
	private IPickService pickService;
	
	@Resource(name="adminPickService")
	private IPickService adminPickService;
	
	@Resource(name="userPickService")
	private IPickService userPickService;

	public void getPickList(List<PickDto> picks, String code, String key) throws MyException {
		
		// 1.查询管理员中是否有对应的pick
		LoginInfoDto user = Tools.getUser();
		if( user != null && user.getType() == UserType.ADMIN.getType()){
			adminPickService.getPickList(picks, code, key, user);
		}
				
		// 2.如果管理员service中没有找到对应的pick则查询用户service
		if( user != null && picks.size() == 0 ){
			userPickService.getPickList(picks, code, key, user);
		}
		
		// 3.如果用户service中没有则查找普通的pickService
		if( picks.size() == 0 ){
			pickService.getPickList(picks, code, key, null);
		}
		
	}
}