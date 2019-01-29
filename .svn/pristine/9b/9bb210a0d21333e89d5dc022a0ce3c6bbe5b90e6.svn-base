package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipAudioLikeDao;
import com.tj720.mip.inter.service.table.IMipAudioLikeService;
import com.tj720.mip.model.MipAudioLike;

@Service
public class MipAudioLikeService extends BaseService<MipAudioLike> implements IMipAudioLikeService{

	@Resource(name="mipAudioLikeDao")
	IMipAudioLikeDao mipAudioLikeDao;
	
	@Resource(name="mipAudioLikeDao")
	public void setDao(IBaseDao<MipAudioLike> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipAudioLike get(String id){
		MipAudioLike model = mipAudioLikeDao.get(id);
		if(model == null)
			 return new MipAudioLike();
		return model;
	}

}
