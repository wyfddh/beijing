package com.design.core.dao;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.sql.Template;

import com.design.core.common.model.common.UploadFile;
import com.design.core.common.model.json.ComboTree;
import com.design.core.common.model.json.ImportFile;
import com.design.core.common.model.json.TreeGrid;

public interface ICommonDao extends IGenericBaseCommonDao{
	
	
	/**
	 * 文件上传
	 * @param request
	 * @throws Exception 
	 */
	public <T> T  uploadFile(UploadFile uploadFile) throws Exception;
	/**
	 * 文件上传或预览
	 * @param uploadFile
	 * @return
	 */
	public HttpServletResponse viewOrDownloadFile(UploadFile uploadFile);


}

