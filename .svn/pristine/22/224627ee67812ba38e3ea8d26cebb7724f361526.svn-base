package com.tj720.admin.service;

import org.springframework.stereotype.Service;

import com.tj720.admin.model.MipOpenCollectionInfo;
import com.tj720.admin.model.MipOpenCulturalrelicInfoApproval;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Page;

/**
* @author chengrongkai
* @version 创建时间：2019年1月3日 上午11:03:37
* @ClassName 类名称
* @Description 类描述
*/
@Service
public interface MipOpenCulturalrelicInfoApprovalService {
	/**
	 * 新增流程信息
	 * @param MipOpenCulturalrelicInfoApproval
	 * @return
	 */
	public JsonResult addApprovalInfo(MipOpenCulturalrelicInfoApproval MipOpenCulturalrelicInfoApproval);
	/**
	 * 操作流程信息
	 * @param id 流程id
	 * @param type 操作类型(1:审批通过,2:审批不通过)
	 * @return
	 */
	public JsonResult operaterApprovalInfo(String id,int type);
	/**
	 * 批量操作流程信息
	 * @param ids 流程id
	 * @param type 操作类型(1:审批通过,2:审批不通过)
	 * @return
	 */
	public JsonResult batchOperaterApprovalInfo(String[] ids,int type);
	/**
	 * 查询审批列表
	 * @param applyDept 申请单位
	 * @param status 申请状态
	 * @return
	 */
	public JsonResult getApprovalInfoList(String applyDept,int status,Page page);
	/**
	 * 查询申请详情
	 * @param id 流程id
	 * @return
	 */
	public JsonResult getApprovalInfoDetail(String id,Page page);
	/**
	 * 查询申请详情（化石）
	 * @param id
	 * @param page
	 * @return
	 */
	public JsonResult getApprovalInfoDetail4OpenFossil(String id,Page page);
	/**
	 * 查询公众公开库
	 * @param applyDept 单位
	 * @return
	 */
	public JsonResult getOpenInfoList(String applyDept,Page page);
	/**
	 * 从公众公开库里移除
	 * @param id 藏品id
	 * @return
	 */
	public JsonResult remove4OpenInfo(String id);
	
	
	/**
	 * 从公众公开库里移除
	 * @param id 藏品id
	 * @return
	 */
	public JsonResult batchRemove4OpenInfo(String[] ids);
	/**
	 * 更新藏品表状态
	 * @param id 藏品表id
	 * @param isOpen 公众公开
	 * @param gjOpen 馆际公开
	 * @return
	 */
	public JsonResult updateCollectionInfo(String id,int isOpen,int gjOpen);
	
	public JsonResult update4OpenFossilInfo(String id,int isOpen,int gjOpen);
	
	/**
	 * 批量更新藏品表状态
	 * @param ids 藏品表ids
	 * @param isOpen 公众公开
	 * @param gjOpen 馆际公开
	 * @return
	 */
	public JsonResult batchUpdateCollectionInfo(String[] ids,int isOpen,int gjOpen);
	
	public JsonResult batchUpdateOpenFossilInfo(String[] ids,int isOpen,int gjOpen);
	
	public JsonResult batchAddApprovalRel(String[] ids,String approvalId,String type);
	/**
	 * 查询审批详情
	 * @param id
	 * @return
	 */
	public MipOpenCulturalrelicInfoApproval getApprovalInfo(String id);
	
	public JsonResult getOpenDetail(String id);
}
