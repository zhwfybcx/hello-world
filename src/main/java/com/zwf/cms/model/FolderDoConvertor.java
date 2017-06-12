/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.model;


import com.zwf.cms.dal.dataobject.FolderDO;
import com.zwf.cms.web.model.FolderInfo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weifeng
 * @version $Id: FolderDoConvertor.java, v 0.1 2017年03月09日 12:39  Exp $
 */
public class FolderDoConvertor {
    /**
     * FolderVo 转化为 FolderDO
     *
     * @param folderVo
     * @return
     */
    public static FolderDO convertToDo(FolderInfo folderVo) {
        if (folderVo == null) {
            return null;
        }
        FolderDO folderDO = new FolderDO();
        BeanUtils.copyProperties(folderVo, folderDO, "createTime", "updateTime");
        return folderDO;
    }

    /**
     * FolderDO 转化为 FolderVo
     *
     * @param folderDO
     * @return
     */
    public static FolderInfo convert(FolderDO folderDO) {
        if (folderDO == null) {
            return null;
        }
        FolderInfo folderVo = new FolderInfo();
        BeanUtils.copyProperties(folderDO, folderVo, "createTime", "updateTime");
        return folderVo;
    }

    /**
     * FolderInfo 转化为 FolderVo
     * @param FolderInfo
     * @return
     */
/*    public static FolderVo convertToVo(FolderInfo folderInfo) {
        if (folderInfo == null) {
            return null;
        }
        FolderVo folderVo = new FolderVo();
        BeanUtils.copyProperties(folderInfo, folderVo, "createTime", "updateTime");
        return folderVo;
    }*/

    /**
     * FolderDO List 转化为 FolderVO List
     *
     * @param folderDOList
     * @return
     */
    public static List<FolderInfo> convertList(List<FolderDO> folderDOList) {
        if (folderDOList == null || folderDOList.size() < 1) {
            return null;
        }
        List<FolderInfo> folderVoList = new ArrayList<>();
        for (FolderDO folderDO : folderDOList) {
            if (folderDO == null) {
                continue;
            }
            folderVoList.add(convert(folderDO));
        }
        return folderVoList;
    }

}
