package com.zwf.cms.web.model;

import com.zwf.cms.dal.dataobject.CmsCommentDO;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.*;

/**
 * Created by user on 2017/3/12.
 */
public class CmsCommentInfo extends CmsCommentDO implements Serializable{

    private static final long serialVersionUID = -6922192957539400271L;

    private List<CmsReplayInfo> list;
    private String userName;


    public List<CmsReplayInfo> getList() {
        return list;
    }

    public void setList(List<CmsReplayInfo> list) {
        this.list = list;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
