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
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.model.Picture;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.ImageThumbnailThread;
import com.tj720.mip.utils.ImageReThumbnailThread;

@Controller
@RequestMapping("/back/picture")
public class PictureController extends BaseController<Picture> {
	private ImageThumbnailThread thread=null;
	private ImageReThumbnailThread thread1=null;
	private String currentFile="";
	private int count=0;
	private int testcount=0;
	private int currentIndex=0;
	private int skipCount=0;
	private int totalCount=0;
	private List<String> skiplist=new ArrayList<String>();
	private List<String> templist=new ArrayList<String>();
	private int subvalue=0;
	private String status="TERMINATED";

	@Autowired
	private IPictureService pictureService;
	@Autowired
	private Config config;

	/**
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/index.do")
	@ResponseBody
	public ModelAndView index() throws MyException {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/picture/picturelist.jsp");
		return mod;
	}
	@RequestMapping("/start.do")
	@ResponseBody
	public String start(String srcPath, String targetPath, String errorPath) throws MyException {
		if(srcPath.trim()=="")
			return "-1";
		if(targetPath.trim()=="")
			return "-2";
		if(errorPath.trim()=="")
			return "-3";
		if(MyString.isEmpty(thread)){
			thread=new ImageThumbnailThread();
			thread.scrPath=srcPath.trim();
			thread.targetPath=targetPath.trim();
			thread.errorPath=errorPath.trim();
			thread.pictureService=pictureService;
			if(config.getPlatformId()==2){
				thread.hasWaterMark=true;
				thread.waterRootPath=config.getRootPath();
			}
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
			result.put("count", Integer.valueOf(this.count).toString());
			result.put("testCount", Integer.valueOf(this.testcount).toString());
			result.put("currentIndex", Integer.valueOf(this.currentIndex).toString());
			result.put("skipCount", Integer.valueOf(this.skipCount).toString());
			result.put("totalCount", Integer.valueOf(this.totalCount).toString());
			result.put("skipfiles", this.skiplist);
			result.put("templist", this.templist);
			result.put("subvalue", this.subvalue);
			result.put("status",this.status);
		}else{
			result.put("currentFile", thread.currentFile);
			result.put("count", Integer.valueOf(thread.count).toString());
			result.put("testCount", Integer.valueOf(thread.testcount).toString());
			result.put("currentIndex", Integer.valueOf(thread.currentIndex).toString());
			result.put("skipCount", Integer.valueOf(thread.skipCount).toString());
			result.put("totalCount", Integer.valueOf(thread.totalCount).toString());
			result.put("skipfiles", thread.skiplist);
			result.put("templist", thread.templist);
			result.put("subvalue", thread.subvalue);
			result.put("status",thread.getState().toString());
			if(thread.getState()==Thread.State.TERMINATED){
				this.currentFile=thread.currentFile;
				this.count=thread.count;
				this.testcount=thread.testcount;
				this.currentIndex=thread.currentIndex;
				this.skipCount=thread.skipCount;
				this.totalCount=thread.totalCount;
				this.skiplist=thread.skiplist;
				this.templist=thread.templist;
				this.subvalue=thread.subvalue;
				this.status=thread.getState().toString();
				thread=null;
			}
		}
		return result;
	}




	/**
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/reindex.do")
	@ResponseBody
	public ModelAndView reindex() throws MyException {
		ModelAndView mod = new ModelAndView("/WEB-INF/back/picture/picturerelist.jsp");
		return mod;
	}
	@RequestMapping("/restart.do")
	@ResponseBody
	public String restart() throws MyException {
		if(MyString.isEmpty(thread1))
			thread1=new ImageReThumbnailThread();
		if(thread1.getState()==Thread.State.NEW||thread1.getState()==Thread.State.TERMINATED){
			thread1.rootPath=config.getRootPath();
			thread1.pictureService=pictureService;
			if(config.getPlatformId()==2)
				thread1.hasWaterMark=true;
			thread1.setPriority(10);
			thread1.start();
		}
		return "1";
	}
	@RequestMapping("/restatus.do")
	@ResponseBody
	public HashMap<String,String> restatus() throws MyException {
		HashMap<String,String>result=new HashMap<String,String>();
		if(!MyString.isEmpty(thread1)){
			result.put("currentFile", thread1.currentFile);
			result.put("count", new Integer(thread1.count).toString());
			result.put("currentIndex", new Integer(thread1.currentIndex).toString());
		}
		return result;
	}
}