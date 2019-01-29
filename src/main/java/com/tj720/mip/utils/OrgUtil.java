package com.tj720.mip.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.tj720.admin.model.MipMenu;
import com.tj720.admin.model.MipOrganization;
import com.tj720.mip.dto.UserDto;

public class OrgUtil {

	
	/***
	 * 
	 * @param orgList 所有组织集合
	 * @param id      当前组织ID
	 * @param type   true返回集合包含当前组织，false不包含
	 * @return 返回当前组织及其所有下级的组织集合
	 */
	public static List<MipOrganization> getSonOrg(List<MipOrganization> orgList,Integer id,Boolean type) {
		List<MipOrganization> sonOrgList = new ArrayList<MipOrganization>();
		List<Integer> ids = new ArrayList<Integer>();
		MipOrganization org = null ;
		Iterator<MipOrganization> iter = orgList.iterator();
		while(iter.hasNext()){
			MipOrganization mipOrg = iter.next();
			if (mipOrg.getId().equals(id)) {
				org = mipOrg;
			}
			if(mipOrg.getParentId()!=null){
				if(mipOrg.getParentId().equals(id)) {
					sonOrgList.add(mipOrg);
					ids.add(mipOrg.getId());
					iter.remove();
				}
			}
			
		}
		List<MipOrganization> recursion = recursion(orgList,ids,sonOrgList);
		if (type) {
			recursion.add(org);
		}
		
		return recursion;
	}
	//递归方法查询该层组织及其存在的下级所有组织
	public static List<MipOrganization> recursion(List<MipOrganization> orgList,List<Integer> ids,List<MipOrganization> sonOrgList) {
		if (ids.size() > 0) {
			List<Integer> newIds = new ArrayList<Integer>();

			Iterator<MipOrganization> iter = orgList.iterator();
			while(iter.hasNext()){
				MipOrganization mipOrg = iter.next();
				for (Integer id : ids) {
					if(mipOrg.getParentId()!=null){
						if (mipOrg.getParentId().equals(id)) {
							sonOrgList.add(mipOrg);
							newIds.add(id);
							iter.remove();
						}
					}
				}
			}

			return recursion(orgList,newIds,sonOrgList);
		} else {
			return sonOrgList;
		}
	}
	/**
	 * 
	 * @param orgList 所有组织集合
	 * @param id      当前组织ID
	 * @param type    true返回集合包含当前组织，false不包含
	 * @return        返回当前组织平级及其所有上级的组织集合
	 */
	public static List<MipOrganization> getParentOrg(List<MipOrganization> orgList,Integer id,Boolean type) {
		
		List<MipOrganization> sonOrg = getSonOrg(orgList,id,type);
		Iterator<MipOrganization> iter = orgList.iterator();
		while(iter.hasNext()){
			MipOrganization mipOrg = iter.next();
			for (MipOrganization mipOrganization : sonOrg) {
				if (mipOrg.getId().equals(mipOrganization.getId())) {
					iter.remove();
				}
			}
			if (!type) {
				if (mipOrg.getId().equals(id)) {
					iter.remove();
				}
			}
		}
		return orgList;
	}
	/**
	 * 获得当前用户当前页面的按钮权限
	 * @param url 页面请求路径
	 * @param request
	 * @return
	 */
	public static Map<String,Integer> getBtnList(String url,HttpServletRequest request) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto)session.getAttribute("user");
		List<MipMenu> sonMenus = userDto.getSonMenus();
		List<MipMenu> btnsByRoles = userDto.getBtnsByRoles();
		for (MipMenu sonMenu : sonMenus) {
			if (sonMenu.getMenuurl().equals(url)) {
				for (MipMenu btnMenu : btnsByRoles) {
					 if (btnMenu.getParentid().equals(sonMenu.getId())) {
						 if (StringUtils.isNotBlank(btnMenu.getRoleids())) {
							 map.put(btnMenu.getRoleids(), 1);
						 }
					 }
				}
			}
		}
		return map;
	}
}
