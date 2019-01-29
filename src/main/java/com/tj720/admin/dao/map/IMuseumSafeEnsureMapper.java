package com.tj720.admin.dao.map;


import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumSafeEnsureDto;

/**
 * 安全保障DAO接口
 * @author chenshiya
 * @version 2018-07-17
 */
@Repository("safeEnsureDao")
public interface IMuseumSafeEnsureMapper {

    public MuseumSafeEnsureDto selectForm(String museumId,String flag);

    public void insert(MuseumSafeEnsureDto info);

    public void update(MuseumSafeEnsureDto info);

    public void deleteBase(String museumId,String flag);
    
    public void updateFlag(MuseumSafeEnsureDto info);
}