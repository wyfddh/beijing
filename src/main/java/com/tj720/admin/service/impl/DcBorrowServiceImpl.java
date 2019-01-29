package com.tj720.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.DcBorrowMapper;
import com.tj720.admin.model.DcBorrow;
import com.tj720.admin.model.DcBorrowExample;
import com.tj720.admin.model.DcBorrowExample.Criteria;
import com.tj720.admin.service.DcBorrowService;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;

@Service
public class DcBorrowServiceImpl implements DcBorrowService {

	@Autowired
	private DcBorrowMapper dcBorrowMapper;

	@Override
	public List<DcBorrow> listDcBorrow(DcBorrow dcBorrow,Page page) {
		DcBorrowExample example = new DcBorrowExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo((byte)1);
		//条件
		//名称
		if(!MyString.isEmpty(dcBorrow.getCollectionName())) {
			createCriteria.andCollectionNameLike("%"+dcBorrow.getCollectionName()+"%");
		}
		//普查编号
		if(!MyString.isEmpty(dcBorrow.getGsNo())) {
			createCriteria.andGsNoEqualTo(dcBorrow.getGsNo());
		}
		//年代
		if(!MyString.isEmpty(dcBorrow.getYear())) {
			createCriteria.andYearEqualTo(dcBorrow.getYear());
		}
		//收藏单位
		if(!MyString.isEmpty(dcBorrow.getCollectionUnit())) {
			createCriteria.andCollectionUnitEqualTo(dcBorrow.getCollectionUnit());
		}
		//文物类别
		if(!MyString.isEmpty(dcBorrow.getWenwuType())) {
			createCriteria.andWenwuTypeEqualTo(dcBorrow.getWenwuType());
		}
		//文物或化石
		if(!MyString.isEmpty(dcBorrow.getCollectionType())) {
			createCriteria.andCollectionTypeEqualTo(dcBorrow.getCollectionType());
		}
		int countByExample = dcBorrowMapper.countByExample(example);
		page.setAllRow(countByExample);
		example.setStartPage(page.getStart());
		example.setSize(page.getSize());
		return dcBorrowMapper.selectByExample(example);
	}

	@Override
	public int getDcBorrowByCollectionId(String collectionId) {
		DcBorrowExample example = new DcBorrowExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCollectionIdEqualTo(collectionId);
		List<DcBorrow> list = dcBorrowMapper.selectByExample(example);
		if(!MyString.isEmpty(list)){
			return 1;
		}
		return 0;
	}

	@Override
	public int insertBorrow(DcBorrow dcBorrow) {
		return dcBorrowMapper.insert(dcBorrow);
	}

	@Override
	public DcBorrow getDcBorrow(String collectionId) {
		DcBorrowExample example = new DcBorrowExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCollectionIdEqualTo(collectionId);
		List<DcBorrow> list = dcBorrowMapper.selectByExample(example);
		if(!MyString.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}

	@Override
	public int delectBorrow(String id) {
		return dcBorrowMapper.deleteByPrimaryKey(id);
	}
}
