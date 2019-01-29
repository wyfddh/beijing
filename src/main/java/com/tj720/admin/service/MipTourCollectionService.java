package com.tj720.admin.service;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dto.MipTourCollectionDto;
import com.tj720.admin.model.MipTopicCollection;
import com.tj720.admin.model.MipTour;
import com.tj720.admin.model.MipTourCollection;
import com.tj720.admin.model.MipTourCollectionExample;

import java.util.HashMap;
import java.util.List;

public interface MipTourCollectionService extends BaseService<MipTourCollection> {

    /**
     * 根据专题id，和藏品id查询数据
     * @param MipTourCollection
     * @return
     */
    public MipTourCollection getBytourIdAndCollectionId(MipTourCollection MipTourCollection);

    public List<MipTourCollection> selectByExample(MipTourCollectionExample example);

    public int updateById(MipTourCollection MipTourCollection);

    /**
     * 根据主表id，获取藏品列表
     * @param tourId
     * @return
     */
    public List<MipTourCollectionDto> getListBytourId(String tourId);

    public int getMaxSort(String tourId);

    public int batchSave(List<MipTourCollection> list);

    public List<MipTour> selectTopicByCollection(String collectionId);

    public int deleteBytourId(MipTourCollection MipTourCollection);

    /**
     * 藏品取消公开后，删除专题中的藏品
     * @param collectionIds
     * @return
     */
    public int deleteByCollectionId(List<String> collectionIds);

    /**
     * 根据多个专题id，获取藏品列表
     * @param topics
     * @return
     */
    public List<MipTourCollectionDto> getListBytourIds(List<String> topics);

}
