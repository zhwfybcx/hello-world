/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;


/**
 * FTP服务实现
 * @author weifeng
 * @version $Id: SessionServiceImpl.java, v 0.1 2017年3月29日 下午6:04:00  Exp $
 */

public class FTPService {
    /**
     * 向FTP服务器上传文件
     * 
     * @param filename_to 服务器的文件名称
     * @param fileFullname_from 本地的文件全名称
     * @return     上传后文件的网络地址
     */
    public static String uploadFile(String filename_to, String fileFullname_from) {
        //服务器路径
        String path_to = "cms";

        //FTP基本信息
        String host = null;
        Integer port = null;
        String username = null;
        String password = null;

        //文件连接
        FileInputStream fileInputStream = null;

        //文件的网络地址
        String uriFile;

        /** 设置日期格式*/
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");


        //Step.2.FTP服务器的基本信息

         PropertyPlaceholder propertyPlaceholder = new PropertyPlaceholder();
        host = propertyPlaceholder.getProperty("ftp.host");
        port = Integer.parseInt(propertyPlaceholder.getProperty("ftp.port"));
        username = propertyPlaceholder.getProperty("ftp.username");
        password = propertyPlaceholder.getProperty("ftp.password");
/*        host = "10.25.22.201";
        port = 2121;
        username = "ccfile";
        password = "C.C,f@C&C2016_21813";*/

        if ((host == null) || (port == null) || (username == null) || (password == null)) {
            return null;
        }

        //Step.3.新建一个文件连接
        try {
            fileInputStream = new FileInputStream(fileFullname_from);
        } catch (FileNotFoundException e) {
            return null;
        }

        //Step.4.上传文件并返回结果
        //filename_to = "/cms/" + filename_to;
        if (uploadFileCore(host, port, username, password, path_to, filename_to, fileInputStream)) {
        	StringBuilder sb = new StringBuilder();
            sb.append("/");
            sb.append(path_to);
            sb.append("/");
            sb.append(filename_to);
            uriFile = sb.toString();
        } else {
            uriFile = null;
        }

        return uriFile;
    }

    /**   
     * Description: 向FTP服务器上传文件
     * @param host FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param path FTP服务器保存目录
     * @param filename 上传到FTP服务器上的文件名   
     * @param inputStream 输入文件流
     * @return 成功返回true，否则返回false   
     */
    public static boolean uploadFileCore(String host, Integer port, String username, String password,
                                  String path, String filename, InputStream inputStream) {
        boolean isSuccess = false;
        FTPClient ftp = new FTPClient();
        String errMsg = null;
        Integer timeout = null;

        //取得FTP的超时时间(秒)
        timeout = 5000;

        try {
            //连接FTP服务器
            ftp.connect(host, port);

            //设定超时时间
            ftp.setSoTimeout(timeout);

            //判断是否成功登录服务器
            if (!ftp.login(username, password)) {
                errMsg = "登录服务器失败";
            } else {
            }

            //设置传输模式
            ftp.setControlEncoding("UTF-8");
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();


            //判断RETURN CODE ?= 200
            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                errMsg = "ReturnCode<>200！！！";
            } else {
            }

            //判断是否成功到达服务器路径
            if (!ftp.changeWorkingDirectory(path)) {
                errMsg = "切换服务器路径失败";
            } else {
            }

            //判断是否成功上传文件
            if (!ftp.storeFile(filename, inputStream)) {
                errMsg = "上传文件失败";
            } else {
            }

            //注销FTP登录
            ftp.logout();

            //上传成功
            if (errMsg == null) {
                isSuccess = true;
            }
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            //关闭FTP连接
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (Exception e) {
                }
            }

            //关闭文件连接
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
        return isSuccess;
    }
}
