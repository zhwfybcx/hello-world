/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.biz.process.impl;

import com.zwf.cms.biz.process.FolderBizProcess;
import com.zwf.cms.biz.process.ManageAdminBizProcess;
import com.zwf.cms.core.service.AdminFolderCoreService;
import com.zwf.cms.core.service.FolderCoreService;
import com.zwf.cms.enums.FolderEnum;
import com.zwf.cms.model.CmsProperties;
import com.zwf.cms.util.StringUtils;
import com.zwf.cms.web.model.AdminFolderVo;
import com.zwf.cms.web.model.AdminVo;
import com.zwf.cms.web.model.FolderInfo;
import com.zwf.cms.web.model.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weifeng
 * @version $Id: FolderBizProcessImpl.java, v 0.1 2017年03月09日 14:13  Exp $
 */
@Component
public class FolderBizProcessImpl implements FolderBizProcess {
    @Autowired
    private FolderCoreService folderCoreService;
    @Autowired
    private AdminFolderCoreService adminFolderCoreService;
    @Autowired
    private ManageAdminBizProcess adminBizProcess;
    @Autowired
    private CmsProperties cmsProperties;
/*    @Value("${cms.admin}")
    private String adminName;*/

    @Transactional
    @Override
    public Long addFolder(FolderInfo folderVo) {
        Long folderID = folderCoreService.save(folderVo);
        folderVo.setFolderId(folderID);
        updatePath(folderVo);
        folderCoreService.updatePathLevel(folderID, folderVo.getPath(), folderVo.getLevel());

        // 保存超级管理员的管理目录权限
        AdminFolderVo adminFolderVo = new AdminFolderVo();
        AdminVo adminVo = adminBizProcess.getAdminByName(cmsProperties.getAdmin());
        adminFolderVo.setAdminId(adminVo.getAdminId());
        adminFolderVo.setFolderId(folderID);
        adminFolderCoreService.save(adminFolderVo);
        return folderID;
    }

    @Override
    public Long deleteFolderById(Long id) {
        return folderCoreService.deleteFolderById(id);
    }

    @Override
    public FolderInfo queryFolderById(Long id) {
        FolderInfo folder;
        folder = folderCoreService.queryFolderById(id);
        return folder;
    }

    @Override
    public boolean isQueryFolderByEname(String ename) {
        return folderCoreService.isQueryFolderByEname(ename);
    }

    @Override
    public List<FolderInfo> getFolderPathListByFolderId(Long id) {
        List<FolderInfo> folderVoList = new ArrayList<>();
        if (id == 0) {
            return folderVoList;
        }
        FolderInfo folderVo = folderCoreService.queryFolderById(id);
        String[] paths = StringUtils.split(folderVo.getPath(), "#");
        if (paths == null || paths.length < 1) {
            return folderVoList;
        }
        for (String path : paths) {
            Long folderId = Long.parseLong(path);
            FolderInfo folder = folderCoreService.queryFolderById(folderId);
            folderVoList.add(folder);
        }
        return folderVoList;
    }

    /**
     * 查询所有 目录，并标明显示名称，及 adminID 是否有管理权限
     *
     * @param adminId
     * @return
     */
    @Override
    public List<FolderInfo> getAllFolderList(Long adminId) {
        List<FolderInfo> folderAdminVoList = folderCoreService.queryFolderAdminId(adminId);
        this.convertFolderToName(folderAdminVoList);
        return folderAdminVoList;
    }

    private String convertPathtoName(Map<String, String> idNameMap, String path) {
        if (StringUtils.isEmpty(path)) {
            return "";
        }
        String ids[] = StringUtils.split(path, "#");
        String[] names = new String[ids.length];
        for (int i = 0; i < ids.length; i++) {
            names[i] = idNameMap.get(ids[i]);
        }
        return StringUtils.join(names, " - ");
    }

    @Override
    public Long updateSort(Long id, Long sort) {
        return folderCoreService.updateSort(id, sort);
    }

    @Override
    public Long update(FolderInfo folderVo) {
        updatePath(folderVo);
        long isSuccess = folderCoreService.update(folderVo);
        return isSuccess;
    }

