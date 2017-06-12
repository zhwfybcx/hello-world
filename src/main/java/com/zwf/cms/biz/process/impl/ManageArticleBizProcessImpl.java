/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.biz.process.impl;

import com.zwf.cms.biz.process.FolderBizProcess;
import com.zwf.cms.biz.process.ManageArticleBizProcess;
import com.zwf.cms.core.service.ArticleCoreService;
import com.zwf.cms.enums.ArticleConstant;
import com.zwf.cms.web.model.ArticleInfo;
import com.zwf.cms.web.model.FolderInfo;
import com.zwf.cms.web.model.PageVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weifeng
 * @version $Id: ManageArticleBizProcessImpl.java, v 0.1 2017年03月17日 上午11:10  Exp $
 */
@Service
public class ManageArticleBizProcessImpl implements ManageArticleBizProcess {
    private static Logger logger = Logger.getLogger(ManageArticleBizProcessImpl.class);

    @Autowired
    private ArticleCoreService articleCoreService;
    @Autowired
    private FolderBizProcess folderBizProcess;

    @Override
    public PageVo<ArticleInfo> queryParmArticleList(ArticleInfo article, int pageNum, int rows) {
        return articleCoreService.queryParmArticleList(article, pageNum, rows);
    }

    @Override
    public long addArticle(ArticleInfo articleVo) {
        // 初始化参数
        articleVo.setCheckif(ArticleConstant.check.yes.name());
        articleVo.setViewcount(0);
        articleVo.setCommentcount(0);

        Long articleId = articleCoreService.addArticle(articleVo);
        return articleId;
    }

    @Override
    public ArticleInfo findByPrimary(Long articleId) {

       ArticleInfo  articleInfo = articleCoreService.findByPrimary(articleId);
        // 目录名称
        FolderInfo folderVo = folderBizProcess.queryFolderById(articleInfo.getFolderid());
        if (folderVo != null) {
            articleInfo.setFolderName(folderVo.getName());
        } else {
            articleInfo.setFolderName("目录丢失");
        }

        return articleInfo;
    }

    @Override
    public void deleteById(long articleId) {
        articleCoreService.deleteById(articleId);
    }

    @Override
    public long update(ArticleInfo articleVo) {
        long i = articleCoreService.update(articleVo);
        return i;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<ArticleInfo> getArticleByFolderIds(Long folderId, int offset, int rows) {
        List<ArticleInfo> list;
        // 获取子目录集合
        List<String> folderIdList = folderBizProcess.queryAllChildFoldersByFatherId(folderId);
        // 查询文章
        list = articleCoreService.getArticleByFolderIds(folderIdList, (offset - 1) * rows, rows);
        // 填充目录名称
        list = articleCoreService.getArticleFolderNameList(list);
        return list;
    }

    @Override
    public long countArticleListByFolderIds(Long folderId) {
        Long count;
        List<String> folderIdList = folderBizProcess.queryAllChildFoldersByFatherId(folderId);
        count = articleCoreService.countArticleListByFolderIds(folderIdList);
        return count;
    }

    @Override
    public List<ArticleInfo> getArticleFolderNameList(List<ArticleInfo> list) {
        return articleCoreService.getArticleFolderNameList(list);
    }

    @Override
    public List<ArticleInfo> getArticleMinGradeList(List<ArticleInfo> list, long gradeId) {
        if (list == null || list.size() < 1) {
            return list;
        }
        return list;
    }
}
