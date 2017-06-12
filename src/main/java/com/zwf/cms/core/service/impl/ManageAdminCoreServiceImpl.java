/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.core.service.impl;


import com.zwf.cms.core.service.ManageAdminCoreService;
import com.zwf.cms.dal.dao.AdminDAO;
import com.zwf.cms.dal.dataobject.AdminDO;
import com.zwf.cms.exception.AuthException;
import com.zwf.cms.model.AdminVoConvertor;
import com.zwf.cms.model.CmsProperties;
import com.zwf.cms.util.MD5Util;
import com.zwf.cms.web.model.AdminVo;
import com.zwf.cms.web.model.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 用户管理的核心逻辑层
 * @author weifeng
 * @version $Id: ManageAdminCoreServiceImp.java, v 0.1 2017年03月09日 下午2:32  Exp $
 */
@Service
public class ManageAdminCoreServiceImpl implements ManageAdminCoreService {

    @Autowired
    private AdminDAO adminDAO;

/*    @Autowired
    private CustomPropertyConfigurer propertyConfigurer;*/

    @Autowired
    private CmsProperties cmsProperties;

    /**
     * 增加管理员
     * @param name
     * @param password
     * @return
     */
    public AdminVo addAdmin(String name, String password) throws AuthException {
        AdminDO adminDO = new AdminDO();
        adminDO.setName(name);
        adminDO.setPassword(MD5Util.getMD5String(password));
        adminDAO.insert(adminDO);
        return AdminVoConvertor.convertToAdminVo(adminDO);
    }

    /**
     * 删除管理员
     * @param adminId
     * @return
     */
    public long deleteAdmin(long adminId) {
        return adminDAO.deleteByPrimary(adminId);
    }

    /**
     * 更新管理员信息
     * @param adminVo
     */
    public void updateAdminByAmdinId(AdminVo adminVo) {
        //生成密文密码,使用core包中MD5
        AdminDO adminDO = AdminVoConvertor.convertToAdminResultDo(adminVo);
        adminDAO.update(adminDO);
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
        AdminVo adminVo = (AdminVo) adminDAO.getByName(name);
        if (adminVo == null) {
            throw new AuthException("邮箱或密码错误");
        }

        String loginPassword = MD5Util.getMD5String(password);
        if (loginPassword.equals(adminVo.getPassword())) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(2592000);
            //这里为什么要setPasswod？
            adminVo.setPassword("");
            if (name.equals(cmsProperties.getAdmin())) {
                adminVo.setAdmin(true);
            } else {
                adminVo.setAdmin(false);
            }
        } else {
            throw new AuthException("邮箱或密码错误");
        }
    }

    /**
     * 通过Id获得指定管理员资料
     */
    public AdminVo getAdminById(long adminId) {

        AdminVo adminVo=AdminVoConvertor.convertToAdminVo(adminDAO.getByPrimary(adminId));
        return adminVo;
    }

    @Override
    public List<AdminDO> getPartList(long offset, long rows) {
        return null;
    }

    /**
     * 获得所有管理员的分页数据
     *
     * @param offset
     * @param rows
     * @return List<AdminDO>
     */
    public List<AdminDO> getAllList(long offset, long rows) {
        return adminDAO.getPartList(offset, rows);
    }

    /**
     * 获得所有管理员的数量
     * @return
     */
    public int getAllListCount() {
        return adminDAO.getAllListCount();
    }

    /**
     * 获得所有管理员的分页
     * @return PageVo<AdminDO>
     */
    public PageVo<AdminDO> getAllListPage(int pageNum) {
        PageVo<AdminDO> pageVo = new PageVo<AdminDO>(pageNum);
        pageVo.setRows(20);
        List<AdminDO> list = this.getAllList(pageVo.getOffset(), pageVo.getRows());
        pageVo.setList(list);
        pageVo.setCount(this.getAllListCount());
        return pageVo;
    }

    /**
     * 通过email获得管理员资料
     *
     * @return AdminDO
     */
    public AdminVo getAdminByName(String name) {
        return AdminVoConvertor.convertToAdminVo(adminDAO.getByName(name));
    }

    public long getSuperAdminId() {

        AdminDO admin = getAdminByName(cmsProperties.getAdmin());
        return admin.getAdminId();
    }

    @Override
    public List<AdminVo> getAllList() {
        return AdminVoConvertor.convertList(adminDAO.getAllList());
    }
}
