package com.zwf.cms.dal.dataobject;

import java.util.Date;

/**
 * The table ADMIN_FOLDER
 */
public class AdminFolderDO{

    /**
     * adminId ADMIN_ID.
     */
    private Long adminId;
    /**
     * folderId FOLDER_ID.
     */
    private Long folderId;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;

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
     * Set folderId FOLDER_ID.
     */
    public void setFolderId(Long folderId){
        this.folderId = folderId;
    }

    /**
     * Get folderId FOLDER_ID.
     *
     * @return the string
     */
    public Long getFolderId(){
        return folderId;
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
}
