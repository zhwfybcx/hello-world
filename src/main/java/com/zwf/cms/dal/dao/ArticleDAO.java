package com.zwf.cms.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zwf.cms.dal.dataobject.ArticleDO;
import com.zwf.cms.dal.mapper.ArticleDOMapper;

/**
* The Table ARTICLE.
* ARTICLE
*/
@Repository
public class ArticleDAO{

    @Autowired
    private ArticleDOMapper articleDOMapper;

    /**
     * desc:插入表:ARTICLE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO ARTICLE( PATH ,TITLE ,PICURL ,STATUS ,ADMINID ,CHECKIF ,CONTENT ,PICTURE ,SUMMARY ,FOLDERID ,ARTICLEID ,VIEWCOUNT ,ARTICLEURL ,CREATETIME ,UPDATETIME ,COMMENTCOUNT )VALUES( #{path,jdbcType=VARCHAR} , #{title,jdbcType=VARCHAR} , #{picurl,jdbcType=LONGVARCHAR} , #{status,jdbcType=VARCHAR} , #{adminid,jdbcType=BIGINT} , #{checkif,jdbcType=CHAR} , #{content,jdbcType=LONGVARCHAR} , #{picture,jdbcType=VARCHAR} , #{summary,jdbcType=VARCHAR} , #{folderid,jdbcType=BIGINT} , #{articleid,jdbcType=BIGINT} , #{viewcount,jdbcType=INTEGER} , #{articleurl,jdbcType=LONGVARCHAR} , now() , now() , #{commentcount,jdbcType=INTEGER} )
     * @param entity entity
     * @return Long
     */
    public Long insert(ArticleDO entity){
        return articleDOMapper.insert(entity);
    }
    /**
     * desc:更新表:ARTICLE.<br/>
     * descSql =  UPDATE ARTICLE SET PATH = #{path,jdbcType=VARCHAR} ,TITLE = #{title,jdbcType=VARCHAR} ,PICURL = #{picurl,jdbcType=LONGVARCHAR} ,STATUS = #{status,jdbcType=VARCHAR} ,ADMINID = #{adminid,jdbcType=BIGINT} ,CHECKIF = #{checkif,jdbcType=CHAR} ,CONTENT = #{content,jdbcType=LONGVARCHAR} ,PICTURE = #{picture,jdbcType=VARCHAR} ,SUMMARY = #{summary,jdbcType=VARCHAR} ,FOLDERID = #{folderid,jdbcType=BIGINT} ,VIEWCOUNT = #{viewcount,jdbcType=INTEGER} ,ARTICLEURL = #{articleurl,jdbcType=LONGVARCHAR} ,UPDATETIME = now() ,COMMENTCOUNT = #{commentcount,jdbcType=INTEGER} WHERE ARTICLEID = #{articleid,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(ArticleDO entity){
        return articleDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:ARTICLE.<br/>
     * descSql =  DELETE FROM ARTICLE WHERE ARTICLEID = #{articleid,jdbcType=BIGINT}
     * @param articleid articleid
     * @return Long
     */
    public Long deleteByPrimary(Long articleid){
        return articleDOMapper.deleteByPrimary(articleid);
    }
    /**
     * desc:根据主键获取数据:ARTICLE.<br/>
     * descSql =  SELECT * FROM ARTICLE WHERE ARTICLEID = #{articleid,jdbcType=BIGINT}
     * @param articleid articleid
     * @return ArticleDO
     */
    public ArticleDO getByPrimary(Long articleid){
        return articleDOMapper.getByPrimary(articleid);
    }
}
