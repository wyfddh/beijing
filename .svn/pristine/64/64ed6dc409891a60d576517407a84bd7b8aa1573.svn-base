package com.tj720.mip.controller.tour;

import com.tj720.admin.service.MipTopicCollectionService;
import com.tj720.mip.framework.auth.AuthPassport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping("/CollectionTour")
public class CollectionTourController {

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
}
