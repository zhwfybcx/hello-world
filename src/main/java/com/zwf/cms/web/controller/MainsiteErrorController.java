package com.zwf.cms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 2017/3/11.
 */
@Controller
public class MainsiteErrorController{
/*    private static final String ERROR_PATH = "/404";
    @RequestMapping(value=ERROR_PATH)
    public String handleError(){
        return "/404";
    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }*/
    @RequestMapping(value = "/500")
    public String get500Error(){
        return "/500";
    }
    @RequestMapping(value = "/404")
    public String get404Error(){
        return "/404";
    }
}
