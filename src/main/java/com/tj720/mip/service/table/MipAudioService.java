package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.MipAudioDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipAudioDao;
import com.tj720.mip.inter.service.table.IMipAudioService;
import com.tj720.mip.model.MipAudio;

@Service
public class MipAudioService extends BaseService<MipAudio> implements IMipAudioService{

	@Resource(name="mipAudioDao")
	IMipAudioDao mipAudioDao;
	
	@Resource(name="mipAudioDao")
	public void setDao(IBaseDao<MipAudio> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipAudio get(String id){
		MipAudio model = mipAudioDao.get(id);
		if(model == null)
			 return new MipAudio();
		return model;
	}

}
