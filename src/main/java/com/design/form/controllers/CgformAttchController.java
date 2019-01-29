package com.design.form.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.design.core.common.hibernate.qbc.CriteriaQuery;
import com.design.core.common.model.common.UploadFile;
import com.design.core.common.model.json.AjaxJson;
import com.design.core.system.service.SystemService;
import com.design.entity.CgformAttachment;
import com.design.utils.DateUtils;
import com.design.utils.FileUtils;
import com.design.utils.MyBeanUtils;
import com.design.utils.ResourceUtil;
import com.design.utils.StringUtil;
import com.design.utils.oConvertUtils;
import com.tj720.mip.utils.FtpUtil;

/**
 * @Title: Controller
 * @Description: 附件管理
 * @author onlineGenerator
 * @date 2014-08-30 10:54:41
 * @version V1.0
 * 
 */
@Controller
@RequestMapping("/cgformAttchController")
public class CgformAttchController {

	private String prefix = ResourceUtil.getConfigByName("viewResolver.prefix");
	private String suffix = ResourceUtil.getConfigByName("viewResolver.suffix");
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CgformAttchController.class);

	@Autowired
	private SystemService systemService;

	/**
	 * 保存文件
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "mySaveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson mySaveFiles(HttpServletRequest request, HttpServletResponse response, CgformAttachment achment)
			throws Exception {

		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID

		if (StringUtil.isNotEmpty(fileKey)) {
			achment.setId(fileKey);
			achment = systemService.getEntity(CgformAttachment.class, fileKey);
		}

		UploadFile uploadFile = new UploadFile(request, achment);
		String businessKey = oConvertUtils.getString(achment.getBusinessKey());
		String detailid = oConvertUtils.getString(achment.getDetailid());
		uploadFile.setCusPath("files/18/temp0000001");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setAttchtype("myFile");
		uploadFile.setByteField(null);// 不存二进制内容
		String basePath = ResourceUtil.getConfigByName("STREAM_FILE_REPOSITORY");
		achment = (CgformAttachment) systemService.uploadFile(uploadFile, basePath);
		if (achment.getAttachmenttitle().length() > 130) {
			j.setMsg("附件名称过长");
			return j;
		}
		if (StringUtil.check(achment.getAttachmenttitle())) {
			j.setMsg("附件名称含有特殊字符");
			return j;
		}
		attributes.put("fileKey", achment.getId());
		attributes.put("infotypename", achment.getInfotypename());
		attributes.put("attachmenttitle", achment.getAttachmenttitle());
		attributes.put("viewhref", "commonController.do?openViewFile&fileid=" + achment.getId());
		attributes.put("downurl", "commonController.do?viewFile&fileid=" + achment.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + achment.getId());
		j.setMsg("文件添加成功");
		j.setAttributes(attributes);

		return j;
	}

	/**
	 * 删除文档
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "delFile")
	@ResponseBody
	public AjaxJson delFile(HttpServletRequest request) throws Exception {
		AjaxJson j = new AjaxJson();
		String message = "";
		String id = request.getParameter("id");
		CgformAttachment file = systemService.getEntity(CgformAttachment.class, id);
		if(file != null) {
			message = "" + file.getAttachmenttitle() + "被删除成功";
			systemService.delete(file);
		}
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}

	/**
	 * 修改文件所属附件类型(拖拽操作)
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "updateFileType")
	@ResponseBody
	public AjaxJson updateFileType(HttpServletRequest request, CgformAttachment attachment) {
		AjaxJson j = new AjaxJson();
		j.setSuccess(true);
		String message = "";
		String id = attachment.getId();
		try {
			CgformAttachment file = systemService.getEntity(CgformAttachment.class, id);
			if (file != null) {
				file.setInfotypeid(attachment.getInfotypeid());
				systemService.saveOrUpdate(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
			message = "修改附件类型失败";
		}
		j.setMsg(message);
		return j;
	}

	// private String infotypeid;// 业务类型
	// private String attchtype;// 业务类型

	/**
	 * 保存文件
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "moveBigFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson moveBigFiles(HttpServletRequest request, HttpServletResponse response, CgformAttachment achment)
			throws Exception {
		AjaxJson j = new AjaxJson();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID

		String uploadFilePath = oConvertUtils.getString(request.getParameter("uploadFilePath"));// 已经上传到服务器的文件
		String attachmentcontent = oConvertUtils.getString(request.getParameter("attachmentcontent"));//

		if (StringUtil.isNotEmpty(fileKey)) {
			achment.setId(fileKey);
			achment = systemService.getEntity(CgformAttachment.class, fileKey);
		}
		String businessKey = oConvertUtils.getString(achment.getBusinessKey());
		String detailid = oConvertUtils.getString(achment.getDetailid());
		String infotypeid = oConvertUtils.getString(achment.getInfotypeid());
		String[] uploadFilePaths = uploadFilePath.split("\\|");

		String basePath = ResourceUtil.getConfigByName("FILL_STORE_PATH");
		String realDec = basePath + "/";
		/*
		 * String realDec = request.getSession().getServletContext() .getRealPath("/");
		 */
		String uploadbasepath = ResourceUtil.getConfigByName("uploadpath");
		for (int i = 0; i < uploadFilePaths.length; i++) {
			String bigFilePath = uploadFilePaths[i];
			String inputFile = realDec + "upload/" + bigFilePath;
			String targetFilePath = "";
			if (!"".equals(businessKey)) {
				targetFilePath = "upload/files/" + achment.getAttchtype() + "/" + businessKey + "/" + detailid;
			} else {
				targetFilePath = "upload/files/" + achment.getAttchtype() + "/temp0000001";
			}
			String outputFolder = realDec + targetFilePath;
			// /转移文件
			try {
				FileUtils.makeDir(realDec, targetFilePath);
				FileUtils.copyFileToFolder(inputFile, outputFolder);
				File file = new File(inputFile);
				CgformAttachment achment1 = new CgformAttachment();

				MyBeanUtils.copyBeanNotNull2Bean(achment, achment1);
				achment1.setAttachmenttitle(file.getName());
				File targetfile = new File(outputFolder + "/" + file.getName());
				String extend = FileUtils.getExtend(file.getName());// 获取文件扩展名
				achment1.setExtend(extend);
				String noextfilename = DateUtils.getDataString(DateUtils.yyyymmddhhmmss) + StringUtil.random(8);// 自定义文件名称
				String myfilename = noextfilename + "." + extend;// 自定义文件名称

				// String filename=targetfile.getAbsolutePath();
				// if(filename.indexOf(".")>=0)
				// {
				// filename = filename.substring(0,filename.lastIndexOf("."));
				// }
				targetfile.renameTo(new File(outputFolder + "/" + myfilename)); // 改名
				achment1.setRealpath(targetFilePath + "/" + myfilename);

				// tBCommAttchService.saveOrUpdate(achment1);
				Map<String, Object> attributes = new HashMap<String, Object>();
				attributes.put("fileKey", achment1.getId());
				attributes.put("attachmenttitle", achment1.getAttachmenttitle());
				attributes.put("viewhref", "commonController.do?openViewFile&fileid=" + achment1.getId());
				attributes.put("downurl", "commonController.do?viewFile&fileid=" + achment1.getId());
				attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + achment1.getId());
				list.add(attributes);

				file.delete();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// uploadFile.setSwfpath("swfpath");
		// uploadFile.setByteField(null);// 不存二进制内容
		// achment = systemService.uploadFile(uploadFile);

		j.setMsg("文件添加成功");
		j.setObj(list);

		return j;
	}

	@RequestMapping(params = "downloadFile")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileid = oConvertUtils.getString(request.getParameter("fileid"));
		CgformAttachment fileobj = systemService.getEntity(CgformAttachment.class, fileid);
		UploadFile uploadFile = new UploadFile(request, response);
		uploadFile.setExtend(fileobj.getExtend());
		uploadFile.setTitleField(fileobj.getAttachmenttitle());
		uploadFile.setRealPath(fileobj.getRealpath());

