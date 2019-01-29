package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dao.MipCommentDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.IMipCommentService;
import com.tj720.mip.model.MipComment;

@Service
public class MipCommentService extends BaseService<MipComment> implements IMipCommentService{

	@Resource(name="mipCommentDao")
	MipCommentDao mipCommentDao;
	
	@Resource(name="mipCommentDao")
	public void setDao(IBaseDao<MipComment> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipComment get(String id){
		MipComment model = mipCommentDao.get(id);
		if(model == null)
			 return new MipComment();
		return model;
	}

}
