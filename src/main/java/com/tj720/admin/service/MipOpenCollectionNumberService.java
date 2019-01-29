package com.tj720.admin.service;

import com.tj720.admin.model.MipOpenCollectionNumber;

public interface MipOpenCollectionNumberService {
	void insert(MipOpenCollectionNumber mipOpenCollectionNumber);
	int selectNumber(String id);
	int selectModel(String id);


}
