package com.tj720.mip.utils;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

public class ImageUtil {  
	public static void main(String[] args) throws IOException {
		/*File dir = new File("F:\\以图搜图\\");
	    File[] fs = dir.listFiles();
	    Thumbnails.of(fs)
	              .size(600, 600)
	              .outputFormat("jpg")
	              .outputQuality(1.0f)
	              .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File("F:\\水印\\测试专用.png")), 0.5f)
	              .toFiles(new File("F:\\缩略图2\\"), Rename.NO_CHANGE);*/
		try {
			File dir = new File("F:\\test\\");
			File[] fs = dir.listFiles();
			Thumbnails.of(fs)
			.size(600, 600)
			.outputFormat("jpg")
			.outputQuality(1.0f)
			.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File("F:\\水印\\测试专用.png")), 0.5f)
			.toFiles(new File("F:\\test2\\"), Rename.NO_CHANGE);
			System.out.println("1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}  
