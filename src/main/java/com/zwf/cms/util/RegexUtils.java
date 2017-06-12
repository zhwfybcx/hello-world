/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author weifeng
 * @version $Id: ManageFolderAction.java, v 0.1 2017年03月15日 16:07  Exp $
 */
public class RegexUtils {

	public static boolean isAlphaUnderline(String msg) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
		Matcher matcher = pattern.matcher(msg);
		return matcher.matches();
	}
}
