package com.tj720.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.elasticsearch.search.aggregations.metrics.percentiles.hdr.InternalHDRPercentileRanks.Iter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.admin.dao.map.MipOpenCollectionInfoMapper;
import com.tj720.admin.dao.map.MipOpenCulturalrelicInfoApprovalMapper;
import com.tj720.admin.model.MipOpenCulturalrelicInfoApproval;
import com.tj720.admin.model.MipOpenCulturalrelicInfoApprovalExample;
import com.tj720.admin.model.MipOpenCulturalrelicInfoApprovalExample.Criteria;
import com.tj720.admin.model.MipOpenFossilInfo;
import com.tj720.admin.service.MipOpenCulturalrelicInfoApprovalService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.model.MipOpenCollectionInfo;
import com.tj720.mip.service.table.MipOpenCollectionInfoService;
import com.tj720.admin.model.MipOpenCulturalrelicInfo;
import com.tj720.mip.utils.Page;
import com.zxlhdata.framework.core.authtool.u.J;
import com.zxlhdata.framework.core.authtool.u.j;

/**
* @author chengrongkai
* @version 创建时间：2019年1月3日 上午11:14:49
* @ClassName 类名称
* @Description 类描述
*/
@Service
public class MipOpenCulturalrelicInfoApprovalServiceImpl implements MipOpenCulturalrelicInfoApprovalService{
	
	@Autowired
	MipOpenCulturalrelicInfoApprovalMapper MipOpenCulturalrelicInfoApprovalMapper;
	@Autowired
	MipOpenCollectionInfoMapper mipOpenCollectionInfoMapper;
	
	@Override
	public JsonResult addApprovalInfo(MipOpenCulturalrelicInfoApproval MipOpenCulturalrelicInfoApproval) {
		int count = MipOpenCulturalrelicInfoApprovalMapper.insertSelective(MipOpenCulturalrelicInfoApproval);
		// TODO Auto-generated method stub
		if(count>0){
			return new JsonResult(1);
		}else{
			return new JsonResult(0);
		}
		
	}

	@Override
	public JsonResult operaterApprovalInfo(String id, int type) {
		MipOpenCulturalrelicInfoApproval record = new MipOpenCulturalrelicInfoApproval();
		record.setId(id);
		record.setStatus((byte)type);
		int count = MipOpenCulturalrelicInfoApprovalMapper.updateByPrimaryKeySelective(record);
		record = MipOpenCulturalrelicInfoApprovalMapper.selectByPrimaryKey(id);
		// TODO Auto-generated method stub
		if(count>0){
			List<MipOpenCulturalrelicInfo> info = MipOpenCulturalrelicInfoApprovalMapper.getApprovalInfoDetailNoPage(id);
			List<MipOpenFossilInfo> info1 = MipOpenCulturalrelicInfoApprovalMapper.getApprovalInfoDetail4OpenFossilNoPage(id);
			String[] ids =  new String[info.size()];
			String[] ids1 =  new String[info1.size()];
			for (int i = 0; i < info.size(); i++) {
				ids[i] = info.get(i).getId();
			}
			for (int i = 0; i < info1.size(); i++) {
				ids1[i] = info1.get(i).getId();
			}
			int isOpen = 2;
			if(type == 3){
				isOpen = 1;
			}else{
				for(int i = 0; i < info.size(); i++){
					saveMipOpenCollectionInfo(info.get(i));
				}	
				for(int i = 0; i < info1.size(); i++){
					saveMipOpenFossilInfo(info1.get(i));
				}	
			}			
			if(record.getExt1().equals("1")){
				JsonResult jsonResult = batchUpdateCollectionInfo(ids, isOpen, 0);
				return jsonResult;
			}else{
				JsonResult jsonResult = batchUpdateOpenFossilInfo(ids1, isOpen, 0);
				return jsonResult;
			}
			
		}else{
			return new JsonResult(0);
		}
	}
	@Transactional
	@Override
	public JsonResult batchOperaterApprovalInfo(String[] ids, int type) {
		int count = 0;
		for(int i=0;i<ids.length;i++){
			JsonResult jsonResult = operaterApprovalInfo(ids[i],type);
			if(jsonResult.getSuccess() == 0){
				count++;
			}
		}
		if(count>0){
			return new JsonResult(0);
		}else{
			return new JsonResult(1);
		}
	}

