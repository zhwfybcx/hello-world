/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.core.service;


import com.zwf.cms.web.model.AdminFolderVo;

/**
 * @author weifeng
 * @version $Id: AdminFolderCoreService.java, v 0.1 2017年03月09日 10:58  Exp $
 */
public interface AdminFolderCoreService {
    /**
     * 保存用户管理权限
     * @param adminFolderVo
     */
    Long save(AdminFolderVo adminFolderVo);

    /**
     * 根据 管理员id, 目录id 查询管理权限
     * @param adminId
     * @param folderId
     * @return
     */
    AdminFolderVo queryAdminFolderById(Long adminId, Long folderId);

    /**
     * desc:根据管理员 id, 目录 id, 删除 AdminFolder.
     * @param entity entity
     * @return Long
     */
    Long delete(AdminFolderVo entity);
    /**
     * desc:根据管理员 id, 删除 AdminFolder.
     * @param adminId adminId
     * @return Long
     */
    Long deleteByAdminId(Long adminId);
    /**
     * desc:根据文件 id, 删除 AdminFolder.
     * @param folderId folderId
     * @return Long
     */
    Long deleteByFolderId(Long folderId);
}
