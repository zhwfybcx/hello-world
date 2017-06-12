/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.controller;


import com.zwf.cms.enums.FolderEnum;
import com.zwf.cms.util.DateUtils;
import com.zwf.cms.util.StringUtils;
import com.zwf.cms.web.controller.manage.ManageBaseController;
import com.zwf.cms.web.model.FolderInfo;
import com.zwf.cms.web.model.HeadlineVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 移动端
 *
 * @author weifeng
 * @version $Id: MobileController.java, v 0.1 2017年3月30日 上午8:55:10  Exp $
 */
@Controller
@RequestMapping("/mobile")
public class MobileController extends ManageBaseController {


	private static final Logger logger = Logger.getLogger(MobileController.class);

	/**
	 * 获取目录列表
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getFolder", method = RequestMethod.GET)
	public @ResponseBody Object getFolder() {

		List<FolderInfo> list = null;
        list = folderBizProcess.queryFolderByFatherIdStatus(0L, FolderEnum.STATUS.display);
		return list;
	}

	/**
	 * 获取轮播列表
	 *
	 * @return
	 */
	@RequestMapping(value = "/getHeadline", method = RequestMethod.GET)
	public @ResponseBody Object getHeadline() {
		List<HeadlineVo> list = headlineBizProcess.getHeadAllList();
		return list;
	}

	/**
	 * 获取文章列表
	 *
	 * @return
	 */
	/*@RequestMapping(value = "/getArticle", method = RequestMethod.GET)
	public @ResponseBody Object getArticle(@RequestParam("folderId") String folderId,
			@RequestParam("offset") Long offset) {

			offset = offset * 10;
			List<ArticleVo> list = new ArrayList<ArticleVo>();
			try {
				list = manageArticleBizProcess.mobileGetArticleListByFatherId(folderId, offset, (long) 10);
			} catch (Exception e1) {
				logger.error(folderId);
			}
			if (list != null && list.size() > 0) {
				for (ArticleVo articleVo : list) {
					try {
						articleVo.setTimeDesc(getStatus(articleVo.getCreatetime()));
					} catch (ParseException e) {
						logger.error(articleVo);
					}
				}
			}
			return list;
	}*/

	/**
	 * 判断当前时间与发布时间所显示的状态 1.一分钟内 2.一小时内 3.一天内 4.显示当前时间
	 *
	 * @throws ParseException
	 */
	public static String getStatus(Date creDate) throws ParseException {
		if (creDate == null) {
			return "";
		}

		Date nowDate = new Date();

		if (DateUtils.getDiffSeconds(nowDate, creDate) < 3600) {
			long num = (long) (DateUtils.getDiffSeconds(nowDate, creDate) / 60);
			return num + "分钟前";
		} else if (StringUtils.equalsIgnoreCase(DateUtils.getWebTodayString(), DateUtils.getWebDateString(creDate))) {
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
			return df.format(creDate).toString();
		} else {
			return DateUtils.getWebDateString(creDate);
		}

	}
}
