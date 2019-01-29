package com.tj720.admin.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.StringUtil;
import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.CmsArticleMapper;
import com.tj720.admin.dto.ArticleDto;
import com.tj720.admin.model.CmsArticle;
import com.tj720.admin.model.CmsArticleExample;
import com.tj720.admin.model.MipAttachment;
import com.tj720.admin.model.CmsArticleExample.Criteria;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.service.CmsArticleService;
import com.tj720.admin.service.CmsSubjectService;
import com.tj720.admin.service.MipAttachmentService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.TimeUtil;

/**
 * @author hanhaojie
 */
@Service
public class CmsArticleServiceImpl extends BaseServiceImpl<CmsArticle> implements CmsArticleService {

	@Autowired
	CmsArticleMapper cmsArticleMapper;
	@Autowired
	Config config;
	@Autowired
	private MipAttachmentService mipAttachmentService;
	
	@Autowired
	CmsSubjectService cmsSubjectService;

    @Override
	public BaseDao<CmsArticle> getBaseDao() {
		return cmsArticleMapper;
	}

	@Override
	public List<CmsArticle> getArticleList(String key, String status, String subjectId, Page page, String orgId) throws ParseException {
		page.setAllRow(cmsArticleMapper.countArticleListByKey(key, status, subjectId, orgId));
		List<CmsArticle> list = cmsArticleMapper.getArticleListByKey(key, status, subjectId, orgId, page.getStart(), page.getSize());
		formatDate(list);
		return list;
	}
	
	@Override
	public List<CmsArticle> getArticleList(String key, String status, String subjectId, List<String> orgList, Page page, String currentOrg) throws ParseException {
		page.setAllRow(cmsArticleMapper.countArticleListByKey(key, status, subjectId, null, orgList, currentOrg));
		List<CmsArticle> list = cmsArticleMapper.getArticleListByKey(key, status, subjectId, null, orgList, currentOrg, page.getStart(), page.getSize());
		formatDate(list);
		return list;
	}

