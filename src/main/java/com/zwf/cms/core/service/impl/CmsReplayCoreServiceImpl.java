package com.zwf.cms.core.service.impl;

import com.zwf.cms.core.service.CmsReplayCoreService;
import com.zwf.cms.dal.dao.CmsReplayDAO;
import com.zwf.cms.dal.dao.UserDAO;
import com.zwf.cms.dal.dataobject.UserDO;
import com.zwf.cms.model.ReplayConvertor;
import com.zwf.cms.web.model.CmsReplayInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论
 * @author weifeng
 * @version $Id: HeadlineCoreService.java, v 0.1 2017年3月9日 下午1:09:22 dell Exp $
 */
@Service
public class CmsReplayCoreServiceImpl implements CmsReplayCoreService{

    @Autowired
    private CmsReplayDAO cmsReplayDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<CmsReplayInfo> getByCommentId(long commentId) {
        List<CmsReplayInfo> list = ReplayConvertor.convertList(cmsReplayDAO.getByCommentId(commentId));
        if(list !=null && list.size()>0){
            for (CmsReplayInfo replayInfo: list) {
                UserDO userDO = userDAO.getByPrimary(replayInfo.getUserid());
                replayInfo.setUserReplayName(userDO.getNickname());
            }
        }
        return list;
    }

    @Override
    public long deleteByCommentId(long commetId) {
        return cmsReplayDAO.deleteByCommentId(commetId);
    }

    @Override
    public long insert(CmsReplayInfo cmsReplayInfo) {
        return cmsReplayDAO.insert(cmsReplayInfo);
    }
}
