package com.tj720.admin.service.collection;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tj720.admin.dto.MuseumBaseInfoDto;
import com.tj720.admin.model.collection.CollectDict;
import com.tj720.mip.framework.JsonResult;


@Service
public interface CollectDictSevice {

    /**
     *
     * @param keys 字典类型
     * @return 返回符合条件字典集合
     */
    List<CollectDict> getDictListByKeys(List<String> keys);

    /**
     *
     * @param key  单个字典类型
     * @param dictCode  字典code
     * @param dictName  字典名
     * @return 返回符合条件字典集合
     */
    List<CollectDict> getDictListByKey(String key, String dictCode, String dictName);

    /**
     *
     * @param key 单个字典类型
     * @return 返回符合条件字典集合
     */
    List<CollectDict> getDictListByKey(String key);


    Map<String,Object> getDictListByArr(String[] arr);

    JsonResult getOrg(String orgId);

    Object getOrgByOrgId(String orgId);

    List<CollectDict> getDictListAndCount(String collection_level, Map<String, String> map);

	Object getOrgAreaByOrgId(String collectionOrgId);
}
