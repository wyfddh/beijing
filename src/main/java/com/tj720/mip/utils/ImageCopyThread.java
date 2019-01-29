package com.tj720.mip.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import com.tj720.mip.model.Picture;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.dto.CollectionAttributesDto;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IMipOpenFossilInfoService;
import com.tj720.mip.inter.service.table.IPictureService;

public class ImageCopyThread extends Thread{
	public IPictureService pictureService;
	public IMipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
	public IMipOpenFossilInfoService mipOpenFossilInfoService;
	public Config config;
	public String remoteBaseRootUrl;
	public String message="开始";
	public double progress=0.0;
	public String currentUrl="";//正在操作的url
	public int currentCount=0;
	public int currentIndex=0;
	public int totalIndex=0;
	public int totalCount=0;
	private int count=0;
	/**
	 * 批量处理图片
	 *
	 * @throws IOException
	 */
	public void run(){
		totalIndex=0;
		copyNoCollectionPic();
		copyCulturalrelicPic();
		copyFossilPic();
	}
	//wyu:下载非藏品的图片
	@SuppressWarnings("unchecked")
	private void copyNoCollectionPic(){
		currentIndex=currentCount=0;
		Page page = new Page();
		page.setSize(1000);
		int currentPage=1;
		do{
			page.setCurrentPage(currentPage);
			String hql = "FROM Picture WHERE typeId>4 AND objectId!='' ORDER BY id";
			this.message="复制非藏品图片，第"+Integer.valueOf(currentPage).toString()+"个图片组（X1000）";
			List<Picture> picList = (List<Picture>) pictureService.queryByHql(hql,Tools.getMap(),page);
			currentCount=page.getAllRow();
			totalCount=count+currentCount;
			int totalpage=page.getTotalPage()>0?page.getTotalPage():currentPage;
			progress=10.0*currentPage/totalpage;
			for(Picture pic:picList){
				currentIndex++;totalIndex++;
				downloadPic(pic);
			}
		}while(page.getTotalPage() > currentPage++);
		count=totalCount;
	}
	//wyu：下载文物图片，只下载公开藏品的前两张图片
	@SuppressWarnings("unchecked")
	private void copyCulturalrelicPic(){
		currentIndex=currentCount=0;
		Page page = new Page();
		page.setSize(1000);
		int currentPage=1;
		do{
			page.setCurrentPage(currentPage);
			String hql = "SELECT new com.tj720.mip.dto.CollectionAttributesDto(id) FROM MipOpenCulturalrelicInfo WHERE isOpen=2 ORDER BY id";
			this.message="复制文物藏品图片，第"+Integer.valueOf(currentPage).toString()+"个藏品组（X1000）";
			List<CollectionAttributesDto> attrsList=(List<CollectionAttributesDto>)mipOpenFossilInfoService.queryDtoByHql(hql,Tools.getMap(),page);
			currentCount=page.getAllRow();
			totalCount=count+currentCount;
			int totalpage=page.getTotalPage()>0?page.getTotalPage():currentPage;
			progress=10.0+70.0*currentPage/totalpage;
			doCollection(attrsList);
		}while(page.getTotalPage() > currentPage++);
		count=totalCount;
	}
	//wyu：下载化石图片，只下载公开藏品的前两张图片
	@SuppressWarnings("unchecked")
	private void copyFossilPic(){
		currentIndex=currentCount=0;
		Page page = new Page();
		page.setSize(1000);
		int currentPage=1;
		do{
			page.setCurrentPage(currentPage);
			String hql = "SELECT new com.tj720.mip.dto.CollectionAttributesDto(id) FROM MipOpenFossilInfo WHERE isOpen=2 ORDER BY id";
			this.message="复制化石藏品图片，第"+Integer.valueOf(currentPage).toString()+"个藏品组（X1000）";
			List<CollectionAttributesDto> attrsList=(List<CollectionAttributesDto>)mipOpenCulturalrelicInfoService.queryDtoByHql(hql,Tools.getMap(),page);
			currentCount=page.getAllRow();
			totalCount=count+currentCount;
			int totalpage=page.getTotalPage()>0?page.getTotalPage():currentPage;
			progress=80.0+20.0*currentPage/totalpage;
			doCollection(attrsList);
		}while(page.getTotalPage() > currentPage++);
		count=totalCount;
	}
	//wyu:处理藏品图片下载及修改数据
	@SuppressWarnings("unchecked")
	private void doCollection(List<CollectionAttributesDto> attrsList){
		for(CollectionAttributesDto attrs:attrsList){
			currentIndex++;totalIndex++;
	    	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+" befSelect");
			List<Picture> picList = (List<Picture>) pictureService.queryByHql("FROM Picture WHERE objectId='"+attrs.getId()+"' ORDER BY isMain DESC,url",Tools.getMap());
	    	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+" aftSelect");
//			List<Picture> picList = (List<Picture>) pictureService.queryLimitByHql("FROM Picture WHERE objectId='"+attrs.getId()+"' ORDER BY isMain DESC,url",2);
			if(!MyString.isEmpty(picList)){
//				StringBuffer picIds=new StringBuffer();
				for(Picture pic:picList){
//					picIds.append(",'").append(pic.getId()).append('\'');
					downloadPic(pic);
				}
//				picIds.replace(0,1,"");
//				pictureService.deleteByHql("DELETE FROM Picture WHERE objectId='"+attrs.getId()+"' AND id NOT IN ("+picIds.toString()+")");
			}
		}
	}
	//wyu:按照图片modle创建目录，下载图片及缩略图
	private void downloadPic(Picture pic){
		String url=pic.getUrl();
    	download(remoteBaseRootUrl+url,config.getRootPath()+url);
    	if(!MyString.isEmpty(pic.getThumb1())){
    		url=pic.getThumb1();
        	download(remoteBaseRootUrl+url,config.getRootPath()+url);
    	}
    	if(!MyString.isEmpty(pic.getThumb2())){
    		url=pic.getThumb2();
        	download(remoteBaseRootUrl+url,config.getRootPath()+url);
    	}
    	if(!MyString.isEmpty(pic.getThumb3())){
    		url=pic.getThumb3();
        	download(remoteBaseRootUrl+url,config.getRootPath()+url);
    	}
    	if(!MyString.isEmpty(pic.getThumb4())){
    		url=pic.getThumb4();
        	download(remoteBaseRootUrl+url,config.getRootPath()+url);
    	}
    	if(!MyString.isEmpty(pic.getThumb5())){
    		url=pic.getThumb5();
        	download(remoteBaseRootUrl+url,config.getRootPath()+url);
    	}
    	if(!MyString.isEmpty(pic.getThumb6())){
    		url=pic.getThumb6();
        	download(remoteBaseRootUrl+url,config.getRootPath()+url);
    	}
	}
	//wyu：下载
	private void download(String urlString,String fileName){
		System.out.println(urlString);
    	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+" download");
