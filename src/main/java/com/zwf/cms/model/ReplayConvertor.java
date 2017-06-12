package com.zwf.cms.model;


import com.zwf.cms.dal.dataobject.CmsReplayDO;
import com.zwf.cms.web.model.CmsReplayInfo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/3/12.
 */
public class ReplayConvertor {
    /**
     * Info转换为DO
     *
     * @return
     */
    public static CmsReplayDO convertToDo(CmsReplayInfo CmsReplayInfo){
        if(CmsReplayInfo==null){
            return null;
        }
        CmsReplayDO CmsReplayDO=new CmsReplayDO();
        BeanUtils.copyProperties(CmsReplayInfo,CmsReplayDO,"createTime");
        return CmsReplayDO;
    }
    /**
     * DO转换Vo
     * @return
     */
    public static CmsReplayInfo convert(CmsReplayDO CmsReplayDO){
        if(CmsReplayDO==null){
            return null;
        }
        CmsReplayInfo CmsReplayInfo=new CmsReplayInfo();
        BeanUtils.copyProperties(CmsReplayDO,CmsReplayInfo,"createTime");
        return CmsReplayInfo;

    }
    /**
     * list<DO>转换List<Vo>
     * @return
     */
    public static List<CmsReplayInfo> convertList(List<CmsReplayDO> CmsReplayDOList){
        if(CmsReplayDOList==null || CmsReplayDOList.size() < 1){
            return null;
        }
        List<CmsReplayInfo> CmsReplayInfoList=new ArrayList<>();
        for(CmsReplayDO CmsReplay:CmsReplayDOList){
            if(CmsReplay==null){
                continue;
            }
            CmsReplayInfoList.add(convert(CmsReplay));
        }
        return CmsReplayInfoList;
    }
}
