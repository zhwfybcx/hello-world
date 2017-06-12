/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.controller.manage;

import com.zwf.cms.exception.AuthException;
import com.zwf.cms.exception.ValidateException;
import com.zwf.cms.util.LoggerUtil;
import com.zwf.cms.util.MD5Util;
import com.zwf.cms.util.StringUtils;
import com.zwf.cms.web.model.AdminVo;
import com.zwf.cms.web.model.JsonVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author weifeng
 * @version $Id: ManageAdminController.java, v 0.1 2017年03月11日 上午11:22  Exp $
 */
@Controller
@RequestMapping("/manage/admin")
public class ManageAdminController extends ManageBaseController {

    private static Logger logger = Logger.getLogger(ManageAdminController.class);

    /**
     * 进入添加用户界面,并且显示所有的用户信息
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String addUser(@RequestParam(value = "p", defaultValue = "1") int pageNum, Model model) {
        List<AdminVo> adminVoList = manageAdminBizProcess.getAllList();
        model.addAttribute("adminList", adminVoList);
        LoggerUtil.debug(logger, adminVoList.toString(), "hello");
        return "manage/admin/add";
    }

    /**
     * 添加管理员
     * @param adminName
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/json/addNew", method = RequestMethod.POST)
    public JsonVo<String> addNewUser(@RequestParam(value = "adminName") String adminName,
                                     @RequestParam(value = "password") String password) {
        LoggerUtil.info(logger, "开始验证登陆参数", adminName, password);
        JsonVo<String> json = new JsonVo<String>();
        try {
            if (StringUtils.isBlank(adminName)) {
                json.getErrors().put("adminName", "管理员名称不能为空");
            }
            if (StringUtils.isBlank(password)) {
                json.getErrors().put("password", "管理员密码不能为空");
            } else if (password.length() < 6) {
                json.getErrors().put("password", "密码不能小于6位");
            } else if (password.length() > 16) {
                json.getErrors().put("password", "密码不能大于16位");
            }

            AdminVo admin = manageAdminBizProcess.getAdminByName(adminName);

            if (admin != null) {
                json.getErrors().put("adminName", "管理员名称不能重复");
            }
            // 检测校验结果
            validate(json);
            manageAdminBizProcess.addAdmin(StringUtils.trim(adminName), password);
            json.setResult(true);
        } catch (Exception e) {
            json.setResult(false);
            LoggerUtil.error(logger, e, "增加用户验证参数出现异常");
        }

        return json;
    }

    /**
     * 删除管理员
     * @param adminId
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/json/delete/{adminId}")
    public JsonVo<String> delete(@PathVariable long adminId, HttpServletRequest request) {
        JsonVo<String> json = new JsonVo<String>();
        try {
            manageAdminBizProcess.deleteAdmin(adminId);
            //删除用户之后，相关权限删除
            adminFolderBizProcess.deleteByAdminId(adminId);
            json.setResult(true);
        } catch (Exception e) {
            json.setResult(false);
            LoggerUtil.error(logger, e, "删除出现异常");
        }
        return json;
    }


    /**
     * 进入到修改密码界面
     * @return
     */
    @RequestMapping(value = "/update")
    public String showUpdate(@RequestParam(value = "adminId", defaultValue = "0") long adminId, HttpServletRequest request, ModelMap modelMap) {
//        String adminName = (String) MemcachedUtil.getInstance().get("SessionName", true);
        AdminVo sessionAdmin = this.getAdmin(request);
        AdminVo adminVo = manageAdminBizProcess.getAdminById(sessionAdmin.getAdminId());
        modelMap.put("adminVo",adminVo);
        return "/manage/admin/update";
    }

    /**
     * 修改密码
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/json/update")
    public JsonVo<String> update(@RequestParam(value = "password") String password,HttpServletRequest request) {
        LoggerUtil.info(logger, "更新密码", "password");
        JsonVo<String> json = new JsonVo<>();
        if (StringUtils.isBlank(password)) {
            json.getErrors().put("password", "管理员密码不能为空");
        } else if (password.length() < 6) {
            json.getErrors().put("password", "密码不能小于6位");
        } else if (password.length() > 16) {
            json.getErrors().put("password", "密码不能大于16位");
        }
        try {
            validate(json);
        } catch (ValidateException e) {
            json.setResult(false);
            e.printStackTrace();
            LoggerUtil.error(logger, e);
            return json;
        }
        try {
            AdminVo adminVo = this.getAdmin(request);
            adminVo.setPassword(MD5Util.getMD5String(password));
            manageAdminBizProcess.updateAdminByAmdinId(adminVo);
            json.setResult(true);
        } catch (AuthException e) {
            json.setResult(false);
            e.printStackTrace();
            LoggerUtil.error(logger, e);
        }
        return json;
    }
    @RequestMapping("/exit")
    public String exitLogin(HttpServletRequest request, HttpServletResponse response){
        request.getSession().invalidate();
        return "manage/admin/login";
    }
}
