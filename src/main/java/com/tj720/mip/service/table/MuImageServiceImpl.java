/** 
 * <pre>项目名称:mip 
 * 文件名称:VirtualServiceImpl.java 
 * 包名:com.tj720.mip.service.content 
 * 创建日期:2017年1月14日上午11:20:02 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.service.table;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.ICommentDao;
import com.tj720.mip.inter.dao.MuImageDao;
import com.tj720.mip.inter.dao.VirtualDao;
import com.tj720.mip.inter.service.table.MuImageService;
import com.tj720.mip.model.Comment;
import com.tj720.mip.model.MuImage;
import com.tj720.mip.model.VirtualShowroom;
import com.tj720.mip.utils.Page;

/** 
 * <pre>项目名称：mip    
 * 类名称：VirtualServiceImpl    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月14日 上午11:20:02    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月14日 上午11:20:02    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class MuImageServiceImpl extends BaseService<MuImage> implements MuImageService{
	@Resource(name="muImageDao")
	MuImageDao muImageDao;
	
	@Resource(name="muImageDao")
	public void setDao(IBaseDao<MuImage> dao) {
		super.setDao(dao);
	}
	
}
