package com.tj720.mip.service.tool;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.PickDto;
import com.tj720.mip.enumeration.ProjectType;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.inter.service.table.IArticleService;
import com.tj720.mip.inter.service.table.IMenuService;
import com.tj720.mip.inter.service.table.IModuleService;
import com.tj720.mip.inter.service.table.IProjectService;
import com.tj720.mip.inter.service.table.IRoleService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.inter.service.tool.IPickService;
import com.tj720.mip.model.Module;
import com.tj720.mip.model.Project;
import com.tj720.mip.model.User;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;

/**
 * 下拉选着
 * @author Ehsan
 *
 */
@Service("userPickService")
public class UserPickService implements IPickService{
	@Autowired
	IMenuService menuService;
	@Autowired
	private ICacheService cacheService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IProjectService projectService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IModuleService moduleService;
	@Autowired
	private IArticleService articleService;

	@Override
	public void getPickList(List<PickDto> picks, String code, String key, LoginInfoDto user) throws MyException {
		// 需要登陆才能
				PickDto pick = null;
				List<String> projectIds = null;
				switch (code) {
					case "CATEGORY":
					int i = 0;
					List<String> categorys = (List<String>) articleService.queryByHql("select distinct category from Article where moduleId in( select id from Module where userId='" + user.getId()+"')", null);
					for (String w : categorys) {
						if (w == null)
							continue;
						i++;
						pick = new PickDto("cat_" + i, w, w);
						picks.add(pick);
					}
					return;
//					case "MYPROJECT":// 用户所有项目
//						// 普通用户，只能查看自己的模块
//						for (Project p : projectService.findByMap(Tools.getMap("userId", Tools.getUser().getId()), null, null)) {
//							pick = new PickDto(p.getId(), p.getName());
//							picks.add(pick);
//						}
//						return;
					case "MYMODULE":// 用户所有模块
						// 普通用户，只能查看自己的模块
						for (Project p : projectService.findByMap(Tools.getMap("userId", Tools.getUser().getId()), null, null)) {
							pick = new PickDto(Const.SEPARATOR, p.getName());
							picks.add(pick);
							
							for(Module m : moduleService.findByMap(Tools.getMap("projectId", p.getId()), null, null)){
								pick = new PickDto(m.getId(), m.getName());
								picks.add(pick);
							}
						}
						return;
					case "PROJECT_MODULE":
						// 普通用户，只能查看自己的项目和模块
						projectIds = projectService.getProjectIdByUid(Tools.getUser().getId());
						moduleService.getDataCenterPick(picks, projectIds , "", "", "");
						return;
					case "MODULES":
						// 查看某个项目下的模块
						if(!MyString.isEmpty(key)){
							for(Module m : moduleService.findByMap(Tools.getMap("projectId", key), null, null)){
								pick = new PickDto(m.getId(), m.getName());
								picks.add(pick);
							}
						}
						return;
					case "PROJECTTYPE":
						for (ProjectType pt : ProjectType.values()) {
							pick = new PickDto(pt.getType()+"", pt.getName());
							picks.add(pick);
						}
						return;
					case "USER":
						if(key!= null && key.length()>=4){
							if(key.indexOf("@")>0){
								for (User u : userService.findByMap(Tools.getMap("email|like", key), null, null)) {
									pick = new PickDto(u.getId(), u.getUserName());
									picks.add(pick);
								}
							}
							else{
								for (User u : userService.findByMap(Tools.getMap("userName|like", key), null, null)) {
									pick = new PickDto(u.getId(), u.getUserName());
									picks.add(pick);
								}
							}
						}else{
							pick = new PickDto(Const.SEPARATOR, "输入的搜索长度必须大于3");
							picks.add(pick);
						}
				}
			}

}
