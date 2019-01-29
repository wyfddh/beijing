package com.tj720.admin.dao.map;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.model.CmsSubject;
import com.tj720.admin.model.CmsSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsSubjectMapper extends BaseDao<CmsSubject>{
    int countByExample(CmsSubjectExample example);

    int deleteByExample(CmsSubjectExample example);

    int deleteByPrimaryKey(String id);

    int insert(CmsSubject record);

    int insertSelective(CmsSubject record);

    List<CmsSubject> selectByExample(CmsSubjectExample example);

    CmsSubject selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CmsSubject record, @Param("example") CmsSubjectExample example);

    int updateByExample(@Param("record") CmsSubject record, @Param("example") CmsSubjectExample example);

    int updateByPrimaryKeySelective(CmsSubject record);

    int updateByPrimaryKey(CmsSubject record);
}