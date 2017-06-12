/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.controller.manage;

import com.zwf.cms.biz.process.*;
import com.zwf.cms.dal.dataobject.UserDO;
import com.zwf.cms.enums.SystemConstant;
import com.zwf.cms.exception.ValidateException;
import com.zwf.cms.web.model.AdminVo;
import com.zwf.cms.web.model.JsonVo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author weifeng
 * @version $Id: ManageBaseController.java, v 0.1 2017年03月11日 上午11:31  Exp $
 */
public class ManageBaseController {
	@Autowired
	protected ManageAdminBizProcess manageAdminBizProcess;
	@Autowired
	protected FolderBizProcess folderBizProcess;
	@Autowired
	protected AdminFolderBizProcess adminFolderBizProcess;
	@Autowired
	protected ManageArticleBizProcess manageArticleBizProcess;
	@Autowired
	protected HeadlineBizProcess headlineBizProcess;
	@Autowired
	protected CmsCommentBizProcess cmsCommentBizProcess;
	/**
	 * 用户
	 */
/*	public UserInfo userInfo;
	@Autowired
	public SessionService sessionService;*/
	/**
	 * Token的cookie
	 */
	
	@Autowired
	public HttpServletRequest request;

	/**
	 * 参数校验
	 * 
	 * @param json
	 * @param <T>
	 * @throws ValidateException
	 */
	protected <T> void validate(JsonVo<T> json) throws ValidateException {
		if (json.getErrors().size() > 0) {
			json.setResult(false);
			throw new ValidateException("有错误发生");
		} else {
			json.setResult(true);
		}
	}

	protected AdminVo getAdmin(HttpServletRequest request) {
		AdminVo admin = (AdminVo) request.getSession().getAttribute(
				SystemConstant.SESSION_ADMIN);
		return admin;
	}

	public UserDO getUserInfo(HttpServletRequest request) {
		UserDO user= (UserDO) request.getSession().getAttribute(
				SystemConstant.SESSION_USER);
		return user;
	}

	/*public UserInfo getUserInfo() {
		String cookieId = getCookie(SessionUtil.MAIDOUPO_TOKEN_KEY);
		if (StringUtil.isNotBlank(cookieId)) {
			userInfo = sessionService.getSession(cookieId);
			return userInfo;
		} else {
			return null;
		}

	}
*/
	/**
	 * 获取cookie
	 * 
	 * @param name
	 * @return
	 */
	public String getCookie(String name) {
		if (request != null) {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals(name)) {
						return cookie.getValue();
					}
				}
			}
		}

		return null;
	}

/*
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
*/

}
