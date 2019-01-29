package com.tj720.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.CProductMapper;
import com.tj720.admin.model.CProduct;
import com.tj720.admin.model.CProductExample;
import com.tj720.admin.model.CProductExample.Criteria;
import com.tj720.admin.service.CProductService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;


@Service("cProductServiceImpl")
public class CProductServiceImpl extends BaseServiceImpl<CProduct> implements CProductService {

	@Autowired
	private CProductMapper cProductMapper;
	
	@Override
	public BaseDao<CProduct> getBaseDao() {
		return cProductMapper;
	}

	@Override
	public List<CProduct> getProducts(Page page, String companyName,String productName) {
		CProductExample example = new CProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(2);
		if (!MyString.isEmpty(companyName)) {
			criteria.andProductNameLike("%" + companyName + "%");
		}
		if (!MyString.isEmpty(productName)) {
			criteria.andProductNameLike("%" + productName + "%");
		}
		int count = cProductMapper.countByExample(example);
//		countByExampleNew
		page.setAllRow(count);
		String order = "create_time desc";
		example.setOrderByClause(order);
		example.setSize(page.getSize());
		example.setStartPage(page.getStart());
//		selectByExampleList
		List<CProduct> list = cProductMapper.selectByExample(example);
		return list;
	}

	@Override
	public int undercarriageCproducts(String id,String reason) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		CProduct record = cProductMapper.selectByPrimaryKey(id);
		if(record!=null){
			record.setStatus(3);
			record.setReason(reason);
			record.setModifyTime(sdf.format(new Date()));
			int delect = cProductMapper.updateByPrimaryKey(record);
			return delect;
		}else{
			return 0;
		}
	}

	@Override
	public CProduct selectProducts(String id) {
		if(!MyString.isEmpty(id)){
			CProduct cProduct = cProductMapper.selectByPrimaryKey(id);
			return cProduct;
		}
		return null;
	}

	@Override
	public List<CProduct> getProductList(Page page, String companyName, String productName) {
		CProductExample example = new CProductExample();
		if (!MyString.isEmpty(companyName)) {
			example.setCompanyName(companyName);
		}
		if (!MyString.isEmpty(productName)) {
			example.setProductName(productName);
		}
		int count = cProductMapper.countByExampleNew(example);
		page.setAllRow(count);
		example.setSize(page.getSize());
		example.setStartPage(page.getStart());
		List<CProduct> list = cProductMapper.selectByExampleList(example);
		return list;
	}

	@Override
	public int updateByCompanyId(String id, byte b) {
		CProduct cProduct = new CProduct();
		cProduct.setIsEnable(0);
		CProductExample example = new CProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andCompayIdEqualTo(id);
		int update = cProductMapper.updateByExampleSelective(cProduct, example);
		return update;
	}
}
