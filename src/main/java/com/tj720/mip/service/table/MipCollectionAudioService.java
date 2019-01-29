package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipCollectionAudioDao;
import com.tj720.mip.inter.service.table.IMipCollectionAudioService;
import com.tj720.mip.model.MipCollectionAudio;

@Service
public class MipCollectionAudioService extends BaseService<MipCollectionAudio> implements IMipCollectionAudioService{

	@Resource(name="mipCollectionAudioDao")
	IMipCollectionAudioDao mipCollectionAudioDao;
	
	@Resource(name="mipCollectionAudioDao")
	public void setDao(IBaseDao<MipCollectionAudio> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipCollectionAudio get(String id){
		MipCollectionAudio model = mipCollectionAudioDao.get(id);
		if(model == null)
			 return new MipCollectionAudio();
		return model;
	}

}
