package com.zwf.cms.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zwf.cms.dal.dataobject.ResourceDO;
import com.zwf.cms.dal.mapper.ResourceDOMapper;

/**
* The Table RESOURCE.
* RESOURCE
*/
@Repository
public class ResourceDAO{

    @Autowired
    private ResourceDOMapper resourceDOMapper;

    /**
     * desc:插入�?:RESOURCE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO RESOURCE( ID ,TITLE ,TYPE_ID ,CONTENT ,CREATE_TIME )VALUES( #{id,jdbcType=BIGINT} , #{title,jdbcType=VARCHAR} , #{typeId,jdbcType=VARCHAR} , #{content,jdbcType=LONGVARCHAR} , #{createTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    public Long insert(ResourceDO entity){
        return resourceDOMapper.insert(entity);
    }
    /**
     * desc:更新�?:RESOURCE.<br/>
     * descSql =  UPDATE RESOURCE SET TITLE = #{title,jdbcType=VARCHAR} ,TYPE_ID = #{typeId,jdbcType=VARCHAR} ,CONTENT = #{content,jdbcType=LONGVARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(ResourceDO entity){
        return resourceDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:RESOURCE.<br/>
     * descSql =  DELETE FROM RESOURCE WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return Long
     */
    public Long deleteByPrimary(Long id){
        return resourceDOMapper.deleteByPrimary(id);
    }
    /**
     * desc:根据主键获取数据:RESOURCE.<br/>
     * descSql =  SELECT * FROM RESOURCE WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return ResourceDO
     */
    public ResourceDO getByPrimary(Long id){
        return resourceDOMapper.getByPrimary(id);
    }
}
