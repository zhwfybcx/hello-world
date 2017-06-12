package com.zwf.cms.web.controller;


import com.zwf.cms.util.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by user on 2017/3/24.
 */
@Controller
@RequestMapping(value = "/ueditor")
public class controller {

    @ResponseBody
    @RequestMapping(value = "/upload")
    public String config(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding( "utf-8" );
        response.setHeader("Content-Type" , "text/html");
        String rootPath=request.getServletContext().getRealPath("/");
        return new ActionEnter( request, rootPath).exec();
    }
}
