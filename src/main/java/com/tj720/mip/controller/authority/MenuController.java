package com.tj720.mip.controller.authority;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.model.MipMenu;
import com.tj720.admin.service.MipMenuService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.model.MenuNode;
import com.tj720.mip.model.MenuZtreeNode;
import com.tj720.mip.springbeans.Config;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController{

	@Autowired
	private MipMenuService mipMenuService;
	@Autowired
	private Config config;

	//去菜单列表页
	@RequestMapping("/goList.do")
	@SuppressWarnings("unchecked")
	@ControllerAop(url="menu/goList.do")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView goList() {
		ModelAndView mv = new ModelAndView("/WEB-INF/back/authority/menuList.jsp");
		List<MenuNode> allMenuNodeList = mipMenuService.getAllMenuNodeList();
		mv.addObject("menuList", JSONObject.toJSON(allMenuNodeList));
		return mv;
	}
	
	//去菜单新增页面
	@RequestMapping("/goAdd.do")
	@SuppressWarnings("unchecked")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView goAdd() {
		ModelAndView mv = new ModelAndView("/WEB-INF/back/authority/menuAdd.jsp");
		//加载上级菜单树
		List<MenuZtreeNode> allMenuZtreeList = mipMenuService.getAllMenuZtreeList("1");
		MenuZtreeNode rootMenu = new MenuZtreeNode();
		rootMenu.setId("0");
		rootMenu.setName("根菜单");
		rootMenu.setOpen(true);
		rootMenu.setpId("-1");
		rootMenu.setSequence(0);
		rootMenu.setType("1");
		allMenuZtreeList.add(rootMenu);
		mv.addObject("treeNode", JSONObject.toJSON(allMenuZtreeList));
		return mv;
	}
	
	//去菜单编辑页面
	@RequestMapping("/goEdit.do")
	@SuppressWarnings("unchecked")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView goEdit(String id) {
		ModelAndView mv = new ModelAndView("/WEB-INF/back/authority/menuEdit.jsp");
		MipMenu menu = new MipMenu();
		if(!StringUtil.isBlank(id)) {
			menu = mipMenuService.get(id);
		}
		//加载上级菜单树
		List<MenuZtreeNode> allMenuZtreeList = mipMenuService.getAllMenuZtreeList("1");
		MenuZtreeNode rootMenu = new MenuZtreeNode();
		rootMenu.setId("0");
		rootMenu.setName("根菜单");
		rootMenu.setOpen(true);
		rootMenu.setpId("-1");
		rootMenu.setSequence(0);
		rootMenu.setType("1");
		allMenuZtreeList.add(rootMenu);
		for (MenuZtreeNode menuZtreeNode : allMenuZtreeList) {
			if(menuZtreeNode.getId().equals(menu.getParentid())) {
				menuZtreeNode.setChecked(true);
				//将上级名称放入menu中
				menu.setParentname(menuZtreeNode.getName());
				break;
			}
		}
		mv.addObject("treeNode", JSONObject.toJSON(allMenuZtreeList));
		mv.addObject("menu", menu);
		return mv;
	}

	//新增菜单
	@RequestMapping("/saveInfo.do")
	@ResponseBody
	@SuppressWarnings("unchecked")
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult saveInfo(MipMenu menu) throws MyException {
		JsonResult result = null;
		try {
			if(StringUtil.isBlank(menu.getMenuname()) || StringUtil.isBlank(menu.getParentid()) || StringUtil.isBlank(menu.getType()) || StringUtil.isBlank(menu.getSequence()+"")) {
				result = new JsonResult(0, "必填字段存在空，请稍后重试");
			}else{
				menu.setCreatetime(new Date());
				menu.setStatus((byte) 1);
				if(StringUtil.isBlank(menu.getMenuurl())) {
					menu.setMenuurl("#");
				}
				String nextId = IdUtils.nextId(menu);
				menu.setId(nextId);
				menu.setRoleids(compareStr(menu.getMenuname()));
				
				mipMenuService.create(menu);
				result = new JsonResult(1, "保存成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult(0, "系统异常，请稍后重试");
		}
		return result;
	}
	
	private String compareStr(String str) {
		if (str.contains("查")) {
			return "show";
		} else if (str.contains("新") || str.contains("添加")) {
			return "add";
		} else if (str.contains("修改") || str.contains("编辑")) {
			return "edit";
		} else if (str.contains("删除")) {
			return "del";
		} else if (str.contains("置顶")) {
			return "top";
		} else if (str.contains("公开") || str.contains("发布") || str.contains("提交")){
			return "pub";
		} else if (str.contains("详情")) {
			return "detail";
		} else if (str.contains("启")) {
			return "usable";
		} else if(str.contains("配置")) {
			return "config";
		}else if(str.contains("转发")) {
			return "send";
		}else if(str.contains("导出")) {
			return "export";
		}
		return "";
	}
	
	//修改菜单
	@RequestMapping("/editInfo.do")
	@ResponseBody
	@SuppressWarnings("unchecked")
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult editInfo(MipMenu menu) throws MyException {
		JsonResult result = null;
		try {
			if(StringUtil.isBlank(menu.getMenuname()) || StringUtil.isBlank(menu.getParentid()) || StringUtil.isBlank(menu.getType()) || StringUtil.isBlank(menu.getSequence()+"")) {
				result = new JsonResult(0, "必填字段存在空，请稍后重试");
			}else{
				if(StringUtil.isBlank(menu.getMenuurl())) {
					menu.setMenuurl("#");
				}
				mipMenuService.updateBySelect(menu);
				result = new JsonResult(1, "修改成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult(0, "系统异常，请稍后重试");
		}
		return result;
	}
	
	//删除菜单
	@RequestMapping("/deleteMenu.do")
	@ResponseBody
	@SuppressWarnings("unchecked")
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult deleteMenu(String id) throws MyException {
		JsonResult result = null;
		try {
			if(StringUtil.isBlank(id)) {
				result = new JsonResult(0, "获取信息有误");
			}else{
				//查看菜单是否存在下级
				List<MipMenu> chileList = mipMenuService.getMenuListByParentId(id);
				if(ObjectUtils.isEmpty(chileList)) {
					//逻辑删除
					MipMenu menu = new MipMenu();
					menu.setId(id);
					menu.setStatus((byte) 0);
					mipMenuService.updateBySelect(menu);
					result = new JsonResult(1, "删除成功");
				}else {
					result = new JsonResult(0, "存在子级菜单，请先删除子级菜单");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult(0, "系统异常，请稍后重试");
		}
		return result;
	}
	
	//验证菜单唯一名称是否唯一
	@RequestMapping("/valiOnlyName.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult valiOnlyName(String roleids, String parentid, @RequestParam(required=false)String id) throws MyException {
		try {
			boolean checkOnlyName = mipMenuService.checkOnlyName(roleids, parentid, id);
			if(checkOnlyName) {
				return new JsonResult(1, "检验通过");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请稍后重试");
		}
		return new JsonResult(0, "名称不唯一");
	}
	
	@RequestMapping("getMenus.do")
	@ResponseBody
	@AuthPassport
	public JSONObject getMenus(){
		
		HttpSession session=request.getSession();
		
		UserDto userDto=(UserDto)session.getAttribute("user");
		if(userDto == null){
			return null;
		} else {
//			List<MipMenu> menusByRoles = userDto.getMenusByRoles();
			List<MipMenu> parentMenus = userDto.getParentMenus();
			List<MipMenu> sonMenus = userDto.getSonMenus();
			JSONObject json = new JSONObject();
			List<JSONObject> parentStr = new ArrayList<JSONObject>();
			for (MipMenu mipParentMenu : parentMenus) {
				JSONObject jsonParent = new JSONObject();
				jsonParent.put("title", mipParentMenu.getMenuname());
				if (mipParentMenu.getIconremark().equals("")) {
					jsonParent.put("icon", "layui-icon layui-icon-template-1");
				} else {
					jsonParent.put("icon", mipParentMenu.getIconremark());
				}
				if (mipParentMenu.getMenuurl().equals("#")) {
					jsonParent.put("href","");
				} else {
					jsonParent.put("href", mipParentMenu.getMenuurl());
				}
				jsonParent.put("spread", false);
				List<JSONObject> sonStr = new ArrayList<JSONObject>();
				for (MipMenu mipSonMenu : sonMenus) {
					if (mipParentMenu.getId().equals(mipSonMenu.getParentid())) {
						JSONObject jsonSon = new JSONObject();
						jsonSon.put("title", mipSonMenu.getMenuname());
						if ("".equals(mipSonMenu.getIconremark())) {
							jsonSon.put("icon", "layui-icon layui-icon-template-1");
						} else {
							System.out.println(mipSonMenu.getIconremark());
							jsonSon.put("icon", mipSonMenu.getIconremark());
						}
						if (mipSonMenu.getMenuurl().equals("#")) {
							jsonSon.put("href", "");
						} else {
							jsonSon.put("href", mipSonMenu.getMenuurl());
						}
						jsonSon.put("spread", false);
						if(mipSonMenu.getMenuname().indexOf("文创产品")>-1) {
							System.out.println("============================");
						}
						List<JSONObject> sonStr1 = new ArrayList<JSONObject>();
						for (MipMenu mipSonMenu1 : sonMenus) {
							if (mipSonMenu.getId().equals(mipSonMenu1.getParentid())) {
								JSONObject jsonSon1 = new JSONObject();
								jsonSon1.put("title", mipSonMenu1.getMenuname());
								if ("".equals(mipSonMenu1.getIconremark())) {
									jsonSon1.put("icon", "layui-icon layui-icon-template-1");
								} else {
									System.out.println(mipSonMenu1.getIconremark());
									jsonSon1.put("icon", mipSonMenu1.getIconremark());
								}
								if (mipSonMenu1.getMenuurl().equals("#")) {
									jsonSon1.put("href", "");
								} else {
									jsonSon1.put("href", mipSonMenu1.getMenuurl());
								}
								jsonSon1.put("spread", false);
								sonStr1.add(jsonSon1);
							}
						}
						jsonSon.put("children", sonStr1.toArray());
						sonStr.add(jsonSon);
					}
				}
				System.out.println(sonStr.toArray());
				jsonParent.put("children", sonStr.toArray());
				parentStr.add(jsonParent);
			}
			json.put("contentManagement", parentStr.toArray());
			System.out.println(((JSONObject)JSONObject.toJSON(json)).toJSONString());
			return json;
		}
	}
}
