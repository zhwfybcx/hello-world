package com.zwf.cms.dal.mapper;

import com.zwf.cms.dal.dataobject.ResourceDO;
import org.apache.ibatis.annotations.Param;

/**
 * 由于�?要对分页支持,请直接使用对应的DAO�?
 * The Table RESOURCE.
 * RESOURCE
 */
public interface ResourceDOMapper{

    /**
     * desc:插入�?:RESOURCE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO RESOURCE( ID ,TITLE ,TYPE_ID ,CONTENT ,CREATE_TIME )VALUES( #{id,jdbcType=BIGINT} , #{title,jdbcType=VARCHAR} , #{typeId,jdbcType=VARCHAR} , #{content,jdbcType=LONGVARCHAR} , #{createTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    Long insert(ResourceDO entity);
    /**
     * desc:更新�?:RESOURCE.<br/>
     * descSql =  UPDATE RESOURCE SET TITLE = #{title,jdbcType=VARCHAR} ,TYPE_ID = #{typeId,jdbcType=VARCHAR} ,CONTENT = #{content,jdbcType=LONGVARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(ResourceDO entity);
    /**
     * desc:根据主键删除数据:RESOURCE.<br/>
     * descSql =  DELETE FROM RESOURCE WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Long id);
    /**
     * desc:根据主键获取数据:RESOURCE.<br/>
     * descSql =  SELECT * FROM RESOURCE WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return ResourceDO
     */
    ResourceDO getByPrimary(Long id);
}
