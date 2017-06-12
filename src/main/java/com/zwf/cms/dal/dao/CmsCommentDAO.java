package com.zwf.cms.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zwf.cms.dal.dataobject.CmsCommentDO;
import java.util.List;
import java.lang.Long;
import com.zwf.cms.dal.mapper.CmsCommentDOMapper;

/**
* The Table CMS_COMMENT.
* CMS_COMMENT
*/
@Repository
public class CmsCommentDAO{

    @Autowired
    private CmsCommentDOMapper cmsCommentDOMapper;

    /**
     * desc:插入�?:CMS_COMMENT.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO CMS_COMMENT( IP ,NAME ,STATUS ,USERID ,CONTENT ,ARTICLEID ,COMMENTID ,CREATETIME )VALUES( #{ip,jdbcType=VARCHAR} , #{name,jdbcType=VARCHAR} , #{status,jdbcType=VARCHAR} , #{userid,jdbcType=BIGINT} , #{content,jdbcType=LONGVARCHAR} , #{articleid,jdbcType=BIGINT} , #{commentid,jdbcType=BIGINT} , #{createtime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    public Long insert(CmsCommentDO entity){
        return cmsCommentDOMapper.insert(entity);
    }
    /**
     * desc:更新�?:CMS_COMMENT.<br/>
     * descSql =  UPDATE CMS_COMMENT SET IP = #{ip,jdbcType=VARCHAR} ,NAME = #{name,jdbcType=VARCHAR} ,STATUS = #{status,jdbcType=VARCHAR} ,USERID = #{userid,jdbcType=BIGINT} ,CONTENT = #{content,jdbcType=LONGVARCHAR} ,ARTICLEID = #{articleid,jdbcType=BIGINT} ,CREATETIME = #{createtime,jdbcType=TIMESTAMP} WHERE COMMENTID = #{commentid,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(CmsCommentDO entity){
        return cmsCommentDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:CMS_COMMENT.<br/>
     * descSql =  DELETE FROM CMS_COMMENT WHERE COMMENTID = #{commentid,jdbcType=BIGINT}
     * @param commentid commentid
     * @return Long
     */
    public Long deleteByPrimary(Long commentid){
        return cmsCommentDOMapper.deleteByPrimary(commentid);
    }
    /**
     * desc:根据主键获取数据:CMS_COMMENT.<br/>
     * descSql =  SELECT * FROM CMS_COMMENT WHERE COMMENTID = #{commentid,jdbcType=BIGINT}
     * @param commentid commentid
     * @return CmsCommentDO
     */
    public CmsCommentDO getByPrimary(Long commentid){
        return cmsCommentDOMapper.getByPrimary(commentid);
    }
    /**
     * desc:根据主键获取数据:CMS_COMMENT.<br/>
     * descSql =  SELECT * FROM CMS_COMMENT WHERE ARTICLEID = #{articleid,jdbcType=BIGINT}
     * @param articleid articleid
     * @return List<CmsCommentDO>
     */
    public List<CmsCommentDO> getByArticleId(Long articleid){
        return cmsCommentDOMapper.getByArticleId(articleid);
    }
    /**
     * desc:根据主键获取数据:CMS_COMMENT.<br/>
     * descSql =  SELECT * FROM CMS_COMMENT ORDER BY CREATETIME DESC LIMIT #{offset,jdbcType=BIGINT},#{rows,jdbcType=BIGINT}
     * @param offset offset
     * @param rows rows
     * @return List<CmsCommentDO>
     */
    public List<CmsCommentDO> getByAllComment(Long offset,Long rows){
        return cmsCommentDOMapper.getByAllComment(offset, rows);
    }
    /**
     * desc:根据主键获取数据:CMS_COMMENT.<br/>
     * descSql =  SELECT count(*) FROM CMS_COMMENT
     * @return Long
     */
    public Long getAllCommentCount(){
        return cmsCommentDOMapper.getAllCommentCount();
    }
}
