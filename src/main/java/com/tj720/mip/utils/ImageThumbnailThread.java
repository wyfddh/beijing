package com.tj720.mip.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.tj720.mip.model.Picture;
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.jpeg.JpegDirectory;
import com.tj720.mip.inter.service.table.IPictureService;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageThumbnailThread extends Thread{
	public IPictureService pictureService;
	public String scrPath;
	public String targetPath;
	public String errorPath;
	public List<String> filelist=new ArrayList<String>();
	public List<String> templist=new ArrayList<String>();
	public List<String> skiplist=new ArrayList<String>();
	public String currentFile="";
	public int currentIndex=0;
	public int testcount=0;
	public int count=0;
	public int skipCount=0;
	public int totalCount=0;
	public int subvalue=0;
	public String waterRootPath="";
	public final String rootPath="picture";
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
		File errorDir=new File(errorPath+File.separator+"1");
		if(!errorDir.exists())
			errorDir.mkdirs();
		errorDir=new File(errorPath+File.separator+"2");
		if(!errorDir.exists())
			errorDir.mkdirs();
		filelist.clear();
		count=0;
		fetchFileList(scrPath);
		count=filelist.size();
		BufferedImage watermarkImagePath1 = null;
		BufferedImage watermarkImagePath2 = null;
		BufferedImage watermarkImagePath3 = null;
		for(String file : filelist){
			totalCount++;
	    	File fileinfo=new File(file);
		    try {
		    	currentFile=file;
				String filename=fileinfo.getName();
				String path=fileinfo.getParent();
				if(filename.length()>22){
					String gsNo=filename.substring(0, 22);
					String muNo=filename.substring(0, 14);
					String coNo=filename.substring(14, 22);
					if(gsNo.length()==22&&muNo.length()==14&&coNo.length()==8){
						testcount++;
						File newDir=new File(targetPath+File.separator+muNo+File.separator+coNo);
						String newThumbnailDir=newDir.getAbsolutePath()+File.separator+thumbPath+File.separator;
						String newFilename=newDir.getAbsolutePath()+File.separator+filename;
						String url=rootPath+newFilename.substring(newFilename.indexOf(File.separator)).replace('\\', '/');
						ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql("from Picture where gsNo = '"+gsNo+"' and url='"+url+"'", Tools.getMap());
						Picture pic=null;
						if(pictures.size()>0){
							pic=pictures.get(0);
							if(!MyString.isEmpty(pic.getThumb1())){
								currentIndex++;
//								if(totalCount-currentIndex!=subvalue){
//									templist.add(file);
//									subvalue=totalCount-currentIndex;
//								}
								continue;
							}
						}
						Metadata metadata = ImageMetadataReader.readMetadata(fileinfo);
						for (Directory directory : metadata.getDirectories()) {
						    for (Tag tag : directory.getTags()) {
						        System.out.println(tag);
						    }
						}
						ExifIFD0Directory ifd0directory=metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
						int orientation=1;
						if(!MyString.isEmpty(ifd0directory))
							try{
								orientation=ifd0directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
							}
						int rotate=0;
						switch(orientation){
						case 8:
							rotate=90;
							break;
						case 3:
							rotate=180;
							break;
						case 6:
							rotate=270;
							break;
						}
						boolean isWidth;
						int width=0;
						int height=0;
						JpegDirectory jpegdirectory=metadata.getFirstDirectoryOfType(JpegDirectory.class);
						if(MyString.isEmpty(jpegdirectory)){
							BufferedImage sourceImg = ImageIO.read(new FileInputStream(fileinfo));
							width=sourceImg.getWidth();
							height=sourceImg.getHeight();
						}else{
							width=jpegdirectory.getInt(JpegDirectory.TAG_IMAGE_WIDTH);
							height=jpegdirectory.getInt(JpegDirectory.TAG_IMAGE_HEIGHT);
						}
						if(width*2>height*3)///宽比较大，按高度设置
							isWidth=false;
						else
							isWidth=true;
						new File(newThumbnailDir).mkdirs();
						File newFile=new File(newFilename);
						//获取图片路径
						if(isWidth)
							Thumbnails.of(file)
					          .width(maxWidth)
					          .outputFormat("jpg")
					          .rotate(rotate)
					          .outputQuality(1.0f)
					          .toFile(newFile);
						else
							Thumbnails.of(file)
					          .height(maxHeight)
					          .outputFormat("jpg")
					          .rotate(rotate)
					          .outputQuality(1.0f)
					          .toFile(newFile);
						BufferedImage sourceImg = ImageIO.read(new FileInputStream(newFile));
						width=sourceImg.getWidth();
						height=sourceImg.getHeight();
						//生成缩略图1
						String thumb1Filename=newThumbnailDir+new Integer(thumb1Width).toString()+"x"+new Integer(thumb1Height).toString()+"_"+filename;
						File newThumb1File=new File(thumb1Filename);
						String thumb1=rootPath+thumb1Filename.substring(thumb1Filename.indexOf(File.separator)).replace('\\', '/');
						if(hasWaterMark){
							watermarkImagePath1 = ImageIO.read(new FileInputStream(waterRootPath + "shuiyin/C2_640.png"));
							Thumbnails.of(newFile)
							.size(thumb1Width, thumb1Height)
							.watermark(Positions.BOTTOM_RIGHT, watermarkImagePath1, 0.9f)
							.toFile(newThumb1File);
						}else{
							Thumbnails.of(newFile)
							.size(thumb1Width, thumb1Height)
							.toFile(newThumb1File);
						}
						sourceImg = ImageIO.read(new FileInputStream(newThumb1File));
						int width1=sourceImg.getWidth();
						int height1=sourceImg.getHeight();
						//生成缩略图2
						String thumb2Filename=newThumbnailDir+new Integer(thumb2Width).toString()+"x_"+filename;
						File newThumb2File=new File(thumb2Filename);
						String thumb2=rootPath+thumb2Filename.substring(thumb2Filename.indexOf(File.separator)).replace('\\', '/');
						if(hasWaterMark){
							watermarkImagePath2 = ImageIO.read(new FileInputStream(waterRootPath + "shuiyin/C1_278.png"));
							Thumbnails.of(newFile)
							.width(thumb2Width)
							.watermark(Positions.BOTTOM_RIGHT, watermarkImagePath2, 0.9f)
							.toFile(newThumb2File);
						}else{
							Thumbnails.of(newFile)
							.width(thumb2Width)
							.toFile(newThumb2File);
						}
						sourceImg = ImageIO.read(new FileInputStream(newThumb2File));
						int width2=sourceImg.getWidth();
						int height2=sourceImg.getHeight();
						//生成缩略图3
						String thumb3Filename=newThumbnailDir+new Integer(thumb3Width).toString()+"x"+new Integer(thumb3Height).toString()+"_"+filename;
						File newThumb3File=new File(thumb3Filename);
						String thumb3=rootPath+thumb3Filename.substring(thumb3Filename.indexOf(File.separator)).replace('\\', '/');
						if(hasWaterMark){
							watermarkImagePath3 = ImageIO.read(new FileInputStream(waterRootPath + "shuiyin/C3_192.png"));
							Thumbnails.of(newFile)
							.size(thumb3Width, thumb3Height)
							.watermark(Positions.BOTTOM_RIGHT, watermarkImagePath2, 0.9f)
							.toFile(newThumb3File);
						}else{
							Thumbnails.of(newFile)
							.size(thumb3Width, thumb3Height)
							.toFile(newThumb3File);
						}
						sourceImg = ImageIO.read(new FileInputStream(newThumb3File));
						int width3=sourceImg.getWidth();
						int height3=sourceImg.getHeight();
						if(MyString.isEmpty(pic)){
							Picture picture = new Picture(gsNo, url, width, height,thumb1,width1,height1, thumb2,width2,height2,thumb3,width3,height3);
							pictureService.save(picture);
						}else{
							pic.setUrl(url);
							pic.setGsNo(gsNo);
							pic.setPicWidth(width);
							pic.setPicHeight(height);
							pic.setThumb1(thumb1);
							pic.setThumb1Width(width1);
							pic.setThumb1Height(height1);
							pic.setThumb2(thumb2);
							pic.setThumb2Width(width2);
							pic.setThumb2Height(height2);
							pic.setThumb3(thumb3);
							pic.setThumb3Width(width3);
							pic.setThumb3Height(height3);
							pic.setIsMain((byte)1);
							pic.setStatus((byte)1);
							pictureService.update(pic);
						}
						currentIndex++;
					}else{
						skiplist.add(file);
						skipCount++;
					}
				}else{
					skiplist.add(file);
					skipCount++;
				}
				this.sleep((long)1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				if(MyString.isEmpty(e.getMessage())){
					skiplist.add(file+" | "+e.getStackTrace().toString());
					skipCount++;
				}else{
					try{
						int bytesum = 0;
						int byteread = 0;
						InputStream inStream = new FileInputStream(file); //读入原文件 
						String errorPathName;
						if(!e.getMessage().contains("Invalid icc profile: bad sequence number"))
							errorPathName =errorPath+File.separator+"2"+File.separator+fileinfo.getName();
						else
							errorPathName = errorPath+File.separator+"1"+File.separator+fileinfo.getName();
						FileOutputStream fs= new FileOutputStream(errorPathName);
						byte[] buffer = new byte[1444]; 
						int length; 
						while ( (byteread = inStream.read(buffer)) != -1) {
							bytesum += byteread; //字节数 文件大小 
							System.out.println(bytesum); 
							fs.write(buffer, 0, byteread); 
						}
						inStream.close(); 
					}
					catch (Exception err) {
						templist.add("复制文件出错:"+file+" | "+err.getMessage());
					} 
					if(!e.getMessage().contains("Invalid icc profile: bad sequence number"))
						templist.add(file+" || "+e.getMessage());
					subvalue++;
				}
			}
//			if(totalCount-currentIndex!=subvalue){
//				subvalue=totalCount-currentIndex;
//			}
		}
	}
	private void fetchFileList(String root){
		File dir = new File(root);
	    File[] files = dir.listFiles();
	    if(!MyString.isEmpty(files)){
		    for (File file : files) {
		    	if(file.isDirectory()){
		    		fetchFileList(file.getAbsolutePath());
		    	}else{
		    		filelist.add(file.getAbsolutePath());
		    		count++;
		    	}
				try {
					this.sleep((long)1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }
	}
}
