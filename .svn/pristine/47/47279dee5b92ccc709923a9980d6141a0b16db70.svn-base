package com.tj720.admin.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.MipAttachment;
import com.tj720.mip.framework.JsonResult;


/**
 * 
 * @author cm
 * @date 2018年7月2日15:34:24
 */
public interface MipAttachmentService extends BaseService<MipAttachment>{
	/**
	 * 单个附件上传
	 * @param file
	 * @return
	 * 		errorCode:1、上传成功，0、上传失败
	 * 		msg:提示信息
	 * 		Object:当文件上传成功时，返回当前文件对象
	 */
	public JsonResult saveAttachment(CommonsMultipartFile file, String tableName, String tableid, String source);
	
	/**
	 * 单个附件上传
	 * @param files
	 * @return
	 * 		errorCode:1、上传成功，0、上传失败
	 * 		msg:提示信息
	 * 		Object:当文件上传成功时，返回当前文件对象
	 */
	public Map<String, Object> saveAttachment(List<CommonsMultipartFile> files, String tableName, String tableid, String source);

	public JsonResult uploadLegal(CommonsMultipartFile file, String projectName);
	
	public JsonResult uploadImg(CommonsMultipartFile file, String projectName, HttpServletRequest request);
	/**
	 * 保存数据库
	 * @param mipAttachment
	 */
	public void save(MipAttachment mipAttachment);

	public void update(MipAttachment mipAttachment);
	
	/**
	 * 批量保存到数据库
	 * @param attachment
	 */
	public void batchSave(List<MipAttachment> attachment);
	
	/**
	 * 根据主表名称和主表id查找相关附件
	 * @param attType		主表名
	 * @param attfkid		主表id
	 * @return
	 */
	public List<MipAttachment> getListByFkid(String attType, String attfkid);
	
	/**
	 * 根据id删除，同时删除服务器文件
	 * @param attchid		id
	 * @return
	 */
	public int deleteFile(String attchid);
	
	public JsonResult uploadForPost(CommonsMultipartFile file, String tableName, String tableid, String source);
	
	List<MipAttachment> getAttachmentsByFkId(String fkId);
	
}
