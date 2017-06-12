package com.zwf.cms.biz.process;

import com.zwf.cms.web.model.CmsReplayInfo;

import java.util.List;

/**
 * @author weifeng
 * @version $Id: CmsReplayBizProcess.java, v 0.1 2017年03月19日 13:38 Exp $
 */
public interface CmsReplayBizProcess {

    /**
     * 查询所有回复
     * @param commentId
     * @return
     */
    List<CmsReplayInfo> queryByCommentId(long commentId);

    /**
     * 添加回复
     * @param cmsReplayInfo
     * @return
     */
    long addReplay (CmsReplayInfo cmsReplayInfo);
}
