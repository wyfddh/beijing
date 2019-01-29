package com.tj720.mip.service.table;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.MipCollectDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.IMipCollectService;
import com.tj720.mip.model.MipCollect;
import com.tj720.mip.utils.Tools;

@Service
public class MipCollectService extends BaseService<MipCollect> implements IMipCollectService{

	@Resource(name="mipCollectDao")
	MipCollectDao mipCollectDao;
	
	@Resource(name="mipCollectDao")
	public void setDao(IBaseDao<MipCollect> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipCollect get(String id){
		MipCollect model = mipCollectDao.get(id);
		if(model == null)
			 return new MipCollect();
		return model;
	}

	/**
	 * 查询用户收藏列表
	 */
	@Override
	@Transactional
	public List<MipCollect> getCollectsByUid(String uid) {
		List<MipCollect> mcList = (List<MipCollect>) mipCollectDao.queryByHql("from MipCollect where uid='" + uid + "'",
				Tools.getMap());
		return mcList;
	}

}
