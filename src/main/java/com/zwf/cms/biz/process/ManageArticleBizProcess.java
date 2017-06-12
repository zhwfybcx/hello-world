/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.biz.process;

import com.zwf.cms.web.model.ArticleInfo;
import com.zwf.cms.web.model.PageVo;

import java.util.List;


/**
 * @author weifeng
 * @version $Id: ManageArticleBizProcess.java, v 0.1 2017年03月17日 上午11:09 qlD Exp$
 */
public interface ManageArticleBizProcess {
	/**
	 * 获取分页查询数据
	 *
	 * @return
	 */
	PageVo<ArticleInfo> queryParmArticleList(ArticleInfo article, int pageNum, int rows);

	/**
	 * 增加文章
	 *
	 * @param articleVo
	 * @return
	 */
	long addArticle(ArticleInfo articleVo);

	/**
	 * 根据主键获取文章 先从缓存取，没有再查数据库
	 *
	 * @return
	 */
	ArticleInfo findByPrimary(Long articleId);

	/**
	 * 删除
	 *
	 * @param articleId
	 */
	void deleteById(long articleId);

	/**
	 * 更新文章
	 *
	 * @param articleVo
	 * @return
	 */
	long update(ArticleInfo articleVo);

	/**
	 * 查询目录下所有文章，递归查询 先查缓存，再查数据库
	 */
	List<ArticleInfo> getArticleByFolderIds(Long folderId, int offset, int rows);

	/**
	 * 统计目录下所有文章，递归查询 先查缓存，再查数据库
	 */
	long countArticleListByFolderIds(Long folderId);

	/**
	 * 移动端使用
	 * 处理文章数据
	 * @param list
	 * @return
	 */
	/*public List<ArticleVo> processArticleMobile(List<ArticleInfo> list, Long grade);*/

	/**
	 * 获取文章的目录名称
	 *
	 * @param list
	 * @return
	 */
	public List<ArticleInfo> getArticleFolderNameList(List<ArticleInfo> list);

	/**
	 * 获取文章的权限
	 * @param list
	 * @return
	 */
	public List<ArticleInfo> getArticleMinGradeList(List<ArticleInfo> list,long gradeId);
}
