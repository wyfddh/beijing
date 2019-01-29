package com.tj720.admin.dao.collection;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tj720.admin.model.collection.CollectionAttachment;

@Repository
public interface CollectionAttachmentMapper {
    int deleteByPrimaryKey(String attId);

    int insert(CollectionAttachment record);

    int insertSelective(CollectionAttachment record);

    CollectionAttachment selectByPrimaryKey(String attId);

    int updateByPrimaryKeySelective(CollectionAttachment record);

    int updateByPrimaryKey(CollectionAttachment record);

    List<CollectionAttachment> getListByRelationId(String collectionPictureid);
}