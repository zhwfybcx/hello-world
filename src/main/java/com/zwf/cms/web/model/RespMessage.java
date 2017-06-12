/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.model;

import com.alibaba.fastjson.JSON;

/**
 * 响应消息
 *
 * @author weifeng
 * @version $Id: RespMessage.java, v 0.1 2017年3月16日 下午1:52  Exp $
 */
public class RespMessage<T, MSG> {

    // 状态码
    private String code;
    // 反馈消息
    private MSG msg;
    // 请求结果
    private T result;
    // 时间戳
    private Long timestamp;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public MSG getMsg() {
        return msg;
    }

    public void setMsg(MSG msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
