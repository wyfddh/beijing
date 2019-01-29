package com.tj720.admin.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.IMuseumPersonMapper;
import com.tj720.admin.dto.MuseumPersonDto;
import com.tj720.admin.dto.PersonAwardRecordDto;
import com.tj720.admin.dto.PersonCertificationDto;
import com.tj720.admin.service.IMuseumPersonService;
import com.tj720.mip.utils.Tools;

@Service("museumPersonService")
public class MuseumPersonServiceImpl implements IMuseumPersonService {

    @Autowired
    IMuseumPersonMapper museumPersonDao;
    
    @Override
    public Integer getCount(Map<String,Object> map){
    	return museumPersonDao.getCount(map);
    };
    //条件查询角色分页
    @Override
    public List<MuseumPersonDto> selectList(Map<String,Object> map){
        List<MuseumPersonDto> list = museumPersonDao.selectList(map);
        return list;
    };

    @Override
    public MuseumPersonDto selectForm(String personId){
        MuseumPersonDto serviceInfo = museumPersonDao.selectForm(personId);
        return serviceInfo;
    };

    public void insert(MuseumPersonDto personDto){
    	String userId = Tools.getUser().getId();
    	personDto.setCreatorId(userId);
		personDto.setCreateTime(new Date());
		personDto.setUpdateId(userId);
		personDto.setUpdateTime(new Date());
        museumPersonDao.insert(personDto);
    };

    public void update(MuseumPersonDto personDto){
    	String userId = Tools.getUser().getId();
    	personDto.setUpdateId(userId);
		personDto.setUpdateTime(new Date());
        museumPersonDao.update(personDto);
    };

    public int deleteByLogic(String id){
        return museumPersonDao.deleteByLogic(id);
    };

    public List<PersonAwardRecordDto> selectAwardList(String personId){
        List<PersonAwardRecordDto> list = museumPersonDao.selectAwardList(personId);
        return  list;
    };

    public List<PersonCertificationDto> selectCertificationList(String personId){
        List<PersonCertificationDto> list = museumPersonDao.selectCertificationList(personId);
        return  list;
    };

    public void insertCertification(PersonCertificationDto certificationInfo){
    	String userId = Tools.getUser().getId();
    	certificationInfo.setCreatorId(userId);
		certificationInfo.setCreateTime(new Date());
		certificationInfo.setUpdateId(userId);
		certificationInfo.setUpdateTime(new Date());
		certificationInfo.setId(IdUtils.nextId(certificationInfo));
        museumPersonDao.insertCertification(certificationInfo);
    };

    public void updateCertification(PersonCertificationDto certificationInfo){
    	String userId = Tools.getUser().getId();
    	certificationInfo.setUpdateId(userId);
		certificationInfo.setUpdateTime(new Date());
        museumPersonDao.updateCertification(certificationInfo);
    };

    public int deleteCertification(String id){
    	return museumPersonDao.deleteCertification(id);
    };

    public void insertAward(PersonAwardRecordDto awardRecordInfo){
    	String userId = Tools.getUser().getId();
    	awardRecordInfo.setCreatorId(userId);
		awardRecordInfo.setCreateTime(new Date());
		awardRecordInfo.setUpdateId(userId);
		awardRecordInfo.setUpdateTime(new Date());
		awardRecordInfo.setId(IdUtils.nextId(awardRecordInfo));
        museumPersonDao.insertAward(awardRecordInfo);
    };

    public void updateAward(PersonAwardRecordDto awardRecordInfo){
    	String userId = Tools.getUser().getId();
    	awardRecordInfo.setUpdateId(userId);
		awardRecordInfo.setUpdateTime(new Date());
        museumPersonDao.updateAward(awardRecordInfo);
    };

    public int deleteAward(String id){
    	return museumPersonDao.deleteAward(id);
    };
    
    public List<MuseumPersonDto> selectAllPerson(String museumId,String flag){
    	List<MuseumPersonDto> list = museumPersonDao.selectAllPerson(museumId,flag);
    	return list;
    };
    
    @Override
    public void deleteBase(String museumId, String flag){
    	museumPersonDao.deleteBase(museumId,flag);
    }
}
