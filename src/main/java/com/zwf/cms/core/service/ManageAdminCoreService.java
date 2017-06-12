/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.core.service;


import com.zwf.cms.dal.dataobject.AdminDO;
import com.zwf.cms.exception.AuthException;
import com.zwf.cms.web.model.AdminVo;
import com.zwf.cms.web.model.PageVo;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author weifeng
 * @version $Id: ManageAdminCoreService.java, v 0.1 2017年03月09日 下午2:47  Exp $
 */
public interface ManageAdminCoreService {

    AdminDO addAdmin(String name, String password) throws AuthException;

    long deleteAdmin(long adminId);

    void updateAdminByAmdinId(AdminVo adminVo);

    void adminLogin(String name, String password, HttpServletRequest request) throws AuthException,
                                                                              IOException;

    AdminVo getAdminById(long adminId);

    List<AdminDO> getPartList(long offset, long rows);

    int getAllListCount();

    PageVo<AdminDO> getAllListPage(int pageNum);

    AdminVo getAdminByName(String name);

    long getSuperAdminId();

    List<AdminVo> getAllList();
}
