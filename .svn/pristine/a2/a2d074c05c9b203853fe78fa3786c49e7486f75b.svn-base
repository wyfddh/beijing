package com.tj720.admin.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.StringUtil;
import com.tj720.admin.common.util.TimeUtil;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.MipLogMapper;
import com.tj720.admin.dao.map.MipUserMapper;
import com.tj720.admin.dto.MipLogSearchDto;
import com.tj720.admin.model.MipLog;
import com.tj720.admin.model.MipLogExample;
import com.tj720.admin.model.MipLogExample.Criteria;
import com.tj720.admin.model.MipOpenCulturalrelicInfoWithBLOBs;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.service.MipLogService;
import com.tj720.mip.dto.LoginDto;
import com.tj720.mip.dto.UserDto;
import com.tj720.mip.model.MipJiLinArticle;
import com.tj720.mip.model.MipOpenFossilInfo;
import com.tj720.mip.model.MipWenchuang;
import com.tj720.mip.model.Spreadtrum;
import com.tj720.mip.model.User;
import com.tj720.mip.model.VirtualShowroom;
import com.tj720.mip.utils.Page;

@Service
public class MipLogServiceImpl implements MipLogService{

	@Autowired
	private MipLogMapper mipLogMapper;
	@Autowired
	private MipUserMapper mipUserMapper;
	
	@Override
	public void LogonLog(HttpServletRequest request, LoginDto model) {
		String ip = getIp(request);
		MipLog assemble = assemble(ip,model);
		save(assemble);
	}

