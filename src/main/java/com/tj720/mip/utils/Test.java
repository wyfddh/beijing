package com.tj720.mip.utils;

import java.io.IOException;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

public class Test {
	
	public static void main(String[] args) throws WriterException, IOException, NotFoundException {
		CreateQrcode t = new CreateQrcode();
		
		//二维码数据的封装,便于以后数据与业务逻辑的分离
		Qrcode q = new Qrcode();
		q.setContent("http://blog.csdn.net/why_still_confused/article/details/51908901");
		q.setFilePath("D://");
		q.setFileName("1.png");
		q.setHeight(200);
		q.setWidth(200);
		q.setFormat("png");
		q.setOnColor(0xFF4169E1);   //Royal blue
		String logoPath = "D://1.jpg";
		
		t.encode(q, logoPath);
//		t.decode("D://1.png");
	}

}
