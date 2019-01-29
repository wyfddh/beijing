package com.tj720.mip.controller.threeDim;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.framework.MyException;
import com.tj720.mip.model.ThreeDimDesk;
import com.tj720.mip.model.ThreeDimItem;
import com.tj720.mip.service.table.ThreeDimDeskService;
import com.tj720.mip.service.table.ThreeDimItemService;

@Controller
@RequestMapping("/3d/source")
public class PageController{

	@Autowired
	private ThreeDimDeskService threeDimDeskService;
	
	@Autowired
	private ThreeDimItemService threeDimItemService;
	
	/**
	 * 通过展台类型查询符合条件的展品列表
	 * @param deskType
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/imageUpload.do")
	public String imageUpload(HttpServletRequest request) throws MyException{
		
		return "redirect:/upload/jquery-publicity20151104/index.html"; 
	}

}
