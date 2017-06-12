package com.zwf.cms.dal.dataobject;

import java.util.Date;

/**
 * The table ARTICLE
 */
public class ArticleDO{

    /**
     * path PATH.
     */
    private String path;
    /**
     * title 文件名称.
     */
    private String title;
    /**
     * picurl PICURL.
     */
    private String picurl;
    /**
     * status 状态：0 隐藏 1 显示.
     */
    private String status;
    /**
     * adminid 管理员ID.
     */
    private Long adminid;
    /**
     * checkif CHECKIF.
     */
    private String checkif;
    /**
     * content 文件内容.
     */
    private String content;
    /**
     * picture PICTURE.
     */
    private String picture;
    /**
     * summary SUMMARY.
     */
    private String summary;
    /**
     * folderid FOLDERID.
     */
    private Long folderid;
    /**
     * articleid 文件ID.
     */
    private Long articleid;
    /**
     * viewcount 浏览数.
     */
    private Integer viewcount;
    /**
     * articleurl ARTICLEURL.
     */
    private String articleurl;
    /**
     * createtime 创建时间.
     */
    private Date createtime;
    /**
     * updatetime 更新时间.
     */
    private Date updatetime;
    /**
     * commentcount 评论数.
     */
    private Integer commentcount;

    /**
     * Set path PATH.
     */
    public void setPath(String path){
        this.path = path;
    }

    /**
     * Get path PATH.
     *
     * @return the string
     */
    public String getPath(){
        return path;
    }

    /**
     * Set title 文件名称.
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Get title 文件名称.
     *
     * @return the string
     */
    public String getTitle(){
        return title;
    }

    /**
     * Set picurl PICURL.
     */
    public void setPicurl(String picurl){
        this.picurl = picurl;
    }

    /**
     * Get picurl PICURL.
     *
     * @return the string
     */
    public String getPicurl(){
        return picurl;
    }

    /**
     * Set status 状态：0 隐藏 1 显示.
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * Get status 状态：0 隐藏 1 显示.
     *
     * @return the string
     */
    public String getStatus(){
        return status;
    }

    /**
     * Set adminid 管理员ID.
     */
    public void setAdminid(Long adminid){
        this.adminid = adminid;
    }

    /**
     * Get adminid 管理员ID.
     *
     * @return the string
     */
    public Long getAdminid(){
        return adminid;
    }

    /**
     * Set checkif CHECKIF.
     */
    public void setCheckif(String checkif){
        this.checkif = checkif;
    }

    /**
     * Get checkif CHECKIF.
     *
     * @return the string
     */
    public String getCheckif(){
        return checkif;
    }

    /**
     * Set content 文件内容.
     */
    public void setContent(String content){
        this.content = content;
    }

    /**
     * Get content 文件内容.
     *
     * @return the string
     */
    public String getContent(){
        return content;
    }

    /**
     * Set picture PICTURE.
     */
    public void setPicture(String picture){
        this.picture = picture;
    }

    /**
     * Get picture PICTURE.
     *
     * @return the string
     */
    public String getPicture(){
        return picture;
    }

    /**
     * Set summary SUMMARY.
     */
    public void setSummary(String summary){
        this.summary = summary;
    }

    /**
     * Get summary SUMMARY.
     *
     * @return the string
     */
    public String getSummary(){
        return summary;
    }

    /**
     * Set folderid FOLDERID.
     */
    public void setFolderid(Long folderid){
        this.folderid = folderid;
    }

    /**
     * Get folderid FOLDERID.
     *
     * @return the string
     */
    public Long getFolderid(){
        return folderid;
    }

    /**
     * Set articleid 文件ID.
     */
    public void setArticleid(Long articleid){
        this.articleid = articleid;
    }

    /**
     * Get articleid 文件ID.
     *
     * @return the string
     */
    public Long getArticleid(){
        return articleid;
    }

    /**
     * Set viewcount 浏览数.
     */
    public void setViewcount(Integer viewcount){
        this.viewcount = viewcount;
    }

    /**
     * Get viewcount 浏览数.
     *
     * @return the string
     */
    public Integer getViewcount(){
        return viewcount;
    }

    /**
     * Set articleurl ARTICLEURL.
     */
    public void setArticleurl(String articleurl){
        this.articleurl = articleurl;
    }

    /**
     * Get articleurl ARTICLEURL.
     *
     * @return the string
     */
    public String getArticleurl(){
        return articleurl;
    }

    /**
     * Set createtime 创建时间.
     */
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }

    /**
     * Get createtime 创建时间.
     *
     * @return the string
     */
    public Date getCreatetime(){
        return createtime;
    }

    /**
     * Set updatetime 更新时间.
     */
    public void setUpdatetime(Date updatetime){
        this.updatetime = updatetime;
    }

    /**
     * Get updatetime 更新时间.
     *
     * @return the string
     */
    public Date getUpdatetime(){
        return updatetime;
    }

    /**
     * Set commentcount 评论数.
     */
    public void setCommentcount(Integer commentcount){
        this.commentcount = commentcount;
    }

    /**
     * Get commentcount 评论数.
     *
     * @return the string
     */
    public Integer getCommentcount(){
        return commentcount;
    }
}