    private void updatePath(FolderInfo folderVo) {
        String path = "";
        Long level = 1L;
        if (folderVo.getFatherId() == 0) {
            path = path + folderVo.getFolderId();
            level = 1L;
        } else {
            FolderInfo fatherFolderVo = this.queryFolderById(folderVo.getFatherId());
            path = String.format("%s#%d", fatherFolderVo.getPath(), folderVo.getFolderId());
            level = fatherFolderVo.getLevel() + 1;
        }
        folderVo.setPath(path);
        folderVo.setLevel(level);
    }

    @Override
    public Long queryChildFolderNum(Long fatherId) {
        return folderCoreService.queryChildFolderNum(fatherId);
    }

    @Override
    public PageVo<FolderInfo> queryFolderPageByFatherId(Long fatherId, Integer pageNum, Integer row) {
        return folderCoreService.queryFolderPageByFatherId(fatherId, pageNum, row);
    }

    @Override
    public List<FolderInfo> queryFolderByNoAdminId(Long adminId) {
        List<FolderInfo> folderNoAdminVoList = folderCoreService.queryFolderByNoAdminId(adminId);
        this.convertFolderToName(folderNoAdminVoList);
        return folderNoAdminVoList;
    }

    @Override
    public PageVo<FolderInfo> queryFolderPageByAdminId(Long adminId, Integer pageNum, Integer row) {
        PageVo<FolderInfo> pageVo = folderCoreService.queryFolderPageByAdminId(adminId, pageNum, row);
        List<FolderInfo> list = pageVo.getList();
        this.convertFolderToName(list);
        return pageVo;
    }

    private List<FolderInfo> convertFolderToName(List<FolderInfo> folders) {
        List<FolderInfo> folderVoList = folderCoreService.queryAllFolder();

        Map<String, String> folderIdNameMap = new HashMap<>();
        if (folderVoList == null || folderVoList.size() < 1) {
            return null;
        }

        for (FolderInfo folderVo : folderVoList) {
            folderIdNameMap.put(String.format("%d", folderVo.getFolderId()), folderVo.getName());
        }
        if (folders == null || folders.size() < 1) {
            return null;
        }
        for (FolderInfo folderVo : folders) {
            folderVo.setPathName(convertPathtoName(folderIdNameMap, folderVo.getPath()));
        }
        return folders;
    }

    @Override
    public List<FolderInfo> queryFolderByFatherIdStatus(Long fatherId, FolderEnum.STATUS status) {
        return folderCoreService.queryFolderByFatherIdStatus(fatherId, status);
    }

    @Override
    public List<String> queryAllChildFoldersByFatherId(Long fatherId) {
        //目录ids
        List<String> folderIdList = new ArrayList<String>();
        //查询所有自己目录
        List<FolderInfo> childList = folderCoreService.queryFolderByFatherIdStatus(fatherId, FolderEnum.STATUS.display);

        folderIdList.add(fatherId.toString());
        if(FolderEnum.ROOT_FATHER_ID == fatherId.longValue()){//查询全部
            for (FolderInfo folderVo : childList) {
                folderIdList.add(String.valueOf(folderVo.getFolderId()));
                List<FolderInfo> fListSub = folderCoreService.queryFolderByFatherIdStatus(folderVo.getFolderId(), FolderEnum.STATUS.display);
                if(fListSub != null && fListSub.size() > 0){
                    for (FolderInfo fv : fListSub) {
                        folderIdList.add(String.valueOf(fv.getFolderId()));
                    }
                }
            }
        }else{
            if(childList != null && childList.size() > 0){
                for (FolderInfo folder : childList) {
                    folderIdList.add(String.valueOf(folder.getFolderId()));
                }
            }
        }
        return folderIdList;
    }

    @Override
    public List<FolderInfo> queryIndexFolders() {
        List<FolderInfo> list = new ArrayList<FolderInfo>();
        for (int i = 0; i < FolderEnum.INDEX_FOLDERS.length; i++) {
            FolderInfo folder = folderCoreService.queryFolderById(FolderEnum.INDEX_FOLDERS[i]);
            folder.setSubFolders(queryFolderByFatherIdStatus(folder.getFolderId(), FolderEnum.STATUS.display));
            list.add(folder);
        }
        return list;
    }

    @Override
    public List<FolderInfo> queryByFatherId() {
        return folderCoreService.queryFolderByFatherId();
    }
}
