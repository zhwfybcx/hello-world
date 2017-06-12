/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.biz.process;

import com.zwf.cms.dal.dataobject.AdminDO;
import com.zwf.cms.exception.AuthException;
import com.zwf.cms.web.model.AdminVo;
import com.zwf.cms.web.model.PageVo;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 用户管理Biz层
 * @author weifeng
 * @version $Id: ManageAdminBizProcess.java, v 0.1 2017年03月09日 下午3:08  Exp $
 */
public interface ManageAdminBizProcess {

    public AdminDO addAdmin(String name, String password) throws AuthException;

    /**
     * 删除管理员
     *
     * @param adminId
     * @return Integer
     */
    public long deleteAdmin(long adminId);

    /**
     * 修改管理员资料
     *
     * @param adminId
     * @param password
     * @return AdminDO
     * @throws AuthException
     */

    public void updateAdminByAmdinId(AdminVo adminVo) throws AuthException;

    /**
     * 管理员登陆
     *
     * @param password
     * @param request
     * @throws IOException
     */
    public void adminLogin(String name, String password,
                           HttpServletRequest request) throws AuthException, IOException;

    /**
     * 通过Id获得指定管理员资料
     */
    AdminVo getAdminById(long adminId);

    /**
     * 获得所有管理员的分页数据
     *
     * @param offset
     * @param rows
     * @return List<AdminDO>
     */
    public List<AdminDO> getAllList(long offset, long rows);

    /**
     * 获得所有管理员的数量
     *
     * @return Integer
     */
    public int getAllListCount();

    /**
     *
     * @param pageNum
     * @return
     */
    public PageVo<AdminDO> getPageListPage(int pageNum);

    /**
     * 通过email获得管理员资料
     *
     * @return AdminDO
     */
    public AdminVo getAdminByName(String name);

    public long getSuperAdminId();

    public List<AdminVo> getAllList();
}
