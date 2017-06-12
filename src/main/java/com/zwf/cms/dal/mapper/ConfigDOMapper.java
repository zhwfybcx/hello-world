package com.zwf.cms.dal.mapper;

import com.zwf.cms.dal.dataobject.ConfigDO;
import org.apache.ibatis.annotations.Param;

/**
 * 由于�?要对分页支持,请直接使用对应的DAO�?
 * The Table CONFIG.
 * CONFIG
 */
public interface ConfigDOMapper{

    /**
     * desc:插入�?:CONFIG.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO CONFIG( CONFIG_KEY ,CREATETIME ,CONFIG_VALUE ,DESCRIPTION )VALUES( #{configKey,jdbcType=VARCHAR} , #{createtime,jdbcType=TIMESTAMP} , #{configValue,jdbcType=VARCHAR} , #{description,jdbcType=LONGVARCHAR} )
     * @param entity entity
     * @return Long
     */
    Long insert(ConfigDO entity);
    /**
     * desc:更新�?:CONFIG.<br/>
     * descSql =  UPDATE CONFIG SET CREATETIME = #{createtime,jdbcType=TIMESTAMP} ,CONFIG_VALUE = #{configValue,jdbcType=VARCHAR} ,DESCRIPTION = #{description,jdbcType=LONGVARCHAR} WHERE CONFIG_KEY = #{configKey,jdbcType=VARCHAR}
     * @param entity entity
     * @return Long
     */
    Long update(ConfigDO entity);
    /**
     * desc:根据主键删除数据:CONFIG.<br/>
     * descSql =  DELETE FROM CONFIG WHERE CONFIG_KEY = #{configKey,jdbcType=VARCHAR}
     * @param configKey configKey
     * @return Long
     */
    Long deleteByPrimary(String configKey);
    /**
     * desc:根据主键获取数据:CONFIG.<br/>
     * descSql =  SELECT * FROM CONFIG WHERE CONFIG_KEY = #{configKey,jdbcType=VARCHAR}
     * @param configKey configKey
     * @return ConfigDO
     */
    ConfigDO getByPrimary(String configKey);
}
