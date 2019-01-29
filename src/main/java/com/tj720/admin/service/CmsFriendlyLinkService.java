package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.model.CmsFriendlyLink;
import com.tj720.admin.model.CmsFriendlyLinkExample;
import com.tj720.mip.utils.Page;

public interface CmsFriendlyLinkService {

	/**
	 * 友情链接列表
	 * @param mipLog
	 * @return
	 */
	public List<CmsFriendlyLink> listCmsFriendlyLink(Page page);
	
	/**
	 * 查询单个友情链接信息
	 * @param id
	 * @return
	 */
	public CmsFriendlyLink getCmsFriendlyLink(Integer id);
	
	/**
	 * 更新友情链接信息
	 * @param cmsCommentKeyword
	 * @return
	 */
	public int updateCmsFriendlyLink(CmsFriendlyLink cmsFriendlyLink);
	
	/**
	 * 新增友情链接信息
	 * @param cmsCommentKeyword
	 * @return
	 */
	public int insertCmsFriendlyLink(CmsFriendlyLink cmsFriendlyLink);
	
	/**
	 * 删除友情链接信息
	 * @param id
	 * @return
	 */
	public int delectCmsFriendlyLinkInfo(Integer id);

	/**
	 * 根据条件查询list数据
	 * @param mipLog
	 * @return
	 */
	public List<CmsFriendlyLink> selectListByExample(CmsFriendlyLinkExample cmsFriendlyLinkExample);
}
