package com.tj720.admin.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.model.MipOpenCollectionInfo;
import com.tj720.mip.service.table.MipOpenCollectionInfoService;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dao.map.CurationChapterMapper;
import com.tj720.admin.dto.CurationChapterDto;
import com.tj720.admin.model.Curation;
import com.tj720.admin.model.CurationChapter;
import com.tj720.admin.model.CurationChapterCollection;
import com.tj720.admin.model.CurationChapterExample;
import com.tj720.admin.model.CurationChapterExample.Criteria;
import com.tj720.admin.model.MipPicture;
import com.tj720.admin.service.CurationChapterCollectionService;
import com.tj720.admin.service.CurationChapterService;
import com.tj720.admin.service.ExtCurationService;
import com.tj720.admin.service.PictureService;

@Service
public class CurationChapterServiceImpl extends BaseServiceImpl<CurationChapter> implements CurationChapterService {

	@Autowired
	private CurationChapterMapper curationChapterMapper;
	@Autowired
	private CurationChapterCollectionService curationChapterCollectionService;
	@Autowired
	private ExtCurationService curationService;
	@Autowired
	private MipOpenCollectionInfoService mipOpenCollectionInfoService;
	@Autowired
	private PictureService pictureService;
	
	@Override
	public BaseDao<CurationChapter> getBaseDao() {
		return curationChapterMapper;
	}

	@Override
	public JsonResult saveCurationChapter(CurationChapterDto curationChapter) throws IllegalAccessException, InvocationTargetException {
		CurationChapter chapter = new CurationChapter();
		//拷贝属性
		BeanUtils.copyProperties(chapter, curationChapter);
		//设置章节id
		String id = IdUtils.nextId(CurationChapter.class.getName());
		chapter.setId(id);
		//设置时间
		chapter.setCreateTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS_NO));
		//设置状态
		chapter.setStatus("1");
		
		//保存章节的展品
		List<CurationChapterCollection> collections = curationChapter.getCollections();
		List<String> idList = new ArrayList<String>();
		if (!MyString.isEmpty(collections)) {
			for (CurationChapterCollection collection : collections) {
				//设置章节id
				collection.setChapterId(id);
				//设置id
				String cId = IdUtils.nextId(CurationChapterCollection.class.getName());
				collection.setId(cId);
				//设置时间
				collection.setCreatTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS_NO));
				//设置状态
				collection.setStatus("1");
				//保存
				int save = curationChapterCollectionService.saveCollection(collection);
				if (save < 1) {
					//保存失败，回滚，删除已保存的
					if (!MyString.isEmpty(idList)) {
						for (String cid : idList) {
							curationChapterCollectionService.deleteByPrimaryKey(cid);
						}
					}
					return new JsonResult(0, "保存失败");
				}
				idList.add(cId);
			}
		}
		//保存章节
		int insert = curationChapterMapper.insertSelective(chapter);
		if (insert < 1) {
			return new JsonResult(0, "保存失败");
		}
		//将第一章第一个藏品或图片作为封面存入curation中
		if ("1".equals(curationChapter.getPos())) {
			CurationChapterCollection chapterCollection = collections.get(0);
			String curationId = curationChapter.getCurationId();
			Curation curation = curationService.get(curationId);
			if ("0".equals(chapterCollection.getIsCollection())) {
				//自传图片
				curation.setImgSrc(chapterCollection.getImgSrc());
			}
			if ("1".equals(chapterCollection.getIsCollection())) {
				//收藏的藏品
				String collectionId = chapterCollection.getCollectionId();
				MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoService.get(collectionId);
				String pictureIds = mipOpenCollectionInfo.getPictureIds();
				if (!MyString.isEmpty(pictureIds)) {
					String[] pids = pictureIds.split(",");
					List<MipPicture> pictures = pictureService.findPicturesByIds(pids);
					if (!MyString.isEmpty(pictures)) {
						MipPicture picture = pictures.get(0);
						if (!MyString.isEmpty(picture.getUrl())) {
							String picUrl = picture.getUrl();
							curation.setImgSrc(picUrl);
						}
					}
				}
			}
		}
		return new JsonResult(1, "保存成功");
	}

	@Override
	public List<CurationChapterDto> findCurationChaptersByCurationId(String id) throws IllegalAccessException, InvocationTargetException {
		List<CurationChapterDto> chapterDtos = new ArrayList<CurationChapterDto>();
		CurationChapterExample example = new CurationChapterExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("pos");
		criteria.andCurationIdEqualTo(id);
		List<CurationChapter> chapters = curationChapterMapper.selectByExample(example);
		if (!MyString.isEmpty(chapters)) {
			for (CurationChapter chapter : chapters) {
				CurationChapterDto chapterDto = new CurationChapterDto();
				BeanUtils.copyProperties(chapterDto, chapter);
				//查章节下的藏品及图片
				List<CurationChapterCollection> collectionList = curationChapterCollectionService.findCollectionsByChapterId(chapter.getId());
				chapterDto.setCollections(collectionList);
				chapterDtos.add(chapterDto);
			}
		}
		return chapterDtos;
	}

}
