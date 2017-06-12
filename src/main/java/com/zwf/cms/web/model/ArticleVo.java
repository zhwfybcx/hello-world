/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.model;


import com.zwf.cms.dal.dataobject.ArticleDO;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author weifeng
 * @version $Id: ArticleVo.java, v 0.1 2017年03月17日 上午9:56  Exp $
 */
public class ArticleVo extends ArticleDO {

	/**  */
	private static final long serialVersionUID = 7982521098551781860L;
	private String pathName;
	private String tag;
	private String timeDesc;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	private String picUrl;

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

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}


}
