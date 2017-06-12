package com.zwf.cms.dal.mapper;

import com.zwf.cms.dal.dataobject.CmsCommentDO;
import java.util.List;
import java.lang.Long;
import org.apache.ibatis.annotations.Param;

/**
 * 由于�?要对分页支持,请直接使用对应的DAO�?
 * The Table CMS_COMMENT.
 * CMS_COMMENT
 */
public interface CmsCommentDOMapper{

    /**
     * desc:插入�?:CMS_COMMENT.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO CMS_COMMENT( IP ,NAME ,STATUS ,USERID ,CONTENT ,ARTICLEID ,COMMENTID ,CREATETIME )VALUES( #{ip,jdbcType=VARCHAR} , #{name,jdbcType=VARCHAR} , #{status,jdbcType=VARCHAR} , #{userid,jdbcType=BIGINT} , #{content,jdbcType=LONGVARCHAR} , #{articleid,jdbcType=BIGINT} , #{commentid,jdbcType=BIGINT} , #{createtime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    Long insert(CmsCommentDO entity);
    /**
     * desc:更新�?:CMS_COMMENT.<br/>
     * descSql =  UPDATE CMS_COMMENT SET IP = #{ip,jdbcType=VARCHAR} ,NAME = #{name,jdbcType=VARCHAR} ,STATUS = #{status,jdbcType=VARCHAR} ,USERID = #{userid,jdbcType=BIGINT} ,CONTENT = #{content,jdbcType=LONGVARCHAR} ,ARTICLEID = #{articleid,jdbcType=BIGINT} ,CREATETIME = #{createtime,jdbcType=TIMESTAMP} WHERE COMMENTID = #{commentid,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(CmsCommentDO entity);
    /**
     * desc:根据主键删除数据:CMS_COMMENT.<br/>
     * descSql =  DELETE FROM CMS_COMMENT WHERE COMMENTID = #{commentid,jdbcType=BIGINT}
     * @param commentid commentid
     * @return Long
     */
    Long deleteByPrimary(Long commentid);
    /**
     * desc:根据主键获取数据:CMS_COMMENT.<br/>
     * descSql =  SELECT * FROM CMS_COMMENT WHERE COMMENTID = #{commentid,jdbcType=BIGINT}
     * @param commentid commentid
     * @return CmsCommentDO
     */
    CmsCommentDO getByPrimary(Long commentid);
    /**
     * desc:根据主键获取数据:CMS_COMMENT.<br/>
     * descSql =  SELECT * FROM CMS_COMMENT WHERE ARTICLEID = #{articleid,jdbcType=BIGINT}
     * @param articleid articleid
     * @return List<CmsCommentDO>
     */
    List<CmsCommentDO> getByArticleId(Long articleid);
    /**
     * desc:根据主键获取数据:CMS_COMMENT.<br/>
     * descSql =  SELECT * FROM CMS_COMMENT ORDER BY CREATETIME DESC LIMIT #{offset,jdbcType=BIGINT},#{rows,jdbcType=BIGINT}
     * @param offset offset
     * @param rows rows
     * @return List<CmsCommentDO>
     */
    List<CmsCommentDO> getByAllComment(@Param("offset")Long offset,@Param("rows")Long rows);
    /**
     * desc:根据主键获取数据:CMS_COMMENT.<br/>
     * descSql =  SELECT count(*) FROM CMS_COMMENT
     * @return Long
     */
    Long getAllCommentCount();
}
