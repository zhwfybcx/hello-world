/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.core.service;


import com.zwf.cms.enums.FolderEnum;
import com.zwf.cms.web.model.FolderInfo;
import com.zwf.cms.web.model.PageVo;

import java.util.List;

/**
 *
 * @author weifeng
 * @version $Id: FolderCoreService.java, v 0.1 2017年03月09日 10:26  Exp $
 */
public interface FolderCoreService {
    /**
     * 添加目录，返回目录ID
     * @param folderVo
     * @return
     */
    Long save(FolderInfo folderVo);
    /**
     * 根据 ID 删除目录
     * @param id
     * @return
     */
    Long deleteFolderById(Long id);

    /**
     * 根据 ID 查询目录
     * @param id
     * @return
     */
    FolderInfo queryFolderById(Long id);

    /**
     * 根据英文名字查询是否重名
     * @param ename
     * @return
     */
    boolean isQueryFolderByEname(String ename);

    /**
     * 更新 folder
     * @return
     */
    Long update(FolderInfo folderVo);

    /**
     * 根据 id 更新 path 路径,目录层级 level
     * @param id
     * @param path
     */
    Long updatePathLevel(Long id,String path,Long level);

    /**
     * 根据 id 更新目录排名 sort
     * @param id
     * @param sort
     */
    Long updateSort(Long id,Long sort);

    /**
     * 查找所有目录
     * @return
     */
    List<FolderInfo>queryAllFolder();
    /**
     * desc:子目录的数量.
     * @param fatherId fatherId
     * @return Long
     */
    Long queryChildFolderNum(Long fatherId);

    /**
     * 查找子目录并进行分页
     * @param fatherId
     * @param offset
     * @param row
     * @return
     */
    List<FolderInfo> queryChildFolderPages(Long fatherId,Integer offset,Integer row);

    /**
     * 对查找子目录进行分页
     * @param fatherId
     * @param pageNum
     * @return
     */
    PageVo<FolderInfo> queryFolderPageByFatherId(Long fatherId, Integer pageNum, Integer row);
    /**
     * 根据管理员查找所有目录.
     * @param adminId adminId
     * @return List<FolderDO>
     */
    List<FolderInfo> queryFolderAdminId(Long adminId);
    /**
     * desc:根据管理员查找目录分页.
     * @param offset offset
     * @param adminId adminId
     * @param row row
     * @return List<FolderDO>
     */
    List<FolderInfo> queryFolderNextByAdminId(Long adminId,Integer offset,Integer row);
    /**
     * desc:根据管理员Id 获取没有管理权限的目录.
     * @param adminId adminId
     * @return List<FolderDO>
     */
    List<FolderInfo> queryFolderByNoAdminId(Long adminId);

    /**
     * 根据管理员查找目录分页.
     * @param adminId
     * @param pageNum
     * @return
     */
    PageVo<FolderInfo>queryFolderPageByAdminId(Long adminId,Integer pageNum,Integer row);

    /**
     * desc:根据父Id，状态获得 folder.
     * @param fatherId fatherId
     * @param status status
     * @return List<FolderInfo>
     */
    List<FolderInfo> queryFolderByFatherIdStatus(Long fatherId, FolderEnum.STATUS status);

    /**
     * 根据父Id=0查询所有一级目录
     * @return
     */
    List<FolderInfo> queryFolderByFatherId();
}
