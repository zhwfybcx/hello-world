/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.controller;


import com.zwf.cms.dal.dataobject.UserDO;
import com.zwf.cms.enums.FolderEnum;
import com.zwf.cms.util.LoggerUtil;
import com.zwf.cms.web.controller.manage.ManageBaseController;
import com.zwf.cms.web.model.ArticleInfo;
import com.zwf.cms.web.model.CmsCommentInfo;
import com.zwf.cms.web.model.FolderInfo;
import com.zwf.cms.web.model.PageVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章Controller
 * @author weifeng
 * @version $Id: ManageAdminController.java, v 0.1 2017年03月11日 上午11:22  Exp $
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends ManageBaseController {

    private static Logger logger = Logger.getLogger(ArticleController.class);

    /**
     * 查看文章列表
     */
    @RequestMapping(value = "/{folderId}/{page}",method= RequestMethod.GET)
    public ModelAndView articleList(@PathVariable Long folderId, @PathVariable int page) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/temp/articleList");
        try {
            List<ArticleInfo> list = manageArticleBizProcess.getArticleByFolderIds(folderId,page,10);
            mav.addObject("list",list);
            mav.addObject("folderId",folderId);

            mav.addObject("pageCount",Math.ceil(((double)manageArticleBizProcess.countArticleListByFolderIds(folderId))/10.00));
            mav.addObject("page",page);
           // mav.addObject("indexFolders",folderBizProcess.queryIndexFolders());//左侧栏目列表
            mav.addObject("indexFolders",folderBizProcess.queryByFatherId());//左侧栏目列表
            long fatherFolderId = folderId;
            if(folderId > FolderEnum.ROOT_FATHER_ID){
                FolderInfo folder = folderBizProcess.queryFolderById(folderId);
                fatherFolderId = folder.getLevel()>1?folder.getFatherId():folder.getFolderId();
                mav.addObject("subFolders",folderBizProcess.queryFolderByFatherIdStatus(fatherFolderId, FolderEnum.STATUS.display));
            }
            mav.addObject("fatherFolderId",fatherFolderId);
            //分页
            PageVo<ArticleInfo> pageVo = new PageVo<>(page);
            pageVo.setRows(10);
            pageVo.setCount((int)manageArticleBizProcess.countArticleListByFolderIds(folderId));
            Map<String, String> Param = new HashMap<>();
            Param.put("folderId", String.valueOf(folderId));
            pageVo.setArgs(Param);
            mav.addObject("pageVo",pageVo);
            UserDO user = this.getUserInfo(request);
            mav.addObject("user",user);
        } catch (Exception e) {
            LoggerUtil.error(logger,e, "查看文章列表异常",folderId);
            mav.setViewName("/404");
        }
        return mav;
    }

    /**
     * 查看文章详情
     */
    @RequestMapping(value = "/{articleid}.htm")
    public ModelAndView article(@PathVariable long articleid, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        try {

            ArticleInfo articleInfo = manageArticleBizProcess.findByPrimary(articleid);
            //文章所属目录
            FolderInfo folder = folderBizProcess.queryFolderById(articleInfo.getFolderid());
            List<CmsCommentInfo> cmsCommentlist= cmsCommentBizProcess.queryByArticle(articleid);
            mav = newsArticle(folder,mav);
            mav.addObject("article", articleInfo);
            mav.addObject("folder", folder);

            //评论回复
            mav.addObject("comment",cmsCommentlist);
        } catch (Exception e) {
            LoggerUtil.error(logger,e, "查看文章详情异常",articleid);
            mav.setViewName("/404");
        }
        return mav;
    }

    /**
     * 资讯
     */
    public ModelAndView newsArticle(FolderInfo folder,ModelAndView mav){

 /*       //移动端跳转到升级页面
        if(CMSUtils.checkAgentIsMobile(request)){
             mav.setViewName("/temp/upgradeApp");
            return mav;
        }*/

        //查询全部资讯的文章
        mav.addObject("lastArticle", manageArticleBizProcess.getArticleByFolderIds(FolderEnum.ROOT_FATHER_ID, 1, 5));
        long fatherFolderId = folder.getLevel()>1?folder.getFatherId():folder.getFolderId();
        //文章所属目录的上级目录
        FolderInfo fatherFolder = folderBizProcess.queryFolderById(fatherFolderId);
        mav.addObject("fatherFolder", fatherFolder);
        //查询相同目录下的文章
        UserDO user = this.getUserInfo(request);
        mav.addObject("user",user);
        mav.addObject("sameFolderArticle",manageArticleBizProcess.getArticleByFolderIds(fatherFolderId,1,5));
        mav.setViewName("/temp/articleInfo");
        return mav;
    }
}
