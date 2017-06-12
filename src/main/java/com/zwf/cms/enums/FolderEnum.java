package com.zwf.cms.enums;

/**
 * @author 目录属性常量
 * 
 */
public class FolderEnum {

	//根目录id
	public static long ROOT_FATHER_ID = 0;
	
	public static int HELP_FOLDER_ID = 8;
	
	//写死的三个主页目录
	public static Long[] INDEX_FOLDERS = { 1l, 12l, 13l };

	public static enum STATUS {
		hidden, display
	};

	public static enum check {
		yes, no
	};

}