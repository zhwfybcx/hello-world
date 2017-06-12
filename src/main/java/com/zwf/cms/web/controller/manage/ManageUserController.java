package com.zwf.cms.web.controller.manage;

import com.zwf.cms.biz.process.UserBizProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by user on 2017/3/15.
 */
@Controller
@RequestMapping(value = "/manage/user")
public class ManageUserController {
    @Autowired
    private UserBizProcess userBizProcess;

    // 返回用户首页
    @RequestMapping(value = "/list")
    public String list(@RequestParam(value = "p", defaultValue = "1") int pageNum, ModelMap modelMap){
        modelMap.put("user",userBizProcess.getAllUser(pageNum));
        return "/manage/user/list";
    }
    //用户首页图表数据源
    @ResponseBody
    @RequestMapping(value = "/count")
    public Map<String,String> queryAllCount(){
        return userBizProcess.getByUserCount();
    }

}