	@Override
	public JsonResult getApprovalInfoList(String applyDept, int status,Page page) {
		int count = MipOpenCulturalrelicInfoApprovalMapper.countApprovalInfoList(applyDept,status);
		page.setAllRow(count);
		List<MipOpenCulturalrelicInfoApproval> list = MipOpenCulturalrelicInfoApprovalMapper.getApprovalInfoList(applyDept,status,page.getStart(),page.getSize());
		if(list != null && list.size()>0){
			for (int j = 0; j < list.size(); j++) {
				MipOpenCulturalrelicInfoApproval temp = list.get(j);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				Date date = temp.getApplyTime();
				String applyTimeStr = sdf.format(date);
				temp.setApplyTimeStr(applyTimeStr);
				temp.setApplyDept(MipOpenCulturalrelicInfoApprovalMapper.getOrgNameById(temp.getApplyDept()));
			}
			
		}
		return new JsonResult(1,list);
	}

	@Override
	public JsonResult getApprovalInfoDetail(String id,Page page) {
		int count = MipOpenCulturalrelicInfoApprovalMapper.countApprovalInfoDetail(id);
		page.setAllRow(count);
		List<MipOpenCulturalrelicInfo> list = MipOpenCulturalrelicInfoApprovalMapper.getApprovalInfoDetail(id,page.getStart(),page.getSize());
		return new JsonResult(1,list);
	}
	
	

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.MipOpenCulturalrelicInfoApprovalService#getApprovalInfoDetail4OpenFossil(java.lang.String, com.tj720.mip.utils.Page)
	 */
	@Override
	public JsonResult getApprovalInfoDetail4OpenFossil(String id, Page page) {
		int count = MipOpenCulturalrelicInfoApprovalMapper.countApprovalInfoDetail(id);
		page.setAllRow(count);
		List<MipOpenFossilInfo> list = MipOpenCulturalrelicInfoApprovalMapper.getApprovalInfoDetail4OpenFossil(id,page.getStart(),page.getSize());
		return new JsonResult(1,list);
	}

