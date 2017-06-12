package com.zwf.cms.web.controller.manage;

import com.zwf.cms.util.LoggerUtil;
import com.zwf.cms.web.model.CmsCommentInfo;
import com.zwf.cms.web.model.JsonVo;
import com.zwf.cms.web.model.PageVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user on 2017/3/14.
 */
@Controller
@RequestMapping(value = "/manage/comment")
public class ManageCmsCommentController extends ManageBaseController{
    private static Logger logger = Logger.getLogger(ManageCmsCommentController.class);
    @RequestMapping(value = "/list")
    public String manage(@RequestParam(value = "p", defaultValue = "1") int pageNum, ModelMap modelMap){
        PageVo<CmsCommentInfo> commentInfoPageVo  = cmsCommentBizProcess.getByAllComments(pageNum);
        modelMap.put("pageVo",commentInfoPageVo);
        return "/manage/comment/list";
    }

    @ResponseBody
    @RequestMapping(value = "/delete/json/{commentId}")
    public JsonVo<String> deleteComment(@PathVariable(value ="commentId" ) long commentId){
        LoggerUtil.info(logger, "开始删除评论", commentId);
        JsonVo<String> json = new JsonVo<String>();
        try{
            cmsCommentBizProcess.deleteComment(commentId);
            json.setResult(true);
        }catch (Exception e){
               e.printStackTrace();
               json.setResult(false);
            LoggerUtil.error(logger, e, "删除出现异常");
        }
        LoggerUtil.info(logger, "删除评论结束", commentId);
        return json;
    }
}
