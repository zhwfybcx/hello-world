/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.core.service.impl;

import com.zwf.cms.core.service.ArticleCoreService;
import com.zwf.cms.core.service.FolderCoreService;
import com.zwf.cms.dal.dao.ArticleDAO;
import com.zwf.cms.dal.dao.ExtArticleDAO;
import com.zwf.cms.dal.dataobject.ArticleDO;
import com.zwf.cms.model.ArticleDoConvertor;
import com.zwf.cms.web.model.ArticleInfo;
import com.zwf.cms.web.model.FolderInfo;
import com.zwf.cms.web.model.PageVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weifeng
 * @version $Id: ArticleCoreServiceImpl.java, v 0.1 2017年03月17日 上午9:46  Exp $
 */
@Service
public class ArticleCoreServiceImpl implements ArticleCoreService {

    /** 日志 */
    private static final Logger logger = Logger.getLogger(ArticleCoreServiceImpl.class);

    @Autowired
    private ArticleDAO articleDAO;
    @Autowired
    private ExtArticleDAO extArticleDAO;
    @Autowired
    private FolderCoreService folderCoreService;
     //封装分页数据源
    @Override
    public PageVo<ArticleInfo> queryParmArticleList(ArticleDO article, int pageNum, int rows) {
        PageVo<ArticleInfo> pageVo = new PageVo<>(pageNum);
        pageVo.setRows(rows);
        List<ArticleDO>  dos = extArticleDAO.queryParmArticleList(article.getFolderid(),pageVo.getOffset(), pageVo.getRows());
        List<ArticleInfo> list = ArticleDoConvertor.convertList(dos);
        pageVo.setList(list);
        pageVo.setCount(extArticleDAO.countParmArticleList(article).intValue());
        return pageVo;
    }

    @Override
    public long addArticle(ArticleInfo articleInfo) {
        ArticleDO articleDO = ArticleDoConvertor.convertToDo(articleInfo);
        return articleDAO.insert(articleDO);
    }

    @Override
    public ArticleInfo findByPrimary(Long articleid) {
        return ArticleDoConvertor.convertToInfo(articleDAO.getByPrimary(articleid));
    }

    @Override
    public void deleteById(long articleId) {
        articleDAO.deleteByPrimary(articleId);
    }

    @Override
    public long update(ArticleInfo articleInfo) {
        return articleDAO.update(ArticleDoConvertor.convertToDo(articleInfo));
    }

    /*@Override
    public List<ArticleInfo> getArtList(Long folderid, Long offset, Long rows) {
        return ArticleVoConvertor.convertList(articleDAO.getArtList(offset, rows,folderid));
    }*/

    @Override
    public List<ArticleInfo> getArticleByFolderIds(List<String> folderIdList, int offset, int rows) {
        if(offset < 0){
            offset = 0;
        }
        if(rows < 0){
            rows = 0;
        }
        List<ArticleInfo> list = ArticleDoConvertor.convertList(extArticleDAO.getArticleListByFolderIds(folderIdList,offset,rows));
        //list = proMobileArticle(list);
        return list;
    }

    @Override
    public long countArticleListByFolderIds(List<String> folderIdList) {
        return extArticleDAO.countArticleListByFolderIds(folderIdList);
    }

/*    @Override
    public List<ArticleVo> proMobileArticle(List<ArticleInfo> list,Long grade) {
        //要返回的文章
        List<ArticleVo> articleVos = new LinkedList<ArticleVo>();
        for (ArticleInfo articleInfo : list) {
            ArticleVo articleVo = ArticleDoConvertor.convertToVo(articleInfo);

            //目录显示,多级目录要特殊处理
            FolderVo folder = folderCoreService.queryFolderById(articleInfo.getFolderid());//文章所属目录
            articleVo.setTag(folder.getName());


            //时间描述
            try {
                articleVo.setTimeDesc(CMSUtils.getTimeDesc(articleInfo.getCreatetime()));
            } catch (ParseException e) {
                LoggerUtil.error(logger, e, "文章timeDes生成失败",articleInfo.getArticleid(),articleInfo.getCreatetime());
            }

            //封面图片
            if (StringUtils.isBlank(articleInfo.getPicture())) {
                articleVo.setPicUrl("http://files.maidoupo.com/ccfile//cms/1468650248890.jpg");
            }else{
                articleVo.setPicUrl(articleInfo.getPicture());
            }

            articleVo.setArticleId(articleInfo.getArticleid().toString());//此处为历史遗留问题
            articleVo.setCreateTime(String.valueOf(articleInfo.getCreatetime().getTime()));
            articleVos.add(articleVo);
        }
        return articleVos;

    }*/

    @Override
    public List<ArticleInfo> getArticleFolderNameList(List<ArticleInfo> list) {
        if(list != null && list.size() > 0){
            for (ArticleInfo articleInfo : list) {
                 FolderInfo folderVo = folderCoreService.queryFolderById(articleInfo.getFolderid());
                if(folderVo != null){
                    articleInfo.setFolderName(folderVo.getName());
                }else{
                    articleInfo.setFolderName("目录丢失");
                }
            }
        }
        return list;
    }


}
