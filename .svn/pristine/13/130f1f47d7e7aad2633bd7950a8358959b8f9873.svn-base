/**
 *对图片进行裁剪、缩放 
 */
package com.tj720.mip.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.tj720.mip.model.Picture;
import com.tj720.mip.springbeans.Config;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * @author Administrator
 */
public class ImageHepler {

	/**
	 * @Description 对图像进行剪裁
	 * @param srcImageFile 原图
	 * @param targetImageFile 目标图
	 * @param width 剪裁宽度
	 * @param height 剪裁高度
	 * @param rect
	 */
	public static void cutAndscaleImage(File srcImageFile, File targetImageFile, String imageName, int width, int height, Rectangle rect){
		try {
			InputStream is = new FileInputStream(srcImageFile);
			BufferedImage bImage = ImageIO.read(is);
			bImage = cutImage(bImage, rect);
			System.out.println(rect);
			bImage = makeThumbnail(bImage, width, height);
			
			//演示用，正式后删除
			if (MyString.isEmpty(imageName)) {
				imageName = "中国文物";
			}
			//给图片添加文字
			bImage = addWords(imageName, bImage, rect);
			//将背景设置为透明
//			bImage = setTouMing(bImage);
			ImageIO.write(bImage, "png", targetImageFile);  
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description 对图像进行剪裁
	 * @param srcImageFile 原图
	 * @param targetImageFile 目标图
	 * @param width 剪裁宽度
	 * @param height 剪裁高度
	 * @param rect
	 */
	public static Boolean cutAndscaleImage(File srcImageFile, File targetImageFile, int width, int height, Rectangle rect){
		try {
			InputStream is = new FileInputStream(srcImageFile);
			BufferedImage bImage = ImageIO.read(is);
			bImage = cutImage(bImage, rect);//裁剪
//			System.out.println(rect);
//			System.out.println("targetImageFile:"+targetImageFile);
//			bImage = makeThumbnail2(bImage, width, height);//缩放
			Thumbnails.of(bImage).size(width, height).outputQuality(1.0f).toFile(targetImageFile);
//			ImageIO.write(bImage, "png", targetImageFile); //图片保存到指定位置
			is.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
//	/**
//	 * @Description: 对BufferImage按照(x, y, width, height) = (subImageBounds.x,subImageBounds.y, subImageBounds.width,subImageBounds.height)进行裁剪
//	 *               如果subImageBounds范围过大，则用空白填充周围的区域。
//	 * @param bImage
//	 *            返回处理后的图片缓冲对象
//	 * @param image
//	 * @param subImageBounds
//	 * @throws IOException
//	 */
//	private static BufferedImage cutImage(BufferedImage image, Rectangle subImageBounds) throws IOException { 
//		// 创建一个BufferedImage图片缓冲对象
//		BufferedImage bimage = new BufferedImage(subImageBounds.width, subImageBounds.height, BufferedImage.TYPE_4BYTE_ABGR);
//		// 获取操作图像对象Graphic
//		Graphics2D g = bimage.createGraphics();
//		
//		// 使背景变为透明
//		bimage = g.getDeviceConfiguration().createCompatibleImage(subImageBounds.width, subImageBounds.height, Transparency.TRANSLUCENT);
//		g.dispose();
//		g = bimage.createGraphics();
//		
//		// 对截取框大小和图片大小对比
//		if ((subImageBounds.width > image.getWidth()) || (subImageBounds.height > image.getHeight())) {
//			// 截取框大小 > 图片大小
//			int left = subImageBounds.x;
//			int top = subImageBounds.y;
//			if (image.getWidth() < subImageBounds.width)
//				// 图片宽 < 截取框宽, 将图片左右居中
//				left = (subImageBounds.width - image.getWidth()) / 2;
//			if (image.getHeight() < subImageBounds.height)
//				// 图片高 > 截取框高， 将图片上下居中
//				top = (subImageBounds.height - image.getHeight()) / 2;
//			// 将多出来的边颜色设置为白色
//			/*Color color = new Color(255, 255, 255, 0);
//			g.setColor(color);*/
//			// 填充
//			g.fillRect(0, 0, subImageBounds.width, subImageBounds.height);
//			g.drawImage(image, left, top, null);
//		} else {
//			g.drawImage(
//					image.getSubimage(subImageBounds.x, subImageBounds.y, subImageBounds.width, subImageBounds.height),
//					0, 0, null);
//		}
//		g.dispose();
//		return bimage;
//	}
	/**
	 * @Description: 对BufferImage按照(x, y, width, height) = (subImageBounds.x,subImageBounds.y, subImageBounds.width,subImageBounds.height)进行裁剪
	 *               如果subImageBounds范围过大，则用空白填充周围的区域。
	 * @param bImage
	 *            返回处理后的图片缓冲对象
	 * @param image
	 * @param subImageBounds
	 * @throws IOException
	 */
	private static BufferedImage cutImage(BufferedImage image, Rectangle subImageBounds) throws IOException { 
		// 截取框大小 > 图片大小
		// 创建一个BufferedImage图片缓冲对象
		BufferedImage bimage = new BufferedImage(subImageBounds.width, subImageBounds.height, BufferedImage.TYPE_4BYTE_ABGR);
		// 获取操作图像对象Graphic
		Graphics2D g = bimage.createGraphics();
		
		// 使背景变为透明
		bimage = g.getDeviceConfiguration().createCompatibleImage(subImageBounds.width, subImageBounds.height, Transparency.TRANSLUCENT);
		g.dispose();
		g = bimage.createGraphics();
		
		int left = subImageBounds.x;
		int top = subImageBounds.y;
		int imagewidth=image.getWidth();
		int imageheight=image.getHeight();
		int subwidth=left<0?(imagewidth-left<subImageBounds.width?imagewidth:subImageBounds.width+left):(imagewidth-left<subImageBounds.width?imagewidth-left:subImageBounds.width);
		int subheight=top<0?(imageheight-top<subImageBounds.height?imageheight:subImageBounds.height+top):(imageheight-top<subImageBounds.height?imageheight-top:subImageBounds.height);
//		g.fillRect(0, 0, subImageBounds.width, subImageBounds.height);
		int subleft=left<0?0:left;
		int subtop=top<0?0:top;
		BufferedImage subimage=image.getSubimage(subleft, subtop, subwidth, subheight);
		left=left<0?-left:0;
		top=top<0?-top:0;
		g.drawImage(subimage,left, top, null);
		g.dispose();
		//wyu:利用subImageBounds的y和height回传图片有效区域的左侧和右侧位置，用于写字描绘白底
		subImageBounds.y=left;
		subImageBounds.height=subwidth;
		return bimage;
	}

	/**
	 * @Description: 对剪裁后的图片根据(x, y, width, height) = (0, 0, width, height)进行缩放，生成BufferImage
	 * @param img
	 * @param width  处理后图片的宽度
	 * @param height 处理后图片高度
	 * @return
	 * @throws IOException
	 */
	private static BufferedImage makeThumbnail(BufferedImage img, int width, int height) throws IOException {
		BufferedImage tag = new BufferedImage(width, height + 50, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = tag.getGraphics();
		
//		Color myColor = new Color(0, 0, 0, 0);
//		g.setColor(myColor);
//		g.fillRect(0, 386, width, height);
		
		g.drawImage(img.getScaledInstance(width, height, 4), 0, 0, null);
		
		g.dispose();
		return tag;
	}
	
	/**
	 * @Description: 对剪裁后的图片根据(x, y, width, height) = (0, 0, width, height)进行缩放，生成BufferImage
	 * @param img
	 * @param width  处理后图片的宽度
	 * @param height 处理后图片高度
	 * @return
	 * @throws IOException
	 */
	private static BufferedImage makeThumbnail2(BufferedImage img, int width, int height) throws IOException {
		BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = tag.getGraphics();
		g.drawImage(img.getScaledInstance(width, height, 4), 0, 0, null);
		g.dispose();
		return tag;
	}
	
	private static BufferedImage addWords(String imageName, BufferedImage bImage, Rectangle rect) throws IOException {
		//得到画笔对象
		Graphics g = bImage.getGraphics();
		
        //最后一个参数用来设置字体的大小  
        Font f = new Font("宋体",Font.PLAIN,18);
        g.setFont(f);  
         
        FontMetrics metrics = g.getFontMetrics();
        Rectangle2D rc = metrics.getStringBounds(imageName, g);
        double wordsWidth = rc.getWidth();
        //x,y表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。 
        int x = (640 - (int)wordsWidth)/2;
        int y = 416;
		//wyu:写字区域描绘白底
        int left=rect.y*bImage.getWidth()/rect.width<x?rect.y*bImage.getWidth()/rect.width:x-1;
        int width=rect.height*bImage.getWidth()/rect.width>wordsWidth?rect.height*bImage.getWidth()/rect.width:(int)wordsWidth+1;
		g.fillRect(left, bImage.getHeight()-50, width, 50);

        Color mycolor = new Color(33, 33, 33);  
        g.setColor(mycolor);
		g.drawString(imageName, x, y);
		
		g.dispose();
		
		return bImage;
	}
	
	private static BufferedImage setTouMing(BufferedImage bImage){
		 int imgHeight = bImage.getHeight();//取得图片的长和宽
         int imgWidth = bImage.getWidth();
         int c = bImage.getRGB(3, 3);
		BufferedImage bi = new BufferedImage(imgWidth, imgHeight,
                BufferedImage.TYPE_4BYTE_ABGR);//新建一个类型支持透明的BufferedImage
		for(int i = 0; i < imgWidth; ++i)//把原图片的内容复制到新的图片，同时把背景设为透明
        {
            for(int j = 0; j < imgHeight; ++j)
            {
                if(bImage.getRGB(i, j) == c)
                    bi.setRGB(i, j, c & 0x00ffffff);//这里把背景设为透明
                else
                    bi.setRGB(i, j, bImage.getRGB(i, j));
            }
        }
		return bImage;
	}
	
	//生成缩略图,并返回缩略图宽和高(若没有高或宽的限定，设置为0)
	public static Map createThumbs(String imagePath, String thumbnailPath, int width, int height) throws IOException{
		
		if (width != 0 && height != 0) {
			Thumbnails.of(imagePath)   
			.size(width, height)
			.outputQuality(0.9)
			.toFile(thumbnailPath);  
		} 
		if(height == 0){
			Thumbnails.of(imagePath)   
			.width(width)
			.outputQuality(0.9)
			.toFile(thumbnailPath);
		} 
		if (width == 0) {
			Thumbnails.of(imagePath)   
			.height(height)
			.outputQuality(0.9)
			.toFile(thumbnailPath);
		}
		//创建一个map，存储图片长和宽
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//获取缩略图图片真实长宽
		BufferedImage sourceImg =ImageIO.read(new FileInputStream(new File(thumbnailPath))); 
		map.put("width", sourceImg.getWidth());
		map.put("height", sourceImg.getHeight());
		
		return map;
	}
	
	//生成缩略图加水印
		public static Map createThumbsAddWatermark(String imagePath, String thumbnailPath, int width, int height, BufferedImage watermarkImagePath) throws IOException{
			if (!MyString.isEmpty(watermarkImagePath)) {
				if (width != 0 && height != 0) {
					Thumbnails.of(imagePath)   
					.size(width, height)
					.watermark(Positions.BOTTOM_RIGHT, watermarkImagePath, 0.9f)
					.outputQuality(0.9)
					.toFile(thumbnailPath);  
				} 
				if(height == 0){
					Thumbnails.of(imagePath)   
					.width(width)
					.watermark(Positions.BOTTOM_RIGHT, watermarkImagePath, 0.9f)
					.outputQuality(0.9)
					.toFile(thumbnailPath);
				} 
				if (width == 0) {
					Thumbnails.of(imagePath)   
					.height(height)
					.watermark(Positions.BOTTOM_RIGHT, watermarkImagePath, 0.9f)
					.outputQuality(0.9)
					.toFile(thumbnailPath);
				}
			}else {
				if (width != 0 && height != 0) {
					Thumbnails.of(imagePath)   
					.size(width, height)
					.outputQuality(0.9)
					.toFile(thumbnailPath);  
				} 
				if(height == 0){
					Thumbnails.of(imagePath)   
					.width(width)
					.outputQuality(0.9)
					.toFile(thumbnailPath);
				} 
				if (width == 0) {
					Thumbnails.of(imagePath)   
					.height(height)
					.outputQuality(0.9)
					.toFile(thumbnailPath);
				}
			}
			//创建一个map，存储图片长和宽
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			//获取缩略图图片真实长宽
			BufferedImage sourceImg =ImageIO.read(new FileInputStream(new File(thumbnailPath))); 
			map.put("width", sourceImg.getWidth());
			map.put("height", sourceImg.getHeight());
			
			return map;
		}
	
	//修改单张图片返回路径
	public static ArrayList<Picture> changePicUrl(ArrayList<Picture> list, Config config){
		String rootUrl = config.getRootUrl();
		if (!MyString.isEmpty(list)) {
			for (Picture picture : list) {
				if (!MyString.isEmpty(picture.getUrl())) {
					picture.setUrl(rootUrl+picture.getUrl());
				}
				if (!MyString.isEmpty(picture.getThumb1())) {
					picture.setThumb1(rootUrl+picture.getThumb1());
				}
				if (!MyString.isEmpty(picture.getThumb2())) {
					picture.setThumb2(rootUrl+picture.getThumb2());
				}
				if (!MyString.isEmpty(picture.getThumb3())) {
					picture.setThumb3(rootUrl+picture.getThumb3());
				}
				if (!MyString.isEmpty(picture.getThumb4())) {
					picture.setThumb4(rootUrl+picture.getThumb4());
				}
				if (!MyString.isEmpty(picture.getThumb5())) {
					picture.setThumb5(rootUrl+picture.getThumb5());
				}
				if (!MyString.isEmpty(picture.getThumb6())) {
					picture.setThumb6(rootUrl+picture.getThumb6());
				}
			}
		}
		return list;
	}
	
	//修改图片返回路径
	public static Picture changePicUrl(Picture picture, Config config){
		String rootUrl = config.getRootUrl();
		if (!MyString.isEmpty(picture)) {
			if (!MyString.isEmpty(picture.getUrl())) {
				picture.setUrl(rootUrl+picture.getUrl());
			}
			if (!MyString.isEmpty(picture.getThumb1())) {
				picture.setThumb1(rootUrl+picture.getThumb1());
			}
			if (!MyString.isEmpty(picture.getThumb2())) {
				picture.setThumb2(rootUrl+picture.getThumb2());
			}
			if (!MyString.isEmpty(picture.getThumb3())) {
				picture.setThumb3(rootUrl+picture.getThumb3());
			}
			if (!MyString.isEmpty(picture.getThumb4())) {
				picture.setThumb4(rootUrl+picture.getThumb4());
			}
			if (!MyString.isEmpty(picture.getThumb5())) {
				picture.setThumb5(rootUrl+picture.getThumb5());
			}
			if (!MyString.isEmpty(picture.getThumb6())) {
				picture.setThumb6(rootUrl+picture.getThumb6());
			}
		}
		return picture;
	}
	
	
	//原图加水印
	public static void changePictureAddWatermark(String imagePath, String thumbnailPath, BufferedImage watermarkImagePath) throws IOException{
		Thumbnails.of(imagePath)   
		.scale(1.0)
		.watermark(Positions.CENTER, watermarkImagePath, 0.5f)
		.outputQuality(1.0)
		.toFile(thumbnailPath);
	}
}
