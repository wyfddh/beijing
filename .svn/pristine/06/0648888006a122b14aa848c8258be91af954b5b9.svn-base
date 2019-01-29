package com.tj720.mip.service.table;

import javax.annotation.Resource;

import com.tj720.admin.dao.map.MipCollectionLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipCollectionLevelDao;
import com.tj720.mip.inter.service.table.IMipCollectionLevelService;
import com.tj720.mip.model.MipCollectionLevel;

@Service
public class MipCollectionLevelService extends BaseService<MipCollectionLevel> implements IMipCollectionLevelService{

	@Resource(name="mipCollectionLevelDao")
	IMipCollectionLevelDao mipCollectionLevelDao;
	
	@Resource(name="mipCollectionLevelDao")
	public void setDao(IBaseDao<MipCollectionLevel> dao ) {
		super.setDao(dao);
	}

	@Autowired
    private MipCollectionLevelMapper mipCollectionLevelMapper;
	
	@Override
	@Transactional
	public MipCollectionLevel get(String id){
		MipCollectionLevel model = mipCollectionLevelDao.get(id);
		if(model == null)
			 return new MipCollectionLevel();
		return model;
	}

    @Override
    public com.tj720.admin.model.MipCollectionLevel getById(String id) {
        return mipCollectionLevelMapper.selectByPrimaryKey(Integer.valueOf(id));
    }
}
