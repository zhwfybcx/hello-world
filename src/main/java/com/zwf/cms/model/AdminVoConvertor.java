/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.model;


import com.zwf.cms.dal.dataobject.AdminDO;
import com.zwf.cms.web.model.AdminVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weifeng
 * @version $Id: AdminVoConvertor.java, v 0.1 2017年03月12日 下午5:16 qlD Exp $
 */
public class AdminVoConvertor {
    public static AdminVo convertToAdminVo(AdminDO adminDO) {
        if(adminDO == null){
            return null;
        }

        AdminVo adminVo = new AdminVo();
        BeanUtils.copyProperties(adminDO,adminVo,"createTime","updateTime");
        adminVo.setCreateTime(adminDO.getCreateTime());
        adminVo.setUpdateTime(adminDO.getUpdateTime());
        return adminVo;
    }

    public static AdminDO convertToAdminResultDo(AdminVo adminVo) {
        if(adminVo == null){
            return null;
        }
        AdminDO adminDO = new AdminDO();
        BeanUtils.copyProperties(adminVo,adminDO,"createTime","updateTime");
        adminDO.setCreateTime(adminVo.getCreateTime());
        adminDO.setUpdateTime(adminVo.getUpdateTime());
        return adminDO;
    }

    public static List<AdminVo> convertList(List<AdminDO> adminDOList) {
        List<AdminVo> adminVoList = new ArrayList<>();
        if (adminDOList != null && adminDOList.size() > 0) {
            for (int i = 0; i < adminDOList.size(); i++) {
                AdminVo adminVo = convertToAdminVo(adminDOList.get(i));
                adminVoList.add(adminVo);
            }
        }
        return adminVoList;
    }
}
