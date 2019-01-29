package com.tj720.admin.service.impl;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.CurationMapper;
import com.tj720.admin.dto.CurationChapterDto;
import com.tj720.admin.dto.CurationDto;
import com.tj720.admin.model.Curation;
import com.tj720.admin.model.CurationExample;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.service.CurationChapterService;
import com.tj720.admin.service.ExtCurationService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.TimeShowUtil;

@Service("extCurationServiceImpl")
public class ExtCurationServiceImpl extends BaseServiceImpl<Curation> implements ExtCurationService{
	
	@Autowired
	private CurationMapper curationMapper;
	@Autowired
	private Config config;
	@Autowired
	private UserService userService;
	@Autowired
	private CurationChapterService curationChapterService;
	
	@Override
	public BaseDao<Curation> getBaseDao() {
		return curationMapper;
	}
	
	
	public List<Curation> getAllCuration(CurationExample curation){
		List<Curation> list= new ArrayList<Curation>();
		list=curationMapper.selectByExample(curation);
		for(Curation cur : list){
			cur.setImgSrc(config.getRootUrl()+cur.getImgSrc());
		}
		return list;
	}


	public int updateStatus(Curation curation) {
		int a = curationMapper.updateByPrimaryKeySelective(curation);
		return a ;
	}


	@Override
	public int allPage(CurationExample curation) {
		int allPage = 0;
		allPage=curationMapper.countByExample(curation);
		return allPage;
	}


	@Override
	public CurationDto getCuration(String id) throws IllegalAccessException, InvocationTargetException {
		CurationDto curationDto = new CurationDto();
		Curation curation = curationMapper.selectByPrimaryKey(id);
		//序
		if (!MyString.isEmpty(curation)) {
			BeanUtils.copyProperties(curationDto, curation);
			if (!MyString.isEmpty(curationDto.getImgSrc())) {
				curationDto.setImgUrl(config.getRootUrl() + curationDto.getImgSrc());
			}else {
				curationDto.setImgUrl("");
			}
			//设置用户
			String userId = curation.getUserId();
			User user = userService.get(userId);
			if (!MyString.isEmpty(user)) {
				curationDto.setUserName(user.getNickName());
				String avatarurl = user.getAvatarUrl();
				if (!MyString.isEmpty(avatarurl)) {
					curationDto.setAvatarUrl(config.getRootUrl() + avatarurl);
				}
			}
		}
		//章节
		List<CurationChapterDto> chapterList = curationChapterService.findCurationChaptersByCurationId(id);
		curationDto.setCurationChapterDtos(chapterList);
		return curationDto;
		
	}


	@Override
	public List<CurationDto> getCurationList(Page page) throws IllegalAccessException, InvocationTargetException {
		List<CurationDto> curationList = new ArrayList<CurationDto>();
		CurationExample example = new CurationExample();
		
		int count = curationMapper.countByExample(example);
		page.setAllRow(count);
		example.setStartRow(page.getStart());
		example.setPageSize(page.getSize());
		List<Curation> list = curationMapper.selectByExample(example);
		if (!MyString.isEmpty(list)) {
			for (Curation curation : list) {
				CurationDto curationDto = new CurationDto();
				BeanUtils.copyProperties(curationDto, curation);
				//设置图片
				if (!MyString.isEmpty(curation.getImgSrc())) {
					curationDto.setImgUrl(config.getRootUrl() + curation.getImgSrc());
				}
				String createTime = curation.getCreateTime();
				String timeStr = DateUtil.StringToString(createTime, DateStyle.YYYY_MM_DD_HH_MM_SS_NO, DateStyle.YYYY_MM_DD_HH_MM_SS_CN);
				curationDto.setTimeStr(timeStr);
				//设置用户
				String userId = curation.getUserId();
				User user = userService.get(userId);
				if (!MyString.isEmpty(user)) {
					curationDto.setUserName(user.getNickName());
					String avatarurl = user.getAvatarUrl();
					if (!MyString.isEmpty(avatarurl)) {
						curationDto.setAvatarUrl(config.getRootUrl() + avatarurl);
					}
				}
				curationList.add(curationDto);
			}
		}
		return curationList;
	}


}
