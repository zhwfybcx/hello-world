/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.model;

import java.util.Date;
import java.util.Map;

/**
 * @author weifeng
 * @version $Id: RespMessageFactory.java, v 0.1 2017年3月16日 下午3:35  Exp $
 */
public class RespMessageFactory {

    /**
     * 创建默认简单回馈消息
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> RespMessage<T, String> createDefaultSimpleRespMessage(T t) {
        return createSimpleRespMessage(t, "", "");
    }

    /**
     * 创建简单回馈消息
     *
     * @param t
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> RespMessage<T, String> createSimpleRespMessage(T t, String code, String msg) {
        RespMessage<T, String> respMessage = new RespMessage();
        respMessage.setResult(t);
        respMessage.setCode(code);
        respMessage.setMsg(msg);
        respMessage.setTimestamp(new Date().getTime());
        return respMessage;
    }

    /**
     * 创建默认复杂回馈消息
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> RespMessage<T, Map<String, String>> createDefaultComplexRespMessage(T t) {
        return createComplexRespMessage(t, "", null);
    }

    /**
     * 创建复杂回馈消息
     *
     * @param t
     * @param code
     * @param msgs
     * @param <T>
     * @return
     */
    public static <T> RespMessage<T, Map<String, String>> createComplexRespMessage(T t, String code, Map<String, String> msgs) {
        RespMessage<T, Map<String, String>> respMessage = new RespMessage();
        respMessage.setResult(t);
        respMessage.setCode(code);
        respMessage.setMsg(msgs);
        respMessage.setTimestamp(new Date().getTime());
        return respMessage;
    }


}
