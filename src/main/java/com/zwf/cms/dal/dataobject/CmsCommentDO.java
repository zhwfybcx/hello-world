package com.zwf.cms.dal.dataobject;

import java.util.Date;

/**
 * The table CMS_COMMENT
 */
public class CmsCommentDO{

    /**
     * ip 地址.
     */
    private String ip;
    /**
     * name 评论名称.
     */
    private String name;
    /**
     * status 评论状态.
     */
    private String status;
    /**
     * userid 用户ID.
     */
    private Long userid;
    /**
     * content 评论内容.
     */
    private String content;
    /**
     * articleid 文章ID.
     */
    private Long articleid;
    /**
     * commentid 评论ID.
     */
    private Long commentid;
    /**
     * createtime 创建时间.
     */
    private Date createtime;

    /**
     * Set ip 地址.
     */
    public void setIp(String ip){
        this.ip = ip;
    }

    /**
     * Get ip 地址.
     *
     * @return the string
     */
    public String getIp(){
        return ip;
    }

    /**
     * Set name 评论名称.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name 评论名称.
     *
     * @return the string
     */
    public String getName(){
        return name;
    }

    /**
     * Set status 评论状态.
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * Get status 评论状态.
     *
     * @return the string
     */
    public String getStatus(){
        return status;
    }

    /**
     * Set userid 用户ID.
     */
    public void setUserid(Long userid){
        this.userid = userid;
    }

    /**
     * Get userid 用户ID.
     *
     * @return the string
     */
    public Long getUserid(){
        return userid;
    }

    /**
     * Set content 评论内容.
     */
    public void setContent(String content){
        this.content = content;
    }

    /**
     * Get content 评论内容.
     *
     * @return the string
     */
    public String getContent(){
        return content;
    }

    /**
     * Set articleid 文章ID.
     */
    public void setArticleid(Long articleid){
        this.articleid = articleid;
    }

    /**
     * Get articleid 文章ID.
     *
     * @return the string
     */
    public Long getArticleid(){
        return articleid;
    }

    /**
     * Set commentid 评论ID.
     */
    public void setCommentid(Long commentid){
        this.commentid = commentid;
    }

    /**
     * Get commentid 评论ID.
     *
     * @return the string
     */
    public Long getCommentid(){
        return commentid;
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
}
