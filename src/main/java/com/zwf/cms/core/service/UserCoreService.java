package com.zwf.cms.core.service;

import com.zwf.cms.dal.dataobject.UserDO;
import com.zwf.cms.web.model.PageVo;

import java.util.Map;

/**
 * Created by user on 2017/3/14.
 */
public interface UserCoreService {
    // 当月每天注册人数
    Map<String,String> getByUserCount();

    //封装分页数据源
    PageVo<UserDO> getAllUser(int PageNum);

    //根据账号查询数据
    UserDO queryByAccount(long account);

    //根据email更新密码
    long updateByEmail(UserDO userDO);

    //根据email查询数据
    UserDO queryByEmail(String email);

    //根据email查询数据
    long insert(UserDO userDO);
}
