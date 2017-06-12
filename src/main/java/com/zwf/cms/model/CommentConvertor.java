package com.zwf.cms.model;

import com.zwf.cms.dal.dataobject.CmsCommentDO;
import com.zwf.cms.web.model.CmsCommentInfo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/3/12.
 */
public class CommentConvertor {
    /**
     * Info转换为DO
     *
     * @return
     */
    public static CmsCommentDO convertToDo(CmsCommentInfo cmsCommentInfo){
        if(cmsCommentInfo==null){
            return null;
        }
        CmsCommentDO cmsCommentDO=new CmsCommentDO();
        BeanUtils.copyProperties(cmsCommentInfo,cmsCommentDO,"createTime");
        return cmsCommentDO;
    }
    /**
     * DO转换Vo
     * @return
     */
    public static CmsCommentInfo convert(CmsCommentDO cmsCommentDO){
        if(cmsCommentDO==null){
            return null;
        }
        CmsCommentInfo cmsCommentInfo=new CmsCommentInfo();
        BeanUtils.copyProperties(cmsCommentDO,cmsCommentInfo,"createTime");
        return cmsCommentInfo;

    }
    /**
     * list<DO>转换List<Vo>
     * @return
     */
    public static List<CmsCommentInfo> convertList(List<CmsCommentDO> cmsCommentDOList){
        if(cmsCommentDOList==null || cmsCommentDOList.size() < 1){
            return null;
        }
        List<CmsCommentInfo> cmsCommentInfoList=new ArrayList<>();
        for(CmsCommentDO cmsComment:cmsCommentDOList){
            if(cmsComment==null){
                continue;
            }
            cmsCommentInfoList.add(convert(cmsComment));
        }
        return cmsCommentInfoList;
    }

}
