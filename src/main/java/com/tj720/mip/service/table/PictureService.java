package com.tj720.mip.service.table;

import com.tj720.admin.dao.map.MipPictureMapper;
import com.tj720.admin.model.MipPicture;
import com.tj720.admin.model.MipPictureExample;
import com.tj720.mip.dao.PictureDao;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.inter.service.tool.ILuceneService;
import com.tj720.mip.model.Picture;
import com.tj720.mip.springbeans.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PictureService extends BaseService<Picture>
		implements IPictureService ,ILuceneService<Picture>{

	@Resource(name="pictureDao")
	PictureDao pictureDao;
	
	@Resource(name="pictureDao")
	public void setDao(IBaseDao<Picture> dao ) {
		super.setDao(dao);
	}

	@Autowired
    private MipPictureMapper mipPictureMapper;
	@Autowired
    private Config config;
	
	@Override
	@Transactional
	public Picture get(String id){
		Picture model = pictureDao.get(id);
		if(model == null)
			 return new Picture();
		return model;
	}

	@Override
	@Transactional
	public List<Picture> getAll() {
		return pictureDao.findByMap(null, null, null);
	}
	@Transactional
	public Picture getUrl(String hql){
		Picture model = pictureDao.getByHql(hql);
		if(model == null)
			 return new Picture();
		return model;
	}

    @Override
    public List<String> getUrlsByIds(String[] split) {
        MipPictureExample example = new MipPictureExample();
        MipPictureExample.Criteria criteria = example.createCriteria();
        ArrayList<String> strings = new ArrayList<>();
        for (String s : split) {
            strings.add(s);
        }
        criteria.andIdIn(strings);
        List<MipPicture> mipPictures = mipPictureMapper.selectByExample(example);
        strings.clear();
        for (MipPicture mipPicture : mipPictures) {
            if (mipPicture.getUrl().indexOf("http") == 0) {
                strings.add(mipPicture.getUrl());
            }else {
                strings.add(config.getImageUrl() + mipPicture.getUrl());
            }
        }
        return strings;
    }
}
