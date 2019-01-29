package com.tj720.admin.dao.collection;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumBaseInfoDto;
import com.tj720.admin.model.collection.CollectDict;

@Repository
public interface CollectDictMapper {
    int deleteByPrimaryKey(String id);

    int insert(CollectDict record);

    int insertSelective(CollectDict record);

    CollectDict selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CollectDict record);

    int updateByPrimaryKey(CollectDict record);

    List<CollectDict> getDictListByKeys(List<String> keys);

    List<CollectDict> getDictListByKey(@Param("key") String key,@Param("dictCode") String dictCode,@Param("dictName") String dictName);

    List<CollectDict> getDictListAndCount(@Param("item") String item,@Param("map") Map<String, String> map);

	MuseumBaseInfoDto getOrgAreaByOrgId(String orgId);
}