package com.tj720.mip.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tj720.mip.model.Picture;
import com.tj720.mip.model.PictureSearchConfig;
import com.tj720.mip.model.PictureSearchSet;
import com.tj720.mip.dto.CollectionAttributesDto;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IMipOpenFossilInfoService;
import com.tj720.mip.inter.service.table.IPictureSearchConfigService;
import com.tj720.mip.inter.service.table.IPictureSearchSetService;
import com.tj720.mip.inter.service.table.IPictureService;

public class ImageSearchThread extends Thread{
	public IPictureSearchConfigService pictureSearchConfigService;
	public IPictureSearchSetService pictureSearchSetService;
	public IPictureService pictureService;
	public IMipOpenCulturalrelicInfoService collectionService;
	public IMipOpenFossilInfoService fossilService;
	public PictureSearchConfig searchConfig;
	public int skip=0;
	public double percentage=1;
	public String rootUrl="";
	public String rootPath="";
	public List<String> filelist=new ArrayList<String>();
	public HashMap<String,Integer> tags=new HashMap<String,Integer>();
	public HashMap<String,Integer> sendtags=new HashMap<String,Integer>();
	public String name="";
	public int index=0;
	public int count=0;
	public double process=0;
	public String status="";
	public String error="";
	public String message="";
	/**
	 * 批量处理图片
	 *
	 * @throws IOException
	 */
	public void run(){
		deletePictureSearchSet();
		addPictureSearchSet();
	}
	private void deletePictureSearchSet(){
		this.status="清空图片库";
		File file=new File(this.rootPath);
		if(file.canExecute())
		if(file.exists()&&file.isDirectory()){
			String[] tempList = file.list();
			for(String filename:tempList){
				File delFile=new File(file.getAbsoluteFile() + File.separator + filename);
				if(delFile.exists()&&delFile.isFile())
					delFile.delete();
			}
		}else
			file.mkdirs();
		Page page = new Page();
		page.setSize(10000);
		int currentPage=1;
		List<String> dataList=new ArrayList<String>();
		List<PictureSearchSet> setList=new ArrayList<PictureSearchSet>();
		String rootfilename=this.rootPath+"CSV"+new Long(System.currentTimeMillis()).toString()+"Del";
		process=1;
		do{
			page.setCurrentPage(currentPage);
			setList = (List<PictureSearchSet>) pictureSearchSetService
					.queryByHql("FROM PictureSearchSet ORDER BY id", Tools.getMap(),page);
			int totalpage=page.getTotalPage()>0?page.getTotalPage():currentPage;
			process=1+9*currentPage/totalpage;
			if(setList.size()>0){
				double tmp_process=5.0/setList.size();
				for(PictureSearchSet p: setList){
					dataList.add(p.getUrl());
					process+=tmp_process;
				}
			}
			if(dataList.size()>0){
				file=new File(rootfilename+String.format("%05d", currentPage)+".csv");
				this.message=file.getAbsolutePath();
				if(CSVUtil.exportCsv(file, dataList)){
					try {
						PictureSearchUtil.delete_image_by_file(file.getAbsolutePath());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						this.error="导出删除文件错误"+e.getStackTrace().toString()+":"+file.getAbsolutePath();
					}
				}else
					this.error="导出删除文件错误:"+file.getAbsolutePath();
				dataList.clear();
			}
		}while(page.getTotalPage() > currentPage++);
		pictureSearchSetService.deleteByHql("delete from PictureSearchSet");
		process=10;
	}

