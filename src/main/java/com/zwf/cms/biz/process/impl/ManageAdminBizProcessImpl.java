/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.biz.process.impl;


import com.zwf.cms.biz.process.ManageAdminBizProcess;
import com.zwf.cms.core.service.ManageAdminCoreService;
import com.zwf.cms.dal.dataobject.AdminDO;
import com.zwf.cms.exception.AuthException;
import com.zwf.cms.web.model.AdminVo;
import com.zwf.cms.web.model.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author weifeng
 * @version $Id: ManageAdminBizProcess.java, v 0.1 2017年03月09日 下午15:08 qlD Exp $
 */
@Service
public class ManageAdminBizProcessImpl implements ManageAdminBizProcess {

    @Autowired
    ManageAdminCoreService manageAdminCoreService;

    /**
     *
     * @param name
     * @param password
     * @return
     * @throws AuthException
     */
    public AdminDO addAdmin(String name, String password) throws AuthException {
        return manageAdminCoreService.addAdmin(name, password);
    }

    /**
     * 删除管理员
     *
     * @param adminId
     * @return Integer
     */
    public long deleteAdmin(long adminId) {
        return manageAdminCoreService.deleteAdmin(adminId);
    }

    /**
     * 修改管理员资料
     *
     * @return AdminDO
     * @throws AuthException
     */

    public void updateAdminByAmdinId(AdminVo adminVo) throws AuthException {
        manageAdminCoreService.updateAdminByAmdinId(adminVo);
    }

    /**
     * 管理员登陆
     *
     * @param password
     * @param request
     * @throws IOException
     */
    public void adminLogin(String name, String password,
                           HttpServletRequest request) throws AuthException, IOException {
        manageAdminCoreService.adminLogin(name,password,request);
    }

    /**
     * 通过Id获得指定管理员资料
     */
    public AdminVo getAdminById(long adminId) {
        return manageAdminCoreService.getAdminById(adminId);
    }

    @Override
    public List<AdminDO> getAllList(long offset, long rows) {
        return null;
    }

    /**
     * 获得所有管理员的数量
     *
     * @return Integer
     */
    public int getAllListCount() {
        return manageAdminCoreService.getAllListCount();
    }

    @Override
    public PageVo<AdminDO> getPageListPage(int pageNum) {
        return null;
    }

    /**
     *
     * @param pageNum
     * @return
     */
    public PageVo<AdminDO> getAllListPage(int pageNum) {
        return manageAdminCoreService.getAllListPage(pageNum);
    }

    /**
     * 通过email获得管理员资料
     *
     * @return AdminDO
     */
    public AdminVo getAdminByName(String name) {
        return manageAdminCoreService.getAdminByName(name);
    }

    public long getSuperAdminId() {
        return manageAdminCoreService.getSuperAdminId();
    }

    @Override
    public List<AdminVo> getAllList() {
        return manageAdminCoreService.getAllList();
    }
}
