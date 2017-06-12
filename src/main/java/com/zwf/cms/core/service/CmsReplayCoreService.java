package com.zwf.cms.core.service;

import com.zwf.cms.web.model.CmsReplayInfo;

import java.util.List;

/**
 * 回复
 * @author weifeng
 * @version $Id: HeadlineCoreService.java, v 0.1 2017年3月9日 下午1:09:22 dell Exp $
 */
public interface CmsReplayCoreService {

    /**
     * 查询所有回复
     * @param commentId
     * @return
     */
    List<CmsReplayInfo> getByCommentId (long commentId);

    /**
     * 删除回复
     * @param commetId
     * @return
     */
    long deleteByCommentId(long commetId);

    /**
     * 添加回复
     * @param cmsReplayInfo
     * @return
     */
    long insert (CmsReplayInfo cmsReplayInfo);
}
