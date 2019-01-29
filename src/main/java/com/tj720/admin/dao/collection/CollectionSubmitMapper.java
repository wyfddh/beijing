package com.tj720.admin.dao.collection;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tj720.admin.model.collection.CollectionSubmit;

@Repository
public interface CollectionSubmitMapper {
    int deleteByPrimaryKey(String id);

    int insert(CollectionSubmit record);

    int insertSelective(CollectionSubmit record);

    CollectionSubmit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CollectionSubmit record);

    int updateByPrimaryKey(CollectionSubmit record);

	CollectionSubmit getInfoByOrgId(String orgId);

	Integer countSubmitList(Map<String, Object> map);

	List<CollectionSubmit> getSubmitList(Map<String, Object> map);
}