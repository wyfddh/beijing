package com.tj720.mip.controller.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.MyException;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.framework.base.BaseController;
import com.tj720.mip.inter.service.table.IMipAudioService;
import com.tj720.mip.model.MipAudio;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("audio")
public class MipAudioController extends BaseController<MipAudio>{

	@Autowired
	private IMipAudioService mipAudioService;
	@Autowired
	private Config config;
	
	/**
	 * 查询首页音频列表
	 * @return
	 * @throws MyException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("getMipAudioList.do")
	public ModelAndView getMipAudioList(@RequestParam(defaultValue = "6") int size,
			@RequestParam(defaultValue = "1", name = "page") int currentPage) throws MyException{
		Boolean flag = false;
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/content/indexAudio.jsp");
		String hql = "FROM MipAudio WHERE status > 0 and type = 1 order by isOpen desc, sequence desc, createTime desc";
		List<MipAudio> mipAudioList = (List<MipAudio>) mipAudioService.queryByHql(hql, Tools.getMap(), page);
		if (!MyString.isEmpty(mipAudioList)) {
			for (MipAudio mipAudio : mipAudioList) {
				String createTime = mipAudio.getCreateTime();
				int index = createTime.indexOf(".");
				createTime = createTime.substring(0, index);
				createTime = DateUtil.StringToString(createTime, DateStyle.YYYY_MM_DD_HH_MM);
				mipAudio.setCreateTime(createTime);
				String url = mipAudio.getUrl();
				if (!MyString.isEmpty(url)) {
					mipAudio.setUrl(config.getRootUrl() + url);
				}
			}
		}
		String hqlOpen = "FROM MipAudio WHERE status > 0 and type = 1 and isOpen = 1";
		List<MipAudio> openAudios = (List<MipAudio>) mipAudioService.queryByHql(hqlOpen, Tools.getMap());
		if (!MyString.isEmpty(openAudios)) {
			flag = true;
		}
		modelAndView.addObject("mipAudioList", mipAudioList);
		modelAndView.addObject("flag", flag);
		modelAndView.addObject("page", page);
		return modelAndView;
	}
	
	/**
	 * 保存音频
	 * @param mipAudio
	 * @return
	 * @throws MyException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("save.do")
	@AuthPassport(authority="contentAdmin")
	@ResponseBody
	public JsonResult save(@ModelAttribute MipAudio mipAudio) throws MyException{
		try {
			mipAudioService.save(mipAudio);
			return new JsonResult(1, "保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "保存失败，系统异常，请联系管理员！");
		}
	}
	
	/**
	 * 删除音频
	 * @param id
	 * @return
	 * @throws MyException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("del.do")
	@AuthPassport(authority="contentAdmin")
	@ResponseBody
	public JsonResult del(String id) throws MyException{
		try {
			MipAudio mipAudio = mipAudioService.get(id);
			mipAudio.setStatus((byte)-127);
			mipAudioService.update(mipAudio);
			return new JsonResult(1, "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "删除失败，系统异常，请联系管理员！");
		}
	}
	
	/**
	 * 发布音频
	 * @param id
	 * @return
	 * @throws MyException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("publish.do")
	@AuthPassport(authority="contentAdmin")
	@ResponseBody
	public JsonResult publish(String id) throws MyException{
		try {
			MipAudio mipAudio = mipAudioService.get(id);
			mipAudio.setIsOpen((byte)1);
			mipAudioService.update(mipAudio);
			return new JsonResult(1, "发布成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "发布失败，系统异常，请联系管理员！");
		}
	}
	
	/**
	 * 取消发布音频
	 * @param id
	 * @return
	 * @throws MyException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("nonPublish.do")
	@AuthPassport(authority="contentAdmin")
	@ResponseBody
	public JsonResult nonPublish(String id) throws MyException{
		try {
			MipAudio mipAudio = mipAudioService.get(id);
			mipAudio.setIsOpen((byte)0);
			mipAudioService.update(mipAudio);
			return new JsonResult(1, "取消发布成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "取消发布失败，系统异常，请联系管理员！");
		}
	}
	
	/**
	 * 查询背景音乐
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("getBGAudio.do")
	@ResponseBody
	public JsonResult getBGAudio() throws MyException{
		try {
			String hql = "from MipAudio where status > 0 and isOpen = 1";
			List<MipAudio> mipAudios = (List<MipAudio>) mipAudioService.queryByHql(hql, Tools.getMap());
			if (MyString.isEmpty(mipAudios)) {
				return new JsonResult(0, "您还未上传或未发布");
			}
			if (mipAudios.size() > 1) {
				return new JsonResult(0, "您发布了多个，请核实");
			}
			MipAudio mipAudio = mipAudios.get(0);
			String url = mipAudio.getUrl();
			if (!MyString.isEmpty(url)) {
				url = config.getRootUrl() + url;
			}
			return new JsonResult(1, url);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0, "系统异常，请联系管理员！");
		}
	}
}
