package com.tj720.admin.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tj720.admin.model.GmWork;

@Service
public interface GmWorkService {



	int getMaxYears(String museumId);

	void save(GmWork gmWork);

	List<GmWork> findListByMuseumId(String museumId);

	GmWork selectById(String id);

	void update(GmWork gmWork);

	int selectAll(String gmYear);

	List<GmWork> findList1(HashMap<String, Object> map);

	Integer countList(HashMap<String, Object> map);

	Integer countMySummary(HashMap<String, Object> map);

	List<GmWork> findMySummary(HashMap<String, Object> map);


}
