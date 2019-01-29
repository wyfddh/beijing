package com.tj720.admin.controller.admin;

import com.tj720.admin.service.InteractionService;
import com.tj720.admin.service.impl.InteractionServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
@RequestMapping("/interaction")
public class InteractionController{
    @Autowired
    private InteractionService interactionService;

    @RequestMapping(value = "/createUser.do", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String CreateUser(HttpServletResponse response)  {
        String json = null;
        try {
            json = interactionService.createUser("0109f26b958f45f3a1d7b75649d30cd5");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println(json);
        return json;
    }

    @RequestMapping(value = "/createCulturalRelic.do", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String createCulturalRelic(HttpServletResponse response)  {
        String json = null;
        try {
            json = interactionService.createCulturalRelic("005a9378c3454e058aeef684b857b4de", "1");
        } catch (Exception e) {//0006af8aa10943ef92c23d56665c48d1
            e.printStackTrace();
        }
        System.err.println(json);
        return json;
    }

    @RequestMapping(value = "/look.do", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String look(HttpServletResponse response)  {
        return "{}";
    }
}