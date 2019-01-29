package com.tj720.admin.service.collection.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.controller.collection.OrgUtil;
import com.tj720.admin.dao.collection.CollectDictMapper;
import com.tj720.admin.dao.map.MipOrganizationMapper;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.collection.CollectDict;
import com.tj720.admin.model.collection.CollectionOrg;
import com.tj720.admin.service.collection.CollectDictSevice;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.springbeans.Config;

@Service
public class CollectDictSeviceImpl implements CollectDictSevice {

	@Autowired
	private CollectDictMapper collectDictMapper;
	@Autowired
	private MipOrganizationMapper mipOrganizationMapper;
	@Autowired
	private Config config;

	private static Pattern NUMBER_PATTERN = Pattern.compile("^-?[0-9]+");

	@Override
	public List<CollectDict> getDictListByKeys(List<String> keys) {
		if (keys != null) {
			if (keys.size() > 0) {
				return collectDictMapper.getDictListByKeys(keys);
			}
		}
		return null;
	}

	@Override
	public List<CollectDict> getDictListByKey(String key, String dictCode,
			String dictName) {

		return collectDictMapper.getDictListByKey(key, dictCode, dictName);
	}

	@Override
	public List<CollectDict> getDictListByKey(String key) {
		List<CollectDict> dictListByKey = getDictListByKey(key, null, null);
		return dictListByKey;
	}

	@Override
	public Map<String, Object> getDictListByArr(String[] arr) {
		List<String> keys = Arrays.asList(arr);
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < keys.size(); i++) {
			List<CollectDict> list = getDictListByKey(keys.get(i));
			map.put(keys.get(i), list);
		}
		return map;
	}

	public static boolean isNum(String str) {
		if (NUMBER_PATTERN.matcher(str).matches()) {
			// 数字
			return true;
		} else {
			// 非数字
			return false;
		}
	}

	@Override
	public JsonResult getOrg(String orgId) {
		JsonResult jsonResult = null;
		try {
			if (isNum(orgId)) {
				// 移动到不同的项目修改该查询即可，无需修改页面
				MipOrganization mipOrganization = mipOrganizationMapper
						.selectByPrimaryKey(Integer.parseInt(orgId));
				if (mipOrganization != null) {
					// 文物局用户或者超级管理员
					List<CollectionOrg> orgList = new ArrayList<CollectionOrg>();
					if ("1".equals(mipOrganization.getOrgTypeId())
							|| "0".equals(orgId)) {
						List<MipOrganization> orgs = mipOrganizationMapper.getOrgList();
						for (MipOrganization org : orgs) {
							CollectionOrg collectionOrg = new CollectionOrg();
							collectionOrg.setOrgId(org.getId().toString());
							collectionOrg.setOrgName(org.getName());
							orgList.add(collectionOrg);
						}
						jsonResult = new JsonResult(1, orgList);
						// 区文委用户
					} else if ("2".equals(mipOrganization.getOrgTypeId())) {
						List<MipOrganization> orgs = mipOrganizationMapper.getOrgList();
						List<MipOrganization> sonOrg = OrgUtil.getSonOrg(orgs,Integer.parseInt(orgId), true);
						for (MipOrganization org : sonOrg) {
							CollectionOrg collectionOrg = new CollectionOrg();
							collectionOrg.setOrgId(org.getId().toString());
							collectionOrg.setOrgName(org.getName());
							orgList.add(collectionOrg);
						}
						jsonResult = new JsonResult(1, orgList);

						// 博物馆及其他用户
					} else {
						CollectionOrg collectionOrg = new CollectionOrg();
						collectionOrg.setOrgId(mipOrganization.getId()
								.toString());
						collectionOrg.setOrgName(mipOrganization.getName());
						orgList.add(collectionOrg);
						jsonResult = new JsonResult(1, orgList);
					}
				}
			} else {
				jsonResult = new JsonResult(0, "数据异常！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			jsonResult = new JsonResult(0, "数据异常！");
		}

		return jsonResult;
	}

	@Override
	public Object getOrgByOrgId(String orgId) {

		return mipOrganizationMapper.selectByPrimaryKey(Integer.parseInt(orgId));
	}

	@Override
	public List<CollectDict> getDictListAndCount(String item,
			Map<String, String> map) {

		return collectDictMapper.getDictListAndCount(item, map);
	}

	@Override
	public Object getOrgAreaByOrgId(String orgId) {

		return collectDictMapper.getOrgAreaByOrgId(orgId);
	}
}