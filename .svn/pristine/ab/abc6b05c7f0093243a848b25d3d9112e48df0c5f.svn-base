package com.tj720.admin.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.MipOpenCulturalrelicInfoStaticMapper;
import com.tj720.admin.model.MipOpenCulturalrelicInfoStatic;
import com.tj720.admin.model.MipOpenCulturalrelicInfoStaticExample;
import com.tj720.admin.model.MipOpenCulturalrelicInfoStaticExample.Criteria;
import com.tj720.admin.service.MipOpenCulturalrelicInfoStaticService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Page;

/**
* @author chengrongkai
* @version 创建时间：2019年1月8日 上午9:11:45
* @ClassName 类名称
* @Description 类描述
*/
@Service
public class MipOpenCulturalrelicInfoStaticServiceImpl implements MipOpenCulturalrelicInfoStaticService{

@Autowired
MipOpenCulturalrelicInfoStaticMapper mipOpenCulturalrelicInfoStaticMapper;
	@Override
	public JsonResult getStaticData(HashMap<String,Object> condition, Page page) {
		int countStaticData = mipOpenCulturalrelicInfoStaticMapper.countStaticData(condition);
		page.setAllRow(countStaticData);
		List<MipOpenCulturalrelicInfoStatic> list = mipOpenCulturalrelicInfoStaticMapper.getStaticData(condition);
		return new JsonResult(1,list);
	}
	/* (non-Javadoc)
	 * @see com.tj720.admin.service.MipOpenCulturalrelicInfoStaticService#get(java.lang.String)
	 */
	@Override
	public JsonResult get(String id) {
		MipOpenCulturalrelicInfoStatic MipOpenCulturalrelicInfoStatic = mipOpenCulturalrelicInfoStaticMapper.getDetail(id);
		return new JsonResult(1,MipOpenCulturalrelicInfoStatic);
	}
	
	
}
