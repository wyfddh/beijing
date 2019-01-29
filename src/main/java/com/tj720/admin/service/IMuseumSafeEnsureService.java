package com.tj720.admin.service;

import com.tj720.admin.dto.MuseumSafeEnsureDto;

public interface IMuseumSafeEnsureService {

    public MuseumSafeEnsureDto selectForm(String museumId,String flag);

    public int save(MuseumSafeEnsureDto info);
    
    public void deleteBase(String museumId,String flag);
    
    public void updateFlag(MuseumSafeEnsureDto info);
    
    public void insertSafeEnsure(MuseumSafeEnsureDto info);
    
}
