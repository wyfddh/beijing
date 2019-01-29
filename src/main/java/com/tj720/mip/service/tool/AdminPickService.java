package com.tj720.mip.service.tool;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.PickDto;
import com.tj720.mip.enumeration.ArticleType;
import com.tj720.mip.enumeration.DataType;
import com.tj720.mip.enumeration.FontFamilyType;
import com.tj720.mip.enumeration.MenuType;
import com.tj720.mip.enumeration.ProjectStatus;
import com.tj720.mip.enumeration.SettingType;
import com.tj720.mip.enumeration.UserType;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.inter.service.table.IArticleService;
import com.tj720.mip.inter.service.table.IMenuService;
import com.tj720.mip.inter.service.table.IProjectService;
import com.tj720.mip.inter.service.table.IRoleService;
import com.tj720.mip.inter.service.tool.IPickService;
import com.tj720.mip.model.Article;
import com.tj720.mip.model.Menu;
import com.tj720.mip.model.Project;
import com.tj720.mip.model.Role;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

/**
 * 下拉选着
 * @author Ehsan
 *
 */
@Service("adminPickService")
public class AdminPickService implements IPickService{
	@Autowired
	IMenuService menuService;
	@Autowired
	private IProjectService projectService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IArticleService articleService;

	@Override
	public void getPickList(List<PickDto> picks, String code, String key, LoginInfoDto user) throws MyException {
		PickDto pick = null;
		String preUrl = "";
		List<Byte> statusList = new ArrayList<Byte>();
		switch (code) {
		case "CATEGORY":
			int i = 0;
			@SuppressWarnings("unchecked")
			List<String> categorys = (List<String>) articleService.queryByHql("select distinct category from Article where moduleId='web' "
					+ "or moduleId in( select id from Module where userId='" + user.getId()+"')", null);
			for (String w : categorys) {
				if (w == null)
					continue;
				i++;
				pick = new PickDto("cat_" + i, w, w);
				picks.add(pick);
			}
			return;
			
//		case "MYPROJECT":
//			for (Project p : projectService.findByMap(null, null, null)) {
//				pick = new PickDto(p.getId(), p.getName());
//				picks.add(pick);
//			}
//			return;
		case "PROJECT":
			for (Project p : projectService.findByMap(null, null, null)) {
				pick = new PickDto(p.getId(), p.getName());
				picks.add(pick);
			}
			return;
		case "PROJECTSTATUE":// 管理员项目、推荐项目...
			for (ProjectStatus ps : ProjectStatus.values()) {
				pick = new PickDto(ps.name(), ps.getStatus()+"", ps.getName());
				picks.add(pick);
			}
			return;
		// 一级菜单
		case "MENU":
			for (Menu m : menuService.findByMap(Tools.getMap("parentId", "0"), null, null)) {
				pick = new PickDto(m.getId(), m.getMenuName());
				picks.add(pick);
			}
			return;
			
		// 权限
		case "AUTH":
			// 分割线
			pick = new PickDto(Const.SEPARATOR, "用户、菜单、角色、系统设置管理");
			picks.add(pick);
			pick = new PickDto(DataType.USER.name(), "用户管理");
			picks.add(pick);
			pick = new PickDto(DataType.ROLE.name(), "角色管理");
			picks.add(pick);
			pick = new PickDto(DataType.MENU.name(), "菜单管理");
			picks.add(pick);
			pick = new PickDto(DataType.SETTING.name(), "系统设置管理");
			picks.add(pick);
			pick = new PickDto(ArticleType.ARTICLE.name(), "站点文章管理");
			picks.add(pick);
			pick = new PickDto(ArticleType.PAGE.name(), "站点页面管理");
			picks.add(pick);
			return;
		
		// 角色
		case "ROLE":
			pick = new PickDto(Const.SUPER, "超级管理员");
			picks.add(pick);
			for (Role r : roleService.findByMap(null, null, null)) {
				pick = new PickDto(r.getId(), r.getRoleName());
				picks.add(pick);
			}
			return;
			
		// 枚举 webPage
		case "WEBPAGETYPE":
			for (ArticleType type : ArticleType.values()) {
				pick = new PickDto(type.name(), type.getName());
				picks.add(pick);
			}
			return;
		// 枚举 菜单类型
		case "MENUTYPE":
			for (MenuType type : MenuType.values()) {
				pick = new PickDto(type.name(), type.getName());
				picks.add(pick);
			}
			return;
		
		// 枚举 设置类型
		case "SETTINGTYPE":
			for (SettingType type : SettingType.values()) {
				pick = new PickDto(type.name(), type.getName());
				picks.add(pick);
			}
			return;
		case "DATATYPE":// 枚举 数据类型
			for (DataType status : DataType.values()) {
				pick = new PickDto(status.name(), status.getName());
				picks.add(pick);
			}
			return;
		case "MODELNAME":// 数据类型
			i = 0;
			List<String> modelNames = (List<String>) articleService.queryByHql("select distinct modelName from Log", null);
			for (String w : modelNames) {
				if (w == null)
					continue;
				i++;
				pick = new PickDto("modelName_" + i, w, w);
				picks.add(pick);
			}
			return;
		
		case "MENURUL":
				// 分割线
				pick = new PickDto(Const.SEPARATOR, "项目列表");
				picks.add(pick);
				pick = new PickDto("m_myproject", "#/project/list/true/NULL", "我的项目列表");
				picks.add(pick);
				pick = new PickDto("m_myproject", "#/project/list/false/NULL", "推荐项目列表");
				picks.add(pick);
				
				pick = new PickDto(Const.SEPARATOR, "项目主页【推荐项目】");
				picks.add(pick);
				
				for (Project project : projectService.findByMap(Tools.getMap("status", ProjectStatus.RECOMMEND.getStatus()), null, null)) {
					pick = new PickDto(project.getId() , String.format(Const.FRONT_PROJECT_URL, project.getId()) , project.getName());
					picks.add(pick);
				}
				
				// 分割线
				pick = new PickDto(Const.SEPARATOR, "文章列表【站点文章】");
				picks.add(pick);
				int j = 0;
				@SuppressWarnings("unchecked")
				List<String> categorys2 = (List<String>) articleService.queryByHql("select distinct category from Article where moduleId='web'", null);
				for (String article : categorys2) {
					if (MyString.isEmpty(article))
						continue;
					j++;
					pick = new PickDto("cat_" + j, String.format(Const.FRONT_ARTICLE_URL, Const.WEB_MODULE,  Const.WEB_MODULE, article) , article);
					picks.add(pick);
				}
				
				// 分割线
				pick = new PickDto(Const.SEPARATOR, "页面【站点页面】");
				picks.add(pick);
				preUrl = "#/web/article/detail/web/PAGE/";
				for (Article w : articleService
						.findByMap(Tools.getMap("key|" + Const.NOT_NULL, Const.NOT_NULL, "type", "PAGE"), null, null)) {
					pick = new PickDto("wp_" + w.getKey(), preUrl + w.getKey(), w.getName());
					picks.add(pick);
				}
				// 分割线
				return;
				
		case "FONTFAMILY":// 字体
			for (FontFamilyType font : FontFamilyType.values()) {
				pick = new PickDto(font.name(), font.getValue(), font.getName());
				picks.add(pick);
			}
			return;
		case "USERTYPE": // 用户类型
			for (UserType type : UserType.values()) {
				pick = new PickDto("user-type"+type.getType(), type.getType()+"", type.getName());
				picks.add(pick);
			}
			return;
		}
	}

}
