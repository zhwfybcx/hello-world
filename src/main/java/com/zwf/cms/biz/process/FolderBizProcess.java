/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.biz.process;


import com.zwf.cms.enums.FolderEnum;
import com.zwf.cms.web.model.FolderInfo;
import com.zwf.cms.web.model.PageVo;

import java.util.List;

/**
 * @author weifeng
 * @version $Id: FolderBizProcess.java, v 0.1 2017年03月09日 10:55  Exp $
 */
public interface FolderBizProcess {
    /**
     * 保存目录
     * @param folderVo
     * @return
     */
    Long addFolder(FolderInfo folderVo);

    /**
     * 根据 ID 删除目录
     * @param id
     * @return
     */
    Long deleteFolderById(Long id);
    /**
     * 根据 ID 查询目录
     * 会先从缓存取
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
     * 根据 目录id 获得 path 中所有的 folder
     * @param id
     * @return
     */
    List<FolderInfo> getFolderPathListByFolderId(Long id);

    /**
     * 查询所有 目录，并标明显示名称，及 adminID 是否有管理权限
     * @param adminId
     * @return
     */
    List<FolderInfo>getAllFolderList(Long adminId);

    /**
     * 根据 id 更新目录排名 sort
     * @param id
     * @param sort
     */
    Long updateSort(Long id,Long sort);

    /**
     * 更新 folder
     * @param folderVo
     * @return
     */
    Long update(FolderInfo folderVo);
    /**
     * desc:子目录的数量.
     * @param fatherId fatherId
     * @return Long
     */
    Long queryChildFolderNum(Long fatherId);

    /**
     * 对查找子目录进行分页
     * @param fatherId
     * @param pageNum
     * @return
     */
    PageVo<FolderInfo> queryFolderPageByFatherId(Long fatherId, Integer pageNum,Integer row);

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
    PageVo<FolderInfo>queryFolderPageByAdminId(Long adminId, Integer pageNum, Integer row);
    /**
     * desc:根据父Id，状态获得 folder.
     * @param fatherId fatherId
     * @param status status
     * @return List<FolderVo>
     */
    List<FolderInfo> queryFolderByFatherIdStatus(Long fatherId, FolderEnum.STATUS status);

    /**
     * 根据父id获取所有子目录的id集合
     * @param fatherId
     * @return
     */
    List<String> queryAllChildFoldersByFatherId(Long fatherId);

    /**
     * desc:查询首页三个固定目录
     * @return List<FolderDO>
     */
    List<FolderInfo> queryIndexFolders();

    /**
     * 根据父亲ID=0 查询所有一级目录
     * @return
     */
    List<FolderInfo> queryByFatherId();
}
