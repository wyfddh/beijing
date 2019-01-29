package com.tj720.mip.controller.modify;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.mip.framework.MyException;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.utils.ImageModifyThread;
import com.tj720.mip.utils.MyString;

@Controller
@RequestMapping("/modify")
public class ModifyController {
	@Autowired
	private IMipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
	@Autowired
	private IPictureService pictureService;
	private ImageModifyThread thread=null;
	private String currentFile="未开始";
	private int totalcount=0;
	private int changecount=0;
	private double percentage=0.0;

	/**
	 * 修改picture表的object_id错误
	 * @throws MyException
	 */
	@RequestMapping("/objectId.do")
	@ResponseBody
	public ModelAndView getCollectionInfo() throws MyException {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/picture/objectId.jsp");
		return mod;
	}
	@RequestMapping("/start.do")
	@ResponseBody
	public String start() throws MyException {
		if(MyString.isEmpty(thread)){
			thread=new ImageModifyThread();
			thread.mipOpenCulturalrelicInfoService=mipOpenCulturalrelicInfoService;
			thread.pictureService=pictureService;
			thread.setPriority(10);
			thread.start();
		}
		return "1";
	}
	@RequestMapping("/status.do")
	@ResponseBody
	public HashMap<String,Object> status() throws MyException {
		HashMap<String,Object>result=new HashMap<String,Object>();
		if(MyString.isEmpty(thread)){
			result.put("currentFile", this.currentFile);
			result.put("totalcount", Integer.valueOf(this.totalcount).toString());
			result.put("changecount", Integer.valueOf(this.changecount).toString());
			result.put("percentage", Double.valueOf(this.percentage).toString());
		}else{
			result.put("currentFile", thread.currentFile);
			result.put("totalcount", Integer.valueOf(thread.totalcount).toString());
			result.put("changecount", Integer.valueOf(thread.changecount).toString());
			result.put("percentage", Double.valueOf(thread.percentage).toString());
			if(thread.getState()==Thread.State.TERMINATED){
				this.currentFile="已完成";
				this.totalcount=thread.totalcount;
				this.changecount=thread.changecount;
				this.percentage=thread.percentage;
				thread=null;
			}
		}
		return result;
	}
}
