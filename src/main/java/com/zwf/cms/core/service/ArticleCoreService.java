/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.core.service;


import com.zwf.cms.dal.dataobject.ArticleDO;
import com.zwf.cms.web.model.ArticleInfo;
import com.zwf.cms.web.model.PageVo;

import java.util.List;

/**
 * @author weifeng
 * @version $Id: ArticleCoreService.java, v 0.1 2017年03月17日 上午9:41 qlD Exp $
 */
public interface ArticleCoreService {
    /**
     * 获取分页查询数据
     * @return
     */
    PageVo<ArticleInfo> queryParmArticleList(ArticleDO article, int pageNum, int rows);

    /**
     * 增加文章
     * @param articleVo
     * @return
     */
    long addArticle(ArticleInfo articleVo);

    /**
     * 根据主键获取文章
     * @param articleid
     * @return
     */
    ArticleInfo findByPrimary(Long articleid);

    /**
     * 根据文章id进行删除
     *
     * @param articleId
     */
    void deleteById(long articleId);

    /**
     * 更新文章
     *
     * @param articleVo
     */
    long update(ArticleInfo articleVo);

    /**
     * 查询目录下所有文章，递归查询
     */
    List<ArticleInfo> getArticleByFolderIds(List<String> folderIdList, int offset, int rows);

    /**
     * 统计目录下所有文章，递归查询
     */
    long countArticleListByFolderIds(List<String> folderIdList);

    /**
     * 处理返回给移动端数据，主要是权限控制
     * @param list
     * @param grade
     * @return
     */
  /*  public List<ArticleVo> proMobileArticle(List<ArticleInfo> list, Long grade);*/

    /**
     * 获取文章的目录名称
     * @param list
     * @return
     */
    public List<ArticleInfo> getArticleFolderNameList(List<ArticleInfo> list);
}
