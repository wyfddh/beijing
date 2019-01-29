package com.tj720.admin.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.CCompanyMapper;
import com.tj720.admin.dto.CCompanyDto;
import com.tj720.admin.model.CCompany;
import com.tj720.admin.model.CCompanyExample;
import com.tj720.admin.model.CCompanyExample.Criteria;
import com.tj720.admin.service.CCompanyService;
import com.tj720.admin.service.CProductService;
import com.tj720.admin.service.WenChuangService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Service("cCompanyServiceImpl")
public class CCompanyServiceImpl extends BaseServiceImpl<CCompany> implements CCompanyService {

	@Autowired
	private CCompanyMapper cCompanyMapper;
	@Autowired
	private Config config;
	@Autowired
	private WenChuangService wenChuangService;
	@Autowired
	private CProductService cProductService;
	
	@Override
	public BaseDao<CCompany> getBaseDao() {
		return cCompanyMapper;
	}

	@Override
	public CCompanyDto getDetail(String id) throws IllegalAccessException, InvocationTargetException {
		String comId = id;
		//查询用户详细信息
		CCompanyDto cCompanyDto = new CCompanyDto();
		CCompany cCompany = cCompanyMapper.selectByPrimaryKey(comId);
		if (!MyString.isEmpty(cCompany)) {
			if (cCompany.getIsEnable() == 0) {
				cCompanyDto.setIsEnable(cCompany.getIsEnable());
			}
			if (cCompany.getIsEnable() == 1) {
				BeanUtils.copyProperties(cCompanyDto, cCompany);
				if (!MyString.isEmpty(cCompany.getLogoSrc())) {
					cCompanyDto.setLogoUrl(config.getRootUrl() + cCompany.getLogoSrc());
				}
				if (!MyString.isEmpty(cCompany.getLicenseSrc())) {
					cCompanyDto.setLicenseUrl(config.getRootUrl() + cCompany.getLicenseSrc());
				}
			}
				cCompanyDto.setVideoSrc(cCompany.getVideoSrc());
		}
		return cCompanyDto;
	}

	@Override
	public Map getAllCompanies(Page page, String companyName, String phone) {
		HashMap<String,Object> map = new HashMap<String, Object>();
		CCompanyExample example = new CCompanyExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusGreaterThan(1);
		if (!MyString.isEmpty(companyName)) {
			criteria.andCompanyNameLike("%" + companyName + "%");
		}
		if (!MyString.isEmpty(phone)) {
			criteria.andPhoneLike("%" + phone + "%");
		}
		int count = cCompanyMapper.countByExample(example);
		page.setAllRow(count);
		
		String order = "create_time desc";
		example.setOrderByClause(order);
		example.setPageSize(page.getSize());
		example.setStartRow(page.getStart());
		List<CCompany> list = cCompanyMapper.selectByExample(example);
		ArrayList<CCompanyDto> dtoList = new ArrayList<CCompanyDto>();
		if (!MyString.isEmpty(list)) {
			for (CCompany cCompany : list) {
				CCompanyDto dto = new CCompanyDto();
				dto.setId(cCompany.getId());
				dto.setCompanyName(cCompany.getCompanyName());
				dto.setPhone(cCompany.getPhone());
				String createTimeStr = DateUtil.StringToString(cCompany.getCreateTime(), DateStyle.YYYY_MM_DD_HH_MM);
				dto.setCreateTime(createTimeStr);
				dto.setStatus(cCompany.getStatus());
				dto.setIsEnable(cCompany.getIsEnable());
				dto.setVideoSrc(cCompany.getVideoSrc());
				dtoList.add(dto);
			}
		}
		map.put("page", page);
		map.put("dtoList", dtoList);
		return map;
	}

	@Override
	public int enable(String id) {
		CCompany cCompany = new CCompany();
		cCompany.setId(id);
		cCompany.setIsEnable(1);
		int update = cCompanyMapper.updateByPrimaryKeySelective(cCompany);
		//启用企业下的文创
		int updateWenChuang = wenChuangService.updatebyCompanyId(id, (byte)1);
		//启用企业下的产品
		int updateCP = cProductService.updateByCompanyId(id, (byte)1);
		
		if (update >0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int notEnable(String id) {
		CCompany cCompany = new CCompany();
		cCompany.setId(id);
		cCompany.setIsEnable(0);
		int update = cCompanyMapper.updateByPrimaryKeySelective(cCompany);
		//停用企业下的文创
		int updateWenChuang = wenChuangService.updatebyCompanyId(id, (byte)-127);
		//停用企业下的产品
		int updateCP = cProductService.updateByCompanyId(id, (byte)-127);
		if (update >0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Map getCheckCCompanies(Page page, String companyName, int status, String categoryName) throws IllegalAccessException, InvocationTargetException {
		HashMap<String,Object> map = new HashMap<String, Object>();
		CCompanyExample example = new CCompanyExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(1);
		if (status == 2) {
			criteria.andStatusEqualTo(status);
		}else if(status == 3){
			criteria.andStatusGreaterThanOrEqualTo(status);
		}else {
			criteria.andStatusGreaterThan(status);
		}
		criteria.andStatusLessThan(5);
		if (!MyString.isEmpty(companyName)) {
			criteria.andCompanyNameLike("%" + companyName + "%");
		}
		if (!MyString.isEmpty(categoryName)) {
			criteria.andCategoryNameEqualTo(categoryName);
		}
		int count = cCompanyMapper.countByExample(example);
		page.setAllRow(count);
		
		example.setPageSize(page.getSize());
		example.setStartRow(page.getStart());
		String order = "modify_time desc";
		example.setOrderByClause(order);
		
		List<CCompany> list = cCompanyMapper.selectByExample(example);
		ArrayList<CCompanyDto> dtoList = new ArrayList<CCompanyDto>();
		
		if (!MyString.isEmpty(list)) {
			for (CCompany cCompany : list) {
				CCompanyDto dto = new CCompanyDto();
				BeanUtils.copyProperties(dto, cCompany);
				//设置图片
				String licenseSrc = cCompany.getLicenseSrc();
				if (!MyString.isEmpty(licenseSrc)) {
					dto.setLicenseUrl(config.getRootUrl() + licenseSrc);
				} else {
					dto.setLicenseUrl("");
				}
				dtoList.add(dto);
			}
		}
		map.put("page", page);
		map.put("dtoList", dtoList);
		return map;
	}

	@Override
	public int checkCCompany(String id, String auditMsg, int status) {
		CCompany cCompany = new CCompany();
		cCompany.setId(id);
		cCompany.setAuditMsg(auditMsg);
		cCompany.setStatus(status);
		int upate = cCompanyMapper.updateByPrimaryKeySelective(cCompany);
		return upate;
	}

}
