package com.tj720.mip.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tj720.mip.inter.service.table.IYearTypeService;
import com.tj720.mip.model.YearType;

@Controller("yearTypeController")
@RequestMapping("/yearType")
public class YearTypeUtil {
	
	@Autowired
	private IYearTypeService yearTypeService;
	
	String path = "";
	String pathName= "";
	
	@RequestMapping("/yearTypeSet.do")
	public void yearTypeSet(){
		
		@SuppressWarnings("unchecked")
		List<YearType> ytList = (List<YearType>) yearTypeService.queryByHql("from YearType", Tools.getMap());
		for (YearType yt : ytList) {
			path = "";
			pathName = "";
			String setPath = setPath(yt);
			setPath = setPath.substring(0,setPath.length()-1);
			String setPathName = setPathName(yt);
			setPathName = setPathName.substring(0,setPathName.length()-1);
			System.out.println(setPath);
			System.out.println(setPathName);
			yt.setPath(setPath);
			yt.setPathName(setPathName);
			yearTypeService.update(yt);
		}
	}
	
	
	public String setPath(YearType yt){
		path = yt.getId() + "," +path;
		String parentId = yt.getParentId(); 
		if ("2".equals(parentId)) {
			return path;
		}
		if (!"0".equals(parentId)) {
			YearType yearType = yearTypeService.get(parentId);
			setPath(yearType);
		}
		return path;
	
	}
	
	
	public String setPathName(YearType yt){
		pathName = yt.getName() + "." + pathName;
		String parentId = yt.getParentId(); 
		if ("0".equals(parentId)) {
			return pathName;
		}
		if (!"2".equals(parentId)) {
			YearType yearType = yearTypeService.get(parentId);
			setPathName(yearType);
		}
		return pathName;
	
	}

}
