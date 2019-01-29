package com.tj720.mip.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tj720.mip.model.MipJiLinArticle;
import com.tj720.mip.model.MipOpenCulturalrelicInfo;
import com.tj720.mip.model.MipOpenFossilInfo;
import com.tj720.mip.model.MipWenchuang;
import com.tj720.mip.model.OutsideAndAbroad;
import com.tj720.mip.model.Picture;
import com.tj720.mip.model.Spreadtrum;
import com.tj720.mip.model.VirtualShowroom;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IPictureService;

public class ImageModifyThread extends Thread{
	public IMipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
	public IPictureService pictureService;
	public String currentFile="";
	public int totalcount=0;
	public int changecount=0;
	public double percentage=0.0;
	/**
	 * 批量处理图片
	 *
	 * @throws IOException
	 */
	public void run(){
		//通过Object 获取正确的 picture 的id
		String[] objects = {"Spreadtrum", "OutsideAndAbroad", "VirtualShowroom", "MipWenchuang", "MipActivity", "MipJiLinArticle", "MipOpenFossilInfo", "MipOpenCulturalrelicInfo"};
		double unit=100.0/objects.length;
		int index=0;
		int count=0;
		double tmp_percent=0.0;
		//循环遍历获取object，通过object获取picture的id
		for (String object : objects) {
			tmp_percent=percentage;
			index=0;
			this.currentFile=object;
			if ("MipOpenCulturalrelicInfo".equals(object)) {
				List<MipOpenCulturalrelicInfo> mociList = (List<MipOpenCulturalrelicInfo>) mipOpenCulturalrelicInfoService.queryByHql("select new MipOpenCulturalrelicInfo(id,pictureIds) from " + object, Tools.getMap());
				count=mociList.size();
				for (MipOpenCulturalrelicInfo moci : mociList) {
					String pictureIds = moci.getPictureIds();
					if (!MyString.isEmpty(pictureIds)) {
						String[] split = pictureIds.split(",");
						StringBuffer sb = new StringBuffer("'");
						for (String pid : split) {
							sb.append(pid).append("','");
						}
						pictureIds = sb.substring(0, sb.length() - 2);
						ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql("from Picture where id in (" + pictureIds + ")", Tools.getMap());
						if (!MyString.isEmpty(pictures)) {
							for (Picture picture : pictures) {
								String objectId = picture.getObjectId();
								if (!moci.getId().equals(objectId)) {
									picture.setObjectId(moci.getId());
									picture.setTypeId("3");
									pictureService.update(picture);
								}
							}
						}
						pictures = (ArrayList<Picture>) pictureService.queryByHql("from Picture where objectId ='"+moci.getId()+"' and id not in (" + pictureIds + ")", Tools.getMap());
						if (!MyString.isEmpty(pictures)) {
							for (Picture picture : pictures) {
								picture.setObjectId("-65535");
								picture.setTypeId("-65535");
								pictureService.update(picture);
							}
						}
						changecount++;
					}
					totalcount++;
					index++;
					percentage=tmp_percent+unit*index/count;
				}
			}else if ("MipOpenFossilInfo".equals(object)) {
				List<MipOpenFossilInfo> mofiList = (List<MipOpenFossilInfo>) mipOpenCulturalrelicInfoService.queryByHql("from " + object, Tools.getMap());
				for (MipOpenFossilInfo moci : mofiList) {
					String pictureIds = moci.getPictureId();
					if (!MyString.isEmpty(pictureIds)) {
						String[] split = pictureIds.split(",");
						StringBuffer sb = new StringBuffer("'");
						for (String pid : split) {
							sb.append(pid).append("','");
						}
						pictureIds = sb.substring(0, sb.length() - 2);
						ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql("from Picture where id in (" + pictureIds + ")", Tools.getMap());
						if (!MyString.isEmpty(pictures)) {
							for (Picture picture : pictures) {
								String objectId = picture.getObjectId();
								if (!moci.getId().equals(objectId)) {
									picture.setObjectId(moci.getId());
									picture.setTypeId("4");
									pictureService.update(picture);
								}
							}
						}
						changecount++;
					}
					totalcount++;
					index++;
					percentage=tmp_percent+unit*index/count;
				}
			}else if ("Spreadtrum".equals(object)) {
				List<Spreadtrum> mofiList = (List<Spreadtrum>) mipOpenCulturalrelicInfoService.queryByHql("from " + object, Tools.getMap());
				for (Spreadtrum moci : mofiList) {
					String pictureIds = moci.getPicture();
					if (!MyString.isEmpty(pictureIds)) {
						String[] split = pictureIds.split(",");
						StringBuffer sb = new StringBuffer("'");
						for (String pid : split) {
							sb.append(pid).append("','");
						}
						pictureIds = sb.substring(0, sb.length() - 2);
						ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql("from Picture where id in (" + pictureIds + ")", Tools.getMap());
						if (!MyString.isEmpty(pictures)) {
							for (Picture picture : pictures) {
								String objectId = picture.getObjectId();
								if (!moci.getId().equals(objectId)) {
									picture.setObjectId(moci.getId());
									picture.setTypeId("5");
									pictureService.update(picture);
								}
							}
						}
					}
					changecount++;
				}
				totalcount++;
				index++;
				percentage=tmp_percent+unit*index/count;
			}else if ("OutsideAndAbroad".equals(object)) {
				List<OutsideAndAbroad> mofiList = (List<OutsideAndAbroad>) mipOpenCulturalrelicInfoService.queryByHql("from " + object, Tools.getMap());
				for (OutsideAndAbroad moci : mofiList) {
					String pictureIds = moci.getPicture();
					if (!MyString.isEmpty(pictureIds)) {
						String[] split = pictureIds.split(",");
						StringBuffer sb = new StringBuffer("'");
						for (String pid : split) {
							sb.append(pid).append("','");
						}
						pictureIds = sb.substring(0, sb.length() - 2);
						ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql("from Picture where id in (" + pictureIds + ")", Tools.getMap());
						if (!MyString.isEmpty(pictures)) {
							for (Picture picture : pictures) {
								String objectId = picture.getObjectId();
								if (!moci.getId().equals(objectId)) {
									picture.setObjectId(moci.getId());
									picture.setTypeId("6");
									pictureService.update(picture);
								}
							}
						}
						changecount++;
					}
					totalcount++;
					index++;
					percentage=tmp_percent+unit*index/count;
				}
			}else if ("VirtualShowroom".equals(object)) {
				List<VirtualShowroom> mofiList = (List<VirtualShowroom>) mipOpenCulturalrelicInfoService.queryByHql("from " + object, Tools.getMap());
				for (VirtualShowroom moci : mofiList) {
					String pictureIds = moci.getViMasterMap();
					if (!MyString.isEmpty(pictureIds)) {
						String[] split = pictureIds.split(",");
						StringBuffer sb = new StringBuffer("'");
						for (String pid : split) {
							sb.append(pid).append("','");
						}
						pictureIds = sb.substring(0, sb.length() - 2);
						ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql("from Picture where id in (" + pictureIds + ")", Tools.getMap());
						if (!MyString.isEmpty(pictures)) {
							for (Picture picture : pictures) {
								String objectId = picture.getObjectId();
								if (!moci.getId().equals(objectId)) {
									picture.setObjectId(moci.getId());
									picture.setTypeId("7");
									pictureService.update(picture);
								}
							}
						}
						changecount++;
					}
					totalcount++;
					index++;
					percentage=tmp_percent+unit*index/count;
				}
			}else if ("MipWenchuang".equals(object)) {
				List<MipWenchuang> mofiList = (List<MipWenchuang>) mipOpenCulturalrelicInfoService.queryByHql("from " + object, Tools.getMap());
				for (MipWenchuang moci : mofiList) {
					String pictureIds = moci.getPictureId();
					if (!MyString.isEmpty(pictureIds)) {
						String[] split = pictureIds.split(",");
						StringBuffer sb = new StringBuffer("'");
						for (String pid : split) {
							sb.append(pid).append("','");
						}
						pictureIds = sb.substring(0, sb.length() - 2);
						ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql("from Picture where id in (" + pictureIds + ")", Tools.getMap());
						if (!MyString.isEmpty(pictures)) {
							for (Picture picture : pictures) {
								String objectId = picture.getObjectId();
								if (!moci.getId().equals(objectId)) {
									picture.setObjectId(moci.getId());
									picture.setTypeId("10");
									pictureService.update(picture);
								}
							}
						}
						changecount++;
					}
					totalcount++;
					index++;
					percentage=tmp_percent+unit*index/count;
				}
			}else if ("MipJiLinArticle".equals(object)) {
				List<MipJiLinArticle> mofiList = (List<MipJiLinArticle>) mipOpenCulturalrelicInfoService.queryByHql("from " + object, Tools.getMap());
				for (MipJiLinArticle moci : mofiList) {
					String pictureIds = moci.getPictureId();
					if (!MyString.isEmpty(pictureIds)) {
						String[] split = pictureIds.split(",");
						StringBuffer sb = new StringBuffer("'");
						for (String pid : split) {
							sb.append(pid).append("','");
						}
						pictureIds = sb.substring(0, sb.length() - 2);
						ArrayList<Picture> pictures = (ArrayList<Picture>) pictureService.queryByHql("from Picture where id in (" + pictureIds + ")", Tools.getMap());
						if (!MyString.isEmpty(pictures)) {
							for (Picture picture : pictures) {
								String objectId = picture.getObjectId();
								if (!moci.getId().equals(objectId)) {
									picture.setObjectId(moci.getId());
									picture.setTypeId("11");
									pictureService.update(picture);
								}
							}
						}
						changecount++;
					}
					totalcount++;
					index++;
					percentage=tmp_percent+unit*index/count;
				}
			}
			percentage=tmp_percent+unit;
		}
	}
}
