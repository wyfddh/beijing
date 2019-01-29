package com.tj720.mip.service.table;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj720.admin.common.constant.KeyConstants;
import com.tj720.admin.dao.map.MipUserMapper;
import com.tj720.admin.dto.MipUserDto;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.model.MipUserExample;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.jedis.JedisService;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj720.mip.dto.LoginDto;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.framework.base.BaseService;
import com.tj720.mip.framework.base.IBaseDao;
import com.tj720.mip.inter.dao.IUserDao;
import com.tj720.mip.inter.service.table.IAuthService;
import com.tj720.mip.inter.service.table.IProjectService;
import com.tj720.mip.inter.service.table.IProjectUserService;
import com.tj720.mip.inter.service.table.IRoleAuthService;
import com.tj720.mip.inter.service.table.IRoleService;
import com.tj720.mip.inter.service.table.IUserRoleService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.inter.service.tool.ICacheService;
import com.tj720.mip.model.User;
import com.tj720.mip.model.UserRole;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Aes;
import com.tj720.mip.utils.Const;
import com.tj720.mip.utils.MyCookie;
import com.tj720.mip.utils.MyString;

@Service
public class UserService extends BaseService<User> implements IUserService {
	@Autowired
	private ICacheService cacheService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private Config config;
	@Autowired
	private IProjectService projectService;
	@Autowired
	private IProjectUserService projectUserService;
	@Autowired
	private IUserRoleService userRoleService;
	@Autowired
	private IRoleAuthService roleAuthService;
	@Autowired
	private IAuthService authService;
	@Autowired
	private MipUserMapper mipUserMapper;
	@Autowired
	private IMipOrganizationService mipOrganizationService;

	@Resource(name = "userDao")
	IUserDao userDao;

	@Resource(name = "userDao")
	public void setDao(IBaseDao<User> dao) {
		super.setDao(dao);
	}

	@Override
	@Transactional
	public User get(String id) {
		User model = userDao.get(id);
		if (model == null)
			return new User();
		return model;
	}

	@Override
	public void login(LoginDto model, User user, HttpServletRequest request, HttpServletResponse response) {
		String token = Aes.encrypt(user.getId());
		String userIptoken = Aes.encrypt(user.getId()+(new Date()).getTime());
		MyCookie.addCookie(Const.COOKIE_TOKEN, token, response);
		//userid+ip
		String key = KeyConstants.USER_IP_TOKEN_CODE_KEY + user.getId()+"##"+this.getIpAddress(request);
		JedisService.set(key, userIptoken, config.getLoginInforTime());
		model.setToken(userIptoken);
		// 将用户信息存入缓存
		// cacheService.setObj(Const.CACHE_USER + user.getId(), new
		// LoginInfoDto(user, roleService, projectService, projectUserService),
		// config.getLoginInforTime());
		cacheService.setObj(Const.CACHE_USER + user.getId(), new LoginInfoDto(user, userRoleService, roleService,
				roleAuthService, authService, projectService, projectUserService), config.getLoginInforTime());
		MyCookie.addCookie(Const.COOKIE_USERID, user.getId(), response);
		model.setId(user.getId());
		user.setToken(userIptoken);
		/*
		 * if (!MyString.isEmpty(model.getUserName())) {
		 * MyCookie.addCookie(Const.COOKIE_USERNAME, model.getUserName(),
		 * response); }
		 */
		if (!MyString.isEmpty(model.getPhone())) {
			MyCookie.addCookie(Const.COOKIE_PHONE, model.getPhone(), response);
		}
		// MyCookie.addCookie(Const.COOKIE_REMBER_PWD, model.getRemberPwd() ,
		// response);
		// MyCookie.addCookie(Const.CACHE_PHONE, model.getPhone() , response);

		/*
		 * if (model.getRemberPwd().equals("YES")) {
		 * MyCookie.addCookie(Const.COOKIE_PASSWORD, model.getPassword(), true,
		 * response); } else { MyCookie.deleteCookie(Const.COOKIE_PASSWORD,
		 * request, response); }
		 */
		MyCookie.addCookie("sessionAdminName", user.getNickName()==null?"":user.getNickName(), response);

		MyCookie.deleteCookie(Const.COOKIE_PASSWORD, request, response);
		model.setSessionAdminName(user.getNickName());
		model.setHeadimgurl(user.getAvatarUrl());
	}

	@Override
	public int getCountBySql(String sql) {
		return userDao.getCountBySql(sql);
	}

	@Override
	@Transactional
	public String getBySql(String sql) {
		return userDao.getBySql(sql);
	}

	@Override
	@Transactional
	public List<User> queryListBySql(String sql) {
		return userDao.queryListBySql(sql);
	}

	@Override
	@Transactional
	public User findOne(String hql) {
		return userDao.findOne(hql);
	}

	@Override
	@Transactional
	public String queryMaxByHql(String phoneStart) {
		return userDao.findMaxByHql(phoneStart);
	}

