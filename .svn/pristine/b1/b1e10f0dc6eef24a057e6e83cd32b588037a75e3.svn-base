package com.tj720.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.StringUtil;
import com.tj720.admin.dao.map.CmsFriendlyLinkMapper;
import com.tj720.admin.model.CmsFriendlyLink;
import com.tj720.admin.model.CmsFriendlyLinkExample;
import com.tj720.admin.model.CmsFriendlyLinkExample.Criteria;
import com.tj720.admin.service.CmsFriendlyLinkService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Page;

@Service
public class CmsFriendlyLinkServiceImpl implements CmsFriendlyLinkService{

	@Autowired
	private CmsFriendlyLinkMapper cmsFriendlyLinkMapper;
	
	@Autowired
	private Config config;
	
	@Override
	public List<CmsFriendlyLink> listCmsFriendlyLink(Page page) {
		CmsFriendlyLinkExample example = new CmsFriendlyLinkExample();
		Criteria createCriteria = example.createCriteria();
		//设置只显示正常状态，不显示删除
		createCriteria.andStatusEqualTo("1");	//1-正常  0-删除
		if(page != null) {
			example.setStartPage(page.getStart());
			example.setSize(page.getSize());
			int countByExample = cmsFriendlyLinkMapper.countByExample(example);
			page.setAllRow(countByExample);
		}
		example.setOrderByClause("sequence");
		List<CmsFriendlyLink> selectByExample = cmsFriendlyLinkMapper.selectByExample(example);
		for (CmsFriendlyLink cmsFriendlyLink : selectByExample) {
			if(StringUtil.isNotEmpty(cmsFriendlyLink.getImgUrl())) {
				cmsFriendlyLink.setImgUrl(config.getImageUrl()+cmsFriendlyLink.getImgUrl());
			}
		}
		return selectByExample;
	}
	
	@Override
	public CmsFriendlyLink getCmsFriendlyLink(Integer id) {
		return cmsFriendlyLinkMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public int updateCmsFriendlyLink(CmsFriendlyLink cmsFriendlyLink) {
		return cmsFriendlyLinkMapper.updateByPrimaryKeySelective(cmsFriendlyLink);
	}
	
	@Override
	public int insertCmsFriendlyLink(CmsFriendlyLink cmsFriendlyLink) {
		return cmsFriendlyLinkMapper.insert(cmsFriendlyLink);
	}

	@Override
	public int delectCmsFriendlyLinkInfo(Integer id) {
		CmsFriendlyLink cmsFriendlyLink = new CmsFriendlyLink();
		cmsFriendlyLink.setId(id);
		cmsFriendlyLink.setStatus("0");
		return cmsFriendlyLinkMapper.updateByPrimaryKeySelective(cmsFriendlyLink);
	}

	public List<CmsFriendlyLink> selectListByExample(CmsFriendlyLinkExample cmsFriendlyLinkExample){
		return cmsFriendlyLinkMapper.selectByExample(cmsFriendlyLinkExample);
	}
}
