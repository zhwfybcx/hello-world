package com.zwf.cms.filter;

import com.zwf.cms.dal.dataobject.UserDO;
import com.zwf.cms.enums.SystemConstant;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by user on 2017/3/23.
 */
public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 获取session
        UserDO user = (UserDO) httpServletRequest.getSession().getAttribute(
                SystemConstant.SESSION_USER);
        if(user != null){
            return true;
        }
        String path = httpServletRequest.getContextPath();
        httpServletResponse.sendRedirect(String.format("%s/user/login",path));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
