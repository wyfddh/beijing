package com.tj720.admin.controller.collection;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tj720.admin.service.collection.CollectDictSevice;
import com.tj720.mip.framework.JsonResult;

/**
 * @author wyf
 * @date 2018/10/16 10:41
 **/
@RestController
@RequestMapping("/collectDict")
public class CollectDictController {

    @Autowired
    private CollectDictSevice collectDictSevice;

    /**
     * @author wyf
     * @description  从字典表取下拉框数据
     * @date  2018/10/16 10:57
     * @param arr 请求的参数数组
     * @return com.tj720.controller.framework.JsonResult
     */
    @RequestMapping("getSelectDataByArr")
    public JsonResult getSelectDataByArr(@RequestParam(value = "arr[]") String[] arr) {

        if (arr == null || arr.length <= 0) {
            return new JsonResult(0);
        }
        Map<String, Object> map = collectDictSevice.getDictListByArr(arr);

        return new JsonResult(1, map);
    }

    /**
     * @author wyf
     * @description   获取组织列表
     * @date  2018/10/29 10:55
     * @param
     * @return com.tj720.controller.framework.JsonResult
     */
    @RequestMapping("getOrg")
    public JsonResult getOrg(String orgId) {

        JsonResult jsonResult = collectDictSevice.getOrg(orgId);

        return jsonResult;
    }

}
