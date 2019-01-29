package com.tj720.admin.controller.admin;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.admin.model.ExtVideo;
import com.tj720.admin.model.MipOrganization;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.service.IMipOrganizationService;
import com.tj720.admin.service.IMipUserService;
import com.tj720.admin.service.VideoService;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/videoSearch")
public class VideoController {
	@Autowired
	VideoService videoService;
	
	@Autowired
	private IMipUserService mipUserService;
	
	@Autowired
	private IMipOrganizationService mipOrganizationService;
	
	@RequestMapping("getVideoList")
	@AuthPassport(authority = "SystemAdmin")
	public String getVideoLiat(ModelMap modelMap,@RequestParam(defaultValue="10") int size, @RequestParam(defaultValue="1") int currentPage){
		try {
			byte level =1;
			String orgId="";
			String userId = Tools.getUser().getId();
			MipUser mipUser = mipUserService.getUser(userId);
			MipOrganization mipOrganization = new MipOrganization();
			List<MipOrganization> mipOrganizationList = new ArrayList<MipOrganization>();
			if (!MyString.isEmpty(mipUser.getOrgId())) {
				mipOrganization = mipOrganizationService.getOrganization(Integer.parseInt(mipUser.getOrgId()));
				if(mipOrganization!=null){
					level = mipOrganization.getLevel();
					orgId = mipOrganization.getId().toString();
				}
//				if(level==1){
//					mipOrganizationList = mipOrganizationService.getListByLevel((byte)3);
//					StringBuffer sBuffer = new StringBuffer();
//					if (!MyString.isEmpty(mipOrganizationList)) {
//						for (MipOrganization mipOrganization2 : mipOrganizationList) {
//							sBuffer.append(mipOrganization2.getId()).append(",");
//						}
//					}
//					orgId = sBuffer.toString();
//					orgId = orgId.substring(0, orgId.length()-1);
//				}else 
					if(level==2){
					mipOrganizationList = mipOrganizationService.getListByPId(mipOrganization.getId());
//					mipOrganizationList = mipOrganizationService.getListByLevel((byte)3);
					StringBuffer sBuffer = new StringBuffer();
					if (!MyString.isEmpty(mipOrganizationList)) {
						for (MipOrganization mipOrganization2 : mipOrganizationList) {
							sBuffer.append(mipOrganization2.getId()).append(",");
						}
						sBuffer.append(mipOrganization.getId());
					}
					orgId = sBuffer.toString();
					orgId = orgId.substring(0, orgId.length()-1);
				}
			}
			Page page = new Page();
			page.setCurrentPage(currentPage);
			page.setSize(size);
			List<ExtVideo> videoList = videoService.getVideoList(page,orgId,level);
			modelMap.put("videoList", videoList);
			modelMap.put("page", page);
			return "/WEB-INF/back/content/indexVideo.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/WEB-INF/back/error.jsp";
		}
	}
	@RequestMapping("saveVideo")
	@ResponseBody
	@AuthPassport(authority="SystemAdmin")
	public String saveVideo(ExtVideo video){
		int result = 0;
		try {
			String userId = Tools.getUser().getId();
			MipUser mipUser = mipUserService.getUser(userId);
			if(!MyString.isEmpty(video)){
				if(!MyString.isEmpty(video.getUrl())&&!MyString.isEmpty(video.getImgUrl())){
					URL url = new URL(video.getUrl());
					video.setUrl(url.getPath().substring(1));
					URL ImgUrl = new URL(video.getImgUrl());
					video.setImgUrl(ImgUrl.getPath().substring(1));
				}
				if (!MyString.isEmpty(mipUser.getOrgId())) {
					result = videoService.saveVideo(video,mipUser.getOrgId());
				}
			}
			if(result==1){
				return "success";
			}else{
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/WEB-INF/back/error.jsp";
		}
	}
	
	@RequestMapping("delectVideo")
	@ResponseBody
	@AuthPassport(authority="SystemAdmin")
	public String delectVideo(String id){
		int result = 0;
		try {
			result = videoService.delectVideo(id);
			if(result==1){
				return "success";
			}else{
				return "error";
			}
		} catch (Exception e) {
			return "/WEB-INF/back/error.jsp";
		}
	}
	
	@RequestMapping("getVideo")
	@AuthPassport(authority="SystemAdmin")
	public String getVideo(ModelMap modelMap,String id){
		try {
			ExtVideo video = videoService.getVideo(id);
			modelMap.put("video", video);
			return "/WEB-INF/back/content/indexVideo.jsp";
		} catch (Exception e) {
			return "/WEB-INF/back/error.jsp";
		}
		
	}
	

}
