package com.zwf.cms.biz.process.impl;

import com.zwf.cms.biz.process.CmsReplayBizProcess;
import com.zwf.cms.core.service.CmsReplayCoreService;
import com.zwf.cms.web.model.CmsReplayInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/3/12.
 */
@Service
public class CmsReplayBizProcessImpl implements CmsReplayBizProcess{

    @Autowired
    private CmsReplayCoreService cmsReplayCoreService;

    @Override
    public List<CmsReplayInfo> queryByCommentId(long commentId) {
        return cmsReplayCoreService.getByCommentId(commentId);
    }

    @Override
    public long addReplay(CmsReplayInfo cmsReplayInfo) {
        return cmsReplayCoreService.insert(cmsReplayInfo);
    }
}
