package com.tj720.admin.dao.map;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.dto.ArticleDto;
import com.tj720.admin.model.CmsArticle;
import com.tj720.admin.model.CmsArticleExample;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CmsArticleMapper extends BaseDao<CmsArticle>{
    int countByExample(CmsArticleExample example);

    int deleteByExample(CmsArticleExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmsArticle record);

    int insertSelective(CmsArticle record);

    List<CmsArticle> selectByExampleWithBLOBs(CmsArticleExample example);

    List<CmsArticle> selectByExample(CmsArticleExample example);

    CmsArticle selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmsArticle record, @Param("example") CmsArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsArticle record, @Param("example") CmsArticleExample example);

    int updateByExample(@Param("record") CmsArticle record, @Param("example") CmsArticleExample example);

    int updateByPrimaryKeySelective(CmsArticle record);

    int updateByPrimaryKeyWithBLOBs(CmsArticle record);

    int updateByPrimaryKey(CmsArticle record);

    List<ArticleDto> selectMuseumArticleByKeywords(@Param("keywords") String keywords,@Param("type") String type);
    
    List<CmsArticle> getArticleListByKey(@Param("key") String key,@Param("status") String status,@Param("subjectId") String subjectId,@Param("orgId") String orgId,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
    int countArticleListByKey(@Param("key") String key,@Param("status") String status,@Param("subjectId") String subjectId,@Param("orgId") String orgId);
    
    List<CmsArticle> getArticleListByKey(@Param("key") String key,@Param("status") String status,@Param("subjectId") String subjectId,@Param("orgId") String orgId,@Param("orgList") List<String> orgList,@Param("currentOrg") String currentOrg, @Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
    int countArticleListByKey(@Param("key") String key,@Param("status") String status,@Param("subjectId") String subjectId,@Param("orgId") String orgId,@Param("orgList") List<String> orgList,@Param("currentOrg") String currentOrg);
    
    List<ArticleDto> getArticleListByType(@Param("subjectId") String subjectId,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
    Integer countArticlesByType(@Param("subjectId") String subjectId);
    ArticleDto getArticleById(@Param("id") String id);
    
    List<ArticleDto> getArticleListByUniqueType(@Param("uniqueName") String uniqueName,@Param("orgid") String orgid,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);    
    
    List<ArticleDto> getOtherArticleByIdAndType(@Param("id") String id,@Param("uniqueName") String uniqueName,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
    
    Integer countOtherArticleByIdAndType(@Param("id") String id,@Param("uniqueName") String uniqueName);

	Integer countArticlesByUniqueType(@Param("uniqueName") String uniqueName,@Param("orgid") String orgid);
	
	List<Map<String, Object>> getChlidrenSubjectByUniqueName(@Param("uniqueName") String uniqueName);
	//查询下级栏目，包含自身
	List<HashMap> getChlidrenSubjectByUniqueNameContainSelf(@Param("uniqueName") String uniqueName);
	
	HashMap<String,Integer> getCommentByArticleId(@Param("articleId") String articleId);
	
	HashMap<String,Object> getCommentByArticleIdAndIp(@Param("articleId") String articleId,@Param("ipaddress") String ipaddress);
	
	Integer countCommentByArticleId(@Param("articleId") String articleId,@Param("ipaddress") String ipaddress);
	
	void insertComment(@Param("articleId") String articleId,@Param("ipaddress") String ipaddress,@Param("commendType") String commendType,@Param("createTime") Date createTime);
    
	void updateComment(@Param("articleId") String articleId,@Param("ipaddress") String ipaddress,@Param("commendType") String commendType);
	
	int updateSaveData(@Param("sqlStr") String sqlStr);
}