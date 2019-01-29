package com.tj720.mip.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
/**
 * 使用google开源的Zxing
 * 带中心logo的二维码生成及识别
 * @author LIn
 *
 */
public class CreateQrcode {
	  
	/**
	 * 生成二维码图像
	 * @param q          二维码模型
	 * @param logoPath   中心logo的存储路径,为null时没中心logo
	 * @throws WriterException
	 * @throws IOException
	 */
	public void encode(Qrcode q, String logoPath) throws WriterException, IOException {	
        BitMatrix bitMatrix;    

        Hashtable<EncodeHintType, Integer> hints = new Hashtable<>();  
        hints.put(EncodeHintType.MARGIN, 1); //设置二维码空白边框的大小 1-4，1是最小 4是默认的国标

        //生成矩阵
        bitMatrix = new MultiFormatWriter().encode(new String(q.getContent().getBytes("UTF-8"),"iso-8859-1"),    
                BarcodeFormat.QR_CODE, q.getWidth(), q.getHeight(), hints);  

        //存储路径
        Path path = FileSystems.getDefault().getPath(q.getFilePath(), q.getFileName()); 
        
        //矩阵颜色设置
        MatrixToImageConfig config = new MatrixToImageConfig(q.getOnColor(), q.getOffColor());
        
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix, config);
        
        if(null == logoPath || !new File(logoPath).exists()){   //不需要中心logo
        	ImageIO.write(image, q.getFormat(), new File(path.toString()));
        }else{
        	this.overlapImage(image, path.toString(), logoPath, q.getFormat());
        }

        System.out.println("success");
   
    }
	
	/**
	 * 生成二维码图像
	 * @param q          二维码模型
	 * @param logoPath   中心logo的存储路径,为null时没中心logo
	 * @throws WriterException
	 * @throws IOException
	 */
	public void encode(Qrcode q, String logoPath, String numCode) throws WriterException, IOException {	
        BitMatrix bitMatrix;    

        Hashtable<EncodeHintType, Integer> hints = new Hashtable<>();  
        hints.put(EncodeHintType.MARGIN, 4); //设置二维码空白边框的大小 1-4，1是最小 4是默认的国标

        //生成矩阵
        bitMatrix = new MultiFormatWriter().encode(new String(q.getContent().getBytes("UTF-8"),"iso-8859-1"),    
                BarcodeFormat.QR_CODE, q.getWidth(), q.getHeight(), hints);  

        //存储路径
        Path path = FileSystems.getDefault().getPath(q.getFilePath(), q.getFileName()); 
        
        //矩阵颜色设置
        MatrixToImageConfig config = new MatrixToImageConfig(q.getOnColor(), q.getOffColor());
        
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix, config);
        
        //加文字
        image = addWords(numCode, image);
        
        if(null == logoPath || !new File(logoPath).exists()){   //不需要中心logo
        	ImageIO.write(image, q.getFormat(), new File(path.toString()));
        }else{
        	this.overlapImage(image, path.toString(), logoPath, q.getFormat());
        }

        System.out.println("success");
   
    }

	/**
	 * 对生成的二维码添加中心图形
	 * @param image
	 * @param imgSavePath
	 * @param logoPath
	 * @param format
	 */
	public void overlapImage(BufferedImage image, String imgSavePath, String logoPath, String format) {
		try {
			BufferedImage logo = scale(logoPath, 80,
					80, true);
			Graphics2D g = image.createGraphics();
			//logo宽高
			int width = image.getWidth() / 5;
			int height = image.getHeight() / 5;
			//logo起始位置，此目的是为logo居中显示
			int x = (image.getWidth() - width) / 2;
			int y = (image.getHeight() - height) / 2;
			g.drawImage(logo, x, y, width, height, null);
			g.dispose();
			ImageIO.write(image, format, new File(imgSavePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 把传入的原始图像按高度和宽度进行缩放，生成符合要求的图标
	 * @param srcImageFile  源文件地址
	 * @param height        目标高度
	 * @param width         目标宽度
	 * @param hasFiller     比例不对时是否需要补白：true为补白; false为不补白;
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	private static BufferedImage scale(String srcImageFile, int height,
			int width, boolean hasFiller) throws IOException {
		double ratio = 0.0; // 缩放比例
		File file = new File(srcImageFile);
		FileInputStream inputStream = new FileInputStream(file);
		BufferedImage srcImage = ImageIO.read(inputStream);
		Image destImage = srcImage.getScaledInstance(width, height,
				BufferedImage.SCALE_SMOOTH);
		// 计算比例
		if ((srcImage.getHeight() > height) || (srcImage.getWidth() > width)) {
			if (srcImage.getHeight() > srcImage.getWidth()) {
				ratio = (new Integer(height)).doubleValue()
						/ srcImage.getHeight();
			} else {
				ratio = (new Integer(width)).doubleValue()
						/ srcImage.getWidth();
			}
			AffineTransformOp op = new AffineTransformOp(
					AffineTransform.getScaleInstance(ratio, ratio), null);
			destImage = op.filter(srcImage, null);
		}
		if (hasFiller) {// 补白
			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_4BYTE_ABGR);
			Color white = new Color(1.0f, 1.0f, 1.0f, 0);
			Graphics2D graphic = image.createGraphics();
			graphic.setColor(white);
			graphic.fillRect(0, 0, width, height);
			if (width == destImage.getWidth(null))
				graphic.drawImage(destImage, 0,
						(height - destImage.getHeight(null)) / 2,
						destImage.getWidth(null), destImage.getHeight(null),
						white, null);
			else
				graphic.drawImage(destImage,
						(width - destImage.getWidth(null)) / 2, 0,
						destImage.getWidth(null), destImage.getHeight(null),
						white, null);
			graphic.dispose();
			destImage = image;
		}
		return (BufferedImage) destImage;
	}
	 
	 /** 
	 * 解析图像
	 * @param  filePath  二维码存放路径
	 * @throws IOException 
	 * @throws NotFoundException 
	 */  
	 public void decode(String filePath) throws IOException, NotFoundException {
	     BufferedImage image;
	     
	     image = ImageIO.read(new File(filePath));  
         LuminanceSource source = new BufferedImageLuminanceSource(image);  
         Binarizer binarizer = new HybridBinarizer(source);  
         BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);  
         Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();  
         hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");  
         Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码  

         System.out.println("图片中内容：  ");  
         System.out.println(result.getText()); 
     }
	 
	 
	 private static BufferedImage addWords(String imageName, BufferedImage bImage) throws IOException {
			//得到画笔对象
			Graphics g = bImage.getGraphics();
			
	        //最后一个参数用来设置字体的大小  
	        Font f = new Font("宋体",Font.PLAIN,16);
	        g.setFont(f);  
	         
	        FontMetrics metrics = g.getFontMetrics();
	        Rectangle2D rc = metrics.getStringBounds(imageName, g);
	        double wordsWidth = rc.getWidth();
	        //x,y表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。 
	        int x = (300 - (int)wordsWidth)/2;
	        int y = 285;

	        Color mycolor = new Color(33, 33, 33);  
	        g.setColor(mycolor);
			g.drawString(imageName, x, y);
			
			g.dispose();
			
			return bImage;
		}
  
}  
