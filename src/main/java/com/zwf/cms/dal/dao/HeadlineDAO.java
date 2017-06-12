package com.zwf.cms.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zwf.cms.dal.dataobject.HeadlineDO;
import java.lang.Long;
import java.util.List;
import com.zwf.cms.dal.mapper.HeadlineDOMapper;

/**
* The Table HEADLINE.
* HEADLINE
*/
@Repository
public class HeadlineDAO{

    @Autowired
    private HeadlineDOMapper headlineDOMapper;

    /**
     * desc:插入�?HEADLINE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO HEADLINE( URL ,NAME ,SORT ,PICTURE ,CREATETIME ,HEADLINEID )VALUES( #{url,jdbcType=VARCHAR} , #{name,jdbcType=VARCHAR} , #{sort,jdbcType=TINYINT} , #{picture,jdbcType=VARCHAR} , NOW() , #{headlineid,jdbcType=BIGINT} )
     * @param entity entity
     * @return Long
     */
    public Long insert(HeadlineDO entity){
        return headlineDOMapper.insert(entity);
    }
    /**
     * desc:更新�?HEADLINE.<br/>
     * descSql =  UPDATE HEADLINE SET URL = #{url,jdbcType=VARCHAR} ,NAME = #{name,jdbcType=VARCHAR} ,SORT = #{sort,jdbcType=TINYINT} ,PICTURE = #{picture,jdbcType=VARCHAR} WHERE HEADLINEID = #{headlineid,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(HeadlineDO entity){
        return headlineDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:HEADLINE.<br/>
     * descSql =  DELETE FROM HEADLINE WHERE HEADLINEID = #{headlineid,jdbcType=BIGINT}
     * @param headlineid headlineid
     * @return Long
     */
    public Long deleteByPrimary(Long headlineid){
        return headlineDOMapper.deleteByPrimary(headlineid);
    }
    /**
     * desc:根据主键获取数据:HEADLINE.<br/>
     * descSql =  SELECT * FROM HEADLINE WHERE HEADLINEID = #{headlineid,jdbcType=BIGINT}
     * @param headlineid headlineid
     * @return HeadlineDO
     */
    public HeadlineDO getByPrimary(Long headlineid){
        return headlineDOMapper.getByPrimary(headlineid);
    }
    /**
     * desc:根据获取总数数据:HEADLINE.<br/>
     * descSql =  SELECT COUNT(*) FROM HEADLINE
     * @return Long
     */
    public Long getByCount(){
        return headlineDOMapper.getByCount();
    }
    /**
     * desc:根据获取分页数据:HEADLINE.<br/>
     * descSql =  SELECT * FROM HEADLINE ORDER BY HEADLINEID DESC LIMIT #{offset,jdbcType=BIGINT},#{rows,jdbcType=BIGINT}
     * @param offset offset
     * @param rows rows
     * @return List<HeadlineDO>
     */
    public List<HeadlineDO> getHeadlineList(Long offset,Long rows){
        return headlineDOMapper.getHeadlineList(offset, rows);
    }
    /**
     * desc:根据获取分页数据:HEADLINE.<br/>
     * descSql =  SELECT * FROM HEADLINE ORDER BY HEADLINEID DESC
     * @return List<HeadlineDO>
     */
    public List<HeadlineDO> getHeadAllList(){
        return headlineDOMapper.getHeadAllList();
    }
}
