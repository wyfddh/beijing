package com.tj720.mip.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IInterfaceService;
import com.tj720.mip.model.Interface;

@Controller
@RequestMapping("/mock")
public class MockController extends BaseController<Interface>{

	@Autowired
	private IInterfaceService interfaceService;
	
	@RequestMapping("/trueExam.do")
	@ResponseBody
	public void trueExam(@RequestParam String id) throws Exception {
		printMsg(interfaceService.get(id).getTrueExam());
	}
	
	@RequestMapping("/falseExam.do")
	@ResponseBody
	public void falseExam(@RequestParam String id) throws Exception {
		printMsg(interfaceService.get(id).getFalseExam());
	}
}