//    	System.out.println("start;");
		currentUrl=urlString;
    	File fileinfo=new File(fileName);
    	File dir=new File(fileinfo.getParent());
    	if(!dir.exists()){
    		dir.mkdirs();
    	}
//		System.out.println(dir.getAbsolutePath());
		try{
			URL url = new URL(urlString);
	    	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+" befGetLength");
	    	int size=0;
	    	while(size==0){
	    		try{
			        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			        conn.setConnectTimeout(3000);
			        conn.setReadTimeout(3000);
			        size=conn.getContentLength();
			        if(size==0)
			        	System.out.println("GetContentLength==0");
			        conn.disconnect();
			    	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+" aftGetLength");
			        conn=null;
	    		}catch(SocketTimeoutException e){
		        	System.out.println("SocketTimeoutException GetLength");
					e.printStackTrace();
	    		}
	    	}
	        DataOutputStream out = new DataOutputStream(new FileOutputStream(fileinfo));
//	        System.out.println("get size OK;");
	        int count = 0;
	        int total=0;
	        byte[] buffer = new byte[16384];
	        while(total<size){
		        try{
			        int endPos=size<total+65535?size:65535+total;
			        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			        connection.setReadTimeout(3000);
			        connection.setConnectTimeout(3000);
			        connection.setRequestProperty("Range", "bytes=" + total + "-" + endPos);
			        DataInputStream in = new DataInputStream(connection.getInputStream());
			        while (count == 0) {
			        	this.sleep(1);
			            count = in.available();
			        }
//			        System.out.println("available;");
			        while((count = in.read(buffer)) > 0) {
			        	total+=count;
//			    		System.out.println(urlString);
//			    		System.out.println(fileName);
//			        	System.out.println(size);
//			        	System.out.println(count);
//			        	System.out.println(total);
			        	out.write(buffer, 0, count);
			        	out.flush();
//			        	System.out.println(new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date()));
//			        	System.out.println("continue;");
			        	int i=0;
				        do{
				        	this.sleep(1);
				            count = in.available();
				        }while (count == 0 && i++<50);
			        }
			        in.close();
			        in=null;
		        	connection.disconnect();
		        	connection=null;
			        if(total<size){
			        	this.sleep(10);
			        }
		        }catch (SocketTimeoutException e) {
		        	System.out.println("SocketTimeoutException");
					e.printStackTrace();
				}
	        }
//        	System.out.println("finish;");
	        out.close();
	        out=null;
        	url=null;
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
}
