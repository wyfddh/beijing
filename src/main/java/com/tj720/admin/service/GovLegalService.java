package com.tj720.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tj720.admin.model.GovLegal;
@Service
public interface GovLegalService {

	List<GovLegal> getList(Map<String, Object> map);

	List<GovLegal> getPublisherList();

	Integer countList(GovLegal govLegal);

	void save(GovLegal govLegal);

	void update(GovLegal govLegal);

	void delete(String id);

	Integer countByLegalTypeId(String id);

	List<GovLegal> getGovListForDesk(Map<String,String> map);
	GovLegal getGovByid(String id);

}
