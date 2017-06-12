/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.biz.process.impl;


import com.zwf.cms.biz.process.AdminFolderBizProcess;
import com.zwf.cms.biz.process.FolderBizProcess;
import com.zwf.cms.core.service.AdminFolderCoreService;
import com.zwf.cms.web.model.AdminFolderVo;
import com.zwf.cms.web.model.FolderInfo;
import com.zwf.cms.web.model.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author weifeng
 * @version $Id: AdminFolderBizProcessImpl.java, v 0.1 2017年03月19日 13:38  Exp $
 */
@Component
public class AdminFolderBizProcessImpl implements AdminFolderBizProcess {
    @Autowired
    private FolderBizProcess folderBizProcess;
    @Autowired
    private AdminFolderCoreService adminFolderCoreService;
    /**
     * 根据 adminId 分页获得负责管理的目录
     * @param adminId
     * @return
     */
    @Override
    public PageVo<FolderInfo> queryFolderPageByAdminId(Long adminId, Integer pageNum, Integer row){
        return folderBizProcess.queryFolderPageByAdminId(adminId,pageNum,row);
    }

    /**
     * 根据 adminId 获得没有管理权限的目录
     * @param adminId
     * @return
     */
    @Override
    public List<FolderInfo> queryNoFolderByIdAdmin(Long adminId){
        return folderBizProcess.queryFolderByNoAdminId(adminId);
    }
    /**
     * 保存用户管理权限
     * @param adminFolderVo
     */
    @Override
    public Long save(AdminFolderVo adminFolderVo){
        return adminFolderCoreService.save(adminFolderVo);
    }
    /**
     * 根据 管理员id, 目录id 查询管理权限
     * @param adminId
     * @param folderId
     * @return
     */
    @Override
    public AdminFolderVo queryAdminFolderById(Long adminId, Long folderId){
        return adminFolderCoreService.queryAdminFolderById(adminId,folderId);
    }
    /**
     * desc:根据管理员 id, 目录 id, 删除 AdminFolder.
     * @param entity entity
     * @return Long
     */
    @Override
    public Long delete(AdminFolderVo entity){
        return adminFolderCoreService.delete(entity);
    }
    /**
     * desc:根据管理员 id, 删除 AdminFolder.
     * @param adminId adminId
     * @return Long
     */
    @Override
    public Long deleteByAdminId(Long adminId){
        return adminFolderCoreService.deleteByAdminId(adminId);
    }
    /**
     * desc:根据文件 id, 删除 AdminFolder.
     * @param folderId folderId
     * @return Long
     */
    @Override
    public Long deleteByFolderId(Long folderId){
        return adminFolderCoreService.deleteByFolderId(folderId);
    }
}
