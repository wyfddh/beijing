/** 
 * <pre>项目名称:mip 
 * 文件名称:WenChuangController.java 
 * 包名:com.tj720.mip.controller.content 
 * 创建日期:2017年3月28日下午5:07:48 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */
package com.tj720.mip.controller.content;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.admin.service.MipLogService;
import com.tj720.common.dto.ImageTranslateDto;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.ErrorInfos;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.MipJiLinArticleService;
import com.tj720.mip.inter.service.table.MipWenchuangService;
import com.tj720.mip.inter.service.table.WenChuangCategoryService;
import com.tj720.mip.model.ArticleCategory;
import com.tj720.mip.model.MipJiLinArticle;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MipWenchuang;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.Spreadtrum;
import com.tj720.mip.model.User;
import com.tj720.mip.model.WenchuangCategory;
import com.tj720.mip.service.table.PictureService;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.HqlWhere;
import com.tj720.mip.utils.ImageHepler;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

/**
 * <pre>
 * 项目名称：mip    
 * 类名称：WenChuangController    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月28日 下午5:07:48    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月28日 下午5:07:48    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
@Controller
@RequestMapping("wenChuang_old")
public class OldWenChuangController {
	@Autowired
	private MipWenchuangService wenchuangService;
	@Autowired
	private UserService userService;// 用户的service
	@Autowired
	private IMipOrganizationService mipOrganizationService;// 组织架构的service
	@Autowired
	private PictureService pictureService;// 图片表的service
	@Autowired
	private Config config;// 常量的取法
	@Autowired
	private WenChuangCategoryService categoryService;
	
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private MipLogService mipLogService;

	@SuppressWarnings("unchecked")
	@RequestMapping("getWenChuang")
	public String getWenChuang(@ModelAttribute MipWenchuang wenchuang, String erea,
			@RequestParam(defaultValue = "1", name = "page") Integer currentPage,@RequestParam(defaultValue = "15") int size, ModelMap modelMap, String keys)
			throws MyException {
		try {
			// 获取用户信息
			LoginInfoDto userDto = Tools.getUser();
			if (MyString.isEmpty(userDto)) {
				return "/toLogin.do";
			}
			User us = userService.get(userDto.getId());
			// 获取用户的组织机构
			String orgId = us.getOrgId();
			MipOrganization org = mipOrganizationService.get(orgId);
			// 查询组织机构的级别
			byte level = org.getLevel();
			// 查询组织机构（城市）的集合
			/*@SuppressWarnings("unchecked")
			List<MipOrganization> cityList = (List<MipOrganization>) mipOrganizationService
			.queryByHql("from MipOrganization where platformId=2 and level=2 order by sequence", Tools.getMap());
			modelMap.put("cityList", cityList);*/
			// 查询组织机构（城市）的集合
			if (level==1) {
				//省级
				List<MipOrganization> cityList = (List<MipOrganization>) mipOrganizationService
						.queryByHql("from MipOrganization where platformId="+config.getPlatformId()+" and level=2 order by sequence", Tools.getMap());
				modelMap.put("cityList", cityList);
				int platformId = org.getPlatformId();
				List<MipOrganization> orgList = (List<MipOrganization>) mipOrganizationService.queryByHql("from MipOrganization where platformId = '"+ platformId +"' and level = 3", Tools.getMap());
				StringBuffer sBuffer = new StringBuffer();
				if (!MyString.isEmpty(orgList)) {
					for (MipOrganization mipOrganization2 : orgList) {
						sBuffer.append(mipOrganization2.getId()).append(",");
					}
				}
				orgId = sBuffer.toString();
				orgId = orgId.substring(0, orgId.length()-1);
				
			}
			if (level==2) {
				//市级
				List<MipOrganization> cityList = (List<MipOrganization>) mipOrganizationService
						.queryByHql("from MipOrganization where platformId="+config.getPlatformId()+" and level=2 and id="+orgId+" order by sequence", Tools.getMap());
				modelMap.put("cityList", cityList);
				List<MipOrganization> orgList = (List<MipOrganization>) mipOrganizationService.queryByHql("from MipOrganization where parentId = '"+ orgId +"'", Tools.getMap());
				StringBuffer sBuffer = new StringBuffer();
				if (!MyString.isEmpty(orgList)) {
					for (MipOrganization mipOrganization2 : orgList) {
						sBuffer.append(mipOrganization2.getId()).append(",");
					}
				}
				orgId = sBuffer.toString();
				orgId = orgId.substring(0, orgId.length()-1);
			}
			
			// 查询组织机构（博物馆）的集合
			if (erea != null && !"".equals(erea)) {
				List<MipOrganization> musList = (List<MipOrganization>) mipOrganizationService
						.queryByHql("from MipOrganization where parentId=" + erea
								+ " and level=3 and status>0 and isdelete=0 order by sequence", Tools.getMap());
				modelMap.put("musList", musList);
			}
			
			//查询该博物馆下的所有用户
			List<User> userList = userService.queryByHql("from User where orgId='"+orgId+"'", Tools.getMap());
			
			Page page = new Page(15);
			page.setCurrentPage(currentPage);
			page.setSize(size);
			String seachhql = wenchuangService.getSeachHql(wenchuang, keys, orgId);
			@SuppressWarnings("unchecked")
			// 文创表数据
			List<MipWenchuang> findByMap = (List<MipWenchuang>) wenchuangService.queryByHql(seachhql, Tools.getMap(), page);
			List<WenchuangCategory> categoryList = (List<WenchuangCategory>) categoryService
					.queryByHql(" from WenchuangCategory ", Tools.getMap());
			// 图片表数据
			// List<Picture> PiList = pictureService.findByMap(null, " new
			// Picture(id,thumb1,thumb5,thumb4) ", null, null);
			List<Picture> piList = new ArrayList<Picture>();
			List<MipOrganization> orgaList = mipOrganizationService.findByMap(null, " new MipOrganization(id,name) ", null,
					null);
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			for (MipWenchuang wen : findByMap) {
				WenchuangCategory wenchuangCategory = categoryService.get(wen.getCategoryId().toString());
				wen.setCategoryName(wenchuangCategory.getCategoryName());
				if (wen.getPublishTime() != null && wen.getPublishTime() != 0) {
					java.util.Date date = new java.util.Date(wen.getPublishTime() * 1000);
					wen.setIssemTime(sim.format(date));
				}
				if (wen.getUserId() != null && !wen.getUserId().equals(0)) {
					User user = userService.get(wen.getUserId());
					wen.setNickName(user.getNickName());
				}
			}
			
			for (MipOrganization orga : orgaList) {
				for (MipWenchuang sprea : findByMap) {
					if (orga.getId().equals(String.valueOf(sprea.getOrgId()))) {
						sprea.setMusExhibition(orga.getName());
					}
				}
			}
			 
			JsonResult wenchuangList = new JsonResult(1, findByMap, page);
			modelMap.put("wenchuangList", wenchuangList);
			modelMap.put("wenchuang", wenchuang);
			modelMap.put("keys", keys);
			modelMap.put("categoryList", categoryList);
			modelMap.put("level",level);
			modelMap.put("erea", erea);
			modelMap.put("userList", userList);
			return "/WEB-INF/back/content/History_JiLin/article_create/article_list.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "系统未知异常，请联系管理员！";
		}
	}

	// 增加或者删除
	@RequestMapping("addAndUpdate")
	@AuthPassport(authority="contentAdmin")
	public String addAndUpdate(HttpServletRequest request,@ModelAttribute MipWenchuang wenchuang) throws MyException, IOException {
		MipWenchuang model = null;
		ImageTranslateDto imageTranslateDto = new ImageTranslateDto();
		imageTranslateDto.setOpType("add");
		List<String> imgPaths = new ArrayList<String>();
		if (!MyString.isEmpty(wenchuang.getId())) {
			if (!wenchuang.getId().equals(Const.NULL_ID)) {
				model = wenchuangService.get(wenchuang.getId());
				// 未发布数据
				if (model.getPublish() == 0 && model.getPublish() != 1) {
					wenchuang.setPublish(model.getPublish());
					wenchuang.setUserId(model.getUserId());
					wenchuang.setOrgId(model.getOrgId());
					wenchuang.setCreateTime(model.getCreateTime());
					wenchuang.setPublishTime((long) 0);
					wenchuangService.update(wenchuang);
					//记录日志（编辑文创）
					mipLogService.contentLog(request, wenchuang, "编辑文创产品");
					if (model.getPictureId() != wenchuang.getPictureId()) {
						Picture delete = pictureService.get(model.getPictureId());
						delete.setObjectId("");
						delete.setStatus((byte) -1);
						pictureService.update(delete);
						Picture picture = pictureService.get(wenchuang.getPictureId());
						if (!MyString.isEmpty(picture) && !MyString.isEmpty(picture.getUrl())) {
							imgPaths.add(picture.getUrl());
							imageTranslateDto.setImgPaths(imgPaths);
							//发布
							redisTemplate.convertAndSend("translateImg", imageTranslateDto);
							// 生成缩略图236x158
							// 获取新主图存放路径
							String url = picture.getUrl();
							String rootPath = config.getRootPath();
							String imagePath = rootPath + url;
							// 设置缩略图的存放路径路径
							int lastIndexOf = url.lastIndexOf("/");
							String substring = url.substring(0, lastIndexOf);
							String imageName = url.substring(lastIndexOf + 1);

							// 藏品详情页大图C1（640*426）
							String thumbUrl1 = substring + "/236x158_" + imageName;
							String thumbnailPath1 = rootPath + thumbUrl1;
							// 生成缩略图
							Map<String, Integer> thumb1 = ImageHepler.createThumbs(imagePath, thumbnailPath1, 236, 158);
							picture.setThumb1(thumbUrl1);
							picture.setThumb1Width(thumb1.get("width"));
							picture.setThumb1Height(thumb1.get("height"));
						} else {
							return "/WEB-INF/back/error.jsp";
						}

						picture.setObjectId(wenchuang.getId());
						pictureService.update(picture);
					}
				}
			}
		} else {
			wenchuang.setPublish((byte) 0);
			User user = userService.get(Tools.getUser().getId());
			wenchuang.setUserId(user.getId());
			wenchuang.setOrgId(Integer.valueOf(user.getOrgId()));
			wenchuang.setPublishTime((long) 0);
			wenchuangService.save(wenchuang);
			//记录日志（新增文创）
			mipLogService.contentLog(request, wenchuang, "新增文创产品");
			Picture picture = pictureService.get(wenchuang.getPictureId());

			if (!MyString.isEmpty(picture) && !MyString.isEmpty(picture.getUrl())) {
				imgPaths.add(picture.getUrl());
				imageTranslateDto.setImgPaths(imgPaths);
				//发布
				redisTemplate.convertAndSend("translateImg", imageTranslateDto);
				// 生成缩略图236x158
				// 获取新主图存放路径
				String url = picture.getUrl();
				String rootPath = config.getRootPath();
				String imagePath = rootPath + url;
				// 设置缩略图的存放路径路径
				int lastIndexOf = url.lastIndexOf("/");
				String substring = url.substring(0, lastIndexOf);
				String imageName = url.substring(lastIndexOf + 1);

				// 藏品详情页大图C1（640*426）
				String thumbUrl1 = substring + "/236x158_" + imageName;
				String thumbnailPath1 = rootPath + thumbUrl1;
				// 生成缩略图
				Map<String, Integer> thumb1 = ImageHepler.createThumbs(imagePath, thumbnailPath1, 236, 158);
				picture.setThumb1(thumbUrl1);
				picture.setThumb1Width(thumb1.get("width"));
				picture.setThumb1Height(thumb1.get("height"));
			} else {
				return "/WEB-INF/back/error.jsp";
			}

			picture.setObjectId(wenchuang.getId());
			pictureService.update(picture);
		}
		return "redirect:/wenChuang/getWenChuang.do";
	}

	// 跳转到增加页面
	@AuthPassport(authority="contentAdmin")
	@RequestMapping("toWenChuangAdd")
	public String toWenChuangAdd(ModelMap map) {
		if (!MyString.isEmpty(Tools.getUser())) {
			User user = userService.get(Tools.getUser().getId());
			MipOrganization mipOrganization = mipOrganizationService.get(user.getOrgId());
			map.put("userName", user.getNickName());
			map.put("userOrga", mipOrganization.getName());
		}

		List<WenchuangCategory> categoryList = (List<WenchuangCategory>) categoryService
				.queryByHql(" from WenchuangCategory ", Tools.getMap());
		map.put("categoryList", categoryList);
		return "/WEB-INF/back/content/History_JiLin/article_create/article_add.jsp";
	}

	// 删除一条信息
	@RequestMapping("deleteWenChuang")
	@ResponseBody
	@AuthPassport(authority="contentAdmin")
	public void deleteWenChuang(HttpServletRequest request,@ModelAttribute MipWenchuang wenchuang) {
		MipWenchuang model = null;
		if (!wenchuang.getId().equals(Const.NULL_ID)) {
			model = wenchuangService.get(wenchuang.getId());
		}
		if (model != null) {
			// 0取消发布,1发布
			if (model.getPublish() == 0) {
				wenchuangService.delete(model);
				//记录日志（删除文创）
				mipLogService.contentLog(request, wenchuang, "删除文创产品");
			}
		}
	}

	// 发布跟取消发布
	@RequestMapping("updatePublish")
	@ResponseBody
	@AuthPassport(authority="contentAdmin")
	public String updatePublish(HttpServletRequest request,@ModelAttribute MipWenchuang wenchuang) {
		MipWenchuang model = null;
		if (!MyString.isEmpty(wenchuang.getId())) {
			if (!wenchuang.getId().equals(Const.NULL_ID)) {
				model = wenchuangService.get(wenchuang.getId());
				if (model.getPublish() == 0) {
					model.setPublish((byte) 1);
					model.setPublishTime(new Date().getTime() / 1000);
					try {
						wenchuangService.update(model);
						//记录日志（发布文创）
						mipLogService.contentLog(request, model, "发布文创产品");
					} catch (Exception e) {
						return "/WEB-INF/back/error.jsp";
					}
				} else if (model.getPublish() == 1) {
					model.setPublish((byte) 0);
					model.setPublishTime((long) 0);
					try {
						wenchuangService.update(model);
						//记录日志（取消发布文创）
						mipLogService.contentLog(request, model, "取消发布文创产品");
					} catch (Exception e) {
						return "/WEB-INF/back/error.jsp";
					}
				}
			}
		}
		return "success";
	}

	// 后台 修改前的回显
	@RequestMapping("getWenChuangInfo")
	@AuthPassport(authority="contentAdmin")
	public String getWenChuangInfo(@ModelAttribute MipWenchuang wenchuang, ModelMap modelMap) throws MyException {
		MipWenchuang model = null;
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		if (!MyString.isEmpty(wenchuang.getId())) {
			if (!wenchuang.getId().equals(Const.NULL_ID)) {
				model = wenchuangService.get(wenchuang.getId());
				
				if (model.getUserId() != null && !model.getUserId().equals("")) {
					User user = userService.get(model.getUserId());
					model.setNickName(user.getNickName());
				}
				if (model.getOrgId() != null && !model.getOrgId().equals(0)) {
					MipOrganization mipOrganization = mipOrganizationService.get(String.valueOf(model.getOrgId()));
					model.setMusExhibition(mipOrganization.getName());
				}

				if (!MyString.isEmpty(model.getPictureId())) {
					Picture picture = pictureService.get(model.getPictureId());
					model.setPictureThumb(config.getRootUrl() + picture.getUrl());
				}
			} else {
				return "/WEB-INF/back/error.jsp";
			}
		}
		List<WenchuangCategory> categoryList = (List<WenchuangCategory>) categoryService
				.queryByHql(" from WenchuangCategory ", Tools.getMap());
		modelMap.put("categoryList", categoryList);
		modelMap.put("wenchuang", model);
		return "/WEB-INF/back/content/History_JiLin/article_create/article_info.jsp";
	}

	// 前台历史吉林的列表
	@SuppressWarnings("unchecked")
	@RequestMapping("getPCMipWenchuang")
	@ResponseBody
	// @AuthPassport
	public JsonResult getPCMipWenchuang(@RequestParam(defaultValue = "1") int currentPage) {
		try {
			Page page = new Page(12);
			page.setCurrentPage(currentPage);
			// 0是未发布(取消发布)状态,1是发布状态
			Map<String, Object> data_Map = new HashMap<String, Object>();
			String hql = "from MipWenchuang where publish = 1 and status>0 order by publishTime desc";
			List<MipWenchuang> list = (List<MipWenchuang>) wenchuangService.queryByHql(hql, Tools.getMap(), page);
			for (MipWenchuang mipWenchuang : list) {
				if (!MyString.isEmpty(mipWenchuang.getPictureId())) {
					Picture picture = pictureService.get(mipWenchuang.getPictureId());
					mipWenchuang.setPictureThumb(config.getRootUrl() + picture.getThumb1());// 设置缩略图路径
				}
				if (!MyString.isEmpty(mipWenchuang.getProductPrice())) {
					mipWenchuang.setPrice(mipWenchuang.getProductPrice() + "￥");
				}
			}
			data_Map.put("list", list);
			return new JsonResult(1, data_Map, page, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(1, ErrorInfos.getMessage("111116"));
		}
	}

	// 查看详情
	@SuppressWarnings("unchecked")
	@RequestMapping("getOneMipWenchuang")
	@ResponseBody
	// @AuthPassport
	public JsonResult getOneMipWenchuang(@ModelAttribute MipWenchuang mipWenchuang) throws MyException {
		try {

			Map<String, Object> data_Map = new HashMap<String, Object>();
			mipWenchuang = wenchuangService.get(mipWenchuang.getId());
			if (!MyString.isEmpty(mipWenchuang.getCategoryId())) {
				WenchuangCategory category = categoryService.get(mipWenchuang.getCategoryId().toString());
				mipWenchuang.setCategoryName(category.getCategoryName());//产品类别名称
			}
			if (!MyString.isEmpty(mipWenchuang.getProductPrice())) {
				mipWenchuang.setPrice(mipWenchuang.getProductPrice() + "元");//产品价格
			}
			if (!MyString.isEmpty(mipWenchuang.getOrgId())) {
				MipOrganization mipOrganization = mipOrganizationService.get(mipWenchuang.getOrgId().toString());
				mipWenchuang.setMusExhibition(mipOrganization.getName());// 产品来源
			}
			if (!MyString.isEmpty(mipWenchuang.getPictureId())) {
				Picture picture = pictureService.get(mipWenchuang.getPictureId());
				mipWenchuang.setPictureThumb(config.getRootUrl() + picture.getUrl());// 设置缩略图路径（原图）
			}
			
			//重设内容 String 
			String content = mipWenchuang.getContent();
			if(content != null && !content.equals("")){
				String txtcontent = content.replaceAll("<[^>]*>", ""); //剔出<html>的标签  
				txtcontent = txtcontent.replaceAll("<a>\\s*|\t|\r|\n</a>", "");//去除字符串中的空格,回车,换行符,制表符  
				mipWenchuang.setContent(txtcontent);
			}
			data_Map.put("mipWenchuang", mipWenchuang);
			
			//同类产品
			Page page = new Page(8);
			page.setCurrentPage(1);
			String hql = "from MipWenchuang where publish = 1 and status>0 and id != '"+mipWenchuang.getId()+"' and categoryId = "+ mipWenchuang.getCategoryId()+" order by publishTime desc";
			List<MipWenchuang> similarities = (List<MipWenchuang>) wenchuangService.queryByHql(hql, Tools.getMap(), page);
			for (MipWenchuang wenchuang : similarities) {
				if (!MyString.isEmpty(wenchuang.getPictureId())) {
					Picture picture = pictureService.get(wenchuang.getPictureId());
					wenchuang.setPictureThumb(config.getRootUrl() + picture.getThumb1());// 设置缩略图路径
				}
				if (!MyString.isEmpty(wenchuang.getProductPrice())) {
					wenchuang.setPrice(wenchuang.getProductPrice() + "￥");
				}
			}
			data_Map.put("similarities", similarities);

			return new JsonResult(1, data_Map, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(1, ErrorInfos.getMessage("111116"));
		}

	}

}
