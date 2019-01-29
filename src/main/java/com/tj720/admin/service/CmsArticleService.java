package com.tj720.admin.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.dto.ArticleDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.admin.model.CmsArticle;
import com.tj720.mip.utils.Page;

public interface CmsArticleService extends BaseService<CmsArticle> {
	
	/**
	 * 根据条件 获取文章列表
	 * @param key
	 * @param status
	 * @param subjectId
	 * @param page
	 * @param orgId
	 * @return
	 * @throws ParseException
	 */
	List<CmsArticle> getArticleList(String key, String status, String subjectId, Page page, String orgId) throws ParseException;
	
	/**
	 * 根据条件 获取文章列表
	 * @param key
	 * @param status
	 * @param subjectId
	 * @param page
	 * @param orgId
	 * @return
	 * @throws ParseException
	 */
	List<CmsArticle> getArticleList(String key, String status, String subjectId, List<String> orgList, Page page, String currentOrg) throws ParseException;
	
	/**
	 * 逻辑删除
	 * @param id
	 * @return
	 */
	int removeArticleById(String id);
	
	/**
	 * 编辑数据
	 * @param cmsArticle
	 * @return
	 */
	int modifyByArticle(CmsArticle cmsArticle);

    /**
     * 获取文章点击数量前10的列表
     */
    List<CmsArticle> getArticleListIsTop10(String startStr,String stopStr);
    
    /**
     * 根据栏目id查询文字数据，按修改时间取最新的数据
     * @return
     */
    List<CmsArticle> getArticleListBySubjectId(String subjectId,Page page);

    int getArticleCountByStatus(String id, String status);

    List<ArticleDto> selectArticleByKeywords(String keywords,String type);
    // 根据分类id获取文章
    JsonResult getArticleListByType(String subjectId,Page page);
    // 获取文章详情
	ArticleDto getArticleById(String id);
	List<ArticleDto> getArticleList(String subjectId, Page page);
    /**
     * 根据栏目查找栏目下面，文章最大的排序
     * @param subjectid
     * @return  如果有文章，在返回最大排序+1
     *          如果没有，则返回0
     */
     int getMaxPosBySubject(String subjectid);
     
     public int update(CmsArticle model) ;

     JsonResult getArticleListByUniqueType1(String uniqueName,String orgid,Page page);
     /**
      * 获取其他文章列表
      * @param id
      * @param subjectId
      * @return
      */
     List<ArticleDto> getOtherArticleListByUniqueName(String id, String uniqueName,Page page);
     
     List<Map<String,Object>> getChildrenSubject(String uniqueName);
     
     HashMap getCommentByArticleId(String articleId);
     
     HashMap getCommentByArticleIdAndIp(String articleId,String ipaddress);
     
     
     Integer countCommentByArticleId(String articleId,String ipaddress);
 	
 	int insertComment(String articleId,String ipaddress,String commendType);
     
 	int updateComment(String articleId,String ipaddress,String commendType);

 	int updateSaveData(String sql);
     
}
