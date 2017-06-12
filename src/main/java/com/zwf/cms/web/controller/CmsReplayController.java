package com.zwf.cms.web.controller;

import com.zwf.cms.biz.process.CmsCommentBizProcess;
import com.zwf.cms.biz.process.CmsReplayBizProcess;
import com.zwf.cms.biz.process.UserBizProcess;
import com.zwf.cms.web.model.CmsCommentInfo;
import com.zwf.cms.web.model.CmsReplayInfo;
import com.zwf.cms.web.model.JsonVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by user on 2017/3/12.
 */
@Controller
@RequestMapping("/topic")
public class CmsReplayController {
    private static Logger logger = Logger.getLogger(CmsReplayController.class);

    @Autowired
    private CmsReplayBizProcess cmsReplayBizProcess;
    @Autowired
    private CmsCommentBizProcess cmsCommentBizProcess;
    @Autowired
    private UserBizProcess userBizProcess;

   /* @ResponseBody
    @RequestMapping("/map")
    public Map<String,Object> CmsReplayList(){
        Map<String,Object> map = cmsCommentBizProcess.queryList(98L);
        return map;
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<CmsCommentInfo> CmsReplayList3(){
        List<CmsCommentInfo> list  = cmsCommentBizProcess.queryByArticle(98L);
        return list;
    }*/
   @ResponseBody
   @RequestMapping(value = "/comment/add")
    public JsonVo<String> addComment(@ModelAttribute CmsCommentInfo cmsCommentInfo, HttpServletRequest request){
        JsonVo<String> json = new JsonVo<String>();
        try {
            cmsCommentInfo.setIp(request.getRemoteAddr());
            cmsCommentInfo.setCreatetime(new Date());
            cmsCommentBizProcess.addComment(cmsCommentInfo);
            json.setResult(true);
        }catch (Exception e){
            json.setResult(false);
        }
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/replay/add")
    public JsonVo<String> addReplay(@ModelAttribute CmsReplayInfo cmsReplayInfo, HttpServletRequest request){
        JsonVo<String> json = new JsonVo<String>();
        try {
            cmsReplayInfo.setIp(request.getRemoteAddr());
            cmsReplayInfo.setCreatetime(new Date());
            cmsReplayBizProcess.addReplay(cmsReplayInfo);
            json.setResult(true);

        }catch (Exception e){
            json.setResult(false);
        }
        return json;
    }

}
