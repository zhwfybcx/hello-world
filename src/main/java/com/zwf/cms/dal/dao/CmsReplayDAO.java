package com.zwf.cms.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zwf.cms.dal.dataobject.CmsReplayDO;
import java.util.List;
import com.zwf.cms.dal.mapper.CmsReplayDOMapper;

/**
* The Table CMS_REPLAY.
* CMS_REPLAY
*/
@Repository
public class CmsReplayDAO{

    @Autowired
    private CmsReplayDOMapper cmsReplayDOMapper;

    /**
     * desc:插入�?:CMS_REPLAY.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO CMS_REPLAY( IP ,NAME ,USERID ,CONTENT ,REPLYID ,COMMENTID ,CREATETIME )VALUES( #{ip,jdbcType=VARCHAR} , #{name,jdbcType=VARCHAR} , #{userid,jdbcType=BIGINT} , #{content,jdbcType=LONGVARCHAR} , #{replyid,jdbcType=BIGINT} , #{commentid,jdbcType=BIGINT} , #{createtime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    public Long insert(CmsReplayDO entity){
        return cmsReplayDOMapper.insert(entity);
    }
    /**
     * desc:更新�?:CMS_REPLAY.<br/>
     * descSql =  UPDATE CMS_REPLAY SET IP = #{ip,jdbcType=VARCHAR} ,NAME = #{name,jdbcType=VARCHAR} ,USERID = #{userid,jdbcType=BIGINT} ,CONTENT = #{content,jdbcType=LONGVARCHAR} ,COMMENTID = #{commentid,jdbcType=BIGINT} ,CREATETIME = #{createtime,jdbcType=TIMESTAMP} WHERE REPLYID = #{replyid,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(CmsReplayDO entity){
        return cmsReplayDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:CMS_REPLAY.<br/>
     * descSql =  DELETE FROM CMS_REPLAY WHERE REPLYID = #{replyid,jdbcType=BIGINT}
     * @param replyid replyid
     * @return Long
     */
    public Long deleteByPrimary(Long replyid){
        return cmsReplayDOMapper.deleteByPrimary(replyid);
    }
    /**
     * desc:根据评论id删除数据:CMS_REPLAY.<br/>
     * descSql =  DELETE FROM CMS_REPLAY WHERE COMMENTID = #{commentid,jdbcType=BIGINT}
     * @param commentid commentid
     * @return Long
     */
    public Long deleteByCommentId(Long commentid){
        return cmsReplayDOMapper.deleteByCommentId(commentid);
    }
    /**
     * desc:根据主键获取数据:CMS_REPLAY.<br/>
     * descSql =  SELECT * FROM CMS_REPLAY WHERE REPLYID = #{replyid,jdbcType=BIGINT}
     * @param replyid replyid
     * @return CmsReplayDO
     */
    public CmsReplayDO getByPrimary(Long replyid){
        return cmsReplayDOMapper.getByPrimary(replyid);
    }
    /**
     * desc:根据主键获取数据:CMS_REPLAY.<br/>
     * descSql =  SELECT * FROM CMS_REPLAY WHERE COMMENTID= #{commentid,jdbcType=BIGINT}
     * @param commentid commentid
     * @return List<CmsReplayDO>
     */
    public List<CmsReplayDO> getByCommentId(Long commentid){
        return cmsReplayDOMapper.getByCommentId(commentid);
    }
}
