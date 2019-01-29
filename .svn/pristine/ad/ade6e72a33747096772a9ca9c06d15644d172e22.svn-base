package com.tj720.mip.service.table;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.MipMuseumCarouselDao;
import com.tj720.mip.inter.service.table.MuseumCarouselService;
import com.tj720.mip.model.MipMuseumCarousel;

@Service
public class MipMuseumCarouselServiceImpl extends BaseService<MipMuseumCarousel> implements MuseumCarouselService {

	@Resource(name="mipmuseumcarouselDao")
	MipMuseumCarouselDao mipmuseumcarouselDao;
	
	@Resource(name="mipmuseumcarouselDao")
	public void setDao(IBaseDao<MipMuseumCarousel> dao) {
		super.setDao(dao);
	}

}