	@Override
	public void LogonLog(HttpServletRequest request, User user) {
		String ip = getIp(request);
		MipLog assemble = assemble(ip,user);
		UserDto userDto = getUserDto(request);
		if("0".equals(userDto.getPasswordType())) {
			//通用密码访问
			assemble.setStatus((byte)1);
		}else {
			assemble.setStatus((byte)2);
		}
		save(assemble);
	}
	/**
	 * 获取ip
	 * @param request
	 * @return
	 */
	private String getIp(HttpServletRequest request) {
		String add = Utils.getIpAddr(request);// 获取当前用户的IP
		return add;
	}
	/**
	 * 保存数据
	 * @param mipLog
	 */
	private void save(MipLog mipLog) {
		mipLogMapper.insert(mipLog);
	}
	/**
	 * 组装数据(登录失败)
	 * @return
	 */
	private MipLog assemble(String ip,LoginDto model) {
		MipLog ml = new MipLog();
			ml.setId(UUID.randomUUID().toString());
			ml.setCreatetime(TimeUtil.GetCurDateTime());
			ml.setPhone(model.getPhone());
			ml.setContent(JSON.toJSONString(model));
			ml.setStatus((byte)3);
			ml.setIp(ip);
			ml.setModelclass("LoginDto");
			ml.setModelname("登录");
			ml.setRemark(model.getTipMessage());
			ml.setSequence(0);
			ml.setType("4");
			ml.setUpdateby("");
		return ml;
	}
	/**
	 * 组装数据(登录成功)
	 * @return
	 */
	private MipLog assemble(String ip,User user) {
		MipLog ml = new MipLog();
			ml.setId(UUID.randomUUID().toString());
			ml.setCreatetime(TimeUtil.GetCurDateTime());
			ml.setPhone(user.getPhone());
			ml.setContent(JSON.toJSONString(user));
			ml.setStatus((byte)2);
			ml.setIp(ip);
			ml.setModelclass("User");
			ml.setModelname("登录");
			ml.setRemark("登录成功");
			ml.setSequence(0);
			ml.setType("4");
			ml.setUpdateby(user.getId());
		return ml;
	}
	/**
	 * 组装数据(藏品)
	 * @return
	 */
	private MipLog assemble(HttpServletRequest request,MipOpenCulturalrelicInfoWithBLOBs mipOpenCultural,String remark) {
		MipLog ml = new MipLog();
		ml.setContent(JSON.toJSONString(mipOpenCultural));
		ml.setModelclass("MipOpenCulturalrelicInfoWithBLOBs");
		ml.setModelname("藏品");
		ml.setRemark("藏品名称:"+mipOpenCultural.getName()+",藏品id:"+mipOpenCultural.getId()+",操作:"+remark);
		ml.setSequence(0);
		ml.setType("1");
		getUser(request,ml);
		return ml;
	}
	/**
	 * 组装数据(化石)
	 * @return
	 */
	private MipLog assemble(HttpServletRequest request,MipOpenFossilInfo mipOpenFossilInfo,String remark) {
		MipLog ml = new MipLog();
		ml.setContent(JSON.toJSONString(mipOpenFossilInfo));
		ml.setModelclass("MipOpenFossilInfo");
		ml.setModelname("化石");
		ml.setRemark("化石名称:"+mipOpenFossilInfo.getName()+",化石id:"+mipOpenFossilInfo.getId()+",操作:"+remark);
		ml.setSequence(0);
		ml.setType("1");
		getUser(request,ml);
		return ml;
	}
	/**
	 * 组装数据(用户)
	 * @return
	 */
	private MipLog assemble(HttpServletRequest request,User user,String remark) {
		MipLog ml = new MipLog();
		if(user != null) {
			ml.setContent(JSON.toJSONString(user));
		}
		ml.setModelclass("User");
		ml.setModelname("用户");
		ml.setRemark(remark);
		ml.setSequence(0);
		ml.setType("2");
		getUser(request,ml);
		return ml;
	}
	/**
	 * 组装数据(内容-展讯)
	 * @return
	 */
	private MipLog assemble(HttpServletRequest request,Spreadtrum spreadtrum,String remark) {
		MipLog ml = new MipLog();
		ml.setRemark(remark);
		if(spreadtrum != null) {
			ml.setContent(JSON.toJSONString(spreadtrum));
			ml.setRemark("展讯名称:"+spreadtrum.getHeadline()+",展讯id:"+spreadtrum.getId()+",操作:"+remark);
		}
		ml.setModelclass("Spreadtrum");
		ml.setModelname("展讯");
		ml.setSequence(0);
		ml.setType("3");
		getUser(request,ml);
		return ml;
	}
	/**
	 * 组装数据(内容-文物故事)
	 * @return
	 */
	private MipLog assemble(HttpServletRequest request,MipJiLinArticle mipJiLinArticle,String remark) {
		MipLog ml = new MipLog();
		ml.setRemark(remark);
		if(mipJiLinArticle != null) {
			ml.setContent(JSON.toJSONString(mipJiLinArticle));
			ml.setRemark("文物故事名称:"+mipJiLinArticle.getHeadline()+",文物故事id:"+mipJiLinArticle.getId()+",操作:"+remark);
		}
		ml.setModelclass("MipJiLinArticle");
		ml.setModelname("文物故事");
		ml.setSequence(0);
		ml.setType("3");
		getUser(request,ml);
		return ml;
	}
	/**
	 * 组装数据(内容-虚拟展厅)
	 * @return
	 */
	private MipLog assemble(HttpServletRequest request,VirtualShowroom virtualShowroom,String remark) {
		MipLog ml = new MipLog();
		ml.setRemark(remark);
		if(virtualShowroom != null) {
			ml.setContent(JSON.toJSONString(virtualShowroom));
			ml.setRemark("虚拟展厅名称:"+virtualShowroom.getViName()+",虚拟展厅id:"+virtualShowroom.getId()+",操作:"+remark);
		}
		ml.setModelclass("VirtualShowroom");
		ml.setModelname("虚拟展厅");
		ml.setSequence(0);
		ml.setType("3");
		getUser(request,ml);
		return ml;
	}
	/**
	 * 组装数据(内容-文创)
	 * @return
	 */
	private MipLog assemble(HttpServletRequest request,MipWenchuang mipWenchuang,String remark) {
		MipLog ml = new MipLog();
		ml.setRemark(remark);
		if(mipWenchuang != null) {
			ml.setContent(JSON.toJSONString(mipWenchuang));
			ml.setRemark("文创产品名称:"+mipWenchuang.getProductName()+",文创产品id:"+mipWenchuang.getId()+",操作:"+remark);
		}
		ml.setModelclass("MipWenchuang");
		ml.setModelname("文创产品");
		ml.setSequence(0);
		ml.setType("3");
		getUser(request,ml);
		return ml;
	}
	/**
	 * 补全数据
	 * @param request
	 * @param ml
	 */
	private void getUser(HttpServletRequest request,MipLog ml) {
		UserDto user = getUserDto(request);
		ml.setId(UUID.randomUUID().toString());
		ml.setCreatetime(TimeUtil.GetCurDateTime());
		ml.setIp(getIp(request));
		ml.setUpdateby(user.getUserId());
		ml.setPhone(user.getPhone());
		if("0".equals(user.getPasswordType())) {
			//通用密码访问
			ml.setStatus((byte)1);
		}else {
			ml.setStatus((byte)2);
		}
	}
	private UserDto getUserDto(HttpServletRequest request) {
		UserDto user = (UserDto)request.getSession().getAttribute("user");
		return user;
	}

