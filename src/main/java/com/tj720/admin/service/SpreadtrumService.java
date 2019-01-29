/**
 * 
 */
package com.tj720.admin.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.tj720.mip.dto.SpreadtrumDto;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Page;

/**
 * @author 程荣凯
 *
 */
@Service
public interface SpreadtrumService {
	 	JsonResult getSpreadtrumList(String orderCondition,Page page ) throws ParseException; 
	 	JsonResult getVirtualExibitionHallList(Page page);
	    
	    HashMap getSpreadtrumByCondition(String orgId,String id);
	    
	    HashMap getVirtualExibitionHallByCondition(String orgId,String id);
	    
	    JsonResult getPictureByPicId(String attFkId,String attId,Page page);
	    //移动端 展览列表
	    JsonResult getWebSpreadtrumList(String key, String area,Page page)throws ParseException;
}
