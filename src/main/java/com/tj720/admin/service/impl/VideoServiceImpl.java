package com.tj720.admin.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.ExtVideoMapper;
import com.tj720.admin.model.ExtVideo;
import com.tj720.admin.model.ExtVideoExample;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.model.ExtVideoExample.Criteria;
import com.tj720.admin.service.VideoService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

import javassist.expr.NewArray;

@Service("VideoService")
public class VideoServiceImpl extends BaseServiceImpl<ExtVideo> implements VideoService{

	@Autowired
	Config config;
	
	@Autowired
	ExtVideoMapper extVideoMapper;
	@Override
	public BaseDao<ExtVideo> getBaseDao() {
		return extVideoMapper;
	}
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	@Override
	public List<ExtVideo> getVideoList(Page page,String orgId,byte level) {
		
		ExtVideoExample example = new ExtVideoExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("2");
		if(level==3){
			criteria.andUserIdEqualTo(orgId);
		}
		if (level == 2) {
			String[] orgList = orgId.split(",");
			List<String> orgIdList = Arrays.asList(orgList);
			criteria.andUserIdIn(orgIdList);
		}
		int count = extVideoMapper.countByExample(example);
		page.setAllRow(count);
		example.setSize(page.getSize());
		example.setStartPage(page.getStart());
		List<ExtVideo> videoList = extVideoMapper.selectByExample(example);
		if(videoList.size()>0){
			for(ExtVideo video : videoList){
				video.setImgUrl(config.getRootUrl()+video.getImgUrl());
				video.setUrl(config.getRootUrl()+video.getUrl());
			}
		}
		return videoList;
	}
	@Override
	public int saveVideo(ExtVideo extVideo,String orgId) {
		extVideo.setStatus("2");
		String id = extVideo.getId();
		int result = 0;
		ExtVideo video = extVideoMapper.selectByPrimaryKey(id);
		if(!MyString.isEmpty(video)){
			try {
				video.setName(extVideo.getName());
				video.setImgUrl(extVideo.getImgUrl());
				video.setUrl(extVideo.getUrl());
			} catch (Exception e) {
				e.printStackTrace();
			}
			video.setModifyTime(sdf.format(new Date()));
			result = extVideoMapper.updateByPrimaryKey(video);
		}else{
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			extVideo.setId(uuid);
			extVideo.setStatus("2");
			extVideo.setUserId(orgId);
			extVideo.setCreateTime(sdf.format(new Date()));
			extVideo.setModifyTime(sdf.format(new Date()));
			result = extVideoMapper.insert(extVideo);
		}
		return result;
	}
	@Override
	public int delectVideo(String id) {
		int result = 0;
		if(!MyString.isEmpty(id)){
			ExtVideo video = extVideoMapper.selectByPrimaryKey(id);
			if(!MyString.isEmpty(video)){
				video.setStatus("0");
				result = extVideoMapper.updateByPrimaryKey(video);
			}
		}
		return result;
		
	}
	@Override
	public ExtVideo getVideo(String id) {
		ExtVideo video = null;
		if(!MyString.isEmpty(id)){
			video = extVideoMapper.selectByPrimaryKey(id);
		}
		return video;
	}

}
