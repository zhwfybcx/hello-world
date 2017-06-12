/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.model;

import com.zwf.cms.dal.dataobject.FolderDO;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;


/**
 * @author weifeng
 * @version $Id: FolderVo.java, v 0.1 2017年03月09日 11:31  Exp $
 */
public class FolderInfo extends FolderDO implements Serializable {
	/**  */
	private static final long serialVersionUID = -3949593336481316167L;
	/**
	 * 显示目录名称
	 */
	private String pathName;
	/**
	 * 文章列表
	 */
	private List<ArticleInfo> articles;
	/**
	 * 子目录列表
	 */
	private List<FolderInfo> subFolders;

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public List<ArticleInfo> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleInfo> articles) {
		this.articles = articles;
	}

	public List<FolderInfo> getSubFolders() {
		return subFolders;
	}

	public void setSubFolders(List<FolderInfo> subFolders) {
		this.subFolders = subFolders;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}