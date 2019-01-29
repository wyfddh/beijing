package com.tj720.mip.utils;

import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.model.Picture;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ImageReThumbnailThread extends Thread{
	@Autowired
	public IPictureService pictureService;
	public String currentFile="";
	public int currentIndex=0;
	public int count=0;
	public String rootPath="";
	public final int maxWidth=960;//1080;
	public final int maxHeight=640;//720;
	public final String thumbPath="thumb";
	public final int thumb1Width=640;
	public final int thumb1Height=426;
	public final int thumb2Width=278;
	public final int thumb3Width=192;
	public final int thumb3Height=128;
	public boolean hasWaterMark=false;
	/**
	 * 批量处理图片
	 *
	 * @throws IOException
	 */
	public void run(){
		BufferedImage watermarkImagePath1 = null;
		BufferedImage watermarkImagePath2 = null;
		BufferedImage watermarkImagePath3 = null;
		if(hasWaterMark){
		    try {
				watermarkImagePath1 = ImageIO.read(new FileInputStream(rootPath + "shuiyin/C2_640.png"));
				watermarkImagePath2 = ImageIO.read(new FileInputStream(rootPath + "shuiyin/C1_278.png"));
				watermarkImagePath3 = ImageIO.read(new FileInputStream(rootPath + "shuiyin/C3_192.png"));
			} catch (Exception e) {
				hasWaterMark=false;
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Page page = new Page();
		page.setSize(8192);
		currentIndex=1;
		do{
			this.currentFile="开始读取数据";
			page.setCurrentPage(currentIndex);
			ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql("from Picture where typeId <= 4 and createTime<'2017-04-27 12:50:00' order by createTime,id", Tools.getMap(),page);
			count=page.getTotalPage();
			this.currentFile="开始读取数据完成";
			count=pictures.size();
			this.currentFile="开始处理数据";
			for(Picture pic : pictures){
	    	    try {
	    	    	if(hasWaterMark&&(MyString.isEmpty(pic.getTypeId())||Integer.valueOf(pic.getTypeId())<=4)){//pic.getUrl()==pic.getThumb1()||MyString.isEmpty(pic.getThumb1())){
				    	String file=(this.rootPath+pic.getUrl()).replace("\\", File.separator).replace("/", File.separator);
				    	File fileinfo=new File(file);
				    	currentFile=file;
						String filename=fileinfo.getName();
						String path=fileinfo.getParent();
						String gsNo=filename.substring(0, 22);
						String muNo=filename.substring(0, 14);
						String coNo=filename.substring(14, 22);
						if(fileinfo.isFile()&&fileinfo.exists()){
							String baseUrl=new File(pic.getUrl()).getParent();
							String newThumbnailDir=path+File.separator+thumbPath+File.separator;
							new File(newThumbnailDir).mkdirs();
							//生成缩略图1
							String thumb1Filename=new Integer(thumb1Width).toString()+"x"+new Integer(thumb1Height).toString()+"_"+filename;
							File newThumb1File=new File(newThumbnailDir+thumb1Filename);
							String thumb1=(baseUrl+"/"+thumbPath+"/"+thumb1Filename).replace('\\', '/');
							if(hasWaterMark){
								Thumbnails.of(file)
								.size(thumb1Width, thumb1Height)
								.watermark(Positions.BOTTOM_RIGHT, watermarkImagePath1, 0.9f)
								.toFile(newThumb1File);
							}else{
								Thumbnails.of(file)
								.size(thumb1Width, thumb1Height)
								.toFile(newThumb1File);
							}
							BufferedImage sourceImg = ImageIO.read(new FileInputStream(newThumb1File));
							int width1=sourceImg.getWidth();
							int height1=sourceImg.getHeight();
							//生成缩略图2
							String thumb2Filename=new Integer(thumb2Width).toString()+"x_"+filename;
							File newThumb2File=new File(newThumbnailDir+thumb2Filename);
							String thumb2=(baseUrl+"/"+thumbPath+"/"+thumb2Filename).replace('\\', '/');
							if(hasWaterMark){
								Thumbnails.of(file)
								.width(thumb2Width)
								.watermark(Positions.BOTTOM_RIGHT, watermarkImagePath2, 0.9f)
								.toFile(newThumb2File);
							}else{
								Thumbnails.of(file)
								.width(thumb2Width)
								.toFile(newThumb2File);
							}
							sourceImg =ImageIO.read(new FileInputStream(newThumb2File));
							int width2=sourceImg.getWidth();
							int height2=sourceImg.getHeight();
							//生成缩略图3
							String thumb3Filename=new Integer(thumb3Width).toString()+"x"+new Integer(thumb3Height).toString()+"_"+filename;
							File newThumb3File=new File(newThumbnailDir+thumb3Filename);
							String thumb3=(baseUrl+"/"+thumbPath+"/"+thumb3Filename).replace('\\', '/');
							if(hasWaterMark){
								Thumbnails.of(file)
								.size(thumb3Width, thumb3Height)
								.watermark(Positions.BOTTOM_RIGHT, watermarkImagePath3, 0.9f)
								.toFile(newThumb3File);
							}else{
								Thumbnails.of(file)
								.size(thumb3Width, thumb3Height)
								.toFile(newThumb3File);
							}
							Thumbnails.of(file)
								.size(thumb3Width, thumb3Height)
								.watermark(Positions.BOTTOM_RIGHT, watermarkImagePath3, 0.9f)
								.toFile(newThumb3File);
							sourceImg =ImageIO.read(new FileInputStream(newThumb3File));
							int width3=sourceImg.getWidth();
							int height3=sourceImg.getHeight();
							pic.setThumb1(thumb1);
							pic.setThumb1Width(width1);
							pic.setThumb1Height(height1);
							pic.setThumb2(thumb2);
							pic.setThumb2Width(width2);
							pic.setThumb2Height(height2);
							pic.setThumb3(thumb3);
							pic.setThumb3Width(width3);
							pic.setThumb3Height(height3);
							pictureService.update(pic);
						}
					}else if(!MyString.isEmpty(pic.getThumb2())&&pic.getThumb2Height()==0){
				    	String file=this.rootPath+pic.getThumb2();
						File newThumb2File=new File(file);
						BufferedImage sourceImg = ImageIO.read(new FileInputStream(newThumb2File));
						int width2=sourceImg.getWidth();
						int height2=sourceImg.getHeight();
						pic.setThumb2Width(width2);
						pic.setThumb2Height(height2);
						pictureService.update(pic);
			    	}
					currentIndex++;
					this.sleep((long)1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}while(count > currentIndex++);
	}
}
