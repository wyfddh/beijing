package com.tj720.mip.service.table;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.authentication.MysqlClearPasswordPlugin;
import com.tj720.mip.dto.CollectionAudioDto;
import com.tj720.mip.dto.CollectionDto;
import com.tj720.mip.dto.CollectionPictureDto;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IMipAudioLikeDao;
import com.tj720.mip.inter.dao.IMipOpenCollectionInfoDao;
import com.tj720.mip.inter.service.table.ICollectionCategoryService;
import com.tj720.mip.inter.service.table.IMipAudioLikeService;
import com.tj720.mip.inter.service.table.IMipCollectService;
import com.tj720.mip.inter.service.table.IMipCollectionAudioService;
import com.tj720.mip.inter.service.table.IMipOpenCollectionInfoService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.inter.service.table.IYearTypeService;
import com.tj720.mip.model.CollectionCategory;
import com.tj720.mip.model.MipAudioLike;
import com.tj720.mip.model.MipCollect;
import com.tj720.mip.model.MipCollectionAudio;
import com.tj720.mip.model.MipOpenCollectionInfo;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.User;
import com.tj720.mip.model.YearType;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.TimeShowUtil;
import com.tj720.mip.utils.Tools;

@Service
public class MipOpenCollectionInfoService extends BaseService<MipOpenCollectionInfo> implements IMipOpenCollectionInfoService{

	@Autowired
	private Config config;
	@Autowired
	private IPictureService pictureService;
	@Autowired
	private IYearTypeService yearTypeService;
	@Autowired
	private ICollectionCategoryService collectionCategoryService;
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	@Autowired
	private IMipCollectionAudioService mipCollectionAudioService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IMipCollectService mipCollectService;
	@Autowired
	private IMipAudioLikeService mipAudioLikeService;
	
	@Resource(name="mipOpenCollectionInfoDao")
	IMipOpenCollectionInfoDao mipOpenCollectionInfoDao;
	
