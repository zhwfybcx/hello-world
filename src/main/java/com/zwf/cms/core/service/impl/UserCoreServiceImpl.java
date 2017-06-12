package com.zwf.cms.core.service.impl;

import com.zwf.cms.core.service.UserCoreService;
import com.zwf.cms.dal.dao.UserDAO;
import com.zwf.cms.dal.dataobject.UserDO;
import com.zwf.cms.util.DateUtils;
import com.zwf.cms.web.model.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by user on 2017/3/14.
 */
@Service
public class UserCoreServiceImpl implements UserCoreService {

    @Autowired
    private UserDAO userDAO;
    @Override
    public Map<String,String> getByUserCount() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        Calendar d = Calendar.getInstance();
        Map<String,String> map = new HashMap<>();
        List<String> list= DateUtils.getAllDaysMonthByDate(new Date());
        for(int i=1;i<=d.getActualMaximum(Calendar.DATE);i++){
            long count = userDAO.getByDateCount(list.get(i-1));
           map.put(list.get(i-1),String.valueOf(count));
        }
        return map;
    }

    @Override
    public PageVo<UserDO> getAllUser(int pageNum) {
        PageVo<UserDO> pageVo = new PageVo<>(pageNum);
        pageVo.setRows(10);
        List<UserDO> list = userDAO.getAllUser();
        pageVo.setList(list);
        pageVo.setCount(userDAO.getAllUserCount());
        return pageVo;
    }

    @Override
    public UserDO queryByAccount(long account) {
        return userDAO.getByAccount(account);
    }

    @Override
    public long updateByEmail(UserDO userDO) {
        return userDAO.update(userDO);
    }

    @Override
    public UserDO queryByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    @Override
    public long insert(UserDO userDO) {
        return userDAO.insert(userDO);
    }
}
