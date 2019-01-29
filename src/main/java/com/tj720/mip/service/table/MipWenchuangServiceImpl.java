/** 
 * <pre>项目名称:mip 
 * 文件名称:MipWenchuangServiceImpl.java 
 * 包名:com.tj720.mip.service.table 
 * 创建日期:2017年3月28日下午4:58:09 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.service.table;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.dao.map.MipWenchuangMapper;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.MipWenchuangDao;
import com.tj720.mip.inter.service.table.MipWenchuangService;
import com.tj720.mip.model.MipWenchuang;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.Page;

/** 
 * <pre>项目名称：mip    
 * 类名称：MipWenchuangServiceImpl    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年3月28日 下午4:58:09    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年3月28日 下午4:58:09    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class MipWenchuangServiceImpl extends BaseService<MipWenchuang> implements MipWenchuangService{
	@Resource(name="mipWenchuangDao")
	MipWenchuangDao mipWenchuangDao;
	
	@Autowired
	MipWenchuangMapper mipWenchuangMapper;
	
	@Resource(name="mipWenchuangDao")
	public void setDao(IBaseDao<MipWenchuang> dao) {
		super.setDao(dao);
	}

	/* (non-Javadoc)    
	 * @see com.tj720.mip.inter.service.table.MipWenchuangService#getSeachHql(com.tj720.mip.model.MipWenchuang, java.lang.String, java.lang.Long, java.lang.Long, byte, java.lang.String)    
	 */
	@Override
	public String getSeachHql(MipWenchuang wenchuang, String keys, String orgId) {
		StringBuffer seachHql = new StringBuffer(" from MipWenchuang where 1=1 ");
		if(wenchuang.getPublish() == -1){
			seachHql.append(" and publish > -128 ");
		}
		if(wenchuang.getPublish() != -1){
			seachHql.append(" and publish =  " + wenchuang.getPublish());
		}
		if(wenchuang.getCategoryId() != 0 && wenchuang.getCategoryId() != null){
			seachHql.append(" and categoryId =  " + wenchuang.getCategoryId());
		}
		if(keys != null && !keys.equals("")){
			String key = keys.replace(" ", "");
			seachHql.append(" and ( productNumber like '%"+key+"%' or productName like '%"+key+"%' )");
		}
		if(wenchuang.getStaPrice() != null && !wenchuang.getStaPrice().equals("")){
			seachHql.append(" and productPrice >=  " + wenchuang.getStaPrice());
		}
		if(wenchuang.getOverPrice() != null && !wenchuang.getOverPrice().equals("")){
			seachHql.append(" and productPrice <=  " + wenchuang.getOverPrice());
		}
		if(!StringUtils.isBlank(orgId)){
			seachHql.append(" and orgId in (" + orgId + ")");
		}
		if(wenchuang.getOrgId() != null && wenchuang.getOrgId() != 0){
			seachHql.append(" and orgId =  " + wenchuang.getOrgId());
		}
		seachHql.append(" ORDER BY createTime DESC ");
		return seachHql.toString();
	}

	@Override
	public List<MipWenchuang> getList(String key, String publish, String categoryId, String staPrice, String overPrice,
			String orgId, List<String> orgList, Page page, String currentOrg) {
		int count = mipWenchuangMapper.countListByKey(key, publish, categoryId, staPrice, overPrice, orgId, orgList, currentOrg);
		page.setAllRow(count);
		return mipWenchuangMapper.selectListByKey(key, publish, categoryId, staPrice, overPrice, orgId, orgList, page.getSize(), page.getStart(), currentOrg);
	}

	@Override
	public List<MipWenchuang> getReleList(String currentId, String categoryId, Integer size) {
		return mipWenchuangMapper.getReleList(currentId, categoryId, size);
	}

	@Override
	public MipWenchuang saveDesignData(Map<String, Object> map, String userId, String orgId) {
		MipWenchuang wenchuang = new MipWenchuang();
		try {
			wenchuang.setPublish((byte) 0);
			wenchuang.setUserId(userId);
			wenchuang.setOrgId(Integer.valueOf(orgId));
			wenchuang.setPublishTime((long) 0);
			wenchuang.setSequence(50);
			wenchuang.setCreateTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS));
			
			wenchuang.setProductName(((String[]) map.get("BD1537772421911@0600001"))[0]);		//产品标题-产品名称
			wenchuang.setCategoryId(NumberUtils.stringToInt(((String[]) map.get("BD1537772421911@0600002"))[0], 1));		//类别-产品类别
			wenchuang.setDesignElements(((String[]) map.get("BD1537772421911@0600004"))[0]);		//设计元素-开发理念
			return wenchuang;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
