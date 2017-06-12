package com.zwf.cms.web.model;

import com.zwf.cms.dal.dataobject.CmsReplayDO;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by user on 2017/3/12.
 */
public class CmsReplayInfo extends CmsReplayDO implements Serializable{

    private static final long serialVersionUID = 6514137254321822588L;
    private String UserReplayName;

    public String getUserReplayName() {
        return UserReplayName;
    }

    public void setUserReplayName(String userReplayName) {
        UserReplayName = userReplayName;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
