package com.design.core.system.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.design.core.common.model.common.UploadFile;
import com.design.entity.CgFormLgFieldEntity;
import com.tj720.mip.utils.FtpUtil;


/**
 * 
 * @author XXXX
 * 
 */
public interface SystemService extends CommonService {
	public String assemblyTableFieldSql(List<CgFormLgFieldEntity> lgFieldList,
			String bieming);
	public Object uploadFile(UploadFile uploadFile, String basePath) throws Exception;
	public HttpServletResponse viewOrDownloadFile(String realPath,
			UploadFile uploadFile, FtpUtil ftpUtil);
}
