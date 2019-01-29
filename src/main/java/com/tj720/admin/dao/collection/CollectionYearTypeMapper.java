package com.tj720.admin.dao.collection;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tj720.admin.model.collection.CollectionYearType;

@Repository
public interface CollectionYearTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(CollectionYearType record);

    int insertSelective(CollectionYearType record);

    CollectionYearType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CollectionYearType record);

    int updateByPrimaryKey(CollectionYearType record);

    List<CollectionYearType> getCommonYearList(Map<String, String> map);
}