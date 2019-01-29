package com.tj720.mip.controller.organization;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.auth.ControllerAop;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.AreaService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.inter.service.table.IMuseumSubject;
import com.tj720.mip.inter.service.table.IRoleService;
import com.tj720.mip.inter.service.table.IUserRoleService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.inter.service.table.MuseumInfoService;
import com.tj720.mip.model.MipArea;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.MuseumSubject;
import com.tj720.mip.model.Role;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.OrgUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/organization/museum")
public class OrgmuseumController extends BaseController<MipOrganization> {
	@Autowired
	private MipOrganizationService mipOrganizationService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private Config config;
	@Autowired
	private IUserService userService;
	@Autowired
	private MuseumInfoService museumInfoService;
	@Autowired
	private IUserRoleService userRoleService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IMuseumSubject museumSubject;// 博物馆信息
	@Autowired
	private IMuseumBaseInfoService museumBaseInfoService;

	// 查询博物馆列表页
	@RequestMapping("/info.do")
	@ControllerAop(url = "organization/museum/info.do")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView getMuseumInfo() {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/organization/orgmuseumlist.jsp");

		return modelAndView;
	}

	@RequestMapping("/getList.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JSONObject getListData(String key, String orgTypeId, String platformId,
			@RequestParam(defaultValue = "15") int size, @RequestParam(defaultValue = "1") int currentPage) {
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		List<MipOrganization> orgList = mipOrganizationService.getPageList(key, orgTypeId, platformId, page);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", page.getAllRow());
		jsonObject.put("data", orgList);
		return jsonObject;
	}

	@RequestMapping("/detail.do")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView detail(@ModelAttribute MipOrganization organization, @RequestParam String relicOrganizationId) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/organization/orgmuseumdetail.jsp");
		organization = mipOrganizationService.get(relicOrganizationId);
		// 查询省份
		List<MipArea> proList = (List<MipArea>) areaService.queryByHql("from MipArea where pid = '0'", Tools.getMap());
		modelAndView.addObject("proList", proList);
		// 查询市
		if (organization.getProvinceId() != null && !"".equals(organization.getProvinceId())) {
			List<MipArea> cityList = (List<MipArea>) areaService.queryByHql(
					"from MipArea where pid = " + organization.getProvinceId() + "and level = 2", Tools.getMap());
			modelAndView.addObject("cityList", cityList);
		}

