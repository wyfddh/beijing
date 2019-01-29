package com.tj720.admin.dao.map;


import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumCollectionDto;

/**
 * 藏品信息DAO接口
 * @author chenshiya
 * @version 2018-05-17
 */
@Repository("museumCollectionDao")
public interface MuseumCollectionInfoMapper {

    public MuseumCollectionDto selectForm(String museumId,String flag);

    public void insert(MuseumCollectionDto collectionDto);

    public void update(MuseumCollectionDto collectionDto);

    public void deleteBase(String museumId,String flag);
    
    public void updateFlag(MuseumCollectionDto collectionDto);

}