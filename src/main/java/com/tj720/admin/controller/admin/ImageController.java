package com.tj720.admin.controller.admin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.quartz.core.SampledStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.admin.common.constant.KeyConstants;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.mip.constant.Constants;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.model.MipOpenCollectionInfo;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.MipOpenCollectionInfoService;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.service.table.PictureService;
import com.tj720.mip.service.table.UserService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.ImageHepler;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.TimeUtil;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/image")
public class ImageController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MipOrganizationService mipOrganizationService;
	@Autowired
	private MipOpenCollectionInfoService MipOpenCollectionInfoService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private Config config;
	
	private final static int DELAY_DAY = 5;
	
	@RequestMapping("/addAllWatermark")
	@ResponseBody
	public JsonResult addAllWatermark(){
		try {
			
			//查询当前博物馆下公开的藏品
			List<MipOpenCollectionInfo> list = MipOpenCollectionInfoService.queryByHql("from MipOpenCollectionInfo", Tools.getMap());
			if (MyString.isEmpty(list)) {
				return new JsonResult(-4, "还未公开藏品");
			}
			//水印地址
			String waterMarkPath = Constants.DEFAULT_WATER_MARK_IMT_PATH;
			if (MyString.isEmpty(waterMarkPath)) {
				return new JsonResult(-5, "找不到水印文件");
			}
			//拼接水印图片的地址
			String rootPath = config.getRootPath();
			String wartmarkPathSource = rootPath + waterMarkPath;
			
			BufferedImage watermarkImagePath = null;
			if (new File(wartmarkPathSource).exists()) {
				watermarkImagePath = ImageIO.read(new FileInputStream(wartmarkPathSource));
			}
			System.out.println("+++++++++++++++++开始添加水印++++++++++++++++++");
			int i = 1 ;
			for (MipOpenCollectionInfo info : list) {
				System.out.println("++++++++++++++++++处理第" + i + "条++++++++++++++++++++++++");
				addWaterMark(rootPath, watermarkImagePath, info);
				i++;
			}
			System.out.println("+++++++++++++++++结束添加水印++++++++++++++++++");
			return new JsonResult(1, "水印添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "添加水印失败，请联系管理员");
		}
	}

	
	
	@RequestMapping("/resetDefaultWatermark")
	@ResponseBody
	@AuthPassport(authority="SystemAdmin")
	public JsonResult resetDefaultWatermark(){
		try {
			//获取登录信息
			LoginInfoDto userDto = Tools.getUser();
			if (MyString.isEmpty(userDto) || MyString.isEmpty(userDto.getId())) {
				return new JsonResult(-1, "未登录或登录已过期");
			}
			User user = userService.get(userDto.getId());
			//获取用户的组织机构
			if (MyString.isEmpty(user)) {
				return new JsonResult(-2, "用户已注销");
			}
			String orgId = user.getOrgId();
			String watermarkPathKey = MessageFormat.format(KeyConstants.ORGANIZATION_WATERMARK_KEY, orgId);
			String orgWaterMakerTimeKey = MessageFormat.format(KeyConstants.ORGANIZATION_WATERMARK_TIME_KEY, orgId);
			JedisService.del(watermarkPathKey);
			JedisService.del(orgWaterMakerTimeKey);
			String waterMarkPath = config.getRootUrl() + Constants.DEFAULT_WATER_MARK_IMT_PATH;
			return new JsonResult(1, waterMarkPath);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "重置默认水印图失败，请联系管理员");
		}
	}
	@RequestMapping("/isAddWatermark")
	@ResponseBody
	@AuthPassport(authority="SystemAdmin")
	public JsonResult isAddWatermark(){
		try {
			//获取登录信息
			LoginInfoDto userDto = Tools.getUser();
			if (MyString.isEmpty(userDto) || MyString.isEmpty(userDto.getId())) {
				return new JsonResult(-1, "未登录或登录已过期");
			}
			User user = userService.get(userDto.getId());
			//获取用户的组织机构
			if (MyString.isEmpty(user)) {
				return new JsonResult(-2, "用户已注销");
			}
			String orgId = user.getOrgId();
			
//			String orgWaterMakerTimeKey = MessageFormat.format(KeyConstants.ORGANIZATION_WATERMARK_TIME_KEY, orgId);
			String organizationWaterMakerKey = MessageFormat.format(KeyConstants.ORGANIZATION_WATERMARK_KEY, orgId);
			if(JedisService.isExist(organizationWaterMakerKey)){
				return new JsonResult(1, "可添加水印");
			}
			
			return new JsonResult(-6, "五天之内不能更新水印");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "添加水印失败，请联系管理员");
		}
	}
	@RequestMapping("/printWatermark")
	@ResponseBody
	@AuthPassport(authority="SystemAdmin")
	public JsonResult printWatermark(){
		try {
			//获取登录信息
			LoginInfoDto userDto = Tools.getUser();
			if (MyString.isEmpty(userDto) || MyString.isEmpty(userDto.getId())) {
				return new JsonResult(-1, "未登录或登录已过期");
			}
			User user = userService.get(userDto.getId());
			//获取用户的组织机构
			if (MyString.isEmpty(user)) {
				return new JsonResult(-2, "用户已注销");
			}
			String orgId = user.getOrgId();
			MipOrganization org = mipOrganizationService.get(orgId);
			if (MyString.isEmpty(org)) {
				return new JsonResult(-3, "用户组织机构已注销");
			}
			String orgWaterMakerTimeKey = MessageFormat.format(KeyConstants.ORGANIZATION_WATERMARK_TIME_KEY, orgId);
			if(JedisService.isExist(orgWaterMakerTimeKey)){
				return new JsonResult(-6, "五天之内不能更新水印");
			}
			//查询当前博物馆下公开的藏品
			List<MipOpenCollectionInfo> list = MipOpenCollectionInfoService.queryByHql("from MipOpenCollectionInfo where collectionUnit = '" +orgId + "'", Tools.getMap());
			if (MyString.isEmpty(list)) {
				return new JsonResult(-4, "还未公开藏品");
			}
			//水印地址
			String waterMarkPath = JedisService.get(MessageFormat.format(KeyConstants.ORGANIZATION_WATERMARK_KEY, orgId));
			waterMarkPath = StringUtils.isBlank(waterMarkPath) ? Constants.DEFAULT_WATER_MARK_IMT_PATH : waterMarkPath;
			if (MyString.isEmpty(waterMarkPath)) {
				return new JsonResult(-5, "找不到水印文件");
			}
			String expireDay = TimeUtil.getNextDay(null, DELAY_DAY, TimeUtil.DATETIME_FORMAT);
			JedisService.set(orgWaterMakerTimeKey, expireDay, DELAY_DAY * 24 * 60 * 60);
			//拼接水印图片的地址
			String rootPath = config.getRootPath();
			String wartmarkPathSource = rootPath + waterMarkPath;
			
			BufferedImage watermarkImagePath = null;
			if (new File(wartmarkPathSource).exists()) {
				watermarkImagePath = ImageIO.read(new FileInputStream(wartmarkPathSource));
			}
			for (MipOpenCollectionInfo info : list) {
				addWaterMark(rootPath, watermarkImagePath, info);
			}
			return new JsonResult(1, "水印添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "添加水印失败，请联系管理员");
		}
	}

	private void addWaterMark(String rootPath, BufferedImage watermarkImagePath, MipOpenCollectionInfo info)
			throws IOException {
		//获取藏品图片的id
		String pictureIds = info.getPictureIds();
		if (!MyString.isEmpty(pictureIds)) {
			String[] idArray = pictureIds.split(",");
			for (String id : idArray) {
				Picture picture = pictureService.get(id);
				if (!MyString.isEmpty(picture)) {
					//获取图片地址
					String url = picture.getUrl();
					//url = url.replace("_wm.", ".");
					if(url.indexOf("_wm.") != -1){
						url = picture.getThumb6();
					}
					//拼接图片真实地址
					String realPath = rootPath + url;
					//拼接图片保存地址
					String imgWithWatermark = url.replace(".", "_wm.");
					String savePath = rootPath + imgWithWatermark;
					//添加水印
					boolean exists_realPath = new File(realPath).exists();
					if (!MyString.isEmpty(watermarkImagePath) && exists_realPath) {
						ImageHepler.changePictureAddWatermark(realPath, savePath, watermarkImagePath);
						//数据库url换有水印的，原图存到thumb6中
						picture.setThumb6(url);
						picture.setUrl(imgWithWatermark);
						pictureService.update(picture);
					}
					
				}
			}
		}
	}
	
	/**
	 * 跳转添加水印页面
	 * @return
	 */
	@RequestMapping("/toWaterMark")
	@AuthPassport(authority="SystemAdmin")
	public ModelAndView toWaterMark(){
		ModelAndView map = new ModelAndView("/WEB-INF/back/content/museum/watermark.jsp");
		//获取登录信息
		LoginInfoDto userDto = Tools.getUser();
		if (MyString.isEmpty(userDto) || MyString.isEmpty(userDto.getId())) {
			map.addObject("error","未登录或登录已过期");
			return map;
		}
		User user = userService.get(userDto.getId());
		//获取用户的组织机构
		if (MyString.isEmpty(user)) {
			map.addObject("error","用户已注销");
			return map;
		}
		String orgId = user.getOrgId();
		map.addObject("objectId", orgId);
		String waterMarkPath = JedisService.get(MessageFormat.format(KeyConstants.ORGANIZATION_WATERMARK_KEY, orgId));
		waterMarkPath = StringUtils.isBlank(waterMarkPath) ? Constants.DEFAULT_WATER_MARK_IMT_PATH : waterMarkPath;
		if (!MyString.isEmpty(waterMarkPath)) {
			waterMarkPath = config.getRootUrl() + waterMarkPath;
		}
		map.addObject("waterMarkPath", waterMarkPath);
		return map;
	}
	
	/**
	 * 公开藏品时添加水印
	 * @param id
	 * @return
	 */
	@RequestMapping("/printWatermarkForEachCollection")
	@ResponseBody
	@AuthPassport(authority="SystemAdmin")
	public JsonResult printWatermarkForOneCollection(String[] ids){
		try {
			//获取登录信息
			LoginInfoDto userDto = Tools.getUser();
			if (MyString.isEmpty(userDto) || MyString.isEmpty(userDto.getId())) {
				return new JsonResult(-1, "未登录或登录已过期");
			}
			User user = userService.get(userDto.getId());
			//获取用户的组织机构
			if (MyString.isEmpty(user)) {
				return new JsonResult(-2, "用户已注销");
			}
			String orgId = user.getOrgId();
			MipOrganization org = mipOrganizationService.get(orgId);
			if (MyString.isEmpty(org)) {
				return new JsonResult(-3, "用户组织机构已注销");
			}
			if (MyString.isEmpty(ids)) {
				return new JsonResult(-6, "ids为空");
			}
			for (String id : ids) {
				MipOpenCollectionInfo info = MipOpenCollectionInfoService.get(id);
				if (MyString.isEmpty(info)) {
					return new JsonResult(-4, "藏品不存在");
				}
				//水印地址
				String waterMarkPath = JedisService.get(MessageFormat.format(KeyConstants.ORGANIZATION_WATERMARK_KEY, orgId));
				if (MyString.isEmpty(waterMarkPath)) {
					return new JsonResult(-5, "找不到水印文件");
				}
				//拼接水印图片的地址
				String rootPath = config.getRootPath();
				String wartmarkPathSource = rootPath + waterMarkPath;
				BufferedImage watermarkImagePath = null;
				if (new File(wartmarkPathSource).exists()) {
					watermarkImagePath = ImageIO.read(new FileInputStream(wartmarkPathSource));
				}
				addWaterMark(rootPath, watermarkImagePath, info);
			}
			return new JsonResult(1, "水印添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "添加水印失败，请联系管理员");
		}
		
	}
	
	
	/**
	 * 测试图片添加水印--用于预览
	 * @param id
	 * @return
	 */
	@RequestMapping("/testWatermarkForTest")
	@ResponseBody
	@AuthPassport(authority="SystemAdmin")
	public JsonResult testWatermarkForTest(){
		try {
			//获取登录信息
			LoginInfoDto userDto = Tools.getUser();
			if (MyString.isEmpty(userDto) || MyString.isEmpty(userDto.getId())) {
				return new JsonResult(-1, "未登录或登录已过期");
			}
			User user = userService.get(userDto.getId());
			//获取用户的组织机构
			if (MyString.isEmpty(user)) {
				return new JsonResult(-2, "用户已注销");
			}
			String orgId = user.getOrgId();
			MipOrganization org = mipOrganizationService.get(orgId);
			if (MyString.isEmpty(org)) {
				return new JsonResult(-3, "用户组织机构已注销");
			}
			//水印地址
			String waterMarkPath = JedisService.get(MessageFormat.format(KeyConstants.ORGANIZATION_WATERMARK_KEY, orgId));
			waterMarkPath = StringUtils.isBlank(waterMarkPath) ? Constants.DEFAULT_WATER_MARK_IMT_PATH : waterMarkPath;
			if (MyString.isEmpty(waterMarkPath)) {
				return new JsonResult(-5, "找不到水印文件");
			}
			//拼接水印图片的地址
			String rootPath = config.getRootPath();
			String wartmarkPathSource = rootPath + waterMarkPath;
			BufferedImage watermarkImagePath = null;
			if (new File(wartmarkPathSource).exists()) {
				watermarkImagePath = ImageIO.read(new FileInputStream(wartmarkPathSource));
			}
			String savePath = rootPath + "picture/watermark/test/"+orgId+".jpg";
			String saveUrl = rootPath + "picture/watermark/test/";
			if (!new File(saveUrl).exists()) {
				new File(saveUrl).mkdirs();
			}
			//添加水印
			boolean exists_realPath = new File(wartmarkPathSource).exists();
			if (!MyString.isEmpty(watermarkImagePath) && exists_realPath) {
				ImageHepler.changePictureAddWatermark(wartmarkPathSource, savePath, watermarkImagePath);
				String picUrl = config.getRootUrl() + "picture/watermark/test/"+orgId+".jpg";
				return new JsonResult(1, picUrl);
			} else {
				return new JsonResult(0, "图片找不到");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "添加水印失败，请联系管理员");
		}
		
	}
	
	
	
}
