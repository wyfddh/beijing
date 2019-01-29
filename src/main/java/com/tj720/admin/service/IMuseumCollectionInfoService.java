package com.tj720.admin.service;

import com.tj720.admin.dto.MuseumCollectionDto;

public interface IMuseumCollectionInfoService {

    public MuseumCollectionDto selectForm(String museumId,String flag);

    public void insert(MuseumCollectionDto collectionDto);

    public void update(MuseumCollectionDto collectionDto);

    public void deleteBase(String museumId, String flag);
    
    public void updateFlag(MuseumCollectionDto collectionDto);
}
