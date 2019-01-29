package com.tj720.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.StringUtil;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.common.constant.Constants;
import com.tj720.admin.common.util.GeneratorKey;
import com.tj720.admin.dao.map.CmsArticleMapper;
import com.tj720.admin.dao.map.CmsSubjectMapper;
import com.tj720.admin.dto.Node;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.model.SubjectNode;
import com.tj720.admin.model.CmsArticle;
import com.tj720.admin.model.CmsArticleExample;
import com.tj720.admin.model.CmsSubject;
import com.tj720.admin.model.CmsSubjectExample;
import com.tj720.admin.model.CmsSubjectExample.Criteria;
import com.tj720.admin.service.CmsSubjectService;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;

@Service
public class CmsSubjectServiceImpl extends BaseServiceImpl<CmsSubject> implements CmsSubjectService {

	@Autowired
	private CmsSubjectMapper cmsSubjectMapper;
	@Autowired
    private CmsArticleMapper cmsArticleMapper;
	@Autowired
	private Config config;
	
	@Override
	public BaseDao<CmsSubject> getBaseDao() {
		return cmsSubjectMapper;
	}



	@Override
	public List<CmsSubject> getSubjectList(CmsSubject cmsSubject, String type,String Pid) {
		String key = "server:"+(StringUtils.isBlank(type)?"":type) + ":" + (StringUtils.isBlank(Pid)?"":Pid);
		String JsonString = JedisService.get(key);
		if(StringUtils.isNotBlank(JsonString)) {
			List<CmsSubject> list = (List<CmsSubject>) JSONArray.parseArray(JsonString, CmsSubject.class);
			return list;
		}
		
		List<CmsSubject> result = new ArrayList<CmsSubject>();
		CmsSubjectExample example = new CmsSubjectExample();
		example.setOrderByClause("level,pos");
				example.setStartRow(0);
		example.setPageSize(10000);
		CmsSubjectExample.Criteria criteria = example.createCriteria();
		/*if(StringUtils.isNotBlank(type)){
			criteria.andTypeEqualTo(type);
		}*/
		if(StringUtils.isNotBlank(Pid)){
			criteria.andFIdEqualTo(Pid);
		}
		List<String> statuss = new ArrayList<>();
		statuss.add("1");
		criteria.andStatusIn(statuss);
		List<CmsSubject> selectByExample = cmsSubjectMapper.selectByExample(example);
		result.addAll(selectByExample);
		
		for (CmsSubject cmsSubject2 : selectByExample) {
			this.getSubjectListByPid(result, cmsSubject2.getId());
		}
		
		JedisService.set(key, JSON.toJSONString(result));
		return result;
	}
	
