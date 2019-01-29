package com.tj720.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.mip.model.MipOpenCollectionInfo;
import com.tj720.mip.service.table.MipOpenCollectionInfoService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.CurationChapterCollectionMapper;
import com.tj720.admin.model.CurationChapterCollection;
import com.tj720.admin.model.CurationChapterCollectionExample;
import com.tj720.admin.model.MipPicture;
import com.tj720.admin.model.CurationChapterCollectionExample.Criteria;
import com.tj720.admin.service.CurationChapterCollectionService;
import com.tj720.admin.service.PictureService;

@Service
public class CurationChapterCollectionServiceImpl extends BaseServiceImpl<CurationChapterCollection> implements CurationChapterCollectionService{

	@Autowired
	private CurationChapterCollectionMapper curationChapterCollectionMapper;
	@Autowired
	private MipOpenCollectionInfoService mipOpenCollectionInfoService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private Config config;
	
	@Override
	public BaseDao<CurationChapterCollection> getBaseDao() {
		return curationChapterCollectionMapper;
	}

	@Override
	public int saveCollection(CurationChapterCollection collection) {
		int insert = curationChapterCollectionMapper.insertSelective(collection);
		return insert;
	}

	@Override
	public List<CurationChapterCollection> findCollectionsByChapterId(String id) {
		CurationChapterCollectionExample example = new CurationChapterCollectionExample();
		Criteria criteria = example.createCriteria();
		criteria.andChapterIdEqualTo(id);
		example.setOrderByClause("pos");
		List<CurationChapterCollection> list = curationChapterCollectionMapper.selectByExample(example);
		if (!MyString.isEmpty(list)) {
			for (CurationChapterCollection collection : list) {
				if ("1".equals(collection.getIsCollection())) {
					//藏品
					String collectionId = collection.getCollectionId();
					MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(collectionId);
					if (!MyString.isEmpty(mipOpenCollectionInfo)) {
						collection.setDesc(mipOpenCollectionInfo.getDescription());
						collection.setName(mipOpenCollectionInfo.getName());
						if (!MyString.isEmpty(mipOpenCollectionInfo.getfAudio())) {
							collection.setAudioUrl(config.getRootUrl() + mipOpenCollectionInfo.getfAudio());
						}
						String pictureIds = mipOpenCollectionInfo.getPictureIds();
						if (!MyString.isEmpty(pictureIds)) {
							String[] pids = pictureIds.split(",");
							List<MipPicture> pictures = pictureService.findPicturesByIds(pids);
							if (!MyString.isEmpty(pictures)) {
								MipPicture picture = pictures.get(0);
								if (!MyString.isEmpty(picture.getUrl())) {
									String picUrl = picture.getUrl();
									collection.setImgSrc(config.getRootUrl() + picUrl);
								}
							}
						}
					}
				}
				if ("0".equals(collection.getIsCollection())) {
					if (!MyString.isEmpty(collection.getImgSrc())) {
						collection.setImgSrc(config.getRootUrl() + collection.getImgSrc());
					} else {
						collection.setImgSrc("");
					}
				}
			}
		}
		return list;
	}

	
	
}
