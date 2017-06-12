package com.zwf.cms.dal.mapper;

import com.zwf.cms.dal.dataobject.HeadlineDO;
import java.lang.Long;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于�?要对分页支持,请直接使用对应的DAO�?
 * The Table HEADLINE.
 * HEADLINE
 */
public interface HeadlineDOMapper{

    /**
     * desc:插入�?HEADLINE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO HEADLINE( URL ,NAME ,SORT ,PICTURE ,CREATETIME ,HEADLINEID )VALUES( #{url,jdbcType=VARCHAR} , #{name,jdbcType=VARCHAR} , #{sort,jdbcType=TINYINT} , #{picture,jdbcType=VARCHAR} , NOW() , #{headlineid,jdbcType=BIGINT} )
     * @param entity entity
     * @return Long
     */
    Long insert(HeadlineDO entity);
    /**
     * desc:更新�?HEADLINE.<br/>
     * descSql =  UPDATE HEADLINE SET URL = #{url,jdbcType=VARCHAR} ,NAME = #{name,jdbcType=VARCHAR} ,SORT = #{sort,jdbcType=TINYINT} ,PICTURE = #{picture,jdbcType=VARCHAR} WHERE HEADLINEID = #{headlineid,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(HeadlineDO entity);
    /**
     * desc:根据主键删除数据:HEADLINE.<br/>
     * descSql =  DELETE FROM HEADLINE WHERE HEADLINEID = #{headlineid,jdbcType=BIGINT}
     * @param headlineid headlineid
     * @return Long
     */
    Long deleteByPrimary(Long headlineid);
    /**
     * desc:根据主键获取数据:HEADLINE.<br/>
     * descSql =  SELECT * FROM HEADLINE WHERE HEADLINEID = #{headlineid,jdbcType=BIGINT}
     * @param headlineid headlineid
     * @return HeadlineDO
     */
    HeadlineDO getByPrimary(Long headlineid);
    /**
     * desc:根据获取总数数据:HEADLINE.<br/>
     * descSql =  SELECT COUNT(*) FROM HEADLINE
     * @return Long
     */
    Long getByCount();
    /**
     * desc:根据获取分页数据:HEADLINE.<br/>
     * descSql =  SELECT * FROM HEADLINE ORDER BY HEADLINEID DESC LIMIT #{offset,jdbcType=BIGINT},#{rows,jdbcType=BIGINT}
     * @param offset offset
     * @param rows rows
     * @return List<HeadlineDO>
     */
    List<HeadlineDO> getHeadlineList(@Param("offset")Long offset,@Param("rows")Long rows);
    /**
     * desc:根据获取分页数据:HEADLINE.<br/>
     * descSql =  SELECT * FROM HEADLINE ORDER BY HEADLINEID DESC
     * @return List<HeadlineDO>
     */
    List<HeadlineDO> getHeadAllList();
}
