package com.tj720.mip.controller.front;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.dto.CollectionDto;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.MipOpenFossilInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMipCollectService;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IMipOpenFossilInfoService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.model.MipCollect;
import com.tj720.mip.model.MipOpenCulturalrelicInfo;
import com.tj720.mip.model.MipOpenFossilInfo;
import com.tj720.mip.model.Picture;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.SortListUtil;
import com.tj720.mip.utils.Tools;

@Controller("CollectedController")
@RequestMapping("/front/Collected")
public class CollectedController extends BaseController<MipOpenCulturalrelicInfo> {

	@Autowired
	private IMipCollectService mipCollectService;
	@Autowired
	private IMipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
	@Autowired
	private IMipOpenFossilInfoService mipOpenFossilInfoService;
	@Autowired
	private IPictureService pictureService;
	@Autowired
	private Config config;

	@RequestMapping("/doCollect.do")
	@ResponseBody
	public JsonResult doCollect(String id, String collectionType) throws MyException {

		// 获取用户信息
		LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
		if (cacheUser == null) {
			return new JsonResult(new MyException("200000", "请先登录！"));
		} else {
			String uid = cacheUser.getId();
			// 创建一个收藏对象
			MipCollect mipCollect = new MipCollect();
			mipCollect.setUid(uid);
			// 判断藏品类型（1：文物；2：化石）
			int collectedCounts = 0;
			if ("1".equals(collectionType)) {
				mipCollect.setCid(id);
				MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(id);
				collectedCounts = mipOpenCulturalrelicInfo.getCollectedCounts();
				collectedCounts++;
				mipOpenCulturalrelicInfo.setCollectedCounts(collectedCounts);
				mipOpenCulturalrelicInfoService.update(mipOpenCulturalrelicInfo);
				mipCollectService.save(mipCollect);
			} else if ("2".equals(collectionType)) {
				MipOpenFossilInfoDto mofid = new MipOpenFossilInfoDto();
				mipCollect.setFid(id);
				MipOpenFossilInfo mipOpenFossilInfo = mipOpenFossilInfoService.get(id);
				collectedCounts = mipOpenFossilInfo.getCollectedCounts();
				collectedCounts++;
				mipOpenFossilInfo.setCollectedCounts(collectedCounts);
				mipOpenFossilInfoService.update(mipOpenFossilInfo);
				mipCollectService.save(mipCollect);
			} else {
				return new JsonResult("参数有误！");
			}
			return new JsonResult(1, "收藏成功！");
		}

	}

