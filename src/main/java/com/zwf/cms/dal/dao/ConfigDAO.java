package com.zwf.cms.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zwf.cms.dal.dataobject.ConfigDO;
import com.zwf.cms.dal.mapper.ConfigDOMapper;

/**
* The Table CONFIG.
* CONFIG
*/
@Repository
public class ConfigDAO{

    @Autowired
    private ConfigDOMapper configDOMapper;

    /**
     * desc:插入�?:CONFIG.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO CONFIG( CONFIG_KEY ,CREATETIME ,CONFIG_VALUE ,DESCRIPTION )VALUES( #{configKey,jdbcType=VARCHAR} , #{createtime,jdbcType=TIMESTAMP} , #{configValue,jdbcType=VARCHAR} , #{description,jdbcType=LONGVARCHAR} )
     * @param entity entity
     * @return Long
     */
    public Long insert(ConfigDO entity){
        return configDOMapper.insert(entity);
    }
    /**
     * desc:更新�?:CONFIG.<br/>
     * descSql =  UPDATE CONFIG SET CREATETIME = #{createtime,jdbcType=TIMESTAMP} ,CONFIG_VALUE = #{configValue,jdbcType=VARCHAR} ,DESCRIPTION = #{description,jdbcType=LONGVARCHAR} WHERE CONFIG_KEY = #{configKey,jdbcType=VARCHAR}
     * @param entity entity
     * @return Long
     */
    public Long update(ConfigDO entity){
        return configDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:CONFIG.<br/>
     * descSql =  DELETE FROM CONFIG WHERE CONFIG_KEY = #{configKey,jdbcType=VARCHAR}
     * @param configKey configKey
     * @return Long
     */
    public Long deleteByPrimary(String configKey){
        return configDOMapper.deleteByPrimary(configKey);
    }
    /**
     * desc:根据主键获取数据:CONFIG.<br/>
     * descSql =  SELECT * FROM CONFIG WHERE CONFIG_KEY = #{configKey,jdbcType=VARCHAR}
     * @param configKey configKey
     * @return ConfigDO
     */
    public ConfigDO getByPrimary(String configKey){
        return configDOMapper.getByPrimary(configKey);
    }
}
