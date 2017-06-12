package com.zwf.cms.dal.dataobject;

import java.util.Date;

/**
 * The table HEADLINE
 */
public class HeadlineDO{

    /**
     * url URL.
     */
    private String url;
    /**
     * name NAME.
     */
    private String name;
    /**
     * sort SORT.
     */
    private Integer sort;
    /**
     * channel CHANNEL.
     */
    private String channel;
    /**
     * picture PICTURE.
     */
    private String picture;
    /**
     * summary SUMMARY.
     */
    private String summary;
    /**
     * createtime CREATETIME.
     */
    private Date createtime;
    /**
     * headlineid HEADLINEID.
     */
    private Long headlineid;

    /**
     * Set url URL.
     */
    public void setUrl(String url){
        this.url = url;
    }

    /**
     * Get url URL.
     *
     * @return the string
     */
    public String getUrl(){
        return url;
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
     * Set sort SORT.
     */
    public void setSort(Integer sort){
        this.sort = sort;
    }

    /**
     * Get sort SORT.
     *
     * @return the string
     */
    public Integer getSort(){
        return sort;
    }

    /**
     * Set channel CHANNEL.
     */
    public void setChannel(String channel){
        this.channel = channel;
    }

    /**
     * Get channel CHANNEL.
     *
     * @return the string
     */
    public String getChannel(){
        return channel;
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

    /**
     * Set headlineid HEADLINEID.
     */
    public void setHeadlineid(Long headlineid){
        this.headlineid = headlineid;
    }

    /**
     * Get headlineid HEADLINEID.
     *
     * @return the string
     */
    public Long getHeadlineid(){
        return headlineid;
    }
}
