/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.controller.manage;

import com.zwf.cms.util.LoggerUtil;
import com.zwf.cms.web.model.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weifeng
 * @version $Id: ManageAdminFolderController.java, v 0.1 2017年03月19日 17:09  Exp $
 */
@Controller
@RequestMapping("/manage/adminFolder")
public class ManageAdminFolderController extends ManageBaseController{
    private static Logger logger=Logger.getLogger(ManageAdminFolderController.class);
    @RequestMapping(value = "/manage",method = RequestMethod.GET)
    public String manage(@RequestParam(value = "adminId",defaultValue = "1") Long adminId,
                         @RequestParam(value = "p",defaultValue = "1") Integer pageNum,
                         ModelMap modelMap){
        LoggerUtil.info(logger,"come into adminFolder manage page");
        PageVo<FolderInfo> pageVo=adminFolderBizProcess.queryFolderPageByAdminId(adminId,pageNum,5);
        Map<String,String> param=new HashMap<>();
        param.put("adminId",String.valueOf(adminId));
        pageVo.setArgs(param);


        List<FolderInfo> folderVoList=adminFolderBizProcess.queryNoFolderByIdAdmin(adminId);

        AdminVo adminVo=manageAdminBizProcess.getAdminById(adminId);
        modelMap.put("pageVo",pageVo);
        modelMap.put("folderVoList",folderVoList);
        modelMap.put("admin",adminVo);
        AdminFolderVo adminFolderVo = new AdminFolderVo();
        adminFolderVo.setAdminId(adminId);
        modelMap.put("adminFolder",adminFolderVo);
        LoggerUtil.info(logger,"return adminFolder manage page");
        return "manage/adminFolder/manage";
    }

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonVo<String> add(@ModelAttribute("adminFolder") AdminFolderVo adminFolderVo){
        AdminFolderVo adminFolderVo1=adminFolderBizProcess.queryAdminFolderById(adminFolderVo.getAdminId()
                ,adminFolderVo.getFolderId());
        LoggerUtil.info(logger,String.format("add adminFolder %s",adminFolderVo));
        JsonVo<String> jsonVo=new JsonVo<>();
        if(adminFolderVo1 == null){
            adminFolderBizProcess.save(adminFolderVo);
            jsonVo.setResult(true);
            LoggerUtil.info(logger,"add adminFolder success");
        }else{
            jsonVo.setMsg("管理员已拥有该权限，请重新添加！");
            jsonVo.setResult(false);
            LoggerUtil.info(logger,"add adminFolder failed");
        }
        return jsonVo;
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public JsonVo<String>delete(@RequestParam("adminId") Long adminId,
                                @RequestParam("folderId") Long folderId){
        LoggerUtil.info(logger,String.format("delete adminFolder adminId: %d, folderId: %d",adminId,folderId));
        JsonVo<String> jsonVo=new JsonVo<>();
        AdminFolderVo folderVo=new AdminFolderVo();
        folderVo.setAdminId(adminId);
        folderVo.setFolderId(folderId);
        adminFolderBizProcess.delete(folderVo);
        jsonVo.setResult(true);
        LoggerUtil.info(logger,String.format("delete adminFolder success adminId: %d, folderId: %d",adminId,folderId));
        return jsonVo;
    }
}