	private List<CmsSubject> getSubjectListByPid(List<CmsSubject> result, String pid){
		CmsSubjectExample example = new CmsSubjectExample();
		example.setOrderByClause("level,pos");
				example.setStartRow(0);
		example.setPageSize(10000);
		CmsSubjectExample.Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(pid)){
			criteria.andFIdEqualTo(pid);
		}
		List<String> statuss = new ArrayList<>();
		statuss.add("1");
		criteria.andStatusIn(statuss);
		List<CmsSubject> selectByExample = cmsSubjectMapper.selectByExample(example);
		result.addAll(selectByExample);
		for (CmsSubject cmsSubject : selectByExample) {
			getSubjectListByPid(result, cmsSubject.getId());
		}
		return result;
	}



	@Override
	public List<CmsSubject> getSubjectList(CmsSubject cmsSubject) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<CmsSubject> getSubjectListByParentId(String parentId) {
	    if(StringUtils.isNotBlank(parentId)){
            CmsSubjectExample example = new CmsSubjectExample();
            CmsSubjectExample.Criteria criteria = example.createCriteria();
            criteria.andFIdEqualTo(parentId);
            criteria.andStatusEqualTo("1");
            return cmsSubjectMapper.selectByExample(example);
        }
        return null;
    }
    
    @Override
    public List<CmsSubject> getSubjectListTreeByParentId(String parentId) {
    	List<CmsSubject> allList = new ArrayList<CmsSubject>();
    	this.getSubjectListTreeByParentId(parentId, allList);
    	return allList;
    }
    
    /**
     * 根据父id查询下面所有树结构
     * @param parentId
     * @param allList
     */
    public void getSubjectListTreeByParentId(String parentId, List<CmsSubject> allList){
    	if(StringUtils.isNotBlank(parentId)){
    		List<CmsSubject> subjectListByParentId = this.getSubjectListByParentId(parentId);
    		if(subjectListByParentId != null && subjectListByParentId.size() != 0) {
    			allList.addAll(subjectListByParentId);	//将查到的list放入总容器中
    		}else {
    			return ;
    		}
    		for (CmsSubject cmsSubject : subjectListByParentId) {
    			if(!StringUtil.isEmpty(cmsSubject.getId())) {
    				this.getSubjectListTreeByParentId(cmsSubject.getId(), allList);
    			}
			}
    	}
    }
    
    @Override
    public List<CmsArticle> getArticleListBySubjectId(String subjectId) {
	    if(StringUtils.isNotBlank(subjectId)){
            CmsArticleExample example = new CmsArticleExample();
            CmsArticleExample.Criteria criteria = example.createCriteria();
            criteria.andSubjectIdEqualTo(subjectId);
            return cmsArticleMapper.selectByExample(example);
        }
        return null;
    }

    @Override
    public List<CmsArticle> getCultureListByPage(Page page, String id) {
        CmsArticleExample example = new CmsArticleExample();
        example.setPageSize(page.getSize());
        example.setStartRow(page.getStart());
        CmsArticleExample.Criteria criteria = example.createCriteria();
        criteria.andSubjectIdEqualTo(id);
        return cmsArticleMapper.selectByExample(example);
    }



	@Override
	public JsonResult modify(CmsSubject cmsSubject) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String format2 = format.format(new Date());
		cmsSubject.setModifyTime(format2);
		int updateByPrimaryKeySelective = cmsSubjectMapper.updateByPrimaryKeySelective(cmsSubject);
		if(updateByPrimaryKeySelective > 0) {
			return new JsonResult(1,cmsSubject);
		}
		return new JsonResult(2,"系统错误");
	}



	@Override
	public JsonResult save(CmsSubject cmsSubject) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String format2 = format.format(new Date());
		cmsSubject.setModifyTime(format2);
		cmsSubject.setCreateTime(format2);
		cmsSubject.setId(50+GeneratorKey.generatorIDCodeByCache(CmsSubject.class.getName(), null));
		cmsSubject.setStatus("1");
		String fid = "";
		if(MyString.isEmpty(cmsSubject.getfId())) {
			cmsSubject.setDn(cmsSubject.getId());
			fid = cmsSubject.getId();
		}else {
			CmsSubject fSubject = cmsSubjectMapper.selectByPrimaryKey(cmsSubject.getfId());
			String dn = fSubject==null?"":(fSubject.getDn()+"/")+cmsSubject.getId();
			cmsSubject.setDn(dn);
			Integer flevel = StringUtil.isEmpty(fSubject==null?null:fSubject.getLevel())?1:Integer.parseInt(fSubject.getLevel());
			cmsSubject.setLevel((flevel+1)+"");		//保存时，设置当前级别为父级别+1
			fid = cmsSubject.getfId();
		}
		//设置排序：查询当前父节点下，最大的排序
		CmsSubjectExample example = new CmsSubjectExample();
		Criteria criteria = example.createCriteria();
		criteria.andFIdEqualTo(fid);
		example.setStartRow(0);
		example.setPageSize(1);
		example.setOrderByClause("pos desc");
		List<CmsSubject> selectByExample = cmsSubjectMapper.selectByExample(example);
		if(selectByExample != null && selectByExample.size() == 1) {
			cmsSubject.setPos(selectByExample.get(0).getPos()+1);
		}else {
			cmsSubject.setPos(0);
		}
		int insertSelective = cmsSubjectMapper.insertSelective(cmsSubject);
		if(insertSelective > 0) {
			return new JsonResult(1,cmsSubject);
		}
		return new JsonResult(2,"系统错误");
	}

	@Override
	public List<CmsSubject> getSubjectListByUniqueName(String id, String uniqueName) {
		CmsSubjectExample example = new CmsSubjectExample();
		Criteria criteria = example.createCriteria();
		List<String> statuss = new ArrayList<>();
		statuss.add("1");
		criteria.andStatusIn(statuss);
		
		if(StringUtil.isNotEmpty(id)) {
			criteria.andIdNotEqualTo(id);
		}
		criteria.andUniqueNameEqualTo(uniqueName);
		List<CmsSubject> selectByExample = cmsSubjectMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public List<SubjectNode> getSubjectListTreeByParentId1(String parentId, String type) {
		if(StringUtils.isNotBlank(parentId)){
			CmsSubjectExample example = new CmsSubjectExample();
            CmsSubjectExample.Criteria criteria = example.createCriteria();
            criteria.andFIdEqualTo(parentId);
//            criteria.andTypeEqualTo(type);
            criteria.andStatusEqualTo("1");
            example.setOrderByClause("pos, create_time");
            List<CmsSubject> selectByExample = cmsSubjectMapper.selectByExample(example);
            List<SubjectNode> resultList = new ArrayList<>();
            for (CmsSubject cmsSubject : selectByExample) {
            	SubjectNode node = new SubjectNode();
            	node.setId(cmsSubject.getId());
            	node.setName(cmsSubject.getName());
            	node.setUniqueName(cmsSubject.getUniqueName());
            	node.setDescription(cmsSubject.getDescription());
            	node.setParentid(cmsSubject.getfId());
            	node.setPos(cmsSubject.getPos());
            	String create_time = cmsSubject.getCreateTime();
    			create_time = DateUtil.StringToString(create_time, DateStyle.YYYY_MM_DD_HH_MM);
    			node.setCreate_time(create_time);
            	node.setChildren(this.getSubjectListTreeByParentId1(cmsSubject.getId(), type));
            	resultList.add(node);
			}
			return resultList;
    	}
		return null;
	}


}
