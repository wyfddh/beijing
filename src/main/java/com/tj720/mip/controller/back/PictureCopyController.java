package com.tj720.mip.controller.back;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IMipOpenFossilInfoService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.model.Picture;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.ImageCopyThread;

@Controller
@RequestMapping("/back/pictureCopy")
public class PictureCopyController extends BaseController<Picture> {
	private ImageCopyThread thread=null;
	private String currentUrl="";
	private int currentCount=0;
	private int currentIndex=0;
	private int totalIndex=0;
	private int totalCount=0;
	private String remoteBaseRootUrl="";
	private String message="未开始";
	private String status=Thread.State.TERMINATED.toString();
	private double progress=0.0;

	@Autowired
	private IPictureService pictureService;
	@Autowired
	private IMipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
	@Autowired
	private IMipOpenFossilInfoService mipOpenFossilInfoService;
	@Autowired
	private Config config;

	/**
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/index.do")
	@ResponseBody
	public ModelAndView index() throws MyException {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/picture/pictureCopy.jsp");
		return mod;
	}
	@RequestMapping("/start.do")
	@ResponseBody
	public String start(String remoteRootUrl) throws MyException {
		if(remoteRootUrl.trim()=="")
			return "-1";
		if(MyString.isEmpty(thread)){
			thread=new ImageCopyThread();
			thread.remoteBaseRootUrl=remoteRootUrl.trim();
			thread.pictureService=pictureService;
			thread.mipOpenCulturalrelicInfoService=mipOpenCulturalrelicInfoService;
			thread.mipOpenFossilInfoService=mipOpenFossilInfoService;
			thread.config=config;
			thread.setPriority(10);
			thread.start();
		}
		return "1";
	}
	@RequestMapping("/status.do")
	@ResponseBody
	public HashMap<String,Object> status() throws MyException {
		HashMap<String,Object>result=new HashMap<String,Object>();
		if(!MyString.isEmpty(thread)&&thread.getState()==Thread.State.TERMINATED){
			this.status=Thread.State.TERMINATED.toString();
			this.message=thread.message;
			this.currentIndex=thread.currentIndex;
			this.currentCount=thread.currentCount;
			this.totalIndex=thread.totalIndex;
			this.totalCount=thread.totalCount;
			this.currentUrl=thread.currentUrl;
			this.progress=thread.progress;
			thread=null;
		}
		if(MyString.isEmpty(thread)||thread.getState()==Thread.State.TERMINATED){
			result.put("currentIndex", Integer.valueOf(this.currentIndex).toString());
			result.put("currentCount", Integer.valueOf(this.currentCount).toString());
			result.put("totalIndex", Integer.valueOf(this.totalIndex).toString());
			result.put("totalCount", Integer.valueOf(this.totalCount).toString());
			result.put("currentUrl", this.currentUrl);
			result.put("progress",Double.valueOf(this.progress));
			result.put("message", this.message);
			result.put("status",this.status);
		}else{
			result.put("status",thread.getState().toString());
			result.put("message", thread.message);
			result.put("currentIndex", Integer.valueOf(thread.currentIndex).toString());
			result.put("currentCount", Integer.valueOf(thread.currentCount).toString());
			result.put("totalIndex", Integer.valueOf(thread.totalIndex).toString());
			result.put("totalCount", Integer.valueOf(thread.totalCount).toString());
			result.put("currentUrl", thread.currentUrl);
			result.put("progress",Double.valueOf(thread.progress));
		}
		return result;
	}
}