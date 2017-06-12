/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.controller.manage;


import com.zwf.cms.exception.ValidateException;
import com.zwf.cms.model.CmsProperties;
import com.zwf.cms.util.LoggerUtil;
import com.zwf.cms.util.RegexUtils;
import com.zwf.cms.util.StringUtils;
import com.zwf.cms.web.model.AdminVo;
import com.zwf.cms.web.model.FolderInfo;
import com.zwf.cms.web.model.JsonVo;
import com.zwf.cms.web.model.PageVo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.validator.routines.IntegerValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weifeng
 * @version $Id: ManageFolderAction.java, v 0.1 2017年03月10日 16:07  Exp $
 */
@Controller
@RequestMapping("/manage/folder")
public class ManageFolderController extends ManageBaseController{
    private static final Logger logger= Logger.getLogger(ManageBaseController.class);
    @Autowired
    private CmsProperties cmsProperties;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(@RequestParam(value = "folderId",defaultValue = "0") Long folderId,
                       @RequestParam(value = "p",defaultValue = "1") Integer pageNum,
                       ModelMap modelMap, HttpServletRequest request){
        LoggerUtil.info(logger,String.format("list folder: %d",folderId));
        //下拉标签相关信息
        List<FolderInfo> pathList=folderBizProcess
                .getFolderPathListByFolderId(folderId);
        //目录
        FolderInfo folderVo;
        if(folderId==0){
            folderVo=new FolderInfo();
            folderVo.setFolderId(0L);
            folderVo.setName("首页");
        }else {
            folderVo=folderBizProcess.queryFolderById(folderId);
        }
        //查询子目录,以5行为一页，可修改
        PageVo<FolderInfo> folderVoPageVo=folderBizProcess.queryFolderPageByFatherId(folderId,pageNum,5);
        Map<String,String> pageParam=new HashMap<>();
        pageParam.put("folderId",String.valueOf(folderId));
        folderVoPageVo.setArgs(pageParam);
        //返回
        modelMap.put("folderVoPageVo",folderVoPageVo);
        modelMap.put("folderVo",folderVo);
        modelMap.put("pathList",pathList);
        modelMap.put("folderName","");
        modelMap.put("folderEname","");
        modelMap.put("folderOrigin",new FolderInfo());
        AdminVo adminVo=manageAdminBizProcess.getAdminByName(cmsProperties.getAdmin());
        modelMap.put("folderAll",folderBizProcess.getAllFolderList(adminVo.getAdminId()));
        LoggerUtil.info(logger,String.format("return %d",folderId));
        return "/manage/folder/list";
    }

