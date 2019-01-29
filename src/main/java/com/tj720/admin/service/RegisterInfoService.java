package com.tj720.admin.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tj720.admin.model.RegisterInfo;
import com.tj720.mip.model.MipOrganization;


@Service
public interface RegisterInfoService {
	
	
	//查询最新年度
	int getMaxYears(String museumId);
	void save(RegisterInfo registerInfo);
	RegisterInfo getById(String id);
	//更新
	void update(RegisterInfo registerInfo);
	
	List<RegisterInfo> findListByMuseumId(String museumId);
	
	//跟上面方法传参数不一样
	List<RegisterInfo> getByEntity(RegisterInfo registerInfo);

	List<RegisterInfo> selectAll(Integer gmYear);

	int selectAllCount(String museumId);

	List<RegisterInfo> findList1(HashMap<String, Object> map);

	List<MipOrganization> selectAllCount1(String museumId);

	Integer countList1(HashMap<String, Object> map);

}
