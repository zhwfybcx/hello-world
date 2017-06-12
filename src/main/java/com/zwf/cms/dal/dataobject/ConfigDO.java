package com.zwf.cms.dal.dataobject;

import java.util.Date;

/**
 * The table CONFIG
 */
public class ConfigDO{

    /**
     * configKey KEY.
     */
    private String configKey;
    /**
     * createtime 时间.
     */
    private Date createtime;
    /**
     * configValue 值.
     */
    private String configValue;
    /**
     * description 描述.
     */
    private String description;

    /**
     * Set configKey KEY.
     */
    public void setConfigKey(String configKey){
        this.configKey = configKey;
    }

    /**
     * Get configKey KEY.
     *
     * @return the string
     */
    public String getConfigKey(){
        return configKey;
    }

    /**
     * Set createtime 时间.
     */
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }

    /**
     * Get createtime 时间.
     *
     * @return the string
     */
    public Date getCreatetime(){
        return createtime;
    }

    /**
     * Set configValue 值.
     */
    public void setConfigValue(String configValue){
        this.configValue = configValue;
    }

    /**
     * Get configValue 值.
     *
     * @return the string
     */
    public String getConfigValue(){
        return configValue;
    }

    /**
     * Set description 描述.
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Get description 描述.
     *
     * @return the string
     */
    public String getDescription(){
        return description;
    }
}
