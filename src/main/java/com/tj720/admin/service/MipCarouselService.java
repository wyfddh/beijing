package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.MipCarouselExample;
import com.tj720.admin.model.MipCarousel;


public interface MipCarouselService extends BaseService<MipCarousel>{
	void insertCarouselInfo(MipCarousel carousel);
	void delectCarouselInfo(String id);
	List<MipCarousel> getCarouselList(String userId);
	/**
	 * 根据轮播图位置获取轮播图
	 * @param userId
	 * @param level
	 * @param carouselPositionId
	 * @return
	 */
	List<MipCarousel> getCarouselList(String userId,String carouselPositionId);
	MipCarousel getCarousel(String id);
	void updateCarousel(MipCarousel carousel);
	MipCarousel getCarouselInfo(String uId,String carouselPositionId);
	
	/**
	 * 根据传入条件进行查找
	 * @param carouselPositionId
	 * @return
	 */
	List<MipCarousel> getCarouselList(MipCarouselExample mipCarouselExample);

}
