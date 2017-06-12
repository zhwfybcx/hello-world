package com.zwf.cms.web.controller;


import com.zwf.cms.biz.process.UserBizProcess;
import com.zwf.cms.dal.dataobject.UserDO;
import com.zwf.cms.enums.SystemConstant;
import com.zwf.cms.exception.ValidateException;
import com.zwf.cms.util.LoggerUtil;
import com.zwf.cms.util.MD5Util;
import com.zwf.cms.util.StringUtils;
import com.zwf.cms.web.controller.manage.ManageBaseController;
import com.zwf.cms.web.model.JsonVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by user on 2017/3/20.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends ManageBaseController{
    @Autowired
    private UserBizProcess userBizProcess;
    private static Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/login")
    public ModelAndView user(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");
        return modelAndView;
    }

    /**
     * 判断是否可以登陆
     * @param account
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login/json")
    public JsonVo<String> checkLogin(@RequestParam(value = "account") String account,
                                     @RequestParam(value = "password") String password,
                                     HttpServletResponse response, HttpServletRequest request) {
        LoggerUtil.info(logger, "开始验证登陆数据", account, password);
        JsonVo<String> json = new JsonVo<>();
        try {
            UserDO user = userBizProcess.queryByAccount((Long.valueOf(account))         );
            /** 如果user不为空，且密码相等 */
            if (user != null && user.getPassword().equals(MD5Util.getMD5String(password))) {
                json.setResult(true);
                //写入session;
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(2592000);
                session.setAttribute(SystemConstant.SESSION_USER,user);
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

    /**
     * 更新密码
     * @param email
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update/json")
    public JsonVo<String> updatePassword(@RequestParam(value = "email") String email,
                                     @RequestParam(value = "password") String password,
                                     HttpServletResponse response, HttpServletRequest request) {
        LoggerUtil.info(logger, "开始验证修改密码参数数据", email, password);
        JsonVo<String> json = new JsonVo<>();
        UserDO user = userBizProcess.queryByEmail(email);
        try {
            if(user==null){
                json.getErrors().put("email","此邮箱没有注册");
            }else if(StringUtils.isBlank(password)){
                  json.getErrors().put("password","密码必填，不能为空");
            }else {
                user.setPassword(MD5Util.getMD5String(password));
                userBizProcess.updateByEmail(user);
            }
            validate(json);
            json.setResult(true);
        } catch (ValidateException e) {
            e.printStackTrace();
            json.setResult(false);
            LoggerUtil.error(logger, e, "验证修改密码参数出现异常");
            json.setMsg(e.getMessage());
        }
        return json;
    }


    //返回注册页面
    @RequestMapping(value = "/register")
    public ModelAndView register(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/register");
        return modelAndView;
    }
    /**
     * 注册
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add/json")
    public JsonVo<String> updatePassword(@ModelAttribute("user")UserDO userDO,HttpServletResponse response, HttpServletRequest request) {
        JsonVo<String> json = new JsonVo<>();
        userDO.setCreatetime(new Date());
        try {
            if(StringUtils.isBlank(userDO.getNickname())){
                json.getErrors().put("nickname","名称不能为空");
            }
            if(StringUtils.isBlank(userDO.getPassword())){
                json.getErrors().put("password","密码不能为空");
            }
            if(StringUtils.isBlank(userDO.getEmail())){
                json.getErrors().put("email","邮箱不能为空");
            }
            if(userDO.getAccount()==null){
                json.getErrors().put("account","手机号不能为空");
            }
            validate(json);
            userDO.setPassword(MD5Util.getMD5String(userDO.getPassword()));
            userBizProcess.register(userDO);
            json.setResult(true);
        } catch (ValidateException e) {
            json.setResult(false);
            LoggerUtil.error(logger, e, "验证修改密码参数出现异常");
        }
        return json;
    }

    @RequestMapping("/exit")
    public String exitLogin(HttpServletRequest request, HttpServletResponse response){
        request.getSession().invalidate();
        return "/login";
    }
}
