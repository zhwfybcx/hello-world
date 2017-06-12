/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.controller;

import com.zwf.cms.web.model.RespMessage;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

/**
 * controller基类
 * 请求映射：/demo
 * Content-Type：application/json 或 application/xml
 * Accept：application/json 或 application/xml
 *
 * @author weifeng
 * @version $Id: BaseController.java, v 0.1 2017年3月16日 下午1:48  Exp $
 */
public interface BaseController<T> {

    /**
     * 列出所有bean
     * 请求方式：GET
     */
    RespMessage<List<T>, String> view();

    /**
     * 列出指定bean
     * 请求映射：/{id}
     * 请求方式：GET
     *
     * @param id
     */
    RespMessage<T, String> view(String id);

    /**
     * 添加一个bean
     * 请求方式：POST
     *
     * @param bean
     * @return
     */
    RespMessage<T, Map<String, String>> add(T bean, BindingResult result);


    /**
     * 更新指定bean的信息（提供bean的全部信息）
     * 请求映射：/{id}
     * 请求方式：PUT
     *
     * @param bean
     * @return
     */
    RespMessage<T, Map<String, String>> updateWhole(String id, T bean, BindingResult result);

    /**
     * 更新指定bean的信息（提供bean的部分信息）
     * 请求映射：/{id}
     * 请求方式：PATCH
     *
     * @param bean
     * @return
     */
    RespMessage<T, Map<String, String>> updatePart(String id, T bean, BindingResult result);

    /**
     * 删除指定bean
     * 请求映射：/{id}
     * 请求方式：DELETE
     *
     * @param id
     * @return
     */
    RespMessage<T, String> delete(String id);

}
