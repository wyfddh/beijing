package com.design.core.system.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.design.core.common.model.common.UploadFile;
import com.design.core.system.service.SystemService;
import com.design.entity.CgFormLgFieldEntity;
import com.design.utils.DateUtils;
import com.design.utils.FileUtils;
import com.design.utils.PinyinUtil;
import com.design.utils.ReflectHelper;
import com.design.utils.ResourceUtil;
import com.design.utils.StreamUtils;
import com.design.utils.StringUtil;
import com.design.utils.oConvertUtils;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.FtpUtil;

@Service("systemService")
@Transactional
public class SystemServiceImpl extends CommonServiceImpl implements
		SystemService {
	
	@Autowired
	private Config config;
	
	/**
	 * 业务表要查询的字段sql  格式为表名.字段名
	* @Title: assemblyTableFieldSql
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param lgFieldList
	* @param @param bieming
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	public String assemblyTableFieldSql(List<CgFormLgFieldEntity> lgFieldList,
			String bieming) {
		try {
			//////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer ssa = new StringBuffer();
		if (lgFieldList != null && lgFieldList.size() > 0) {
			for (int iq = 0; iq < lgFieldList.size(); iq++) {
				CgFormLgFieldEntity cgFormField = lgFieldList.get(iq);
				if(!cgFormField.getShowType().startsWith("v_form")) {//不需要查虚拟字段
					String fieldName = cgFormField.getFieldName().toUpperCase();
					ssa.append(bieming + "." + fieldName + "");
					if ((lgFieldList.size() - iq) != 1) {
						ssa.append(", ");
					}
				}else{
					String fieldName = cgFormField.getFieldName().toUpperCase();
					ssa.append(" '' as " + fieldName + "");
					if ((lgFieldList.size() - iq) != 1) {
						ssa.append(", ");
					}
				}
			}
		}

		return ssa.toString();
	}
	
	/**
	 * 文件上传
	 * 
	 * @param request
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Object uploadFile(UploadFile uploadFile, String basePath) throws Exception {
		Object object = uploadFile.getObject();
		if (uploadFile.getFileKey() != null) {
			updateEntitie(object);
		} else {
			try {
				// /设置大小
				// DiskFileItemFactory factory = new DiskFileItemFactory();
				// ServletFileUpload upload = new ServletFileUpload(factory);
				// upload.setFileSizeMax(504857600);

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
				// String realPath =
				// uploadFile.getMultipartRequest().getSession()
				// .getServletContext().getRealPath("/")
				// + "/" + path;// 文件的硬盘真实路径
				String realPath = basePath + "/" + path;// 文件的硬盘真实路径
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
					
					if (uploadFile.getAttchtype() != null) {
						reflectHelper.setMethodValue("attchtype",
								uploadFile.getAttchtype());
					}
					saveOrUpdate(object);
					// 文件拷贝到指定硬盘目录
					FileCopyUtils.copy(mf.getBytes(), savefile);
					
					//2018年8月23日18:32:06：文件上传到ftp
					int rootPathLenth = ResourceUtil.getConfigByName("STREAM_FILE_REPOSITORY").length();
					int lastIndexOf = savePath.lastIndexOf(myfilename);
					String ftpMainPath = savePath.substring(rootPathLenth, lastIndexOf);
					
					FtpUtil ftpUtil = new FtpUtil(config.getFtpUrl(), Integer.parseInt(config.getFtpPort()),
							config.getFtpUserName(), config.getFtpPassWord());
					ftpUtil.uploadFtpFile(config.getRootPath() + ftpMainPath, myfilename, new FileInputStream(savefile));
					//=================end-ftp================================
					
					
					// if (uploadFile.getSwfpath() != null) {
					// // 转SWF
					// reflectHelper.setMethodValue(uploadFile.getSwfpath(),
					// path + swfName + ".swf");
					// SwfToolsUtil.convert2SWF(savePath);
					// }
					// FileCopyUtils.copy(mf.getBytes(), savefile);
					// Date dBegin=new Date();

					if (uploadFile.getSwfpath() != null) {
						// long timeMillisStart = System.currentTimeMillis();
						// // 转SWF
						// reflectHelper.setMethodValue(uploadFile.getSwfpath(),
						// path + FileUtils.getFilePrefix(myfilename)
						// + ".swf");
						// SwfToolsUtil.convert2SWF(savePath);
						// long timeMillisEnd = System.currentTimeMillis();
						// System.out.println("转换花费时间："
						// + (timeMillisEnd - timeMillisStart));
					}

				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return object;
	}
	
	@SuppressWarnings("unchecked")
	public HttpServletResponse viewOrDownloadFile(String realPath,
			UploadFile uploadFile, FtpUtil ftpUtil) {
		uploadFile.getResponse().setContentType("UTF-8");
		uploadFile.getResponse().setCharacterEncoding("UTF-8");
		InputStream bis = null;
		BufferedOutputStream bos = null;
		HttpServletResponse response = uploadFile.getResponse();
		// HttpServletRequest request = uploadFile.getRequest();
		// String ctxPath = request.getSession().getServletContext()
		// .getRealPath("/");
		String downLoadPath = "";
//		long fileLength = 0;
		if (uploadFile.getRealPath() != null && uploadFile.getContent() == null) {
			String RealPath = uploadFile.getRealPath();
			char firstChar = RealPath.charAt(0);
			String ftpPath = "";
			if (firstChar == '/') {
				downLoadPath = realPath + uploadFile.getRealPath();
			} else {
				downLoadPath = realPath + "/" + uploadFile.getRealPath();
			}
//			fileLength = new File(downLoadPath).length();
			/*try {
				bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}*/
		} else {
			/*if (uploadFile.getContent() != null)
				bis = new ByteArrayInputStream(uploadFile.getContent());*/
//			fileLength = uploadFile.getContent().length;
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
//				response.setHeader("Content-Length", String.valueOf(fileLength));
			}
			boolean downFtpFile = ftpUtil.downFtpFile(downLoadPath, response.getOutputStream());
			/*bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}*/
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
