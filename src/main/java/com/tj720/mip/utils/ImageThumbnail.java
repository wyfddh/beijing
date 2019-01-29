package com.tj720.mip.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import org.junit.Ignore;
import org.junit.Test;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

public class ImageThumbnail {

	/*public static void main(String[] args) throws IOException {
		String path = "F:\\srcFile";
		traverseFolder1(path);
	}

	public static void traverseFolder1(String path) throws IOException {
		int fileNum = 0, folderNum = 0;
		File file = new File(path);
		if (file.exists()) {
			LinkedList<File> list = new LinkedList<File>();
			File[] files = file.listFiles();
			for (File file2 : files) {

				String srcPath = file2.getAbsolutePath();
				String imageName = file2.getName();
				System.out.println(imageName);
				String targetPath = "F:/target2/" + imageName;
				File srcfile = new File(srcPath);
				if (!srcfile.exists()) {
					System.out.println("文件不存在");
				}
				Thumbnails.of(srcPath).size(500,500).outputQuality(1.0f).toFile(targetPath);
				System.out.println("文件:" + file2.getAbsolutePath());
				folderNum++;

			}
			File temp_file;
			while (!list.isEmpty()) {
				temp_file = list.removeFirst();
				files = temp_file.listFiles();
				for (File file2 : files) {
					if (file2.isDirectory()) {
						System.out.println("文件夹:" + file2.getAbsolutePath());
						list.add(file2);
						fileNum++;
					} else {
						System.out.println("文件:" + file2.getAbsolutePath());
						folderNum++;
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
		System.out.println("文件夹共有:" + folderNum + ",文件共有:" + fileNum);
	}*/

	
	/**
	 * 批量处理图片
	 *
	 * @throws IOException
	 */
	/*public static void main(String[] args) throws IOException {
		File dir = new File("F:\\srcFile\\");
	    File[] fs = dir.listFiles();
	    Thumbnails.of(fs)
	              .size(600, 600)
	              .outputFormat("jpg")
	              .outputQuality(1.0f)
	              .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\测试专用.png")), 0.5f)
	              .toFiles(new File("F:\\target3\\"), Rename.PREFIX_HYPHEN_THUMBNAIL);
	}*/
	/*public static void test7() throws IOException {
	    File dir = new File("F:\\srcFile\\");
	    File[] fs = dir.listFiles();
	    Thumbnails.of(fs)
	              .size(600, 600)
	              .outputFormat("jpg")
	              .outputQuality(1.0f)
	              .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\测试专用.png")), 0.5f)
	              .toFiles(new File("F:\\target3\\"), Rename.PREFIX_HYPHEN_THUMBNAIL);
	}*/
	
	/**
	 * 缩放图片，并在图片右下角添加文字
	 *
	 * @throws IOException
	 */
	@Ignore
	@Test
	public void test4() throws IOException {
	    //根据文字自定义出一张水印图片
	    BufferedImage bi = new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g = bi.createGraphics();
	   
	    g.setColor(Color.LIGHT_GRAY);
	    g.drawRect(0, 0, 64, 64);
	    char[] data = "csyor.com".toCharArray();
	    g.drawChars(data, 0, data.length, 5, 32);
	 
	    Thumbnails.of(new File("E:\\test\\1a.jpg"))
	              .scale(0.5f)
	              .watermark(Positions.BOTTOM_RIGHT, bi, 0.9f)
	              .toFile(new File("E:\\test\\1a_front_1.jpg"));
	}
	
	public static void main(String[] args) {
		String aString=("ssss,bbbb,cccc,dddd,eeee");
		String picId="bbbb";
		aString=aString.replace(picId, "").replace(",,", ",").replaceFirst("^,", "").replaceFirst(",$", "");
		System.out.println(aString);
		picId="cccc";
		aString=aString.replace(picId, "").replace(",,", ",").replaceFirst("^,", "").replaceFirst(",$", "");
		System.out.println(aString);
		picId="ssss";
		aString=aString.replace(picId, "").replace(",,", ",").replaceFirst("^,", "").replaceFirst(",$", "");
		System.out.println(aString);
		picId="eeee";
		aString=aString.replace(picId, "").replace(",,", ",").replaceFirst("^,", "").replaceFirst(",$", "");
		System.out.println(aString);
	}
}
