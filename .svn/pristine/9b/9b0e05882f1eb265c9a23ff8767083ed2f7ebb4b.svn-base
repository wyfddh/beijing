package com.tj720.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tj720.admin.model.GovLegalType;

@Service
public interface GovLegalTypeService {

	List<GovLegalType> getFirstKindList();

	Integer countList(GovLegalType govLegalType);

	List<GovLegalType> getList(Map<String, Object> map);

	GovLegalType getById(String id);

	void save(GovLegalType govLegalType);

	void delById(String id);

	void delAllById(String id);

	List<GovLegalType> getSecondKindList(String firstKindId);

	List<GovLegalType> getAllKind();

	void update(GovLegalType govLegalType);

	List<GovLegalType> getKindList();


}
