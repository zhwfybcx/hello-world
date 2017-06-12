package com.zwf.cms.dal.mapper;

import com.zwf.cms.dal.dataobject.ArticleDO;
import org.apache.ibatis.annotations.Param;

/**
 * 由于�?要对分页支持,请直接使用对应的DAO�?
 * The Table ARTICLE.
 * ARTICLE
 */
public interface ArticleDOMapper{

    /**
     * desc:插入表:ARTICLE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO ARTICLE( PATH ,TITLE ,PICURL ,STATUS ,ADMINID ,CHECKIF ,CONTENT ,PICTURE ,SUMMARY ,FOLDERID ,ARTICLEID ,VIEWCOUNT ,ARTICLEURL ,CREATETIME ,UPDATETIME ,COMMENTCOUNT )VALUES( #{path,jdbcType=VARCHAR} , #{title,jdbcType=VARCHAR} , #{picurl,jdbcType=LONGVARCHAR} , #{status,jdbcType=VARCHAR} , #{adminid,jdbcType=BIGINT} , #{checkif,jdbcType=CHAR} , #{content,jdbcType=LONGVARCHAR} , #{picture,jdbcType=VARCHAR} , #{summary,jdbcType=VARCHAR} , #{folderid,jdbcType=BIGINT} , #{articleid,jdbcType=BIGINT} , #{viewcount,jdbcType=INTEGER} , #{articleurl,jdbcType=LONGVARCHAR} , now() , now() , #{commentcount,jdbcType=INTEGER} )
     * @param entity entity
     * @return Long
     */
    Long insert(ArticleDO entity);
    /**
     * desc:更新表:ARTICLE.<br/>
     * descSql =  UPDATE ARTICLE SET PATH = #{path,jdbcType=VARCHAR} ,TITLE = #{title,jdbcType=VARCHAR} ,PICURL = #{picurl,jdbcType=LONGVARCHAR} ,STATUS = #{status,jdbcType=VARCHAR} ,ADMINID = #{adminid,jdbcType=BIGINT} ,CHECKIF = #{checkif,jdbcType=CHAR} ,CONTENT = #{content,jdbcType=LONGVARCHAR} ,PICTURE = #{picture,jdbcType=VARCHAR} ,SUMMARY = #{summary,jdbcType=VARCHAR} ,FOLDERID = #{folderid,jdbcType=BIGINT} ,VIEWCOUNT = #{viewcount,jdbcType=INTEGER} ,ARTICLEURL = #{articleurl,jdbcType=LONGVARCHAR} ,UPDATETIME = now() ,COMMENTCOUNT = #{commentcount,jdbcType=INTEGER} WHERE ARTICLEID = #{articleid,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(ArticleDO entity);
    /**
     * desc:根据主键删除数据:ARTICLE.<br/>
     * descSql =  DELETE FROM ARTICLE WHERE ARTICLEID = #{articleid,jdbcType=BIGINT}
     * @param articleid articleid
     * @return Long
     */
    Long deleteByPrimary(Long articleid);
    /**
     * desc:根据主键获取数据:ARTICLE.<br/>
     * descSql =  SELECT * FROM ARTICLE WHERE ARTICLEID = #{articleid,jdbcType=BIGINT}
     * @param articleid articleid
     * @return ArticleDO
     */
    ArticleDO getByPrimary(Long articleid);
}