	@Override
	public JsonResult getOpenInfoList(String applyDept, Page page) {
		int count = MipOpenCulturalrelicInfoApprovalMapper.countOpenInfoList(applyDept);
		page.setAllRow(count);
		List<MipOpenCollectionInfo> list = MipOpenCulturalrelicInfoApprovalMapper.getOpenInfoList(applyDept,page.getStart(),page.getSize());
		return new JsonResult(1,list);
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.MipOpenCulturalrelicInfoApprovalService#remove4OpenInfo(java.lang.String)
	 */
	@Override
	public JsonResult remove4OpenInfo(String id) {
		// TODO Auto-generated method stub
		//从公开藏品库删除
//		MipOpenCulturalrelicInfoApproval record = MipOpenCulturalrelicInfoApprovalMapper.selectByPrimaryKey(id);
		com.tj720.admin.model.MipOpenCollectionInfo mip = MipOpenCulturalrelicInfoApprovalMapper.getOpenDetail(id);
		int count = MipOpenCulturalrelicInfoApprovalMapper.remove4OpenInfo(id);
		if(count>0){
			//更新藏品库状态
//			if(record.getExt1().equals("2")){
				//默认更新藏品库
				if(mip.getCollectionType().equals("1")){
					JsonResult jsonResult = update4OpenFossilInfo(id,1,0);
					return jsonResult;
				}else{
					JsonResult jsonResult = updateCollectionInfo(id,1,0);
					return jsonResult;
				}			
		}else{
			return new JsonResult(1);
		}
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.MipOpenCulturalrelicInfoApprovalService#batchRemove4OpenInfo(java.lang.String[])
	 */
	@Override
	public JsonResult batchRemove4OpenInfo(String[] ids) {
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			JsonResult jsonResult = remove4OpenInfo(ids[i]);
			if(jsonResult.getSuccess() == 0){
				count++;
			}
		}
		if(count>0){
			return new JsonResult(0);
		}else{
			return new JsonResult(1);
		}
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.MipOpenCulturalrelicInfoApprovalService#updateCollectionInfo(java.lang.String, int, int)
	 */
	@Override
	public JsonResult updateCollectionInfo(String id, int isOpen, int gjOpen) {
		HashMap<String,Object> condition = new HashMap<String,Object>();
		condition.put("id", id);
		condition.put("isOpen", isOpen);
		condition.put("gjOpen", gjOpen);
		int count = MipOpenCulturalrelicInfoApprovalMapper.update4CollectionInfo(condition);
		if(count >0){
			return new JsonResult(1,count);
		}else{
			return new JsonResult(0);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.MipOpenCulturalrelicInfoApprovalService#batchUpdateCollectionInfo(java.lang.String[], int, int)
	 */
	@Override
	public JsonResult batchUpdateCollectionInfo(String[] ids, int isOpen, int gjOpen) {
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			JsonResult jsonResult = updateCollectionInfo(ids[i],isOpen,gjOpen);
			if(jsonResult.getSuccess()==0){
				count++;
			}
		}
		if(count>0){
			return new JsonResult(0);
		}else{
			return new JsonResult(1);
		}
	}
	


	/* (non-Javadoc)
	 * @see com.tj720.admin.service.MipOpenCulturalrelicInfoApprovalService#batchAddApprovalRel(java.lang.String[], java.lang.String)
	 */
	@Override
	public JsonResult batchAddApprovalRel(String[] ids, String approvalId,String type) {
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			HashMap<String,Object> condition = new HashMap<String,Object>();
			condition.put("id", ids[i]);
			condition.put("approvalId", approvalId);
			condition.put("isOpen", 3);
			if(type == "1"){
				int count = MipOpenCulturalrelicInfoApprovalMapper.update4CollectionInfo(condition);
				if(count <= 0){
					result++;
				}
			}else if(type == "2"){
				int count = MipOpenCulturalrelicInfoApprovalMapper.update4OpenFossilInfo(condition);
				if(count <= 0){
					result++;
				}
			}			
		}
		if(result>0){
			return new JsonResult(0);
		}else{
			return new JsonResult(1);
		}
		
	}
	
	/**
	 * 将原文物藏品带id保存到公开表
	 * @param mipOpenCulturalrelicInfo
	 * @return
	 */
	public String saveMipOpenCollectionInfo(MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo) {
		com.tj720.admin.model.MipOpenCollectionInfo record = mipOpenCollectionInfoMapper.selectByPrimaryKey(mipOpenCulturalrelicInfo.getId());
		if(record != null){
			return "0";
		}
		com.tj720.admin.model.MipOpenCollectionInfo mipOpenCollectionInfo = new com.tj720.admin.model.MipOpenCollectionInfo();
		mipOpenCollectionInfo.setId(mipOpenCulturalrelicInfo.getId());
		mipOpenCollectionInfo.setName(mipOpenCulturalrelicInfo.getName());
		mipOpenCollectionInfo.setGsNo(mipOpenCulturalrelicInfo.getGsNo());
		mipOpenCollectionInfo.setCollectionUnit(mipOpenCulturalrelicInfo.getCollectionUnit());
		mipOpenCollectionInfo.setCollectionLevel(mipOpenCulturalrelicInfo.getCollectionLevel());
		mipOpenCollectionInfo.setYearType(mipOpenCulturalrelicInfo.getYearType());
		mipOpenCollectionInfo.setCollectionsCategory(mipOpenCulturalrelicInfo.getCollectionsCategory());
		mipOpenCollectionInfo.setDescription(mipOpenCulturalrelicInfo.getDescription());
		mipOpenCollectionInfo.setfAudio(mipOpenCulturalrelicInfo.getfAudio());
		mipOpenCollectionInfo.setfVideo(mipOpenCulturalrelicInfo.getfVideo());
		mipOpenCollectionInfo.setThreeDimensionalCollection(mipOpenCulturalrelicInfo.getThreeDimensionalCollection());
		mipOpenCollectionInfo.setPictureIds(mipOpenCulturalrelicInfo.getPictureIds());
		mipOpenCollectionInfo.setClickCounts(mipOpenCulturalrelicInfo.getClickCounts());
		mipOpenCollectionInfo.setCollectedCounts(mipOpenCulturalrelicInfo.getCollectedCounts());
		mipOpenCollectionInfo.setUpdatedTime(mipOpenCulturalrelicInfo.getSubmitTime());
		mipOpenCollectionInfo.setIsHighQuality(mipOpenCulturalrelicInfo.getIsHighQuality());
		mipOpenCollectionInfo.setCollectionType(mipOpenCulturalrelicInfo.getCollectionType());
		mipOpenCollectionInfo.setCreatetime(mipOpenCulturalrelicInfo.getCreateTime());
		mipOpenCollectionInfo.setStatus(mipOpenCulturalrelicInfo.getStatus());
		mipOpenCollectionInfo.setSequence(mipOpenCulturalrelicInfo.getSequence());
		mipOpenCollectionInfo.setRingBeatData(mipOpenCulturalrelicInfo.getRingBeatData());
		int count = mipOpenCollectionInfoMapper.insertSelective(mipOpenCollectionInfo);
		if(count > 0){
			return "1";
		}else{
			return "0";
		}
	}
	
	public String saveMipOpenFossilInfo(MipOpenFossilInfo mipOpenCulturalrelicInfo) {
		com.tj720.admin.model.MipOpenCollectionInfo record = mipOpenCollectionInfoMapper.selectByPrimaryKey(mipOpenCulturalrelicInfo.getId());
		if(record != null){
			return "0";
		}
		com.tj720.admin.model.MipOpenCollectionInfo mipOpenCollectionInfo = new com.tj720.admin.model.MipOpenCollectionInfo();
		mipOpenCollectionInfo.setId(mipOpenCulturalrelicInfo.getId());
		mipOpenCollectionInfo.setName(mipOpenCulturalrelicInfo.getName());
		mipOpenCollectionInfo.setGsNo(mipOpenCulturalrelicInfo.getGsNo());
		mipOpenCollectionInfo.setCollectionUnit(mipOpenCulturalrelicInfo.getCollectionUnit());
		mipOpenCollectionInfo.setCollectionLevel(mipOpenCulturalrelicInfo.getCollectionLevel());
		mipOpenCollectionInfo.setYearType(mipOpenCulturalrelicInfo.getYearType());
		mipOpenCollectionInfo.setCollectionsCategory(mipOpenCulturalrelicInfo.getCollectionsCategory());
		mipOpenCollectionInfo.setDescription(mipOpenCulturalrelicInfo.getDescription());
		mipOpenCollectionInfo.setfAudio(mipOpenCulturalrelicInfo.getfAudio());
		mipOpenCollectionInfo.setfVideo(mipOpenCulturalrelicInfo.getfVideo());
		mipOpenCollectionInfo.setThreeDimensionalCollection(mipOpenCulturalrelicInfo.getThreeDimensionalCollection());
		mipOpenCollectionInfo.setPictureIds(mipOpenCulturalrelicInfo.getPictureIds());
		mipOpenCollectionInfo.setClickCounts(mipOpenCulturalrelicInfo.getClickCounts());
		mipOpenCollectionInfo.setCollectedCounts(mipOpenCulturalrelicInfo.getCollectedCounts());
		mipOpenCollectionInfo.setUpdatedTime(mipOpenCulturalrelicInfo.getSubmitTime());
		mipOpenCollectionInfo.setIsHighQuality(mipOpenCulturalrelicInfo.getIsHighQuality());
		mipOpenCollectionInfo.setCollectionType(mipOpenCulturalrelicInfo.getCollectionType());
		mipOpenCollectionInfo.setCreatetime(mipOpenCulturalrelicInfo.getCreateTime());
		mipOpenCollectionInfo.setStatus(mipOpenCulturalrelicInfo.getStatus());
		mipOpenCollectionInfo.setSequence(mipOpenCulturalrelicInfo.getSequence());
		mipOpenCollectionInfo.setRingBeatData(mipOpenCulturalrelicInfo.getRingBeatData());
		int count = mipOpenCollectionInfoMapper.insertSelective(mipOpenCollectionInfo);
		if(count > 0){
			return "1";
		}else{
			return "0";
		}
	}

	@Override
	public JsonResult update4OpenFossilInfo(String id, int isOpen, int gjOpen) {
		HashMap<String,Object> condition = new HashMap<String,Object>();
		condition.put("id", id);
		condition.put("isOpen", isOpen);
		condition.put("gjOpen", gjOpen);
		int count = MipOpenCulturalrelicInfoApprovalMapper.update4OpenFossilInfo(condition);
		if(count>0){
			return new JsonResult(1,count);
		}else{
			return new JsonResult(0);
		}
		
	}
	
	@Override
	public JsonResult batchUpdateOpenFossilInfo(String[] ids, int isOpen, int gjOpen) {
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			JsonResult jsonResult = update4OpenFossilInfo(ids[i],isOpen,gjOpen);
			if(jsonResult.getSuccess()==0){
				count++;
			}
		}
		if(count>0){
			return new JsonResult(0);
		}else{
			return new JsonResult(1);
		}
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.MipOpenCulturalrelicInfoApprovalService#getApprovalInfo(java.lang.String)
	 */
	@Override
	public MipOpenCulturalrelicInfoApproval getApprovalInfo(String id) {
		// TODO Auto-generated method stub
		return MipOpenCulturalrelicInfoApprovalMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.tj720.admin.service.MipOpenCulturalrelicInfoApprovalService#getOpenDetail(java.lang.String)
	 */
	@Override
	public JsonResult getOpenDetail(String id) {
		com.tj720.admin.model.MipOpenCollectionInfo data = MipOpenCulturalrelicInfoApprovalMapper.getOpenDetail(id);
		return new JsonResult(1,data);
	}
	
	
	
	
}
