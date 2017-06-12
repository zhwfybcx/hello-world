/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */

package com.zwf.cms.core.service.impl;


import com.zwf.cms.core.service.FolderCoreService;
import com.zwf.cms.dal.dao.FolderDAO;
import com.zwf.cms.dal.dataobject.FolderDO;
import com.zwf.cms.enums.FolderEnum;
import com.zwf.cms.model.FolderDoConvertor;
import com.zwf.cms.web.model.FolderInfo;
import com.zwf.cms.web.model.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author weifeng
 * @version $Id: FolderCoreServiceImpl.java, v 0.1 2017年03月09日 10:27  Exp $
 */
@Component
public class FolderCoreServiceImpl implements FolderCoreService {
    @Autowired
    private FolderDAO folderDAO;

    /**
     * 添加目录，返回目录ID
     * @return
     */
    @Override
    @Transactional
    public Long save(FolderInfo folderVo) {
        FolderDO folderDO= FolderDoConvertor.convertToDo(folderVo);
        folderDAO.insert(folderDO);
        return folderDO.getFolderId();
    }
    /**
     * 根据 ID 删除目录
     * @param id
     * @return
     */
    @Override
    public Long deleteFolderById(Long id) {
        return folderDAO.deleteByPrimary(id);
    }
    /**
     * 根据 ID 查询目录
     * @param id
     * @return
     */
    @Override
    public FolderInfo queryFolderById(Long id) {
        FolderDO folderDO=folderDAO.getByPrimary(id);
        FolderInfo folderVo=FolderDoConvertor.convert(folderDO);
        return folderVo;
    }
    /**
     * 根据英文名字查询是否重名
     * @param ename
     * @return
     */
    @Override
    public boolean isQueryFolderByEname(String ename) {
        FolderDO folderDO=folderDAO.getByEname(ename);
        return folderDO != null;
    }
    /**
     * 更新 folder
     * @param folderVo
     * @return
     */
    @Override
    public Long update(FolderInfo folderVo){
        FolderDO folderDO=FolderDoConvertor.convertToDo(folderVo);
        return folderDAO.update(folderDO);
    }
    /**
     * 根据 id 更新 path 路径,目录层级 level
     * @param id
     * @param path
     */
    @Override
    public Long updatePathLevel(Long id,String path,Long level){
        return folderDAO.updatePathLevel(path,level,id);
    }
    /**
     * 根据 id 更新目录排名 sort
     * @param id
     * @param sort
     */
    @Override
    public Long updateSort(Long id,Long sort){
        return folderDAO.updateSort(sort,id);
    }
    /**
     * 查找所有目录
     * @return
     */
    @Override
    public List<FolderInfo>queryAllFolder(){
        List<FolderDO> folderDOList=folderDAO.getAllFolder();
        List<FolderInfo> folderVoList=FolderDoConvertor.convertList(folderDOList);
        return folderVoList;
    }

    /**
     * desc:子目录的数量.
     * @param fatherId fatherId
     * @return Long
     */
    @Override
    public Long queryChildFolderNum(Long fatherId){
        return folderDAO.getChildFolderNum(fatherId);
    }

    /**
     * 查找子目录并进行分页
     * @param fatherId
     * @param offset
     * @param row
     * @return
     */
    @Override
    public List<FolderInfo> queryChildFolderPages(Long fatherId,Integer offset,Integer row){
        List<FolderDO> folderDOList=folderDAO.getChildFolderPages(offset,fatherId,row);
        List<FolderInfo> folderVoList=FolderDoConvertor.convertList(folderDOList);
        return folderVoList;
    }
    /**
     * 对查找子目录进行分页
     * @param fatherId
     * @param pageNum
     * @return
     */
    @Override
    public PageVo<FolderInfo>queryFolderPageByFatherId(Long fatherId,Integer pageNum,Integer row){
        PageVo<FolderInfo>pageVo=new PageVo<>(pageNum);
        pageVo.setRows(row);
        List<FolderInfo> folderVoList=this.queryChildFolderPages(fatherId
                ,pageVo.getOffset(),pageVo.getRows());
        pageVo.setList(folderVoList);
        int count=queryChildFolderNum(fatherId).intValue();
        pageVo.setCount(count);
        return pageVo;
    }

    /**
     * 根据管理员查找所有目录.
     * @param adminId adminId
     * @return List<FolderDO>
     */
    @Override
    public List<FolderInfo> queryFolderAdminId(Long adminId){
        List<FolderInfo> folderVoList = FolderDoConvertor.convertList(folderDAO.getFolderAdminId(adminId));
        return folderVoList;
    }
    /**
     * desc:根据管理员查找目录分页.
     * @param offset offset
     * @param adminId adminId
     * @param row row
     * @return List<FolderDO>
     */
    @Override
    public List<FolderInfo> queryFolderNextByAdminId(Long adminId,Integer offset,Integer row){
        return FolderDoConvertor.convertList(folderDAO.getFolderPageByAdminId(offset,adminId,row));
    }
    /**
     * desc:根据管理员Id 获取没有管理权限的目录.
     * @param adminId adminId
     * @return List<FolderDO>
     */
    @Override
    public List<FolderInfo> queryFolderByNoAdminId(Long adminId){
        return FolderDoConvertor.convertList(folderDAO.getFolderByNoAdminId(adminId));
    }

    /**
     * 根据管理员查找目录分页.
     * @param adminId
     * @param pageNum
     * @return
     */
    @Override
    public PageVo<FolderInfo>queryFolderPageByAdminId(Long adminId,Integer pageNum,Integer row){
        PageVo<FolderInfo> pageVo=new PageVo<>(pageNum);
        pageVo.setRows(row);
        List<FolderInfo> folderVoList=this.queryFolderNextByAdminId(adminId,pageVo.getOffset(),pageVo.getRows());
        int count=(folderDAO.getFolderCountbyAdminId(adminId)).intValue();
        pageVo.setCount(count);
        pageVo.setList(folderVoList);
        return pageVo;
    }

    /**
     * desc:根据父Id，状态获得 folder.
     * @param fatherId fatherId
     * @param status status
     * @return List<FolderInfo>
     */
    @Override
    public List<FolderInfo> queryFolderByFatherIdStatus(Long fatherId, FolderEnum.STATUS status){
        List<FolderDO> folderDOList=folderDAO.getFolderByFatherIdStatus(fatherId,status.name());
        return FolderDoConvertor.convertList(folderDOList);
    }

    @Override
    public List<FolderInfo> queryFolderByFatherId() {
        List<FolderInfo> firstFolderList = FolderDoConvertor.convertList(folderDAO.getByFatherId());
        return firstFolderList;
    }
}