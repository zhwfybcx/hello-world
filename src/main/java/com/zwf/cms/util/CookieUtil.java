/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author weifeng
 * @version $Id: CookieUtil.java, v 0.1 2017年03月26日 14:23  Exp $
 */
public class CookieUtil {
    public static String NAME="CMS_NAME";
    public static String ID="CMS_ID";
    public static String IS_ADMIN="IS_ADMIN";
    public static void addCookie(String name,String value,int time,HttpServletResponse response){
        Cookie cookie=new Cookie(name,value);
        cookie.setMaxAge(time);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static String getCookie(String name, HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if(cookies != null){
            for(Cookie cookie:cookies){
                if(StringUtils.equals(cookie.getName(),name)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void removeCookie(String name,HttpServletResponse response){
        Cookie cookie=new Cookie(name,null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
