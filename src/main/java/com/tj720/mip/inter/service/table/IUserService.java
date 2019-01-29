package com.tj720.mip.inter.service.table;

import com.tj720.admin.dto.MipUserDto;
import com.tj720.admin.model.MipUser;
import com.tj720.mip.dto.LoginDto;
import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IUserService extends IBaseService<User>{

	void login(LoginDto model, User user, HttpServletRequest request, HttpServletResponse response);
	int getCountBySql(String sql);
	String getBySql(String sql);
	List<User> queryListBySql(String sql);
	User findOne(String hql);
	String queryMaxByHql(String phoneStart);

    MipUser queryUserByPhone(String phone);
	void down(User user, HttpServletResponse response) throws IOException;
	// 根据实体查询结果数量
	Integer countByMipUserDto(MipUserDto mipUserDto);
	// 分页查询账户
	List<MipUserDto> getListByMap(Map<String, Object> map);
	
	void saveEntity(MipUser user);
	MipUser getById(String id);
	Integer getUserByOrg(String orgId);
	void updateByMipUser(MipUser user);
	void deletById(String id);
	void updataStatus(Map<String, Object> map);
	Integer checkPhone(String phone);
}