	private void addPictureSearchSet(){
		this.status="重建图片库";
		percentage=searchConfig.getSetPercentage()/100.0;
		switch(searchConfig.getSetPercentage()){
		case 10:
			skip=9;
			break;
		case 30:
			skip=2;
			break;
		case 50:
			skip=1;
			break;
		case 70:
			skip=0;
			break;
		default:
			skip=0;
		}
		int pageCount=0;
		pageCount=addOCCollectionSearchSet(pageCount);
		percentage=90.0;
		addOCFossilSearchSet(pageCount);
		percentage=100.0;
		this.status="完成操作";
	}
	private int addOCCollectionSearchSet(int pageCount){
		int count=0;
		int send=0;
		Page page = new Page();
		page.setSize(10000);
		int currentPage=1;
		String rootfilename=this.rootPath+"CSV"+new Long(System.currentTimeMillis()).toString()+"Add";
		List<String> dataList=new ArrayList<String>();
		List<PictureSearchSet> setList=new ArrayList<PictureSearchSet>();
		do{
			page.setCurrentPage(currentPage);
			String hql = "SELECT new com.tj720.mip.dto.CollectionAttributesDto(o.id,c.name AS collectionsCategory,o.gsNo,o.name,o.formerly,o.foreignName,"
					+ "y.pathName as yearType, o.collectionUnit) FROM MipOpenCulturalrelicInfo o, CollectionCategory c,YearType y where o.collectionsCategory=c.id "
					+ "AND o.yearType=y.id AND o.isOpen = 2 AND o.status > 0";
			this.status="重建图片库，第"+Integer.valueOf(pageCount+currentPage).toString()+"个文件";
			List<CollectionAttributesDto> attrsList=(List<CollectionAttributesDto>)collectionService.queryDtoByHql(hql,Tools.getMap(),page);
			for(CollectionAttributesDto attrs:attrsList){
				int totalpage=page.getTotalPage()>0?page.getTotalPage():currentPage;
				process=10+80*currentPage/totalpage;
				Picture pic = pictureService.getByHql("FROM Picture WHERE objectId='"+attrs.getId()+"' ORDER BY isMain DESC,url");
				if(MyString.isEmpty(pic))
					continue;
				PictureSearchSet ps=new PictureSearchSet();
				ps.setUrl(this.rootUrl+(MyString.isEmpty(pic.getThumb1())?pic.getUrl():pic.getThumb1()));
				if(!MyString.isEmpty(attrs.getCollectionsCategory()))
					ps.setCollectionsCategory(attrs.getCollectionsCategory());
				if(!MyString.isEmpty(attrs.getGsNo()))
					ps.setGsNo(attrs.getGsNo());
				if(!MyString.isEmpty(attrs.getSearchName()))
					ps.setName(attrs.getSearchName());
				ps.setObjectId(pic.getObjectId());
				ps.setPictureId(pic.getId());
				ps.setStatus((byte)1);
				ps.setTypeId(pic.getTypeId());
				if(!MyString.isEmpty(attrs.getSearchYearType()))
					ps.setYearType(attrs.getSearchYearType());
				String tag=ps.getShortTags();
				if(!attrs.getCollectionUnit().equalsIgnoreCase("60")){//山东省博不计数
					count++;
					if(tags.containsKey(tag)&&sendtags.containsKey(tag)){
						if((double)sendtags.get(tag)/tags.get(tag)>percentage||(double)send/count>percentage){
							tags.put(tag, tags.get(tag)+1);
							continue;
						}else{
							sendtags.put(tag, sendtags.get(tag)+1);
							tags.put(tag, tags.get(tag)+1);
						}
					}else{
						sendtags.put(tag, 1);
						tags.put(tag, 1);
					}
					send++;
				}
				pictureSearchSetService.save(ps);
				dataList.add(ps.getUrl()+","+ps.getMetaId()+","+ps.getTags());
			}
			File file=new File(rootfilename+String.format("%05d", pageCount+currentPage)+".csv");
			this.message=file.getAbsolutePath();
			if(CSVUtil.exportCsv(file, dataList)){
				try {
					/////wyu:20170513,导出数据，不上传。
					//PictureSearchUtil.add_image_by_file(file.getAbsolutePath());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					this.status=e.getStackTrace().toString()+":"+file.getAbsolutePath();
				}
			}else
				this.error="导出文件错误:"+file.getAbsolutePath();
			try {
				this.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setList.clear();
			dataList.clear();
			attrsList.clear();
		}while(page.getTotalPage() > currentPage++);
		return pageCount+currentPage-1;
	}
	private int addOCFossilSearchSet(int pageCount){
		int count=0;
		int send=0;
		Page page = new Page();
		page.setSize(10000);
		int currentPage=1;
		String rootfilename=this.rootPath+"CSV"+new Long(System.currentTimeMillis()).toString()+"Add";
		List<String> dataList=new ArrayList<String>();
		List<PictureSearchSet> setList=new ArrayList<PictureSearchSet>();
		do{
			page.setCurrentPage(currentPage);
			String hql = "SELECT new com.tj720.mip.dto.CollectionAttributesDto(o.id,c.name AS collectionsCategory,o.gsNo,o.name,o.formerly,o.foreignName,o.yearType,"
					+ "o.collectionUnit) FROM MipOpenFossilInfo o, CollectionCategory c where o.collectionsCategory=c.id AND o.isOpen = 2 AND o.status > 0";
			this.status="重建图片库，第"+Integer.valueOf(pageCount+currentPage).toString()+"个文件";
			List<CollectionAttributesDto> attrsList=(List<CollectionAttributesDto>)collectionService.queryDtoByHql(hql,Tools.getMap(),page);
			for(CollectionAttributesDto attrs:attrsList){
				int totalpage=page.getTotalPage()>0?page.getTotalPage():currentPage;
				process=90+10*currentPage/totalpage;
				Picture pic = pictureService.getByHql("FROM Picture WHERE objectId='"+attrs.getId()+"' ORDER BY isMain DESC,url");
				if(MyString.isEmpty(pic))
					continue;
				PictureSearchSet ps=new PictureSearchSet();
				ps.setUrl(this.rootUrl+(MyString.isEmpty(pic.getThumb1())?pic.getUrl():pic.getThumb1()));
				if(!MyString.isEmpty(attrs.getCollectionsCategory()))
					ps.setCollectionsCategory(attrs.getCollectionsCategory());
				if(!MyString.isEmpty(attrs.getGsNo()))
					ps.setGsNo(attrs.getGsNo());
				if(!MyString.isEmpty(attrs.getSearchName()))
					ps.setName(attrs.getSearchName());
				ps.setObjectId(pic.getObjectId());
				ps.setPictureId(pic.getId());
				ps.setStatus((byte)1);
				ps.setTypeId(pic.getTypeId());
				if(!MyString.isEmpty(attrs.getSearchYearType()))
					ps.setYearType(attrs.getSearchYearType());
				String tag=ps.getShortTags();
//				if(!attrs.getCollectionUnit().equalsIgnoreCase("60")){//山东省博不计数
					count++;
					if(tags.containsKey(tag)&&sendtags.containsKey(tag)){
						if((double)sendtags.get(tag)/tags.get(tag)>percentage||(double)send/count>percentage){
							tags.put(tag, tags.get(tag)+1);
							continue;
						}else{
							sendtags.put(tag, sendtags.get(tag)+1);
							tags.put(tag, tags.get(tag)+1);
						}
					}else{
						sendtags.put(tag, 1);
						tags.put(tag, 1);
					}
					send++;
//				}
				pictureSearchSetService.save(ps);
				dataList.add(ps.getUrl()+","+ps.getMetaId()+","+ps.getTags());
			}
			File file=new File(rootfilename+String.format("%05d", pageCount+currentPage)+".csv");
			this.message=file.getAbsolutePath();
			if(CSVUtil.exportCsv(file, dataList)){
				try {
					/////wyu:20170513,导出数据，不上传。
					//PictureSearchUtil.add_image_by_file(file.getAbsolutePath());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					this.status=e.getStackTrace().toString()+":"+file.getAbsolutePath();
				}
			}else
				this.error="导出文件错误:"+file.getAbsolutePath();
			try {
				this.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setList.clear();
			dataList.clear();
			attrsList.clear();
		}while(page.getTotalPage() > currentPage++);
		return pageCount+currentPage-1;
	}
/*
	private void addPictureSearchSet0(){
		this.status="重建图片库";
		percentage=searchConfig.getSetPercentage()/100.0;
		switch(searchConfig.getSetPercentage()){
		case 10:
			skip=9;
			break;
		case 30:
			skip=2;
			break;
		case 50:
			skip=1;
			break;
		case 70:
			skip=0;
			break;
		default:
			skip=0;
		}
		int count=0;
		int send=0;
		Page page = new Page();
		page.setSize(10000);
		int currentPage=1;
		String rootfilename=this.rootPath+"CSV"+new Long(System.currentTimeMillis()).toString()+"Add";
		List<String> dataList=new ArrayList<String>();
		List<PictureSearchSet> setList=new ArrayList<PictureSearchSet>();
		do{
			page.setCurrentPage(currentPage);
			List<Picture> picList = (List<Picture>) pictureService
					.queryByHql("FROM Picture WHERE typeId<=4 AND objectId!='' ORDER BY id ASC",Tools.getMap(),page);// AND status>0
			this.status="重建图片库，第"+new Integer(currentPage).toString()+"个文件";
			for(Picture pic:picList){
				int totalpage=page.getTotalPage()>0?page.getTotalPage():currentPage;
				process=10+90*currentPage/totalpage;
				PictureSearchSet ps=new PictureSearchSet();
				ps.setUrl(this.rootUrl+(MyString.isEmpty(pic.getThumb1())?pic.getUrl():pic.getThumb1()));
				CollectionAttributesDto attrs=getCollectionAttributes(pic.getObjectId(),pic.getTypeId());
				if(MyString.isEmpty(attrs))
					continue;
				if(!MyString.isEmpty(attrs.getCollectionsCategory()))
					ps.setCollectionsCategory(attrs.getCollectionsCategory());
				if(!MyString.isEmpty(attrs.getGsNo()))
					ps.setGsNo(attrs.getGsNo());
				if(!MyString.isEmpty(attrs.getSearchName()))
					ps.setName(attrs.getSearchName());
				ps.setObjectId(pic.getObjectId());
				ps.setPictureId(pic.getId());
				ps.setStatus((byte)1);
				ps.setTypeId(pic.getTypeId());
				if(!MyString.isEmpty(attrs.getSearchYearType()))
					ps.setYearType(attrs.getSearchYearType());
				String tag=ps.getShortTags();
				if(tags.containsKey(tag)&&sendtags.containsKey(tag)){
					if(!attrs.getCollectionUnit().equalsIgnoreCase("60"))//山东省博不计数
						count++;
					if((double)sendtags.get(tag)/tags.get(tag)>percentage||(double)send/count>percentage){
						tags.put(tag, tags.get(tag)+1);
						continue;
					}else{
						sendtags.put(tag, sendtags.get(tag)+1);
						tags.put(tag, tags.get(tag)+1);
					}
				}else{
					if(!attrs.getCollectionUnit().equalsIgnoreCase("60"))//山东省博不计数
						count++;
					sendtags.put(tag, 1);
					tags.put(tag, 1);
				}
				if(!attrs.getCollectionUnit().equalsIgnoreCase("60"))//山东省博不计数
					send++;
				pictureSearchSetService.save(ps);
				dataList.add(ps.getUrl()+","+ps.getMetaId()+","+ps.getTags());
			}
			File file=new File(rootfilename+String.format("%05d", currentPage)+".csv");
			this.message=file.getAbsolutePath();
			if(CSVUtil.exportCsv(file, dataList)){
				try {
					/////wyu:20170513,导出数据，不上传。
					//PictureSearchUtil.add_image_by_file(file.getAbsolutePath());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					this.status=e.getStackTrace().toString()+":"+file.getAbsolutePath();
				}
			}else
				this.error="导出文件错误:"+file.getAbsolutePath();
			try {
				this.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setList.clear();
			dataList.clear();
			picList.clear();
		}while(page.getTotalPage() > currentPage++);
		process=100.0;
		this.status="处理完成";
	}
	private CollectionAttributesDto getCollectionAttributes0(String objId,String typeId){
		CollectionAttributesDto attrs=new CollectionAttributesDto();
		switch(typeId){
		case "1":
		case "3":
			attrs=getOCCollectionAttributes(objId);
			if(MyString.isEmpty(attrs))
				attrs=getOCFossilAttributes(objId);
			break;
		case "2":
		case "4":
			attrs=getOCFossilAttributes(objId);
			if(MyString.isEmpty(attrs))
				attrs=getOCCollectionAttributes(objId);
			break;
		}
		return attrs;
	}
	private CollectionAttributesDto getOCCollectionAttributes0(String objId){
		String hql = "SELECT new com.tj720.mip.dto.CollectionAttributesDto(c.name AS collectionsCategory,o.gsNo,o.name,o.formerly,o.foreignName,"
				+ "y.pathName as yearType, o.collectionUnit) FROM MipOpenCulturalrelicInfo o, CollectionCategory c,YearType y where o.collectionsCategory=c.id "
				+ "AND o.yearType=y.id AND o.isOpen = 2 AND o.status > 0 AND o.id='"+objId+"'";
		CollectionAttributesDto attrs=(CollectionAttributesDto)collectionService.getDtoByHql(hql);
		return attrs;
	}
	private CollectionAttributesDto getOCFossilAttributes0(String objId){
		String hql = "SELECT new com.tj720.mip.dto.CollectionAttributesDto(c.name AS collectionsCategory,o.gsNo,o.name,o.formerly,o.foreignName,o.yearType,"
				+ "o.collectionUnit) FROM MipOpenFossilInfo o, CollectionCategory c where o.collectionsCategory=c.id AND o.isOpen = 2 AND o.status > 0 AND "
				+ "o.id='"+objId+"'";
		CollectionAttributesDto attrs=(CollectionAttributesDto)collectionService.getDtoByHql(hql);
		return attrs;
	}
*/
}
