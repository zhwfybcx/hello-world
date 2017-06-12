package com.zwf.cms.biz.process.impl;

import com.zwf.cms.biz.process.CmsCommentBizProcess;
import com.zwf.cms.core.service.CmsCommentCoreService;
import com.zwf.cms.core.service.CmsReplayCoreService;
import com.zwf.cms.web.model.CmsCommentInfo;
import com.zwf.cms.web.model.CmsReplayInfo;
import com.zwf.cms.web.model.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2017/3/12.
 */
@Component
public class CmsCommentBizProcessImpl implements CmsCommentBizProcess{

    @Autowired
    private CmsCommentCoreService cmsCommentCoreService;
    @Autowired
    private CmsReplayCoreService cmsReplayCoreService;
    @Override
    public List<CmsCommentInfo> queryByArticle(long articleId) {
        List<CmsCommentInfo> commentList = cmsCommentCoreService.getByArticleId(articleId);
        if(commentList != null && commentList.size()>0){
            for(CmsCommentInfo commentInfo : commentList){
                List<CmsReplayInfo> list = cmsReplayCoreService.getByCommentId(commentInfo.getCommentid());
                if(list != null && list.size()>0){
                    commentInfo.setList(list);
                }else {
                    commentInfo.setList(null);
                }
            }
        }
        return  commentList;
    }

    @Override
    public Map<String, Object> queryList(long articleId) {

        List<CmsCommentInfo> commentList = cmsCommentCoreService.getByArticleId(articleId);
        if (commentList != null && commentList.size() > 0) {
            for (CmsCommentInfo commentInfo : commentList) {
                List<CmsReplayInfo> list = cmsReplayCoreService.getByCommentId(commentInfo.getCommentid());
                Map<String, Object> map = new HashMap<>();
                map.put("comment", commentInfo);
                if (list != null && list.size() > 0) {
                    map.put("replay", list);
                } else {
                    map.put("replay", "");
                }
                return map;
            }

        }
        return null;
    }

    @Override
    public PageVo<CmsCommentInfo> getByAllComments(int pageNum) {
        return cmsCommentCoreService.getByAllComments(pageNum);
    }

    @Override
    public long addComment(CmsCommentInfo cmsCommentInfo) {
        return cmsCommentCoreService.insert(cmsCommentInfo);
    }

    @Override
    public void deleteComment(long commentId) {
        cmsCommentCoreService.delete(commentId);
        cmsReplayCoreService.deleteByCommentId(commentId);
    }

}
