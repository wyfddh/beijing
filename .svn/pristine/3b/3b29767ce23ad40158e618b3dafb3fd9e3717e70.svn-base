package com.tj720.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.base.service.BaseServiceImpl;
import com.tj720.admin.dao.map.GmMuseumRegisterInfoMapper;
import com.tj720.admin.model.GmMuseumRegisterInfo;
import com.tj720.admin.model.GmMuseumRegisterInfoExample;
import com.tj720.admin.model.GmMuseumRegisterInfoExample.Criteria;
import com.tj720.admin.model.GmMuseumRegisterInfoWithBLOBs;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.service.GmMuseumRegisterInfoService;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.IMipUserService;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;
@Service("gmMuseumRegisterInforServiceImpl")
public class GmMuseumRegisterInforServiceImpl extends BaseServiceImpl<GmMuseumRegisterInfo> implements GmMuseumRegisterInfoService{

	
	@Autowired
	private GmMuseumRegisterInfoMapper  registerInfo;
	@Autowired
	private IMipOrganizationService organizationService;
	@Autowired
	private IMipUserService userService;
	
	@Override
	public BaseDao<GmMuseumRegisterInfo> getBaseDao() {
		return registerInfo;
	}
	@Override
	public List<GmMuseumRegisterInfoWithBLOBs> getInfoList(Page page, int orgId, byte level) {
		GmMuseumRegisterInfoExample example = new GmMuseumRegisterInfoExample();
		Criteria criteria = example.createCriteria();
		if (level == 1) {
			//查全省
		}
		if (level == 2) {
			//查全市
			List<MipOrganization> organizations = organizationService.getListByPId(orgId);
			List<String> orgList = new ArrayList<String>();
			for (MipOrganization org : organizations) {
				orgList.add(org.getId()+"");
			}
			criteria.andOrgIdIn(orgList);
		}
		if (level == 3) {
			//博物馆
			criteria.andOrgIdEqualTo(orgId+"");
		}
		int count = registerInfo.countByExample(example);
		example.setOrderByClause("org_id asc");
		page.setAllRow(count);
//		String order = "create_time desc";
//		example.setOrderByClause(order);
		example.setSize(page.getSize());
		example.setStartPage(page.getStart());
		List<GmMuseumRegisterInfoWithBLOBs> list = registerInfo.selectByExampleWithBLOBs(example);
		return list;
	}
	@Override
	public GmMuseumRegisterInfoWithBLOBs saveRegister(GmMuseumRegisterInfo info){
		String userId = Tools.getUserId();
		MipUser user = userService.getUser(userId);
		GmMuseumRegisterInfoExample example = new GmMuseumRegisterInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(user.getOrgId());
		List<GmMuseumRegisterInfoWithBLOBs> list = registerInfo.selectByExampleWithBLOBs(example);
		if(list.size()>0){
			return list.get(0);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmsss");
		Date data = new Date();
		info.setId(sdf1.format(data));
		info.setOrgId(user.getOrgId());
		info.setCreateTime(sdf.format(data));
		int a =registerInfo.insert(info);
		if(a>0){
			list = registerInfo.selectByExampleWithBLOBs(example);
			return list.get(0);
		}else{
			return null;
		}
		
	}
	@Override
	public GmMuseumRegisterInfoWithBLOBs getRegister(String id) {
		GmMuseumRegisterInfoExample example = new GmMuseumRegisterInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrgIdEqualTo(id);
		GmMuseumRegisterInfoWithBLOBs list = registerInfo.selectByPrimaryKey(id);
		if(list!=null){
			return list;
		}else{
			return null;
		}
	}

}
