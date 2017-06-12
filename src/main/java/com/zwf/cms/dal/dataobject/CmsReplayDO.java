package com.zwf.cms.dal.dataobject;

import java.util.Date;

/**
 * The table CMS_REPLAY
 */
public class CmsReplayDO{

    /**
     * ip IP.
     */
    private String ip;
    /**
     * name NAME.
     */
    private String name;
    /**
     * userid USERID.
     */
    private Long userid;
    /**
     * content CONTENT.
     */
    private String content;
    /**
     * replyid REPLYID.
     */
    private Long replyid;
    /**
     * commentid COMMENTID.
     */
    private Long commentid;
    /**
     * createtime CREATETIME.
     */
    private Date createtime;

    /**
     * Set ip IP.
     */
    public void setIp(String ip){
        this.ip = ip;
    }

    /**
     * Get ip IP.
     *
     * @return the string
     */
    public String getIp(){
        return ip;
    }

    /**
     * Set name NAME.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name NAME.
     *
     * @return the string
     */
    public String getName(){
        return name;
    }

    /**
     * Set userid USERID.
     */
    public void setUserid(Long userid){
        this.userid = userid;
    }

    /**
     * Get userid USERID.
     *
     * @return the string
     */
    public Long getUserid(){
        return userid;
    }

    /**
     * Set content CONTENT.
     */
    public void setContent(String content){
        this.content = content;
    }

    /**
     * Get content CONTENT.
     *
     * @return the string
     */
    public String getContent(){
        return content;
    }

    /**
     * Set replyid REPLYID.
     */
    public void setReplyid(Long replyid){
        this.replyid = replyid;
    }

    /**
     * Get replyid REPLYID.
     *
     * @return the string
     */
    public Long getReplyid(){
        return replyid;
    }

    /**
     * Set commentid COMMENTID.
     */
    public void setCommentid(Long commentid){
        this.commentid = commentid;
    }

    /**
     * Get commentid COMMENTID.
     *
     * @return the string
     */
    public Long getCommentid(){
        return commentid;
    }

    /**
     * Set createtime CREATETIME.
     */
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }

    /**
     * Get createtime CREATETIME.
     *
     * @return the string
     */
    public Date getCreatetime(){
        return createtime;
    }
}
