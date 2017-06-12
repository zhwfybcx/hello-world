/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.model;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weifeng
 * @version $Id: BaseConvertor.java, v 0.1 2017年3月17日 下午3:23 xfG Exp $
 */
public abstract class BaseConvertor<S, T> implements Converter<S, T> {

    @Override
    public T convert(S s) {
        T t = null;
        try {
            t = getEntityClass().newInstance();
            BeanUtils.copyProperties(s, t);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

    public List<T> convert(List<S> ss) {
        List<T> ts = new ArrayList<>();
        if (ss == null || ss.size() == 0) {
            return ts;
        }
        for (S s : ss) {
            try {
                T t = getEntityClass().newInstance();
                BeanUtils.copyProperties(s, t);
                ts.add(t);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return ts;
    }

    protected abstract Class<T> getEntityClass();
}