	@Override
	public MipUser queryUserByPhone(String phone) {
		MipUserExample example = new MipUserExample();
		MipUserExample.Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(phone);
		List<MipUser> mipUsers = mipUserMapper.selectByExample(example);
		if (Objects.nonNull(mipUsers) && mipUsers.size() > 0) {
			return mipUsers.get(0);
		}
		return null;
	}

	@Override
	public void down(User user,HttpServletResponse response) throws IOException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lcc = Long.valueOf(user.getLastLoginTime());
		Date date = new Date(lcc*1000L);
		String format = simpleDateFormat.format(date);
		//创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		String orgId = user.getOrgId();
		HSSFSheet sheet ;
		String museumName = "";
		if (!StringUtils.isBlank(orgId)) {
			MipOrganization organization = mipOrganizationService.getOrganization(Integer.parseInt(orgId));
			museumName = organization.getName();
			sheet=wb.createSheet(museumName + "管理员信息表");
		} else {
			sheet=wb.createSheet("用户信息表");
		}
		//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1=sheet.createRow(0);
		//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell=row1.createCell(0);
		//设置单元格内容
		cell.setCellValue("用户信息表");
		//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
		//在sheet里创建第二行
		HSSFRow row2=sheet.createRow(1);    
		//创建单元格并设置单元格内容
		row2.createCell(0).setCellValue("单位");
		row2.createCell(1).setCellValue("手机号/账号");    
		row2.createCell(2).setCellValue("姓名"); 
		row2.createCell(3).setCellValue("创建时间");    
		row2.createCell(4).setCellValue("最后登录时间");    
		//在sheet里创建第三行
		HSSFRow row3=sheet.createRow(2);
		row3.createCell(0).setCellValue(museumName);
		row3.createCell(1).setCellValue(user.getPhone());
		row3.createCell(2).setCellValue(user.getUserName());
		row3.createCell(3).setCellValue(user.getCreateTime());
		row3.createCell(4).setCellValue(format);
		//输出Excel文件
		OutputStream output=response.getOutputStream();
		String fileName = museumName + "用户信息表" + ".xls";
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename=" +  URLEncoder.encode(fileName, "UTF-8"));
		response.setContentType("application/msexcel");        
		wb.write(output);
		output.close();
		wb.close();
	}

	@Override
	public Integer countByMipUserDto(MipUserDto mipUserDto) {

		return mipUserMapper.countByMipUserDto(mipUserDto);
	}

	@Override
	public List<MipUserDto> getListByMap(Map<String, Object> map) {
		List<MipUserDto> listByMap = mipUserMapper.getListByMap(map);
		List<UserRole> roleList = new ArrayList<UserRole>();
		for (MipUserDto mipUserDto : listByMap) {
			UserRole userRole = new UserRole();
			String id = mipUserDto.getId();
			userRole.setUserId(id);
			roleList.add(userRole);
		}
		if (roleList.size() > 0) {
//			List<MipUserDto> nameList = mipUserMapper.getRoleName(roleList);
			/*Map<String,String> roleMap = new HashMap<String, String>();
			for (MipUserDto mipUserDto : nameList) {
				String id = mipUserDto.getId();
				String roleName = mipUserDto.getRoleName();
				if (roleMap.containsKey(id)) {
					String val = roleMap.get(id);
					roleMap.put(id, val + "," + roleName);
				} else {
					roleMap.put(id, roleName);
				}
			}*/
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (MipUserDto mipUser : listByMap) {
				String id = mipUser.getId();
				Date createtime = mipUser.getCreatetime();
				String format = df.format(createtime);
				mipUser.setcTime(format);
				if (mipUser.getStatus() == 1) {
					mipUser.setStatusName("正常"); 
					mipUser.setChangeStatus("停用");
				} else {
					mipUser.setStatusName("停用");
					mipUser.setChangeStatus("启用");
				}
				/*if (roleMap.containsKey(id)) {
					mipUser.setRoleName(roleMap.get(id));
				}*/
			}
			return listByMap;
		} else {
			return new ArrayList<MipUserDto>();
		}

	}
	
	/**
	 * 获取ip
	 * @param request
	 * @return
	 */
	public String getIpAddress(HttpServletRequest request) {
	    String ip = request.getHeader("x-forwarded-for");
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getRemoteAddr();
	    }
	    if (ip.contains(",")) {
	        return ip.split(",")[0];
	    } else {
	        return ip;
	    }
	}

	@Override
	public void saveEntity(MipUser user) {
		mipUserMapper.insert(user);

	}

	@Override
	public MipUser getById(String id) {

		return mipUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer getUserByOrg(String orgId) {

		return mipUserMapper.getUserByOrg(orgId);
	}

	@Override
	public void updateByMipUser(MipUser user) {

		mipUserMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void deletById(String id) {
		mipUserMapper.deletById(id);
	}

	@Override
	public void updataStatus(Map<String, Object> map) {
		mipUserMapper.updataStatus(map);

	}

	@Override
	public Integer checkPhone(String phone) {

		return mipUserMapper.checkPhone(phone);
	}
}