	@Resource(name="mipOpenCollectionInfoDao")
	public void setDao(IBaseDao<MipOpenCollectionInfo> dao ) {
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public MipOpenCollectionInfo get(String id){
		MipOpenCollectionInfo model = mipOpenCollectionInfoDao.get(id);
		if(model == null)
			 return new MipOpenCollectionInfo();
		return model;
	}

	@SuppressWarnings("finally")
	@Override
	@Transactional
	public JsonResult getList(String hql, Page page) {
		List<CollectionPictureDto> collections = new ArrayList<CollectionPictureDto>();
		List<MipOpenCollectionInfo> mipOpenCollectionInfos = (List<MipOpenCollectionInfo>) mipOpenCollectionInfoDao.queryByHql(hql, Tools.getMap(), page);
		List<MipCollect> mcList = new ArrayList<MipCollect>();
		try {
			// 获取用户登录信息
			LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
			String uid = cacheUser.getId();
			// 查询用户收藏列表
			mcList = (List<MipCollect>) mipCollectService.queryByHql("from MipCollect where uid='" + uid + "'",
					Tools.getMap());
		} finally {
			//遍历藏品集合，设置数据
			if (!MyString.isEmpty(mipOpenCollectionInfos)) {
				for (MipOpenCollectionInfo collection : mipOpenCollectionInfos) {
					CollectionPictureDto collectionPictureDto = new CollectionPictureDto();
					collectionPictureDto.setId(collection.getId());
					collectionPictureDto.setName(collection.getName());
					collectionPictureDto.setThreeD(collection.getThreeDimensionalCollection());
					collectionPictureDto.setDescription(collection.getDescription());
					collectionPictureDto.setCollectionType(collection.getCollectionType());
					if (!MyString.isEmpty(collection.getfAudio())) {
						collectionPictureDto.setAudioUrl(config.getRootUrl() + collection.getfAudio());
					}
					// 判断是否收藏信息
					if (!MyString.isEmpty(mcList)) {
						for (MipCollect mc : mcList) {
							if (collection.getId().equals(mc.getCid()) || collection.getId().equals(mc.getFid())) {
								collectionPictureDto.setIsCollected((byte) 1);
							}
						}
					}
					//重新设置级别
					String tranLevel = collectionLevelTran(collection);
					collectionPictureDto.setCollectionsLevel(tranLevel);
					//重设年代
					String yearName = colletionYearTran(collection);
					collectionPictureDto.setYearType(yearName);
					//重设类别
					String categoryName = collectionCategoryTran(collection);
					collectionPictureDto.setCollectionsCategory(categoryName);
					//重设博物馆名称
					String collectionUnit = collection.getCollectionUnit();
					String orgName = collectionOrgTran(collectionUnit);
					collectionPictureDto.setMuseumId(collectionUnit);
					collectionPictureDto.setMuseumName(orgName);
					//重设图片
					String pictureIds = collection.getPictureIds();
					if (!MyString.isEmpty(pictureIds)) {
						Picture picture = pictureUrlTran(pictureIds);
						collectionPictureDto.setPicture(picture);
					}
					//设置音频
					Page page2 = new Page(10);
					String hql_audio = "from MipCollectionAudio where status > 0 and collectionId = '"+ collection.getId() +"' order by publishTime desc, likeCounts desc";
					List<MipCollectionAudio> audios = (List<MipCollectionAudio>) mipCollectionAudioService.queryByHql(hql_audio, Tools.getMap(), page2);
					//处理音频
					ArrayList<CollectionAudioDto> audioList = collectionAudioTran(orgName, audios);
					collectionPictureDto.setAudios(audioList);
					collections.add(collectionPictureDto);
				}
			}
			return new JsonResult(1, collections, page);
		}
	}
	
	/**
	 * 查询精品藏品
	 */
	@Override
	@Transactional
	public List<CollectionDto> getHighCollections(String id, Page page) {
		List<CollectionDto> collectionDtos = new ArrayList<CollectionDto>();
		List<MipOpenCollectionInfo> collectionInfos = mipOpenCollectionInfoDao.findByMap("new MipOpenCollectionInfo(id, name, pictureIds)", Tools.getMap("isHighQuality",2,"collectionUnit",id), page, "sequence desc, clickCounts desc");
		if (!MyString.isEmpty(collectionInfos)) {
			for (MipOpenCollectionInfo collectionInfo : collectionInfos) {
				CollectionDto collectionDto = new CollectionDto();
				collectionDto.setId(collectionInfo.getId());
				collectionDto.setName(collectionInfo.getName());
				String pictureIds = collectionInfo.getPictureIds();
				if (!MyString.isEmpty(pictureIds)) {
					Picture picture = this.pictureUrlTran(pictureIds);
					if (!MyString.isEmpty(picture)) {
						String thumb3 = picture.getThumb3();
						if (!MyString.isEmpty(thumb3)) {
							collectionDto.setPictureThumb(config.getRootUrl() + thumb3);
						}
					}
				}
				collectionDtos.add(collectionDto);
			}
		}
		return collectionDtos;
	}
	
	/**
	 * 查询馆内藏品
	 */
	@Override
	@Transactional
	public List<CollectionDto> getCollections(String id, Page page) {
		List<CollectionDto> collectionDtos = new ArrayList<CollectionDto>();
		List<MipOpenCollectionInfo> collectionInfos = mipOpenCollectionInfoDao.findByMap("new MipOpenCollectionInfo(id, name, pictureIds)", Tools.getMap("collectionUnit",id), page, "sequence desc, clickCounts desc");
		if (!MyString.isEmpty(collectionInfos)) {
			for (MipOpenCollectionInfo collectionInfo : collectionInfos) {
				CollectionDto collectionDto = new CollectionDto();
				collectionDto.setId(collectionInfo.getId());
				collectionDto.setName(collectionInfo.getName());
				String pictureIds = collectionInfo.getPictureIds();
				if (!MyString.isEmpty(pictureIds)) {
					Picture picture = this.pictureUrlTran(pictureIds);
					if (!MyString.isEmpty(picture)) {
						String thumb3 = picture.getThumb3();
						if (!MyString.isEmpty(thumb3)) {
							collectionDto.setPictureThumb(config.getRootUrl() + thumb3);
						}
					}
				}
				collectionDtos.add(collectionDto);
			}
		}
		return collectionDtos;
	}
	
	/**
	 * 我的音频列表
	 * @return
	 */
	@Override
	@Transactional
	public List<CollectionAudioDto> myAudios(String uid, Page page){
		//查询所有音频
		List<MipCollectionAudio> audios = (List<MipCollectionAudio>) mipCollectionAudioService.queryByHql("from MipCollectionAudio where userId = '"+ uid +"' order by publishTime desc", Tools.getMap(), page);
		List<CollectionAudioDto> myAudioTran = new ArrayList<CollectionAudioDto>();
		if (!MyString.isEmpty(audios)) {
			myAudioTran = myAudioTran(audios);
		}
		return myAudioTran;
	}

	/**
	 * 处理音频回传值
	 * @param orgName
	 * @param audios
	 * @return
	 */
	public ArrayList<CollectionAudioDto> collectionAudioTran(String orgName, List<MipCollectionAudio> audios) {
		ArrayList<CollectionAudioDto> audioList = new ArrayList<CollectionAudioDto>();
		if (!MyString.isEmpty(audios)) {
			for (MipCollectionAudio audio : audios) {
				CollectionAudioDto audioDto = new CollectionAudioDto();
				try {
					BeanUtils.copyProperties(audioDto, audio);
					if (audioDto.getIsOfficial() == 1) {
						audioDto.setUserName(orgName);
					}
					if (audioDto.getIsOfficial() == 0) {
						String userId = audioDto.getUserId();
						User user = userService.get(userId);
						if (!MyString.isEmpty(user)) {
							//设置昵称
							String nickName = user.getNickName();
							audioDto.setUserName(nickName);
							//设置头像
							String avatarUrl = user.getAvatarUrl();
							if (!MyString.isEmpty(avatarUrl)) {
								audioDto.setAvatarUrl(config.getRootUrl() + avatarUrl);
							}
						}
					}
					//设置发布时间
					Long currentTime = System.currentTimeMillis();
					Long publishTime = audioDto.getPublishTime();
					String publishTimeStr = TimeShowUtil.plTime(currentTime, publishTime);
					audioDto.setPublishTimeStr(publishTimeStr);
					//设置音频地址
					String url = audioDto.getUrl();
					if (!MyString.isEmpty(url)) {
						//url = config.getRootUrl() + url;
						url = config.getAudioUrl() + url;
					}
					//设置音频时长
					String duration = audio.getDuration();
//					String tranMinSec = TimeShowUtil.tranMinSec(duration);
					audioDto.setDuration(duration);
					//设置点赞数目
					List<Long> counts = (List<Long>) mipAudioLikeService.queryByHql("select count(*) from MipAudioLike where audioId = '"+ audio.getId() +"'", Tools.getMap());
					if (!MyString.isEmpty(counts)) {
						audioDto.setLikeCounts(counts.get(0).intValue());
					}
					//判断当前音频是否被当前用户点赞过
					LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
					if (!MyString.isEmpty(cacheUser)) {
						String uid = cacheUser.getId();
						List<MipAudioLike> audioLikes = (List<MipAudioLike>) mipAudioLikeService.queryByHql("from MipAudioLike where audioId = '"+ audio.getId() +"' and userId = '" + uid + "'", Tools.getMap());
						if (!MyString.isEmpty(audioLikes)) {
							audioDto.setIsLiked(1);
						}
					}
					audioDto.setUrl(url);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
				//加入集合
				audioList.add(audioDto);
			}
		}
		return audioList;
	}
	
	
	/**
	 * 个人中心我的音频列表音频回传
	 * @param orgName
	 * @param audios
	 * @return
	 */
	public ArrayList<CollectionAudioDto> myAudioTran(List<MipCollectionAudio> audios) {
		ArrayList<CollectionAudioDto> audioList = new ArrayList<CollectionAudioDto>();
		if (!MyString.isEmpty(audios)) {
			for (MipCollectionAudio audio : audios) {
				CollectionAudioDto audioDto = new CollectionAudioDto();
				try {
					BeanUtils.copyProperties(audioDto, audio);
					/*String userId = audioDto.getUserId();
					User user = userService.get(userId);
					if (!MyString.isEmpty(user)) {
						// 设置昵称
						String nickName = user.getNickName();
						audioDto.setUserName(nickName);
						// 设置头像
						String avatarUrl = user.getAvatarUrl();
						if (!MyString.isEmpty(avatarUrl)) {
							audioDto.setAvatarUrl(config.getRootUrl() + avatarUrl);
						}
					}*/
					//设置藏品名称
					String collectionId = audio.getCollectionId();
					MipOpenCollectionInfo mipOpenCollectionInfo = mipOpenCollectionInfoDao.get(collectionId);
					audioDto.setCollectionName(mipOpenCollectionInfo.getName());
					audioDto.setCollectionId(collectionId);
					
					//设置发布时间
					Long currentTime = System.currentTimeMillis();
					Long publishTime = audioDto.getPublishTime();
					String publishTimeStr = TimeShowUtil.plTime(currentTime, publishTime);
					audioDto.setPublishTimeStr(publishTimeStr);
					//设置音频地址
					String url = audioDto.getUrl();
					if (!MyString.isEmpty(url)) {
						//url = config.getRootUrl() + url;
						url = config.getAudioUrl() + url;
					}
					//设置点赞数目
					List<Long> counts = (List<Long>) mipAudioLikeService.queryByHql("select count(*) from MipAudioLike where audioId = '"+ audio.getId() +"'", Tools.getMap());
					if (!MyString.isEmpty(counts)) {
						audioDto.setLikeCounts(counts.get(0).intValue());
					}
					//设置音频时长
					String duration = audio.getDuration();
//					String tranMinSec = TimeShowUtil.tranMinSec(duration);
					audioDto.setDuration(duration);
					audioDto.setUrl(url);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
				//加入集合
				audioList.add(audioDto);
			}
		}
		return audioList;
	}
	

	/**
	 * 藏品所属博物馆id转字符串
	 * @param collection
	 * @return
	 */
	public String collectionOrgTran(String collectionUnit) {
		MipOrganization mipOrganization = mipOrganizationService.get(collectionUnit);
		String orgName = "";
		if (!MyString.isEmpty(mipOrganization)) {
			orgName = mipOrganization.getName();
		}
		return orgName;
	}
	
	/**
	 * 藏品分类id转字符串
	 * @param collection
	 * @return
	 */
	public String collectionCategoryTran(MipOpenCollectionInfo collection) {
		String categoryId = collection.getCollectionsCategory();
		CollectionCategory category = collectionCategoryService.get(categoryId);
		String categoryName = "";
		if (!MyString.isEmpty(category)) {
			categoryName = category.getName();
		}
		return categoryName;
	}

	/**
	 * 藏品年代id转字符串
	 * @param collection
	 * @return
	 */
	public String colletionYearTran(MipOpenCollectionInfo collection) {
		String yearTypeId = collection.getYearType();
		YearType yearType = yearTypeService.get(yearTypeId);
		String yearName = "";
		if (!MyString.isEmpty(yearType)) {
			yearName = yearType.getName();
		}
		return yearName;
	}

	/**
	 * 藏品级别id转字符串
	 * @param collection
	 * @return
	 */
	public String collectionLevelTran(MipOpenCollectionInfo collection) {
		String level = collection.getCollectionLevel();
		String tranLevel = tranLevel(level);
		return tranLevel;
	}

	/**
	 * 提取藏品图片，并设置url
	 * @param collectionPictureDto
	 * @param pictureIds
	 */
	public Picture pictureUrlTran(String pictureIds) {
		String[] split = pictureIds.split(",");
		StringBuffer sb = new StringBuffer("'");
		for (String pid : split) {
			sb.append(pid).append("','");
		}
		pictureIds = sb.substring(0, sb.length() - 2);
		ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql(
				"from Picture where id in (" + pictureIds + ") order by isMain desc,url", Tools.getMap());
		if (!MyString.isEmpty(pictures)) {
			for (Picture picture : pictures) {
				picture.setUrlStr(config.getRootUrl() + picture.getUrl());
				picture.setThumb1Str(config.getRootUrl() + picture.getThumb1());
				picture.setThumb2Str(config.getRootUrl() + picture.getThumb2());
				picture.setThumb3Str(config.getRootUrl() + picture.getThumb3());
			}
			return pictures.get(0);
		} else {
			return new Picture();
		}
	}
	
	
	
	
	//转换级别
	public String tranLevel(String id){
		if ("1".equals(id)) {
			return "一级";
		} else if ("2".equals(id)) {
			return "二级";
		} else if ("3".equals(id)) {
			return "三级";
		} else if ("4".equals(id)) {
			return "一般";
		} else {
			return "未定级";
		}
	}

	

	

}
