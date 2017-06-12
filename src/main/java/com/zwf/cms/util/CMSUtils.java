package com.zwf.cms.util;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author weifeng
 * @version $Id: CMSUtils.java, v 0.1 2017年03月19日 17:09  Exp $
 */
public class CMSUtils {

	/**
	 * 把骆驼命名法的变量，变为大写字母变小写且之前加下划线
	 * 
	 * @param str
	 * @return
	 */
	public static String toUnderline(String str) {
		str = StringUtils.uncapitalize(str);
		char[] letters = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char letter : letters) {
			if (Character.isUpperCase(letter)) {
				sb.append("_" + letter + "");
			} else {
				sb.append(letter + "");
			}
		}
		return StringUtils.lowerCase(sb.toString());
	}

	public static String toText(String str) {
		return HtmlUtils.htmlEscape(str);
	}

	public static String toHTML(String str) {
		return Jsoup.clean(str, Whitelist.relaxed());
	}

	public static void main(String[] args) {
	}

	private final static String[] agent = { "Android", "iPhone", "iPod", "iPad", "Windows Phone", "MQQBrowser" };

	/**
	 * 检查用户是否是移动端
	 * 
	 * @param request
	 * @return
	 */
	public static boolean checkAgentIsMobile(HttpServletRequest request) {
		String ua = request.getHeader("User-Agent");
		boolean flag = false;
		if (!ua.contains("Windows NT") || (ua.contains("Windows NT") && ua.contains("compatible; MSIE 9.0;"))) {
			// 排除 苹果桌面系统
			if (!ua.contains("Windows NT") && !ua.contains("Macintosh")) {
				for (String item : agent) {
					if (ua.contains(item)) {
						flag = true;
						break;
					}
				}
			}
		}
		return flag;
	}
}
