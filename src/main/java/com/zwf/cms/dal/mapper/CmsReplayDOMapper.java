package com.zwf.cms.dal.mapper;

import com.zwf.cms.dal.dataobject.CmsReplayDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于�?要对分页支持,请直接使用对应的DAO�?
 * The Table CMS_REPLAY.
 * CMS_REPLAY
 */
public interface CmsReplayDOMapper{

    /**
     * desc:插入�?:CMS_REPLAY.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO CMS_REPLAY( IP ,NAME ,USERID ,CONTENT ,REPLYID ,COMMENTID ,CREATETIME )VALUES( #{ip,jdbcType=VARCHAR} , #{name,jdbcType=VARCHAR} , #{userid,jdbcType=BIGINT} , #{content,jdbcType=LONGVARCHAR} , #{replyid,jdbcType=BIGINT} , #{commentid,jdbcType=BIGINT} , #{createtime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    Long insert(CmsReplayDO entity);
    /**
     * desc:更新�?:CMS_REPLAY.<br/>
     * descSql =  UPDATE CMS_REPLAY SET IP = #{ip,jdbcType=VARCHAR} ,NAME = #{name,jdbcType=VARCHAR} ,USERID = #{userid,jdbcType=BIGINT} ,CONTENT = #{content,jdbcType=LONGVARCHAR} ,COMMENTID = #{commentid,jdbcType=BIGINT} ,CREATETIME = #{createtime,jdbcType=TIMESTAMP} WHERE REPLYID = #{replyid,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(CmsReplayDO entity);
    /**
     * desc:根据主键删除数据:CMS_REPLAY.<br/>
     * descSql =  DELETE FROM CMS_REPLAY WHERE REPLYID = #{replyid,jdbcType=BIGINT}
     * @param replyid replyid
     * @return Long
     */
    Long deleteByPrimary(Long replyid);
    /**
     * desc:根据评论id删除数据:CMS_REPLAY.<br/>
     * descSql =  DELETE FROM CMS_REPLAY WHERE COMMENTID = #{commentid,jdbcType=BIGINT}
     * @param commentid commentid
     * @return Long
     */
    Long deleteByCommentId(Long commentid);
    /**
     * desc:根据主键获取数据:CMS_REPLAY.<br/>
     * descSql =  SELECT * FROM CMS_REPLAY WHERE REPLYID = #{replyid,jdbcType=BIGINT}
     * @param replyid replyid
     * @return CmsReplayDO
     */
    CmsReplayDO getByPrimary(Long replyid);
    /**
     * desc:根据主键获取数据:CMS_REPLAY.<br/>
     * descSql =  SELECT * FROM CMS_REPLAY WHERE COMMENTID= #{commentid,jdbcType=BIGINT}
     * @param commentid commentid
     * @return List<CmsReplayDO>
     */
    List<CmsReplayDO> getByCommentId(Long commentid);
}