	/**
	 * 我的收藏
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/myCollect.do")
	@ResponseBody
	public JsonResult myCollect(@RequestParam(defaultValue = "6") int size, @RequestParam(defaultValue = "1") int currentPage, HttpServletResponse response) throws MyException {
		// 获取用户信息
		LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
		if (cacheUser == null) {
			return new JsonResult(new MyException("200000", "请先登录！"));
		} else {
			String uid = cacheUser.getId();
			//page
			Page page = new Page();
			page.setSize(size);
			page.setCurrentPage(currentPage);
			
			//查询用户收藏列表
			List<MipCollect> collectList = (List<MipCollect>) mipCollectService.queryByHql("from MipCollect where uid = '"+uid+"'", Tools.getMap(), page);
			//用户收藏文物列表
			String wwStr = "";
			List<CollectionDto> collects = new ArrayList<CollectionDto>();
			if (!MyString.isEmpty(collectList)) {
				for (MipCollect mipCollect : collectList) {
					wwStr += "'" + mipCollect.getCid() + "',";
				}
				wwStr = wwStr.substring(0, wwStr.length()-1);
			
				List<MipOpenCulturalrelicInfo> mociList = (List<MipOpenCulturalrelicInfo>) mipOpenCulturalrelicInfoService.queryByHql("from MipOpenCulturalrelicInfo where id in ("+wwStr+")", Tools.getMap());
				for (MipOpenCulturalrelicInfo moci : mociList) {
					CollectionDto collectionDto = new CollectionDto();
					collectionDto.setId(moci.getId());
					collectionDto.setName(moci.getName());
					collectionDto.setType(moci.getCollectionType());
					//收藏时间
					List<MipCollect> mcList = (List<MipCollect>) mipCollectService.queryByHql("from MipCollect where cid = '"+moci.getId()+"'", Tools.getMap());
					if (!MyString.isEmpty(mcList)) {
						MipCollect mipCollect = mcList.get(0);
						collectionDto.setCollectTime(mipCollect.getCreateTime());
					}
					
					String pictureIds = moci.getPictureIds();
					String[] idArray = pictureIds.split(",");
					String ids = "";
					for (String id : idArray) {
						ids += "'" + id + "',";
					}
					ids = ids.substring(0, ids.length()-1);
					List<Picture> pics =  (List<Picture>) pictureService.queryByHql("from Picture where id in ("+ids+") order by isMain desc,url", Tools.getMap());
					
					//缩略图路径
	//				List<Picture> pics = (List<Picture>) pictureService.queryByHql("from Picture where objectId='"+moci.getId()+"' order by isMain desc,url", Tools.getMap());
					if (!MyString.isEmpty(pics)) {
						Picture pic = pics.get(0);
						collectionDto.setPictureThumb(config.getRootUrl()+pic.getThumb3());
						collectionDto.setPictureUrl(config.getRootUrl()+pic.getUrl());
						
					}
					collects.add(collectionDto);
				}
			}
			//用户收藏化石列表
			String hsStr = "";
			if (!MyString.isEmpty(collectList)) {
				for (MipCollect mipCollect : collectList) {
					hsStr += "'" + mipCollect.getFid() + "',";
				}
				hsStr = hsStr.substring(0, hsStr.length()-1);
			
				List<MipOpenFossilInfo> mofiList = (List<MipOpenFossilInfo>) mipOpenFossilInfoService.queryByHql("from MipOpenFossilInfo where id in ("+hsStr+")", Tools.getMap());
				for (MipOpenFossilInfo mofi : mofiList) {
					CollectionDto collectionDto = new CollectionDto();
					collectionDto.setId(mofi.getId());
					collectionDto.setName(mofi.getName());
					collectionDto.setType(mofi.getCollectionType());
					
					//收藏时间
					List<MipCollect> mcList = (List<MipCollect>) mipCollectService.queryByHql("from MipCollect where fid = '"+mofi.getId()+"'", Tools.getMap());
					if (!MyString.isEmpty(mcList)) {
						MipCollect mipCollect = mcList.get(0);
						collectionDto.setCollectTime(mipCollect.getCreateTime());
					}
					
					String pictureIds = mofi.getPictureId();
					String[] idArray = pictureIds.split(",");
					String ids = "";
					for (String id : idArray) {
						ids += "'" + id + "',";
					}
					ids = ids.substring(0, ids.length()-1);
					List<Picture> pics =  (List<Picture>) pictureService.queryByHql("from Picture where id in ("+ids+") order by isMain desc,url", Tools.getMap());
					//缩略图路径
	//				List<Picture> pics = (List<Picture>) pictureService.queryByHql("from Picture where objectId='"+mofi.getId()+"' order by isMain desc,url", Tools.getMap());
					if (!MyString.isEmpty(pics)) {
						Picture pic = pics.get(0);
						collectionDto.setPictureThumb(config.getRootUrl()+pic.getThumb3());
						collectionDto.setPictureUrl(config.getRootUrl()+pic.getUrl());
					}
					collects.add(collectionDto);
				}
			}
			if (!MyString.isEmpty(collects)) {
				collects = (List<CollectionDto>) SortListUtil.sort(collects, "collectTime", SortListUtil.DESC);
			}
			response.setHeader("Access-Control-Allow-Origin", "*");
			return new JsonResult(1, collects, page);
		}
		
	}

}