		// 查询区
		if (organization.getCityId() != null && !"".equals(organization.getCityId())) {
			List<MipArea> townList = (List<MipArea>) areaService.queryByHql(
					"from MipArea where pid = " + organization.getCityId() + "and level = 3", Tools.getMap());
			modelAndView.addObject("townList", townList);
		}
		// 上級文物館
		String hql2 = "from MipOrganization where orgTypeId = '1' and level=2 and platformId = "
				+ config.getPlatformId();
		// System.out.println(hql2);
		List<MipOrganization> relicList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql2,
				Tools.getMap());
		modelAndView.addObject("relicOrganization", organization);
		modelAndView.addObject("relicList", relicList);

		return modelAndView;
	}

	// 文物局编辑
	@SuppressWarnings("unchecked")
	@RequestMapping("/edit.do")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView edit(@ModelAttribute MipOrganization organization, @RequestParam String relicOrganizationId) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/organization/orgmuseumedit.jsp");
		organization = mipOrganizationService.get(relicOrganizationId);
		modelAndView.addObject("organization", organization);

		List<com.tj720.admin.model.MipOrganization> orgList = mipOrganizationService.getList();
		List<com.tj720.admin.model.MipOrganization> sonAndSelfList = OrgUtil.getSonOrg(orgList,
				Integer.parseInt(relicOrganizationId), true);
		orgList.removeAll(sonAndSelfList);
		modelAndView.addObject("orgList", orgList);
		String hql1 = "from Role where status = 1";
		List<Role> roleList = (List<Role>) roleService.queryByHql(hql1, Tools.getMap());
		modelAndView.addObject("roleList", roleList);
		return modelAndView;
	}

	// 增加
	@RequestMapping("add.do")
	@SuppressWarnings("unchecked")
	@AuthPassport(authority = "SystemAdmin")
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/organization/orgmuseumadd.jsp");
		// 上級
		String hql = "from MipOrganization where status <> -127 ";
		List<MipOrganization> orgList = (List<MipOrganization>) mipOrganizationService.queryByHql(hql, Tools.getMap());
		modelAndView.addObject("orgList", orgList);
		String hql1 = "from Role where status = 1";
		List<Role> roleList = (List<Role>) roleService.queryByHql(hql1, Tools.getMap());
		modelAndView.addObject("roleList", roleList);
		return modelAndView;
	}

	// 保存
	@RequestMapping("/addOrUpdate.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult addOrUpdate(@ModelAttribute MipOrganization organization) {
		if (!MyString.isEmpty(organization.getId())) {
			String parentId = organization.getParentId();
			// 保存修改数据
			if (!MyString.isEmpty(organization.getParentId())) {
				MipOrganization pMipOrganization = mipOrganizationService.get(parentId);
				String path = pMipOrganization.getPath();
				organization.setPath(path + "/" + organization.getId());
			}
			String orgTypeId = organization.getOrgTypeId();
			if (!MyString.isEmpty(organization.getOrgTypeId())) {
				if ("1".equals(orgTypeId)) {
					organization.setBaseName("文物局");
				} else if ("2".equals(orgTypeId)) {
					organization.setBaseName("区文委");
				} else if ("3".equals(orgTypeId)) {
					organization.setBaseName("博物馆");
				} else if ("4".equals(orgTypeId)) {
					organization.setBaseName("文物修复资质单位");
				} else if ("5".equals(orgTypeId)) {
					organization.setBaseName("其他文物收藏单位");
				}
			}
			try {
				mipOrganizationService.update(organization);
				MuseumDataProgressDto progressInfo = new MuseumDataProgressDto();
				String museumId = organization.getId();
				String museumName = organization.getName();
				String userId = Tools.getUser().getId();
				progressInfo.setMuseumId(museumId);
				progressInfo.setMuseumName(museumName);
				progressInfo.setOrgType(orgTypeId);
				progressInfo.setUpdateId(userId);
				progressInfo.setUpdateTime(new Date());
				museumBaseInfoService.updateProgress(progressInfo);
				return new JsonResult(1, "保存成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(0, "保存失败");
			}

		}
		return new JsonResult(0, "保存失败");
	}

	// 保存新增数据
	@RequestMapping("/saveInfo.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult saveInfo(@ModelAttribute MipOrganization mipOrganization, String parentId, String name,
			String orgTypeId) {
		mipOrganization.setName(name);
		mipOrganization.setParentId(parentId);
		mipOrganization.setOrgTypeId(orgTypeId);
		if ("1".equals(orgTypeId)) {
			mipOrganization.setBaseName("文物局");
		} else if ("2".equals(orgTypeId)) {
			mipOrganization.setBaseName("区文委");
		} else if ("3".equals(orgTypeId)) {
			mipOrganization.setBaseName("博物馆");
		} else if ("4".equals(orgTypeId)) {
			mipOrganization.setBaseName("文物修复资质单位");
		} else if ("5".equals(orgTypeId)) {
			mipOrganization.setBaseName("其他文物收藏单位");
		}

		try {
			mipOrganization = mipOrganizationService.save(mipOrganization);
			if (!MyString.isEmpty(mipOrganization.getParentId())) {
				String parentId1 = mipOrganization.getParentId();
				MipOrganization pMipOrganization = mipOrganizationService.get(parentId1);
				String path = pMipOrganization.getPath();
				mipOrganization.setPath(path + "/" + mipOrganization.getId());
				mipOrganizationService.update(mipOrganization);
			}
			MuseumDataProgressDto progressInfo = new MuseumDataProgressDto();
			String museumId = mipOrganization.getId();
			String museumName = mipOrganization.getName();
			String userId = Tools.getUser().getId();
			if (StringUtils.isNotEmpty(museumId)) {
				progressInfo.setMuseumId(museumId);
				progressInfo.setMuseumName(museumName);
				progressInfo.setOrgType(orgTypeId);
				progressInfo.setCreatorId(userId);
				progressInfo.setUpdateId(userId);
				progressInfo.setUpdateTime(new Date());
				progressInfo.setCreateTime(new Date());
				progressInfo.setId(IdUtils.nextId(progressInfo));
				progressInfo.setFlag("1");// 文物局数据
				museumBaseInfoService.insertProgress(progressInfo);
				progressInfo.setCreatorId(userId);
				progressInfo.setUpdateId(userId);
				progressInfo.setUpdateTime(new Date());
				progressInfo.setCreateTime(new Date());
				progressInfo.setId(IdUtils.nextId(progressInfo));
				progressInfo.setFlag("2");// 博物馆数据
				museumBaseInfoService.insertProgress(progressInfo);
			} else {
				return new JsonResult(0, "保存失败");
			}
			return new JsonResult(1, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "保存失败");
		}

	}

	public void saveMuseumSubject(String id) {
		String[] a = { "场馆介绍", "历史沿革", "展览概况", "藏品总说", "参观指南", "如何买票", "附近餐饮", "服务信息" };
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String data = sdf.format(new Date());
		for (int k = 0; k < a.length; k++) {
			MuseumSubject ms = new MuseumSubject();
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			ms.setId(uuid);
			ms.setOrgId(id);
			ms.setName(a[k]);
			ms.setpId("");
			ms.setSubjectType("1");
			ms.setModelType("1");
			ms.setCreateTime(data);
			if ("场馆介绍".equals(a[k])) {
				ms.setStatus((byte) 1);
				ms.setSequence(5);
			} else if ("历史沿革".equals(a[k])) {
				ms.setStatus((byte) 1);
				ms.setSequence(4);
			} else if ("展览概况".equals(a[k])) {
				ms.setStatus((byte) 1);
				ms.setSequence(3);
			} else if ("藏品总说".equals(a[k])) {
				ms.setStatus((byte) 1);
				ms.setSequence(2);
			} else if ("参观指南".equals(a[k])) {
				ms.setStatus((byte) 1);
				ms.setSequence(1);
			} else {
				ms.setStatus((byte) 0);
				ms.setSequence(0);
			}
			ms.setDescription("");
			ms.setUpdatedTime(data);
			museumSubject.save(ms);
		}
	}

	// 删除
	@RequestMapping("/delete.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public String delete(String[] ids) throws MyException {

		try {
			for (String id : ids) {
				int count = userService.getUserByOrg(id);
				if (count == 0) {
					// 获取对象
					MipOrganization model = mipOrganizationService.get(id);
					// 设置状态（-127）
					model.setStatus((byte) -127);
					mipOrganizationService.update(model);
					// 删除博物馆资料
					museumBaseInfoService.deleteProgress(id);
				} else {
					return "2";
				}
			}
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}

	}

	// 校验博物馆名称
	@RequestMapping("/checkOrgName.do")
	@ResponseBody
	public String checkOrgName(String orgName) throws MyException {
		try {
			if (orgName != null) {
				orgName = orgName.replace(" ", "");
			}
			if (MyString.isEmpty(orgName)) {
				return "-1";// 名称为空
			}
			List<MipOrganization> list = (List<MipOrganization>) mipOrganizationService
					.queryByHql("from MipOrganization where name = '" + orgName + "'", Tools.getMap());
			if (list != null && list.size() > 0) {
				return "-2";// 名称已存在
			}
			return "1";// 名称可以添加
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}

	}
	
	/**
	 * 加载博物馆列表
	 * @param key
	 * @param orgTypeId
	 * @param town
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/getMuseunListData.do")
	@ResponseBody
	@AuthPassport(authority = "SystemAdmin")
	public JsonResult getMuseunListData(String key, String orgTypeId, String town) throws MyException{
		List<com.tj720.admin.model.MipOrganization> allByProvince = mipOrganizationService.getAllByProvince(null, null, town, orgTypeId, key);
		return new JsonResult(1, allByProvince);
	}

}
