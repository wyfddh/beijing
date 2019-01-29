package com.design.core.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.sql.Template;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.design.core.common.hibernate.qbc.HqlQuery;
import com.design.core.common.hibernate.qbc.PageList;
import com.design.core.common.model.common.DBTable;
import com.design.core.common.model.common.UploadFile;
import com.design.core.common.model.json.DataGridReturn;
import com.design.core.common.model.json.ImportFile;
import com.design.core.dao.ICommonDao;
import com.design.core.dao.IGenericBaseCommonDao;
import com.design.utils.DateUtils;
import com.design.utils.FileUtils;
import com.design.utils.PinyinUtil;
import com.design.utils.ReflectHelper;
import com.design.utils.ResourceUtil;
import com.design.utils.StreamUtils;
import com.design.utils.StringUtil;
import com.design.utils.oConvertUtils;

/**
 * 公共扩展方法
 * 
 * @author XXXX
 * 
 */
@Repository
public class CommonDao extends GenericBaseCommonDao implements ICommonDao,
IGenericBaseCommonDao {


	/**
	 * 文件上传
	 * 
	 * @param request
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Object uploadFile(UploadFile uploadFile) throws Exception {
		Object object = uploadFile.getObject();
		if (uploadFile.getFileKey() != null) {
			updateEntitie(object);
		} else {
			try {
				// /设置大小
//				DiskFileItemFactory factory = new DiskFileItemFactory();
//				ServletFileUpload upload = new ServletFileUpload(factory);
//				upload.setFileSizeMax(504857600);

				uploadFile.getMultipartRequest().setCharacterEncoding("UTF-8");
				MultipartHttpServletRequest multipartRequest = uploadFile
						.getMultipartRequest();
				ReflectHelper reflectHelper = new ReflectHelper(
						uploadFile.getObject());
				String uploadbasepath = uploadFile.getBasePath();// 文件上传根目录

				if (uploadbasepath == null) {
					uploadbasepath = ResourceUtil.getConfigByName("uploadpath");
				}
				Map<String, MultipartFile> fileMap = multipartRequest
						.getFileMap();
				// 文件数据库保存路径
				String path = uploadbasepath + "/";// 文件保存在硬盘的相对路径
				String realPath = uploadFile.getMultipartRequest().getSession()
						.getServletContext().getRealPath("/")
						+ "/" + path;// 文件的硬盘真实路径
				File file = new File(realPath);
				if (!file.exists()) {
					file.mkdirs();// 创建根目录
				}
				if (uploadFile.getCusPath() != null) {
					realPath += uploadFile.getCusPath() + "/";
					path += uploadFile.getCusPath() + "/";
					file = new File(realPath);
					if (!file.exists()) {
						file.mkdirs();// 创建文件自定义子目录
					}
				} else {
					realPath += DateUtils.getDataString(DateUtils.yyyyMMdd)
							+ "/";
					path += DateUtils.getDataString(DateUtils.yyyyMMdd) + "/";
					file = new File(realPath);
					if (!file.exists()) {
						file.mkdir();// 创建文件时间子目录
					}
				}
				String entityName = uploadFile.getObject().getClass()
						.getSimpleName();
				// 设置文件上传路径
				
				if (entityName.equals("TSTemplate")) {
					realPath = uploadFile.getMultipartRequest().getSession()
							.getServletContext().getRealPath("/")
							+ ResourceUtil.getConfigByName("templatepath")
							+ "/";
					path = ResourceUtil.getConfigByName("templatepath") + "/";
				} else if (entityName.equals("TSIcon")) {
					realPath = uploadFile.getMultipartRequest().getSession()
							.getServletContext().getRealPath("/")
							+ uploadFile.getCusPath() + "/";
					path = uploadFile.getCusPath() + "/";
				}
				String fileName = "";
				String swfName = "";
				for (Map.Entry<String, MultipartFile> entity : fileMap
						.entrySet()) {
					MultipartFile mf = entity.getValue();// 获取上传文件对象
					fileName = mf.getOriginalFilename();// 获取文件名
					swfName = PinyinUtil.getPinYinHeadChar(oConvertUtils
							.replaceBlank(FileUtils.getFilePrefix(fileName)));// 取文件名首字母作为SWF文件名
					String extend = FileUtils.getExtend(fileName);// 获取文件扩展名
					String myfilename = "";
					String noextfilename = "";// 不带扩展名
					if (uploadFile.isRename()) {

						noextfilename = DateUtils
								.getDataString(DateUtils.yyyymmddhhmmss)
								+ StringUtil.random(8);// 自定义文件名称
						myfilename = noextfilename + "." + extend;// 自定义文件名称
					} else {
						myfilename = fileName;
					}

					String savePath = realPath + myfilename;// 文件保存全路径
					String fileprefixName = FileUtils.getFilePrefix(fileName);
					if (uploadFile.getTitleField() != null) {
						reflectHelper.setMethodValue(
								uploadFile.getTitleField(), fileprefixName);// 动态调用set方法给文件对象标题赋值
					}
					if (uploadFile.getExtend() != null) {
						// 动态调用 set方法给文件对象内容赋值
						reflectHelper.setMethodValue(uploadFile.getExtend(),
								extend);
					}
					if (uploadFile.getByteField() != null) {
						// 二进制文件保存在数据库中
						reflectHelper.setMethodValue(uploadFile.getByteField(),
								StreamUtils.InputStreamTOByte(mf
										.getInputStream()));
					}
					File savefile = new File(savePath);
					if (uploadFile.getRealPath() != null) {
						// 设置文件数据库的物理路径
						reflectHelper.setMethodValue(uploadFile.getRealPath(),
								path + myfilename);
					}
					saveOrUpdate(object);
					// 文件拷贝到指定硬盘目录
					FileCopyUtils.copy(mf.getBytes(), savefile);
					// if (uploadFile.getSwfpath() != null) {
					// // 转SWF
					// reflectHelper.setMethodValue(uploadFile.getSwfpath(),
					// path + swfName + ".swf");
					// SwfToolsUtil.convert2SWF(savePath);
					// }
					// FileCopyUtils.copy(mf.getBytes(), savefile);
					// Date dBegin=new Date();

					if (uploadFile.getSwfpath() != null) {
//						long timeMillisStart = System.currentTimeMillis();
//						// 转SWF
//						reflectHelper.setMethodValue(uploadFile.getSwfpath(),
//								path + FileUtils.getFilePrefix(myfilename)
//										+ ".swf");
//						SwfToolsUtil.convert2SWF(savePath);
//						long timeMillisEnd = System.currentTimeMillis();
//						System.out.println("转换花费时间："
//								+ (timeMillisEnd - timeMillisStart));
					}

				}
			} catch (Exception e1) {
			}
		}
		return object;
	}

	

	/**
	 * 文件下载或预览
	 * 
	 * @param request
	 * @throws Exception
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public HttpServletResponse viewOrDownloadFile(UploadFile uploadFile) {
		uploadFile.getResponse().setContentType("UTF-8");
		uploadFile.getResponse().setCharacterEncoding("UTF-8");
		InputStream bis = null;
		BufferedOutputStream bos = null;
		HttpServletResponse response = uploadFile.getResponse();
		HttpServletRequest request = uploadFile.getRequest();
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/");
		String downLoadPath = "";
		long fileLength = 0;
		if (uploadFile.getRealPath() != null && uploadFile.getContent() == null) {
			downLoadPath = ctxPath + uploadFile.getRealPath();
			fileLength = new File(downLoadPath).length();
			try {
				bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			if (uploadFile.getContent() != null)
				bis = new ByteArrayInputStream(uploadFile.getContent());
			fileLength = uploadFile.getContent().length;
		}
		try {
			if (!uploadFile.isView() && uploadFile.getExtend() != null) {
				if (uploadFile.getExtend().equals("text")) {
					response.setContentType("text/plain;");
				} else if (uploadFile.getExtend().equals("doc")) {
					response.setContentType("application/msword;");
				} else if (uploadFile.getExtend().equals("xls")) {
					response.setContentType("application/ms-excel;");
				} else if (uploadFile.getExtend().equals("pdf")) {
					response.setContentType("application/pdf;");
				} else if (uploadFile.getExtend().equals("jpg")
						|| uploadFile.getExtend().equals("jpeg")) {
					response.setContentType("image/jpeg;");
				} else {
					response.setContentType("application/x-msdownload;");
				}
				response.setHeader(
						"Content-disposition",
						"attachment; filename="
								+ new String(
										(uploadFile.getTitleField() + "." + uploadFile
												.getExtend()).getBytes("GBK"),
										"ISO8859-1"));
				response.setHeader("Content-Length", String.valueOf(fileLength));
			}
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public HttpServletResponse viewOrDownloadFile(String realPath,UploadFile uploadFile) {
		uploadFile.getResponse().setContentType("UTF-8");
		uploadFile.getResponse().setCharacterEncoding("UTF-8");
		InputStream bis = null;
		BufferedOutputStream bos = null;
		HttpServletResponse response = uploadFile.getResponse();
//		HttpServletRequest request = uploadFile.getRequest();
//		String ctxPath = request.getSession().getServletContext()
//				.getRealPath("/");
		String downLoadPath = "";
		long fileLength = 0;
		if (uploadFile.getRealPath() != null && uploadFile.getContent() == null) {
			downLoadPath = realPath +"\\"+ uploadFile.getRealPath();
			fileLength = new File(downLoadPath).length();
			try {
				bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			if (uploadFile.getContent() != null)
				bis = new ByteArrayInputStream(uploadFile.getContent());
			fileLength = uploadFile.getContent().length;
		}
		try {
			if (!uploadFile.isView() && uploadFile.getExtend() != null) {
				if (uploadFile.getExtend().equals("text")) {
					response.setContentType("text/plain;");
				} else if (uploadFile.getExtend().equals("doc")) {
					response.setContentType("application/msword;");
				} else if (uploadFile.getExtend().equals("xls")) {
					response.setContentType("application/ms-excel;");
				} else if (uploadFile.getExtend().equals("pdf")) {
					response.setContentType("application/pdf;");
				} else if (uploadFile.getExtend().equals("jpg")
						|| uploadFile.getExtend().equals("jpeg")) {
					response.setContentType("image/jpeg;");
				} else {
					response.setContentType("application/x-msdownload;");
				}
				response.setHeader(
						"Content-disposition",
						"attachment; filename="
								+ new String(
										(uploadFile.getTitleField() + "." + uploadFile
												.getExtend()).getBytes("GBK"),
										"ISO8859-1"));
				response.setHeader("Content-Length", String.valueOf(fileLength));
			}
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return response;
	}


}