    /**
     * @author 目录排序
     *
     */
    @ResponseBody
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public JsonVo<String> sort(
            @RequestParam(value = "sortJson") String sortJson) {
        LoggerUtil.info(logger,sortJson);
        JsonVo<String> json = new JsonVo<>();
        JSONArray array = JSONArray.fromObject(sortJson);
        for (int i = 0; i < array.size(); i++) {
            JSONObject folder = array.getJSONObject(i);
            String folderId = folder.get("folderId").toString();
            String sort = folder.get("sort").toString();

            //排序不是整数
            if(!StringUtils.isNumeric(sort)){
                json.setMsg("排序请输入数字");
                json.setResult(false);
                LoggerUtil.info(logger,String.format("return fail,bad attr"));
                break;
            }
            IntegerValidator.getInstance().validate(sort);
            folderBizProcess.updateSort(Long.parseLong(folderId),
                    Long.parseLong(sort));
        }
        json.setResult(true);
        LoggerUtil.info(logger,String.format("return success"));
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public JsonVo<String>add(@ModelAttribute("folderOrigin")FolderInfo folderVo,ModelMap modelMap){
        LoggerUtil.info(logger,folderVo);
        JsonVo<String> json=new JsonVo<>();
        try {
            if(StringUtils.isBlank(folderVo.getName())){
                json.getErrors().put("name","目录名称不能为空");
            }
            if(StringUtils.isBlank(folderVo.getEname())){
                json.getErrors().put("ename","英文名称不能为空");
            }else if(!RegexUtils.isAlphaUnderline(folderVo.getEname())){
                json.getErrors().put("ename","只能是英文字母，数字和下划线");
            }else if(folderBizProcess.isQueryFolderByEname(folderVo.getEname())){
                json.getErrors().put("ename","英文名称不能重复");
            }
            validate(json);
            //保存目录
            folderVo.setPath("");
            folderVo.setSort(1L);
            folderBizProcess.addFolder(folderVo);
            json.setResult(true);
        } catch (ValidateException e) {
            e.printStackTrace();
            LoggerUtil.error(logger,e);
            json.setResult(false);
            json.setMsg(e.getMessage());
        }
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{folderId}",method = RequestMethod.POST)
    public JsonVo<String> delete(@PathVariable("folderId") long folderId){
        LoggerUtil.info(logger,folderId);
        JsonVo<String> json=new JsonVo<>();

        Long childNum=folderBizProcess.queryChildFolderNum(folderId);
        if(childNum==null || Long.compare(childNum,0)==0){
            Long count=manageArticleBizProcess.countArticleListByFolderIds(folderId);
            if(count!=null && count !=0){
                json.setResult(false);
                json.setMsg("此目录下还有文章,不能被删除。");
                LoggerUtil.info(logger,String.format("delete fail: %d has child article",folderId));
            }else{
                //删除目录
                folderBizProcess.deleteFolderById(folderId);
                //将相关目录权限删除
                adminFolderBizProcess.deleteByFolderId(folderId);
                json.setResult(true);
            }
        }else {
            json.setResult(false);
            json.setMsg("此目录下有子目录，不能删除。");
            LoggerUtil.info(logger,String.format("delete fail: %d has child folder",folderId));
        }
        LoggerUtil.info(logger,String.format("delete successful: %d",folderId));
        return json;
    }

    @RequestMapping(value = "/update")
    public String update(@RequestParam("folderId") Long folderId,ModelMap modelMap){
        FolderInfo folderVo=folderBizProcess.queryFolderById(folderId);
        modelMap.put("folderId",folderId);
        modelMap.put("name",folderVo.getName());
        modelMap.put("ename",folderVo.getEname());
        modelMap.put("fatherId",folderVo.getFatherId());
        modelMap.put("status",folderVo.getStatus());

        AdminVo adminVo=manageAdminBizProcess.getAdminByName(cmsProperties.getAdmin());

        modelMap.put("folderAll",folderBizProcess.getAllFolderList(adminVo.getAdminId()));
        return "/manage/folder/update";
    }

    @ResponseBody
    @RequestMapping(value = "/updateForm",method = RequestMethod.POST)
    public JsonVo<String> updateForm(@RequestParam("folderId") Long folderId,
                                     @RequestParam("name") String name,
                                     @RequestParam("ename") String ename,
                                     @RequestParam("fatherId") Long fatherId,
                                     @RequestParam("status") String status,
                                     @RequestParam("originEname") String originEname,
                                     ModelMap modelMap){
        LoggerUtil.info(logger,String.format("update form %d",folderId));
        JsonVo<String> json=new JsonVo<>();
        try {
            if(StringUtils.isBlank(name)){
                json.getErrors().put("name","目录名称不能为空");
            }
            if(StringUtils.isBlank(ename)){
                json.getErrors().put("ename","英文名称不能为空");
            }else if(!RegexUtils.isAlphaUnderline(ename)){
                json.getErrors().put("ename","只能是英文字母，数字和下划线");
            }else if(!StringUtils.equals(originEname,ename) && folderBizProcess.isQueryFolderByEname(ename)){
                json.getErrors().put("ename","英文名称不能重复");
            }
            validate(json);
            FolderInfo folderVo=new FolderInfo();
            folderVo.setFolderId(folderId);
            folderVo.setName(name);
            folderVo.setEname(ename);
            folderVo.setFatherId(fatherId);
            folderVo.setStatus(status);
            //更新目录
            folderBizProcess.update(folderVo);
            LoggerUtil.info(logger,String.format("update form success %d",folderId));
            json.setResult(true);
        } catch (ValidateException e) {
            e.printStackTrace();
            LoggerUtil.error(logger,e);
            LoggerUtil.info(logger,String.format("update form failed %d",folderId));
            json.setResult(false);
            json.setMsg(e.getMessage());
        }
        return json;
    }
}
