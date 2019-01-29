package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.model.SubjectNode;
import com.tj720.admin.model.CmsArticle;
import com.tj720.admin.model.CmsSubject;
import com.tj720.mip.utils.Page;

public interface CmsSubjectService extends BaseService<CmsSubject> {
	
	/**
	 * 根据条件 获取栏目列表
	 * @param cmsSubject 条件对象
	 * @param type 分页参数
	 * @return
	 */
	List<CmsSubject> getSubjectList(CmsSubject cmsSubject, String type,String Pid);
	
	/**
	 * 根据条件 获取栏目列表
	 * @param cmsSubject 条件对象
	 * @return
	 */
	List<CmsSubject> getSubjectList(CmsSubject cmsSubject);

    /**
     * 根据父ID获取ID底下的所有子级数据
     * @param parentId 父ID
     * @return
     */
	List<CmsSubject> getSubjectListByParentId(String parentId);

    /**
     * 根据父ID获取ID底下的所有子级数据，包含子级的子级数据
     * @param parentId 父ID
     * @return
     */
	List<CmsSubject> getSubjectListTreeByParentId(String parentId);
	
	/**
	 * 根据父id获取所有子级，并将子级赋值到chiled集合中（树形列表专用）
	 * @param parentId
	 * @return
	 */
	List<SubjectNode> getSubjectListTreeByParentId1(String parentId, String type);

    /**
     * 根据栏目ID查询对应的文化列表
     * @param subjectId 栏目ID
     * @return
     */
	List<CmsArticle> getArticleListBySubjectId(String subjectId);

    List<CmsArticle> getCultureListByPage(Page page, String id);
    
    JsonResult modify(CmsSubject cmsSubject);
    
    JsonResult save(CmsSubject cmsSubject);

    /**
     * 唯一名称和id，查找其他使用唯一名称的栏目
     * @param id
     * @param uniqueName
     * @return
     */
    List<CmsSubject> getSubjectListByUniqueName(String id, String uniqueName);
}
