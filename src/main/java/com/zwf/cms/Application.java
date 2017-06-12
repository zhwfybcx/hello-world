/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author weifeng
 * @version $Id: Application.java, v 0.1 2017年11月17日 上午11:24 xfG Exp $
 */
@SpringBootApplication
@MapperScan("com.zwf.cms.dal.mapper")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}

