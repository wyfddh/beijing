package com.tj720.admin.dao.collection;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tj720.admin.model.collection.CollectionCategory;

@Repository
public interface CollectionCategoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(CollectionCategory record);

    int insertSelective(CollectionCategory record);

    CollectionCategory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CollectionCategory record);

    int updateByPrimaryKey(CollectionCategory record);

    List<CollectionCategory> getListByType(Map<String, String> map);
}