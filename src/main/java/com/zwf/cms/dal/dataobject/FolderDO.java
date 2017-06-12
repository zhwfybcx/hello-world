package com.zwf.cms.dal.dataobject;

import java.util.Date;

/**
 * The table FOLDER
 */
public class FolderDO{

    /**
     * name 中文名.
     */
    private String name;
    /**
     * path 路径.
     */
    private String path;
    /**
     * sort SORT.
     */
    private Long sort;
    /**
     * ename 英文名.
     */
    private String ename;
    /**
     * level LEVEL.
     */
    private Long level;
    /**
     * status 状态：0 隐藏 1 现实.
     */
    private String status;
    /**
     * fatherId FATHER_ID.
     */
    private Long fatherId;
    /**
     * folderId FOLDER_ID.
     */
    private Long folderId;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * updateTime UPDATE_TIME.
     */
    private Date updateTime;

    /**
     * Set name 中文名.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name 中文名.
     *
     * @return the string
     */
    public String getName(){
        return name;
    }

    /**
     * Set path 路径.
     */
    public void setPath(String path){
        this.path = path;
    }

    /**
     * Get path 路径.
     *
     * @return the string
     */
    public String getPath(){
        return path;
    }

    /**
     * Set sort SORT.
     */
    public void setSort(Long sort){
        this.sort = sort;
    }

    /**
     * Get sort SORT.
     *
     * @return the string
     */
    public Long getSort(){
        return sort;
    }

    /**
     * Set ename 英文名.
     */
    public void setEname(String ename){
        this.ename = ename;
    }

    /**
     * Get ename 英文名.
     *
     * @return the string
     */
    public String getEname(){
        return ename;
    }

    /**
     * Set level LEVEL.
     */
    public void setLevel(Long level){
        this.level = level;
    }

    /**
     * Get level LEVEL.
     *
     * @return the string
     */
    public Long getLevel(){
        return level;
    }

    /**
     * Set status 状态：0 隐藏 1 现实.
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * Get status 状态：0 隐藏 1 现实.
     *
     * @return the string
     */
    public String getStatus(){
        return status;
    }

    /**
     * Set fatherId FATHER_ID.
     */
    public void setFatherId(Long fatherId){
        this.fatherId = fatherId;
    }

    /**
     * Get fatherId FATHER_ID.
     *
     * @return the string
     */
    public Long getFatherId(){
        return fatherId;
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
