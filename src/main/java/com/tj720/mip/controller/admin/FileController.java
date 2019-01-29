package com.tj720.mip.controller.admin;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.http.HttpException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.tj720.admin.common.constant.KeyConstants;
import com.tj720.admin.model.MipOpenCulturalrelicInfoWithBLOBs;
import com.tj720.admin.service.jedis.JedisService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.ICurationService;
import com.tj720.mip.model.Curation;
import com.tj720.mip.model.MipOpenCulturalrelicInfo;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.PictureService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.CreateQrcode;
import com.tj720.mip.utils.DateFormartUtil;
import com.tj720.mip.utils.FtpUtil;
import com.tj720.mip.utils.ImageHepler;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Qrcode;
import com.tj720.mip.utils.Tools;
import com.tj720.mip.utils.TwoDimensionCode;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileController extends BaseController<User> {
	@Autowired
	private Config config;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private ICurationService curationService;
	
	private FtpUtil ftpUtil;

	@RequestMapping(value = "/file/upload.do")
	@ResponseBody
	public String upload(@RequestParam(value = "file", required = false) CommonsMultipartFile file,
			@RequestParam(defaultValue = "") String callBack, String property, HttpServletRequest request) {

		String result = "";
		String realFileName = file.getOriginalFilename();
		//		String destDir = Tools.getServicePath(request);
		String destDir = config.getRootPath();
		String saveUrl = "";
		String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1).toLowerCase();
		JSONObject obj = new JSONObject();
		/**
		 * 文件大小拦截，不能超过20M
		 */
		if (file.getSize() > 1024 * 1024 * config.getFileSize()) {
			obj.put("error", 1);
			result = "[ERROR]文件超过最大限制，请上传小于" + config.getFileSize() + "M的文件";
		} else if (config.getImageType().indexOf(suffix) < 0 && config.getFileType().indexOf(suffix) < 0) {
			// 检查扩展名
			obj.put("error", 1);
			result = "[ERROR]上传文件格式不对";
		} else {
			// 检查扩展名
			if (config.getImageType().indexOf(suffix) >= 0) {
				saveUrl += "back/upload/images";
			} else {
				saveUrl += "resources/upload/files";
			}
			saveUrl += "/" + DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD) + "/";
			String version = ".MIP." + Tools.getChar(6) + ".1";
			// 如果文件包含版本号：.CAV.文件标识.版本号 //版本号CrapApi Version
			try {
				if (realFileName.contains(".MIP.")) {
					String str[] = realFileName.split("\\.");
					version = ".MIP." + str[str.length - 3] + "." + (Long.parseLong(str[str.length - 2]) + 1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			realFileName = DateFormartUtil.getDateByFormat(DateFormartUtil.HHmmss) + Tools.getChar(6) + version + "."
					+ suffix;
			// 保存
			try {
				/*if (!new File(destDir + saveUrl).exists()) {
					new File(destDir + saveUrl).mkdirs();
				}*/
				File targetFile = new File(destDir + saveUrl, realFileName);
				//原来版本：上传到本地
//				file.transferTo(targetFile);
				//现在版本：上传到ftp
				ftpUtil = new FtpUtil(config.getFtpUrl(), Integer.valueOf(config.getFtpPort()), config.getFtpUserName(), config.getFtpPassWord());
				boolean uploadFtpFile = ftpUtil.uploadFtpFile(destDir + saveUrl, realFileName, file.getInputStream());
				result = saveUrl + realFileName;
				obj.put("error", 0);
				obj.put("state", "SUCCESS");
				obj.put("url", saveUrl + realFileName);
			} catch (Exception e) {
				obj.put("error", 1);
				e.printStackTrace();
				result = "[ERROR]上传失败";
			}

		}
		if (!callBack.equals("")) {
			if (result.indexOf("[ERROR]") < 0) {
				printMsg("<script>parent." + callBack + "('[OK]上传成功','" + result + "','" + property + "')</script>");
			} else {
				printMsg("<script>parent.uploadImgCallBack('[ERROR]上传失败','" + result + "')</script>");
			}
		} else {
			obj.put("message", result);
			// printMsg(obj.toString());
		}
		return obj.toString();
	}

	@RequestMapping(value = "/file/uploadPicture.do")
	@ResponseBody
	public String uploadPicture(@RequestParam(value = "file", required = false) CommonsMultipartFile file,
			String objectId, String typeId, @RequestParam(defaultValue = "") String callBack, String property,
			HttpServletRequest request) {
		System.out.println("++++++++++uploadPicture++++++++++++++++++");
		String result = "";
		String realFileName = file.getOriginalFilename();
		System.out.println("++++++++++name=" + realFileName + "++++++++++++++++++");
		// String destDir = Tools.getServicePath(request);
		String destDir = config.getRootPath();
		String saveUrl = "";
		String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1).toUpperCase();
		System.out.println(suffix);
		int indexOf = config.getImageType().indexOf(suffix);
		int indexOf2 = config.getFileType().indexOf(suffix);
		System.out.println(indexOf);
		System.out.println(indexOf2);
		JSONObject obj = new JSONObject();
		System.out.println("++++++++++size=" + file.getSize() + "++++++++++++++++++");
		/**
		 * 文件大小拦截，不能超过20M
		 */
		if (file.getSize() > 20 * 1024 * 1024 * config.getFileSize()) {
			System.out.println("++++++++++size is to big++++++++++++++++++");
			obj.put("error", 1);
			result = "[ERROR]文件超过最大限制，请上传小于" + (20 * config.getFileSize()) + "M的文件";
		} else if (indexOf < 0 && indexOf2 < 0) {
			// 检查扩展名
			obj.put("error", 1);
			result = "[ERROR]上传文件格式不对";
			System.out.println("++++++++++suffix is error++++++++++++++++++");
		} else {
			// 检查扩展名
			if (indexOf >= 0) {
				saveUrl += "back/picture";
			} else {
				saveUrl += "back/picture";
			}

			//通过类型分发存储文件
			saveUrl = appandSavePath(typeId, saveUrl);

			String uuidStr = UUID.randomUUID().toString().replace("-", "");
			String targetFileName = uuidStr + "." + suffix;
			// 保存图片
			try {
				//上传到临时文件夹中
				String tempPath =System.getProperty("java.io.tmpdir")+File.separator;
				if (!new File(tempPath + destDir + saveUrl).exists()) {
					new File(tempPath + destDir + saveUrl).mkdirs();
				}
				File targetFile = new File(tempPath + destDir + saveUrl, targetFileName);
//				File targetFile = new File(destDir + saveUrl, targetFileName);

				//将CommonsMultipartFile转成File
				/*DiskFileItem fi = (DiskFileItem) file.getFileItem();  
				File toTranFile = fi.getStoreLocation(); */ 
				//现将图片存到本地
				file.transferTo(targetFile);
				ftpUtil = new FtpUtil(config.getFtpUrl(), Integer.valueOf(config.getFtpPort()), config.getFtpUserName(), config.getFtpPassWord());
				boolean uploadFtpFile = ftpUtil.uploadFtpFile(destDir + saveUrl, realFileName, file.getInputStream());

				//将不合格图片倒转
				Metadata metadata = ImageMetadataReader.readMetadata(targetFile);
				ExifIFD0Directory ifd0directory=metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
				int orientation = 1;
				if(!MyString.isEmpty(ifd0directory)){
					try {
						orientation=MyString.isEmpty(ifd0directory)?1:ifd0directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
						int rotate=0;
						//判断旋转角度
						switch(orientation){
						case 8://原图需要顺时针转90度
							rotate=90;
							break;
						case 3://原图需要顺时针转180度
							rotate=180;
							break;
						case 6://原图需要顺时针转270度
							rotate=270;
							break;
						}
						//生成图片
						if(rotate != 0){
							String saveImagePath = destDir + saveUrl + "/" + uuidStr;
							Thumbnails.of(targetFile).scale(1f).rotate(rotate).outputFormat(suffix).outputQuality(1.0f).toFile(saveImagePath);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				//读取生成图片的长和宽
				BufferedImage sourceImg = ImageIO.read(new FileInputStream(targetFile));
				int width=sourceImg.getWidth();
				int height=sourceImg.getHeight();

				Picture picture = new Picture();
				// 存数据库
				picture.setObjectId(objectId);
				picture.setTypeId(typeId);
				picture.setName(realFileName);
				picture.setUrl(saveUrl + "/" + targetFileName);
				picture.setStatus((byte) 1);
//				picture.setIsMain((byte) 1);
				
				picture.setPicWidth(width);
				picture.setPicHeight(height);
				Picture pic = setMain(picture);
				Picture savePic = pictureService.save(pic);
				String picId = savePic.getId();
				String picName = savePic.getName();
				result = config.getRootUrl() + saveUrl + "/" + targetFileName;
				obj.put("error", 0);
				obj.put("state", "SUCCESS");
				obj.put("url", result);
				obj.put("picId", picId);
				obj.put("picName", picName);
			} catch (Exception e) {
				obj.put("error", 1);
				e.printStackTrace();
				result = "[ERROR]上传失败";
			}

		}
		if (!callBack.equals("")) {
			if (result.indexOf("[ERROR]") < 0) {
				//				printMsg("<script>parent." + callBack + "('[OK]上传成功','" + result + "','" + property + "')</script>");
			} else {
				//				printMsg("<script>parent.uploadImgCallBack('[ERROR]上传失败','" + result + "')</script>");
			}
		} else {
			obj.put("message", result);
			// printMsg(obj.toString());
		}
		return obj.toString();
	}


	// 设置主图
	public Picture setMain(Picture pic) throws MyException {
		ftpUtil = new FtpUtil(config.getFtpUrl(), Integer.valueOf(config.getFtpPort()), config.getFtpUserName(), config.getFtpPassWord());
		try {

			// 获取新主图存放路径
			String url = pic.getUrl();
			url = url.replace("_wm.", ".");
			String rootPath = config.getRootPath();
			String imagePath = rootPath + url;
			// 设置缩略图的存放路径路径
			int lastIndexOf = url.lastIndexOf("/");
			String substring = url.substring(0, lastIndexOf);
			String imageName = url.substring(lastIndexOf + 1);
			
			//上传到临时文件夹中
			String tempPath =System.getProperty("java.io.tmpdir")+File.separator;

			if (MyString.isEmpty(pic.getThumb1())) {
				// 藏品详情页大图C1（640*426）
				if (!new File(tempPath + rootPath + substring).exists()) {
					new File(tempPath + rootPath + substring).mkdirs();
				}
				String thumbUrl1 = substring + "/640x426_" + imageName;
				String thumbnailPath1 = rootPath + thumbUrl1;
				if (config.getPlatformId() == 2) {
					String filePathString = config.getRootPath() + "shuiyin/C2_640.png";
					//				 File file1 =new File("E:\\yp\\workspaces1220\\mip\\src\\main\\webapp\\shandong_project\\img\\C2_640.png");
					//					BufferedImage watermarkImagePath1 = ImageIO.read(new FileInputStream(filePathString));
					BufferedImage watermarkImagePath1 = null;
					// 生成缩略图
					Map<String, Integer> thumb1 = ImageHepler.createThumbsAddWatermark(tempPath + imagePath, tempPath + thumbnailPath1, 640, 426,watermarkImagePath1);
					pic.setThumb1(thumbUrl1);
					pic.setThumb1Width(thumb1.get("width"));
					pic.setThumb1Height(thumb1.get("height"));
				}else {
					// 生成缩略图
					Map<String, Integer> thumb1 = ImageHepler.createThumbsAddWatermark(tempPath + imagePath, tempPath + thumbnailPath1, 640, 426, null);
					pic.setThumb1(thumbUrl1);
					pic.setThumb1Width(thumb1.get("width"));
					pic.setThumb1Height(thumb1.get("height"));
				}
				File thumbnailFile = new File(tempPath + thumbnailPath1);
				InputStream thumbnailFileIs = new FileInputStream(thumbnailFile);
				//将缩略图上传到ftp
				boolean uploadFtpFile = ftpUtil.uploadFtpFile(thumbnailPath1.substring(0, thumbnailPath1.lastIndexOf("/640x426_" + imageName)-1), "/640x426_" + imageName, thumbnailFileIs);
			}

			if (MyString.isEmpty(pic.getThumb2())) {
				// 藏品详情页相关图等C2（278*）
				if (!new File(tempPath + rootPath + substring).exists()) {
					new File(tempPath + rootPath + substring).mkdirs();
				}
				String thumbUrl2 = substring + "/278x_" + imageName;
				String thumbnailPath2 = rootPath + thumbUrl2;
				if (config.getPlatformId() == 2) {
					String filePathString = config.getRootPath() + "shuiyin/C1_278.png";
					// File file1 =new
					// File("E:\\yp\\workspaces1220\\mip\\src\\main\\webapp\\shandong_project\\img\\C1_278.png");
					//					BufferedImage watermarkImagePath2 = ImageIO.read(new FileInputStream(filePathString));
					BufferedImage watermarkImagePath2 = null;
					// 生成缩略图
					Map<String, Integer> thumb2 = ImageHepler.createThumbsAddWatermark(tempPath + imagePath, tempPath + thumbnailPath2, 278,
							0, watermarkImagePath2);
					pic.setThumb2(thumbUrl2);
					pic.setThumb2Width(thumb2.get("width"));
					pic.setThumb2Height(thumb2.get("height"));
				}else {
					Map<String, Integer> thumb2 = ImageHepler.createThumbsAddWatermark(tempPath + imagePath, tempPath + thumbnailPath2, 278,
							0, null);
					pic.setThumb2(thumbUrl2);
					pic.setThumb2Width(thumb2.get("width"));
					pic.setThumb2Height(thumb2.get("height"));
				}
				File thumbnailFile = new File(tempPath + thumbnailPath2);
				InputStream thumbnailFileIs = new FileInputStream(thumbnailFile);
				//将缩略图上传到ftp
				boolean uploadFtpFile = ftpUtil.uploadFtpFile(thumbnailPath2.substring(0, thumbnailPath2.lastIndexOf("/278x_" + imageName)-1), "/278x_" + imageName, thumbnailFileIs);
			}

			if (MyString.isEmpty(pic.getThumb3())) {
				// 藏品详情页相关图等C1（192*128）
				if (!new File(tempPath + rootPath + substring).exists()) {
					new File(tempPath + rootPath + substring).mkdirs();
				}
				String thumbUrl3 = substring + "/192x128_" + imageName;
				String thumbnailPath3 = rootPath + thumbUrl3;
				if (config.getPlatformId() == 2) {
					String filePathString = config.getRootPath() + "shuiyin/C3_192.png";
					//					File file1 =new File("E:\\yp\\workspaces1220\\mip\\src\\main\\webapp\\shandong_project\\img\\C3_192.png");
					//					BufferedImage watermarkImagePath3 = ImageIO.read(new FileInputStream(filePathString));
					BufferedImage watermarkImagePath3 = null;
					// 生成缩略图
					Map<String, Integer> thumb3 = ImageHepler.createThumbsAddWatermark(tempPath + imagePath, tempPath + thumbnailPath3, 192, 128, watermarkImagePath3);
					pic.setThumb3(thumbUrl3);
					pic.setThumb3Width(thumb3.get("width"));
					pic.setThumb3Height(thumb3.get("height"));
				}else {
					Map<String, Integer> thumb3 = ImageHepler.createThumbsAddWatermark(tempPath + imagePath, tempPath + thumbnailPath3, 192, 128, null);
					pic.setThumb3(thumbUrl3);
					pic.setThumb3Width(thumb3.get("width"));
					pic.setThumb3Height(thumb3.get("height"));
				}
				File thumbnailFile = new File(tempPath + thumbnailPath3);
				InputStream thumbnailFileIs = new FileInputStream(thumbnailFile);
				//将缩略图上传到ftp
				boolean uploadFtpFile = ftpUtil.uploadFtpFile(thumbnailPath3.substring(0, thumbnailPath3.lastIndexOf("/192x128_" + imageName)-1), "/192x128_" + imageName, thumbnailFileIs);
			}

			
			pic.setIsMain((byte) 1);

			return pic;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	private String appandSavePath(String typeId, String saveUrl) {
		switch (typeId) {
		case "3":
			saveUrl += "/wenwu";
			break;
		case "4":
			saveUrl += "/huashi";
			break;
		case "5":
			saveUrl += "/spreadtrum";
			break;
		case "6":
			saveUrl += "/outSpreadtrum";
			break;
		case "7":
			saveUrl += "/virtualShowroom";
			break;
		case "8":
			saveUrl += "/picSearch";
			break;
		case "10":
			saveUrl += "/wenchuang";
			break;
		case "11":
			saveUrl += "/jilinArticle";
			break;
		case "12":
			saveUrl += "/activity";
			break;
		case "13":
			saveUrl += "/carousel";
			break;
		case "14":
			saveUrl += "/museumCarousel";
			break;
		case "20":
			saveUrl += "/user";
			break;
		case "21":
			saveUrl += "/museumInfo";
			break;
		case "22":
			saveUrl += "/exhibition";
			break;
		case "30":
			saveUrl += "/watermark";
			break;
		default:
			saveUrl += "/other";
			break;
		}
		return saveUrl;
	}

	// 上传音频
	@RequestMapping(value = "/file/uploadAudio.do")
	@ResponseBody
	public String uploadAudio(@RequestParam(value = "file", required = false) CommonsMultipartFile file,
			String objectId, String typeId, @RequestParam(defaultValue = "") String callBack, String property,
			HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		String result = "";
		if (file.isEmpty()) {
			obj.put("error", 1);
			result = "[ERROR]上传文件为空";
			obj.put("message", result);
			return obj.toString();
		}

		String realFileName = file.getOriginalFilename();
		// String destDir = Tools.getServicePath(request);
		String destDir = config.getRootPath();
		String saveUrl = "";
		String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1);


		/**
		 * 文件大小拦截，不能超过50M
		 */
		if (file.getSize() > 2.5 * 1024 * 1024 * config.getFileSize()) {
			obj.put("error", 1);
			result = "[ERROR]文件超过最大限制，请上传小于" + (50 * config.getFileSize()) + "M的文件";
		} else if (config.getAudioType().indexOf(suffix) < 0) {
			// 检查扩展名
			obj.put("error", 1);
			result = "[ERROR]上传失败";
		} else {
			// 检查扩展名
			if (config.getAudioType().indexOf(suffix) >= 0) {
				saveUrl += "back/audio";
			} else {
				saveUrl += "back/audio";
			}

			String targetFileName = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
			// 保存图片
			try {
				/*if (!new File(destDir + saveUrl).exists()) {
					new File(destDir + saveUrl).mkdirs();
				}*/
//				File targetFile = new File(destDir + saveUrl, targetFileName);
				//原来版本：上传到本地
//				file.transferTo(targetFile);
				//现在版本：上传到ftp
				ftpUtil = new FtpUtil(config.getFtpUrl(), Integer.valueOf(config.getFtpPort()), config.getFtpUserName(), config.getFtpPassWord());
				boolean uploadFtpFile = ftpUtil.uploadFtpFile(destDir + saveUrl, targetFileName, file.getInputStream());

				result = saveUrl + "/" + targetFileName;
				obj.put("error", 0);
				obj.put("state", "SUCCESS");
				obj.put("url", result);
				obj.put("src", config.getRootUrl() + result);
			} catch (Exception e) {
				obj.put("error", 1);
				e.printStackTrace();
				result = "[ERROR]上传失败";
			}

		}
		if (!callBack.equals("")) {
			if (result.indexOf("[ERROR]") < 0) {
				//				printMsg("<script>parent." + callBack + "('[OK]上传成功','" + result + "','" + property + "')</script>");
			} else {
				//				printMsg("<script>parent.uploadImgCallBack('[ERROR]上传失败','" + result + "')</script>");
			}
		} else {
			obj.put("message", result);
			// printMsg(obj.toString());
		}
		return obj.toString();
	}

	// 上传视频
	@RequestMapping(value = "/file/uploadVideo.do")
	@ResponseBody
	public String uploadVideo(@RequestParam(value = "file", required = false) CommonsMultipartFile file,
			String objectId, String typeId, @RequestParam(defaultValue = "") String callBack, String property,
			HttpServletRequest request) {
		String result = "";
		String realFileName = file.getOriginalFilename();
		// String destDir = Tools.getServicePath(request);
		String destDir = config.getRootPath();
		String saveUrl = "";
		String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1).toUpperCase();
		JSONObject obj = new JSONObject();
		/**
		 * 文件大小拦截，不能超过50M
		 */
		if (file.getSize() > (10 * 1024 * 1024 * config.getFileSize())) {
			obj.put("error", 1);
			result = "[ERROR]文件超过最大限制，请上传小于" + (200 * config.getFileSize()) + "M的文件";
		} else if (config.getImageType().indexOf(suffix) < 0 && config.getFileType().indexOf(suffix) < 0) {
			// 检查扩展名
			obj.put("error", 1);
			result = "[ERROR]上传文件格式不对";
		} else {
			// 检查扩展名
			if (config.getImageType().indexOf(suffix) >= 0) {
				saveUrl += "back/video";
			} else {
				saveUrl += "back/video";
			}

			String targetFileName = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
			// 保存图片
			try {
				/*if (!new File(destDir + saveUrl).exists()) {
					new File(destDir + saveUrl).mkdirs();
				}*/
//				File targetFile = new File(destDir + saveUrl, targetFileName);
				//原来版本：上传到本地
//				file.transferTo(targetFile);
				//现在版本：上传到ftp
				ftpUtil = new FtpUtil(config.getFtpUrl(), Integer.valueOf(config.getFtpPort()), config.getFtpUserName(), config.getFtpPassWord());
				boolean uploadFtpFile = ftpUtil.uploadFtpFile(destDir + saveUrl, targetFileName, file.getInputStream());

				result = saveUrl + "/" + targetFileName;
				obj.put("error", 0);
				obj.put("state", "SUCCESS");
				obj.put("url", result);
				obj.put("src", config.getRootUrl() + result);
			} catch (Exception e) {
				obj.put("error", 1);
				e.printStackTrace();
				result = "[ERROR]上传失败";
			}

		}
		if (!callBack.equals("")) {
			if (result.indexOf("[ERROR]") < 0) {
				//				printMsg("<script>parent." + callBack + "('[OK]上传成功','" + result + "','" + property + "')</script>");
			} else {
				//				printMsg("<script>parent.uploadImgCallBack('[ERROR]上传失败','" + result + "')</script>");
			}
		} else {
			obj.put("message", result);
			// printMsg(obj.toString());
		}
		return obj.toString();
	}

	/**
	 * 策展上传图片
	 * @param file
	 * @param id
	 * @param cid
	 * @param imageName
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/file/uploadAndCut.do")
	// @AuthPassport
	@ResponseBody
	public JsonResult uploadAndCut(@RequestParam(value = "file", required = false) CommonsMultipartFile file, int num, @ModelAttribute Curation curation, 
			HttpServletRequest request) {

		String result = "";
		String realFileName = file.getOriginalFilename();
		String destDir = config.getRootPath();
		String saveUrl = "";
		String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1).toLowerCase();
		Map obj = new HashMap<String, Object>();
		String  uuidStr = UUID.randomUUID().toString().replace("-", "");
		/**
		 * 文件大小拦截，不能超过20M
		 */
		if (file.getSize() > 1024 * 1024 * config.getFileSize()) {
			obj.put("error", 1);
			result = "[ERROR]文件超过最大限制，请上传小于" + config.getFileSize() + "M的文件";
		} else if (config.getImageType().indexOf(suffix) < 0 && config.getFileType().indexOf(suffix) < 0) {
			// 检查扩展名
			obj.put("error", 1);
			result = "[ERROR]上传文件格式不对";
		} else {

			int x = 0;
			int y = 0;
			int width = 0;
			int height = 0;

			// 获取缩放或截图后图片的参数
			String tailor = request.getParameter("tailor");
			// 判断是否裁剪
			if (!"false".equals(tailor)) {
				// 裁剪

				net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(tailor);
				Map map = jsonObject;// new HashMap();
				/*
				 * Map map = new HashMap<>(); JSONObject jsonObject = new
				 * JSONObject(tailor); for (Iterator iter = jsonObject.keys();
				 * iter.hasNext();) { String key = (String) iter.next();
				 * map.put(key, jsonObject.get(key)); }
				 */
				String xString = map.get("x").toString();
				if (xString.contains(".")) {
					Double doubleX = (Double) map.get("x");
					x = Integer.valueOf(doubleX.intValue());
				}else {
					x = (Integer) map.get("x");
				}

				String yString = map.get("y").toString();
				if (yString.contains(".")) {
					Double doubleY = (Double) map.get("y");
					y = Integer.valueOf(doubleY.intValue());
				}else {
					y = (Integer) map.get("y");
				}

				String widthStr = map.get("width").toString();
				if (widthStr.contains(".")) {
					Double doubleWidth = (Double) map.get("width");
					width = Integer.valueOf(doubleWidth.intValue());
				}else {
					width = (Integer) map.get("width");
				}
				//				
				String heiStr = map.get("height").toString();
				if (heiStr.contains(".")) {
					Double doubleHeight = (Double) map.get("height");
					height = Integer.valueOf(doubleHeight.intValue());
				}else{
					height = (Integer) map.get("height");
				}

			}
			// 检查扩展名
			saveUrl += "back/picture/cezhan/"+uuidStr;

			realFileName = num + "." + "png";

			Rectangle rect = new Rectangle();

			rect.setBounds(x, y, width, height);

			// 縮放或裁剪
			try {
				if (!new File(destDir + saveUrl).exists()) {
					new File(destDir + saveUrl).mkdirs();
				}
				File targetFile = new File(destDir + saveUrl, realFileName);

				File srcFile = commonMultipartToFile(file);

				String url = saveUrl + "/" +realFileName;

				ImageHepler.cutAndscaleImage(srcFile, targetFile, curation.getTitle(), 640, 386, rect);

				curation = curationService.get(curation.getId());

				//保存数据库
				/*switch (num) {
				case 1:
					curation.setImage1(url);
					break;
				case 2:
					curation.setImage2(url);
					break;
				case 3:
					curation.setImage3(url);
					break;
				case 4:
					curation.setImage4(url);
					break;
				case 5:
					curation.setImage5(url);
					break;
				case 6:
					curation.setImage6(url);
					break;
				case 7:
					curation.setImage7(url);
					break;
				case 8:
					curation.setImage8(url);
					break;
				case 9:
					curation.setImage9(url);
					break;
				case 10:
					curation.setImage10(url);
					break;
				case 11:
					curation.setImage11(url);
					break;
				case 12:
					curation.setImage12(url);
					break;
				default:
					break;
				}

				//将状态设置为不可用
				curation.setStatus((byte)0);

				//保存
				curationService.update(curation);
				 */
				result = saveUrl + realFileName;
				obj.put("error", 0);
				obj.put("state", "SUCCESS");
				obj.put("url", url);
				obj.put("rootUrl", config.getRootUrl());
			} catch (Exception e) {
				obj.put("error", 1);
				e.printStackTrace();
				result = "[ERROR]上传失败";
			}

		}
		return new JsonResult(1, obj);
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/file/uploadAndCutStr.do")
	// @AuthPassport
	@ResponseBody
	public JsonResult uploadAndCutStr(String imgUrl, int num, @ModelAttribute Curation curation, 
			HttpServletRequest request) {
		if (MyString.isEmpty(imgUrl)) {
			return new JsonResult(0, "图片路径不可为空！");
		}
		//修改字符串路径
		imgUrl = imgUrl.replace(config.getRootUrl(), config.getRootPath());

		File file = new File(imgUrl);
		if (MyString.isEmpty(file)) {
			return new JsonResult(0, "不存在此图片！");
		}

		String result = "";
		//		String realFileName = file.getOriginalFilename();
		String realFileName = file.getName();
		String destDir = config.getRootPath();
		String saveUrl = "";
		String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1).toLowerCase();
		Map obj = new HashMap<String, Object>();
		String  uuidStr = UUID.randomUUID().toString().replace("-", "");
		/**
		 * 文件大小拦截，不能超过20M
		 */

		long length = file.length();

		if (length > 1024 * 1024 * config.getFileSize()) {
			obj.put("error", 1);
			result = "[ERROR]文件超过最大限制，请上传小于" + config.getFileSize() + "M的文件";
		} else if (config.getImageType().indexOf(suffix) < 0 && config.getFileType().indexOf(suffix) < 0) {
			// 检查扩展名
			obj.put("error", 1);
			result = "[ERROR]上传文件格式不对";
		} else {

			int x = 0;
			int y = 0;
			int width = 0;
			int height = 0;

			// 获取缩放或截图后图片的参数
			String tailor = request.getParameter("tailor");
			// 判断是否裁剪
			if (!"false".equals(tailor)) {
				// 裁剪

				net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(tailor);
				Map map = jsonObject;// new HashMap();
				String xString = map.get("x").toString();
				if (xString.contains(".")) {
					Double doubleX = (Double) map.get("x");
					x = Integer.valueOf(doubleX.intValue());
				}else {
					x = (Integer) map.get("x");
				}

				String yString = map.get("y").toString();
				if (yString.contains(".")) {
					Double doubleY = (Double) map.get("y");
					y = Integer.valueOf(doubleY.intValue());
				}else {
					y = (Integer) map.get("y");
				}

				String widthStr = map.get("width").toString();
				if (widthStr.contains(".")) {
					Double doubleWidth = (Double) map.get("width");
					width = Integer.valueOf(doubleWidth.intValue());
				}else {
					width = (Integer) map.get("width");
				}
				//				
				String heiStr = map.get("height").toString();
				if (heiStr.contains(".")) {
					Double doubleHeight = (Double) map.get("height");
					height = Integer.valueOf(doubleHeight.intValue());
				}else{
					height = (Integer) map.get("height");
				}

			}
			// 检查扩展名
			saveUrl += "back/picture/cezhan/"+uuidStr;

			realFileName = num + "." + "png";

			Rectangle rect = new Rectangle();

			rect.setBounds(x, y, width, height);

			// 縮放或裁剪
			try {
				if (!new File(destDir + saveUrl).exists()) {
					new File(destDir + saveUrl).mkdirs();
				}
				File targetFile = new File(destDir + saveUrl, realFileName);

				File srcFile = file;

				String url = saveUrl + "/" +realFileName;

				ImageHepler.cutAndscaleImage(srcFile, targetFile, curation.getTitle(), 640, 386, rect);

				curation = curationService.get(curation.getId());

				result = saveUrl + realFileName;
				obj.put("error", 0);
				obj.put("state", "SUCCESS");
				obj.put("url", url);
				obj.put("rootUrl", config.getRootUrl());
			} catch (Exception e) {
				obj.put("error", 1);
				e.printStackTrace();
				result = "[ERROR]上传失败";
			}

		}
		return new JsonResult(1, obj);
	}

	/**
	 * MultipartFile 转换成File
	 * 
	 * @param multfile
	 *            原文件类型
	 * @return File
	 * @throws IOException
	 */
	private File commonMultipartToFile(CommonsMultipartFile cf) throws IOException {
		File file = null;
		try {
			file=File.createTempFile("tmp", null);
			cf.transferTo(file);
			file.deleteOnExit();        
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}


	@RequestMapping(value = "/aaaa/uploadImage.do")
	@ResponseBody
	public Map<String, Object> uploadImage(@RequestParam(value = "upfile", required = false) CommonsMultipartFile upfile, HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> params = new HashMap<String, Object>();
		try{
			String basePath = config.getRootPath();//存放根路径
			String visitUrl = config.getRootUrl();//访问根路径
			String realFileName = upfile.getOriginalFilename();//原名
			String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1).toUpperCase();
			String fileName = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
			StringBuilder sb = new StringBuilder();
			//拼接保存路径
			sb.append(basePath).append("back/picture/").append(fileName);
			visitUrl = visitUrl + "back/picture/"+fileName;
			File f = new File(sb.toString());
			if(!f.exists()){
				f.getParentFile().mkdirs();
			}
			OutputStream out = new FileOutputStream(f);
			FileCopyUtils.copy(upfile.getInputStream(), out);
			params.put("state", "SUCCESS");
			params.put("url", visitUrl);
			params.put("size", upfile.getSize());
			params.put("original", fileName);
			params.put("type", upfile.getContentType());
		} catch (Exception e){
			params.put("state", "ERROR");
		}
		return params;
	}

	@RequestMapping(value = "/file/uploadSearchPicture.do")
	@ResponseBody
	public String uploadSearchPicture(@RequestParam(value = "file", required = false) CommonsMultipartFile file,
			String objectId, String typeId, @RequestParam(defaultValue = "") String callBack, String property,
			HttpServletRequest request) {

		String result = "";
		String realFileName = file.getOriginalFilename();
		// String destDir = Tools.getServicePath(request);
		String destDir = config.getRootPath();
		String saveUrl = "";
		String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1).toUpperCase();
		JSONObject obj = new JSONObject();

		/**
		 * 文件大小拦截，不能超过20M
		 */
		if (file.getSize() > 20 * 1024 * 1024 * config.getFileSize()) {
			obj.put("error", 1);
			result = "[ERROR]文件超过最大限制，请上传小于" + (20 * config.getFileSize()) + "M的文件";
		} else if (config.getImageType().indexOf(suffix) < 0 && config.getFileType().indexOf(suffix) < 0) {
			// 检查扩展名
			obj.put("error", 1);
			result = "[ERROR]上传文件格式不对";
		} else {
			// 检查扩展名
			if (config.getImageType().indexOf(suffix) >= 0) {
				saveUrl += "back/picture";
			} else {
				saveUrl += "back/picture";
			}

			String targetFileName = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
			// 保存图片
			try {
				/*if (!new File(destDir + saveUrl).exists()) {
					new File(destDir + saveUrl).mkdirs();
				}*/
				File targetFile = new File(destDir + saveUrl, targetFileName);
				//原来版本：上传到本地
//				file.transferTo(targetFile);
				//现在版本：上传到ftp
				ftpUtil = new FtpUtil(config.getFtpUrl(), Integer.valueOf(config.getFtpPort()), config.getFtpUserName(), config.getFtpPassWord());
				boolean uploadFtpFile = ftpUtil.uploadFtpFile(destDir + saveUrl, targetFileName, file.getInputStream());

				Picture picture = new Picture();

				// 存数据库
				picture.setObjectId(objectId);
				picture.setTypeId(typeId);
				picture.setName(realFileName);
				picture.setUrl(saveUrl + "/" + targetFileName);
				picture.setStatus((byte) 1);
				picture.setIsMain((byte) 1);
				// 获取原图真实长宽
				//				BufferedImage sourceImg = ImageIO.read(new FileInputStream(targetFile));
				//				picture.setPicWidth(sourceImg.getWidth());
				//				picture.setPicHeight(sourceImg.getHeight());
				Picture savePic = pictureService.save(picture);
				String picId = savePic.getId();
				String picName = savePic.getName();
				result = config.getRootUrl() + saveUrl + "/" + targetFileName;
				obj.put("error", 0);
				obj.put("state", "SUCCESS");
				obj.put("url", result);
				obj.put("picId", picId);
				obj.put("picName", picName);
			} catch (Exception e) {
				obj.put("error", 1);
				e.printStackTrace();
				result = "[ERROR]上传失败";
			}

		}
		if (!callBack.equals("")) {
			if (result.indexOf("[ERROR]") < 0) {
				//				printMsg("<script>parent." + callBack + "('[OK]上传成功','" + result + "','" + property + "')</script>");
			} else {
				//				printMsg("<script>parent.uploadImgCallBack('[ERROR]上传失败','" + result + "')</script>");
			}
		} else {
			obj.put("message", result);
			// printMsg(obj.toString());
		}
		return obj.toString();
	}

	/**
	 * 裁剪并上传图片
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/file/cutPicture.do")
	// @AuthPassport
	@ResponseBody
	public JsonResult cutPicture(@RequestParam(value = "file", required = false) CommonsMultipartFile file, int thumWidth, int thumHeight, String typeId, HttpServletRequest request) {

		//获取用户信息
//		LoginInfoDto cacheUser = (LoginInfoDto) Tools.getUser();
//		if (cacheUser == null) {
//			return new JsonResult(new MyException("200000","请先登录！"));
//		} 
//		String objectId = cacheUser.getId();//用户id

		String result = "";
		String orgFileName = file.getOriginalFilename();//图片名称
		String destDir = config.getRootPath();//根路径
		String saveUrl = "";//图片保存路径
		String suffix = orgFileName.substring(orgFileName.lastIndexOf(".") + 1).toLowerCase();//图片后缀名
		Map<String, Object> obj = new HashMap<String, Object>();
		String uuidStr = UUID.randomUUID().toString().replace("-", "");//uuid字符串
		/**
		 * 文件大小拦截，不能超过20M
		 */
		if (file.getSize() > 1024 * 1024 * config.getFileSize()) {
			return new JsonResult(0, "图片大小超过20M，请上传小于20M的图片");
		} else if (config.getImageType().indexOf(suffix) < 0 && config.getFileType().indexOf(suffix) < 0) {
			// 检查扩展名
			return new JsonResult(0, "图片后缀名错误");
		} else {

			int x = 0;
			int y = 0;
			int width = 0;
			int height = 0;

			// 获取缩放或截图后图片的参数
			String tailor = request.getParameter("tailor");
			// 判断是否裁剪
			if (!"false".equals(tailor)) {
				// 裁剪
				net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(tailor);
				Map map = jsonObject;// new HashMap();
				String xString = map.get("x").toString();
				if (xString.contains(".")) {
					Double doubleX = (Double) map.get("x");
					x = Integer.valueOf(doubleX.intValue());
				}else {
					x = (Integer) map.get("x");
				}

				String yString = map.get("y").toString();
				if (yString.contains(".")) {
					Double doubleY = (Double) map.get("y");
					y = Integer.valueOf(doubleY.intValue());
				}else {
					y = (Integer) map.get("y");
				}

				String widthStr = map.get("width").toString();
				if (widthStr.contains(".")) {
					Double doubleWidth = (Double) map.get("width");
					width = Integer.valueOf(doubleWidth.intValue());
				}else {
					width = (Integer) map.get("width");
				}
				//				
				String heiStr = map.get("height").toString();
				if (heiStr.contains(".")) {
					Double doubleHeight = (Double) map.get("height");
					height = Integer.valueOf(doubleHeight.intValue());
				}else{
					height = (Integer) map.get("height");
				}

			}

			saveUrl += "back/picture/cut";

			//通过类型分发存储文件
			saveUrl = appandSavePath(typeId, saveUrl);

			String realFileName = uuidStr + "." + suffix;

			Rectangle rect = new Rectangle();

			rect.setBounds(x, y, width, height);

			// 縮放或裁剪
			try {
				//上传到临时文件夹中
				String tempPath =System.getProperty("java.io.tmpdir")+File.separator;
				if (!new File(tempPath + destDir + saveUrl).exists()) {
					new File(tempPath + destDir + saveUrl).mkdirs();
				}
				/*if (!new File(destDir + saveUrl).exists()) {
					new File(destDir + saveUrl).mkdirs();
				}*/
				File targetFile = new File(tempPath + destDir + saveUrl, realFileName);

				File srcFile = commonMultipartToFile(file);

				String url = saveUrl + "/" +realFileName;
				
				Boolean cutAndscaleImage = ImageHepler.cutAndscaleImage(srcFile, targetFile, thumWidth, thumHeight, rect);//剪切、缩放图片及保存图片

				if (!cutAndscaleImage) {
					return new JsonResult(0, "图片模式错误，请确保图片模式为RGB颜色");
				}else {
					//现在版本：上传到ftp
					ftpUtil = new FtpUtil(config.getFtpUrl(), Integer.valueOf(config.getFtpPort()), config.getFtpUserName(), config.getFtpPassWord());
					InputStream targetFileIs = new FileInputStream(targetFile);
					boolean uploadFtpFile = ftpUtil.uploadFtpFile(destDir + saveUrl, realFileName, targetFileIs);
					if(!uploadFtpFile) {
						return new JsonResult(0, "文件上传失败");
					}
				}

				// 图片存数据库
				Picture picture = new Picture();
//				picture.setObjectId(objectId);
				picture.setTypeId(typeId);
				picture.setName(orgFileName);//保存原图片名称
				picture.setUrl(url);
				picture.setStatus((byte) 1);
				//				picture.setIsMain((byte) 1);
				/*// 获取原图真实长宽
				BufferedImage sourceImg = ImageIO.read(new FileInputStream(targetFile));
				picture.setPicWidth(sourceImg.getWidth());
				picture.setPicHeight(sourceImg.getHeight());*/
				Picture savePic = pictureService.save(picture);

				obj.put("picId", savePic.getId());
				obj.put("error", 0);
				obj.put("state", "SUCCESS");
				obj.put("url", url);
				obj.put("rootUrl", config.getRootUrl());
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(0, "系统错误");
			}

		}
		return new JsonResult(1, obj);
	}

	// 上传音频
	@RequestMapping(value = "/front/uploadAudioSY.do")
	@ResponseBody
	public String uploadAudioSY(@RequestParam(value = "file", required = false) CommonsMultipartFile file, HttpServletRequest request) {

		String result = "";
		String realFileName = file.getOriginalFilename();
		// String destDir = Tools.getServicePath(request);
		String destDir = config.getRootPath();
		String saveUrl = "";
		String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1).toUpperCase();
		JSONObject obj = new JSONObject();

		/**
		 * 文件大小拦截，不能超过50M
		 */
		if (file.getSize() > 2.5 * 1024 * 1024 * config.getFileSize()) {
			obj.put("error", 1);
			result = "[ERROR]文件超过最大限制，请上传小于" + (50 * config.getFileSize()) + "M的文件";
		} else if (config.getImageType().indexOf(suffix) < 0 && config.getFileType().indexOf(suffix) < 0) {
			// 检查扩展名
			obj.put("error", 1);
			result = "[ERROR]上传文件格式不对";
		} else {
			// 检查扩展名
			if (config.getImageType().indexOf(suffix) >= 0) {
				saveUrl += "back/audio";
			} else {
				saveUrl += "back/audio";
			}

			String targetFileName = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
			// 保存图片
			try {
				if (!new File(destDir + saveUrl).exists()) {
					new File(destDir + saveUrl).mkdirs();
				}
				File targetFile = new File(destDir + saveUrl, targetFileName);
				file.transferTo(targetFile);

				result = saveUrl + "/" + targetFileName;
				obj.put("error", 0);
				obj.put("state", "SUCCESS");
				obj.put("url", result);
				obj.put("src", config.getRootUrl() + result);
			} catch (Exception e) {
				obj.put("error", 1);
				e.printStackTrace();
				result = "[ERROR]上传失败";
			}

		}

		obj.put("message", result);
		// printMsg(obj.toString());

		return obj.toString();
	}

	/*//生成二维码（带logo）
		@RequestMapping(value = "/createTwoDimensionCode.do")
		@ResponseBody
		public JsonResult createTwoDimensionCode(String content, String picCollectionPicUrl){
			try {
				String imgType = ".png";
				String rootDir = config.getRootPath() + "picture/erweima";
				String id = UUID.randomUUID().toString().replace("-", "");
				String imgPath = "";
				imgPath = rootDir + "/" + id + imgType;
				String imgUrl = config.getRootUrl() + "picture/erweima" + "/" + id +imgType;
				String logo = "";
				if (!MyString.isEmpty(picCollectionPicUrl)) {
					logo = picCollectionPicUrl.replace(config.getRootUrl(), config.getRootPath());
				} 
				if (!new File(rootDir).exists()) {
					new File(rootDir).mkdirs();
				}
				TwoDimensionCode twoDimensionCode = new TwoDimensionCode();
				twoDimensionCode.encoderQRCodeWithLogo(content, logo, imgPath, imgType, 20);

				return new JsonResult(1, imgUrl);
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(0, "系统异常");
			}
		}*/


	//生成二维码（带logo）
	@RequestMapping(value = "/createTwoDimensionCode.do")
	@ResponseBody
	public JsonResult createTwoDimensionCode(String content, String picCollectionPicUrl){
		try {
			String imgType = ".png";
			String rootUrl = config.getRootPath();
			String saveUrl = "picture/erweima/"+ DateFormartUtil.getDateByFormat(DateFormartUtil.YYYY_MM_DD) + "/";
			String id = UUID.randomUUID().toString().replace("-", "");
			String targetFileName = id +imgType;
			String imgPath = rootUrl+saveUrl;
			String logo = "";
			
			//上传到临时文件夹中
			String tempPath =System.getProperty("java.io.tmpdir")+File.separator;
			if (!new File(tempPath + rootUrl + saveUrl).exists()) {
				new File(tempPath + rootUrl + saveUrl).mkdirs();
			}
			File targetFile = new File(tempPath+rootUrl+saveUrl, targetFileName);
			TwoDimensionCode twoDimensionCode = new TwoDimensionCode();
			Boolean cutAndscaleImage =  twoDimensionCode.encoderQRCodeWithLogo(content, logo, targetFile, imgType, 20);
			if(!cutAndscaleImage) {
				return new JsonResult(0, "系统异常");
			}
			
			ftpUtil = new FtpUtil(config.getFtpUrl(), Integer.valueOf(config.getFtpPort()), config.getFtpUserName(), config.getFtpPassWord());
			InputStream targetFileIs = new FileInputStream(targetFile);
			boolean uploadFtpFile = ftpUtil.uploadFtpFile(imgPath, targetFileName, targetFileIs);
			if(!uploadFtpFile) {
				return new JsonResult(0, "系统异常");
			}

			return new JsonResult(1, config.getRootUrl() + saveUrl+targetFileName);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常");
		}
	}


	@RequestMapping(value = "/file/uploadWatermark.do")
	@ResponseBody
	public String uploadWatermark(@RequestParam(value = "file", required = false) CommonsMultipartFile file,
			String objectId, String typeId, @RequestParam(defaultValue = "") String callBack, String property,
			HttpServletRequest request) {

		String result = "";
		String realFileName = file.getOriginalFilename();
		String destDir = config.getRootPath();
		String saveUrl = "";
		String suffix = realFileName.substring(realFileName.lastIndexOf(".") + 1).toUpperCase();
		JSONObject obj = new JSONObject();

		/**
		 * 文件大小拦截，不能超过500k
		 */
		if (file.getSize() > 500 * 1024) {
			obj.put("success", 0);
			result = "[ERROR]文件超过最大限制，请上传小于" + (500) + "K的文件";
		} else if (config.getImageType().indexOf(suffix) < 0 && config.getFileType().indexOf(suffix) < 0) {
			// 检查扩展名
			obj.put("success", 0);
			result = "[ERROR]上传文件格式不对";
		} else {
			// 检查扩展名
			if ("PNG".indexOf(suffix) >= 0) {
				saveUrl += "back/picture";
			} else {
				obj.put("success", 0);
				result = "[ERROR]上传文件格式不对";
			}

			//通过类型分发存储文件
			saveUrl = appandSavePath(typeId, saveUrl);

			String uuidStr = UUID.randomUUID().toString().replace("-", "");
			String targetFileName = uuidStr + "." + suffix;
			// 保存图片
			try {
				if (!new File(destDir + saveUrl).exists()) {
					new File(destDir + saveUrl).mkdirs();
				}
				File targetFile = new File(destDir + saveUrl, targetFileName);

				file.transferTo(targetFile);

				//将CommonsMultipartFile转成File
				/*DiskFileItem fi = (DiskFileItem) file.getFileItem();  
					File toTranFile = fi.getStoreLocation(); */ 
				//现将图片存到本地

				//读取生成图片的长和宽
				BufferedImage sourceImg = ImageIO.read(new FileInputStream(targetFile));
				int width=sourceImg.getWidth();
				int height=sourceImg.getHeight();

				Picture picture = new Picture();
				// 存数据库
				picture.setObjectId(objectId);
				picture.setTypeId(typeId);
				picture.setName(realFileName);
				picture.setUrl(saveUrl + "/" + targetFileName);
				picture.setStatus((byte) 1);
				picture.setIsMain((byte) -1);
				picture.setPicWidth(width);
				picture.setPicHeight(height);
				Picture savePic = pictureService.save(picture);
				String picId = savePic.getId();
				String picName = savePic.getName();
				result = config.getRootUrl() + saveUrl + "/" + targetFileName;
				obj.put("error", 0);
				obj.put("state", "SUCCESS");
				obj.put("url", result);
				obj.put("picId", picId);
				obj.put("picName", picName);
				//存redis当中
				JedisService.set(MessageFormat.format(KeyConstants.ORGANIZATION_WATERMARK_KEY, objectId), saveUrl + "/" + targetFileName);

				obj.put("success", 1);
				result = "[SUCCESS]上传成功";
			} catch (Exception e) {
				obj.put("success", 0);
				e.printStackTrace();
				result = "[ERROR]上传失败";
			}

		}
		if (!callBack.equals("")) {
			if (result.indexOf("[ERROR]") < 0) {
				//					printMsg("<script>parent." + callBack + "('[OK]上传成功','" + result + "','" + property + "')</script>");
			} else {
				//					printMsg("<script>parent.uploadImgCallBack('[ERROR]上传失败','" + result + "')</script>");
			}
		} else {
			obj.put("message", result);
			// printMsg(obj.toString());
		}
		return obj.toString();
	}
}
