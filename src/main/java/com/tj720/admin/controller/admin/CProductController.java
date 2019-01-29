package com.tj720.admin.controller.admin;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.model.CProduct;
import com.tj720.admin.service.CProductService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;


@RequestMapping("/cProduct")
@Controller
public class CProductController {

	@Autowired
	Config config;
	
	@Autowired
	CProductService cProductService;
	
	@RequestMapping("/getCproductsList")
	@AuthPassport(authority = "SystemAdmin")
	public String CproductList(ModelMap modelMap,@RequestParam(defaultValue="10") int size, @RequestParam(defaultValue="1") int currentPage, String companyName,String productName){
		try {
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
			List<CProduct> result = cProductService.getProductList(page,companyName,productName);
			modelMap.put("list", result);
			modelMap.put("page", page);
			return "/WEB-INF/back/supplier/ProductList.jsp";
		} catch (Exception e) {
			return "/WEB-INF/back/error.jsp";
		}
	}
	
	@RequestMapping("/getCpoducts")
	@AuthPassport(authority = "SystemAdmin")
	public String getCproduct(ModelMap modelMap,String id){
		try {
			CProduct cProduct = cProductService.selectProducts(id);
			if(StringUtils.isNotBlank(cProduct.getImgSrc())) {
				cProduct.setImgSrc(config.getRootUrl() + cProduct.getImgSrc());
			}
			modelMap.put("product", cProduct);
		} catch (Exception e) {
			e.printStackTrace();
			return "/WEB-INF/back/error.jsp";
		}
		return "/WEB-INF/back/supplier/comDetail.jsp";
	}
	@ResponseBody
	@RequestMapping("/undercarriageCproducts")
	@AuthPassport(authority = "SystemAdmin")
	public String undercarriageCproducts(ModelMap modelMap,String id,String reason){
			int a = cProductService.undercarriageCproducts(id,reason);
			return a+"";
	}
}
