package com.zwf.cms.biz.process.impl;

import com.zwf.cms.biz.process.UserBizProcess;
import com.zwf.cms.core.service.UserCoreService;
import com.zwf.cms.dal.dataobject.UserDO;
import com.zwf.cms.web.model.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by user on 2017/3/15.
 */
@Component
public class UserBizProcessImpl implements UserBizProcess{
    @Autowired
    private UserCoreService userCoreService;
    @Override
    public Map<String, String> getByUserCount() {
        return userCoreService.getByUserCount();
    }

    @Override
    public PageVo<UserDO> getAllUser(int pageNum) {
        return userCoreService.getAllUser(pageNum);
    }

    @Override
    public UserDO queryByAccount(long account) {
        return userCoreService.queryByAccount(account);
    }

    @Override
    public long updateByEmail(UserDO userDO) {
        return userCoreService.updateByEmail(userDO);
    }

    @Override
    public UserDO queryByEmail(String email) {
        return userCoreService.queryByEmail(email);
    }

    @Override
    public long register(UserDO userDO) {
        return userCoreService.insert(userDO);
    }

}