	/**
	 * 格式化时间，图片链接
	 * @param list
	 * @throws ParseException
	 */
    private void formatDate(List<CmsArticle> list) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(CmsArticle cms : list){
        	if(StringUtil.isNotEmpty(cms.getTitleImageSrc())) {
        		cms.setTitleImageSrc(config.getRootUrl()+cms.getTitleImageSrc());
        	}
            Date parse = format.parse(cms.getCreateTime());
            cms.setCreateTime(dateFormat.format(parse));
        }
    }

    @Override
	public int removeArticleById(String id) {
		CmsArticle article = new CmsArticle();
		article.setId(id);
		article.setStatus("0");
		article.setModifyTime(TimeUtil.getCurDate());
		return cmsArticleMapper.updateByPrimaryKeySelective(article);
	}

	@Override
	public int modifyByArticle(CmsArticle cmsArticle) {
	     return cmsArticleMapper.updateByPrimaryKeySelective(cmsArticle);
	}

    @Override
    public List<CmsArticle> getArticleListIsTop10(String startStr,String stopStr) {
        CmsArticleExample example = new CmsArticleExample();
        example.setPageSize(10);
        example.setOrderByClause("view_counts desc");
        CmsArticleExample.Criteria criteria = example.createCriteria();
        criteria.andSubjectIdBetween(startStr, stopStr);
        criteria.andStatusEqualTo("5");
        return cmsArticleMapper.selectByExample(example);
    }

    @Override
	public int update(CmsArticle model) {
		return cmsArticleMapper.updateByPrimaryKey(model);
	}

    /**
     * 重写基类的get方法(对内容进行转换处理)
     * @param id .
     * @return .
     */
    @Override
    public CmsArticle get(String id) {
        CmsArticle cms = super.get(id);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(!StringUtils.isBlank(cms.getTitleImageSrc())) {
        	cms.setTitleImageSrc(config.getRootUrl()+cms.getTitleImageSrc());
        }
        String publisher = cms.getPublisher();
//        MipUser mipUser = userService.getUserByOrgId(publisher);
        MipUser mipUser = null;
        cms.setMark(publisher);
        if(mipUser != null) {
            cms.setPublisher(mipUser.getNickName());
        }
        Date parse = null;
        try {
            parse = format.parse(cms.getCreateTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cms.setCreateTime(dateFormat.format(parse));
        return cms;
    }

	@Override
	public List<CmsArticle> getArticleListBySubjectId(String subjectId, Page page) {
		CmsArticleExample example = new CmsArticleExample();
		example.setStartRow(page.getStart());
        example.setPageSize(page.getSize());
        example.setOrderByClause("modify_time desc");
        CmsArticleExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo("5");
        criteria.andSubjectIdEqualTo(subjectId);
        /*if("9".equals(subjectId)){
        	criteria.andSubjectIdEqualTo(subjectId);
		}else{
			List<CmsSubject> subjectList = cmsSubjectService.getSubjectListByParentId(subjectId);
			List<String> values = new ArrayList<String>();
			if(!MyString.isEmpty(subjectList)){
				for(CmsSubject list : subjectList){
					values.add(list.getId());
				}
				criteria.andSubjectIdIn(values);
			}
		}*/
        return cmsArticleMapper.selectByExample(example);
	}

    @Override
    public int getArticleCountByStatus(String id, String status) {
        CmsArticle cmsArticle = this.get(id);
        if(Objects.nonNull(cmsArticle)){
            CmsArticleExample example = new CmsArticleExample();
            CmsArticleExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo(status);
            criteria.andSubjectIdEqualTo(cmsArticle.getSubjectId());
            return cmsArticleMapper.countByExample(example);
        }
        return 10;
    }

    @Override
    public List<ArticleDto> selectArticleByKeywords(String keywords,String type) {
        List<ArticleDto> articleDtos = cmsArticleMapper.selectMuseumArticleByKeywords("%" + keywords + "%",type);
        return articleDtos;
    }
    
    @Override
    public JsonResult getArticleListByType(String subjectId,Page page){
    	int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		Integer allCounts = cmsArticleMapper.countArticlesByType(subjectId);
		page.setAllRow(allCounts);
		List<ArticleDto> articleDtos = cmsArticleMapper.getArticleListByType(subjectId,startRow,page.getSize());
		List<ArticleDto> articleDtosNew = new ArrayList<ArticleDto>();
//		try {
//			formatArticleDto(articleDtos);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		for(ArticleDto article : articleDtos){
			String txtcontent = article.getContent();
			if (!MyString.isEmpty(txtcontent)) {
//				txtcontent = txtcontent.replaceAll("<br/><br/>","<br/>");
//				txtcontent = txtcontent.replaceAll("<(?!img|/?br)[^>]*>","");
//				txtcontent = txtcontent.replaceAll("&nbsp;", "");//去除字符串中的空格,回车,换行符,制表符  
//				txtcontent = txtcontent.replaceAll("<br/>", "");//去除字符串中的空格,回车,换行符,制表符 
//				txtcontent = txtcontent.replaceAll("<img.*>.*</img>", "").replaceAll("<img.*/>", "");//去图
//				txtcontent = txtcontent.replaceAll("\\s*", "");//去空格	
//				// <p>段落替换为换行 
//				txtcontent = txtcontent.replaceAll("<p .*?>", ""); 
//				// <br><br/>替换为换行 
//				txtcontent = txtcontent.replaceAll("<br\\s*/?>", ""); 
//				// 去掉其它的<>之间的东西 
//				txtcontent = txtcontent.replaceAll("\\<.*?>", ""); 
				//剔出<html>的标签
				txtcontent = txtcontent.replaceAll("</?[^>]+>", ""); 
				//去除字符串中的空格,回车,换行符,制表符 
				txtcontent = txtcontent.replaceAll("&nbsp;", "");
			}
			article.setContent(txtcontent);
						try {
			String timeString = formatDate(article.getCreateTime());
			article.setCreateTime(timeString);
			if(null != timeString && timeString!=""){
				String[] time = timeString.split(" ");
				String[] timeAttr =  time[0].split("-");
				article.setYear(timeAttr[0]);
				article.setMonthDay(timeAttr[2]+"/"+timeAttr[1]);
				article.setDayMonth(timeAttr[1]+"/"+timeAttr[2]);
			}			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(null != article){
	    		if(null != article.getPicUrl()){
	    			article.setPicUrl(addRootUrl(article.getPicUrl()));
	    		}
	    		if(null != article.getPdfUrl()){
	    			String pdfId = article.getPdfUrl();
	    			if(!StringUtils.isBlank(pdfId)) {
	    				MipAttachment mipAttachment = mipAttachmentService.get(pdfId);
	    				article.setPdfUrl(addRootUrl(mipAttachment.getAttPath()));
	    			}
	    		}
	    	}
			articleDtosNew.add(article);
		}
		return new JsonResult(1,articleDtosNew,page);
    }
    
    @Override
    public ArticleDto getArticleById(String id){
    	//点击次数+1（缓存）
//		String key = MessageFormat.format(KeyConstants.ARTICLE_VIEW_COUNTSY, id);
//		JedisService.incr(key);
		//过期后(5s)存入数据库
//		String expireKey = MessageFormat.format(KeyConstants.ARTICLE_VIEW_COUNTSY_EXPIRE, id);
//		JedisService.set(expireKey, JedisService.get(key), 5);
		
    	ArticleDto article = cmsArticleMapper.getArticleById(id);
    	if(null != article){
    		if(null != article.getPicUrl()){
    			article.setPicUrl(addRootUrl(article.getPicUrl()));
    		}
    		if(null != article.getPdfUrl()){
    			String pdfId = article.getPdfUrl();
    			if(!StringUtils.isBlank(pdfId)) {
    				MipAttachment mipAttachment = mipAttachmentService.get(pdfId);
    				article.setPdfUrl(addRootUrl(mipAttachment.getAttPath()));
    			}
    		}
    		try {
    			String timeString = formatDate(article.getCreateTime());
    			article.setCreateTime(timeString);
    			if(null != timeString && timeString!=""){
    				String[] time = timeString.split(" ");
    				String[] timeAttr =  time[0].split("-");
    				article.setYear(timeAttr[0]);
    				article.setMonthDay(timeAttr[2]+"/"+timeAttr[1]);
    				article.setDayMonth(timeAttr[1]+"/"+timeAttr[2]);
    				timeString = time[0];
					article.setCreateTime(timeString);
    			}
    			} catch (ParseException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	}

    	return article;
    }
   
    @Override
    public List<ArticleDto> getArticleList(String subjectId,Page page){
    	int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		Integer allCounts = cmsArticleMapper.countArticlesByType(subjectId);
		page.setAllRow(allCounts);
		List<ArticleDto> articleDtos = cmsArticleMapper.getArticleListByType(subjectId,startRow,page.getSize());
		List<ArticleDto> articleDtosNew = new ArrayList<ArticleDto>();
		for(ArticleDto article : articleDtos){
			String txtcontent = article.getContent();
			if (!MyString.isEmpty(txtcontent)) {				
				txtcontent = txtcontent.replaceAll("</?[^>]+>", ""); 
				//去除字符串中的空格,回车,换行符,制表符 
				txtcontent = txtcontent.replaceAll("&nbsp;", "");
			}
			article.setContent(txtcontent);
			try {
			String timeString = formatDate(article.getCreateTime());
			article.setCreateTime(timeString);
			if(null != timeString && timeString!=""){
				String[] time = timeString.split(" ");
				String[] timeAttr =  time[0].split("-");
				article.setYear(timeAttr[0]);
				article.setMonthDay(timeAttr[2]+"/"+timeAttr[1]);
				article.setDayMonth(timeAttr[1]+"/"+timeAttr[2]);
				timeString = time[0];
				article.setCreateTime(timeString);
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(null != article){
	    		if(null != article.getPicUrl()){
	    			article.setPicUrl(addRootUrl(article.getPicUrl()));
	    		}
	    		if(null != article.getPdfUrl()){
	    			String pdfId = article.getPdfUrl();
	    			if(!StringUtils.isBlank(pdfId)) {
	    				MipAttachment mipAttachment = mipAttachmentService.get(pdfId);
	    				article.setPdfUrl(addRootUrl(mipAttachment.getAttPath()));
	    			}
	    		}
	    	}
			articleDtosNew.add(article);
		}
		return articleDtosNew;
    }
    
    
    @Override
    public int getMaxPosBySubject(String subjectid) {
    	//查询当前栏目下，最大的排序
        CmsArticleExample example = new CmsArticleExample();
        Criteria criteria = example.createCriteria();
        criteria.andSubjectIdEqualTo(subjectid);
        example.setOrderByClause("pos desc");
        example.setStartRow(0);
        example.setPageSize(1);
        List<CmsArticle> selectByExample = cmsArticleMapper.selectByExample(example);
        if(selectByExample == null || selectByExample.size() == 0) {
        	return 0;
        }else {
        	return selectByExample.get(0).getPos()+1;
        }
    }
    
    @Override
	public JsonResult getArticleListByUniqueType1(String uniqueName,String orgid,Page page){
	    	int startRow = -1;
			int curPage = page.getCurrentPage();
			startRow = (curPage - 1) * page.getSize();
			startRow = startRow <= 0 ? -1 : startRow;
			Integer allCounts = cmsArticleMapper.countArticlesByUniqueType(uniqueName,orgid);
			page.setAllRow(allCounts);
			List<ArticleDto> articleDtos = cmsArticleMapper.getArticleListByUniqueType(uniqueName,orgid,startRow,page.getSize());
			List<ArticleDto> articleDtosNew = new ArrayList<ArticleDto>();
//			try {
//				formatArticleDto(articleDtos);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			for(ArticleDto article : articleDtos){
				String txtcontent = article.getContent();
				if (!MyString.isEmpty(txtcontent)) {
					//剔出<html>的标签
					txtcontent = txtcontent.replaceAll("</?[^>]+>", ""); 
					//去除字符串中的空格,回车,换行符,制表符 
					txtcontent = txtcontent.replaceAll("&nbsp;", "");
				}
				article.setContent(txtcontent);	
				try {
					String timeString = formatDate(article.getCreateTime());
					
					article.setCreateTime(timeString);
					if(null != timeString && timeString!=""){
						String[] time = timeString.split(" ");
						String[] timeAttr =  time[0].split("-");
						article.setYear(timeAttr[0]);
						article.setMonthDay(timeAttr[2]+"/"+timeAttr[1]);
						article.setDayMonth(timeAttr[1]+"/"+timeAttr[2]);
						timeString = time[0];
						article.setCreateTime(timeString);
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				if(null != article){
		    		if(null != article.getPicUrl()){
		    			article.setPicUrl(addRootUrl(article.getPicUrl()));
		    		}
		    		if(null != article.getPdfUrl()){
		    			String pdfId = article.getPdfUrl();
		    			if(!StringUtils.isBlank(pdfId)) {
		    				MipAttachment mipAttachment = mipAttachmentService.get(pdfId);
		    				article.setPdfUrl(addRootUrl(mipAttachment.getAttPath()));
		    			}
		    		}
		    	}
				articleDtosNew.add(article);
			}
			return new JsonResult(1,articleDtosNew,page);
	    }

	@Override
	public List<Map<String,Object>> getChildrenSubject(String uniqueName) {
		List<Map<String,Object>> list = cmsArticleMapper.getChlidrenSubjectByUniqueName(uniqueName);
		return list;
	}

	@Override
	public List<ArticleDto> getOtherArticleListByUniqueName(String id, String uniqueName,Page page) {
		if(null == id || uniqueName== null){
			return null;
		}
		int startRow = -1;
		int curPage = page.getCurrentPage();
		startRow = (curPage - 1) * page.getSize();
		startRow = startRow <= 0 ? -1 : startRow;
		Integer allCounts = cmsArticleMapper.countOtherArticleByIdAndType(id,uniqueName);
		page.setAllRow(allCounts);
		List<ArticleDto> articleDtos = cmsArticleMapper.getOtherArticleByIdAndType(id, uniqueName,startRow,page.getSize());
		List<ArticleDto> articleDtosNew = new ArrayList<ArticleDto>();
		for(ArticleDto article : articleDtos){
			String txtcontent = article.getContent();
			if (!MyString.isEmpty(txtcontent)) {				
				txtcontent = txtcontent.replaceAll("</?[^>]+>", ""); 
				//去除字符串中的空格,回车,换行符,制表符 
				txtcontent = txtcontent.replaceAll("&nbsp;", "");
			}
			article.setContent(txtcontent);
			try {
			String timeString = formatDate(article.getCreateTime());
			article.setCreateTime(timeString);
			if(null != timeString && timeString!=""){
				String[] time = timeString.split(" ");
				String[] timeAttr =  time[0].split("-");
				article.setYear(timeAttr[0]);
				article.setMonthDay(timeAttr[1]+"/"+timeAttr[2]);
				article.setDayMonth(timeAttr[1]+"/"+timeAttr[2]);
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(null != article){
	    		if(null != article.getPicUrl()){
	    			article.setPicUrl(addRootUrl(article.getPicUrl()));
	    		}
	    		if(null != article.getPdfUrl()){
	    			String pdfId = article.getPdfUrl();
	    			if(!StringUtils.isBlank(pdfId)) {
	    				MipAttachment mipAttachment = mipAttachmentService.get(pdfId);
	    				article.setPdfUrl(addRootUrl(mipAttachment.getAttPath()));
	    			}
	    		}
	    	}
			articleDtosNew.add(article);
		}
		return articleDtosNew;
	}
	private String addRootUrl(String url){
		if(null != url && url != ""){
			return config.getRootUrl()+url;
		}
		else{
			return url;
		}
	}

	@Override
	public HashMap getCommentByArticleId(String articleId) {
		int count = cmsArticleMapper.countCommentByArticleId(articleId, null);
		HashMap comments = comments = new HashMap();
		if(count == 0){
			
			comments.put("commendCount", 0);
			comments.put("middleCount", 0);
			comments.put("criticismCount", 0);
			return comments;
		}else{
			comments = cmsArticleMapper.getCommentByArticleId(articleId);
			if(null == comments){
				comments = new HashMap();
				comments.put("commendCount", 0);
				comments.put("middleCount", 0);
				comments.put("criticismCount", 0);
			}
		}		
		return comments;
	}
	@Override
	public HashMap getCommentByArticleIdAndIp(String articleId,String ipaddress) {
		int count = cmsArticleMapper.countCommentByArticleId(articleId, ipaddress);
		HashMap comments = comments = new HashMap();
		if(count == 0){			
			comments.put("commendCount", 0);
			comments.put("middleCount", 0);
			comments.put("criticismCount", 0);
			return comments;
		}else{
			comments = cmsArticleMapper.getCommentByArticleIdAndIp(articleId,ipaddress);
			if(null == comments){
				comments = new HashMap();
				comments.put("commendCount", 0);
				comments.put("middleCount", 0);
				comments.put("criticismCount", 0);
			}
		}		
		return comments;
	}

	@Override
	public int insertComment(String articleId, String ipaddress, String commendType) {
		// TODO Auto-generated method stub
		Integer count = cmsArticleMapper.countCommentByArticleId(articleId, ipaddress);
		if(count > 0){
			return 0;
		}
		cmsArticleMapper.insertComment(articleId, ipaddress, commendType,new Date());
		return 1;
	}
	@Override
	public int updateComment(String articleId, String ipaddress, String commendType) {
		// TODO Auto-generated method stub
		cmsArticleMapper.updateComment(articleId, ipaddress, commendType);
		return 1;
	}
	@Override
	public Integer countCommentByArticleId(String articleId, String ipaddress) {
		// TODO Auto-generated method stub
		return cmsArticleMapper.countCommentByArticleId(articleId, ipaddress);
	}
	
	/**
	 * 格式化时间，图片链接
	 * @param list
	 * @throws ParseException
	 */
    private void formatArticleDto(List<ArticleDto> list) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(ArticleDto cms : list){
        	if(StringUtil.isNotEmpty(cms.getPicUrl())) {
        		cms.setPicUrl(config.getRootUrl()+cms.getPicUrl());
        	}
        	if(StringUtil.isNotEmpty(cms.getPdfUrl())) {
        		String pdfId = cms.getPdfUrl();
    			if(!StringUtils.isBlank(pdfId)) {
    				MipAttachment mipAttachment = mipAttachmentService.get(pdfId);
    				cms.setPdfUrl(config.getRootUrl()+mipAttachment.getAttPath());
    			}
        	}
            Date parse = format.parse(cms.getCreateTime());
            cms.setCreateTime(dateFormat.format(parse));
        }
    }
    /**
     * 格式化时间
     * @param date
     * @return
     * @throws ParseException
     */
    private String formatDate(String date) throws ParseException {
        if(null == date || date == ""){return date;}
    	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        Date parse = format.parse(date);
        return dateFormat.format(parse);
    }
    
    @Override
	public int updateSaveData(String sqlStr) {
		// TODO Auto-generated method stub
		int num = cmsArticleMapper.updateSaveData(sqlStr);
		return num;
	}

}
