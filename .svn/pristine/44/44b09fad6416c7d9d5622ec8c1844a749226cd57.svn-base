package com.tj720.mip.controller.front;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.ISourceService;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.model.Module;
import com.tj720.mip.model.Project;
import com.tj720.mip.model.Source;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller("frontSourceController")
@RequestMapping("/front/source")
public class SourceController extends BaseController<Source>{

	@Autowired
	private ISourceService sourceService;
	@Autowired
	private ICacheService cacheService;
	
	@RequestMapping("/detail.do")
	@ResponseBody
	public JsonResult webDetail(@ModelAttribute Source source,String password,String visitCode) throws MyException{
		Source model;
		if(!MyString.isEmpty(source.getId())){
			model = sourceService.get(source.getId());
		}else{
			throw new MyException("000020");
		}
		
		Module module = cacheService.getModule(model.getModuleId());
		Project project = cacheService.getProject(module.getProjectId());
		
		// 如果是私有项目，必须登录才能访问，公开项目需要查看是否需要密码
		isPrivateProject(password, visitCode, project);
		return new JsonResult(1,model);
	}
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult webList(@ModelAttribute Source source,@RequestParam(defaultValue="1") int currentPage,String password,String visitCode) throws MyException{
		Module module = cacheService.getModule(source.getModuleId());
		Project project = cacheService.getProject(module.getProjectId());
		
		// 如果是私有项目，必须登录才能访问，公开项目需要查看是否需要密码
		isPrivateProject(password, visitCode, project);
		
		Page page= new Page(15);
		page.setCurrentPage(currentPage);
		// 搜索条件
		Map<String,Object> map = Tools.getMap("name|like", source.getName(), "moduleId", source.getModuleId());

		
		return new JsonResult(1, sourceService.findByMap(map, " new Source(id,createTime,status,sequence,name,remark,filePath,moduleId,updateTime) ", page, null)
				, page, Tools.getMap("crumbs", Tools.getCrumbs("模块:"+module.getName(),"void")));
	}
}
