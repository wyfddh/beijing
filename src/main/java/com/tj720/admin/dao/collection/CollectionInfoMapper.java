package com.tj720.admin.dao.collection;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tj720.admin.model.collection.CollectionInfo;
import com.tj720.admin.model.collection.CollectionInfoWithBLOBs;
import com.tj720.admin.model.collection.collectionCountDto;

@Repository
public interface CollectionInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(CollectionInfoWithBLOBs record);

    int insertSelective(CollectionInfoWithBLOBs record);

    CollectionInfoWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CollectionInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CollectionInfoWithBLOBs record);

    int updateByPrimaryKey(CollectionInfo record);

    Integer countCollectionInfoList(Map<String, Object> map);

    List<CollectionInfoWithBLOBs> getCollectionInfoList(Map<String, Object> map);

    void batchUpdateData(@Param("list") List<String> keys1,@Param("state") String state);

    collectionCountDto getCollentionHeadCount(Map<String, String> map);

    void batchExhibiting(@Param("list") List<String> list, @Param("state") String state);

    CollectionInfoWithBLOBs getCollectionById(String id);

}