package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.CProduct;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Page;

public interface CProductService extends BaseService<CProduct>{
	
	List<CProduct> getProducts(Page page, String companyName,String productName);
	int undercarriageCproducts(String id,String reason);
	CProduct selectProducts(String id);
	List<CProduct> getProductList(Page page, String companyName,String productName);
//	JsonResult saveProduct(CProduct cProduct);
	int updateByCompanyId(String id, byte b);

}
