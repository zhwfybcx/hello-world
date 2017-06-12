/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.model;

import com.zwf.cms.dal.dataobject.ArticleDO;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;



/**
 * @author weifeng
 * @version $Id: ArticleVo.java, v 0.1 2017年03月17日 上午9:56  Exp $
 */
public class ArticleInfo extends ArticleDO implements Serializable {

	private static final long serialVersionUID = 7982521098551781860L;

	/**
	 * 栏目名称 不包含父级栏目
	 */
	private String folderName;
	/**
	 * 栏目名称 包含父级目录
	 */
	private String tag;
	/**
	 * 智能时间显示
	 */
	private String timeDesc;
	/**
	 * 最低阅读权限
	 */
	/*private String minGrade;*/
	/**
	 * 最低阅读权限显示名称
	 */
	private String minGradeName;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTimeDesc() {
		return timeDesc;
	}

	public void setTimeDesc(String timeDesc) {
		this.timeDesc = timeDesc;
	}

/*	public String getMinGrade() {
		return minGrade;
	}

	public void setMinGrade(String minGrade) {
		this.minGrade = minGrade;
	}*/

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getMinGradeName() {
		return minGradeName;
	}

	public void setMinGradeName(String minGradeName) {
		this.minGradeName = minGradeName;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
