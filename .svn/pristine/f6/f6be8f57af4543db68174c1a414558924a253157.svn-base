package com.tj720.admin.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tj720.admin.dto.MipLogSearchDto;
import com.tj720.admin.model.MipLog;
import com.tj720.admin.model.MipOpenCulturalrelicInfoWithBLOBs;
import com.tj720.mip.dto.LoginDto;
import com.tj720.mip.model.MipJiLinArticle;
import com.tj720.mip.model.MipOpenFossilInfo;
import com.tj720.mip.model.MipWenchuang;
import com.tj720.mip.model.Spreadtrum;
import com.tj720.mip.model.User;
import com.tj720.mip.model.VirtualShowroom;
import com.tj720.mip.utils.Page;

public interface MipLogService {

	/**
	 * 登录日志（失败）
	 * @param request
	 * @param model
	 */
	public void LogonLog(HttpServletRequest request,LoginDto model);
	/**
	 * 登录日志（成功）
	 * @param request
	 * @param model
	 */
	public void LogonLog(HttpServletRequest request,User user);
	
	/**
	 * 查询后台日志列表
	 * @param mipLog
	 * @return
	 */
	public List<MipLog> listMipLog(MipLogSearchDto mipLog,Page page);
	
	/**
	 * 日志列表-mybatis
	 * @param mipLog
	 * @param page
	 * @return
	 */
	public List<MipLog> listMipLogByKey(MipLogSearchDto mipLog,Page page);
	
	/**
	 * 藏品日志
	 * @param mipOPenCultural
	 */
	public void occLog(HttpServletRequest request,MipOpenCulturalrelicInfoWithBLOBs mipOPenCultural,String remark);
	/**
	 * 化石日志
	 * @param mipOPenCultural
	 */
	public void ocfLog(HttpServletRequest request,MipOpenFossilInfo mipOpenFossilInfo,String remark);
	
	/**
	 * 用户日志（增加管理员，修改密码）
	 * @param request
	 * @param user
	 */
	public void userLog(HttpServletRequest request,User user,String remark);
	/**
	 * 内容-展览展讯
	 * @param request
	 * @param user
	 */
	public void contentLog(HttpServletRequest request,Spreadtrum spreadtrum,String remark);
	/**
	 * 内容-文物故事
	 * @param request
	 * @param user
	 */
	public void contentLog(HttpServletRequest request,MipJiLinArticle mipJiLinArticle,String remark);
	/**
	 * 内容-虚拟展厅
	 * @param request
	 * @param user
	 */
	public void contentLog(HttpServletRequest request,VirtualShowroom virtualShowroom,String remark);
	/**
	 * 内容-文创产品
	 * @param request
	 * @param user
	 */
	public void contentLog(HttpServletRequest request,MipWenchuang mipWenchuang,String remark);
}
