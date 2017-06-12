/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.model;


import com.zwf.cms.dal.dataobject.AdminFolderDO;
import com.zwf.cms.web.model.AdminFolderVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weifeng
 * @version $Id: AdminFolderConvert.java, v 0.1 2017年03月09日 13:54  Exp $
 */
public class AdminFolderConvert {
    /**
     * AdminFolderVo 转化为 AdminFolderDO
     * @param adminFolderVo
     * @return
     */
    public static AdminFolderDO convertToDO(AdminFolderVo adminFolderVo){
        if(adminFolderVo==null){
            return null;
        }
        AdminFolderDO adminFolderDO=new AdminFolderDO();
        BeanUtils.copyProperties(adminFolderVo,adminFolderDO,"createTime");
        return adminFolderDO;
    }

    /**
     * AdminFolderDO 转化为 AdminFolderVo
     * @param adminFolderDO
     * @return
     */
    public static AdminFolderVo convert(AdminFolderDO adminFolderDO){
        if(adminFolderDO==null){
            return null;
        }
        AdminFolderVo adminFolderVo=new AdminFolderVo();
        BeanUtils.copyProperties(adminFolderDO,adminFolderVo,"createTime");
        return adminFolderVo;
    }

    /**
     * List: AdminFolderDO 转化为 AdminFolderVo
     * @param adminFolderDOList
     * @return
     */
    public static List<AdminFolderVo> convertList(List<AdminFolderDO> adminFolderDOList){
        if(adminFolderDOList == null || adminFolderDOList.size() < 1){
            return null;
        }
        List<AdminFolderVo> adminFolderVoList=new ArrayList<>();
        for(AdminFolderDO adminFolderDO:adminFolderDOList){
            if(adminFolderDO==null){
                continue;
            }
            adminFolderVoList.add(convert(adminFolderDO));
        }
        return adminFolderVoList;
    }
}
