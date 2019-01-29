package com.tj720.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tj720.admin.model.MipCollect;

@Service
public interface MipCollectService {
	//根据用户ID查询该用户所有收藏
	List<MipCollect> getCollectsByUid(Map<String, Object> map);
	//根据用户id收藏id删除该收藏
	void delCollect(Map<String, String> map);
	void save(MipCollect mipCollect);
	MipCollect getCollect(Map<String, String> map);
	List<MipCollect> getColByUserID(Map<String, Object> map);
	List<MipCollect> getOrgByUserID(Map<String, Object> map);
	Integer getCountColByUid(Map<String, Object> map);
	void update(MipCollect mipCollect);

}