	@Override
	public List<MipLog> listMipLog(MipLogSearchDto mipLog,Page page) {
		MipLogExample example = new MipLogExample();
		if(mipLog != null) {
			Criteria createCriteria = example.createCriteria();
			if(!StringUtil.isEmpty(mipLog.getPhone())) {
				createCriteria.andPhoneEqualTo(mipLog.getPhone());
			}
			if(!StringUtil.isEmpty(mipLog.getType())) {
				createCriteria.andTypeEqualTo(mipLog.getType());
			}
			if(mipLog.getStatus()!= null) {
				createCriteria.andStatusEqualTo(mipLog.getStatus());
			}
			if(!StringUtil.isEmpty(mipLog.getStateTime())) {
				String sDate2String = TimeUtil.sDate2String(mipLog.getStateTime());
				createCriteria.andCreatetimeGreaterThanOrEqualTo(sDate2String);
			}
			if(!StringUtil.isEmpty(mipLog.getEndTime())) {
				String sDate2String = TimeUtil.sDate2StringEnd(mipLog.getEndTime());
				createCriteria.andCreatetimeLessThanOrEqualTo(sDate2String);
			}
		}
		if(page != null) {
			example.setStartPage(page.getStart());
			example.setSize(page.getSize());
			int countByExample = mipLogMapper.countByExample(example);
			page.setAllRow(countByExample);
		}
		example.setOrderByClause("createTime desc");
		List<MipLog> selectByExample = mipLogMapper.selectByExample(example);
		for(MipLog ml : selectByExample) {
			String updateby = ml.getUpdateby();
			if(!StringUtil.isEmpty(updateby)) {
				MipUser selectByPrimaryKey = mipUserMapper.selectByPrimaryKey(updateby);
				ml.setUpdateby(selectByPrimaryKey.getName());
			}
		}
		return selectByExample;
	}

	@Override
	public void occLog(HttpServletRequest request,MipOpenCulturalrelicInfoWithBLOBs mipOPenCultural,String remark) {
		MipLog assemble = assemble(request,mipOPenCultural,remark);
		save(assemble);
	}

	@Override
	public void ocfLog(HttpServletRequest request, MipOpenFossilInfo mipOpenFossilInfo, String remark) {
		MipLog assemble = assemble(request,mipOpenFossilInfo,remark);
		save(assemble);
	}

	@Override
	public void userLog(HttpServletRequest request, User user,String remark) {
		MipLog assemble = assemble(request,user,remark);
		save(assemble);
	}

	@Override
	public void contentLog(HttpServletRequest request, Spreadtrum spreadtrum, String remark) {
		MipLog assemble = assemble(request,spreadtrum,remark);
		save(assemble);
	}

	@Override
	public void contentLog(HttpServletRequest request, MipJiLinArticle mipJiLinArticle, String remark) {
		MipLog assemble = assemble(request,mipJiLinArticle,remark);
		save(assemble);
	}

	@Override
	public void contentLog(HttpServletRequest request, VirtualShowroom virtualShowroom, String remark) {
		MipLog assemble = assemble(request,virtualShowroom,remark);
		save(assemble);
	}

	@Override
	public void contentLog(HttpServletRequest request, MipWenchuang mipWenchuang, String remark) {
		MipLog assemble = assemble(request,mipWenchuang,remark);
		save(assemble);
	}

	@Override
	public List<MipLog> listMipLogByKey(MipLogSearchDto mipLog, Page page) {
		int countMipLogList = mipLogMapper.countMipLogList(mipLog);
		page.setAllRow(countMipLogList);
		return mipLogMapper.getMipLogList(mipLog, page.getStart(), page.getSize());
	}
}
