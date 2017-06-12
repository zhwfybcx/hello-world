package com.zwf.cms.web.controller.manage;

import com.zwf.cms.util.LoggerUtil;
import com.zwf.cms.biz.process.HeadlineBizProcess;
import com.zwf.cms.web.model.JsonVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/** 
 * 轮播管理的控制层
 * @author weifeng
 * @version $Id: HeadlineAction.java, v 0.1 2017年3月9日 下午3:49:39  Exp $
 */
@Controller
@RequestMapping("/manage/headline")
public class HeadlineController {
    private static Logger logger = Logger.getLogger(HeadlineController.class);
    @Autowired
    private HeadlineBizProcess headlineBizProcess;
    /**
     * 返回列表页面
     * @param pageNum
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String manage(@RequestParam(value = "p", defaultValue = "1") int pageNum, ModelMap modelMap) {
        modelMap.put("pageVo", headlineBizProcess.getAllListPage(pageNum));
        return "/manage/headline/list";
    }
    /**
     * 返回更新页面
     * @param headlineid
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping(value="/update",method=RequestMethod.GET)
    public String update(@RequestParam(value="headlineid",defaultValue = "0") Long headlineid,
           ModelMap modelMap,HttpServletRequest request ){
        modelMap.put("headlineDO",headlineBizProcess.queryByPrimary(headlineid));        
        return "/manage/headline/update";                
    }
    /**
     * 返回添加页面
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addHeadline(ModelMap modelMap) {
        modelMap.put("name", "");
        modelMap.put("url", "");
        modelMap.put("picture", "");
        return "/manage/headline/add";
    }
    /** 
     * 获取前台更新数据
     * @param headlineid
     * @param name
     * @param url
     * @param picture
     * @param request
     * @return
     */
   @ResponseBody
   @RequestMapping(value="/update/json",method=RequestMethod.POST)
   public JsonVo<String> update(
            @RequestParam(value = "headlineid") Long headlineid,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "url") String url,
            @RequestParam(value="picture") String picture,
            HttpServletRequest request){
       JsonVo<String> json = new JsonVo<String>();
        try {
            headlineBizProcess.update(headlineid, name, picture, url);
            json.setResult(true);
        } catch (Exception e) {
            json.setResult(false);
            LoggerUtil.info(logger, e,"更新数据失败");
        }
        
        return json;
    }
   /** 
    * 执行删除
    * @param headlineid
    * @param request
    * @return
    */
   @ResponseBody
   @RequestMapping(value="/delete/json/{headlineid}")
   public JsonVo<String> delete(@PathVariable("headlineid") Long headlineid,
          HttpServletRequest request){
        JsonVo<String> jsonVo=new JsonVo<String>();
        try {
            headlineBizProcess.deleteByPrimary(headlineid);
            jsonVo.setResult(true);
        } catch (Exception e) {
           jsonVo.setResult(false);
           LoggerUtil.info(logger, e,"删除失败");
        }        
    return jsonVo;
       
   }
   /**
    * 获取添加数据，执行添加
    * @param name
    * @param url
    * @param picture
    * @param request
    * @return
    */
   @ResponseBody
   @RequestMapping(value="/add/json",method=RequestMethod.POST)
   public JsonVo<String> addHeadline(                     
              @RequestParam(value = "name") String name,
              @RequestParam(value = "url") String url,
              @RequestParam(value="picture") String picture,
             HttpServletRequest request){
       JsonVo<String> jsonVo=new JsonVo<String>();
    try {
         headlineBizProcess.addHeadline(name, picture, url);
         jsonVo.setResult(true);
    } catch (Exception e) {
        jsonVo.setResult(false);
        LoggerUtil.info(logger, e,"添加功能失败");
    }
        return jsonVo;
    }
}
