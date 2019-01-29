package com.tj720.mip.controller.collectionTopic;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tj720.admin.service.MipTopicCollectionService;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;

/**
* @author chengrongkai
* @version 创建时间：2018年8月9日 上午9:59:41
* @ClassName 类名称
* @Description 类描述
*/
@Controller
@RequestMapping("/CollectionTopic")
public class CollectionTopicController {
	@Autowired
	MipTopicCollectionService mipTopicCollectionService;
	@RequestMapping("/goCreateTopicPage.do")
	@AuthPassport
	public ModelAndView goCreateTopic(String topicId){
		ModelAndView modle = new ModelAndView("/WEB-INF/back/content/topic/topic_show.jsp");
		HashMap<String,Object> map = mipTopicCollectionService.getTopicById(topicId);
		modle.addObject("topic", map);
		return modle;
	}
	
	@RequestMapping(value="/goEditTopicPage.do")
	@AuthPassport
	public String goEditTopicPage(Model model, String topicId) {
		HashMap<String,Object> map = mipTopicCollectionService.getTopicById(topicId);
		model.addAttribute("topic", map);
		return "/WEB-INF/back/topic/editDetail.jsp";
	}

	@RequestMapping("/getAllTopic.do")
	public JsonResult getAllTopic(){
		return new 	JsonResult(0, "接口异常!");
	}
	@RequestMapping("/getCreateTopic.do")
	public JsonResult getCreateTopic(String topicId){
		return new 	JsonResult(0, "接口异常!");
	}
	
}
