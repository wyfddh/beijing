package com.tj720.mip.controller.regusermanage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;
@Controller
@RequestMapping("/regUserManage")
public class RegUserController extends BaseController<User> {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/info.do")
	@AuthPassport(authority = "contentCommon")
	public ModelAndView getUserInfo(@ModelAttribute User user,String key,String phone,String startCreateTime,
			String endCreateTime, String startLastLoginTime,String endLastLoginTime,
			@RequestParam(defaultValue = "20")int size,
			@RequestParam(defaultValue = "1", name = "page") int currentPage,
			@RequestParam(defaultValue = "createTime") String order)throws MyException{
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/content/regist_user/regUserList.jsp");
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		String hql = "from User where status <> -127";
		if (startCreateTime!= null && !"".equals(startCreateTime)) {
			if (endCreateTime != null && !"".equals(endCreateTime)) {
				hql+=" and createTime between '"+startCreateTime+"'"
						+ "and '"+endCreateTime+"'";
			} else {
				hql+=" and createTime between '"+startCreateTime+"'" 
						+ " and now()";
			}
		} else {

			if (endCreateTime != null && !"".equals(endCreateTime)) {
				hql+=" and createTime between '1970-01-01' and '"+endCreateTime+"'";
			}
		}
		
		if (phone != null && !"".equals(phone)) {
			hql +=( " and phone = '" +phone+"'");
		}
		if (key != null && !"".equals(key)) {
			hql += " and nickName like '%" + key + "%' ";
		}else {
			key="";
		}
		if (startLastLoginTime!= null && !"".equals(startLastLoginTime) ) {
			if (endLastLoginTime != null && !"".equals(endLastLoginTime) ) {
				hql+=" and lastLoginTime between '" + startLastLoginTime
						+ "' and '" + endLastLoginTime + "'";
			} else {
				hql+=" and lastLoginTime between '" + startLastLoginTime
						+ "' and now()";
			}
		} else {

			if (endLastLoginTime != null && !"".equals(endLastLoginTime) ) {
				hql+=" and lastLoginTime between '1970-01-01' and '"
						+ endLastLoginTime + "'";
			}
		}
		List<User> userList = (List<User>) userService.queryByHql(hql, Tools.getMap(),page);
		modelAndView.addObject("userList", userList);
		modelAndView.addObject("page", page);
		modelAndView.addObject("key", key);
		modelAndView.addObject("phone", phone);
		modelAndView.addObject("startCreateTime", startCreateTime);
		modelAndView.addObject("endCreateTime", endCreateTime);
		modelAndView.addObject("startLastLoginTime", startLastLoginTime);
		modelAndView.addObject("endLastLoginTime", endLastLoginTime);
		System.out.println(hql);
		return modelAndView;
		
	}
	@RequestMapping("/detail.do")
	@AuthPassport(authority = "contentCommon")
	public ModelAndView detail(@ModelAttribute User user){
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/content/regist_user/regUserDetail.jsp");
		User userInfo = userService.get(user.getId());
		modelAndView.addObject("userInfo", userInfo);
		return modelAndView;
	}
	
	//删除
	@RequestMapping("/delete.do")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public String delete(String[] ids)throws MyException{
		
		try {
			for (String id : ids) {
				// 获取对象
				User model = userService.get(id);
				// 设置状态（-127）
				model.setStatus((byte) -127);
				userService.update(model);
				
			}
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
	
	//启用
	@RequestMapping("/qiyong")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public String qiyong(String[] ids)throws MyException{
		try {
			for (String id : ids) {
				// 获取对象
				User model = userService.get(id);
				// 设置状态（-127）
				model.setStatus((byte) 1);
				userService.update(model);
				
			}
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
		
	}
	
	//禁用
	@RequestMapping("/jinyong")
	@AuthPassport(authority = "contentCommon")
	@ResponseBody
	public String jinyong(String[] ids)throws MyException{
		try {
			for (String id : ids) {
				// 获取对象
				User model = userService.get(id);
				// 设置状态（-127）
				model.setStatus((byte) 0);
				userService.update(model);
				
			}
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}							
}
