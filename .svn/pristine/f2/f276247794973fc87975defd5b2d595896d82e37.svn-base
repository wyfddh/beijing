package com.tj720.mip.controller.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMenuService;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.model.Menu;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping
public class MenuController_old extends BaseController<Menu> {
	@Autowired
	IMenuService menuService;
	@Autowired
	ICacheService cacheService;

	/**
	 * 根据父菜单、菜单名、菜单类型及页码获取菜单列表
	 * 
	 * @return
	 */
	@RequestMapping("/menu_old/list.do")
	@ResponseBody
	public JsonResult list(@ModelAttribute Menu menu, @RequestParam(defaultValue = "1") Integer currentPage) {
		Page page= new Page(15);
		page.setCurrentPage(currentPage);
		Map<String,Object> map = Tools.getMap("parentId", menu.getParentId(), "menuName|like", menu.getMenuName(), "type", menu.getType());
 		return new JsonResult(1, menuService.findByMap(map, page, null), page);
	}

	@RequestMapping("/menu_old/detail.do")
	@ResponseBody
	public JsonResult detail(@ModelAttribute Menu menu) {
		Menu model;
		if (!menu.getId().equals(Const.NULL_ID)) {
			model = menuService.get(menu.getId());
		} else {
			model = new Menu();
			model.setParentId(menu.getParentId());
			Menu parentMenu = menuService.get(menu.getParentId());
			model.setType(parentMenu.getType());
		}
		return new JsonResult(1, model);
	}

	/**
	 * 
	 * @param menu
	 * @return
	 */
	@RequestMapping("/menu_old/addOrUpdate.do")
	@ResponseBody
	public JsonResult addOrUpdate(@ModelAttribute Menu menu) {
		try {
			// 子菜单类型和父菜单类型一致
			Menu parentMenu = menuService.get(menu.getParentId());
			if (parentMenu != null && parentMenu.getId()!=null)
				menu.setType(parentMenu.getType());

			if (!MyString.isEmpty(menu.getId())) {
				menuService.update(menu);
			} else {
				menu.setId(null);
				menuService.save(menu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 清除缓存
		cacheService.delObj("cache:leftMenu");
		return new JsonResult(1, menu);
	}

	@RequestMapping("/menu_old/delete.do")
	@ResponseBody
	public JsonResult delete(@ModelAttribute Menu menu) throws MyException {
		if(menuService.getCount(Tools.getMap("parentId", menu.getId())) > 0){
			throw new MyException("000025");
		}
		menuService.delete(menu);
		// 清除缓存
		cacheService.delObj("cache:leftMenu");
		return new JsonResult(1, null);
	}

	@RequestMapping("/back/menu_old/changeSequence.do")
	@ResponseBody
	public JsonResult changeSequence(@RequestParam String id,@RequestParam String changeId) {
		Menu change = menuService.get(changeId);
		Menu model = menuService.get(id);
		int modelSequence = model.getSequence();
		
		model.setSequence(change.getSequence());
		change.setSequence(modelSequence);
		
		menuService.update(model);
		menuService.update(change);
		
		// 清除缓存
		cacheService.delObj("cache:leftMenu");
		return new JsonResult(1, null);
	}

}
