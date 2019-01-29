package com.tj720.mip.controller.admin;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tj720.admin.model.MipAttachment;
import com.tj720.admin.service.MipAttachmentService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.model.User;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.FtpUtil;

@Controller
@RequestMapping("/attach")
public class AttachmentController extends BaseController<User> {
	@Autowired
	private Config config;

	@Autowired
	private MipAttachmentService mipAttachmentService;
	
	private FtpUtil ftpUtil;

	/**
	 * 单个附件上传
	 * @param file			附件
	 * @param tableName		外键表名
	 * @param tableId		外键表id
	 * @param source		备注
	 * @param request	
	 * @return
	 */
	@RequestMapping(value = "/upload.do")
	@ResponseBody
	public JsonResult upload(@RequestParam(value = "file", required = false) CommonsMultipartFile file,
			String tableName, String tableId, String source, HttpServletRequest request) {
		JsonResult saveAttachment = mipAttachmentService.saveAttachment(file, tableName, tableId, source);
		return saveAttachment;
	}


	@RequestMapping("/uploadLegal.do")
	@ResponseBody
	public JsonResult uploadLegal(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request,String projectName) {


		JsonResult result = mipAttachmentService.uploadLegal(file,projectName);

		return result;
	}

	@RequestMapping("/cancelFile.do")
	@ResponseBody
	public JsonResult cancelFile(String resultPath) {

		String path = config.getFtpRootPath() + config.getRootPath() + resultPath;
		try {
			//以前版本：删除本地文件
//			FileUtil.delFile(path);
			//现在版本：ftp服务器
			ftpUtil = new FtpUtil(config.getFtpUrl(), Integer.valueOf(config.getFtpPort()), config.getFtpUserName(), config.getFtpPassWord());
			boolean delFtpFile = ftpUtil.delFtpFile(path);
			return new JsonResult(1);
		} catch (Exception e) {

			e.printStackTrace();
			return new JsonResult(2);
		}

	}

	@RequestMapping(value="/downFile.do")
	public void downFile(String path,String fileName,HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");//设定请求字符编码
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String downPath = config.getFtpRootPath() + config.getRootPath() + path;

		try {
			response.setContentType("application/x-msdownload;charset=utf-8");
			response.setHeader("Content-disposition", "attachment; filename=" +  URLEncoder.encode(fileName, "UTF-8"));
			ftpUtil = new FtpUtil(config.getFtpUrl(), Integer.valueOf(config.getFtpPort()), config.getFtpUserName(), config.getFtpPassWord());
			ftpUtil.downFtpFile(downPath, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 裁剪并上传图片
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/cutPicture.do")
	@ResponseBody
	public JsonResult cutPicture(@RequestParam(value = "file", required = false) CommonsMultipartFile file, HttpServletRequest request,String projectName) {
		JsonResult result = mipAttachmentService.uploadImg(file, projectName, request);
		return result;
	}
	
	@RequestMapping(value = "/deleteAttachment.do")
	@ResponseBody
	public JsonResult deleteAttachment(@RequestParam String attId){
		try {
			int result = mipAttachmentService.deleteFile(attId);
			return  new JsonResult(1,result);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(0,"删除失败");
		}

	}
	
	@RequestMapping(value = "/uploadForPost.do")
	@ResponseBody
	public JsonResult uploadForPost(@RequestParam(value = "file", required = false) CommonsMultipartFile file,
							 String tableName, String tableId, String source, HttpServletRequest request) {
		JsonResult saveAttachment = mipAttachmentService.uploadForPost(file, tableName, tableId, source);
		return saveAttachment;
	}
	
	/**
	 * 根据文件批号查询附件列表
	 * @param fkId 文件批号
	 * @return
	 */
	@RequestMapping(value = "/getAttachmentsByFkId.do")
	@ResponseBody
	public JsonResult getAttachmentsByFkId(@RequestParam String fkId){
		try {
			List<MipAttachment> attachments= mipAttachmentService.getAttachmentsByFkId(fkId);
			return  new JsonResult(1,attachments);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(0,"查询失败");
		}

	}
}
