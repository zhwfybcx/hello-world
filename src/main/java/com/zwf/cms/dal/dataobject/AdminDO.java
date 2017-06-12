package com.zwf.cms.dal.dataobject;

import java.util.Date;

/**
 * The table ADMIN
 */
public class AdminDO{

    /**
     * name 管理员名称.
     */
    private String name;
    /**
     * adminId ADMIN_ID.
     */
    private Long adminId;
    /**
     * password 密码 MD5加密.
     */
    private String password;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * updateTime UPDATE_TIME.
     */
    private Date updateTime;

    /**
     * Set name 管理员名称.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name 管理员名称.
     *
     * @return the string
     */
    public String getName(){
        return name;
    }

    /**
     * Set adminId ADMIN_ID.
     */
    public void setAdminId(Long adminId){
        this.adminId = adminId;
    }

    /**
     * Get adminId ADMIN_ID.
     *
     * @return the string
     */
    public Long getAdminId(){
        return adminId;
    }

    /**
     * Set password 密码 MD5加密.
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * Get password 密码 MD5加密.
     *
     * @return the string
     */
    public String getPassword(){
        return password;
    }

    /**
     * Set createTime CREATE_TIME.
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * Get createTime CREATE_TIME.
     *
     * @return the string
     */
    public Date getCreateTime(){
        return createTime;
    }

    /**
     * Set updateTime UPDATE_TIME.
     */
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    /**
     * Get updateTime UPDATE_TIME.
     *
     * @return the string
     */
    public Date getUpdateTime(){
        return updateTime;
    }
}
