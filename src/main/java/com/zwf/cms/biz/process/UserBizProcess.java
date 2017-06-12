package com.zwf.cms.biz.process;

import com.zwf.cms.dal.dataobject.UserDO;
import com.zwf.cms.web.model.PageVo;

import java.util.Map;

/**
 * Created by user on 2017/3/15.
 */
public interface UserBizProcess {
    Map<String,String> getByUserCount();

    //获取分页数据源
    PageVo<UserDO> getAllUser(int pageNum);

    //根据账号查询数据
    UserDO queryByAccount(long account);

    //根据email更新密码
    long updateByEmail(UserDO userDO);

    //根据email查询数据
    UserDO queryByEmail(String email);

    //根据email查询数据
    long register(UserDO userDO);
}
