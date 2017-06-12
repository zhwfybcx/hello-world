/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.controller;

import com.zwf.cms.biz.process.ManageAdminBizProcess;
import com.zwf.cms.enums.SystemConstant;
import com.zwf.cms.model.CmsProperties;
import com.zwf.cms.util.LoggerUtil;
import com.zwf.cms.util.MD5Util;
import com.zwf.cms.util.StringUtils;
import com.zwf.cms.web.model.AdminVo;
import com.zwf.cms.web.model.JsonVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author weifeng
 * @version $Id: ManageAdminController.java, v 0.1 2017年03月11日 上午11:22  Exp $
 */
@Controller
@RequestMapping("/admin")
public class AdminController{

    private static Logger logger = Logger.getLogger(AdminController.class);
    @Autowired
    private ManageAdminBizProcess manageAdminBizProcess;
    @Autowired
    private CmsProperties cmsProperties;

    /**
     * 进入到登陆界面
     * @return
     */
    @RequestMapping(value = "/login")
    public String showLogin() {
        return "/manage/admin/login";
    }

    /**
     * 判断是否可以登陆
     * @param adminName
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/json/login")
    public JsonVo<String> checkLogin(@RequestParam(value = "username") String adminName,
                                     @RequestParam(value = "password") String password,
                                     HttpServletResponse response, HttpServletRequest request) {
        LoggerUtil.info(logger, "开始验证登陆数据", adminName, password);
        JsonVo<String> json = new JsonVo<>();
        try {
            AdminVo admin = manageAdminBizProcess.getAdminByName(adminName);
            /** 如果admin不为空，且密码相等 */
            if (admin != null && admin.getPassword().equals(MD5Util.getMD5String(password))) {
                json.setResult(true);

                /**start**/
                if(StringUtils.equals(cmsProperties.getAdmin(),admin.getName())){
                    admin.setIsAdmin(true);
                }

                //写入session;
                HttpSession  session = request.getSession();
                session.setMaxInactiveInterval(2592000);
                session.setAttribute(SystemConstant.SESSION_ADMIN,admin);
                LoggerUtil.info(logger, "用户对象存入session", admin);
            } else {
                json.setResult(false);
            }
        } catch (Exception e) {
            request.getSession().invalidate();
            json.setResult(false);
            LoggerUtil.error(logger, e, "验证登陆参数出现异常");
        }
        return json;
    }
}
