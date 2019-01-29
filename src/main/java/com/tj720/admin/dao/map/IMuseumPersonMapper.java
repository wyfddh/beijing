package com.tj720.admin.dao.map;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tj720.admin.dto.MuseumPersonDto;
import com.tj720.admin.dto.PersonAwardRecordDto;
import com.tj720.admin.dto.PersonCertificationDto;

/**
 * 博物馆基础资料DAO接口
 * @author chenshiya
 * @version 2018-05-17
 */
@Repository("museumPersonDao")
public interface IMuseumPersonMapper {

	public Integer getCount(Map<String,Object> map);
	
    public List<MuseumPersonDto> selectList(Map<String,Object> map);

    public MuseumPersonDto selectForm(String personId);

    public void insert(MuseumPersonDto personDto);

    public void update(MuseumPersonDto personDto);

    public int deleteByLogic(String id);

    public List<PersonAwardRecordDto> selectAwardList(String personId);

    public List<PersonCertificationDto> selectCertificationList(String personId);

    public void insertCertification(PersonCertificationDto certificationInfo);

    public void updateCertification(PersonCertificationDto certificationInfo);

    public int deleteCertification(String id);

    public void insertAward(PersonAwardRecordDto awardRecordInfo);

    public void updateAward(PersonAwardRecordDto awardRecordInfo);

    public int deleteAward(String id);
    
    public List<MuseumPersonDto> selectAllPerson(String museumId,String flag);
    
    public void deleteBase(String museumId,String flag);
}