package com.tj720.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipOpenCollectionNumberMapper;
import com.tj720.admin.model.MipOpenCollectionNumber;
import com.tj720.admin.service.MipOpenCollectionNumberService;
import com.tj720.mip.utils.MyString;
@Service("MipOpenCollectionNumberServiceImpl")
public class MipOpenCollectionNumberServiceImpl extends BaseServiceImpl<MipOpenCollectionNumber> implements MipOpenCollectionNumberService{

	@Autowired
	private MipOpenCollectionNumberMapper mip;
	@Override
	public BaseDao<MipOpenCollectionNumber> getBaseDao() {
		return mip;
	}
	@Override
	public void insert(MipOpenCollectionNumber mipOpenCollectionNumber) {
		mip.insert(mipOpenCollectionNumber);
		
	}
	@Override
	public int selectNumber(String id) {
		MipOpenCollectionNumber mipOpenCollectionNumber= mip.selectById(id);
		if(!MyString.isEmpty(mipOpenCollectionNumber)){
			
			return mipOpenCollectionNumber.getNumber();
		}
		return 0;
	}
	@Override
	public int selectModel(String id) {
		MipOpenCollectionNumber mipOpenCollectionNumber= mip.selectById(id);
		if(!MyString.isEmpty(mipOpenCollectionNumber)){
			return 1;
		}
		return 0;
	}

}
