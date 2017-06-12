/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.biz.process;


import com.zwf.cms.web.model.AdminFolderVo;
import com.zwf.cms.web.model.FolderInfo;
import com.zwf.cms.web.model.PageVo;

import java.util.List;

/**
 * @author weifeng
 * @version $Id: AdminFolderBizProcess.java, v 0.1 2017年03月19日 13:38 Exp $
 */
public interface AdminFolderBizProcess {
    /**
     * 根据 adminId 分页获得负责管理的目录
     * @param adminId
     * @return
     */
    PageVo<FolderInfo> queryFolderPageByAdminId(Long adminId, Integer pageNum, Integer row);

    /**
     * 根据 adminId 获得没有管理权限的目录
     * @param adminId
     * @return
     */
    List<FolderInfo>queryNoFolderByIdAdmin(Long adminId);
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
