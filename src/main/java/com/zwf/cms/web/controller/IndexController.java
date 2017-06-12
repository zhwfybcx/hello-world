/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.controller;

import com.zwf.cms.util.LoggerUtil;

import com.zwf.cms.dal.dataobject.UserDO;
import com.zwf.cms.enums.FolderEnum;
import com.zwf.cms.web.controller.manage.ManageBaseController;
import com.zwf.cms.web.model.ArticleInfo;
import com.zwf.cms.web.model.FolderInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 首页
 * @author weifeng
 * @version $Id: ManageIndexController.java, v 0.1 2017年3月19日 下午3:49:25  Exp $
 */
@Controller
public class IndexController extends ManageBaseController {

	private static final Logger logger = Logger.getLogger(IndexController.class);

    /**
     * 首页
     *
     * @param pageNum
     * @return
     */
    @RequestMapping("/")
    public ModelAndView index(@RequestParam(value = "p", defaultValue = "1") int pageNum) {
        ModelAndView mav = new ModelAndView();
        try {
            //最新资讯
            List<ArticleInfo> lastArticle = manageArticleBizProcess.getArticleByFolderIds(FolderEnum.ROOT_FATHER_ID,1,10);
            //lastArticle = articleBizProcess.getArticleMinGradeList(lastArticle,getUserInfo());//权限控制
            mav.addObject("lastArticle",lastArticle);
            //轮播
          //  mav.addObject("headlines",headlineBizProcess.getHeadByChannel(HeadlineEnum.CHANNEL.WEB.name()));
            mav.addObject("headlines",headlineBizProcess.getHeadAllList());
            //首页三个栏目
            List<FolderInfo> list = folderBizProcess.queryIndexFolders();
            //遍历这三个栏目下的最新三个文章
            for (FolderInfo folderInfo : list) {
                List<ArticleInfo> articles = manageArticleBizProcess.getArticleByFolderIds(folderInfo.getFolderId(),1,3);
                //articles = articleBizProcess.getArticleMinGradeList(articles,getUserInfo());//权限控制
                folderInfo.setArticles(articles);
            }
            UserDO user = this.getUserInfo(request);
            mav.addObject("user",user);
            mav.addObject("folders", list);
            mav.setViewName("/index");
        } catch (Exception e) {
            LoggerUtil.error(logger, e,"获取首页错误");
            mav.setViewName("/404");
        }
        return mav;
    }
}
