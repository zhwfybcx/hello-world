package com.zwf.cms.dal.dataobject;

import java.util.Date;

/**
 * The table RESOURCE
 */
public class ResourceDO{

    /**
     * id 主键.
     */
    private Long id;
    /**
     * title 标题.
     */
    private String title;
    /**
     * typeId 类型.
     */
    private String typeId;
    /**
     * content 内容.
     */
    private String content;
    /**
     * createTime 创建时间.
     */
    private Date createTime;

    /**
     * Set id 主键.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id 主键.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set title 标题.
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Get title 标题.
     *
     * @return the string
     */
    public String getTitle(){
        return title;
    }

    /**
     * Set typeId 类型.
     */
    public void setTypeId(String typeId){
        this.typeId = typeId;
    }

    /**
     * Get typeId 类型.
     *
     * @return the string
     */
    public String getTypeId(){
        return typeId;
    }

    /**
     * Set content 内容.
     */
    public void setContent(String content){
        this.content = content;
    }

    /**
     * Get content 内容.
     *
     * @return the string
     */
    public String getContent(){
        return content;
    }

    /**
     * Set createTime 创建时间.
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * Get createTime 创建时间.
     *
     * @return the string
     */
    public Date getCreateTime(){
        return createTime;
    }
}
