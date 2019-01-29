/** 
 * <pre>项目名称:mip 
 * 文件名称:VirtualDaoImpl.java 
 * 包名:com.tj720.mip.dao 
 * 创建日期:2017年1月14日上午11:23:51 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.dao;

import org.springframework.stereotype.Repository;

import com.tj720.mip.framework.base.BaseDao;
import com.tj720.mip.inter.dao.MuImageDao;
import com.tj720.mip.inter.dao.VirtualDao;
import com.tj720.mip.model.MuImage;
import com.tj720.mip.model.VirtualShowroom;

/** 
 * <pre>项目名称：mip    
 * 类名称：VirtualDaoImpl    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年1月14日 上午11:23:51    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年1月14日 上午11:23:51    
 * 修改备注：       
 * @version </pre>    
 */
@Repository("muImageDao")
public class MuImageDaoImpl extends BaseDao<MuImage> implements MuImageDao{
	
}
