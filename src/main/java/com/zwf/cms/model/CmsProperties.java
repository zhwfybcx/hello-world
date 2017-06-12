/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author weifeng
 * @version $Id: CmsProperties.java, v 0.1 2017年3月17日 下午1:46  Exp $
 */
@Component
@ConfigurationProperties(prefix = "cms")
public class CmsProperties {

    // 超级管理员
    private String admin;
    // ftp服务器地址
    private String ftp;

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getFtp() {
        return ftp;
    }

    public void setFtp(String ftp) {
        this.ftp = ftp;
    }
}
