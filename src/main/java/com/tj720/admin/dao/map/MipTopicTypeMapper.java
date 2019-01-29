package com.tj720.admin.dao.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tj720.admin.model.MipTopicType;

public interface MipTopicTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(MipTopicType record);

    int insertSelective(MipTopicType record);

    MipTopicType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MipTopicType record);

    int updateByPrimaryKey(MipTopicType record);
    
    List<MipTopicType> getList(@Param("name") String name, @Param("startRow") Integer start, @Param("pageSize") Integer size);
    
    int countList(@Param("name") String name);
}