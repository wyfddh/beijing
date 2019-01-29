package com.baidu.ueditor.upload;

import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.AppInfo;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;
import com.tj720.mip.utils.FtpUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class BinaryUploader {

	public static final State save(HttpServletRequest request,
			Map<String, Object> conf) {
		FileItemStream fileStream = null;
		boolean isAjaxUpload = request.getHeader( "X_Requested_With" ) != null;

		if (!ServletFileUpload.isMultipartContent(request)) {
			return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
		}

		ServletFileUpload upload = new ServletFileUpload(
				new DiskFileItemFactory());

        if ( isAjaxUpload ) {
            upload.setHeaderEncoding( "UTF-8" );
        }

		try {
			FileItemIterator iterator = upload.getItemIterator(request);

			while (iterator.hasNext()) {
				fileStream = iterator.next();

				if (!fileStream.isFormField())
					break;
				fileStream = null;
			}

			if (fileStream == null) {
				return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
			}

			String savePath = (String) conf.get("savePath");
			String originFileName = fileStream.getName();
			String suffix = FileType.getSuffixByFilename(originFileName);

			originFileName = originFileName.substring(0,
					originFileName.length() - suffix.length());
			savePath = savePath + suffix;

			long maxSize = ((Long) conf.get("maxSize")).longValue();

			if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
				return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
			}

			savePath = PathFormat.parse(savePath, originFileName);

			int lastIndexOf = savePath.lastIndexOf("/");
			String substring = savePath.substring(1, lastIndexOf);
			String imageName = savePath.substring(lastIndexOf + 1);
			
			Properties pro = new Properties();
		 	String realpath = request.getRealPath("/WEB-INF/classes"); 
	 		//读取配置文件
	 		FileInputStream in = new FileInputStream(realpath+"/config.properties"); 
	 		pro.load(new InputStreamReader(in, "UTF-8")); 

			conf.put("rootPath", pro.getProperty("web.rootPath"));
			
			String tempPath =System.getProperty("java.io.tmpdir")+File.separator;
			
//			String physicalPath = (String) conf.get("rootPath") + savePath;
			String physicalPath = tempPath + savePath;
			if (!new File(tempPath + substring).exists()) {
				new File(tempPath + substring).mkdirs();
			}
			InputStream is = fileStream.openStream();
			State storageState = StorageManager.saveFileByInputStream(is,
					physicalPath, maxSize);
			is.close();
			
			File targetFile = new File(tempPath + substring, imageName);
			FtpUtil ftpUtil = new FtpUtil(pro.getProperty("ftp.url"), Integer.valueOf(pro.getProperty("ftp.port")), pro.getProperty("ftp.userName"), pro.getProperty("ftp.passWord"));
			InputStream targetFileIs = new FileInputStream(targetFile);
			boolean ftpSuccess = ftpUtil.uploadFtpFile(conf.get("rootPath") + substring, imageName, targetFileIs);

			if (ftpSuccess) {
				storageState.putInfo("url", pro.getProperty("web.rootUrl") + PathFormat.format(savePath));
				storageState.putInfo("type", suffix);
				storageState.putInfo("original", originFileName + suffix);
			}
			return storageState;
		} catch (FileUploadException e) {
			return new BaseState(false, AppInfo.PARSE_REQUEST_ERROR);
		} catch (IOException e) {
		}
		return new BaseState(false, AppInfo.IO_ERROR);
	}

	private static boolean validType(String type, String[] allowTypes) {
		List<String> list = Arrays.asList(allowTypes);

		return list.contains(type);
	}
	
	public static void main(String[] args) {
		String tempPath =System.getProperty("java.io.tmpdir")+File.separator;
		System.out.println(tempPath);
	}
}