//		String basePath = ResourceUtil.getConfigByName("STREAM_FILE_REPOSITORY");
		//2018年8月23日18:05:27-caiming：上传到ftp
		Properties pro = new Properties();
		try {
			String realpath = request.getRealPath("/WEB-INF/classes");
			// 读取配置文件
			FileInputStream in = new FileInputStream(realpath + "/config.properties");
			pro.load(new InputStreamReader(in, "UTF-8"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		String basePath = pro.getProperty("ftp.rootPath") + pro.getProperty("web.rootPath");
		FtpUtil ftpUtil = new FtpUtil(pro.getProperty("ftp.url"), Integer.parseInt(pro.getProperty("ftp.port")),
				pro.getProperty("ftp.userName"), pro.getProperty("ftp.passWord"));
		// uploadFile.setView(true);
		systemService.viewOrDownloadFile(basePath, uploadFile, ftpUtil);
	}

	@RequestMapping(params = "uploadFile")
	public ModelAndView uploadFile(HttpServletRequest request) {
		String designId = oConvertUtils.getString(request.getParameter("designId"), "");
		request.setAttribute("designId", designId);
		return new ModelAndView(prefix + "pagegen/uploadFilePage" + suffix);
	}

	@RequestMapping(params = "uploadBigFile_new")
	public ModelAndView uploadBigFile_new(HttpServletRequest request) {
		String designId = oConvertUtils.getString(request.getParameter("designId"), "");
		String typecode = oConvertUtils.getString(request.getParameter("typecode"), "");
		request.setAttribute("typecode", typecode);
		request.setAttribute("designId", designId);
		return new ModelAndView(prefix + "pagegen/uploadBigFilePage" + suffix);
	}

	/**
	 * 单个文件上传完毕执行此方法---新
	 * 
	 * @param request
	 * @param response
	 * @param achment
	 * @return
	 */
	@RequestMapping(params = "BigonComplete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson BigonComplete(HttpServletRequest request, HttpServletResponse response, CgformAttachment achment) {
		AjaxJson j = new AjaxJson();
		String typecode = oConvertUtils.getString(request.getParameter("typecode"), "");
		String picName = oConvertUtils.getString(request.getParameter("picName"), "");
		String fileCode = oConvertUtils.getString(request.getParameter("fileCode"), "");// 文件ID

		String fileName = oConvertUtils.getString(request.getParameter("fileName"), "");//
		String detailId = oConvertUtils.getString(request.getParameter("detailId"), "");
		String mainId = oConvertUtils.getString(request.getParameter("mainId"), "");
		String val = ResourceUtil.getConfigByName("STREAM_FILE_REPOSITORY");
		CgformAttachment achment1 = new CgformAttachment();

		try {
			Properties pro = new Properties();
			String realpath = request.getRealPath("/WEB-INF/classes");
			// 读取配置文件
			FileInputStream in = new FileInputStream(realpath + "/config.properties");
			pro.load(new InputStreamReader(in, "UTF-8"));

			File file = new File(val);
			if (file.exists()) {
				// 当文件已经保存完毕后，将文件上传到ftp
				String currentFilePath = val + File.separator + fileCode;
				String ftpPath = pro.getProperty("web.rootPath") + fileCode;
				ftpPath = ftpPath.replace("\\", "/");
				int last = ftpPath.lastIndexOf("/");
				String rootPath = ftpPath.substring(0, last);
				String fileName1 = ftpPath.substring(last + 1);
				FtpUtil ftpUtil = new FtpUtil(pro.getProperty("ftp.url"), Integer.parseInt(pro.getProperty("ftp.port")),
						pro.getProperty("ftp.userName"), pro.getProperty("ftp.passWord"));
				InputStream fileIs = new FileInputStream(currentFilePath);
				boolean uploadFtpFile = ftpUtil.uploadFtpFile(rootPath, fileName1, fileIs);
				if (uploadFtpFile) {
					if (StringUtil.isNotEmpty(typecode)) {
						achment1.setInfotypeid(typecode);
					}
					if (StringUtil.isNotEmpty(picName)) {
						achment1.setInfotypename(picName);
					}
					achment1.setBusinessKey(mainId);
					achment1.setExtend(FileUtils.getExtend(fileCode));
					achment1.setDetailid(detailId);
					achment1.setAttachmenttitle(fileName);
					achment1.setRealpath(fileCode);
					systemService.saveOrUpdate(achment1);
					j.setMsg("文件保存成功！");
					j.setObj(achment1);
				} else {
					j.setObj("0");
					j.setMsg("文件保存失败！");
				}
			} else {
				j.setObj("0");
				j.setMsg("文件保存失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return j;
	}

	public void fileChannelCopy(File s, File t) {

		FileInputStream fi = null;
		FileOutputStream fo = null;
		FileChannel in = null;
		FileChannel out = null;
		try {
			if (!t.exists()) {
				if (!t.getParentFile().exists()) {// 判断目标文件所在的目录是否存在
					// 如果目标文件所在的文件夹不存在，则创建父文件夹
					t.getParentFile().mkdirs();
				}
				t.createNewFile();
			}
			fi = new FileInputStream(s);
			fo = new FileOutputStream(t);
			in = fi.getChannel();// 得到对应的文件通道
			out = fo.getChannel();// 得到对应的文件通道
			in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fi.close();
				in.close();
				fo.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(params = "delObjFile")
	@ResponseBody
	public AjaxJson delObjFile(HttpServletRequest request) throws IOException {
		AjaxJson j = new AjaxJson();
		String user = (String) request.getSession().getAttribute("");
		String val = ResourceUtil.getConfigByName("STREAM_FILE_REPOSITORY");
		String dir = val + "/" + user + "/" + "temp";

		FileUtils.delete(dir);
		return j;
	}

	public static void getAllFileName(String path, ArrayList<String> fileName) {
		File file = new File(path);
		File[] files = file.listFiles();
		String[] names = file.list();
		if (names != null)
			fileName.addAll(Arrays.asList(names));
		for (File a : files) {
			if (a.isDirectory()) {
				getAllFileName(a.getAbsolutePath(), fileName);
			}
		}
	}

	@RequestMapping(params = "getAllFileByMainId")
	@ResponseBody
	public AjaxJson getAllFileByMainId(HttpServletRequest request) {

		String businesskey = oConvertUtils.getString(request.getParameter("businesskey"), "");
		String detailid = oConvertUtils.getString(request.getParameter("detailid"), "");
		String fType = oConvertUtils.getString(request.getParameter("fType"), "");
		String attchCode = "";
		String picType = oConvertUtils.getString(request.getParameter("picType"), "");
		String bussCode = oConvertUtils.getString(request.getParameter("bussCode"), "");

		AjaxJson j = new AjaxJson();

		if (StringUtil.isEmpty(businesskey) && StringUtil.isEmpty(detailid)) {
			j.setObj("0");
			j.setSuccess(false);
			return j;
		}

		CriteriaQuery cq2 = new CriteriaQuery(CgformAttachment.class);
		if (StringUtil.isNotEmpty(businesskey)) {
			cq2.eq("businessKey", businesskey);
		}
		if (StringUtil.isNotEmpty(attchCode)) {
			cq2.eq("attchtype", attchCode);
		}
		if (StringUtil.isNotEmpty(detailid)) {
			cq2.eq("detailid", detailid);
		}
		if (StringUtil.isNotEmpty(picType)) {
			cq2.eq("infotypeid", picType);
		}
		cq2.add();
		List<CgformAttachment> TSAttacList = systemService.getListByCriteriaQuery(cq2, false);
		if (TSAttacList != null && TSAttacList.size() > 0) {
			j.setObj(TSAttacList);
			j.setSuccess(true);
		} else {
			j.setObj("0");
			j.setSuccess(false);
		}
		return j;
	}

	@RequestMapping(params = "showImg")
	@ResponseBody
	public void showImg(HttpServletRequest request, HttpServletResponse response) {
		String picFilePath = "";
		String basePath = ResourceUtil.getConfigByName("STREAM_FILE_REPOSITORY");

		String businesskey = oConvertUtils.getString(request.getParameter("businesskey"), "");
		String detailid = oConvertUtils.getString(request.getParameter("detailid"), "");
		String attchCode = "";
		String picType = oConvertUtils.getString(request.getParameter("picType"), "");
		String fileId = oConvertUtils.getString(request.getParameter("fileId"), "");

		String bussCode = oConvertUtils.getString(request.getParameter("bussCode"), "");
		// TBCulConfigformEntity tBCulConfigform = systemService
		// .findUniqueByProperty(TBCulConfigformEntity.class, "busCode",
		// bussCode);
		// if(tBCulConfigform!=null){
		// if(StringUtil.isNotEmpty(tBCulConfigform.getImgtypecode())){
		// TSType tSType =
		// systemService.getEntity(TSType.class,tBCulConfigform.getImgtypecode());
		// attchCode = tSType.getTypecode();
		// }
		// }
		List<Map<String, Object>> TSAttacList = null;
		String hql0 = "";
		// String hql0 = "select T.* FROM cgform_attachment t where 1=1 ";
		// if(StringUtil.isNotEmpty(businesskey)){
		// hql0+=" and businesskey='"+businesskey+"' ";
		// }
		// if(StringUtil.isNotEmpty(attchCode)){
		// hql0+=" and attchtype='"+attchCode+"' ";
		// }
		// if(StringUtil.isNotEmpty(picType)){
		// hql0+=" and infotypeid='"+picType+"' ";
		// }
		// if(StringUtil.isNotEmpty(detailid)){
		// hql0+=" and detailid='"+detailid+"' ";
		// }
		// if(StringUtil.isNotEmpty(fileId)){
		// hql0+=" and id='"+fileId+"' ";
		// }
		// hql0+=" and extend in ('jpg','bmp','png','tiff','gif') ";
		// hql0+=" order by infotypeid asc, create_date desc";
		// TSAttacList = systemService.findForJdbc(hql0);
		//
		// if(TSAttacList!=null&&TSAttacList.size()>0){
		// picFilePath=TSAttacList.get(0).get("REALPATH").toString();
		// }else{//如果没找到则查询其他的方位图片
		hql0 = "select T.* FROM cgform_attachment t  where   1=1  ";
		// if(StringUtil.isNotEmpty(businesskey)){
		// hql0+=" and businesskey='"+businesskey+"' ";
		// }
		// if(StringUtil.isNotEmpty(attchCode)){
		// hql0+=" and attchtype='"+attchCode+"' ";
		// }
		// if(StringUtil.isNotEmpty(detailid)){
		// hql0+=" and detailid='"+detailid+"' ";
		// }
		if (StringUtil.isNotEmpty(fileId)) {
			hql0 += " and id='" + fileId + "' ";
		}
		// hql0+=" and extend in ('jpg','bmp','png','tiff','gif') ";
		// hql0+=" order by infotypeid asc, create_date desc";
		TSAttacList = systemService.findForJdbc(hql0);
		if (TSAttacList != null && TSAttacList.size() > 0) {
			picFilePath = TSAttacList.get(0).get("REALPATH").toString();
		}
		// }

		String rowStr = basePath + "/" + picFilePath;
		try {
			Properties pro = new Properties();
			String realpath = request.getRealPath("/WEB-INF/classes");
			// 读取配置文件
			FileInputStream in = new FileInputStream(realpath + "/config.properties");
			pro.load(new InputStreamReader(in, "UTF-8"));
			FtpUtil ftpUtil = new FtpUtil(pro.getProperty("ftp.url"), Integer.parseInt(pro.getProperty("ftp.port")),
					pro.getProperty("ftp.userName"), pro.getProperty("ftp.passWord"));
			String ftpPath = pro.getProperty("ftp.rootPath") + pro.getProperty("web.rootPath") + "/" + picFilePath;
			ftpUtil.getFlow(ftpPath, response);
			response.setContentType("image/*"); // 设置返回的文件类型
			OutputStream outStream = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
			outStream.flush();
			outStream.close();
		} catch (Exception e) {
			return;
		}

	}

	/**
	 * 藏品共享给外部接口访问图片
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "showPic")
	@ResponseBody
	public void showPic(HttpServletRequest request, HttpServletResponse response) {
		String fileId = oConvertUtils.getString(request.getParameter("fileId"), "");

		String picFilePath = "";
		String basePath = ResourceUtil.getConfigByName("FILL_STORE_PATH");

		List<Map<String, Object>> TSAttacList = null;
		String hql0 = "select T.* FROM cgform_attachment t  where   1=1  ";

		if (StringUtil.isNotEmpty(fileId)) {
			hql0 += " and id='" + fileId + "' ";
		}
		TSAttacList = systemService.findForJdbc(hql0);

		if (TSAttacList != null && TSAttacList.size() > 0) {
			picFilePath = TSAttacList.get(0).get("REALPATH").toString();
		}
		String rowStr = basePath + "/" + picFilePath;
		try {
			Properties pro = new Properties();
			String realpath = request.getRealPath("/WEB-INF/classes");
			// 读取配置文件
			FileInputStream in = new FileInputStream(realpath + "/config.properties");
			pro.load(new InputStreamReader(in, "UTF-8"));
			FtpUtil ftpUtil = new FtpUtil(pro.getProperty("ftp.url"), Integer.parseInt(pro.getProperty("ftp.port")),
					pro.getProperty("ftp.userName"), pro.getProperty("ftp.passWord"));
			String ftpPath = pro.getProperty("web.rootPath") + "/" + picFilePath;
			ftpUtil.getFlow(ftpPath, response);
			
			response.setContentType("image/*"); // 设置返回的文件类型
			OutputStream outStream = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
			outStream.flush();
			outStream.close();
		} catch (Exception e) {
			return;
		}

	}

}
