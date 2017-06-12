/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.core.service.impl;

import com.zwf.cms.core.service.AdminFolderCoreService;
import com.zwf.cms.dal.dao.AdminFolderDAO;
import com.zwf.cms.dal.dataobject.AdminFolderDO;
import com.zwf.cms.model.AdminFolderConvert;
import com.zwf.cms.web.model.AdminFolderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author weifeng
 * @version $Id: AdminFolderCoreServiceImpl.java, v 0.1 2017年03月09日 10:59  Exp $
 */
@Component
public class AdminFolderCoreServiceImpl implements AdminFolderCoreService {
    @Autowired
    private AdminFolderDAO adminFolderDAO;
    /**
     * 保存用户管理权限
     * @param adminFolderVo
     */
    @Override
    public Long save(AdminFolderVo adminFolderVo) {
        AdminFolderDO adminFolderDO= AdminFolderConvert.convertToDO(adminFolderVo);
        adminFolderDAO.insert(adminFolderDO);
        return adminFolderDO.getAdminId();
    }
    /**
     * 根据 管理员id, 目录id 查询管理权限
     * @param adminId
     * @param folderId
     * @return
     */
    public AdminFolderVo queryAdminFolderById(Long adminId,Long folderId){
        List<AdminFolderDO> adminFolderDOList=adminFolderDAO.getByIds(adminId,folderId);
        if(adminFolderDOList != null && adminFolderDOList.size() > 0){
            return AdminFolderConvert.convert(adminFolderDOList.get(0));
        }
        return null;
    }
    /**
     * desc:根据管理员 id, 目录 id, 删除 AdminFolder.
     * @param entity entity
     * @return Long
     */
    @Override
    public Long delete(AdminFolderVo entity){
        AdminFolderDO adminFolderDO=AdminFolderConvert.convertToDO(entity);
        return adminFolderDAO.delete(adminFolderDO);
    }
    /**
     * desc:根据管理员 id, 删除 AdminFolder.
     * @param adminId adminId
     * @return Long
     */
    @Override
    public Long deleteByAdminId(Long adminId){
        return adminFolderDAO.deleteByAdminId(adminId);
    }
    /**
     * desc:根据文件 id, 删除 AdminFolder.
     * @param folderId folderId
     * @return Long
     */
    @Override
    public Long deleteByFolderId(Long folderId){
        return adminFolderDAO.deleteByFolderId(folderId);
    }
}
