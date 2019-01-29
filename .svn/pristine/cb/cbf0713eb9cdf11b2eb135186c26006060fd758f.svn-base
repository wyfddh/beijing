package com.tj720.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.MipCollectionAudioMapper;
import com.tj720.admin.model.MipCollectionAudio;
import com.tj720.admin.model.MipCollectionAudioExample;
import com.tj720.admin.model.MipCollectionAudioExample.Criteria;
import com.tj720.admin.service.MipCollectionAudioService;

@Service("MipCollectionAudioServiceImpl")
public class MipCollectionAudioServiceImpl extends BaseServiceImpl<MipCollectionAudio> implements MipCollectionAudioService{

	@Autowired
	MipCollectionAudioMapper mipCollectionAudioMapper;
	@Override
	public BaseDao<MipCollectionAudio> getBaseDao() {
		return mipCollectionAudioMapper;
	}
	
	@Override
	public MipCollectionAudio getOfficialAudio(String collectionId, byte isOfficial) {
		MipCollectionAudioExample example = new MipCollectionAudioExample();
		Criteria criteria = example.createCriteria();
		criteria.andCollectionIdEqualTo(collectionId);
		criteria.andIsOfficialEqualTo(isOfficial);
		List<MipCollectionAudio> list = mipCollectionAudioMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public void updateAudio(MipCollectionAudio audio) {
		mipCollectionAudioMapper.updateByPrimaryKey(audio);
		
	}
	@Override
	public void insertAudio(MipCollectionAudio audio) {
		mipCollectionAudioMapper.insert(audio);
	}

}
