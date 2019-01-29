package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipCollectionAudioMapper;
import com.tj720.admin.model.MipCollectionAudio;
import com.tj720.admin.model.MipCollectionAudioExample;
import com.tj720.admin.service.IAudioSearchService;

@Service("audioSearchServiceImpl")
public class AudioSearchServiceImpl extends BaseServiceImpl<MipCollectionAudio> implements IAudioSearchService{

	
	@Autowired
	MipCollectionAudioMapper mipCollectionAudioMapper;
	
	@Override
	public BaseDao<MipCollectionAudio> getBaseDao() {
		// TODO Auto-generated method stub
		return mipCollectionAudioMapper;
	}

	@Override
	public List<MipCollectionAudio> getUserList(MipCollectionAudioExample curation) {
		List<MipCollectionAudio> list = new ArrayList<MipCollectionAudio>();
		list = mipCollectionAudioMapper.selectAllExample(curation);
		return list;
	}

	@Override
	public int allPage(MipCollectionAudioExample curation) {
		int total = mipCollectionAudioMapper.countByExample(curation);
		return total;
	}

	@Override
	public int updateAudio(MipCollectionAudio record) {
		int a = mipCollectionAudioMapper.updateByPrimaryKeySelective(record);
		return a;
	}

}
