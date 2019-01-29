package com.tj720.mip.controller.admin;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IFCCollectionService;
import com.tj720.mip.inter.service.table.IFCFossilService;
import com.tj720.mip.inter.service.table.IMipOpenCulturalrelicInfoService;
import com.tj720.mip.inter.service.table.IMipOpenFossilInfoService;
import com.tj720.mip.inter.service.table.IMipOrganizationService;
import com.tj720.mip.model.MipOpenCulturalrelicInfo;
import com.tj720.mip.model.MipOpenFossilInfo;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;
@Controller
@RequestMapping("/collectionTransfer")
public class collectionTransferController extends BaseController<MipOrganization>{

		@Autowired
		private IMipOrganizationService mipOrganizationService;
		@Autowired
		private IMipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
		@Autowired
		private IMipOpenFossilInfoService mipOpenFossilInfoService;
		@Autowired
		private IFCFossilService baseFossilService;
		@Autowired
		private IFCCollectionService baseFCCollectionService;
		
		
		@RequestMapping("/getOrganization.do")
		@ResponseBody
		@SuppressWarnings("unchecked")
		/*@AuthPassport(authority = "SystemAdmin")*/
		public ModelAndView list(String name,
				@RequestParam(defaultValue = "1", name = "page") int currentPage,
				@RequestParam(defaultValue = "10") int size) {
			ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/organization/collectionTransfer.jsp");
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
			if(!MyString.isEmpty(name)){
				String hql = "from MipOrganization where name like '%"+ name +"%'";
				List<MipOrganization> organization = (List<MipOrganization>)mipOrganizationService.queryByHql(hql, Tools.getMap());
				modelAndView.addObject("waitTransfer", organization);
				modelAndView.addObject("transfer", organization);
			}
			modelAndView.addObject("page", page);
			modelAndView.addObject("name", name);
			return modelAndView;
		}
		
		@RequestMapping("/updateInfo.do")
		@SuppressWarnings("unchecked")
		@ResponseBody
	/*	@AuthPassport(authority = "SystemAdmin")*/
		public String list(String org1Id, String org2Id) {
			JSONObject obj = new JSONObject();
			if(!MyString.isEmpty(org1Id)&&!MyString.isEmpty(org2Id)){
				//判断欲转移藏品的博物馆是否有藏品
				String hql1 = "FROM MipOpenCulturalrelicInfo WHERE collectionUnit = "+org1Id;
				List<MipOpenCulturalrelicInfo> OpenCulturalrelic1Info = (List<MipOpenCulturalrelicInfo>) mipOpenCulturalrelicInfoService.queryByHql(hql1, Tools.getMap());
				String hql2 = "FROM MipOpenFossilInfo WHERE collectionUnit = "+org1Id;
				List<MipOpenFossilInfo> OpenFossil1Info = (List<MipOpenFossilInfo>) mipOpenFossilInfoService.queryByHql(hql2, Tools.getMap());
				//判断欲转移藏品的博物馆是否有藏品，如果没有藏品，就不转移。
				if(MyString.isEmpty(OpenCulturalrelic1Info) && MyString.isEmpty(OpenFossil1Info) ){
					obj.put("error", 1);
					obj.put("message", "该馆没有可转移藏品。");
					return obj.toString();
				}else{
					//判断转移至的博物馆是否有藏品
					String hql3 = "FROM MipOpenCulturalrelicInfo WHERE collectionUnit = "+org2Id;
					List<MipOpenCulturalrelicInfo> OpenCulturalrelic2Info = (List<MipOpenCulturalrelicInfo>) mipOpenCulturalrelicInfoService.queryByHql(hql3, Tools.getMap());
					String hql4 = "FROM MipOpenFossilInfo WHERE collectionUnit = "+org2Id;
					List<MipOpenFossilInfo> OpenFossil2Info = (List<MipOpenFossilInfo>) mipOpenFossilInfoService.queryByHql(hql4, Tools.getMap());
					//判断转移到博物馆是否有藏品，如果有藏品，就不转移。
					if(!MyString.isEmpty(OpenCulturalrelic2Info) || !MyString.isEmpty(OpenFossil2Info) ){
						obj.put("error", 1);
						obj.put("message", "该馆有藏品，不允许转移到此馆。");
						return obj.toString();
					}else{
						//转移修改四个表的值（两个base两个open）
						if(!MyString.isEmpty(OpenCulturalrelic1Info)){
							String hqlofmoci = "update MipOpenCulturalrelicInfo set collectionUnit='"+ org2Id+ "' WHERE collectionUnit= '"+org1Id+"'";
							mipOpenCulturalrelicInfoService.update(hqlofmoci, Tools.getMap());
							//mip_base_culturalrelic_info
							String hqlofbase = "update FCCollection set collectionUnit='"+ org2Id+ "' WHERE collectionUnit= '"+org1Id+"'";
							baseFCCollectionService.update(hqlofbase, Tools.getMap());
							}
						if(!MyString.isEmpty(OpenFossil1Info)){
							/*for(MipOpenFossilInfo ofi:OpenFossil1Info){
								ofi.setCollectionUnit(org2Id);
								mipOpenFossilInfoService.update(ofi);
							}*/
							String hqlofmofi = "update MipOpenFossilInfo set collectionUnit='"+ org2Id+ "' WHERE collectionUnit= '"+org1Id+"'";
							mipOpenFossilInfoService.update(hqlofmofi, Tools.getMap());
							//mip_base_fossil_info
							String hqlofbase = "update FCFossil set collectionUnit='"+ org2Id+ "' WHERE collectionUnit= '"+org1Id+"'";
							baseFossilService.update(hqlofbase, Tools.getMap());
						}
						//修改藏品转到博物馆在MipOrganization表的collectionCount
						MipOrganization org2 = mipOrganizationService.get(org2Id);
						int count = OpenCulturalrelic1Info.size() + OpenFossil1Info.size();
						org2.setCollectionCount(count);
						//修改orgid2的dwid和basename
						MipOrganization org1 = mipOrganizationService.get(org1Id);
						if(!MyString.isEmpty(org1.getDwid())){
							org2.setDwid(org1.getDwid());
						}
						if(!MyString.isEmpty(org1.getBaseName())){
							org2.setBaseName(org1.getBaseName());
						}
						mipOrganizationService.update(org2);
					}
				}
				
			}
			return "SUCCESS";
		}

}
